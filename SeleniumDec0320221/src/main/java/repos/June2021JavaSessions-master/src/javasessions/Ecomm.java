package javasessions;

import java.util.ArrayList;

public class Ecomm {

	// WAF -- >
	// create a function
	// input: productName (String)
	// return: list of sellers --> ArrayList<String>

	public ArrayList<String> getSellerList(String productName) {
		System.out.println("product name is : " + productName);
		
		ArrayList<String> sellerList = new ArrayList<String>();
		
		if (productName.equals("MacBook Pro")) {
			sellerList.add("Neon Enterprise");
			sellerList.add("xyz Enterprise");
			sellerList.add("IT Enterprise");
		}
		else if (productName.equals("Tshirt")) {
			sellerList.add("Myntra Enterprise");
			sellerList.add("Ajio Enterprise");
		}
		else if (productName.equals("XBox")) {
			sellerList.add("xoom enterprise, new delhi");
			sellerList.add("maddy IT games, banaglore");
		} else {
			System.out.println(productName + " is not found.....");
		}

		return sellerList;

	}

	public static void main(String[] args) {
		Ecomm obj = new Ecomm();
		ArrayList<String> macSellerList = obj.getSellerList("MacBook Pro");
		System.out.println(macSellerList);
		
		ArrayList<String> nikeSellerList = obj.getSellerList("Nike shoes");
		System.out.println(nikeSellerList);
		
		
		
		
	}

}
