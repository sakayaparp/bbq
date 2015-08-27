package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class MemberEmployeeComposer extends GrailsComposer {

    def afterCompose = { window ->
		
		if(session['username'] != null){
			$('#mEmployee').setVisible(true)
		
			def pMember = Profilemember.findAll()
			$('#setMyMember').append{
				for(p in pMember){
					listitem{
						listcell(label: p.username)
						listcell(label: p.name)
						listcell(label: p.lastname)
						listcell(label: p.idnumber)
						listcell(label: p.address)
						listcell(label: p.amphoe)
						listcell(label: p.province)
						listcell(label: p.zipcode)
						listcell(label: p.email)
						listcell(label: p.phonenumber)
						listcell(label: p.point)
					}
				}
			}
			
			$('#setUser').append{
				for(pu in pMember){
					comboitem(label: pu.username)
				}
			}
			
			$('#addPoint').on('click', {
				def c = Profilemember.findByUsername($('#setUser').text()) 
				if($('#setUser').getSelectedItem() != null && c != null){
					if($('#txtReason').text() != null && $('#txtPoint').text().isInteger() == true && Integer.parseInt($('#txtPoint').text()) > 0){
						def em = Profilemember.get(c.id)
						em.point = em.point+Integer.parseInt($('#txtPoint').text())
						em.save()
						
						def ec = Employee.get(Employee.findByUsername(session['username']).id)
						new ByAddPoint(
							employee: ec,
							profilemember: em,
							reason: $('#txtReason').text(),
							point: Integer.parseInt($('#txtPoint').text())
						).save()
						
						$('#setMyMember').getItems().clear()
						
						def pMember2 = Profilemember.findAll()
						$('#setMyMember').append{
							for(p in pMember2){
								listitem{
									listcell(label: p.username)
									listcell(label: p.name)
									listcell(label: p.lastname)
									listcell(label: p.idnumber)
									listcell(label: p.address)
									listcell(label: p.amphoe)
									listcell(label: p.province)
									listcell(label: p.zipcode)
									listcell(label: p.email)
									listcell(label: p.phonenumber)
									listcell(label: p.point)
								}
							}
						}
						alert('เพิ่ม '+$('#txtPoint').text()+' Point ให้กับ '+em.username)
					}
					else
						alert('กรอกจำนวน Point และเหตุผลให้ถูกต้อง')
				}
				else
					alert('คนที่คุณเลือกไม่ได้เป็นสมาชิก')
			})
			
			def pma = Promotion.findAll()
			$('#setMyPromotion').append{
				for(p in pma){
					def pd = Promotiondetail.findById(p.promotiondetailId)
					def pm = Profilemember.findById(p.profilememberId)
					if(p.status == "ยังไม่ส่ง"){
						listitem {
							listcell({checkbox(id: p.id)})
							listcell(label: p.id)
							listcell(label: pm.username)
							listcell(label: pd.promotionname)
							listcell(label: pd.point)
							listcell(label: p.orderdate.toString().substring(0,19))
							listcell(label: p.status)
						}
					}
				}
			}
			
			$('#setMyPromotion2').append{
				for(p in pma){
					def pd = Promotiondetail.findById(p.promotiondetailId)
					def pm = Profilemember.findById(p.profilememberId)
					if(p.status == "ส่งแล้ว"){
						listitem {
							listcell(label: p.id)
							listcell(label: pm.username)
							listcell(label: pd.promotionname)
							listcell(label: pd.point)
							listcell(label: p.orderdate.toString().substring(0,19))
							listcell(label: p.status)
						}
					}
				}
			}
			
			$('#cAll').on('click', {
				for(cb in $('#setMyPromotion > listitem > listcell > checkbox[checked=false]'))
				cb.setChecked(true)
			})
			
			$('#confirm').on('click', {
				
				for(cb in $('#setMyPromotion > listitem > listcell > checkbox[checked=true]')){
					def ep = Promotion.get(cb.getId())
					ep.status = "ส่งแล้ว"
					ep.save()
				}
				
				def pma2 = Promotion.findAll()
				$('#setMyPromotion').getItems().clear()
				$('#setMyPromotion').append{
					for(p in pma2){
						def pd = Promotiondetail.findById(p.promotiondetailId)
						def pm = Profilemember.findById(p.profilememberId)
							if(p.status == "ยังไม่ส่ง"){
							listitem {
								listcell({checkbox(id: p.id)})
								listcell(label: p.id)
								listcell(label: pm.username)
								listcell(label: pd.promotionname)
								listcell(label: pd.point)
								listcell(label: p.orderdate.toString().substring(0,19))
								listcell(label: p.status)
							}
						}
					}
				}
				
				$('#setMyPromotion2').getItems().clear()
				$('#setMyPromotion2').append{
					for(p in pma2){
						def pd = Promotiondetail.findById(p.promotiondetailId)
						def pm = Profilemember.findById(p.profilememberId)
							if(p.status == "ส่งแล้ว"){
							listitem {
								listcell(label: p.id)
								listcell(label: pm.username)
								listcell(label: pd.promotionname)
								listcell(label: pd.point)
								listcell(label: p.orderdate.toString().substring(0,19))
								listcell(label: p.status)
							}
						}
					}
				}
			})
			
			$('#logout').on('click', {
				session['username'] = null
				Executions.sendRedirect("/loginWarehouse.zul")
			})
		}else{
			Executions.sendRedirect("/loginWarehouse.zul")
		}
    }
}
