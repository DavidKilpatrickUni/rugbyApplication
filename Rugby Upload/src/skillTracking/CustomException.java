package skillTracking;

//Class

/**
* <h1> Class </h1>
* 
* <p>
* Create custom exceptions that can have base or defined messages.
* </p>
* <p>
* Used many times throughout the program using the defined message feature to fit scenario or exception.
* </p>
* 
* @author David Kilpatrick
* @version 1.0
* @since 17/04/2020
*
* @see Exception
*/

public class CustomException extends Exception {

	// Variables
	
	private String errorMessage = "Error has occured";													// Variable to store error message for an instance of CustomException. Has a preset message.
	
	// Constructors
	
	// Default
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>CustomException</code> class. 
	 * </p>
	 * 
	 * @see CustomException	
	 * @see Exception
	 */
	
	public CustomException() {
		
	}
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Overloaded constructor for the <code>CustomException</code> class.
	 * </p>
	 * 
	 * <p>
	 * Is main constructor that is used when creating custom exceptions. Parameter allows errorMessage variable within the <code>CustomException</code> 
	 * class for this instance, to be altered to fit the current scenario or exception.
	 * </p>
	 * 
	 * @param altErrorMessage				<code>String</code> input to set altErrorMessage variable in <code>CustomException</code> class to.
	 * 
	 * @see CustomException
	 * @see Exception
	 */
	
	public CustomException(String altErrorMessage) {
		
		errorMessage = altErrorMessage;
		
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Retrieves the data held in errorMessage variable for an instance of <code>CustomException</code>.
	 * </p>
	 * 
	 * @see CustomException
	 * @see Exception
	 */
	
	public String getMessage() {

		return errorMessage;
	
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * A toString override method for the <code>CustomException</code> Class.
	 * </p>
	 * 
	 * @see CustomException
	 * @see Exception
	 */
	
	public String toString() {
		
		return getMessage();
		
	}
	
}
	
	

