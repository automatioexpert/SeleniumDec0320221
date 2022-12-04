package SeleniumSessions;

import org.checkerframework.checker.units.qual.A;

public class WaitTypes {

	public static void main(String[] args) {

		//synchronization in selenium
		//sync between script(selenium) and application
		//1. static wait 
			//sleep(5 secs) -- Thread.sleep(5000)
			
		//2. dynamic wait
			//implicitly wait
			//explicit wait:
				//a. WebDriverWait
				//b. FluentWait
				
		//Wait(I)<--FluentWait(C)<---WebDriverWait(C)
		//ele -->2 secs, 5 secs, 10 secs
		//dynamic wait -- 10 secs (max timeout)
		//2 secs --> 8 secs (ignored)
		//5 secs --> 5 secs
		//10 secs --> 0 secs
		//0 secs --> 10 secs
		//11 secs --> nosuchelement exception
		
		
		
		
		
		
	}

}
