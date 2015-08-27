package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class PaymentComposer extends GrailsComposer {

    def afterCompose = { window ->
		
       	
        	$('#btn').on('click',{
				def c =	Fooddetail.findByTable($('#txt1').text())
				if($('#txt1').text() != '' && c != null){
					if($('#txt1').text() == c.table){
						$('#main2 > #box1').getItems().clear()
						def c1 =Fooddetail.findAllByTable($('#txt1').text())
						$('#main2 > #box1').append {
							for(ls in c1){
								listitem {
									listcell(label: ls.table)
									listcell(label: ls.foodname)
									listcell(label: ls.amount)
									listcell(label: ls.price)
									listcell(label: ls.status)			
								}			       
							}
						}
				
					}else
					alert('กรุณากรอกหมายเลขโต๊ะ')
				}else
					alert('กรุณากรอกหมายเลขโต๊ะใหม่')
		
    		})
			 	$('#cancel').on('click',{
			$('#main2 > #box1').getItems().clear()
    		})
			
			
			
			
			  $('#btncon').on('click', {
				def c =	Fooddetail.findByTable($('#txt1').text())
			  if($('#txt1').text() != '' && c != null){
				if($('#txt1').text() == c.table){
						def pay1 = Fooddetail.findByTable($('#txt1').text())
						$('#pay').find('#payment2').text(''+(pay1.price*pay1.amount))
						$('#pay').setVisible(true)
					}
				else
					alert('กรุณากรอกหมายเลขโต๊ะ')
				}else
					alert('กรุณากรอกหมายเลขโต๊ะใหม่')
				})
			$('#cancel2').on('click', {
				$('#pay').setVisible(false)
			})
		
			$('#btnclear').on('click', {
				$('#payment1').text('')
				$('#payment2').text('')
				$('#payment3').text('')
			})
		
			  $('#btnok').on('click', {
							def c = $('#pay').getParent()
							def pay1 = Fooddetail.findByTable($(c).find('#txt1').text())
							if($('#payment1').text().isNumber() == true){
							
								if($('#payment1').text() != '' && Double.parseDouble($('#payment1').text()) >= pay1.price){
									def priceall = pay1.price
									def d = Double.parseDouble($('#payment1').text())
									$('#payment3').text(""+(d-priceall*pay1.amount))
									
								def t1 = new Payment(
									price : Fooddetail.findByTable($(c).find('#txt1').text()).price,
									status : 'จ่ายแล้ว' , 
									table : Fooddetail.findByTable($(c).find('#txt1').text()).table
								)
								t1.save()
							
										
									
								}
								else
									alert('กรุณากรอกจำนวนเงินใหม่')		
							}
							else
								alert('กรุณากรอกจำนวนเงินใหม่')			
			})
			
			
			
			
    }
}
