package modifiers;

public class Modifiers {
	public String email="hsen07@gmail.com";
	
    private String ui="8886666666";
    protected String age="80";
	String account="88888886666666";
	private String atmid ;
	
	public void atm (String atmid){
		this.atmid=atmid;
		System.out.println(this.atmid);
		String atmidno=getUi();
		System.out.println("this is setter method value; "+atmidno);
	}

	public String getUi() {
		return ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
		System.out.println(this.ui);
	}

	public String getAtmid() {
		return atmid;
	}

	public void setAtmid(String atmid) {
		this.atmid = atmid;
	}
	
}
