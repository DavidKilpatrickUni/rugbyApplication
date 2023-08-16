package skillTracking;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit tests created to test the Coach class

class CoachTest {
	
	// Test the default constructor of the class.
	
	@Test
	void defaultConstructor() {
		
		Coach coach = new Coach();																										// Create instance with constructor
		
		String testFirstName = null;																									// Test variable set to expected output
		
		assertEquals(testFirstName,coach.getFirstName());																				// Assert that instance has no data for given method
			
	}
	
	// Test the Getter Method for retrieving first name data of an instance.

	@Test
	void getFirstName() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		String testFirstName = "Gregor";																								// Test variable set to expected output
		
		assertEquals(testFirstName,coach.getFirstName());																				// Assert that instance has "Gregor" for first name
			
	}
	
	// Test the Setter Method for defining first name data of an instance.
	
	@Test
	void setFirstName() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		coach.setFirstName("Eddie");																									// Utilisation of method being tested - Set Coach instance first name to "Eddie"
		
		String testFirstName = "Eddie";																									// Test variable set to expected output
		
		assertEquals(testFirstName,coach.getFirstName());																				// Assert that instance has "Eddie" for first name	
			
	}
	
	// Test the Getter Method for retrieving last name data of an instance.
	
	@Test
	void getLastName() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		String testLastName = "Townsend";																								// Test variable set to expected output
		
		assertEquals(testLastName,coach.getLastName());																					// Assert that instance has "Townsend" for last name	
		
	}
	
	// Test the Setter Method for defining last name data of an instance.
	
	@Test
	void setLastName() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		coach.setLastName("Jones");																										// Utilisation of method being tested - Set Coach instance last name to "Jones"
		
		String testLastName = "Jones";																									// Test variable set to expected output
		
		assertEquals(testLastName,coach.getLastName());																					// Assert that instance has "Jones" for Last name	
		
	}
	
	// Test the Getter Method for retrieving full name data of an instance.
	
	@Test
	void getFullName() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		String testFullName = "Gregor Townsend";																						// Test variable set to expected output
		
		assertEquals(testFullName,coach.getFullName());																					// Assert that instance has "Gregor Townsend" for full name
		
	}
	
	// Test the Getter Method for retrieving age band data of an instance.
	
	@Test
	void getTeamAgeBracket() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		TeamAgeBracket testTeamAgeBracket = TeamAgeBracket.SENIOR;																		// Test variable set to expected output
		
		assertEquals(testTeamAgeBracket,coach.getTeamAgeBracket());																		// Assert that instance has "SENIOR" for age band
		
	}
	
	// Test the Setter Method for defining age band data of an instance.
	
	@Test
	void setTeamAgeBracket() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		coach.setTeamAgeBracket(TeamAgeBracket.U12);																					// Utilisation of method being tested - Set Coach instance age band to "U12"
		
		TeamAgeBracket testTeamAgeBracket = TeamAgeBracket.U12;																			// Test variable set to expected output
		
		assertEquals(testTeamAgeBracket,coach.getTeamAgeBracket());																		// Assert that instance has "U12" for age band
		
	}
	
	// Test the Getter Method for retrieving memberID data of an instance.
	
	@Test
	void getMemberID() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		String testMemberID = "Coach1";																									// Test variable set to expected output
		
		assertEquals(testMemberID,coach.getMemberID());																					// Assert that instance has "U12" for age band
		
	}
	
	// Test the Setter Method for defining memberID data of an instance.
	
	@Test
	void setMemberID() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		coach.setMemberID("Coach15");																									// Utilisation of method being tested - Set Coach instance memberID to "Coach15"
		
		String testMemberID = "Coach15";																								// Test variable set to expected output
		
		assertEquals(testMemberID,coach.getMemberID());																					// Assert that instance has "Coach15" for memberID
		
	}
	
	// Test the Getter Method for retrieving email data of an instance.
	
	@Test
	void getEmail() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		String testEmail = "online";																									// Test variable set to expected output
		
		assertEquals(testEmail,coach.getEmail());																						// Assert that instance has "online" for email
		
	}
	
	// Test the Setter Method for defining email data of an instance.
	
	@Test
	void setEmail() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		coach.setEmail("email");																										// Utilisation of method being tested - Set Coach instance email to "email"
		
		String testEmail = "email";																										// Test variable set to expected output
		
		assertEquals(testEmail,coach.getEmail());																						// Assert that instance has "email" for email
		
	}
	
	// Test the Getter Method for retrieving password data of an instance.
	
	@Test
	void getPassword() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		String testPassword = "pass";																									// Test variable set to expected output
		
		assertEquals(testPassword,coach.getPassword());																					// Assert that instance has "pass" for password
		
	}
	
	// Test the Setter Method for defining password data of an instance.
	
	@Test
	void setPassword() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
			
		coach.setPassword("password");																									// Utilisation of method being tested - Set Coach instance password to "password"
		
		String testPassword = "password";																								// Test variable set to expected output
		
		assertEquals(testPassword,coach.getPassword());																					// Assert that instance has "password" for password
		
	}
	
	// Test the toString method of an instance.
	
	@Test
	void getToString() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");		// Set variable to instance of Coach
		
		String testToString = "Gregor";																									// Test variable set to expected output
		
		assertEquals(testToString,coach.toString());																					// Assert that instance has "Gregor" for toString override
		
	}
	
	// Test to confirm instances could be created and added to Model ArrayList.
	
	@Test
	void coachArrayListPopulation() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach;																													// Variable to store instances
		
		model.allCoaches.clear();																										// Remove all current instances in the ArrayList
		
		coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");			// Set variable to instance of Coach
		model.allCoaches.add(coach);																									// Add instance to ArrayList
		
		coach = new Coach("Eddie", "Jones", TeamAgeBracket.U16,"Coach"+(model.allMembers.size()+1), "email", "access");					// Set variable to instance of Coach
		model.allCoaches.add(coach);																									// Add instance to ArrayList
		
		coach = new Coach("Warren", "Gatland", TeamAgeBracket.U13,"Coach"+(model.allMembers.size()+1), "internet", "valid");			// Set variable to instance of Coach
		model.allCoaches.add(coach);																									// Add instance to ArrayList
		
		int listSize = model.allCoaches.size();																							// Set variable to size of ArrayList
		
		assertEquals(3,listSize);																										// Assert that ArrayList size is 3
	}
	
	// Test to confirm instances could be created and added to Model ArrayList.
	
	@Test
	void memberArrayListPopulation() {
		
		Model model = new Model();																										// Set variable to instance of Model for data retrieval 
		
		Coach coach;																													// Variable to store instances
		
		model.allMembers.clear();																										// Remove all current instances in the ArrayList
		
		coach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(model.allMembers.size()+1), "online", "pass");			// Set variable to instance of Coach
		model.allMembers.add(coach);																									// Add instance to ArrayList
		
		coach = new Coach("Eddie", "Jones", TeamAgeBracket.U16,"Coach"+(model.allMembers.size()+1), "email", "access");					// Set variable to instance of Coach
		model.allMembers.add(coach);																									// Add instance to ArrayList
		
		coach = new Coach("Warren", "Gatland", TeamAgeBracket.U13,"Coach"+(model.allMembers.size()+1), "internet", "valid");			// Set variable to instance of Coach
		model.allMembers.add(coach);																									// Add instance to ArrayList
		
		int listSize = model.allMembers.size();																							// Set variable to size of ArrayList
		
		assertEquals(3,listSize);																										// Assert that ArrayList size is 3
	}
	
}
