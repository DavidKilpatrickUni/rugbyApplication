package skillTracking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.HashMap;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Class

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Model part of the MVC structure.
 * </p>
 * <p>
 * Storing data and variables for the <code>Controller</code> to access to present to the user through the <code>View</code>.
 * </p>
 * <p>
 * Is used for data generation through serialisation or methods and then storing said data.
 * </p>
 * <p>
 * First checks if serialisation files exist.
 * <br>If true deserialises these files
 * <br>If false runs a method to generate stock members necessary for the demonstration and testing of the program, creating new serialisation files in the process.
 * </p>
 * 
 * @author David Kilpatrick
 * @version 1.0
 * @since 17/04/2020
 *
 * @see Controller 
 * @see java.io.Serializable
 * @see ArrayList
 * @see HashMap
 */

public class Model implements java.io.Serializable{
	
	// Variables

	public ArrayList<Member> allMembers = new ArrayList<Member>();									// ArrayList of Member variable to store all members types at the rugby club.			
	public ArrayList<Squad> allSquads = new ArrayList<Squad>();										// ArrayList of Squad variable to store all squads at the rugby club.	
	public ArrayList<Coach> allCoaches = new ArrayList<Coach>();									// ArrayList of Coach variable to store all coaches at the rugby club.		
	public transient HashMap<String, String> loginDetails = new HashMap<String, String>();			// HashMap of String and String to store an account name and password for account login details. Transient for security reasons as it contains a password
																									// Is a temporary method for storing login accounts to use with Skill tracking program. Provides a set list that can be defined and
																									// is separate from other member details.
	
	
	public Coach currentUser;																		// Variable to store current account that is logged into the program. An instance of Coach.
	
	// Constructors
	
	// Default
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>Model</code> class. 
	 * </p>
	 * <p>
	 * Runs a method that determines what data the <code>Model</code> shall contain and store.
	 * </p>
	 * 
	 * @see Model	
	 */
	
	public Model() {
		
		dataGen();	
		
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Determines what data the <code>Model</code> shall contain and store.
	 * </p>
	 * 
	 * <p> 
	 * Used to check for the existence of serialisation files.
	 * <br> If true deserialises the files using methods.
	 * <br> If false generates stock data the program requires using methods and creates serialisation files.
	 * </p>
	 * 
	 * @see Model
	 */
	
	private void dataGen() {																				

		boolean exists;																						// Variable to store a file exist check. 
		
		File tmpDir = new File("logins.ser");																// File variable to store expected file name.														
		exists = tmpDir.exists();																			// Sets variable to result of exist check on expected file name.

		if (!exists) {																						// If False, the file does not exist. Run the following methods to generate stock data.
			
			createSquads();
			serializeLogins();																		
			serializeSquads();
			serializeCoach();
			
		} else {																							// If True, the does exist. Run the following methods to deserialise the files. 
			
			deSerializeLogins();
			deSerializeSquads();																			
			deSerializeCoach();
			
		}																								
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Serialises a new file for data to be stored in to keep the program persistent.
	 * </p>
	 * 
	 * <p> 
	 * Used to create a file to store login details.
	 * </p>
	 * <p>
	 * Sets up a <code>FileOutputStream</code> of the new file to be created.
	 * <br>Sets up an <code>ObjectOutputStream</code> to send out the created file.
	 * <br>Writes the file loginDetail variable from <code>Model</code> to a file.
	 * <br>Closes Output Streams.
	 * </p>
	 * 
	 * @exception IOException
	 * 
	 * @see Model
	 */
	
	private void serializeLogins() {														

		try {																				
			
			FileOutputStream fileOut = new FileOutputStream("logins.ser");				
			ObjectOutputStream out = new ObjectOutputStream(fileOut);						
			out.writeObject(loginDetails);													
			out.close();																	
			fileOut.close();																

		} catch (IOException i) {															
			
			i.printStackTrace();														
			
		}																					
	}	
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Deserialises a file of data setup to be used within this program.
	 * </p>
	 * 
	 * <p> 
	 * Used to read in a file that stores login details.
	 * </p>
	 * <p>
	 * Sets up a <code>FileInputStream</code> of the file to be read.
	 * <br>Sets up an <code>ObjectInputStream</code> to read in a file.
	 * <br>Sets the loginDetails variable in the <code>Model</code> to the file data in a HashMap structure.
	 * <br>Closes Input Streams.
	 * </p>
	 * 
	 * @exception IOException
	 * @exception ClassNotFoundException
	 * 
	 * @see Model
	 * @see HashMap
	 */
	
	private void deSerializeLogins() {													

		try {																				
			
			FileInputStream fileIn = new FileInputStream("logins.ser");					
			ObjectInputStream in = new ObjectInputStream(fileIn);							
			loginDetails = (HashMap<String, String>) in.readObject();														
			in.close();																		
			fileIn.close();																	
			
		}catch (IOException i) {															
			
			i.printStackTrace();															
			return;																			
			
		} catch (ClassNotFoundException c) {												
			
			System.out.println("File not found");											
			c.printStackTrace();															
			return;																			 
			
		}																					
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Serialises a new file for data to be stored in to keep the program persistent.
	 * </p>
	 * 
	 * <p> 
	 * Used to create a file to store squad details.
	 * </p>
	 * <p>
	 * Sets up a <code>FileOutputStream</code> of the new file to be created.
	 * <br>Sets up an <code>ObjectOutputStream</code> to send out the created file.
	 * <br>Writes the file allSquads variable from <code>Model</code> to a file.
	 * <br>Closes OutputStreams.
	 * </p>
	 * 
	 * @exception IOException
	 * 
	 * @see Model
	 */
	
	private void serializeSquads() {														

		try {																				
			
			FileOutputStream fileOut = new FileOutputStream("squads.ser");				
			ObjectOutputStream out = new ObjectOutputStream(fileOut);						
			out.writeObject(allSquads);													
			out.close();																	
			fileOut.close();																

		} catch (IOException i) {															
			
			i.printStackTrace();															
			
		}																					
	}	
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Deserialises a file of data setup to be used within this program.
	 * </p>
	 * 
	 * <p> 
	 * Used to read in a file that stores squad details.
	 * </p>
	 * <p>
	 * Sets up a <code>FileInputStream</code> of the file to be read.
	 * <br>Sets up an <code>ObjectInputStream</code> to read in a file.
	 * <br>Sets the allSquads variable in the <code>Model</code> to the file data in an ArrayList structure.
	 * <br>Closes Input Streams.
	 * </p>
	 * 
	 * @exception IOException
	 * @exception ClassNotFoundException
	 * 
	 * @see Model
	 * @see ArrayList
	 */
	
	private void deSerializeSquads() {													

		try {																				
			
			FileInputStream fileIn = new FileInputStream("squads.ser");					
			ObjectInputStream in = new ObjectInputStream(fileIn);							
			allSquads = (ArrayList<Squad>) in.readObject();														
			in.close();																		
			fileIn.close();																	 
			
		}catch (IOException i) {															
			
			i.printStackTrace();															
			return;																			
			
		} catch (ClassNotFoundException c) {												
			
			System.out.println("File not found");											
			c.printStackTrace();															
			return;																			 
			
		}																					
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Serialises a new file for data to be stored in to keep the program persistent.
	 * </p>
	 * 
	 * <p> 
	 * Used to create a file to store coach details.
	 * </p>
	 * <p>
	 * Sets up a <code>FileOutputStream</code> of the new file to be created.
	 * <br>Sets up an <code>ObjectOutputStream</code> to send out the created file.
	 * <br>Writes the file allCoaches variable from <code>Model</code> to a file.
	 * <br>Closes OutputStreams.
	 * </p>
	 * 
	 * @exception IOException
	 * 
	 * @see Model
	 */
	
	private void serializeCoach() {														

		try {																				
			
			FileOutputStream fileOut = new FileOutputStream("coach.ser");				
			ObjectOutputStream out = new ObjectOutputStream(fileOut);						
			out.writeObject(allCoaches);													
			out.close();																	
			fileOut.close();																

		} catch (IOException i) {															
			
			i.printStackTrace();															
			
		}																					
	}	
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Deserialises a file of data setup to be used within this program.
	 * </p>
	 * 
	 * <p> 
	 * Used to read in a file that stores coach details.
	 * </p>
	 * <p>
	 * Sets up a <code>FileInputStream</code> of the file to be read.
	 * <br>Sets up an <code>ObjectInputStream</code> to read in a file.
	 * <br>Sets the allCoaches variable in the <code>Model</code> to the file data in an ArrayList structure.
	 * <br>Closes Input Streams.
	 * </p>
	 * 
	 * @exception IOException
	 * @exception ClassNotFoundException
	 * 
	 * @see Model
	 * @see ArrayList
	 */
	
	private void deSerializeCoach() {													

		try {																				
			
			FileInputStream fileIn = new FileInputStream("coach.ser");					
			ObjectInputStream in = new ObjectInputStream(fileIn);							
			allCoaches = (ArrayList<Coach>) in.readObject();														
			in.close();																		
			fileIn.close();																	
			
		}catch (IOException i) {															
			
			i.printStackTrace();															
			return;																			
			
		} catch (ClassNotFoundException c) {												
			
			System.out.println("File not found");											
			c.printStackTrace();															
			return;																			  
			
		}																					
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Calls all serialisation methods in one method to keep the program persistent.
	 * </p>
	 * 
	 * <p> 
	 * Used to create files to store program details.
	 * </p>
	 * 
	 * @see Model
	 */
	
	public void serialize() {
		
		serializeSquads();
		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Data generation method that creates squads, a coach for that squad and fills each squad with players.
	 * </p>
	 * 
	 * <p> 
	 * Used to create squads, coaches and players. Allocating all relevant details and lists to each.
	 * </p>
	 * 
	 * <p>
	 * An <code>ArrayList</code> of instances of <code>Squad</code>.
	 * <br>Each <code>Squad</code> instance has an <code>ArrayList</code> of instances of <code>Player</code>.
	 * <br>Each <code>Player</code> instance has an <code>ArrayList</code> of instances of <code>SkillCategory</code>.
	 * </p>
	 * 
	 * <p>
	 * Changes the profileDate variable for an instance of <code>Player</code> to a formated time. (Time was selected for testing and demonstration purposes).
	 * <br><code>LocalTime</code> passed through <code>DateTimeFormatter</code> is utilised.
	 * </p>
	 * 
	 * @see Member
	 * @see Coach
	 * @see Player
	 * @see Squad
	 * @see SkillCategory
	 * @see LocalTime
	 * @see DateTimeFormatter
	 */
	
	// Decided to use time rather than date for testing and demonstration purposes.
	
	private void createSquads()   {
		
		LocalTime currentTime = LocalTime.now();																				// Variable to store current time.
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");														// Variable to store the format a time will take when converted to a String.
		String timeString = currentTime.format(format);																			// Variable that stores the resulting String of formated time from two previously defined variables.
		
		// Documentation of createSquad()
		//
		// Each squad creation goes through same process. Only variable names and input data changes.
		//
		// 1. Create an ArrayList to contain the players.
		// 2. Create a coach and add that coach to the allCoaches and allMembers ArrayLists.
		// 3. Add login details to loginDetails HashMap
		// 4a. Create a player and add that player to the Squad ArrayList created and allMembers ArrayList.
		// 4b. Step 4a can be repeated to increase the number of players in one squad.
		// 5. Create a squad and add the created coach and created ArrayList of players as parameters in the constructor.
		// 6. Add the new squad to the ArrayList of allSquads.
		/*
		 
		ArrayList<Player> squadPlayers = new ArrayList<Player>();																										// ArrayList variable to store a new squad of players.
		
		Coach coach = new Coach("firstName", "lastName", TeamAgeBracket.Option,"MemberType"+(allMembers.size()+1), "email", "password");								// Create new Coach instance with relevant information.
		loginDetails.put("email", "password");																															// Create a new key and value for the login HashMap
		
		allCoaches.add(coach);																																			// Add instance of Coach to allCoaches ArrayList
		allMembers.add(coach);																																			// Add instance of Coach to allMembers ArrayList
		
		Player player = new Player("firstName", "LastName", TeamAgeBracket.Option,"MemberType"+(allMembers.size()+1),Position.Option, timeString, createSkills());		// Create new Player instance with relevant information. Utilises the createSkills() method.
		
		squadPlayers.add(player);																																		// Add instance of Player to squad ArrayList
		allMembers.add(player);																																			// Add instance of Player to allMembers ArrayList
		
		Squad squad = new Squad("squadName",TeamAgeBracket.Option, coach, squadPlayers);																				// Create new Squad instance with relevant information.	Use the Coach instance and squad ArrayList created previously.											
		
		allSquads.add(squadPlayers);																																	// Add instance of Squad to allSquads ArrAyList
		
		*/
		//
		// Creation of full 15 man squad senior squad, its coach and list players. Also contains extra commands to set ratings and comments for 1 player. All used for demonstration and testing purposes.
		//
		
		ArrayList<Player> seniorPlayers = new ArrayList<Player>();																
		
		Coach seniorCoach = new Coach("Gregor", "Townsend", TeamAgeBracket.SENIOR,"Coach"+(allMembers.size()+1), "online", "pass");							
		loginDetails.put("online", "pass");																													
		allCoaches.add(seniorCoach);																														
		allMembers.add(seniorCoach);																														
		
		Player player1 = new Player("Allan", "Dell", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.PROP, timeString, createSkills());		
		
		player1.getSkillCategories("Passing").getSkill("Standard").setRating(4);																																	// Set the defined skill to a rating
		player1.getSkillCategories("Passing").getSkill("Pop").setRating(4);																																			// Set the defined skill to a rating
		player1.getSkillCategories("Passing").getSkill("Spin").setRating(3);																																		// Set the defined skill to a rating
		player1.getSkillCategories("Passing").setComment("Passing skill is of a high level.\n\nImproving spin pass ability and decision making of when to "
														+ "use this type of pass will be benificial. Some extra training sessions focusing on the skill will be required."
														+ "\n\nStandard skill ability is still increasing from the technique lessons conducted and rating is close to being upgraded a"
														+ "second time this month to a 5. \n\nPop has stayed at current rating for many months now and a new approach may be required to improve it any further");	// Set the comment for a category
		
		player1.getSkillCategories("Tackling").getSkill("Front").setRating(5);																																		// Set the defined skill to a rating
		player1.getSkillCategories("Tackling").getSkill("Rear").setRating(5);																																		// Set the defined skill to a rating
		player1.getSkillCategories("Tackling").getSkill("Side").setRating(4);																																		// Set the defined skill to a rating
		player1.getSkillCategories("Tackling").getSkill("Scrabble").setRating(4);																																	// Set the defined skill to a rating
		player1.getSkillCategories("Tackling").setComment("Tackling ability is extremely high and are perfect qualities for the current position the player has in the team.");										// Set the comment for a category
		
		player1.getSkillCategories("Kicking").getSkill("Drop").setRating(1);																																		// Set the defined skill to a rating
		player1.getSkillCategories("Kicking").getSkill("Punt").setRating(2);																																		// Set the defined skill to a rating
		player1.getSkillCategories("Kicking").getSkill("Grubber").setRating(3);																																		// Set the defined skill to a rating
		player1.getSkillCategories("Kicking").getSkill("Goal").setRating(1);																																		// Set the defined skill to a rating
		player1.getSkillCategories("Kicking").setComment("Although kicking is not required for this player to perform in his position, his skill in grubber and punt may be "
														 + "helpful in some situations and as a tactical/strategy edge.");																							// Set the comment for a category
		
		seniorPlayers.add(player1);																															
		allMembers.add(player1);																															
		
		Player player2 = new Player("Fraser", "Brown", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.HOOKER, timeString, createSkills());
		seniorPlayers.add(player2);
		allMembers.add(player2);
		
		Player player3 = new Player("Simon", "Berghan", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.PROP, timeString, createSkills());
		seniorPlayers.add(player3);
		allMembers.add(player3);
		
		Player player4 = new Player("Ben", "Toolis", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.LOCK, timeString, createSkills());
		seniorPlayers.add(player4);
		allMembers.add(player4);
		
		Player player5 = new Player("Grant", "Gilchrist", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.LOCK, timeString, createSkills());
		seniorPlayers.add(player5);
		allMembers.add(player5);
		
		Player player6 = new Player("Magnus", "Bradbury", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.FLANKER, timeString, createSkills());
		seniorPlayers.add(player6);
		allMembers.add(player6);
		
		Player player7 = new Player("Hamish", "Watson", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.NUMBER_8, timeString, createSkills());
		seniorPlayers.add(player7);
		allMembers.add(player7);
		
		Player player8 = new Player("Luke", "Crosbie", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.FLANKER, timeString, createSkills());
		seniorPlayers.add(player8);
		allMembers.add(player8);
		
		Player player9 = new Player("Byron", "Mcguigan", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.WING, timeString, createSkills());
		seniorPlayers.add(player9);
		allMembers.add(player9);
		
		Player player10 = new Player("Ali", "Price", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.SCRUM_HALF, timeString, createSkills());
		seniorPlayers.add(player10);
		allMembers.add(player10);
		
		Player player11 = new Player("Adam", "Hastings", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.FLY_HALF, timeString, createSkills());
		seniorPlayers.add(player11);
		allMembers.add(player11);
		
		Player player12 = new Player("Chris", "Harris", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.CENTRE, timeString, createSkills());
		seniorPlayers.add(player12);
		allMembers.add(player12);
		
		Player player13 = new Player("Matt", "Scott", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.CENTRE, timeString, createSkills());
		seniorPlayers.add(player13);
		allMembers.add(player13);
		
		Player player14 = new Player("Kyle", "Steyn", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.WING, timeString, createSkills());
		seniorPlayers.add(player14);
		allMembers.add(player14);
		
		Player player15 = new Player("Blair", "Kinghorn", TeamAgeBracket.SENIOR,"Player"+(allMembers.size()+1),Position.FULL_BACK, timeString, createSkills());
		seniorPlayers.add(player15);
		allMembers.add(player15);
		
		Squad seniorSquad = new Squad("Senior",TeamAgeBracket.SENIOR, seniorCoach, seniorPlayers);
		
		//
		// Creation of U16 squad, its coach and list players. 3 players to demonstrate the possibility of multiple squads. Also used for demonstration and testing.
		//
		
		ArrayList<Player> u16Players = new ArrayList<Player>();
		
		Coach u16Coach = new Coach("Eddie", "Jones", TeamAgeBracket.U16,"Coach"+(allMembers.size()+1), "email", "access");
		loginDetails.put("email", "access");
		allCoaches.add(u16Coach);
		allMembers.add(u16Coach);
		
		Player player16 = new Player("Owen", "Farrell", TeamAgeBracket.U16,"Player"+(allMembers.size()+1),Position.FLY_HALF, timeString, createSkills());
		u16Players.add(player16);
		allMembers.add(player16);
		
		Player player17 = new Player("Tom", "Dunn", TeamAgeBracket.U16,"Player"+(allMembers.size()+1),Position.HOOKER, timeString, createSkills());
		u16Players.add(player17);
		allMembers.add(player17);
		
		Player player18 = new Player("Jonny", "May", TeamAgeBracket.U16,"Player"+(allMembers.size()+1),Position.WING, timeString, createSkills());
		u16Players.add(player18);
		allMembers.add(player18);
		
		Squad u16Squad = new Squad("U16", TeamAgeBracket.U16,u16Coach, u16Players);
		
		//
		// Creation of U16 squad, its coach and list players. 3 players to demonstrate the possibility of multiple squads. Also used for demonstration and testing.
		//
		
		ArrayList<Player> u13Players = new ArrayList<Player>();
		
		Coach u13Coach = new Coach("Warren", "Gatland", TeamAgeBracket.U13,"Coach"+(allMembers.size()+1), "internet", "valid");
		loginDetails.put("internet", "valid");
		allCoaches.add(u13Coach);
		allMembers.add(u13Coach);
		
		Player player19 = new Player("Dan", "Biggar", TeamAgeBracket.U13,"Player"+(allMembers.size()+1),Position.FLY_HALF, timeString, createSkills());
		u13Players.add(player19);
		allMembers.add(player19);
		
		Player player20 = new Player("Elliot", "Dee", TeamAgeBracket.U13,"Player"+(allMembers.size()+1),Position.HOOKER, timeString, createSkills());
		u13Players.add(player20);
		allMembers.add(player20);
		
		Player player21 = new Player("Josh", "Adams", TeamAgeBracket.U13,"Player"+(allMembers.size()+1),Position.WING, timeString, createSkills());
		u13Players.add(player21);
		allMembers.add(player21);
		
		Squad u13Squad = new Squad("U13", TeamAgeBracket.U13,u13Coach, u13Players);
		
		allSquads.add(seniorSquad);
		allSquads.add(u16Squad);
		allSquads.add(u13Squad);
	
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Data generation method that creates skill categories filled with skills that is added to an instance of a <code>Player</code>.
	 * </p>
	 * 
	 * <p> 
	 * Used to create a list of skill categories filled with a list of skills. Allocating relevant details.
	 * </p>
	 * 
	 * <p>
	 * An <code>ArrayList</code> of instances of <code>SkillCategory</code>.
	 * <br>Each <code>SkillCategory</code> instance has an <code>ArrayList</code> of instances of <code>Skill</code>.
	 * </p>
	 * 		
	 * @return <b>myCategories</b>			The <code>ArrayList</code> of skill categories created.
	 * 
	 * @see SkillCategory
	 * @see Skill
	 * @see ArrayList
	 */

	private ArrayList<SkillCategory> createSkills() {
		
		// Documentation of createSquad()
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
