package barbq



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Checkin)
class CheckinTests {

    void testUserName() {
    	def s  = new Checkin(name:"employee",date:"15/3/2556")
		assert s.name =="employee"  
		assert s.validate() == true  
    }
     
    void testBlankDate(){
    	def s = new Checkin(name:"employee",date:"")
    	assert s.validate == false
    }
    void testBlankUserName(){
    	def s = new Checkin(name:"")
    	assert s.validate() == false
	}
	void CheckDuplicate(){
		def s = new Checkin(name:"employee",date:"15/3/2556")
		s.save()
		def d = new Checkin(name:"employee",date:"15/3/2556")
		assert d.validate()== false
	}
}
