package packagesAndAccessModifiers2;

public class Protection2 extends packagesAndAccessModifiers1.Protection {

	public Protection2() {
		System.out.println("Derived other package constructor");
		// This will throw compile error since the variable n is for class or
		// package only
		// System.out.println("n = " + n);
		// This will throw compile error since the variable pri_n is private to
		// the class Derived
		// System.out.println("pri_n = " + pri_n);
		System.out.println("pro_n = " + pro_n);
		System.out.println("pub_n = " + pub_n);
	}

}
