package skillTracking;

//Class

/**
 * <h1> Abstract Class </h1>
 * 
 * <p>
 * Storing variables and methods in relation to all rugby club members.
 * Can create and alter information about the objects in the class and those classes who inherit from it.
 * </p>
 * <p>
 * Is used primarily for its methods by subclasses, for calling on an instance of an objects information.
 * </p>
 * <p>
 * Each member has its own first name, last name, memberID and age bracket.
 * </p>
 * 
 * @author David Kilpatrick
 * @version 1.0
 * @since 17/04/2020
 * 
 * @see java.io.Serializable
 */

public abstract class Member implements java.io.Serializable{

	// Variables
	
	private String firstName;													// Variable to store first name for an instance of Member.
	private String lastName;													// Variable to store last name for an instance of Member.
	private TeamAgeBracket teamAgeBracket; 										// Variable to store age group for an instance of Member.
	private String memberID;													// Variable to store memberID for an instance of Member. String was selected so a memberID could include letters and numbers. This program uses a member type plus size
																				// of member pool to generate the memberID. This means every member has a unique ID but also defines their type. Coach2 or Player 12 for example.
	
	// Constructors
	
	// Default 
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>Member</code> class. 
	 * </p>
	 * 
	 * @see Member	
	 */
	
	public Member() {
		
	}
	
	// Overloaded 
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Overloaded constructor for the <code>Member</code> class.
	 * </p>
	 * 
	 * <p>
	 * Is main constructor that is utilised by classes inheriting from this superclass when creating new members.
	 * All members have a first name, last name, age group and memberID.
	 * </p>
	 * 
	 * @param firstName				<code>String</code> input to set firstName variable in <code>Member</code> class to.
	 * @param lastName				<code>String</code> input to set lastName variable in <code>Member</code> class to.
	 * @param teamAgeBracket		<code>TeamAgeBracket</code> input to set teamAgeBracket variable in <code>Member</code> class to. 
	 * @param memberID				<code>String</code> input to set memberID variable in <code>Member</code> class to. 
	 * 
	 * @see Member
	 * @see TeamAgeBracket
	 * @see String
	 */
	
	public Member(String firstName, String lastName, TeamAgeBracket teamAgeBracket, String memberID) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamAgeBracket = teamAgeBracket;
		this.memberID = memberID;

	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in firstName variable for an instance of <code>Member</code>.
	 * </p>
	 * 
	 * 
	 * @see Member
	 */
	
	public String getFirstName() {
		
		return firstName;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the firstName variable for an instance of <code>Member</code> to the parameter .
	 * </p>
	 * 
	 * @param firstName		<code>String</code> input to set firstName variable in <code>Member</code> class to.
	 * 
	 * @see Member
	 * @see String
	 */
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in lastName variable for an instance of <code>Member</code>.
	 * </p>
	 * 
	 * @see Member
	 */
	
	public String getLastName() {
		
		return lastName;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the lastName variable for an instance of <code>Member</code> to the parameter.
	 * </p>
	 * 
	 * @param lastName		<code>String</code> input to set lastName variable in <code>Member</code> class to.
	 * 
	 * @see Member
	 * @see String
	 */
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in firstName and lastName variables for an instance of <code>Member</code>.
	 * </p>
	 * <p>
	 * Used to display a Members full name in one method call.
	 * </p>
	 * 
	 * @see Member
	 * @see String
	 */
	
	public  String getFullName() {
		
		return (getFirstName() + " " + getLastName());
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in teamAgeBracket variable for an instance of <code>Member</code>.
	 * </p>
	 * 
	 * @see Member
	 * @see TeamAgeBracket
	 */

	public TeamAgeBracket getTeamAgeBracket() {
		
		return teamAgeBracket;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the teamAgeBracket variable for an instance of <code>Member</code> to the parameter .
	 * </p>
	 * 
	 * @param teamAgeBracket		<code>TeamAgeBracket</code> input to set teamAgeBracket variable in <code>Member</code> class to.
	 * 
	 * @see Member
	 * @see TeamAgeBracket
	 */
	
	public void setTeamAgeBracket(TeamAgeBracket teamAgeBracket) {
		
		this.teamAgeBracket = teamAgeBracket;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in memberID variable for an instance of <code>Member</code>.
	 * </p>
	 * 
	 * @see Member
	 */
	
	public String getMemberID() {
		
		return memberID;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the memberID variable for an instance of <code>Member</code> to the parameter.
	 * </p>
	 * 
	 * @param memberID		<code>String</code> input to set memberID variable in <code>Member</code> class to.
	 * 
	 * @see Member
	 * @see String 
	 */
	
	public void setMemberID(String memberID){
		
		this.memberID = memberID;
		
	}
		
}
