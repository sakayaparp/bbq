package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zul.Messagebox
import org.zkoss.zk.ui.event.EventListener
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.Messagebox.Button
import org.zkoss.zk.ui.Executions

class SavemoneyComposer extends GrailsComposer {


def update(){
		$('#box').getItems().clear()
	    def pulldata = Savemoney.findAll()  
		$('#box').append{ 
			for(ls in pulldata){ 
				listitem{
					listcell(label: ls.name)
					listcell(label: ls.date)
					listcell(label: ls.number)
					listcell(label: ls.price)
					listcell({button(label: "ลบ",id: ls.id)})
				}	
			}
		}
//=========================================================================================================
//button delete
		$('#box > listitem > listcell > button[label="ลบ"]').on('click',{
			def a = Savemoney.findById(it.target.id)
				a.delete(flush:true)
				alert("ลบข้อมูลสำเร็จ")
				//Executions.sendRedirect("/savemoney.zul")
				update();
				})
//=========================================================================================================
	} 

    def afterCompose = { window ->
        // initialize components here

//=========================================================================================================
//pull data
		update();
//=========================================================================================================
//button pull
		$('#pull').on('click',{
					$('#box').getItems().clear()
					update();
					})
//button clear
		$('#clear').on('click',{
			$('#box').getItems().clear()
			})
//=========================================================================================================
//button add data
		$('#ok').on('click',{
					if($('#name').getText() == "" || $('#in').getText() == "" || $('#number').getText() == "" || $('#price').getText() == ""){
		                        	alert("คุณกรอกข้อมูลไม่ครบถ้วน")

	}else {		Messagebox.show("คุณแน่ใจหรือไม่ที่จะทำการยืนยัน", null,
   Messagebox.YES+Messagebox.NO, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onYes")) {
							def a = new Savemoney(
								name: $('#name').getText(),
								date: $('#in').getText(),
								number: $('#number').getText(),
								price: $('#price').getText()
								)
							a.save()
							update();
                			alert("บันทึกข้อมูลเรียบร้อย")
                			$('#name').setText()
							$('#in').setText()
							$('#number').setText()
							$('#price').setText()
							
                        } else {
                            alert("ไม่ทำการบันทึก !");
                            $('#name').setText()
							$('#in').setText()
							$('#number').setText()
							$('#price').setText()
                        }
                    }}
                    )
				}
    		})

//=========================================================================================================
//button search
		$('#search').on('click',{
			//alert($('#in_search').getText())
			$('#box').getItems().clear()
			def eiei = Savemoney.findAllByDate($('#in_search').getText())
									$('#box').append{
									for(ls4 in eiei){
											listitem{
												listcell(label: ls4.name)
												listcell(label: ls4.date)
												listcell(label: ls4.number)
												listcell(label: ls4.price)
												listcell({button(label: "ลบ",id: ls4.id)})
										}
									}
								}
				$('#in_search').setText()
			})
//=========================================================================================================


    }
	
}
