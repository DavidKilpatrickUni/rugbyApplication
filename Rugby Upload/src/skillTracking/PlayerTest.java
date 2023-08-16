package skillTracking;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

//JUnit tests created to test the Player class

class PlayerTest {
	
	// Test the default constructor of the class.
	
	@Test
	void defaultConstructor() {
		
		Player player = new Player();																																// Create instance with constructor
		
		String testFirstName = null;																																// Test variable set to expected output
		
		assertEquals(testFirstName,player.getFirstName());																											// Assert that instance has no data for given method
			
	}
	
	// Test the Getter Method for retrieving first name data of an instance.

	@Test
	void getFirstName() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval 
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		String testFirstName = "Fraser";																															// Test variable set to expected output
			
		assertEquals(testFirstName,player.getFirstName());																											// Assert that instance has "Fraser" for first name
			
	}
	
	// Test the Setter Method for defining first name data of an instance.
	
	@Test
	void setFirstName() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval 
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		player.setFirstName("Allan");																																// Utilisation of method being tested - Set Player instance first name to "Allan"
		
		String testFirstName = "Allan";																																// Test variable set to expected output
		
		assertEquals(testFirstName,player.getFirstName());																											// Assert that instance has "Allan" for first name
			
	}
	
	// Test the Getter Method for retrieving last name data of an instance.
	
	@Test
	void getLastName() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval 
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		String testLastName = "Brown";																																// Test variable set to expected output
		
		assertEquals(testLastName,player.getLastName());																											// Assert that instance has "Brown" for last name		
		
	}
	
	// Test the Setter Method for defining last name data of an instance.
	
	@Test
	void setLastName() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		player.setLastName("Dell");																																	// Utilisation of method being tested - Set Player instance last name to "Allan"
		
		String testLastName = "Dell";																																// Test variable set to expected output
		
		assertEquals(testLastName,player.getLastName());																											// Assert that instance has "Dell" for last name	
		
	}
	
	// Test the Getter Method for retrieving full name data of an instance.
	
	@Test
	void getFullName() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		String testFullName = "Fraser Brown";																														// Test variable set to expected output
		
		assertEquals(testFullName,player.getFullName());																											// Assert that instance has "Fraser Brown" for full name
		
	}
	
	// Test the Getter Method for retrieving age band data of an instance.
	
	@Test
	void getTeamAgeBracket() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		TeamAgeBracket testTeamAgeBracket = TeamAgeBracket.SENIOR;																									// Test variable set to expected output
		
		assertEquals(testTeamAgeBracket,player.getTeamAgeBracket());																								// Assert that instance has "SENIOR" for age band
		
	}
	
	// Test the Setter Method for defining age band data of an instance.
	
	@Test
	void setTeamAgeBracket() {
				
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		player.setTeamAgeBracket(TeamAgeBracket.U12);																												// Utilisation of method being tested - Set Player instance age band to "U12"
		
		TeamAgeBracket testTeamAgeBracket = TeamAgeBracket.U12;																										// Test variable set to expected output
		
		assertEquals(testTeamAgeBracket,player.getTeamAgeBracket());																								// Assert that instance has "U12" for age band
		
	}
	
	// Test the Getter Method for retrieving memberID data of an instance.
	
	@Test
	void getMemberID() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		String testMemberID = "Player1";																															// Test variable set to expected output
		
		assertEquals(testMemberID,player.getMemberID());																											// Assert that instance has "Player1" for memberID
		
	}
	
	// Test the Setter Method for defining memberID data of an instance.
	
	@Test
	void setMemberID() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		player.setMemberID("Player15");																																// Utilisation of method being tested - Set Player instance memberID to "Player15"
			
		String testMemberID = "Player15";																															// Test variable set to expected output
		
		assertEquals(testMemberID,player.getMemberID());																											// Assert that instance has "Player15" for memberID
		
	}
	
	// Test the Getter Method for retrieving position data of an instance.
	
	@Test
	void getPosition() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		Position testPosition = Position.HOOKER;																													// Test variable set to expected output
		
		assertEquals(testPosition,player.getPosition());																											// Assert that instance has "HOOKER" for position
		
	}
	
	// Test the Getter Method for retrieving position data as a String of an instance.
	
	@Test
	void getStringPosition() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		String testPosition = "HOOKER";																																// Test variable set to expected output
		
		assertEquals(testPosition,player.getStringPosition());																										// Assert that instance has "HOOKER" for position
		
	}
	
	// Test the Setter Method for defining memberID data of an instance.
	
	@Test
	void setPosition() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		player.setPosition(Position.CENTRE);																														// Utilisation of method being tested - Set Player instance position to "CENTRE"
		
		Position testPosition = Position.CENTRE;																													// Test variable set to expected output
		
		assertEquals(testPosition,player.getPosition());																											// Assert that instance has "CENTRE" for position
		
	}
	
	// Test the Getter Method for retrieving profile date data of an instance.
	
	@Test
	void getProfileDate() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		String testProfileDate = "12:00";																															// Test variable set to expected output
		
		assertEquals(testProfileDate,player.getProfileDate());																										// Assert that instance has "12:00" for profile date
		
	}
	
	// Test the Setter Method for defining profile date data of an instance.
	
	@Test
	void setProfileDate() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		player.setProfileDate("17:30");																																// Utilisation of method being tested - Set Player instance profile date to "17:30"
		
		String testProfileDate = "17:30";																															// Test variable set to expected output
		
		assertEquals(testProfileDate,player.getProfileDate());																										// Assert that instance has "17:30" for profile date
		
	}
	
	// Test the toString method of an instance.
	
	@Test
	void getToString() {
		
		Model model = new Model();																																	// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());		// Set variable to instance of Player
		
		String testToString = "Fraser Brown";																														// Test variable set to expected output
		
		assertEquals(testToString,player.toString());																												// Assert that instance has "Fraser Brown" for toString override
		
	}
	
	// Remediation
	// Test the Getter Method for retrieving list of skill categories data of an instance.
	
	@Test
	void getCategories() {
		
		Model model = new Model();																																					// Set variable to instance of Model for data retrieval
		
		ArrayList<SkillCategory> myCategories = new ArrayList<SkillCategory>();																										// ArrayList variable to store a list of skill categories for a player.
		
		ArrayList<Skill> myPassing = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill standard = new Skill("Standard",3);																																	// Create new Skill instance with relevant information.
		myPassing.add(standard);																																					// Add instance of Skill to new skill ArrayList.
		Skill pop = new Skill("Pop",3);																																				// Create new Skill instance with relevant information.
		myPassing.add(pop);																																							// Add instance of Skill to new skill ArrayList.
		Skill spin = new Skill("Spin",3);																																			// Create new Skill instance with relevant information.
		myPassing.add(spin);																																						// Add instance of Skill to new skill ArrayList.
		
		SkillCategory passing = new SkillCategory("Passing",myPassing,"Passing comments");																							// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(passing);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
		
		ArrayList<Skill> myTackling = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill front = new Skill("Front",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(front);																																						// Add instance of Skill to new skill ArrayList.
		Skill rear = new Skill("Rear",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(rear);																																						// Add instance of Skill to new skill ArrayList.
		Skill side = new Skill("Side",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(side);																																						// Add instance of Skill to new skill ArrayList.
		Skill scrabble = new Skill("Scrabble",3);																																	// Create new Skill instance with relevant information.
		myTackling.add(scrabble);																																					// Add instance of Skill to new skill ArrayList.
		
		SkillCategory tackling = new SkillCategory("Tackling",myTackling,"Tackling comments");																						// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(tackling);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
	
		ArrayList<Skill> myKicking = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill drop = new Skill("Drop",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(drop);																																						// Add instance of Skill to new skill ArrayList.
		Skill punt = new Skill("Punt",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(punt);																																						// Add instance of Skill to new skill ArrayList.
		Skill grubber = new Skill("Grubber",3);																																		// Create new Skill instance with relevant information.
		myKicking.add(grubber);																																						// Add instance of Skill to new skill ArrayList.
		Skill goal = new Skill("Goal",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(goal);																																						// Add instance of Skill to new skill ArrayList.
		
		SkillCategory kicking = new SkillCategory("Kicking",myKicking,"Kicking comments");																							// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(kicking);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", myCategories);							// Set variable to instance of Player
		
		ArrayList<SkillCategory> testList = myCategories;																															// Test variable set to expected output
		
		assertEquals(testList,player.getSkillCategories());																															// Assert that instance has same list 																											
	}
	
	// Remediation
	// Test the Setter Method for defining list of skill categories data of an instance.
	
	@Test
	void setCategories() {
		
		Model model = new Model();																																					// Set variable to instance of Model for data retrieval
		
		ArrayList<SkillCategory> myCategories = new ArrayList<SkillCategory>();																										// ArrayList variable to store a list of skill categories for a player.
		
		ArrayList<Skill> myPassing = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill standard = new Skill("Standard",3);																																	// Create new Skill instance with relevant information.
		myPassing.add(standard);																																					// Add instance of Skill to new skill ArrayList.
		Skill pop = new Skill("Pop",3);																																				// Create new Skill instance with relevant information.
		myPassing.add(pop);																																							// Add instance of Skill to new skill ArrayList.
		Skill spin = new Skill("Spin",3);																																			// Create new Skill instance with relevant information.
		myPassing.add(spin);																																						// Add instance of Skill to new skill ArrayList.
		
		SkillCategory passing = new SkillCategory("Passing",myPassing,"Passing comments");																							// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(passing);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
		
		ArrayList<Skill> myTackling = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill front = new Skill("Front",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(front);																																						// Add instance of Skill to new skill ArrayList.
		Skill rear = new Skill("Rear",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(rear);																																						// Add instance of Skill to new skill ArrayList.
		Skill side = new Skill("Side",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(side);																																						// Add instance of Skill to new skill ArrayList.
		Skill scrabble = new Skill("Scrabble",3);																																	// Create new Skill instance with relevant information.
		myTackling.add(scrabble);																																					// Add instance of Skill to new skill ArrayList.
		
		SkillCategory tackling = new SkillCategory("Tackling",myTackling,"Tackling comments");																						// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(tackling);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
	
		ArrayList<Skill> myKicking = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill drop = new Skill("Drop",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(drop);																																						// Add instance of Skill to new skill ArrayList.
		Skill punt = new Skill("Punt",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(punt);																																						// Add instance of Skill to new skill ArrayList.
		Skill grubber = new Skill("Grubber",3);																																		// Create new Skill instance with relevant information.
		myKicking.add(grubber);																																						// Add instance of Skill to new skill ArrayList.
		Skill goal = new Skill("Goal",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(goal);																																						// Add instance of Skill to new skill ArrayList.
		
		SkillCategory kicking = new SkillCategory("Kicking",myKicking,"Kicking comments");																							// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(kicking);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", null);									// Set variable to instance of Player
		
		player.setSkillCategories(myCategories);																																	// Utilisation of method being tested - Set Player instance ArrayList to list
		
		ArrayList<SkillCategory> testList = myCategories;																															// Test variable set to expected output
		
		assertEquals(testList,player.getSkillCategories());																															// Assert that instance has same list 
	}
	
	// Remediation
	// Test the Getter Method for retrieving a specific valid category from skill categories list data of an instance.
	
	@Test
	void getCategory() {
		
		Model model = new Model();																																					// Set variable to instance of Model for data retrieval
		
		ArrayList<SkillCategory> myCategories = new ArrayList<SkillCategory>();																										// ArrayList variable to store a list of skill categories for a player.
		
		ArrayList<Skill> myPassing = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill standard = new Skill("Standard",3);																																	// Create new Skill instance with relevant information.
		myPassing.add(standard);																																					// Add instance of Skill to new skill ArrayList.
		Skill pop = new Skill("Pop",3);																																				// Create new Skill instance with relevant information.
		myPassing.add(pop);																																							// Add instance of Skill to new skill ArrayList.
		Skill spin = new Skill("Spin",3);																																			// Create new Skill instance with relevant information.
		myPassing.add(spin);																																						// Add instance of Skill to new skill ArrayList.
		
		SkillCategory passing = new SkillCategory("Passing",myPassing,"Passing comments");																							// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(passing);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
		
		ArrayList<Skill> myTackling = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill front = new Skill("Front",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(front);																																						// Add instance of Skill to new skill ArrayList.
		Skill rear = new Skill("Rear",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(rear);																																						// Add instance of Skill to new skill ArrayList.
		Skill side = new Skill("Side",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(side);																																						// Add instance of Skill to new skill ArrayList.
		Skill scrabble = new Skill("Scrabble",3);																																	// Create new Skill instance with relevant information.
		myTackling.add(scrabble);																																					// Add instance of Skill to new skill ArrayList.
		
		SkillCategory tackling = new SkillCategory("Tackling",myTackling,"Tackling comments");																						// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(tackling);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
	
		ArrayList<Skill> myKicking = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill drop = new Skill("Drop",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(drop);																																						// Add instance of Skill to new skill ArrayList.
		Skill punt = new Skill("Punt",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(punt);																																						// Add instance of Skill to new skill ArrayList.
		Skill grubber = new Skill("Grubber",3);																																		// Create new Skill instance with relevant information.
		myKicking.add(grubber);																																						// Add instance of Skill to new skill ArrayList.
		Skill goal = new Skill("Goal",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(goal);																																						// Add instance of Skill to new skill ArrayList.
		
		SkillCategory kicking = new SkillCategory("Kicking",myKicking,"Kicking comments");																							// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(kicking);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", myCategories);							// Set variable to instance of Player
		
		SkillCategory testList = myCategories.get(1);																																// Test variable set to expected output
		
		assertEquals(testList,player.getSkillCategories("Tackling"));																												// Assert that instance has same category 
	}
	
	// Remediation
	// Test the Getter Method for retrieving a specific invalid category from skill categories list data of an instance.
	
	@Test
	void getCategoryFail() {
		
		Model model = new Model();																																					// Set variable to instance of Model for data retrieval
		
		ArrayList<SkillCategory> myCategories = new ArrayList<SkillCategory>();																										// ArrayList variable to store a list of skill categories for a player.
		
		ArrayList<Skill> myPassing = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill standard = new Skill("Standard",3);																																	// Create new Skill instance with relevant information.
		myPassing.add(standard);																																					// Add instance of Skill to new skill ArrayList.
		Skill pop = new Skill("Pop",3);																																				// Create new Skill instance with relevant information.
		myPassing.add(pop);																																							// Add instance of Skill to new skill ArrayList.
		Skill spin = new Skill("Spin",3);																																			// Create new Skill instance with relevant information.
		myPassing.add(spin);																																						// Add instance of Skill to new skill ArrayList.
		
		SkillCategory passing = new SkillCategory("Passing",myPassing,"Passing comments");																							// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(passing);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.	
		
		ArrayList<Skill> myTackling = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.																														
				
		Skill front = new Skill("Front",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(front);																																						// Add instance of Skill to new skill ArrayList.
		Skill rear = new Skill("Rear",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(rear);																																						// Add instance of Skill to new skill ArrayList.
		Skill side = new Skill("Side",3);																																			// Create new Skill instance with relevant information.
		myTackling.add(side);																																						// Add instance of Skill to new skill ArrayList.
		Skill scrabble = new Skill("Scrabble",3);																																	// Create new Skill instance with relevant information.
		myTackling.add(scrabble);																																					// Add instance of Skill to new skill ArrayList.
		
		SkillCategory tackling = new SkillCategory("Tackling",myTackling,"Tackling comments");																						// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(tackling);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.	
	
		ArrayList<Skill> myKicking = new ArrayList<Skill>();																														// ArrayList variable to store skills within one category.
		
		Skill drop = new Skill("Drop",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(drop);																																						// Add instance of Skill to new skill ArrayList.
		Skill punt = new Skill("Punt",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(punt);																																						// Add instance of Skill to new skill ArrayList.
		Skill grubber = new Skill("Grubber",3);																																		// Create new Skill instance with relevant information.
		myKicking.add(grubber);																																						// Add instance of Skill to new skill ArrayList.
		Skill goal = new Skill("Goal",3);																																			// Create new Skill instance with relevant information.
		myKicking.add(goal);																																						// Add instance of Skill to new skill ArrayList.
		
		SkillCategory kicking = new SkillCategory("Kicking",myKicking,"Kicking comments");																							// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
		myCategories.add(kicking);																																					// Add instance of Skill Category to the created skill category ArrayList for the given player.	
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", myCategories);							// Set variable to instance of Player
		
		SkillCategory testList = null;																																				// Test variable set to expected output
		
		assertEquals(testList,player.getSkillCategories("Diving"));																													// Assert that instance has no category by that name
	}
	
	// Test to confirm instances could be created and be allocated a skill list.
	
	@Test
	void categoryPopulation() {
		
		Model model = new Model();																																					// Set variable to instance of Model for data retrieval
		
		Player player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());						// Set variable to instance of Player						
		
		int listSize = player.getSkillCategories().size();																															// Set variable to size of ArrayList
		
		assertEquals(3,listSize);																																					// Assert that ArrayList size is 3
	}
	
	// Test to confirm instances could be created and added to Model ArrayList.
	
	@Test
	void memberArrayListPopulation() {
		
		Model model = new Model();																																					// Set variable to instance of Model for data retrieval 
		
		model.allMembers.clear();																																					// Remove all current instances in the ArrayList
		
		Player player;																																								// Variable to store instances
		
		player = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.HOOKER, "12:00", createTestSkills());							// Set variable to instance of Player
		model.allMembers.add(player);																																				// Add instance to ArrayList
		
		player = new Player("Ben", "Toolis", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.LOCK, "12:00", createTestSkills());								// Set variable to instance of Player
		model.allMembers.add(player);																																				// Add instance to ArrayList
		
		player = new Player("Grant", "Gilchrist", TeamAgeBracket.SENIOR,"Player"+(model.allMembers.size()+1),Position.LOCK, "12:00", createTestSkills());							// Set variable to instance of Player
		model.allMembers.add(player);																																				// Add instance to ArrayList

		int listSize = model.allMembers.size();																																		// Set variable to size of ArrayList
		
		assertEquals(3,listSize);																																					// Assert that ArrayList size is 3
	}
	
	// Copy of method use in the model for skill list creation. Used to give Player instances an ArrayList of skill categories, with each category populated with a list of skills. Used as a parameter 
	// in overloaded constructor for class.
	
	// Documentation of createTestSkills()
	//
	// Each skill category creation goes through same process. Only variable names and input data changes.
	//
	// 1. Create an ArrayList to contain the players list of all skill categories.
	// 2. Create an ArrayList for a 1 skill category to hold skills.
	// 3a. Create a skill and add that skill to the created 1 skill category ArrayList.
	// 3b. Step 3a can be repeated to increase the skills in 1 skill category.
	// 5. Create a new Skill category instance, give it a name and comment plus the created ArrayList of 1 category.
	// 6. Add the new skill category to the ArrayList of the players all skill categories.
	/*
	 * 
	ArrayList<SkillCategory> allCategories = new ArrayList<SkillCategory>();																	// ArrayList variable to store a list of skill categories for a player.
	
	ArrayList<Skill> newCategory = new ArrayList<Skill>();																						// ArrayList variable to store skills within one category.
	
	Skill skill1 = new Skill("nameOfSkill",rating);																								// Create new Skill instance with relevant information.
	newCategory.add(skill1);																													// Add instance of Skill to new skill ArrayList.
	Skill skill2 = new Skill("nameOfSkill",rating);																								// Create new Skill instance with relevant information.
	newCategory.add(skill2);																													// Add instance of Skill to new skill ArrayList.
	Skill skill3 = new Skill("nameOfSkill",rating);																								// Create new Skill instance with relevant information.
	newCategory.add(skill3);																													// Add instance of Skill to new skill ArrayList.
	
	SkillCategory newCategory = new SkillCategory("nameOfCategory",newCategory,"Comment");														// Create new Skill Category instance with relevant information. Using the created ArrayList of Skill instances.
	allCategories.add(nameOfCategory);																											// Add instance of Skill Category to the created skill category ArrayList for the given player.	
	
	return allCategories;																														// Return the completed ArrayList to be used as a parameter in player creation.
	*/
	
	private ArrayList<SkillCategory> createTestSkills() {
		
		ArrayList<SkillCategory> myCategories = new ArrayList<SkillCategory>();
		
		ArrayList<Skill> myPassing = new ArrayList<Skill>();
		
		Skill standard = new Skill("Standard",3);
		myPassing.add(standard);
		Skill pop = new Skill("Pop",3);
		myPassing.add(pop);
		Skill spin = new Skill("Spin",3);
		myPassing.add(spin);
		
		SkillCategory passing = new SkillCategory("Passing",myPassing,"Passing comments");
		myCategories.add(passing);
		
		ArrayList<Skill> myTackling = new ArrayList<Skill>();
		
		Skill front = new Skill("Front",3);
		myTackling.add(front);
		Skill rear = new Skill("Rear",3);
		myTackling.add(rear);
		Skill side = new Skill("Side",3);
		myTackling.add(side);
		Skill scrabble = new Skill("Scrabble",3);
		myTackling.add(scrabble);
		
		SkillCategory tackling = new SkillCategory("Tackling",myTackling,"Tackling comments");
		myCategories.add(tackling);
	
		ArrayList<Skill> myKicking = new ArrayList<Skill>();
		
		Skill drop = new Skill("Drop",3);
		myKicking.add(drop);
		Skill punt = new Skill("Punt",3);
		myKicking.add(punt);
		Skill grubber = new Skill("Grubber",3);
		myKicking.add(grubber);
		Skill goal = new Skill("Goal",3);
		myKicking.add(goal);
		
		SkillCategory kicking = new SkillCategory("Kicking",myKicking,"Kicking comments");
		myCategories.add(kicking);
		
		return myCategories;
	}

}
