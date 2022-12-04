package javasessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

	// WAF: this will return menu links on the page
	// param: page name
	// return: ArrayList<String>

	public ArrayList<String> getPageMenuLinks(String pageName) {
		System.out.println("page name is : " + pageName);

		ArrayList<String> menuList = new ArrayList<String>();

		if (pageName.trim().equalsIgnoreCase("loginpage")) {
			menuList.add("product");
			menuList.add("category");
			menuList.add("price");
		} else if (pageName.trim().equalsIgnoreCase("homepage")) {
			menuList.add("product");
			menuList.add("category");
			menuList.add("price");
			menuList.add("search");
			menuList.add("cart");
		} else if (pageName.trim().equalsIgnoreCase("productpage")) {
			menuList.add("product");
			menuList.add("category");
			menuList.add("price");
			menuList.add("info");
			menuList.add("seller");
		} else {
			System.out.println("please pass the right page name...." + pageName);
		}

		return menuList;
	}

	// WAF: name: getEmpDevicesList()
	// return the list of devices -- static String [] array
	// param: empName -- String
	public String[] getEmpDevicesList(String empName) {
		System.out.println("welcome to IT team....emp name is : " + empName);

		String devices[] = null;
		List<String> list = null;

		empName = empName.toLowerCase();// sachin
		if (empName.equals("sachin")) {
//			devices[0] = "iPhonex";
//			devices[1] = "Macbook pro";
//			devices[2] = "Airtel SIM";
			//devices = new String[] {"iph12", "macbook"};
			//devices = "iph12,macbook".split(",");
			list = Arrays.asList("iph", "macbook");
			devices = list.toArray(new String[list.size()]);
		
			
		} else if (empName.equals("ravi")) {
//			devices[0] = "iPhone12";
//			devices[1] = "Macbook Air";
//			devices[2] = "Airtel SIM";
//			devices[3] = "Lenovo Windows";
			//devices = new String[]{"iph12", "macbook pro", "Airtel SIM"};
			//devices = "iph12,macbook,AIRTEL SIM".split(",");

			list = Arrays.asList("iph", "macbook", "SIM");
			devices = list.toArray(new String[list.size()]);

		} else if (empName.equals("archana")) {
//			devices[0] = "iPhone13";
//			devices[1] = "Macbook Pro";
//			devices[2] = "HP Windows";
//			devices[3] = "Keyboard";
//			devices[4] = "Mouse";
			//devices = new String[]{"iph12", "macbook pro", "Airtel SIM", "keyboard", "mouse"};
			list = Arrays.asList("iph12", "macbook pro", "Airtel SIM", "keyboard", "mouse");
			devices = list.toArray(new String[list.size()]);

		} else {
			System.out.println("emp name is not found..." + empName);
		}

		return devices;
	}

	public static void main(String[] args) {

		Application app = new Application();
//		ArrayList<String> loginList = app.getPageMenuLinks("cartpage");
//		System.out.println(loginList);

		String emp_devices[] = app.getEmpDevicesList("archana");
		System.out.println(Arrays.toString(emp_devices));
		
//		int l = 016543;
//		System.out.println(l);
	}

}
