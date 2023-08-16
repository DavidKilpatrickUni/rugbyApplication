package skillTracking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Color;

// Class

/**
 * <h1> Class </h1>
 * 
 * <p>
 * View part of the MVC structure.
 * </p>
 * 
 * <p>
 * Main Menu Screen
 * </p>
 * 
 * <p>
 * Has a direct link with the <code>Controller</code> that enables communication and completion of tasks.
 * <br>Reading and interpreting user actions through the <code>View</code>.
 * <br>Sending them to <code>Controller</code> to be processed.
 * </p>
 * 
 * <p>
 * Main hub of the program once fully functional.
 * <br>Is used to display information to the user and receive input from a user.
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

public class MainMenuScreen extends JFrame {

	// Variables
	
	private Controller myController;																						// Controller variable for storing instance of the Controller being used during program runtime.
	private Coach myDetails;																								// Variable to store current user. The instance of Coach.
	
	private JPanel contentPane;																								// JPanel variable for storing the panel that all GUI elements are added to.
	private JTextField txtCoach;																							// JTextField variable for contents of textField.
	private JTextField txtSquad;																							// JTextField variable for contents of textField.

	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>MainMenuScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * </p>
	 * 
	 * <p>
	 * First parameter is to set up a connection with the <code>Controller</code>.
	 * <br>Second is which instance of <code>Coach</code> to use for content generation and menu options.
	 * </p>
	 * 
	 * @param controller		<code>Controller</code> input to set controller variable to.
	 * @param userDetails		<code>Coach</code> input to set userDetails variable to.
	 * 
	 * @see Controller
	 * @see MainMenuScreen
	 * @see Coach
	 */
	
	public MainMenuScreen(Controller controller, Coach userDetails) {
		
		myController = controller;																								// Set Variable to parameter.																				
		myDetails = userDetails;																								// Set Variable to parameter.															
		
		TeamAgeBracket ageGroup = myDetails.getTeamAgeBracket();																// Set Variable to parameter. Retrieve age group of coach.
		Squad mySquad = myController.getMySquad(ageGroup);																		// Set Variable to parameter. Retrieve squad of given age group.
		String coachNameLabel = myDetails.getFullName();																		// Set Variable to parameter. Coaches full name String.
		String ageLabel = mySquad.getSquadName();																				// Set Variable to parameter. Squad name String.
		
		//
		// GUI element creation
		//
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Rugby.class.getResource("/RugbyBall.PNG")));							// Set Tool bar Icon.
		setTitle("Simply Rugby - Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblScreenLabel = new JLabel("Main Menu");
		lblScreenLabel.setForeground(new Color(0, 153, 255));
		lblScreenLabel.setBackground(new Color(0, 153, 255));
		lblScreenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblScreenLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 28));
		lblScreenLabel.setBounds(315, 40, 160, 40);
		contentPane.add(lblScreenLabel);
		
		JLabel lblCoach = new JLabel("Coach");
		lblCoach.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoach.setForeground(new Color(0, 153, 255));
		lblCoach.setBounds(225, 110, 140, 14);
		contentPane.add(lblCoach);
		
		//
		// Coach textField - Dynamically displays full name of current user (Coach). Not user editable.
		//
		
		txtCoach = new JTextField(coachNameLabel);																				// Set textField text to variable.
		txtCoach.setBackground(Color.WHITE);
		txtCoach.setToolTipText("Coach - Current coach logged into program.");
		txtCoach.setHorizontalAlignment(SwingConstants.CENTER);
		txtCoach.setEditable(false);
		txtCoach.setBounds(225, 140, 140, 25);
		contentPane.add(txtCoach);
		txtCoach.setColumns(10);
		
		JLabel lblAgeGroup = new JLabel("Squad");
		lblAgeGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeGroup.setForeground(new Color(0, 153, 255));
		lblAgeGroup.setBounds(425, 110, 140, 14);
		contentPane.add(lblAgeGroup);
		
		//
		// Squad textField - Dynamically displays Squad of which the current user manages and has access to. Not user editable.
		//
		
		txtSquad = new JTextField(ageLabel);																					// Set textField text to variable.
		txtSquad.setBackground(Color.WHITE);
		txtSquad.setToolTipText("Squad - Squad the current coach is head of.");
		txtSquad.setHorizontalAlignment(SwingConstants.CENTER);
		txtSquad.setEditable(false);
		txtSquad.setBounds(425, 140, 140, 25);
		contentPane.add(txtSquad);
		txtSquad.setColumns(10);
		
		JButton btnPlayerDetails = new JButton("Player Details");
		btnPlayerDetails.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Link to Player Details screen - Not part of the prototype build");
				
			}
		});
		btnPlayerDetails.setToolTipText("Player Details - Not a function of this prototype. \r\nUsed to display expected layout.");
		btnPlayerDetails.setBounds(225, 240, 140, 25);
		contentPane.add(btnPlayerDetails);
		
		JButton btnTraining = new JButton("Training Sessions");
		btnTraining.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Link to Training Sessions screen - Not part of the prototype build");
				
			}
		});
		btnTraining.setToolTipText("Training Sessions - Not a function of this prototype. \r\nUsed to display expected layout.");
		btnTraining.setBounds(425, 240, 140, 25);
		contentPane.add(btnTraining);
		
		//
		// Player Profile Button
		//
		
		JButton btnPlayerProfiles = new JButton("Player Profiles");
		btnPlayerProfiles.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																		// ActionListener for Button press.
				
				myController.initPlayerProfileSelect(mySquad);																	// Use connection with Controller to start method.
				dispose();																										// Close the current instance of MainMenuScreen.
				
			}
		});
		btnPlayerProfiles.setToolTipText("Player Profiles - Click this button to progress to Player Profile Select screen.");
		btnPlayerProfiles.setBounds(225, 290, 140, 25);
		contentPane.add(btnPlayerProfiles);
		
		JButton btnFixtures = new JButton("Fixtures");
		btnFixtures.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Link to Fixture screen - Not part of the prototype build");
				
			}
		});
		btnFixtures.setToolTipText("Fixtures - Not a function of this prototype. \r\nUsed to display expected layout.");
		btnFixtures.setBounds(425, 290, 140, 25);
		contentPane.add(btnFixtures);
		
		//
		// Log out Button - Allows current user to log out and return to title screen.
		//
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																		// ActionListener for Button press.
				
				int select;																										// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Are you sure you want to Log out?", "Simply Rugby - Log out", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);		// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {																			// If Statement. Variable value is YES.
					
				myController.initFirstScreen();																					// Use connection with Controller to start method.
				dispose();																										// Close the current instance of MainMenuScreen.
				
				}
			}
		});
		btnLogOut.setToolTipText("Log Out - Click this button to log out and return to Title screen.");
		btnLogOut.setBounds(350, 420, 90, 25);
		contentPane.add(btnLogOut);
		
		//
		// Exit Button
		//
		
		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("Exit - Click this button to exit the program.");
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																		// ActionListener for Button press.
				
				int select;																										// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Simply Rugby - Exit", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);		// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {																			// If Statement. Variable value is YES.
					
					myController.exit();																						// Use connection with Controller to start method.
					
				}
			}
		});
		btnExit.setBounds(350, 470, 90, 25);
		contentPane.add(btnExit);
				
	}
	
}
