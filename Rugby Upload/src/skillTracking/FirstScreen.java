package skillTracking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

// Class

/**
 * <h1> Class </h1>
 * 
 * <p>
 * View part of the MVC structure.
 * </p>
 * 
 * <p>
 * Title Screen
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

public class FirstScreen extends JFrame {

	// Variables
	
	private Controller myController;																	// Controller variable for storing instance of the Controller being used during program runtime.
	
	private JPanel contentPane;																			// JPanel variable for storing the panel that all GUI elements are added to.
	
	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>FirstScreen</code> class. 
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
	 * @see FirstScreen
	 */
	
	public FirstScreen(Controller controller) {																
		
		myController = controller; 																			// Set Variable to parameter.
			
		// GUI element creation
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Rugby.class.getResource("/RugbyBall.PNG")));		// Set Tool bar Icon.
		setTitle("Simply Rugby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblScreenLabel = new JLabel(" Simply Rugby");
		lblScreenLabel.setForeground(new Color(0, 153, 255));
		lblScreenLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 28));
		lblScreenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblScreenLabel.setBounds(300, 40, 200, 40);
		contentPane.add(lblScreenLabel);
			
		//
		// Screen Image - Rugby ball image that is program image, used for tool bar icon and task bar program icon.
		//
		
		ImageIcon rugbyIcon =  new ImageIcon(Rugby.class.getResource("/RugbyBall.PNG"));					// Create new instance of Icon using the given PNG file.
		Image rugbyImage = rugbyIcon.getImage();															// Create image of icon variable.
		Image rugbyImageResize = rugbyImage.getScaledInstance(200,200, java.awt.Image.SCALE_SMOOTH);		// Resize image to scale desired. 
		rugbyIcon = new ImageIcon(rugbyImageResize);														// Set instance of Icon to the resized Image.
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE, 2, true));
		panel.setBounds(300, 145, 200, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel(rugbyIcon);																// Add Icon to label.
		lblLogo.setBounds(0, 0, 200, 200);
		panel.add(lblLogo);
		
		//
		// Login Button
		//
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {													// ActionListener for Button press.
				
				myController.initLoginScreen();																// Use connection with Controller to start method.
				dispose();																					// Close the current instance of FirstScreen.
				
			}
		});
		btnLogin.setToolTipText("Login - Click this button to login into program.");
		btnLogin.setBounds(350, 420, 90, 25);
		contentPane.add(btnLogin);
		
		//
		// Exit Button
		//
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																				// ActionListener for Button press.
				
				int select;																												// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Simply Rugby - Exit", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {																					// If Statement. Variable value is YES.
					
					myController.exit();																								// Use connection with Controller to start method.																					
					
				}	
			}
		});
		btnExit.setToolTipText("Exit - Click this button to exit the program.");
		btnExit.setBounds(350, 470, 90, 25);
		contentPane.add(btnExit);

	}
}
