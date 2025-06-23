package extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {

	@Test(groups = "regression")
	public void main1() {
//		System.out.println("case1");
		Reporter.log("Report vala case1", true);
	}

	@Test(groups = "regression")
	public void main2() {
		System.out.println("case2");
	}

	@Test(groups = "regression")
	public void main3() {
		System.out.println("case3");
	}

	@Test(groups = "smoke")
	public void main4() {
		System.out.println("case4");
	}

	@Test(groups = "smoke")
	public void main5() {
		System.out.println("case5");
	}

}
