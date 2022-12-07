package com.reflection;

public class ReflectionClass {

	int id = 0;
	private String private_name = "";
	protected String protected_name = "";
	public String public_name = "";

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	private String getPrivate_name() {
		return private_name;
	}

	private void setPrivate_name(String private_name) {
		this.private_name = private_name;
	}

	protected String getProtected_name() {
		return protected_name;
	}

	protected void setProtected_name(String protected_name) {
		this.protected_name = protected_name;
	}

	public String getPublic_name() {
		return public_name;
	}

	public void setPublic_name(String public_name) {
		this.public_name = public_name;
	}

}
