package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class CheckinComposer extends GrailsComposer {

    def afterCompose = { window ->



      $('#check0').on('click',{
          Executions.sendRedirect("/index.zul")
        })
      $('#check1').on('click',{
          Executions.sendRedirect("/indexEmplo.zul")
        })
      $('#check3').on('click',{

      	 $('#listshow').getItems().clear()
 		 def show = Employee.findAll()
          
            $('#listshow').append{ 
              for(ls in show){  
                listitem{

                  String a = ls.name
                  String b = "  "+ls.surname
                  String c = "นาย"+a+b

                  listcell(label: c)   
                  listcell(label: ls.sex)  
                  listcell(label: ls.status)  
                
                }
              }
            } 
      	})
      $('#check5').on('click',{

        if($('#username').getText()==''||
              $('#password').getText()==''){
          alert("กรุณากรอก Username กับ password ให้ครบ")
        }
        else{

                  def ch = $('#username')[0].text
                  def hh = Employee.findByUsername(ch)
                  def ps = $('#password')[0].text
                        if(hh.password == ps){
                              $('#listshow').getItems().clear()
                              def    a    =  new Date().toString().substring(0,19)
                              String gg   =  hh.name+" "+hh.surname
                              def    news =  new Checkin(
                                  name: gg,
                                  date:a )
                              news.save()
                        $('#username')[0].text = ''
                        $('#password')[0].text = ''
                         alert("คุณ"+gg+" ได้ลงชื่อเข้างานแล้วเวลา"+" "+a)



                           $('#emName').val(" "+hh.name)
                           $('#emsurName').val(" "+hh.surname)
                           $('#emSex').val(" "+hh.sex)
                           $('#emDepart').val(" "+hh.depart)
                           $('#emDate').val(" "+new Date().toString().substring(0,19))

                         

                        hh.status = "พนักงานลงชื่อเข้าทำงานแล้วเวลา:"+new Date().toString().substring(0,19)
                              
                               }
                        else{
                          alert("Username อาจไม่ตรรงกับ password กรุณากรอกใหม่")
                            }   
            }
        })

      
    }

}
