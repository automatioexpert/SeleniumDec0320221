package com.testcases;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomeListener extends RunListener {
	
	private FileWriter wrtie = null;
	
	@Override
	public void testRunStarted(Description description) throws Exception {
		try {
			wrtie = new FileWriter("CustomerLogger.log");
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.testRunStarted(description);
	}
	
	@Override
	public void testStarted(Description description) throws Exception {
		wrtie.write(description.getMethodName() + " Started its Execution" + "\n");
		super.testStarted(description);
	}
	
	@Override
	public void testFinished(Description description) throws Exception {
		wrtie.write(description.getMethodName() + " Finished its Execution" + "\n");
		wrtie.write("======================================================" + "\n");
		super.testFinished(description);
	}
	
	@Override
	public void testFailure(Failure failure) throws Exception {
		wrtie.write(failure.getTestHeader() + "\n");
		wrtie.write(failure.getMessage() + "\n");
		wrtie.write(failure.getTrace() + "\n");
		super.testFailure(failure);
	}
	
	@Override
	public void testRunFinished(Result result) throws Exception {
		try {
			if(wrtie != null)
				wrtie.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.testRunFinished(result);
	}

}
