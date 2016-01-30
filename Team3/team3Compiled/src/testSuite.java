import java.util.Enumeration;

import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Created by CLambrec on 30/01/2016.
 */
public class testSuite {

    public static void main (String[] args) throws Exception {
        Test suite = suite();
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("Test was succesfull: " + result.wasSuccessful());
        System.out.println("Run Tests: " + result.runCount());
        System.out.println("Error Tests: " + result.errorCount());
        Enumeration<TestFailure> errors = result.errors();
        while (errors.hasMoreElements()) {
            System.out.println(errors.nextElement().failedTest().toString());
        }

        System.out.println("Failed Tests: " + result.failureCount());
        Enumeration<TestFailure> fails = result.failures();
        while (fails.hasMoreElements()) {
            System.out.println(fails.nextElement().failedTest().toString());
        }
    }

    public static Test suite() {
        TestSuite suite = new TestSuite("Circuite Tests");

        suite.addTestSuite(BreakingAPIV1.class);

        return suite;
    }
}
