package barbq
import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class LoginWarehouseComposer extends GrailsComposer {

    def afterCompose = { window ->
        $('#btnlogin').on('click',{
			def a = Employee.findByUsername($('#txtAddUsername').text())
			
			if($('#txtAddUsername')[0].text=='' || $('#txtAddPassword')[0].text==''){
				alert('กรอกข้อมูลใหม่')
			}else if(a != null){
				if($('#txtAddPassword').text()==a.password){
					session['username']=a.username

					if(a.depart=='พนักงานคลังสินค้า'){
						Executions.sendRedirect("/indexWarehouse.zul")
					}else if(a.depart=='พนักงานสั่งอาหาร'){
						Executions.sendRedirect("/menu.zul")
					}else if(a.depart=='พนักงานชำระเงิน'){
						Executions.sendRedirect("/payment.zul")
					}else if(a.depart=='พนักงานจองโต๊ะ'){
						Executions.sendRedirect("/reserve.zul")
					}else if(a.depart=='พนักงานดูแลระบบสมาชิก'){
						Executions.sendRedirect("/memberEmployee.zul")
					}
					else{
						alert('ท่านไม่มีตำแหน่ง')
					}
				}
				else{
					alert('รหัสผ่านผิด')
				}
			}else{
				alert('ข้อมูลไม่ถูกต้อง')
			}
			
		})
    }
}
