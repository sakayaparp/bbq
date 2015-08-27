package barbq

class Checkin {
	String name
	String date
    static constraints = {
    	name blank:false
    	date blank:false
    	name unique:true
    	
    
    }
}
