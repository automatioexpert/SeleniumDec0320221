package javasessions;

import java.util.ArrayList;
import java.util.Arrays;

public class Company {

	// WAF:
	// name:getCompInfo
	// input param: compName(String)
	// return: name, Bangalore, 1000, 5.5, Tom -- Object static array--> Object[]
	public Object[] getCompInfo(String compName) {

		System.out.println("getting info for : " + compName);
		Object info[] = new Object[5];

		if (compName.equals("IBM")) {
			info[0] = "IBM";
			info[1] = 1000;
			info[2] = 5.5;
			info[3] = "Bangalore";
			info[4] = "Tom";
		} else if (compName.equals("MS")) {
			info[0] = "MS";
			info[1] = 2000;
			info[2] = 6.5;
			info[3] = "HYD";
			info[4] = "Peter";
		}

		else {
			System.out.println("comp name is not found.....");
		}

		return info;
	}

	// name:
	// inp:
	// return: list of products: ArrayList<String>
	public ArrayList<String> getProductList(String compName) {

		System.out.println("getting product list for : " + compName);
		ArrayList<String> prodList = new ArrayList<String>();

		switch (compName.toLowerCase()) {
		case "amazon":
			prodList.add("macbook");
			prodList.add("samsung");
			prodList.add("imac");
			break;
		case "walmart":
			prodList.add("nike");
			prodList.add("reebok");
			prodList.add("adidas");
			break;
		case "flipkart":
			prodList.add("zara");
			prodList.add("H&M");
			prodList.add("H&B");
			break;

		default:
			System.out.println("comp is not found...." + compName);
			break;
		}

		return prodList;

	}

	public static void main(String[] args) {
		Company obj = new Company();
		ArrayList<String> amzList = obj.getProductList("amazon");
		System.out.println(amzList);//[]--for/for each
		System.out.println("amazon prod count: " + amzList.size());

		ArrayList<String> wmList = obj.getProductList("walmart");
		System.out.println(wmList);

		ArrayList<String> spList = obj.getProductList("snapdeal");
		System.out.println(spList);

		Object comp[] = obj.getCompInfo("IBM");
		System.out.println(Arrays.toString(comp));

		Object comp1[] = obj.getCompInfo("NAL");
		System.out.println(Arrays.toString(comp1));

	}

}
