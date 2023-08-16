package skillTracking;

//Class

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Storing variables and methods in relation to coach members.
 * Can create and alter information about the objects in the class.
 * Inherits from the <code>Member</code> class.
 * </p>
 * 
 * <p>
 * Is used for creating new coach members.
 * </p>
 * <p>
 * 
 * Each coach has its own details about email and password.
 * <br>These details are used to create login accounts.
 * <br>Every squad is allocated a coach.
 * </p>
 * 
 * @author David Kilpatrick
 * @version 1.0
 * @since 17/04/2020
 *
 * @see Member
 * @see java.io.Serializable
 */

public class Coach extends Member implements java.io.Serializable {

	// Variables
	
	private transient String password;																					// Variable to store password for an instance of Coach. Transient for security reasons as it is a password
	private String email;																								// Variable to store email for an instance of Coach.

	// Constructors
	
	// Default
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>Coach</code> class. 
	 * </p>
	 * 
	 * @see Coach	
	 */
	
	public Coach() {
		
	}
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Overloaded constructor for the <code>Coach</code> class.
	 * </p>
	 * 
	 * <p>
	 * Is main constructor that is used when creating new coach members. Utilises constructor from superclass <code>Member</code> and adds extra parameters.
	 * A coach has an email address and password.
	 * </p>
	 * 
	 * @param firstName				<code>String</code> input to set firstName variable in <code>Member</code> class to.
	 * @param lastName				<code>String</code> input to set lastName variable in <code>Member</code> class to.
	 * @param teamAgeBracket		<code>TeamAgeBracket</code> input to set teamAgeBracket variable in <code>Member</code> class to. 
	 * @param memberID				<code>String</code> input to set memberID variable in <code>Member</code> class to. 
	 * @param email					<code>String</code> input to set email variable in <code>Coach</code> class to.
	 * @param password				<code>String</code> input to set password variable in <code>Coach</code> class to.
	 * 
	 * @see Member
	 * @see Coach
	 * @see TeamAgeBracket
	 * @see String
	 */
	
	public Coach(String firstName, String lastName, TeamAgeBracket teamAgeBracket, String memberID, String email, String password) {
		
		super(firstName, lastName, teamAgeBracket, memberID);
		this.password = password;
		this.email = email;
	
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in password variable for an instance of <code>Coach</code>.
	 * </p>
	 * 
	 * @see Coach
	 */

	public String getPassword() {
		
		return password;
		
	}

	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the password variable for an instance of <code>Coach</code> to the parameter .
	 * </p>
	 * 
	 * @param password		<code>String</code> input to set password variable in <code>Coach</code> class to.
	 * 
	 * @see Coach
	 * @see String
	 */
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}

	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in email variable for an instance of <code>Coach</code>.
	 * </p>
	 * 
	 * @see Coach
	 */
	
	public String getEmail() {
		
		return email;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Sets the email variable for an instance of <code>Coach</code> to the parameter.
	 * </p>
	 * 
	 * @param email		<code>String</code> input to set email variable in <code>Coach</code> class to.
	 * 
	 * @see Coach
	 * @see String
	 */

	public void setEmail(String email) {
		
		this.email = email;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * A toString override method for the <code>Coach</code> Class.
	 * </p>
	 * 
	 * @see Coach
	 */

	public String toString() {
		
		return getFirstName();
		
	}
	
}
