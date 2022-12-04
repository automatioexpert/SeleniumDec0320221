package constructorconcept;

public class Company {

	// const...looks like a function but not a function
	// const... can not return any value: no return type for the const.... but
	// function may or may not return a value
	// const... name will be same as the class name, but function name can be anything
	// const... wil be called when you create the object of the class ut function
	// will be called with the obj reference
	// const... is used to initialize the class variables with this keyword
	// const.. is used to restrict of creating unnecessary objects and
	// const... should not have the buss logic/ application logic
	// buss logic should be written inside the function

	String name;
	int empCount;
	String hq;
	String ceo;
	double sharePrice;

	public Company(String name, int empCount, String hq, String ceo, double sharePrice) {
		this.name = name;
		this.empCount = empCount;
		this.hq = hq;
		this.ceo = ceo;
		this.sharePrice = sharePrice;
	}

	public Company(String name, String hq) {
		this.name = name;
		this.hq = hq;
	}

	public Company(String name, int empCount, double sharePrice) {
		this.name = name;
		this.empCount = empCount;
		this.sharePrice = sharePrice;
	}

	public Company(String name) {
		this.name = name;
	}

}
