package barbq



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Status)
class StatusTests {

    void testTrueAll() {
		def s = new Status(nameManager:"A",lastnameManager:"B",password:"123456789")
		assert s.validate()==true
    }
	
	void testNameManagerNotBlank(){
		def s = new Status(nameManager:"",lastnameManager:"B",password:"123456789")
		assert s.validate()==false
	}
	
	void lastnameManagerNotBlank(){
		def s = new Status(nameManager:"A",lastnameManager:"",password:"123456789")
		assert s.validate()==false
	}
	
	void passwordNotBlank(){
		def s = new Status(nameManager:"A",lastnameManager:"B",password:"")
		assert s.validate()==false
	}
	
	void nameNotDuplicate(){
		def s = new Status(nameManager:"A",lastnameManager:"B",password:"123456789")
		s.save()
		def t = new Status(nameManager:"A",lastnameManager:"C",password:"123456789")
		s.save()
		assert t.validate()==false
	}
    
}
