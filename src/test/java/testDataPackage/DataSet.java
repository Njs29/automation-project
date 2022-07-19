package testDataPackage;

import org.testng.annotations.DataProvider;

public class DataSet {

	@DataProvider(name = "registrationData")
	public static Object dataset() {
		// currently Data set contain only for two user but You can add as many as you
		// want
		// need to update email only for every run for every user
		Object[][] obj = {
				{ "johnKanir105@gmalla.com", "John", "Kanir", "testpass123@", "12", "7", "2000", "AdventureSports",
						"87 Nickel Road", "2661 Kennedy Court", "Kentucky", "6", "41002", "21",
						"Take first left after Jr. school", "774-280-5944", "606-402-2834", " My address" },
				{ "jacyjane105@dffda.com", "Jacy", "Jane", "@testpass123", "28", "5", "1990", "Market Basket",
						"2358 Barfield Lane", "Indianapolis", "Indiana", "12", "55555", "21",
						"Take first Right after KFC", "317-529-7499", "317-425-8779", " My address" } };
		return obj;

	}

	// currently Data set contain only for two valid registered user but You can add
	// as many as you
	// need to be update email only for every run for every run
	@DataProvider(name = "userInfo")
	public static Object emailset() {
		Object[][] obj = { { "johnKanir105@gmalla.com", "testpass123@", "Call before knock the door" },
				{ "jacyjane105@dffda.com", "@testpass123", "Be aware about dog" } };
		return obj;

	}

}
