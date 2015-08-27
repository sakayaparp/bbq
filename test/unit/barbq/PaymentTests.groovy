package barbq



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Payment)
class PaymentTests {

    void testPayment() {
       def s = new Payment(table:"A1",price:100,status:"ยังไม่ชำระเงิน")
	   assert s.table == "A1"
	   assert s.price == 100
	   assert s.status == "ยังไม่ชำระเงิน"
	   assert s.validate() == true
    
    }
	 void testPaymentblank() {
       def s = new Payment(table:"",price:100,status:"ยังไม่ชำระเงิน")
			assert s.validate() == false
	   def s2 = new Payment(table:"A1",price:100,status:"")
			assert s2.validate() == false
		
    }
	 void testPaymentprice() {
       def s = new Payment(table:"",price:"aa",status:"ยังไม่ชำระเงิน")
			assert s.validate() == false
	  
		
    }

}
