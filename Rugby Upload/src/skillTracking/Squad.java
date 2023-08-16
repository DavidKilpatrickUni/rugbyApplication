package skillTracking;

import java.util.ArrayList;

// Class

/**
* <h1> Class </h1>
* 
* <p>
* Storing variables and methods in relation to squads.
* Can create and alter information about the objects in the class.
* </p>
* <p>
* Is used to create squads and access information about the squad. 
* </p>
* <p>
* Each squad has its own name, coach, age bracket and list of players. 
* </p>
* @author David Kilpatrick
* @version 1.0
* @since 17/04/2020
*
* @see Player
* @see java.io.Serializable
*/

public class Squad implements java.io.Serializable {

	// Variables
	
	private String squadName;																										// Variable to store squad name of a squad for an instance of Squad.
	private Coach coach;																											// Variable to store coach in charge of a squad for an instance of Squad.
	private TeamAgeBracket teamAgeBracket;																							// Variable to store age group of a squad for an instance of Squad.
	private ArrayList<Player> squadPlayers = new ArrayList<Player>();																// ArrayList of Player variable to store players in a squad for an instance of Squad.
	
	// Constructors
	
	// Default
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>Squad</code> class. 
	 * </p>
	 * 
	 * @see Squad	
	 */
	
	public Squad() {
		
	}
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Overloaded constructor for the <code>Squad</code> class.
	 * </p>
	 * 
	 * <p>
	 * Is main constructor that is used when creating new squads, allocating them a name, age group, head coach and a list of players. 
	 * </p>
	 * 
	 * @param squadName				<code>String</code> input to set squadName variable in <code>Squad</code> class to.
	 * @param teamAgeBracket		<code>TeamAgeBracket</code> input to set teamAgeBracket variable in <code>Squad</code> class to. 
	 * @param coach					<code>Coach</code> input to set coach variable in <code>Squad</code> class to. 
	 * @param squadPlayers			<code>ArrayList</code> input to set squadPlayers variable in <code>Squad</code> class to.
	 *
	 * @see Member
	 * @see Player
	 * @see TeamAgeBracket
	 * @see String
	 * @see ArrayList
	 */
	
	public Squad(String squadName,TeamAgeBracket teamAgeBracket, Coach coach, ArrayList<Player> squadPlayers) {
		
		this.squadName = squadName;																																								
		this.teamAgeBracket = teamAgeBracket;
		this.coach = coach;
		this.squadPlayers = squadPlayers;
		
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in squadName variable for an instance of <code>Squad</code>.
	 * </p>
	 * 
	 * @see Squad
	 */

	public String getSquadName() {
		
		return squadName;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the squadName variable for an instance of <code>Squad</code> to the parameter.
	 * </p>
	 * 
	 * @param squadName		<code>String</code> input to set squadName variable in <code>Squad</code> class to.
	 * 
	 * @see Squad
	 * @see String
	 */

	public void setSquadName(String squadName) {
		
		this.squadName = squadName;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in coach variable for an instance of <code>Squad</code>.
	 * </p>
	 * 
	 * @see Squad
	 * @see Coach
	 */
	
	public Coach getCoach() {
		
		return coach;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the coach variable for an instance of <code>Squad</code> to the parameter.
	 * </p>
	 * 
	 * @param coach		<code>Coach</code> input to set coach variable in <code>Squad</code> class to.
	 * 
	 * @see Squad
	 * @see Coach
	 */

	public void setCoach(Coach coach) {
		
		this.coach = coach;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in squadPlayers variable for an instance of <code>Squad</code>.
	 * </p>
	 * 
	 * @see Squad
	 * @see Player
	 * @see ArrayList
	 */

	public ArrayList<Player> getSquadPlayers() {
		
		return squadPlayers;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the squadPlayers variable for an instance of <code>Squad</code> to the parameter.
	 * </p>
	 * 
	 * @param squadPlayers		<code>ArrayList</code> input to set squadPlayers variable in <code>Player</code> class to.
	 * 
	 * @see Squad
	 * @see Player
	 * @see ArrayList
	 */
	
	public void setSquadPlayers(ArrayList<Player> squadPlayers) {
		
		this.squadPlayers = squadPlayers;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To find a certain player member by Full Name within the ArrayList of players attached to an instance of <code>Squad</code> and return that <code>Player</code> instance.
	 * </p>
	 * 
	 * @param Name		<code>String</code> input to search for.
	 * 
	 * @see Squad
	 * @see Player
	 * @see String
	 * @see ArrayList
	 */
	
	public Player getPlayer(String fullName){																						// Method with parameter.
		
		for (Player item : squadPlayers) {																							// For Each loop. Loops through each element within an ArrayList attached to a Squad instance. 
			
			if (item.getFullName().equals(fullName)) {																				// If Statement. Checks full name of current element is equal to the parameter.
				
				return item;																										// True. Return element.
			
			}																					
			
		}
		
		return null;																												// False. Return null.
	}
	

	/**
	 * <h1> Method </h1>
	 * <p>
	 * To find a certain player member by MemberID within the ArrayList of players attached to an instance of <code>Squad</code> and return that <code>Player</code> instance.
	 * </p>
	 * 
	 * @param memberID		<code>String</code> input to search for.
	 * 
	 * @see Squad
	 * @see Player
	 * @see String
	 * @see ArrayList
	 */
	
	public Player getPlayerID(String memberID){																						// Method with parameter.
		
		for (Player item : squadPlayers) {																							// For Each loop. Loops through each element within an ArrayList attached to a Squad instance.													
			
			if (item.getMemberID().equals(memberID)) {																				// If Statement. Checks memberID of current element is equal to the parameter.
				
				return item;																										// True. Return element.																					
			
			}																					
			
		}
		
		return null;																												// False. Return null.
	}

	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in teamAgeBracket variable for an instance of <code>Squad</code>.
	 * </p>
	 * 
	 * @see Squad
	 * @see TeamAgeBracket
	 */

	public TeamAgeBracket getTeamAgeBracket() {
		
		return teamAgeBracket;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the teamAgeBracket variable for an instance of <code>Squad</code> to the parameter .
	 * </p>
	 * 
	 * @param teamAgeBracket		<code>TeamAgeBracket</code> input to set teamAgeBracket variable in <code>Squad</code> class to.
	 * 
	 * @see Member
	 * @see TeamAgeBracket
	 */

	public void setTeamAgeBracket(TeamAgeBracket teamAgeBracket) {
		
		this.teamAgeBracket = teamAgeBracket;
		
	}
		
}
