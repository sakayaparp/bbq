package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class MemberProfileComposer extends GrailsComposer {

    def afterCompose = { window ->
	
		if(session['usernamem'] != null){
			
			$('window').setVisible(true)
			$('#editProfilePage').setVisible(false)
			
			def pm = Profilemember.findByUsername(session['usernamem'])
			
			$('#sUsername').text(pm.username) 
			$('#sPoint').text(pm.point)
			$('#sName').text(pm.name)
			$('#sLastname').text(pm.lastname)
			$('#sIdnumber').text(pm.idnumber)
			$('#sAddress').text(pm.address)
			$('#sAmphoe').text(pm.amphoe)
			$('#sProvince').text(pm.province)
			$('#sZipcode').text(pm.zipcode)
			$('#sEmail').text(pm.email)
			$('#sPhonenumber').text(pm.phonenumber)
			
			$('#inAddress').text(pm.address)
			$('#inAmphoe').text(pm.amphoe)
			$('#inProvince').text(pm.province)
			$('#inZipcode').text(pm.zipcode)
			$('#inEmail').text(pm.email)
			$('#inPhonenumber').text(pm.phonenumber)
			
			$('#btnEditProfile').on('click', {
				$('#editProfilePage').setVisible(true)
			})
			
			def member = Profilemember.get(pm.id)
			
			$('#btnConfirm').on('click', {
				if(
					$('#inAddress').text() != '' &&
					$('#inAmphoe').text() != '' &&
					$('#inProvince').text() != '' &&
					$('#inZipcode').text().length() == 5 && $('#inZipcode').text().isInteger() == true &&
					$('#inEmail').text() != '' &&
					$('#inPhonenumber').text().length() == 10 && $('#inPhonenumber').text().isLong() == true
				){
					member.address = $('#inAddress').text()
					member.amphoe = $('#inAmphoe').text()
					member.province = $('#inProvince').text()
					member.zipcode = $('#inZipcode').text()
					member.email = $('#inEmail').text()
					member.phonenumber = $('#inPhonenumber').text()
					member.save()
					def p = $('#editProfilePage').getParent()
					$(p).find('#sAddress').text(pm.address)
					$(p).find('#sAmphoe').text(pm.amphoe)
					$(p).find('#sProvince').text(pm.province)
					$(p).find('#sZipcode').text(pm.zipcode)
					$(p).find('#sEmail').text(pm.email)
					$(p).find('#sPhonenumber').text(pm.phonenumber)
					$('#editProfilePage').setVisible(false)
				}
				else
					alert('กรุณากรอกข้อมูลให้ถูกต้อง')
			})
			
			$('#btnCancel').on('click', {
				$('#editProfilePage').setVisible(false)
				
				$('#inAddress').text(pm.address)
				$('#inAmphoe').text(pm.amphoe)
				$('#inProvince').text(pm.province)
				$('#inZipcode').text(pm.zipcode)
				$('#inEmail').text(pm.email)
				$('#inPhonenumber').text(pm.phonenumber)
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
