package APITest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_TestNG {
	//before running any class/test if u want to run then v can use before suite
	//it can have a configuration//cannot have test 
	@BeforeSuite
	 public void BS()
	 {
		 System.out.println("BS going to execute before any test");
	 }
	 @BeforeTest
	 public void BT()
	 {
		 System.out.println("BT  will run after test suite");
	 }
	 @BeforeClass
	 public void BC()
	 {
		 System.out.println("BC  will execute before class");
	 }
	 @BeforeMethod
	 public void BM()
	 {
		 System.out.println("BM will execute before every test");
	 }
	 @Test
	 public void testcase1() {
	 System.out.println("this is first testcase");
	 }
	/* @Test
	 public void getboard{
		 String url = "https://trello.com";
		 ().baseUri(url).when().get("/").prettyPrint();
		 }*/
	 @Test
	 public void testcase2()
	 {
		 System.out.println("this is second testcase");
		Assert.assertEquals("Afreen", "Afreen");
	 }
	 @AfterMethod
	 public void AM()
	 {
		 System.out.println("AM will execute After each test");
	 }
	 @AfterClass
	 public void AC()
	 {
		 System.out.println("AC will execute after class");
	 }
	
}
