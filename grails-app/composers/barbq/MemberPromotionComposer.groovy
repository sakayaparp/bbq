package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class MemberPromotionComposer extends GrailsComposer {

    def afterCompose = { window ->
		
		if(session['usernamem'] != null){
			$('#mPromotion').setVisible(true)
		
			def pm = Profilemember.findByUsername(session['usernamem'])
			def pma = Promotion.findAll()
			
			$('#setMyPromotion').append{
				for(p in pma){
					def pd = Promotiondetail.findById(p.promotiondetailId)
					if(pm.id == p.profilememberId && p.status == 'ยังไม่ส่ง'){
						listitem {
							listcell(label: pd.promotionname)
							listcell(label: pd.point)
							listcell(label: p.orderdate.toString().substring(0,19))
							listcell(label: 'ยังไม่ได้รับ')
						}
					}else if(pm.id == p.profilememberId){
						listitem {
							listcell(label: pd.promotionname)
							listcell(label: pd.point)
							listcell(label: p.orderdate.toString().substring(0,19))
							listcell(label: 'ได้รับแล้ว')
						}		
					}
				}
			}
			
			$('#viewPromotion1').on('Click', {
				$('#setMyPromotion').getItems().clear()
				$('#setMyPromotion').append{
					for(p in pma){
						def pd = Promotiondetail.findById(p.promotiondetailId)
						if(pm.id == p.profilememberId && p.status == 'ยังไม่ส่ง'){
							listitem {
								listcell(label: pd.promotionname)
								listcell(label: pd.point)
								listcell(label: p.orderdate.toString().substring(0,19))
								listcell(label: 'ยังไม่ได้รับ')
							}
						}
					}
				}
			})
			
			$('#viewPromotion2').on('Click', {
				$('#setMyPromotion').getItems().clear()
				$('#setMyPromotion').append{
					for(p in pma){
						def pd = Promotiondetail.findById(p.promotiondetailId)
						if(pm.id == p.profilememberId && p.status == 'ส่งแล้ว'){
							listitem {
								listcell(label: pd.promotionname)
								listcell(label: pd.point)
								listcell(label: p.orderdate.toString().substring(0,19))
								listcell(label: 'ได้รับแล้ว')
							}
						}
					}
				}
			})
			
			$('#viewPromotion3').on('Click', {
				$('#setMyPromotion').getItems().clear()
				$('#setMyPromotion').append{
					for(p in pma){
						def pd = Promotiondetail.findById(p.promotiondetailId)
						if(pm.id == p.profilememberId && p.status == 'ยังไม่ส่ง'){
							listitem {
								listcell(label: pd.promotionname)
								listcell(label: pd.point)
								listcell(label: p.orderdate.toString().substring(0,19))
								listcell(label: 'ยังไม่ได้รับ')
							}
						}else if(pm.id == p.profilememberId){
							listitem {
								listcell(label: pd.promotionname)
								listcell(label: pd.point)
								listcell(label: p.orderdate.toString().substring(0,19))
								listcell(label: 'ได้รับแล้ว')
							}
						}
					}
				}
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
