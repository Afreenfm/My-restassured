package APITest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2_testNG {
	@BeforeClass
	public void BC()
	{
		System.out.println("my secongd class");
	}
	@BeforeMethod
	public void BM()
	{
		System.out.println("before method");
	}
	@Test
	public void testcase3()
	{
		System.out.println("third testcase");
	}
	 @AfterTest
	 public void AT()
	 {
		 System.out.println("AT will execute after all the test");
	 }
	 @AfterSuite
	 public void AS()
	 {
		 System.out.println("AS this will execute at the end");
	 }

}
