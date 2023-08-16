package skillTracking;

//Class

import java.util.ArrayList;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Storing variables and methods in relation to player members.
 * Can create and alter information about the objects in the class.
 * Inherits from the <code>Member</code> class.
 * </p>
 * <p>
 * Is used for creating new player members. 
 * </p>
 * <p>
 * Each player has its own details about playing position, profile creation/update date and list of skill categories.
 * </p>
 * <p>
 * Each <code>Player</code> instance has an <code>ArrayList</code> of instances of <code>SkillCategory</code>
 * <br>Each <code>SkillCategory</code> instance has an <code>ArrayList</code> of instances of <code>Skill</code>
 * </p>
 *
 * 
 * @author David Kilpatrick
 * @version 1.0
 * @since 17/04/2020
 *
 * @see Member
 * @see SkillCategory
 * @see Skill
 */

public class Player extends Member{

	//Variables
	
	private Position position;																						// Variable to store position a player plays for an instance of Player.
	private ArrayList<SkillCategory> skillCategories = new ArrayList<SkillCategory>();								// ArrayList of SkillCategory variable to store skill categories a player has for an instance of Player.
	private String profileDate;																						// Variable to store date of player profile creation/alteration for an instance of Player. String was selected so the
																													// time or date could be formatted to requirements. 

	// Constructors
	
	// Default
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>Player</code> class. 
	 * </p>
	 * 
	 * @see Player	
	 */
	
	public Player() {
		
	}
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Overloaded constructor for the <code>Player</code> class.
	 * </p>
	 * 
	 * <p>
	 * Is main constructor that is used when creating new player members. Utilises constructor from superclass <code>Member</code> and adds extra parameters.
	 * A player has a position, date of creation/update of player profile and a list of skill categories.
	 * </p>
	 * 
	 * @param firstName				<code>String</code> input to set firstName variable in <code>Member</code> class to.
	 * @param lastName				<code>String</code> input to set lastName variable in <code>Member</code> class to.
	 * @param teamAgeBracket		<code>TeamAgeBracket</code> input to set teamAgeBracket variable in <code>Member</code> class to. 
	 * @param memberID				<code>String</code> input to set memberID variable in <code>Member</code> class to. 
	 * @param position				<code>Position</code> input to set position variable in <code>Player</code> class to. 
	 * @param profileDate			<code>String</code> input to set profileDate variable in <code>Player</code> class to.
	 * @param skillCategories		<code>ArrayList</code> input to set firstName variable in <code>Player</code> class to.
	 *
	 * @see Member
	 * @see Player
	 * @see TeamAgeBracket
	 * @see Position
	 * @see SkillCategory
	 * @see String
	 */
	
	public Player(String firstName, String lastName, TeamAgeBracket teamAgeBracket, String memberID ,Position position,String profileDate, ArrayList<SkillCategory> skillCategories) {
		
		super(firstName, lastName, teamAgeBracket, memberID);
		this.position = position;																									
		this.profileDate = profileDate;																								
		this.skillCategories = skillCategories;																						
		
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in skillCategories variable for an instance of <code>Player</code>.
	 * </p>
	 * 
	 * @see Player
	 * @see SkillCategory
	 * @see ArrayList
	 */

	public ArrayList<SkillCategory> getSkillCategories() {
		
		return skillCategories;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the skillCategories variable for an instance of <code>Player</code> to the parameter.
	 * </p>
	 * 
	 * @param skillCategories		<code>ArrayList</code> input to set skillCategories variable in <code>Player</code> class to.
	 * 
	 * @see Player
	 * @see SkillCategory
	 * @see ArrayList
	 */

	public void setSkillCategories(ArrayList<SkillCategory> skillCategories) {
		
		this.skillCategories = skillCategories;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To find a certain skill category within the <code>ArrayList</code> of skill categories attached to an instance of <code>Player</code> and return that <code>SkillCategory</code> instance.
	 * </p>
	 * 
	 * @param category		<code>String</code> input to search for.
	 * 
	 * @see Player
	 * @see SkillCategory
	 * @see String
	 * @see ArrayList
	 */

	public SkillCategory getSkillCategories(String category) {														// Method with parameter.
		
		for (SkillCategory item : skillCategories) {																// For Each loop. Loops through each element within an ArrayList attached to a Player instance. 													
			
			if (item.getCategoryName().equals(category)) {															// If Statement. Checks name of current element is equal to the parameter.
				
				return item;																						// True. Return element.
			
			}																					
		}
		
		return null;																								// False. Return null.
	}	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in position variable for an instance of <code>Player</code>.
	 * </p>
	 * 
	 * @see Player
	 * @see Position
	 */ 

	public Position getPosition() {
		
		return position;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in position variable for an instance of <code>Player</code> and returns as a <code>String</code>
	 * </p>
	 * 
	 * @see Player
	 * @see Position
	 * @see String
	 */ 

	public String getStringPosition() {
		
		return (getPosition().toString());
		
	}

	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the position variable for an instance of <code>Player</code> to the parameter.
	 * </p>
	 * 
	 * @param position		<code>Position</code> input to set position variable in <code>Player</code> class to.
	 * 
	 * @see Player
	 * @see Position
	 */
	
	public void setPosition(Position position) {
		
		this.position = position;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in profileDate variable for an instance of <code>Player</code>.
	 * </p>
	 * 
	 * @see Player
	 */ 

	public String getProfileDate() {
		
		return profileDate;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the profileDate variable for an instance of <code>Player</code> to the parameter.
	 * </p>
	 * 
	 * @param profileDate		<code>String</code> input to set profileDate variable in <code>Player</code> class to.
	 * 
	 * @see Player
	 * @see String
	 */

	public void setProfileDate(String profileDate) {
		
		this.profileDate = profileDate;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * A toString override method for the <code>Player</code> Class.
	 * </p>
	 * 
	 * @see Player
	 */
	
	public String toString() {
		
		return getFullName();
		
	}
	
	
}
