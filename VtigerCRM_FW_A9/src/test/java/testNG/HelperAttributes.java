package testNG;

import org.testng.annotations.Test;

public class HelperAttributes {
	@Test
	public void createCity() {
		System.out.println("Creating NOIDA");
	}
	
	@Test(dependsOnMethods = "createCity")
	public void modifyCity() {
		System.out.println("Changing it to GREATER NOIDA");
	}
	
	@Test(dependsOnMethods = "modifyCity")
	public void deleteCity() {
		System.out.println("Deleting GREATER NOIDA");
	}
	
	
}

