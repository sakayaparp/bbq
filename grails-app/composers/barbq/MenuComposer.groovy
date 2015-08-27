package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zul.Messagebox
import org.zkoss.zk.ui.event.EventListener
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.Messagebox.Button

class MenuComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here

        //============================================================================================================================
        $('#ok').on('click',{

             Messagebox.show("คุณแน่ใจหรือไม่ที่จะทำการยืนยัน", null,
   Messagebox.YES+Messagebox.NO, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onYes")) {
                            $('#confirm').setVisible(true)
                            if($('#count1').text() > '0' || $('#count2').text() > '0' || $('#count3').text() > '0' || $('#count4').text() > '0'){

                                                if($('#count1').text() >'0'){
                                                def a = $('#table1').text()
                                                def b = $('#count1').text()
                                     
                                                $('#confirm > #box2').append{
                                                    listitem{
                                                        listcell(label: 'ชุดอิ่มอร่อย')
                                                        listcell(label: '999')
                                                        listcell(label: a)
                                                        listcell(label: b)
                                                        listcell(label: 'ลบรายการ')
                                                        }       
                                                    }
                                                    def s1 = new Fooddetail(
                                                            table: a ,
                                                            foodname: 'ชุดอิ่มอร่อย',
                                                            price: '999',
                                                            amount: b,
                                                            status: 'รอชำระเงิน'
                                                            )
                                                            s1.save() 
                                                }
                                                if($('#count2').text() > '0'){
                                                    def c = $('#table2').text()
                                                    def d = $('#count2').text()
                                                 $('#confirm > #box2').append{
                                                    listitem{
                                                        listcell(label: 'ชุดพอเพียง')
                                                        listcell(label: '599')
                                                        listcell(label: c)
                                                        listcell(label: d)
                                                        listcell(label: 'ลบรายการ')
                                                        }   
                                                    }
                                                    def s2 = new Fooddetail(
                                                            table: c ,
                                                            foodname: 'ชุดพอเพียง',
                                                            price: '599',
                                                            amount: d,
                                                            status: 'รอชำระเงิน'
                                                            )
                                                            s2.save() 
                                                }
                                                if($('#count3').text() > '0'){
                                                    def e = $('#table3').text()
                                                    def f = $('#count3').text()
                                                 $('#confirm > #box2').append{
                                                    listitem{
                                                        listcell(label: 'ชุดเพื่อสุขภาพ')
                                                        listcell(label: '799')
                                                        listcell(label: e)
                                                        listcell(label: f)
                                                        listcell(label: 'ลบรายการ')
                                                        }   
                                                    }
                                                    def s3 = new Fooddetail(
                                                            table: e ,
                                                            foodname: 'ชุดเพื่อสุขภาพ',
                                                            price: '799',
                                                            amount: f,
                                                            status: 'รอชำระเงิน'
                                                            )
                                                            s3.save() 
                                                }
                                                if($('#count4').text() > '0'){
                                                    def g = $('#table4').text()
                                                    def h = $('#count4').text()
                                                 $('#confirm > #box2').append{
                                                    listitem{
                                                        listcell(label: 'ชุดเนื้อสุดอลังการ')
                                                        listcell(label: '599')
                                                        listcell(label: g)
                                                        listcell(label: h)
                                                        listcell(label: 'ลบรายการ')
                                                        }   
                                                    }
                                                    def s4 = new Fooddetail(
                                                            table: g ,
                                                            foodname: 'ชุดเนื้อสุดอลังการ',
                                                            price: '599',
                                                            amount: h,
                                                            status: 'รอชำระเงิน'
                                                            )
                                                            s4.save() 
                                                }
                             }
                        } else {
                            alert("ไม่ทำการบันทึก !");
                        }
                    }})
           
    		})

//====================================================================================================================

    	$('#cancel').on('click',{

    		$('#confirm').setVisible(false)
    		$('#confirm > #box2').getItems().clear()
       

    		})   
//=====================================================================================================================
    }
}
