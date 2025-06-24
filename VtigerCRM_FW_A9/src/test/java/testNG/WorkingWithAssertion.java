package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithAssertion {
	@Test
	public void WorkingWithAssert() {

		boolean status1 = "abc".equals("abc");
		boolean status2 = "abc".equals("xyz");

//		Assert.assertTrue(status1);
//		Assert.assertFalse(status2);
//
//		Assert.assertFalse(false);
//		Assert.assertTrue(true);

		String a = "abc";
		String b = "abc";
		String c = "xyz";

//		Assert.assertEquals("abc","abc");
//		Assert.assertNotEquals(a, b);

		Object obj1 = null;
		Object obj2 = new Object();

//		Assert.assertNull(obj1);
//		Assert.assertNotNull(obj2);

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status1);
		sa.assertFalse(status2);
		sa.assertEquals(a, b);
		sa.assertNotEquals(a, b);
		sa.assertNull(obj1);
		sa.assertNotNull(obj2);

		System.out.println("Got Executed");

//		sa.assertAll();
	}
}
