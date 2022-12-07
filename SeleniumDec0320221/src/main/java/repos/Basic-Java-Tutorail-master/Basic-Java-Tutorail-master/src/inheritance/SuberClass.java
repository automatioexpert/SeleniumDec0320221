package inheritance;

public class SuberClass {
	protected String age="80";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	}
	//Addition Method
	public void addition (){
    	int a=10;
    	int m=9;
    	int d=a+m;
    	System.out.println("The value of the addition is:" +d);
    }
	
	//Grade Calculation Method
	public void calculateGrade(int gradLinux, int gradSystem,int gradComputer){
		int avg= (gradLinux+gradSystem+gradComputer) *100 /300;
		System.out.println("Linux grade is: " +gradLinux);
		System.out.println("System grade is: " +gradSystem);
		System.out.println("System grade is: " +gradComputer);
		System.out.println("The average of the grade is: " +avg);
		
	     if (avg>=90 && avg<100){
	    	 System.out.println("Grade of the student is: A");
	     }else if(avg>=80 && avg<89){
	    	 System.out.println("Grade of the student is: B");
	     }else if(avg>=70 && avg<79){
	    	 System.out.println("Grade of the student is: C");
		 }else if(avg>=60 && avg<69){
	    	 System.out.println("Grade of the student is: D");
		 }else if(avg>=50 && avg<59){
	    	 System.out.println("Grade of the student is: E");
		 }else{
			 System.out.println("Grade of the student is: F");
		 }
	}
	//
	public void age(String ageid){
		this.age=ageid;
		System.out.println(this.age);
		String ageidno=getAge();
		System.out.println("this is setter method value; "+ageidno);
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	

}