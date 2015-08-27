package barbq

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.event.EventListener
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions
import org.zkoss.zul.Messagebox
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.Messagebox.Button

class PromotionComposer extends GrailsComposer {

    def afterCompose = { window ->
	
		if(session['usernamem'] != null){
			$('#winpro').setVisible(true)
        	$('#btnp1').on('click',{
				alert(Promotiondetail.findById(1).detail)
			})
				
			$('#btnp2').on('click',{
				alert(Promotiondetail.findById(2).detail)
			})
				
			$('#btnp3').on('click',{
				alert(Promotiondetail.findById(3).detail)
			})
				
			$('#btnp4').on('click',{
				alert(Promotiondetail.findById(4).detail)
			})
				
			$('#btnp5').on('click',{
				alert(Promotiondetail.findById(5).detail)
			})

			$('#p1').text(Profilemember.findByUsername(session['usernamem']).username)
			$('#p2').text(Profilemember.findByUsername(session['usernamem']).point)
			
			$('#btncon').on('click',{
				Messagebox.show("คุณแน่ใจหรือไม่ที่จะทำการยืนยัน", null,
   Messagebox.YES+Messagebox.NO, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
                    public void onEvent(Event evt) throws InterruptedException {
					 if (evt.getName().equals("onYes")) {
						if($("radio[checked=true]")){
						def h = Profilemember.get(Profilemember.findByUsername(session['usernamem']).id)
						def d = Promotiondetail.findByPromotionname($('radio[checked=true]').text()).point
						def c = Profilemember.findByUsername(session['usernamem']).point
								if(c >= d){
									h.point = c-d
									h.save()
									def t2 = new Promotiondetail()
									def t3 = new Profilemember()
									def t1 = new Promotion(
										profilemember: t3.get(Profilemember.findByUsername(session['usernamem']).id),
										promotiondetail: t2.get(Promotiondetail.findByPromotionname($('radio[checked=true]').text()).id),
										status: 'ยังไม่ส่ง'
									)
									t1.save()	
									$('#p2').text(Profilemember.findByUsername(session['usernamem']).point)	
								}
								else{
									alert('แต้มคุณไม่พอ')
								}
						}
						else{
							alert('กรุณาเลือกโปรโมชั่น')
							}
					} else {
                            alert("คุณไม่ได้ทำการเลือกโปรโมชั่น");
                       }
			
			}})
			})

			$('#logout').on('click', {
				session['usernamem'] = null
				Executions.sendRedirect("/index.zul")
			})
			
		}else{
			Executions.sendRedirect("/index.zul")
		}
		
		
		
    }
}
