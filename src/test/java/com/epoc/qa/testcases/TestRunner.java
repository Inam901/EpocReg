package com.epoc.qa.testcases;

import org.testng.TestNG;

public class TestRunner {
	
	static TestNG testNg;

	//@SuppressWarnings("deprication")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ExtentReportListener ext =new ExtentReportListener();
		
		testNg = new TestNG();
		
		testNg.setTestClasses(new Class[] {ChiropractorRegTest.class});
		testNg.run();

	}

}
