package extra;

import org.testng.annotations.Test;

public class Demo2 {
	
	@Test(groups = "smoke")
	public void case1() {
		System.out.println("1");
	}
	
	@Test(groups = "regression")
	public void case2() {
		System.out.println("2");
		
	}
	
	@Test(groups = "regression")
	public void case3() {
		System.out.println("3");
		
	}
	
	@Test(groups = "regression")
	public void case4() {
		System.out.println("4");
		
	}
	
	@Test(groups = "regression")
	public void case5() {
		System.out.println("5");
		
	}
	
	
	
}
