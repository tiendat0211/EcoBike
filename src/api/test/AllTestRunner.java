package api.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AllTestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTest.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println("All Test Case are " + result.wasSuccessful());

	}

}
