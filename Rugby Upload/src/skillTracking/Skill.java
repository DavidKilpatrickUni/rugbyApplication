package skillTracking;

// Class

/**
* <h1> Class </h1>
* 
* <p>
* Storing variables and methods in relation to skills.
* Can create and alter information about the objects in the class.
* </p>
* <p>
* Is used to create, alter and access information about the skills. 
* </p>
* <p>
* Each skill has its own name and rating.
* </p>
* <p>
* <code>Skill</code> instances are put in an <code>ArrayList</code> inside an instance of <code>SkillCategory</code>.
* <br><code>SkillCategory</code> instances are put in an <code>ArrayList</code> inside an instance of <code>Player</code>. 
* </p>
* 
* @author David Kilpatrick
* @version 1.0
* @since 17/04/2020
*
* @see java.io.Serializable
* @see Player
* @see SkillCategory
*/

public class Skill implements java.io.Serializable {
	
	// Variables
	
	private String skill;																						// Variable to store skill name of a skill for an instance of Skill.
	private int rating;																							// Variable to store skill rating of a skill for an instance of Skill.
	
	// Constructors
	
	// Default
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>Skill</code> class. 
	 * </p>
	 * 
	 * @see Skill	
	 */
	
	public Skill() {
	
	}
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Overloaded constructor for the <code>Skill</code> class.
	 * </p>
	 * 
	 * <p>
	 * Constructor that is used when creating a new skill, allocating them a name and rating, for a new playing member.
	 * <br> Skills are created with preset rating of 0. 
	 * </p>
	 * 
	 * @param skill				<code>String</code> input to set skill variable in <code>Skill</code> class to.
	 *
	 * @see Skill
	 * @see String
	 */
	
	public Skill(String skill) {
		
		this.skill = skill;
		rating = 0;
		
	}
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Overloaded constructor for the <code>Skill</code> class.
	 * </p>
	 * 
	 * <p>
	 * Constructor that is used when creating a new skill, allocating them a name and rating, for a playing member during data generation.
	 * <br> Skills are created with a defined rating. 
	 * </p>
	 * 
	 * @param skill				<code>String</code> input to set skill variable in <code>Skill</code> class to.
	 * @param rating			<code>Integer</code> input to set rating variable in <code>Skill</code> class to.
	 *
	 * @see Skill
	 * @see String
	 * @see Integer
	 */
	
	public Skill(String skill,int rating) {
		
		this.skill = skill;
		this.rating = rating;
		
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in skill variable for an instance of <code>Skill</code>.
	 * </p>
	 * 
	 * @see Skill
	 */
	
	public String getSkill() {
		
		return skill;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the skill variable for an instance of <code>Skill</code> to the parameter.
	 * </p>
	 * 
	 * @param skill		<code>String</code> input to set skill variable in <code>Skill</code> class to.
	 * 
	 * @see Skill
	 * @see String
	 */
	
	public void setSkill(String skill) {
		
		this.skill = skill;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in rating variable for an instance of <code>Skill</code>.
	 * </p>
	 * 
	 * @see Skill
	 */
	
	public int getRating() {
		
		return rating;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in rating variable for an instance of <code>Skill</code> and returns as a <code>String</code>. Used for text boxes on GUI.
	 * </p>
	 * 
	 * @see Skill
	 */
	
	public String getStringRating() {
		
		return (""+getRating());
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the rating variable for an instance of <code>Skill</code> to the parameter.
	 * </p>
	 * 
	 * @param rating		<code>Integer</code> input to set rating variable in <code>Skill</code> class to.
	 * 
	 * @see Skill
	 * @see Integer
	 */
	
	public void setRating(int rating) {
		
		this.rating = rating;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * A toString override method for the <code>Skill</code> Class.
	 * </p>
	 * 
	 * @see Skill
	 */
	
	public String toString() {
		
		return getSkill();
		
	}
}
