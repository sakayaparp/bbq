package barbq

class Savemoney {

	String name
	String date 
	Integer number
	Integer price
	

    static constraints = {
    	name blank:false
        date blank:false
        number blank:false ,matches: /\d{5}/
        price blank:false ,matches: /\d{7}/
        
    }
}
