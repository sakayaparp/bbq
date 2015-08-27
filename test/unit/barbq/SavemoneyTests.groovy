package barbq



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Savemoney)
class SavemoneyTests {

    void testName() {
       def s = new Savemoney(name:"ไก่",date:"2556/3/15",number:"100",price:"1234567")	
       assert s.name == "ไก่"
       assert s.validate() == true	
       def s2 = new Savemoney(name:"")	
       assert s2.validate() == false	
    }	
    void testDate() {	
    	def s = new Savemoney(name:"ไก่",date:"",number:"100",price:"1234567")	
    	assert s.validate() == false		
    	def s3 = new Savemoney(name:"ไก่",date:"2556/3/15",number:"100",price:"1234567")	
    	assert s3.date == "2556/3/15"	
    	assert s3.validate() == true	
    }	
    void testNumber() {	
    	def s = new Savemoney(name:"ไก่",date:"2556/3/15",number:"",price:"1234567")	
    	assert s.validate() == false	
    	def s2 = new Savemoney(name:"ไก่",date:"2556/3/15",number:"abc",price:"1234567")	
    	assert s2.validate() == false	
    	def s3 = new Savemoney(name:"ไก่",date:"2556/3/15",number:"ฟหก",price:"1234567")	
    	assert s3.validate() == false	
    	def s4 = new Savemoney(name:"ไก่",date:"2556/3/15",number:"100",price:"1234567")		
    	assert s4.number == 100	
    	assert s4.validate() == true 		
    }	
    void testPrice() {		
    	def s = new Savemoney(price:"")		
    	assert s.validate() == false		
    	def s2 = new Savemoney(price:"bca")	
    	assert s2.validate() == false	
    	def s3 = new Savemoney(price:"หดก")	
    	assert s3.validate() == false	
    	def s4 = new Savemoney(price:"12345678")	
    	assert s4.validate() == false		
    	def s5 = new Savemoney(name:"ไก่",date:"2556/3/15",number:"100",price:"1234567")		
    	assert s5.price == 1234567		
    	assert s5.validate() == true
    }
}
