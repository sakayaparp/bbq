package barbq

class Payment {
	String table
	double price
	String status
	Date orderdate = new Date()
    static constraints = {
			table blank:false
			status blank:false
    }
}
