package barbq

class Promotiondetail {
	
	String promotionname
	String detail
	int point
	
	static hasMany = [promotion: Promotion]
	
    static constraints = {
    }
}
