package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class IndexComposer extends GrailsComposer {

    def afterCompose = { window ->
		$('#btnLogin').on('click', {
			def c = Profilemember.findByUsername($('#txtUser').text()) 
			if($('#txtUser').text() == '' || $('#txtPass').text() == '')
				alert('กรุณากรอก Username และ Password')
			else if(c != null){
				if($('#txtPass').text() == c.password){
					session['usernamem'] = c.username
					Executions.sendRedirect("/memberProfile.zul")
				}
				else
					alert('คุณกรอก Username หรือ Password ผิด กรุณากรอกใหม่')
			}
			else
				alert('คุณกรอก Username หรือ Password ผิด กรุณากรอกใหม่')
		})
	
        $('#btnRegister').on('click', {
			$('#registerPage').setVisible(true)
		})
		
		$('#btnCancel').on('click', {
			$('#registerPage').setVisible(false)
			$('#inID').text('')
			$('#inPassword').text('')
			$('#inPasswordc').text('')
			$('#inName').text('')
			$('#inLastname').text('')
			$('#inIdentify').text('')
			$('#inAddress').text('')
			$('#inAmphoe').text('')
			$('#inProvince').text('')
			$('#inZipCode').text('')
			$('#inEmail').text('')
			$('#inPhone').text('')
		})
		
		$('#btnConfirm').on('click', {
			def u = Profilemember.findByUsername($('#inID').text()) 
			if(
				$('#inID').text() == '' ||
				$('#inPassword').text() == '' ||
				$('#inName').text() == '' ||
				$('#inLastname').text() == '' ||
				$('#inIdentify').text() == '' ||
				$('#inAddress').text() == '' ||
				$('#inAmphoe').text() == '' ||
				$('#inProvince').text() == '' ||
				$('#inZipCode').text() == '' ||
				$('#inEmail').text() == '' ||
				$('#inPhone').text() == ''
			)
				alert('คุณกรอกข้อมูลไม่ครบ.. กรุณากรอกข้อมูลให้ครบทุกช่อง')
			else if(u != null){
				if($('#inID').text() == u.username){
					alert('Username นี้มีผู้ใช้แล้ว กรุณาเปลี่ยนใหม่!!')
				}
			}
			else if($('#inIdentify').text().length() == 13 && $('#inIdentify').text().isNumber() == true &&
			$('#inPhone').text().length() == 10 && $('#inPhone').text().isLong() == true &&
			$('#inZipCode').text().length() == 5 && $('#inZipCode').text().isInteger() == true){
				if($('#inPassword').text() == $('#inPasswordc').text()){
					new Profilemember(
						username: $('#inID').text(), 
						password: $('#inPassword').text(), 
						name: $('#inName').text(),
						lastname: $('#inLastname').text(),
						idnumber: $('#inIdentify').text(),
						address: $('#inAddress').text(),
						amphoe: $('#inAmphoe').text(),
						province: $('#inProvince').text(),
						zipcode: $('#inZipCode').text(),
						email: $('#inEmail').text(),
						phonenumber: $('#inPhone').text()
					).save()
					$('#inID').text('')
					$('#inPassword').text('')
					$('#inPasswordc').text('')
					$('#inName').text('')
					$('#inLastname').text('')
					$('#inIdentify').text('')
					$('#inAddress').text('')
					$('#inAmphoe').text('')
					$('#inProvince').text('')
					$('#inZipCode').text('')
					$('#inEmail').text('')
					$('#inPhone').text('')
					alert('คุณสมัครสมาชิกเรียบร้อยแล้ว!! สามารถเข้าสู่ระบบสมาชิกได้ทันที...')
					$('#registerPage').setVisible(false)
				}
				else
					alert('คุณกรอกรหัสยืนยันผิด กรุณากรอกใหม่...')
			}
			else
				alert('คุณกรอกรหัสบัตรประชาชน, รหัสไปรษณีย์ หรือเบอร์โทรศัพท์ ผิด กรุณากรอกใหม่..')
		})
    }
}
