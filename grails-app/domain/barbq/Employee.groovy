package barbq

class Employee {

	String name
	String surname
	String sex
	String address
	String aum
	String province
	String zipcode
	String depart
	String selary
	String username
	String password
	String status = "ยังไม่มาทำงาน"

	static hasMany=[adjustments: Adjustment, byaddpoint: ByAddPoint]
	
    static constraints = {
    }
}
