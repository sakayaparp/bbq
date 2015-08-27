package barbq

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class ReserveComposer extends GrailsComposer {

    def afterCompose = { window ->
        
        $('#btnlogout').on('click',{
            Executions.sendRedirect("/loginWarehouse.zul")
            })


        $('#btnaccept').on('click',{
                
                if($('#listtable').text() != ''){
                    def table = $('#listtable').text()
                    def a = new Reservetable(
                        nametable:table,
                        status: 'ไม่ว่าง'

                        )
                    a.save()

                    alert(table  + '   ' + 'ได้ทำการเลือกโต๊ะไปแล้วครับ/ค่ะ')
                    alert('คุณได้ทำการจองโต๊ะเรียบร้อยแล้วครับ/ค่ะ')

                }
                
                else{
                    alert('คุณยังไม่ได้ทำการเลือกที่นั่งครับ/ค่ะ')
                }
                
            })
    }
}
