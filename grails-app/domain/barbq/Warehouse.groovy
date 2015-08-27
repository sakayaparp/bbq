package barbq

class Warehouse {

	String product_name
	Date editDate = new Date()
	String date_expire
	Integer amount
	String buy_by
	Double price
	String details
	
	static hasMany = [adjustments: Adjustment]
    static constraints = {
    }
}
