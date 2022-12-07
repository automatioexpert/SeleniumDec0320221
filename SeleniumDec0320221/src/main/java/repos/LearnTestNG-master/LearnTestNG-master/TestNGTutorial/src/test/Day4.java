package test;

import org.testng.annotations.Test;

public class Day4 {
	@Test
	public void WebLoginHome()
	{
		System.out.println("Web Login Home");
	}
	@Test
	public void MobileLoginHome()
	{
		System.out.println("Mobile Login Home");
	}
	@Test
	public void APILoginHome()
	{
		System.out.println("API Login Home");
	}
	@Test(groups= {"Smoke"})
	public void smoke2()
	{
		System.out.println("Smoke 2");
	}
	@Test(groups= {"Smoke"})
	public void smoke3()
	{
		System.out.println("Smoke 3");
	}
}
