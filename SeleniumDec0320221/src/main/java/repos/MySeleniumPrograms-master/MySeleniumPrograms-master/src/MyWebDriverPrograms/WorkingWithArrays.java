package MyWebDriverPrograms;

public class WorkingWithArrays {

	
	public static void main(String[] args) {

		//Declaring an Single Dimensional Array 
		int a[] = new int[] {10, 20, 30, 40, 50};
		 
	//	    (OR)
		    
		    
/*		int a[] = new int[5];
		  a[0] = 10;
		  a[1] = 20;
		  a[2] = 30;
		  a[3] = 40;
		  a[4] = 50; */
		  
		  
		  for (int i=0; i <a.length; i++)
		  {
			  System.out.println("a(i):" +a[i]);
			  System.out.println("Length is:" +a.length);
			  
		  }
	   
	// Two Dimensional Array
     int b[][] = new int [2][2];
     b[0][0] = 1;
     b[0][1] = 2;
     b[1][0] = 20;
     b[1][1] = 4;		
		
     for (int i=0;i<b.length;i++)
     {
    	 for (int j=0;j<b.length;j++)
    	 { 
    		 System.out.println(b[i][j]);
    		 
    	 }
     }
     
     // Multiple data types into the same array using keyword "Object"
     Object obj[] = new Object[5];
     obj[0] = 10;
     obj[1] = "tester";
     obj[2] = "Parking";
     obj[3] = 20;
     obj[4] = "Shiva";
     for ( int i = 0; i<obj.length; i++)
     {
    	 System.out.println(obj[i]);
    	 
     }
     
		
     
   
     
     
	}

}
