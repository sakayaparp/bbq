package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class IndexEmploComposer extends GrailsComposer {

    def afterCompose = { window ->
      $('#sbtnlogin').on('click',{
      	if($('#txtUser').getText()=="admin" && $('#txtPass').getText()=="1234" ){
      		Executions.sendRedirect("/indexemployee.zul")
      	}
      	else{

      		alert("username หรือ password ผิด")
      	}
      })
    }
}
