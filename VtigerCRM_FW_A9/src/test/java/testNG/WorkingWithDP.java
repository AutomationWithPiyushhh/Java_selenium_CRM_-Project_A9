package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkingWithDP {

	@Test(dataProvider = "getData")
	public void writeNames(Object firstname , Object lastname) {
		System.out.println(firstname + " " + lastname);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] students = new Object[5][2];
//										[row][column]
//										row -> number of executions
//										col -> number of parameters
		students[0][0] = "Abhishek";
		students[0][1] = 123;

		students[1][0] = "Banshika";
		students[1][1] = "Vasisth";

		students[2][0] = "Chinu";
		students[2][1] = "Chaudhary";

		students[3][0] = "Divyanshu";
		students[3][1] = "Yadav";

		students[4][0] = "Zahid";
		students[4][1] = "Khan";

		return students;
	}
}
