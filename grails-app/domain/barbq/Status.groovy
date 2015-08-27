package barbq

class Status {

	String nameManager
	String lastnameManager
	Integer password
	
    static constraints = {
		nameManager blank: false,unique: true
		lastnameManager blank: false,unique: true 
    }
}
