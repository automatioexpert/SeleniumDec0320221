package overridingPractice;

	public class TestA {
		// TODO Auto-generated method stub
			private String atm="66996996978886";
			
		public void tesb (){
			System.out.println("This is my atm number do not stole it " +this.atm);
		}

		/*public String getAtm() {
			return atm;
		}

		public void setAtm(String atm) {
			this.atm = atm;
			System.out.println(this.atm);
		}*/
		
		//Method overloading
		public void addition(){
			int a=60;
			int b=50;
			int c=a+b;
		}
		public void addition(int d,int r,int t){
			//declare argument in the method
			int e=d+r+t;
			System.out.println("the sum is :" +e);
			
		}
		public void addition(int u,int w,int j,int k){
			//add one extra argument 
			int l=(u-w)+j+k;
			System.out.println("the total of l is: "+l);
		}
		public void addition(float u,float r, float k){
			//change the type of the argument
			float y=u+r-k;
			System.out.println("the total of the float is: "+y);
			
		}
		public void addition (double k){
			//change the type of the argument
		}
		//public void TestA(){   }
		
		public TestA(String name){
			System.out.println("This is developer who is using this class: "+name);
		}
}
