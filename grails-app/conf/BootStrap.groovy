import barbq.*

class BootStrap {

    def init = { servletContext ->

//=====================================================


    	def barnam0 = new Barnam(
    		menu: "Pepsi",
    		amount: "100",
    		balance: "70",
    		time: "Sun Mar 17 19:51:48",
    		detail: ""
    		)
    	barnam0.save()

    	def barnam1 = new Barnam(
    		menu: "Coke",
    		amount: "100",
    		balance: "70",
    		time: "Sun Mar 17 19:51:48",
    		detail: ""
    		)
    	barnam1.save()

    	def barnam2 = new Barnam(
    		menu: "Fanta",
    		amount: "100",
    		balance: "70",
    		time: "Sun Mar 17 19:51:48",
    		detail: ""
    		)
    	barnam2.save()

    	def barnam3 = new Barnam(
    		menu: "Beer  Chang",
    		amount: "100",
    		balance: "70",
    		time: "Sun Mar 17 19:51:48",
    		detail: ""
    		)
    	barnam3.save()

    	def barnam4 = new Barnam(
    		menu: "Beer  LEO",
    		amount: "100",
    		balance: "70",
    		time: "Sun Mar 17 19:51:48",
    		detail: ""
    		)
    	barnam4.save()


    	def barnam5 = new Barnam(
    		menu: "Beer  Heineken",
    		amount: "50",
    		balance: "50",
    		time: "Sun Mar 17 19:51:48",
    		detail: ""
    		)
    	barnam5.save()

    	def barnam6 = new Barnam(
    		menu: "Black  Label",
    		amount: "50",
    		balance: "50",
    		time: "Sun Mar 17 14:51:48",
    		detail: ""
    		)
    	barnam6.save()

    	def barnam7 = new Barnam(
    		menu: "Red  Label",
    		amount: "30",
    		balance: "20",
    		time: "Sun Mar 17 15:51:48",
    		detail: ""
    		)
    	barnam7.save()

    	def barnam8 = new Barnam(
    		menu: "Smirnoff: VODKA",
    		amount: "40",
    		balance: "37",
    		time: "Sun Mar 17 16:51:48",
    		detail: ""
    		)
    	barnam8.save()

    	def barnam9 = new Barnam(
    		menu: "100   PIPERS",
    		amount: "100",
    		balance: "20",
    		time: "Sun Mar 17 15:51:48",
    		detail: ""
    		)
    	barnam9.save()


//=====================================================    	


    	def data1 = new Savemoney(
    		name: "หมู",
    		date: "2556/03/14",
    		number: "1",
    		price: "100"
    		)
    	data1.save()

    	def data2 = new Savemoney(
    		name: "ผัก",
    		date: "2556/03/14",
    		number: "2",
    		price: "50"
    		)
    	data2.save()

    	def data3 = new Savemoney(
    		name: "ไก่",
    		date: "2556/03/14",
    		number: "1",
    		price: "20"
    		)
    	data3.save()

    	def data4 = new Savemoney(
    		name: "ปลาหมึก",
    		date: "2556/03/14",
    		number: "20",
    		price: "50"
    		)
    	data4.save()

    	def data5 = new Savemoney(
    		name: "กุ้ง",
    		date: "2556/03/14",
    		number: "2",
    		price: "150"
    		)
    	data5.save()

    	def data6 = new Savemoney(
    		name: "ลูกชิ้น",
    		date: "2556/03/14",
    		number: "1",
    		price: "75"
    		)
    	data6.save()
		
		def em1 = new Employee(
			name: "ณัฐพงศ์",
			surname: "ฐิติชวลิตกุล",
			sex: "ชาย",
			address: "ชัยภูมิ",
			aum: "แก้งคร้อ",
			province: "ชัยภูมิ",
			zipcode: "30340",
			depart: "พนักงานคลังสินค้า",
			selary: "100,000",
			username: "tck",
			password: "1234"
		)
		em1.save()
		def em2 = new Employee(
			name: "เชษฐา",
			surname: "ครอบกระโทก",
			sex: "ชาย",
			address: "อำนาจเจริญ",
			aum: "หัวตะพาน",
			province: "อำนาจเจริญ",
			zipcode: "37240",
			depart: "ผู้จัดการ",
			selary: "200,000",
			username: "darkkill",
			password: "1234"
		)
		em2.save()
		def em3 = new Employee(
			name: "ศักยภาพ",
			surname: "พวงสมบัติ",
			sex: "ชาย",
			address: "นครราชสีมา",
			aum: "โนนสูง",
			province: "นครราชสีมา",
			zipcode: "37240",
			depart: "พนักงานสั่งอาหาร",
			selary: "2000",
			username: "sak",
			password: "1234"
		)
		em3.save()
		def em4 = new Employee(
			name: "สุธิรนันท์",
			surname: "ภูตน",
			sex: "ชาย",
			address: "สระแก้ว",
			aum: "เมือง",
			province: "สระแก้ว",
			zipcode: "37240",
			depart: "พนักงานชำระเงิน",
			selary: "20000",
			username: "jiewfcb",
			password: "1234"
		)
		em4.save()
		def em5 = new Employee(
			name: "สัจจจนาท",
			surname: "สีสุทัศน์",
			sex: "ชาย",
			address: "พะเยา",
			aum: "เมือง",
			province: "พะเยา",
			zipcode: "37240",
			depart: "พนักงานจองโต๊ะ",
			selary: "50",
			username: "aum",
			password: "1234"
		)
		em5.save()
		def em6 = new Employee(
			name: "พชร",
			surname: "บุญรุ่ง",
			sex: "ชาย",
			address: "ระยอง",
			aum: "เมือง",
			province: "ระยอง",
			zipcode: "37000",
			depart: "พนักงานดูแลระบบสมาชิก",
			selary: "800",
			username: "ppmaster",
			password: "1234"
		)
		em6.save()
	
		def fs1 = new Warehouse(
			product_name: "จาน",
			//Date editDate = new Date(),
			date_expire: "3/3/2012",
			amount: 150,
			buy_by:  "ณัฐพงศ์",
			price: 40,
			details: "-"
		)
		fs1.save()
		
		def fs2 = new Warehouse(
			product_name: "ชาม",
			//Date editDate = new Date(),
			date_expire: "5/3/2012",
			amount: 69,
			buy_by:  "สุธิรนันท์",
			price: 30,
			details: "-"
		)
		fs2.save()
		
		def fs3 = new Warehouse(
			product_name: "ช้อน",
			//Date editDate = new Date(),
			date_expire: "16/7/2012",
			amount: 230,
			buy_by:  "ศักยภาพ",
			price: 5,
			details: "-"
		)
		fs3.save()
		
		def fs4 = new Warehouse(
			product_name: "ส้อม",
			//Date editDate = new Date(),
			date_expire: "16/7/2012",
			amount: 230,
			buy_by:  "ศักยภาพ",
			price: 5,
			details: "-"
		)
		fs4.save()
		
		def fs5 = new Warehouse(
			product_name: "เนื้อหมู",
			//Date editDate = new Date(),
			date_expire: "18/7/2012",
			amount: 20,
			buy_by:  "สุธิรนันท์",
			price: 120,
			details: "-"
		)
		fs5.save()
		
		def fs6 = new Warehouse(
			product_name: "เนื้อไก่",
			//Date editDate = new Date(),
			date_expire: "19/7/2012",
			amount: 12,
			buy_by:  "เชษฐา",
			price: 70,
			details: "-"
		)
		fs6.save()
		
		def fs7 = new Warehouse(
			product_name: "มะม่วง",
			//Date editDate = new Date(),
			date_expire: "16/7/2012",
			amount: 78,
			buy_by:  "ณัฐพงศ์",
			price: 20,
			details: "-"
		)
		fs7.save()
		
		
		def fs8 = new Warehouse(
			product_name: "กระทะเนื้อย่าง",
			//Date editDate = new Date(),
			date_expire: "23/8/2012",
			amount: 34,
			buy_by:  "สัจจนาท",
			price: 400,
			details: "-"
		)
		fs8.save()
		
		def fs9 = new Warehouse(
			product_name: "ตะเกียบ",
			//Date editDate = new Date(),
			date_expire: "23/8/2012",
			amount: 300,
			buy_by:  "สัจจนาท",
			price: 3,
			details: "-"
		)
		fs9.save()
		
		def fs10 = new Warehouse(
			product_name: "ข้าวสาร",
			//Date editDate = new Date(),
			date_expire: "23/8/2012",
			amount: 50,
			buy_by:  "สัจจนาท",
			price: 30,
			details: "-"
		)
		fs10.save()
		
		def fs11 = new Warehouse(
			product_name: "พัดลม",
			//Date editDate = new Date(),
			date_expire: "23/8/2012",
			amount: 3,
			buy_by:  "ณัฐพงศ์",
			price: 730,
			details: "Hatari"
		)
		fs11.save()
		
		def fs12 = new Warehouse(
			product_name: "ตะกร้าใส่ผัก",
			//Date editDate = new Date(),
			date_expire: "29/8/2012",
			amount: 30,
			buy_by:  "สัจจนาท",
			price: 30,
			details: "-"
		)
		fs12.save()
		
		def fs13 = new Warehouse(
			product_name: "ผ้ากันเปื้อน",
			//Date editDate = new Date(),
			date_expire: "2/8/2012",
			amount: 20,
			buy_by:  "สัจจนาท",
			price: 30,
			details: "-"
		)
		fs13.save()
		def fs14 = new Warehouse(
			product_name: "เก้าอี้ไม้",
			//Date editDate = new Date(),
			date_expire: "23/6/2012",
			amount: 15,
			buy_by:  "เชษฐา",
			price: 1000,
			details: "ร้านเฟอร์นิเจอร์"
		)
		fs14.save()
		
		new Profilemember(
			username: "ppmastercpe",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		new Profilemember(
			username: "jiewfcb",
			password: "1234",
			name: "สุธิรนันท์",
			lastname: "ภูตน",
			idnumber: "1111111111111",
			address: "94 ม. 7",
			amphoe: "คลองหาด",
			province: "สระเเก้ง",
			zipcode: "27260",
			email: "jew.fcb@gmail.com",
			phonenumber: "0854308719",
			point:10000
		).save()
		
		new Profilemember(
			username: "test2",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		new Profilemember(
			username: "test3",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		new Profilemember(
			username: "test4",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		new Profilemember(
			username: "test5",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		new Profilemember(
			username: "test6",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		new Profilemember(
			username: "test7",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		new Profilemember(
			username: "test8",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		new Profilemember(
			username: "test9",
			password: "1234",
			name: "พชร",
			lastname: "บุญรุ่ง",
			idnumber: "1110100127140",
			address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",
			amphoe: "เมืองระยอง",
			province: "ระยอง",
			zipcode: "21150",
			email: "ppmaster@windowslive.com",
			phonenumber: "0831153381"
		).save()
		
		//========================================================================
		def promotiondetail1 = new Promotiondetail(detail:"ชุดนี้เหมาะสำหรับการมากันเป็นครอบครัว มีเนื้อหมู ผัก อย่างละ1ชุด",point:"300",promotionname:"ชุดครอบครัว")
		promotiondetail1.save()
	
		def promotiondetail2 = new Promotiondetail(detail:"ชุดนี้เหมาะสำหรับไม่ชอบรับประทานเนื้อ โดยจะเน้นไปที่เมนูผักสะส่วนใหญ่",point:"200",promotionname:"ชุดผักรวม")
		promotiondetail2.save()
	
		def promotiondetail3 = new Promotiondetail(detail:"ชุดนี้สำหรับท่านที่ชอบรับประทานเเบบไม่ยั่งต้องชุดนี้ มีทั้ง เนื้อสัตว์ ผัก เเละน้ำจิ้มอีกหลากหลายให้ท่านเลือกได้ตามใจ",point:"600",promotionname:"ชุดจุใจ")
		promotiondetail3.save()
	
		def promotiondetail4 = new Promotiondetail(detail:"ชุดนี้สำหรับคนที่ชอบรับประทานเยอะ ต้องชุดนี้เลย ประกอบไปด้วยทั้ง เนื้อสัตว์เเละยังรวมทั้งอาหารทะเล",point:"600",promotionname:"ชุดอิ่มสุด")
		promotiondetail4.save()
	
		def promotiondetail5 = new Promotiondetail(detail:"ชุดนี้เหมาะสำหรับคนที่ชอบรับประทานอาหารทะเล ชุดนี้ประกอบด้วย หมึก กุ้ง เเละปลา",point:"400",promotionname:"ชุดทะเล")
		promotiondetail5.save()
	
		def promotiondetail6 = new Promotiondetail(detail:"ชุดนี้สำหรับคนที่กินไม่เยอะ เหมาะสำหรับชุดนี้โดยจะมีทั้งเนื้อสัตว์ ผักรวมไปถึงอาหารทะเลให้ท่านสามารถเลือกรับประทานได้",point:"300",promotionname:"ชุดสุดคุ้ม")
		promotiondetail6.save()
    }
    def destroy = {
    }
}
