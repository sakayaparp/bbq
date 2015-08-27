package barbq

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class IndexWarehouseComposer extends GrailsComposer {

    def afterCompose = { window ->
        def foodDB = Warehouse.findAll()  //foodDB ใช้เก็บตัวแปรที่ดึงเข้ามาจาก Database
		$('#listboxID').append{ //แอดข้อมูลเข้าสู่ listbox ที่มีไอดีชื่อ listbox $('#listboxID') ก็ได้ แต่เดิมทำแบบนี้
			for(ls in foodDB){  //วนลูป เอา fooddB เก็บใน ls
				listitem(value: ls.product_name){
					listcell(label: ls.product_name)
					//listcell(label: "yes")
					listcell(label: ls.amount)
					listcell(label: ls.date_expire)
					listcell(label: ls.price+' ฿')
					listcell(label: ls.details)
					
				}
			}
		}	
		
		$('#btnDecreaseNumber').on('click',{
			if($('#cbBoxID').getSelectedItem()==null){
				alert('เลือกรายการ')
			}else{
				def update = Warehouse.get(Warehouse.findByProduct_name($('#cbBoxID').text()).id)
				if($('#txtDecrese').text() != '' && Integer.parseInt($('#txtDecrese').text()) <= Warehouse.findByProduct_name($('#cbBoxID').text()).amount){
					update.amount = Warehouse.findByProduct_name($('#cbBoxID').text()).amount-Integer.parseInt($('#txtDecrese').text())
					update.save()
					
					
					def emAdd = new Employee()
					def foodDecrease = new Warehouse()
					new Adjustment(
						employee: emAdd.get(Employee.findByUsername(session['username']).id),
						warehouse: foodDecrease.get(Warehouse.findByProduct_name($('#cbBoxID').text()).id), //บรรทัดนี้ลบได้
						type: "Decrease"
					).save()
					
					$('#listboxID').getItems().clear()
					def updateListDecreaseNumber = Warehouse.findAll()
					$('#listboxID').append{
						for(ls in updateListDecreaseNumber){
							listitem(value: ls.product_name){
								listcell(label: ls.product_name)
								//listcell(label: "yes")
								listcell(label: ls.amount)
								listcell(label: ls.date_expire)
								listcell(label: ls.price+' ฿')
								listcell(label: ls.details)
								
							}
						}
					}
					
					alert('ลดแล้ว')
				}
				else
					alert('กรอกจำนวน')
			}
		})
		
		$('#btnIncreaseNumber').on('click',{
			if($('#cbBoxID').getSelectedItem()==null){
				alert('เลือกรายการ')
			}else{
				def addamount = Warehouse.get(Warehouse.findByProduct_name($('#cbBoxID').text()).id)
				if($('#txtDecrese').text() != ''){
					addamount.amount = Warehouse.findByProduct_name($('#cbBoxID').text()).amount+Integer.parseInt($('#txtDecrese').text())
					addamount.save()
					
					def emAdd = new Employee()
					def foodIncrease = new Warehouse()
					new Adjustment(
						employee: emAdd.get(Employee.findByUsername(session['username']).id),
						warehouse: foodIncrease.get(Warehouse.findByProduct_name($('#cbBoxID').text()).id), //บรรทัดนี้ลบได้
						type: "Increase"
					).save()
					
					$('#listboxID').getItems().clear()
					def updateListIncreaseNumber = Warehouse.findAll()
					$('#listboxID').append{
						for(ls in updateListIncreaseNumber){
							listitem(value: ls.product_name){
								listcell(label: ls.product_name)
								//listcell(label: "yes")
								listcell(label: ls.amount)
								listcell(label: ls.date_expire)
								listcell(label: ls.price+' ฿')
								listcell(label: ls.details)
								
							}
						}
					}
					
					alert('เพิ่มแล้ว')
				}
				else
					alert('กรอกจำนวน')
			}
		})
		
		$('#cbBoxID').append{   //cb เหมือนกับ ls ใช้ดึงข้อมูลใน loop combobox
			for(cb in foodDB){
				comboitem(label: cb.product_name)
			}
			
		}
	
		$('#btnAddTask').on('click',{
			if($('#txtAddFoodName')[0].text=='' || $('#txtAddExpire')[0].text=='' || $('#txtAddNumber')[0].text=='' || $('#txtAddBy')[0].text=='' || $('#txtAddPrice')[0].text==''){
				alert('กรอกข้อมูลให้ครบถ้วน')
			}else{	
				
				
				
				//def adjAdd = new Adjustment(type:"add")
			
				def add_name = $('#txtAddFoodName')[0].text
				def add_expire = $('#txtAddExpire')[0].text
				def add_number = $('#txtAddNumber')[0].text
				def add_by = $('#txtAddBy')[0].text
				def add_price = $('#txtAddPrice')[0].text
				def add_details = $('#txtAddDetails')[0].text
				
				def food = new Warehouse(
					product_name: add_name,
					date_expire: add_expire,
					amount: add_number,
					buy_by: add_by,
					price: add_price,
					details: add_details
				)
				
				
				//food.adjustments = [adjAdd]
				food.save()
				
				def emAdd = new Employee()
				def foodAdd = new Warehouse()
				
				def adjAdd = new Adjustment(
					employee: emAdd.get(Employee.findByUsername(session['username']).id),
					warehouse: foodAdd.get(Warehouse.findByProduct_name(add_name).id), //บรรทัดนี้ลบได้
					type: "add"
					
				)
				adjAdd.save()
				
				//Clear And Update All 
				
				$('#listboxID').getItems().clear()
				def updateList = Warehouse.findAll()
				$('#listboxID').append{
					for(ls in updateList){
						listitem(value: ls.product_name){
							listcell(label: ls.product_name)
							//listcell(label: "yes")
							listcell(label: ls.amount)
							listcell(label: ls.date_expire)
							listcell(label: ls.price+' ฿')
							listcell(label: ls.details)
							
						}
					}
				}
				
				def ComboAddList = Warehouse.findAll()
				$('#cbBoxID').getItems().clear()
				$('#cbBoxID').append{   //cb เหมือนกับ ls ใช้ดึงข้อมูลใน loop combobox
					for(cb in ComboAddList){
						comboitem(label: cb.product_name)
					}
				}
				alert('บันทึกสำเร็จ')
				
				
			}
		})
		
		$('#btnLogout').on('click',{
			Executions.sendRedirect("/loginWarehouse.zul")
		})
		
		$('#btnRefresh').on('click',{
			Executions.sendRedirect("/indexwarehouse.zul") //รีเฟรชหน้าไปที่ indexwarehouse.zul หน้าเดิม
		})
		
		$('#btnDelete').on('click',{
	
			if($('#cbBoxID').getSelectedItem()==null){
				alert('เลือกรายการ')
			}else{
				if($('#txtDecrese').text() == ''){
				
					def del = Warehouse.findByProduct_name($('#cbBoxID').text()) //ค้นหาจากฐานข้อมูลที่มีชื่อตามรายการที่เลือก
					del.delete(flush:true) //ลบรายการออกจากฐานข้อมูล
					//Executions.sendRedirect("/indexwarehouse.zul")
					
					
					//update List All
					$('#listboxID').getItems().clear()
					def updateListDel = Warehouse.findAll()
					$('#listboxID').append{
						for(ls in updateListDel){
							listitem(value: ls.product_name){
								listcell(label: ls.product_name)
								//listcell(label: "yes")
								listcell(label: ls.amount)
								listcell(label: ls.date_expire)
								listcell(label: ls.price+' ฿')
								listcell(label: ls.details)
								
							}
						}
					}
					
					def ComboDelList = Warehouse.findAll()
					$('#cbBoxID').val("")
					$('#cbBoxID').getItems().clear()
					$('#cbBoxID').append{   //cb เหมือนกับ ls ใช้ดึงข้อมูลใน loop combobox
						for(cb in ComboDelList){
							comboitem(label: cb.product_name)
						}
					}
					
					alert('ลบรายการสำเร็จ')
				
				
				}else
					alert('ห้ามกรอกจำนวน')
			}
		})
    }
}
