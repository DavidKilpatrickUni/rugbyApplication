package skillTracking;

import java.awt.EventQueue;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

// Class

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Controller part of the MVC structure.
 * </p>
 * <p>
 * Has a direct link with the <code>Model</code> and <code>View</code>, that enables the two to communicate and do tasks.
 * <br>Reading and interpreting user actions through the <code>View</code>.
 * <br>Processing data and variables from the <code>Model</code> to present to the user through the <code>View</code>.
 * </p>
 * <p>
 * Is used to call view ports, validation and process tasks.
 * <br>The communicator between the <code>Model</code> and <code>View</code> to get tasks and functions completed.
 * </p>
 * <p>
 * First sets up the <code>Model</code> then creates the first view port.
 * <br>All actions after this are determined by the user through the user of the <code>View</code>
 * </p>
 * 
 * @author David Kilpatrick
 * @version 1.0
 * @since 17/04/2020
 *
 * @see Model
 */

public class Controller {

	// Variables
	
	private Model myModel = new Model(); 																			// Model Variable to store new instance of the Model.
	
	// Constructors
	
	// Default
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>Controller</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Creates an instance for a new <code>Model</code>.
	 * <br>Runs a method that starts the first screen of the GUI displayed to the user.
	 * </p>
	 * 
	 * @see Controller
	 * @see Model	
	 */
	
	public Controller() {
	
		myModel = new Model();																				// Set Model variable.
		
		EventQueue.invokeLater(new Runnable() {																// EventQueue. Only runs code within the brackets if the program is free from doing any task.
			
			public void run() {																				// Method that is run when program is free.
				
				initFirstScreen();																			// Method to call View port method.
					
			}
		});
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Create a view port that will be displayed to the user.
	 * </p>
	 * 
	 * <p> 
	 * Initiates the Title screen of the program.
	 * <br>Creates a new instance of <code>FirstScreen</code> and displays that instance to the user.
	 * <br>Sets current user to null.
	 * </p>
	 * 
	 * @exception Exception
	 * 
	 * @see Controller
	 * @see Model
	 * @see FirstScreen
	 */
	
	public void initFirstScreen() {
	
		myModel.currentUser = null;									// Sets variable stored in the Model to null. This removes knowledge of any user log in at program initiation or when recalling the view port at log off.
		
		try {
			
			FirstScreen firstScreen = new FirstScreen(this);		// Create new instance with parameter of this Controller. To allow communication between the instance View and Controller.
			firstScreen.setVisible(true);							// Display instance View.	
			
		}catch(Exception e) {										// Exception handling
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Create a view port that will be displayed to the user.
	 * </p>
	 * 
	 * <p> 
	 * Initiates the Login screen of the program.
	 * <br>Creates a new instance of <code>LoginScreen</code> and displays that instance to the user.
	 * </p>
	 * 
	 * <p>
	 * Asks for user log in details. Each log in has a linked instance of Coach.
	 * <br> These current user details are stored in the <code>Model</code> until log off or program exit.
	 * <br>Each coach has login details that allows access.
	 * <br>Each coach works within a age group and has a designated squad to manage.
	 * </p>
	 * 
	 * @exception Exception
	 * 
	 * @see Controller
	 * @see Model
	 * @see LoginScreen
	 * @see Coach
	 */
	
	public void initLoginScreen() {
		
		try {
			
			LoginScreen loginScreen = new LoginScreen(this);		// Create new instance with parameter of this Controller. To allow communication between the instance View and Controller.
			loginScreen.setVisible(true);							// Display instance View.	
			
		}catch(Exception e) {										// Exception handling
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * To validate input of an account login.
	 * </p>
	 * 
	 * <p> 
	 * Used when a user tries to login in.
	 * <br>Searches the account login list for given user name.
	 * <br>If found compares given password against password stored for the found account.
	 * <br>If password is valid for the account, login check has passed.
	 * <br>All other results are a fail with an accompanying message.
	 * </p>
	 * 
	 * <p>
	 * Search the <code>HashMap</code> <code>Key</code> for userName.
	 * <br><code>If</code> found compare <code>HashMap</code> <code>Value</code> for given <code>Key</code>, to password.
	 * <br><code>If</code> match, return <code>true</code>.
	 * <br><code>Else</code> results are <code>false</code> with accompanying <code>CustomException</code>.
	 * </p>
	 * 
	 * @param userName				<code>String</code> input of userName to search for.
	 * @param password				<code>String</code> input of password of given account linked with userName.
	 * 
	 * @return <b>result</b>		<code>Boolean</code> output to be used by program uses to make decisions.
	 * 
	 * @exception CustomException
	 * 
	 * @see Controller
	 * @see Model
	 * @see LoginScreen
	 * @see String
	 * @see HashMap
	 * @see Boolean
	 */
	
	// ProtoType version of login. 
	
	public Boolean checkLogin(String userName, String password) throws CustomException {						// Method with parameters. String of userName to find matching account key and password to compare value to.
		
		Boolean result;																							// Variable to store result of search
		
		result = false;																							// Set variable to false. Base setting only changed if parameters both pass checks is found.
		
		for (String uName : myModel.loginDetails.keySet()) {													// For Each loop. Loops through each element within an HashMap stored in the Model
		
			if(uName.equals(userName)){																			// If Statement. Checks if Key of current element is equal to the userName parameter.
				
				if(myModel.loginDetails.get(uName).equals(password)) {											// True. If Statement. Checks if Value of current Key is equal to the password parameter.
					
					result = true;																				// True. Set variable to true.																		
					
					return result;																				// Return Result.
					
				}
			}	
		}
		
		if (result == false) {																					// If Statement. Check value of result variable.
			
			throw new CustomException("Invalid details provided");												// True, result variable is false. Create new exception with parameter message.
			
		}
		
		return result;																							// Return result.
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * To define which user details are linked with a login account.
	 * </p>
	 * 
	 * <p> 
	 * Used when a valid user logins in.
	 * <br>Returns user details of given login account.
	 * <br>Sets the current user to this user.
	 * <br>Allows progression of the program to next view port with relevant content.
	 * </p>
	 * 
	 * <p> 
	 * The protoType uses the email variable of a <code>Coach</code> instance as userName.
	 * <br>Return a <code>Coach</code> instance by userName.
	 * <br>Set currentUser variable in <code>Model</code> to <code>Coach</code> instance.
	 * <br>Call method to create <code>MainMenuScreen</code> instance with parameter of <code>Coach</code> instance.
	 * </p>
	 * 
	 * @param userName				<code>String</code> input to define which <code>Coach</code> instance to select by userName.
	 * 
	 * @see Controller
	 * @see Model
	 * @see LoginScreen
	 * @see MainMenuScreen
	 * @see String
	 * @see ArrayList
	 */

	// Sets up current user and content of pages based on return of method. Returns the Coach with the userName given. UserName is the email of a coach for this protoType.
	// Previous method check ,checkLogin(), ensures that a Coach will be found.
	
	public void loginUser(String userName) {															// Method with parameters. String to compare to.
		
		Coach userDetails;																				// Variable to store result of search.
		
		for (Coach coach : myModel.allCoaches) {														// For Each loop. Loops through each element within an ArrayList stored in the Model
			
			if (coach.getEmail().equals(userName)) {													// If Statement. Checks email of current element is equal to the parameter.
				
				userDetails = coach;																	// True. Set variable to instance of Coach.														
				myModel.currentUser = coach;															// Set variable in Model to instance of Coach. 
				initMainMenuScreen(userDetails);														// Call view port method with parameter to ensure correct content and options are available.
			
			}	
		}		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Create a view port that will be displayed to the user.
	 * </p>
	 * 
	 * <p> 
	 * Initiates the Main menu screen of the program.
	 * <br>Creates a new instance of <code>MainMenuScreen</code> and displays that instance to the user.
	 * </p>
	 * 
	 * <p>
	 * Menu and menu option contents are defined by the current user logged into the program.
	 * </p>
	 * 
	 * @exception Exception
	 * 
	 * @see Controller
	 * @see Model
	 * @see MainMenuScreen
	 */
	
	public void initMainMenuScreen(Coach userDetails) {									// Method with parameter. Current logged in users(coach). 
		
		try {
			
			MainMenuScreen mainMenuScreen = new MainMenuScreen(this, userDetails);		// Create new instance with parameters of this Controller and the current user logged in. 
																						// 1.To allow communication between the instance View and Controller. 2. The correct user details and access for the user is given
			
			mainMenuScreen.setVisible(true);											// Display instance View.
			
		}catch(Exception e) {															// Exception handling
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Create a view port that will be displayed to the user.
	 * </p>
	 * 
	 * <p> 
	 * Initiates the Main menu screen of the program.
	 * <br>Creates a new instance of <code>MainMenuScreen</code> and displays that instance to the user.
	 * </p>
	 * 
	 * <p>
	 * Menu and menu option contents are defined by the current user logged into the program.
	 * </p>
	 * 
	 * @exception Exception
	 * 
	 * @see Controller
	 * @see Model
	 * @see MainMenuScreen
	 */
	
	// Required so the user currently logged in can return to Main menu from menu option screens. Uses the variable stored in the Model of the current user.
	
	public void backMainMenuScreen() {
		
		try {
			
			MainMenuScreen mainMenuScreen = new MainMenuScreen(this,myModel.currentUser);	// Create new instance with parameters of this Controller and the current user logged in. 
																							// 1.To allow communication between the instance View and Controller. 2. The correct user details and access for the user is given
			
			mainMenuScreen.setVisible(true);												// Display instance View.
			
		}catch(Exception e) {																// Exception handling
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Create a view port that will be displayed to the user.
	 * </p>
	 * 
	 * <p> 
	 * Initiates the Player Profile Select screen of the program.
	 * <br>Creates a new instance of <code>PlayerProfileSelect</code> and displays that instance to the user.
	 * </p>
	 * 
	 * <p>
	 * Screen that displays or allows the search of specific players based on the squad they are part of.
	 * <br>The squad is determined by the current users details. Each squad has a specific coach.
	 * <br>Player selected determines contents of the Player Profile Screen.
	 * </p>
	 * 
	 * @exception Exception
	 * 
	 * @see Controller
	 * @see Model
	 * @see PlayerProfileSelect
	 * @see PlayerProfileScreen
	 */
	
	public void initPlayerProfileSelect(Squad squadDetails) {											// Method with parameter. Current logged in users(coach) squad. 
		
		try {
			
			PlayerProfileSelect playerProfileSelect = new PlayerProfileSelect(this, squadDetails);		// Create new instance with parameters of this Controller and the current logged in users(coach) squad. 
																										// 1.To allow communication between the instance View and Controller. 2. The correct squad details and access for the user is given.
			
			playerProfileSelect.setVisible(true);														// Display instance View.
			
		}catch(Exception e) {																			// Exception handling
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Create a view port that will be displayed to the user.
	 * </p>
	 * 
	 * <p> 
	 * Initiates the Player Profile Select screen of the program.
	 * <br>Creates a new instance of <code>PlayerProfileSelect</code> and displays that instance to the user.
	 * </p>
	 * 
	 * <p>
	 * Screen that displays or allows the search of specific players based on the squad they are part of.
	 * <br>The squad is determined by the current users details. Each squad has a specific coach.
	 * <br>Player selected determines contents of the Player Profile Screen.
	 * </p>
	 * 
	 * @exception Exception
	 * 
	 * @see Controller
	 * @see Model
	 * @see PlayerProfileSelect
	 * @see PlayerProfileScreen
	 */
	
	// Required so the user currently logged in can return to Player Profile Select from Player Profile. Uses the variable stored in the Model of the current user passed through a method.
	
	public void backPlayerProfileSelect() {																									// Method with parameter. Current logged in users(coach) squad. 
		
		try {
			
			PlayerProfileSelect playerProfileSelect = new PlayerProfileSelect(this, getMySquad(myModel.currentUser.getTeamAgeBracket()));	// Create new instance with parameters of this Controller and the current logged in users(coach) squad. Use method to determine squad.
																																			// 1.To allow communication between the instance View and Controller. 2. The correct squad details and access for the user is given.
			
			playerProfileSelect.setVisible(true);																							// Display instance View.
			
		}catch(Exception e) {																												// Exception handling
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Return a certain squad by age group.
	 * </p>
	 * 
	 * <p> 
	 * Used when a user returns to Player Profile Select.
	 * <br>Returns squad details of current users squad.
	 * </p>
	 * 
	 * <p> 
	 * Return a <code>Squad</code> instance by teamAgeBracket.
	 * </p>
	 * 
	 * @param ageGroup				<code>TeamAgeBracket</code> input to define which <code>Squad</code> instance to select.
	 * 
	 * @return <b>mySquad</b>		<code>Squad</code> output to be used by program for setting up page contents of Player Profile Select.
	 * 
	 * @see Controller
	 * @see Model
	 * @see PlayerProfileScreen
	 * @see PlayerProfileSelect
	 * @see Squad
	 * @see TeamAgeBracket
	 * @see ArrayList
	 */
	
	// Every squad has a age group bracket with a coach assigned to that squad and age group bracket. Using return by age group returns the correct squad for the correct coach.
	
	public Squad getMySquad(TeamAgeBracket ageGroup) {																	// Method with parameters. The age group to search for.
		
	Squad mySquad;																										// Variable to store result of search
	
	mySquad = null;																										// Set variable to null. Base setting only changed if searched for squad is found.
		
		for (Squad squad : myModel.allSquads) {																			// For Each loop. Loops through each element within an ArrayList stored in the Model				
			
			if (squad.getTeamAgeBracket().equals(ageGroup)) {															// If Statement. Checks ageGroup of current element is equal to the parameter.
				
				mySquad = squad;																						// True. Set variable to instance of Squad.
				
				return mySquad;																							// Return variable.
				
			}	
		}
		
		return mySquad;																									// Return result. Declaring Null is needed for method to operate and this return for method structure.
			
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Search for a certain player by Full Name.
	 * </p>
	 * 
	 * <p> 
	 * Used when searching for a Player Profile on Player Profile Select screen.
	 * <br>Search for a given player in a given squad.
	 * <br>Returns if the player exists in given squad.
	 * </p>
	 * 
	 * <p> 
	 * Search a <code>Squad</code> instance for a <code>Player</code> instance by fullName.
	 * </p>
	 * 
	 * @param squad			<code>Squad</code> input to define which <code>Squad</code> instance to select.
	 * @param searchPlayer	<code>String</code> input to define which <code>Player</code> instance to search for based on Full Name.
	 * 
	 * @exception CustomException
	 * 
	 * @return <b>result</b>		<code>Boolean</code> output that program uses to make decisions.
	 * 
	 * @see Controller
	 * @see PlayerProfileScreen
	 * @see PlayerProfileSelect
	 * @see Squad
	 * @see Player
	 * @see String
	 * @see Boolean
	 */
	
	
	public boolean playerSearchByName(Squad squad, String searchPlayer) throws CustomException{									// Method with parameters. Squad instance to search for Full Name of player using given String.
		
		boolean result;																											// Variable to store result of search
		
		result = false;																											// Set variable to false. Base setting only changed if searched for player is found.
		
		if (squad.getPlayer(searchPlayer) != null) {																			// If Statement. Use method to check if given fullName exists in the given squad.
			
			result = true;																										// True. Set variable.
			
		}
		
		if (result == false) {																									// False. Create new Exception with custom message.
			
			throw new CustomException("Player name not found.");																// Create new instance of CustomException with parameter message.
			
		}
	
		
		return result;																											// Return result
		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Search for a certain player by memberID.
	 * </p>
	 * 
	 * <p> 
	 * Used when searching for a Player Profile on Player Profile Select screen.
	 * <br>Search for a given player in a given squad.
	 * <br>Returns if the player exists in given squad.
	 * </p>
	 * 
	 * <p> 
	 * Search a <code>Squad</code> instance for a <code>Player</code> instance by memberID.
	 * </p>
	 * 
	 * @param squad			<code>Squad</code> input to define which <code>Squad</code> instance to select.
	 * @param searchPlayer	<code>String</code> input to define which <code>Player</code> instance to search for based on memberID.
	 * 
	 * @exception CustomException
	 *  
	 * @return <b>result</b>		<code>Boolean</code> output that program uses to make decisions.
	 * 
	 * @see Controller
	 * @see PlayerProfileScreen
	 * @see PlayerProfileSelect
	 * @see Squad
	 * @see Player
	 * @see String
	 * @see Boolean
	 */
	
	public boolean playerSearchByID(Squad squad, String searchPlayer ) throws CustomException{									// Method with parameters. Squad instance to search for memberID of player using given String.
		
		boolean result;																											// Variable to store result of search
		
		result = false;																											// Set variable to false. Base setting only changed if searched for player is found.

		if (squad.getPlayerID(searchPlayer) != null) {																			// If Statement. Use method to check if given memberID exists in the given squad.
		
			result = true;																										// True. Set variable.
			
		}
		
		if (result == false) {																									// False. Create new Exception with custom message.
			
			throw new CustomException("Player ID not found.");																	// Create new instance of CustomException with parameter message.
			
		}
		
		return result;																											// Return result
		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Return a certain player by squad list number.
	 * </p>
	 * 
	 * <p> 
	 * Used when selecting a player from comboBox on Player Profile Select screen.
	 * <br>Select a given player in a given squad.
	 * <br>Returns player details.
	 * </p>
	 * 
	 * <p> 
	 * Return a <code>Player</code> instance by element value in given <code>ArrayList</code>.
	 * </p>
	 * 
	 * <p>
	 * ComboBox uses .toArray() to display <code>ArrayList</code> contents.
	 * <br>Element is determined by .getSelectedIndex() of current item selected in comboBox.
	 * </p>
	 * 
	 * @param squad				<code>Squad</code> input to define which <code>Squad</code> instance to select.
	 * @param playerSelection	<code>Integer</code> input to define which <code>Player</code> instance to return based on <code>ArrayList</code> element value.
	 *  
	 * @return <b>player</b>		<code>Player</code> output to be used by program for setting up page contents of Player Profile Screen.
	 * 
	 * @see Controller
	 * @see PlayerProfileScreen
	 * @see PlayerProfileSelect
	 * @see Squad
	 * @see Player
	 * @see Integer
	 */
	
	public Player getThisPlayerByNumber(Squad squad, int playerSelection) {														// Method with parameters. Select a specific integer element from given squad of players ArrayList.
		
		Player player;																											// Variable to store result of method.																
		
		player = squad.getSquadPlayers().get(playerSelection);																	// Set variable to method return.

		return player;																											// Return result.
		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Return a certain player by memberID.
	 * </p>
	 * 
	 * <p> 
	 * Used when searching for a Player Profile on Player Profile Select screen.
	 * <br>Select a given player in a given squad.
	 * <br>Returns player details.
	 * </p>
	 * 
	 * <p> 
	 * Return a <code>Player</code> instance by memberID.
	 * </p>
	 * 
	 * @param squad				<code>Squad</code> input to define which <code>Squad</code> instance to select.
	 * @param playerSelection	<code>String</code> input to define which <code>Player</code> instance to return based on memberID.
	 *  
	 * @return <b>player</b>		<code>Player</code> output to be used by program for setting up page contents of Player Profile Screen.
	 * 
	 * @see Controller
	 * @see PlayerProfileScreen
	 * @see PlayerProfileSelect
	 * @see Squad
	 * @see Player
	 * @see String
	 */
	
	public Player getThisPlayerByID(Squad squad, String playerSelection) {														// Method with parameters. Select a specific player memberID from given squad of players ArrayList.
		
		Player player;																											// Variable to store result of method.	
	
		player = squad.getPlayerID(playerSelection);																			// Set variable to method return.

		return player;																											// Return result.
		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Return a certain player by Full Name.
	 * </p>
	 * 
	 * <p> 
	 * Used when searching for a Player Profile on Player Profile Select screen.
	 * <br>Select a given player in a given squad.
	 * <br>Returns player details.
	 * </p>
	 * 
	 * <p> 
	 * Return a <code>Player</code> instance by fullName.
	 * </p>
	 * 
	 * @param squad				<code>Squad</code> input to define which <code>Squad</code> instance to select.
	 * @param playerSelection	<code>String</code> input to define which <code>Player</code> instance to return based on Full Name.
	 *  
	 * @return <b>player</b>		<code>Player</code> output to be used by program for setting up page contents of Player Profile Screen.
	 * 
	 * @see Controller
	 * @see PlayerProfileScreen
	 * @see PlayerProfileSelect
	 * @see Squad
	 * @see Player
	 * @see String
	 */
	
	public Player getThisPlayerByName(Squad squad, String playerSelection) {													// Method with parameters. Select a specific player fullName from given squad of players ArrayList.
		
		Player player;																											// Variable to store result of method.
		
		player = squad.getPlayer(playerSelection);																				// Set variable to method return.
		
		return player;																											// Return result.
		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Create a view port that will be displayed to the user.
	 * </p>
	 * 
	 * <p> 
	 * Initiates the Player Profile screen of the program.
	 * <br>Creates a new instance of <code>PlayerProfileScreen</code> and displays that instance to the user.
	 * </p>
	 * 
	 * <p>
	 * Screen that displays the score cards of skills,ratings and comment for selected player.
	 * <br>The player selected is determined by user choice on the Player Profile Select Screen.
	 * </p>
	 * 
	 * @exception Exception
	 * 
	 * @see Controller
	 * @see Model
	 * @see PlayerProfileScreen
	 * @see PlayerProfileSelect
	 */
	
	public void initPlayerProfileScreen(Player playerInfo) {												// Method with parameter. Current logged in users(coach) squad. 
		
		try {
			
			PlayerProfileScreen playerProfileScreen = new PlayerProfileScreen(this, playerInfo);			// Create new instance with parameters of this Controller and the Player instance. 
																											// 1.To allow communication between the instance View and Controller. 2. The correct player details are displayed and editable.
			
			playerProfileScreen.setVisible(true);															// Display instance View.
			
		}catch(Exception e) {
			
			e.printStackTrace();																			// Exception handling
			
		}
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Set the rating variable for an instance of <code>Skill</code> for an instance of <code>SkillCategory</code> for an instance of <code>Player</code>.
	 * </p>
	 * 
	 * <p> 
	 * Used when updating a Player Profile.
	 * <br>Set rating of a skill of a given skill category for a given player.
	 * <br>Changes the rating to a user defined Integer. 
	 * </p>
	 * 
	 * <p> 
	 * Serialises data to file.
	 * </p>
	 * 
	 * @param player	<code>Player</code> input to define which <code>Player</code> instance to select.
	 * @param category	<code>String</code> input to define which <code>SkillCategory</code> instance to select.
	 * @param skill		<code>String</code> input to define which <code>Skill</code> instance to select.
	 * @param rating	<code>Integer</code> input to set rating variable in <code>Skill</code> class to.
	 * 
	 * @see Controller
	 * @see Model
	 * @see PlayerProfileScreen
	 * @see Player
	 * @see SkillCategory
	 * @see String
	 * @see Integer
	 */

	public void updateRating(Player player,String category, String skill, int rating) {		// Method with parameters. Integer to change rating variable of defined a Skill instance, of defined a SkillCategory instance, of a defined Player instance.
		
		player.getSkillCategories(category).getSkill(skill).setRating(rating);				// Set the comment of Player instance using methods.
		
		myModel.serialize();																// Run method in Model to keep the data persistent.

		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Set the comment variable for an instance of <code>SkillCategory</code> for an instance of <code>Player</code>.
	 * </p>
	 * 
	 * <p> 
	 * Used when updating a Player Profile.
	 * <br>Set comment of a given skill category for a given player.
	 * <br>Changes the comment to a user defined String. 
	 * </p>
	 * 
	 * <p> 
	 * Serialises data to file.
	 * </p>
	 * 
	 * @param player	<code>Player</code> input to define which <code>Player</code> instance to select.
	 * @param category	<code>String</code> input to define which <code>SkillCategory</code> instance to select.
	 * @param comment	<code>String</code> input to set comment variable in <code>SkillCategory</code> class to.
	 * 
	 * @see Controller
	 * @see Model
	 * @see PlayerProfileScreen
	 * @see Player
	 * @see SkillCategory
	 * @see String
	 */
	
	public void updateComment(Player player,String category, String comment) {				// Method with parameters. String to change comment variable of defined a SkillCategory instance, of a defined Player instance.

		player.getSkillCategories(category).setComment(comment);							// Set the comment of Player instance using methods.
		
		myModel.serialize();																// Run method in Model to keep the data persistent.
		
		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * Set the profileDate variable for an instance of <code>Player</code>.
	 * </p>
	 * 
	 * <p> 
	 * Used when updating a Player Profile.
	 * </p>
	 * 
	 * <p>
	 * Changes the profileDate to a formated time. (Time was selected for testing and demonstration purposes).
	 * <br><code>LocalTime</code> passed through <code>DateTimeFormatter</code> is utilised.
	 * </p>
	 * 
	 * <p> 
	 * Serialises data to file.
	 * </p>
	 * 
	 * @param player  <code>Player</code> input to define which <code>Player</code> instance to select.
	 * 
	 * @see Controller
	 * @see Model
	 * @see PlayerProfileScreen
	 * @see Player
	 */
	
	// Decided to use time rather than date for testing and demonstration purposes. 
	
	public void updateDate(Player player) {														// Method with parameter. Player instance to change.
		
		LocalTime timeNow = LocalTime.now();													// Variable to store current time.
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");						// Variable to store the format a time will take when converted to a String.
		String timeString = timeNow.format(format);												// Variable that stores the resulting String of formated time from two previously defined variables.
		
		player.setProfileDate(timeString);;														// Set profileDate of Player instance using method.
		
		myModel.serialize();																	// Run method in Model to keep the data persistent.
		
	}
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * To exit the program.
	 * </p>
	 * 
	 * @see Controller
	 */

	public void exit() {
		
		System.exit(0);
		
	}
	
	//
	// Methods added after testing.
	//
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * To check user input against stored values ignoring letter casing.
	 * </p>
	 * 
	 * <p> 
	 * Used to check Full Name search inputs by the user on Player Profile Screen.
	 * <br>Loops through known Full Names and compares input against it, ignoring casing.
	 * <br>If found returns String of Full Name.
	 * <br>Else returns error.
	 * </p>
	 * 
	 * <p>
	 * Loops through all instances of <code>Player</code> in a given <code>Squad</code> instance comparing fullName to <code>String</code> check.
	 * <br><code>IF</code> <code>Player</code> instance fullName equals check using equalsIgnoreCheck().
	 * <br>Set return variable to loop element value.
	 * <br><code>Else</code> return new instance of <code>CustomException</code> with message parameter.
	 * </p>
	 * 
	 * @param squadInfo		<code>Squad</code> input to define which <code>Squad</code> instance to select.
	 * @param check			<code>String</code> input to compare known values against.
	 * 
	 * @return <b>ignoreCase</b>		<code>String</code> output the program uses to in other methods for displaying content.
	 * 
	 * @exception CustomException
	 * 
	 * @see Controller
	 * @see PlayerProfileSelect
	 * @see Squad
	 * @see String
	 * @see ArrayList
	 */
	
	public String checkNameCase(Squad squadInfo, String check) throws CustomException{						// Method with parameters. Squad instance to loop through and String of input to compare against																					
		
		String ignoreCase;																					// Variable to store method result.
		
		ignoreCase = null;																					// Set variable to null.
		
			for (int i = 0; i < squadInfo.getSquadPlayers().size(); i++) {									// For Loop. Loop through all values of a given ArrayList. Start at 0 to size of array.
				
				if(squadInfo.getSquadPlayers().get(i).getFullName().equalsIgnoreCase(check)) {				// If Statement. Uses methods to compare input parameter against the stored value of a fullName stored for each player in a squad.
					
					ignoreCase = squadInfo.getSquadPlayers().get(i).getFullName();							// True. Set variable to ArrayList element value.
					break;																					// End loop.
					
				}
			}
			
			if(ignoreCase == null) {																		// If Statement. Check variable has changed since initiation.
				
				throw new CustomException("Player Full Name not found.");									// If unchanged create new instance of exception
				
			}
			
		return ignoreCase;																					// Return variable.
					
	}	
	
	/**
	 * <h1> Method </h1>
	 *
	 * <p> 
	 * To check user input against stored values ignoring letter casing.
	 * </p>
	 * 
	 * <p> 
	 * Used to check memberID search inputs by the user on Player Profile Screen.
	 * <br>Loops through known memberID and compares input against it, ignoring casing.
	 * <br>If found returns String of memberID.
	 * <br>Else returns error.
	 * </p>
	 * 
	 * <p>
	 * Loops through all instances of <code>Player</code> in a given <code>Squad</code> instance comparing memberID to <code>String</code> check.
	 * <br><code>IF</code> <code>Player</code> instance memberID equals check using equalsIgnoreCase().
	 * <br>Set return variable to loop element value.
	 * <br><code>Else</code> return new instance of <code>CustomException</code> with message parameter.
	 * </p>
	 * 
	 * @param squadInfo		<code>Squad</code> input to define which <code>Squad</code> instance to select.
	 * @param check			<code>String</code> input to compare known values against.
	 * 
	 * @return <b>ignoreCase</b>		<code>String</code> output the program uses to in other methods for displaying content.
	 * 
	 * @exception CustomException
	 * 
	 * @see Controller
	 * @see PlayerProfileSelect
	 * @see Squad
	 * @see String
	 * @see ArrayList
	 */
	
	public String checkIDCase(Squad squadInfo, String check) throws CustomException{							// Method with parameters. Squad instance to loop through and String of input to compare against																						

		String ignoreCase;																						// Variable to store method result.
		
		ignoreCase= null;																						// Set variable to null.
		
			for (int i = 0; i < squadInfo.getSquadPlayers().size(); i++) {										// For Loop. Loop through all values of a given ArrayList. Start at 0 to size of array.
				
				if(squadInfo.getSquadPlayers().get(i).getMemberID().equalsIgnoreCase(check)) {					// If Statement. Uses methods to compare input parameter against the stored value of a memberID stored for each player in a squad.
					
					ignoreCase = squadInfo.getSquadPlayers().get(i).getMemberID();								// True. Set variable to ArrayList element value.
					break;																						// End loop.
					
				}
			}
			
			if(ignoreCase == null) {																			// If Statement. Check variable has changed since initiation.
				
				throw new CustomException("Player memberID not found.");										// If unchanged create new instance of exception
				
			}
			
		return ignoreCase;																						// Return variable.
					
	}		
			
}
