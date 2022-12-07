package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestReflection {

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class cls = Class.forName("com.reflection.ReflectionClass"); //step - 1
		Object obj = cls.newInstance(); //step - 2
		
		Method set_private = cls.getDeclaredMethod("setPrivate_name", String.class); //step - 3
		set_private.setAccessible(true); // step - 4
		set_private.invoke(obj, "Private Data Member - 1");
		
		Field private_name = cls.getDeclaredField("private_name");
		private_name.setAccessible(true);
		System.out.println("Value : " + private_name.get(obj));
		
		/*Method get_private = cls.getDeclaredMethod("getPrivate_name", null);
		get_private.setAccessible(true);
		System.out.println("Value :  " + get_private.invoke(obj, null));
		
		Method set_protected = cls.getDeclaredMethod("setProtected_name", String.class);
		set_protected.setAccessible(true);
		set_protected.invoke(obj, "Protected Data Memeber");
		
		Method get_protected = cls.getDeclaredMethod("getProtected_name", null);
		get_protected.setAccessible(true);
		System.out.println("Value : " + get_protected.invoke(obj, null));
		
		Method set_public = cls.getMethod("setPublic_name", String.class);
		set_public.invoke(obj, "Public data Memeber");
		
		Method get_public = cls.getMethod("getPublic_name", null);
		System.out.println("Value : " + get_public.invoke(obj, null));*/
		
		
	

	}

}
