package barbq

class Adjustment {
	Date editedDate = new Date()
	String type
	
	static belongsTo = [employee: Employee, warehouse: Warehouse]
    static constraints = {
    }
}
