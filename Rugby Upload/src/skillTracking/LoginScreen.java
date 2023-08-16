package skillTracking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

// Class

/**
 * <h1> Class </h1>
 * 
 * <p>
 * View part of the MVC structure.
 * </p>
 * 
 * <p>
 * Login Screen
 * </p>
 * 
 * <p>
 * Has a direct link with the <code>Controller</code> that enables communication and completion of tasks.
 * <br>Reading and interpreting user actions through the <code>View</code>.
 * <br>Sending them to <code>Controller</code> to be processed.
 * </p>
 * 
 * <p>
 * Is used to display information to the user and receive input from a user.
 * <br>Request user input for account details.
 * <br>Has text boxes to receive input.
 * <br>Has buttons for user navigation.
 * </p>
 * 
 * <p>
 * Firstly sets up the GUI elements.
 * <br>All actions after this are determined by the user through the GUI.
 * </p>
 * 
 * @author David Kilpatrick
 * @version 1.0
 * @since 17/04/2020
 *
 * @see Controller
 */

public class LoginScreen extends JFrame  {
	
	// Variables
	
	private Controller myController;																				// Controller variable for storing instance of the Controller being used during program runtime.
	
	private JPanel contentPane;																						// JPanel variable for storing the panel that all GUI elements are added to.
	private JTextField txtUserName;																					// JTextField variable for contents of textField.
	private JPasswordField txtPassword;																				// JPassworField variable for contents of textField.

		// Constructors
	
		// Overloaded
		
		/**
		 * <h1> Constructor </h1>
		 * 
		 * <p>
		 * Default constructor for the <code>LoginScreen</code> class. 
		 * </p>
		 * 
		 * <p>
		 * Sets up GUI elements and adds them to JPanel variable.
		 * <br>Has ActionListeners to act on user input.
		 * </p>
		 * 
		 * <p>
		 * Parameter is to set up a connection with the <code>Controller</code>.
		 * </p>
		 * 
		 * @param controller		<code>Controller</code> input to set controller variable to.
		 * 
		 * @see Controller
		 * @see LoginScreen
		 */
	
	public LoginScreen(Controller controller) {
		
		myController = controller;																					// Set Variable to parameter.
		
		// GUI element creation
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Rugby.class.getResource("/RugbyBall.PNG")));				// Set Tool bar Icon.
		setTitle("Simply Rugby - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblScreenLabel = new JLabel("Welcome");
		lblScreenLabel.setForeground(new Color(0, 153, 255));
		lblScreenLabel.setBackground(new Color(0, 153, 255));
		lblScreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblScreenLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 28));
		lblScreenLabel.setBounds(295, 40, 200, 40);
		contentPane.add(lblScreenLabel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setForeground(new Color(0, 153, 255));
		lblUserName.setBackground(new Color(0, 153, 255));
		lblUserName.setBounds(295, 110, 200, 14);
		contentPane.add(lblUserName);
		
		//
		// Username textField - Has key press override to process textbox input. For functionality and user experience.
		//
		
		txtUserName = new JTextField();
		txtUserName.setToolTipText("User Name - Normally an email address.");
		txtUserName.setBounds(295, 140, 200, 25);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {														// ActionListener for key press.
				
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {											// If Statement. Key press is 'Enter'.
					
					enterLogin();																		// True. Run method.
					
				}	
			}
		});
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(0, 153, 255));
		lblPassword.setBackground(new Color(0, 153, 255));
		lblPassword.setBounds(295, 180, 200, 14);
		contentPane.add(lblPassword);
		
		//
		// Password textField - Has key press override to process textbox input. For functionality and user experience.
		//
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Password - Password for given User Name.");
		txtPassword.setBounds(295, 210, 200, 25);
		contentPane.add(txtPassword);
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {														// ActionListener for key press.
				
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {											// If Statement. Key press is 'Enter'.
					
					enterLogin();																		// True. Run method.
					
				}
			}
		});
		
		//
		// Login Button
		//
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {												// ActionListener for Button press
			
				enterLogin();																			// Run Method.
			
			}
		});
		btnLogin.setToolTipText("Login - Click this button to login into program.");
		btnLogin.setBounds(350, 260, 90, 25);
		contentPane.add(btnLogin);
		
		JLabel lblRegister = new JLabel("New To Simply Rugby");
		lblRegister.setForeground(new Color(0, 153, 255));
		lblRegister.setBackground(new Color(0, 153, 255));
		lblRegister.setBounds(333, 370, 128, 14);
		contentPane.add(lblRegister);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Link to a new member registration screen - Not part of the prototype build");
				
			}
		});
		btnRegister.setToolTipText("Register - Not a function of this prototype. \r\nUsed to display expected layout.");
		btnRegister.setBounds(350, 400, 90, 25);
		contentPane.add(btnRegister);
		
		//
		// Exit Button
		//
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																	// ActionListener for Button press
				
				int select; 																								// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Simply Rugby - Exit", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);	// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {																		// If Statement. Variable value is YES
					
					myController.exit();																					// Use connection with Controller to start method
					
				}
			}
		});
		btnExit.setToolTipText("Exit - Click this button to exit the program.");
		btnExit.setBounds(350, 470, 90, 25);
		contentPane.add(btnExit);
	
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Checks contents of textFields of the GUI.
	 * </p>
	 * 
	 * <p>
	 * Used to check that the given inputs have a value within them.
	 * <br>Utilises .isEmpty().
	 * </p>
	 * 
	 * @param   userName	<code>String</code> input content of GUI userName textFields.
	 * @param	password	<code>String</code> input content of GUI password textFields.
	 * 
	 * @return <b>result</b>	<code>Boolean</code> output that program uses to make decisions.
	 * 
	 * @exception CustomException
	 * 
	 * @see LoginScreen
	 * @see Boolean
	 * @see String
	 */
	
	private boolean checkFields(String userName , String password) throws CustomException{								// Method with parameters. The content Strings of the userName and password text boxes.
		
		boolean result;																									// Variable to store result of check.
		
		result = true;																									// Set variable to true. Base setting only changed if textField contents are empty.
		
		if (userName.isEmpty() || password.isEmpty()) {																	// If statement with 2 conditions, must passed both. Use .isEmpty() to check contents of parameters.
			
			result = false;																								// True. Set variable to false
			throw new CustomException("Enter valid details to login");													// Create new instance of CustomException with message parameter.
			
		}
		
		return result;																									// Return Result.
		
	}
	
		/**
		 * <h1> Method </h1>
		 * 
		 * <p> 
		 * To process user input for a login attempt.
		 * </p>
		 * 
		 * <p>
		 * Used to call methods to validate user input.
		 * <br>Valid details result in program progression.
		 * <br>Invalid returns error message.
		 * <br>Utilises checkFields method.
		 * <br>Utilises checkLogin method.
		 * </p>
		 * 
		 * <p>
		 * Firstly removes whitespace and checks for textFieldscontents.
		 * <br><code>IF</code> content exists, pass it through a login method.
		 * <br><code>IF</code> a valid login, a new viewport is displayed.
		 * <br>Failed checks create a new instance of <code>CustomException</code>.
		 * </p>
		 * 
		 * @exception CustomException
		 * 
		 * @see LoginScreen
		 */
	
	private void enterLogin() {
		
		boolean checkFields;																												// Variable to store result of method call
		boolean checkLogin;																													// Variable to store result of method call
		String username;																													// Variable to store username textField String
		String password;																													// Variable to store password textField String
		
		username = txtUserName.getText().trim();																							// Set variable to username textField contents removing whitespace.
		password = txtPassword.getText().trim();																							// Set variable to password textField contents removing whitespace.
		
		try {									
			
			checkFields = checkFields(username,password);																					// Set variable to result of passing variables through given method.
		
				try {
					
					if (checkFields) {																										// If Statement. The text boxes do contain content.
						
						checkLogin = myController.checkLogin(username,password);															// True. Set variable to result of passing variables through given method.
						
						if (checkLogin) {																									// If Statement. The input details provided are those of a valid login account.
							
							myController.loginUser(username);																				// Use connection with Controller to start method.
							dispose();																										// Close the current instance of LoginScreen.
							
						}
					}
					
				} catch (CustomException error) {																							// Exception
		
					JOptionPane.showMessageDialog(null, error, "Simply Rugby - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);		// Pop up message box with custom message 
				
				}
				
		} catch (CustomException error) {																									// Exception
			
			JOptionPane.showMessageDialog(null, error, "Simply Rugby - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);				// Pop up message box with custom message 
			
		}	
	}

}
