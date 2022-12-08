package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		Map<String, Object> test1=new HashMap<>();
		test1.put("name", "test1");
		test1.put("count", "5");
		test1.put("enabled", false);
		
		Map<String, Object> test2=new HashMap<>();
		test2.put("name", "test2");
		test2.put("count", "2");
		test2.put("enabled", true);
		
		List<Map<String, Object>> list=new ArrayList<>();
		list.add(test1);
		list.add(test2);
		
		for (int i = 0; i <list.size(); i++) {
			if (testMethod.getName().equalsIgnoreCase(String.valueOf(list.get(i).get("name")))) {
				if (list.get(i).get("enabled").equals(false)) {
					annotation.setEnabled(false);
				}
				else {
					//annotation.setInvocationCount(Integer.parseInt((String) list.get(i).get("count")));
					annotation.setRetryAnalyzer(RetryAnalyzer.class);
				}
			}
		}
	}

}
