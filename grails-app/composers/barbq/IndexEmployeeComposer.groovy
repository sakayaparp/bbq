package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class IndexEmployeeComposer extends GrailsComposer {

    def afterCompose = { window ->


           $('#lb').on('click',{
            Executions.sendRedirect("/indexStatus.zul")
            })
          $('#btnOut').on('click',{
            Executions.sendRedirect("/indexEmplo.zul")
            })

          $('#update').on('click',{

            if($('#depart2').getSelectedItem()==null){
                  alert("กรุณาเลือกชื่อพนักงานที่ต้องการแก้ไsaveขก่อน")
            }
            else{
            def ch = $('#listEdit').text()
            def chang = Employee.findByName(ch)
            
            chang.depart=$('#depart2').text()
            chang.selary=$('#textbox2').text()
            chang.username=$('#textbox3').text()
            chang.password=$('#textbox4').text()
            chang.save()
            alert("แก้ไขข้อมูลเรียบ")

            $('#listshow').getItems().clear()

            def show2 = Employee.findAll()
          
            $('#listshow').append{ 
              for(ls in show2){  
                listitem{
                  String a = ls.name
                  String b = "  "+ls.surname
                  String c = a+b
                  listcell(label: c)
                  listcell(label: ls.sex)
                  listcell(label: ls.depart)
                  listcell(label: ls.selary+' บาท')                 
                }
              }
            } 

              def tck3 = $('#listEdit').text()
              def new3 = Employee.findByName(tck3)
                   $('#sdepart').val(new3.depart)
                   $('#ssalary').val(new3.selary)
                   $('#susername').val(new3.username)
                   $('#spass').val(new3.password)


                  $('#depart2').setSelectedItem(null)
                  $('#textbox2')[0].text = ''
                  $('#textbox3')[0].text = ''
                  $('#textbox4')[0].text = ''


                }

          })

          $('#submitEdit').on('click',{
              if($('#listEdit').getSelectedItem()==null){
                  alert("กรุณาเลือกชื่อพนักงานที่ต้องการแก้ไขก่อน")
               }
               else{
              def tck2 = $('#listEdit').text()
              def new2 = Employee.findByName(tck2)
              $('#sname').val(new2.name+" "+new2.surname)
              $('#ssex').val(new2.sex)
              $('#saddress').val(new2.address+" "+new2.aum+" "+new2.province+" "+new2.zipcode)
              $('#sdepart').val(new2.depart)
              $('#ssalary').val(new2.selary)
              $('#susername').val(new2.username)
              $('#spass').val(new2.password)
              $('#lb1').val(new2.selary+"  เป็น")
              $('#lb2').val(new2.username+"  เป็น")
              $('#lb3').val(new2.password+"  เป็น")
               }
          })
        
           def delname66 = Employee.findAll()
                 $('#delname').append{
                      for(ls in delname66){
                      comboitem(label: ls.name)
                   }
            }
              def delname77 = Employee.findAll()
                 $('#listEdit').append{
                      for(ls in delname77){
                      comboitem(label: ls.name)
                   }
            }
      
         def em = Employee.findAll()
          
          $('#listshow').append{ 
              for(ls in em){  
                listitem{
                  String a = ls.name
                  String b = "  "+ls.surname
                  String c = a+b
                  listcell(label: c)
                  listcell(label: ls.sex)
                  listcell(label: ls.depart)
                  listcell(label: ls.selary+' บาท')                 
                  }
              }
           } 


                 $('#btnClear').on('click',{
                
                  $('#name')[0].text = ''
                  $('#surname')[0].text = ''
                  $('#sex1').setSelected(false)
                  $('#sex2').setSelected(false)
                  $('#address')[0].text = ''
                  $('#zipcode')[0].text = ''
                  $('#aum')[0].text = ''
                  $('#provinc')[0].text = ''
                  $('#depart').setSelectedItem(null)
                  $('#salary')[0].text = ''
                  $('#username')[0].text = ''
                  $('#pass')[0].text = ''
          
                 })

           $('#btnSubmit').on('click',{
            if( $('#name').getText()==''||
                $('#surname').getText()==''||
                $('#sex > radio[checked=true]').size()==0 ||
                $('#address').getText()==''||
                $('#aum').getText()==''||
                $('#surname').getText()==''||
                $('#provinc').getText()==''||
                $('#depart').getSelectedItem()==null ||
                $('#salary').getText()==''||
                $('#username').getText()==''||
                $('#pass').getText()==''
                ){
              alert("กรุณากรอกข้อมูลให้ครบ")
            }

            else{
            def name = $('#name')[0].text
            def surname = $('#surname')[0].text
            def  sex  = ""
             for(cb in $('#sex > radio[checked=true]'))
                 sex=sex+cb.getLabel()
            def address = $('#address')[0].text
            def aum = $('#aum')[0].text
            def provinc = $('#provinc')[0].text
            def zip  = $('#zipcode')[0].text
            def  depart  = $('#depart').text()
            def salary = $('#salary')[0].text
            def username = $('#username')[0].text
            def pass = $('#pass')[0].text           
           
            def add = new Employee(
                    name: name,
                    surname:surname,
                    sex:sex,
                    address:address,
                    aum:aum,
                    province:provinc,
                    zipcode:zip,
                    depart:depart,
                    selary:salary,
                    username:username,
                    password:pass
            )  
            add.save()

            $('#listshow').getItems().clear()

            def show1 = Employee.findAll()
          
            $('#listshow').append{ 
              for(ls in show1){  
                listitem{
                  String a = ls.name
                  String b = "  "+ls.surname
                  String c = a+b
                  listcell(label: c)
                  listcell(label: ls.sex)
                  listcell(label: ls.depart)
                  listcell(label: ls.selary+' บาท')                 
                }
              }
            } 

              $('#delname').getItems().clear()

             def delname1 = Employee.findAll()
                 $('#delname').append{
                      for(ls in delname1){
                      comboitem(label: ls.name)
                   }
            }

              $('#listEdit').getItems().clear()
             def delname88 = Employee.findAll()
                 $('#listEdit').append{
                      for(ls in delname88){
                      comboitem(label: ls.name)
                   }
            }
      
            alert("บันทึกข้อมูลพนักงานเรียบร้อยแล้ว")

                  $('#name')[0].text = ''
                  $('#surname')[0].text = ''
                  $('#sex1').setSelected(false)
                  $('#sex2').setSelected(false)
                  $('#address')[0].text = ''
                  $('#aum')[0].text = ''
                  $('#provinc')[0].text = ''
                  $('#zipcode')[0].text = ''
                  $('#depart').setSelectedItem(null)
                  $('#salary')[0].text = ''
                  $('#username')[0].text = ''
                  $('#pass')[0].text = ''
                  if($('#depart').text() == "พนักงานเสริฟ") {
                  $('#ss').setVisible(true)
                  }
          }

       })
        $('#del').on('click',{
           if($('#delname').getSelectedItem()==null){
                        alert("กรุณาเลือกพนักงานก่อน")
                    }
           else{

                     def dele = Employee.findByName($('#delname').text())
                     dele.delete()
           

            def show2 = Employee.findAll()
            $('#listshow').getItems().clear()
            $('#listshow').append{ 
              for(ls2 in show2){  
                listitem{
                  String a = ls2.name
                  String b = "  "+ls2.surname
                  String c = a+b
                  listcell(label: c)
                  listcell(label: ls2.sex)
                  listcell(label: ls2.depart)
                  listcell(label: ls2.selary+' บาท')                 
                }
              }
            }
            $('#delname').getItems().clear()

             def delname2 = Employee.findAll()
                 $('#delname').append{
                      for(ls3 in delname2){
                      comboitem(label: ls3.name)
                   }
            }
                     //alert("ลบข้อมูลเรียบร้อยแล้ว")
                }

                Executions.sendRedirect("/indexemployee.zul")
             })

     }
}
