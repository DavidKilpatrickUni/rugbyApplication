package skillTracking;

// Class

/**
 * <h1> Program </h1>
 * 
 * <p>
 * A skill Tracking program prototype designed to fulfil the wishes and expectations of Simply Rugby. 
 * All data is generated at start up or imported from serialised files.
 * </p>
 * <p>
 * There is a login system to allow preset user accounts access to the program.
 * Each account has a set age group to work within and can only see a squad at that age bracket. 
 * Users can then navigate the user interfaces to see layout and functionality.<br> 
 * <br>The program has two main functions. 
 * <br>1. To allow users to select a playing members profile from the specific age group squad.
 * <br>2. To view and alter player profiles of that squad as they see fit.
 * </p>
 * 
 * @author David Kilpatrick
 * @version 1.0
 * @since 17/04/2020
 */

public class Rugby {
	
	/**
	 * <h1> Main </h1>
	 * <p>
	 * Lunches new <code>Controller</code> to start the program.
	 * <p>
	 * 
	 * @param  args
	*/
	
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
	}

}
