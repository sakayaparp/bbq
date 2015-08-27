package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class IndexStatusComposer extends GrailsComposer {

   def afterCompose = { window ->
		
		def pm = Profilemember.count()
		$('#sumCustomer').val(pm+" คน")
		
		def pd = Employee.count()
		$('#sumEmployee').val(pd+" คน")
		
		def wh = Warehouse.count()
		$('#sumWarehouse').val(wh+" รายการ")
	
	
        $('#btnselect').on('click',{
			def selectVar = $('#cbBoxSelect').text()
			if(selectVar=="ระบบโปรโมชั่น"){
				$('#WindowsPromotion > #lsBoxPromotion').getItems().clear()
				$('#WindowsPromotion').setVisible(true)
				def promotion = Promotiondetail.findAll()
				$('#WindowsPromotion > #lsBoxPromotion').append{
					for(ls in promotion){
						listitem(value: ls.promotionname){
							listcell(label: ls.promotionname)
							listcell(label: ls.detail)
							listcell(label: ls.point)
						}
					}
				}
				
			}else if(selectVar=="ระบบพนักงาน"){
			
				$('#WindowsEmployee > #lsBoxEmployee').getItems().clear()
				$('#WindowsEmployee').setVisible(true)
				def emp = Employee.findAll()
				$('#WindowsEmployee > #lsBoxEmployee').append{
					for(ls in emp){
						listitem(value: ls.name){
							listcell(label: ls.name)
							listcell(label: ls.surname)
							listcell(label: ls.sex)
							listcell(label: ls.address)
							listcell(label: ls.aum)
							listcell(label: ls.province)
							listcell(label: ls.zipcode)
							listcell(label: ls.depart)
							listcell(label: ls.selary)
						}
					}
				}
			}else if(selectVar=="ระบบเข้าออกงานของพนักงาน"){
			
				def k = Checkin.count()
				if(k==0){
					alert('ยังไม่มีพนักงานเข้างาน')
				}
				
				$('#WindowsCheckin > #lsBoxCheckin').getItems().clear()
				$('#WindowsCheckin').setVisible(true)
				def check = Checkin.findAll()
				$('#WindowsCheckin > #lsBoxCheckin').append{
					for(ls in check){
						listitem(value: ls.name){
							listcell(label: ls.name)
							listcell(label: ls.date)
						}
					}
				}
				
			}else if(selectVar=="ระบบสมาชิก"){
			
				$('#WindowsMember > #lsBoxMember').getItems().clear()
				$('#WindowsMember').setVisible(true)
				def member = Profilemember.findAll()
				$('#WindowsMember > #lsBoxMember').append{
					for(ls in member){
						listitem(value: ls.name){
							listcell(label: ls.name)
							listcell(label: ls.lastname)
							listcell(label: ls.idnumber)
							listcell(label: ls.address)
							listcell(label: ls.amphoe)
							listcell(label: ls.province)
							listcell(label: ls.zipcode)
							listcell(label: ls.email)
							listcell(label: ls.phonenumber)
						}
					}
				}
				
			}else if(selectVar=="ระบบบันทึกค่าใช้จ่ายประจำวัน"){
				$('#WindowsSavemoney > #lsBoxSavemoney').getItems().clear()
				$('#WindowsSavemoney').setVisible(true)
				def sm = Savemoney.findAll()
				$('#WindowsSavemoney > #lsBoxSavemoney').append{
					for(ls in sm){
						listitem(value: ls.name){
							listcell(label: ls.name)
							listcell(label: ls.date)
							listcell(label: ls.number)
							listcell(label: ls.price)
						}
					}
				}
			}else if(selectVar=="ระบบคลังสินค้า"){
				$('#WindowsWarehouse > #lsBoxWarehouse').getItems().clear()
				$('#WindowsWarehouse').setVisible(true)
				def foodDB = Warehouse.findAll()
				$('#WindowsWarehouse > #lsBoxWarehouse').append{
					for(ls in foodDB){
						listitem(value: ls.product_name){
							listcell(label: ls.product_name)
							listcell(label: ls.editDate)
							listcell(label: ls.date_expire)
							listcell(label: ls.amount)
							listcell(label: ls.buy_by)
							listcell(label: ls.price)
							listcell(label: ls.details)
						}
					}
				}
			}else{
				alert('กรอก')
			}
		})
		
		$('#btnCancelWarehouse').on('click',{
			$('#WindowsWarehouse').setVisible(false)
		})
		$('#btnCancelEmployee').on('click',{
			$('#WindowsEmployee').setVisible(false)
		})
		$('#btnCancelMember').on('click',{
			$('#WindowsMember').setVisible(false)
		})
		$('#btnCancelPromotion').on('click',{
			$('#WindowsPromotion').setVisible(false)
		})
		$('#btnCancelSavemoney').on('click',{
			$('#WindowsSavemoney').setVisible(false)
		})
		$('#btnCancelCheckin').on('click',{
			$('#WindowsCheckin').setVisible(false)
		})
    }
}
