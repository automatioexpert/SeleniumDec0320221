package com.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IterateOverHashMap {

	public static void main(String[] args) {

		Map<String, Double> employeeSalary = new HashMap<String, Double>();
		employeeSalary.put("Rajesh", 1000.50);
		employeeSalary.put("Mahesh", 2000.50);
		employeeSalary.put("Durgesh", 300.50);
		employeeSalary.put("Kalpesh", 1300.00);
		employeeSalary.put("Ganesh", 3000.00);

		// using for each
		employeeSalary.forEach((employee, salary) -> {
			System.out.println(employee + " --> " + salary);
		});

		// using entry set and iterator
		System.out.println("using entry set and iterator");
		Set<Entry<String, Double>> entrySet = employeeSalary.entrySet();
		Iterator<Entry<String, Double>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, Double> entry = iterator.next();
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}

		System.out.println("entry set and for each loop");
		employeeSalary.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		});

		System.out.println("key set and for each loop");
		employeeSalary.keySet().forEach(employee -> {
			System.out.println(employee + " --> " + employeeSalary.get(employee));
		});

		System.out.println("using for loop");
		for (Entry<String, Double> entry : employeeSalary.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}

		System.out.println("using key set and iterator");
		Set<String> keySet = employeeSalary.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + "-->" + employeeSalary.get(key));
		}
	}

}
