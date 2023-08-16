package skillTracking;

import java.util.ArrayList;

// Class

/**
* <h1> Class </h1>
* 
* <p>
* Storing variables and methods in relation to skill categories.
* Can create and alter information about the objects in the class.
* </p>
* <p>
* Is used to create, alter and access information about the skill categories.
* </p>
* <p>
* Each skill category has its own name, comment and list of skills.
* </p>
* <p>
* Each <code>SkillCategory</code> instance has an <code>ArrayList</code> of instances of <code>Skill</code>
* <br><code>SkillCategory</code> instances are put in an <code>ArrayList</code> inside an instance of <code>Player</code>. 
* 
* </p>
* 
* @author David Kilpatrick
* @version 1.0
* @since 17/04/2020
*
* @see java.io.Serializable
* @see Player
* @see Skill
* @see ArrayList
*/

public class SkillCategory implements java.io.Serializable{
	
	// Variables
	
	private String categoryName;																												// Variable to store category name of a category for an instance of SkillCategory.
	private ArrayList<Skill> mySkills = new ArrayList<Skill>();																					// ArrayList of Skill variable to store skills in a category for an instance of SkillCategory.
	private String comment;																														// Variable to store a comment for a category for an instance of SkillCategory.
	
	// Constructors
	
	// Default
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>SkillCategory</code> class. 
	 * </p>
	 * 
	 * @see SkillCategory	
	 */
	
	public SkillCategory() {
		
		
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
	 * Constructor that is used when creating a new skill category, allocating them a name, comment and list of skills.
	 * </p>
	 * 
	 * @param skill				<code>String</code> input to set skill variable in <code>Skill</code> class to.
	 *
	 * @see Skill
	 * @see String
	 */
	
	public SkillCategory(String categoryName, ArrayList<Skill> mySkills, String comment) {
		
		this.categoryName = categoryName;
		this.mySkills = mySkills;
		this.comment = comment;
	}

	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in categoryName variable for an instance of <code>SkillCategory</code>.
	 * </p>
	 * 
	 * @see SkillCategory
	 */
	
	public String getCategoryName() {
		
		return categoryName;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the categoryName variable for an instance of <code>SkillCategory</code> to the parameter.
	 * </p>
	 * 
	 * @param categoryName		<code>String</code> input to set categoryName variable in <code>SkillCategory</code> class to.
	 * 
	 * @see SkillCategory
	 * @see String
	 */
	
	public void setCategoryName(String categoryName) {
		
		this.categoryName = categoryName;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in mySkills variable for an instance of <code>SkillCategory</code>.
	 * </p>
	 * 
	 * @see SkillCategory
	 * @see Skill
	 * @see ArrayList
	 */
												
	public ArrayList<Skill> getAllSkills() {
		
		return mySkills;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To find a certain skill within the <code>ArrayList</code> of skills attached to an instance of <code>SkillCategory</code> and return that <code>Skill</code> instance.
	 * </p>
	 * 
	 * @param category		<code>String</code> input to search for.
	 * 
	 * @see SkillCategory
	 * @see Skill
	 * @see String
	 * @see ArrayList
	 */
	
	public Skill getSkill(String skill) {																					// Method with parameter.
		
		for (Skill item : mySkills) {																						// For Each loop. Loops through each element within an ArrayList attached to a SkillCategory instance. 						
			
			if (item.getSkill().equals(skill)) {																			// If Statement. Checks name of current element is equal to the parameter.
				
			return item;																									// True. Return element.
			
			}																					
			
		}
		
		return null;																										// False. Return null.
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in comment variable for an instance of <code>SkillCategory</code>.
	 * </p>
	 * 
	 * @see SkillCategory
	 */
	
	public String getComment() {
		
		return comment;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the comment variable for an instance of <code>SkillCategory</code> to the parameter.
	 * </p>
	 * 
	 * @param comment		<code>String</code> input to set comment variable in <code>SkillCategory</code> class to.
	 * 
	 * @see SkillCategory
	 * @see String
	 */

	public void setComment(String comment) {
		
		this.comment = comment;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * A toString override method for the <code>SkillCategory</code> Class.
	 * </p>
	 * 
	 * @see SkillCategory
	 */
	
	public String toString() {
		
		return getCategoryName();
		
	}
	
	
}
