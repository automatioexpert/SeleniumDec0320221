package FinalizeMethod;

public class Company {

	String cName;

	@Override
	public void finalize() {
		System.out.println("inside finalize method....Company");
	}

	//practical use case:
	//DB connetion:
	//make the DB connection -- connected
	//hit sql query -- exception
	//get the result from DB--exception
	
	//finally{
		//close the DB connection
	//}
	
	//finalize():
	//launch a browser:
	//fill the form on login page
	//driver = null
	//finalize(){
		//clean up activity
		//reinitialize the driver
		//driver.quit()
		//shut down the selenium server
	//}
	
	
	
}
