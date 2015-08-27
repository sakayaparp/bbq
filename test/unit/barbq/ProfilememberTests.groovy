package barbq



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Profilemember)
class ProfilememberTests {

    void testRegisterMember() {
		def t = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "เมืองระยอง", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "0831153381",
		idnumber: "1110100127140", point: 100)
		assert t.username == "ppmastercpe"
		assert t.password == "1234"
		assert t.name == "พชร"
		assert t.lastname == "บุญรุ่ง"
		assert t.idnumber == "1110100127140"
		assert t.address == "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด"
		assert t.amphoe == "เมืองระยอง"
		assert t.province == "ระยอง"
		assert t.zipcode == "21150"
		assert t.email == "ppmaster@windowslive.com"
		assert t.phonenumber == "0831153381"
		assert t.point == 100
		assert t.validate() == true
    }
	
	void testCheckEdit() {
		def t = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "เมืองระยอง", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "0831153381",
		idnumber: "1110100127140")
		t.save()
		def t2 = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "พระราม2", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "0831153381",
		idnumber: "1110100127140")
		t2.save()
		assert t2.validate() == true
	}
	
	void testCheckPhoneNoCharacter() {
		def t = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "เมืองระยอง", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "AS31153381",
		idnumber: "1110100127140")
		
		assert t.validate() == false
	}
	
	void testCheckPhoneNumber() {
		def t = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "เมืองระยอง", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "08311533812",
		idnumber: "1110100127140")
		assert t.validate() == false
		
		def t2 = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "เมืองระยอง", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "083115338",
		idnumber: "1110100127140")
		assert t2.validate() == false
	}
	
	void testCheckIdNumberNoCharacter() {
		def t = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "เมืองระยอง", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "0831153381",
		idnumber: "asd10100127140")
		
		assert t.validate() == false
	}
	
	void testCheckIdNumber() {
		def t = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "เมืองระยอง", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "0831153381",
		idnumber: "111010012714")
		
		assert t.validate() == false
		
		def t2 = new Profilemember(username: "ppmastercpe", password: "1234", name: "พชร", lastname: "บุญรุ่ง",  province: "ระยอง",
		address: "26 ถ. เทอดไทยมุสลิม ต. มาบตาพุด",  amphoe: "เมืองระยอง", zipcode: "21150", email: "ppmaster@windowslive.com", phonenumber: "0831153381",
		idnumber: "11101001271401")
		
		assert t2.validate() == false
	}
}
