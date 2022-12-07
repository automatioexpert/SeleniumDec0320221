package array;

public class Arraysa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int studentid[]=new int[10];
		/*studentid[0]=100;
		studentid[2]=200;
		studentid[6]=600;
		System.out.println(studentid[6]);
		System.out.println(studentid[80]);
		System.out.println(studentid.length);*/
		
		for(int i=0;i<studentid.length;i++){
			studentid[i]=i*100;
			System.out.println("studentid[" +i +"]=" +studentid[i]);
		}
		
		//multiarray
		int teacherid[][]=new int[2][3];
			teacherid[0][0]=6;
			teacherid[0][1]=600;
			teacherid[0][2]=500;
			teacherid[1][0]=10;
			teacherid[1][2]=120;
			//System.out.println(teacherid[0][1]);
			
			for(int i=0;i<teacherid.length;i++){
				for (int j=0;j<teacherid[i].length;j++){
					System.out.println(teacherid[i][j]);
				}				
			}
		/*
	   	int i=0;
		while (i<studentid.length){
			studentid[i]=i;
			System.out.println("studentid[" +i+"]" +studentid[i]);
			i++;
		}*/
	}
}
