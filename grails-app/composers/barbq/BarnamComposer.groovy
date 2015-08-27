package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zul.Messagebox
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.event.EventListener
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.Messagebox.Button

class BarnamComposer extends GrailsComposer {

    def afterCompose = { window ->

      
        
        $('#btnlogout').on('click',{
            Executions.sendRedirect("/loginWarehouse.zul")
        })

      def a = Barnam.findAll()  
        $('#game > #eiei').append{ 
           for(data in a){ 
                listitem{
                    listcell(label: data.menu)
                    listcell(label: data.amount)
                    listcell(label: data.balance)
                    listcell(label: data.time) 
                    listcell(label: data.detail)
                }   
            }
        }


/*        $('#btnAddTask').on('click',{
        	if($('#txtAddFoodName')[0].text=='' || $('#txtAddNumber')[0].text==''){

        		alert('คุณยังกรอกข้อมูลไม่ครบกรุณากรอกข้อมูลให้ครบด้วยครับ/ค่ะ')

        	}else{

        		alert('ได้ทำการบันทึกข้อมูลเรียบร้อยครับ/ค่ะ')

        	}
 			
        })

*/

//==================================================================================

        $('#btnEdit').on('click',{
    
            if($('#cdBox').getSelectedItem()==null){
                alert('กรุณาเลือกรายการด้วยครับ/ค่ะ')
            
          }else{
                    def lob = Barnam.findByMenu($('#cdBox').text()) //ค้นหาจากฐานข้อมูลที่มีชื่อตามรายการที่เลือก
                    lob.delete() //ลบรายการออกจากฐานข้อมูล
                    
                    alert('ลบรายการเรียบร้อยแล้วครับ/ค่ะ')  

                    Executions.sendRedirect("/Barnam.zul") 
               
            }
            
        })


//============================================================================

        def a2 = Barnam.findAll()
        $('#cdBox').append{   //cb เหมือนกับ ls ใช้ดึงข้อมูลใน loop combobox
            for(cb in a2){
                comboitem(label: cb.menu)
            }
            
        }

        $('#btnAddTask').on('click',{

            if($('#txtAddFoodName')[0].text=='' || $('#txtAddNumber')[0].text=='' || $('#txtAddNumbers')[0].text==''){

                alert('คุณยังกรอกข้อมูลไม่ครบกรุณากรอกข้อมูลให้ครบด้วยครับ/ค่ะ')

                }else {    
                Messagebox.show("คุณแน่ใจหรือไม่ที่จะทำการยืนยัน", null,
                Messagebox.YES+Messagebox.NO, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onYes")) {

                            def  tt = new Date().toString().substring(0,19)
                            def aum = new Barnam(
                                menu: $('#txtAddFoodName').text(),
                                amount: $('#txtAddNumber').text(),
                                balance: $('#txtAddNumbers').text(),
                                time: tt,
                                detail: $('#txtAddDetails').text()
                                )
                            aum.save()
                        
                            $('#game > #eiei').getItems().clear()   

                                def b = Barnam.findAll()  
                                 for(ls in b){  
                                    $('#eiei').append{ 
                                            listitem{
                                                listcell(label: ls.menu)
                                                listcell(label: ls.amount)
                                                listcell(label: ls.balance)
                                                listcell(label: tt) 
                                                listcell(label: ls.detail)
                                            }  
                                        }
                                    }
                alert('ได้ทำการบันทึกข้อมูลเรียบร้อยครับ/ค่ะ')

                Executions.sendRedirect("/Barnam.zul")
                        }

            }
                                               
        })
    }})

//=====================================================================

//=====================================================================

/*

        def axe = Barnam.findAll()
        $('#cdBoxer').append{   //cb เหมือนกับ ls ใช้ดึงข้อมูลใน loop combobox
            for(kalum in axe){
                comboitem(label: kalum.menu)
            }
            
        }

/*
        $('#btnOk').on('click',{
    
            if($('#cdBoxer').getSelectedItem()==null){
                alert('กรุณาเลือกรายการ')
            
          }else{
                    def lob = Barnam.findByMenu($('#cdBoxer').text()) //ค้นหาจากฐานข้อมูลที่มีชื่อตามรายการที่เลือก
                    lob.delete() //ลบรายการออกจากฐานข้อมูล
                    
                    alert('ลบรายการสำเร็จ')  

                    Executions.sendRedirect("/Barnam.zul") 
               
            }
            
        })

     

        $('#btnOk').on('click',{
    
            if($('#cdBoxer').getSelectedItem()==null){
                alert('เลือกรายการ')
            }else{

                def update = Barnam.get(Barnam.findByMenu($('#cbBoxer').text()).id)
                if($('#Num').text() != '' && Integer.parseInt($('#Num').text()) <= Barnam.findByMenu($('#cbBoxer').text()).balance){
                    update.balance = Barnam.findByMenu($('#cbBoxer').text()).balance-Integer.parseInt($('#Num').text())
                    update.save()

                def foodDecrease = new Barnam()
                    new Adjustment(
                        warehouse: foodDecrease.get(Barnam.findByMenu($('#cbBoxer').text()).id), //บรรทัดนี้ลบได้
                        type: "Decrease"
                    ).save()

                    
                    $('#game > #eiei').getItems().clear()
                    def updateListDecreaseNumber = Barnam.findAll()
                    $('#game > #eiei').append{
                        for(sad in zx){  
                         $('#eiei').append{ 
                                listitem{
                                    listcell(label: sad.menu)
                                    listcell(label: sad.amount)
                                    listcell(label: sad.balance)
                                    listcell(label: tt) 
                                    listcell(label: sad.detail)
                                }  
                            }
                        }
                    }
                    
                    alert('ลดแล้ว')
                }
                else
                    alert('กรอกจำนวน')
            }
        })
*/

    }
}