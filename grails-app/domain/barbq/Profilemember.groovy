package barbq

class Profilemember {

	String username
	String password
	String name
	String lastname
	String idnumber
	String address
	String amphoe
	String province
	String zipcode
	String email
	String phonenumber
	int point = 0
	
	static hasMany = [promotion: Promotion, byaddpoint: ByAddPoint]
	
    static constraints = {
		username unique: false
		password unique: false
		name unique: false
		lastname unique: false
		idnumber unique: false, matches: /\d{13}/
		address unique: false
		amphoe unique: false
		province unique: false
		zipcode unique: false
		email unique: false
		phonenumber unique: false, matches: /\d{10}/
		point unique: false
    }
}
