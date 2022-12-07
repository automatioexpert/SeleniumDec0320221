package UI;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class testNgTest {

	@Test(priority = 1, description = "helo baba log", groups = "regression")
	public void blogin() {

		System.out.println("login succusfull");

	}
    @Test(priority = 2)
	public void alogout() {

		System.out.println("logout succusfull");

	}
}
