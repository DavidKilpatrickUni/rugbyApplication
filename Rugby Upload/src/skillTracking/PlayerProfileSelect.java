package skillTracking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * View part of the MVC structure.
 * </p>
 * 
 * <p>
 * Player Profile Select Screen
 * </p>
 * 
 * <p>
 * Has a direct link with the <code>Controller</code> that enables communication and completion of tasks.
 * <br>Reading and interpreting user actions through the <code>View</code>.
 * <br>Sending them to <code>Controller</code> to be processed.
 * </p>
 * 
 * <p>
 * Screen used for searching for or selecting a player from a given squad of players.
 * <br>Is used to display information to the user and receive input from a user.
 * <br>Has buttons for user navigation.
 * <br>Text field for search input.
 * <br>Radio buttons to define search criteria.
 * <br>ComboBox to select player from given squad list.
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

public class PlayerProfileSelect extends JFrame {

	// Variables 
	
	private Controller myController;																						// Controller variable for storing instance of the Controller being used during program runtime.
	private Squad squadInfo; 																								// Variable to store current users squad. The instance of Squad.
	private int playerSelection;																							// Variable to store current highlighted item in comboBox. 
																															// Will be set to element number of highlighted item in the comboBox relevant to position in the array it is displaying.
	
	private String radioSelect;																								// Variable to store type of search to do based on which radio button is selected.																								
	
	private JPanel contentPane;																								// JPanel variable for storing the panel that all GUI elements are added to.
	private JTextField txtSearch;																							// JTextField variable for contents of textField.
	private JTextField txtSquad;																							// JTextField variable for contents of textField.
	
	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>PlayerProfileSelect</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * </p>
	 * 
	 * <p>
	 * First parameter is to set up a connection with the <code>Controller</code>.
	 * <br>Second is which instance of <code>Squad</code> to use for content generation.
	 * </p>
	 * 
	 * @param controller		<code>Controller</code> input to set controller variable to.
	 * @param squadPlayers		<code>Squad</code> input to set squadPlayers variable to.
	 * 
	 * @see Controller
	 * @see PlayerProfileSelect
	 * @see Squad
	 */
	
	public PlayerProfileSelect(Controller controller, Squad squadPlayers) {
		
		myController = controller;																							// Set Variable to parameter.		
		squadInfo = squadPlayers;																							// Set Variable to parameter.		
		
		// GUI element creation
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Rugby.class.getResource("/RugbyBall.PNG")));						// Set Tool bar Icon.
		setTitle("Simply Rugby - Player Profile Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblScreenLabel = new JLabel("Player Profile Select");
		lblScreenLabel.setForeground(new Color(0, 153, 255));
		lblScreenLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblScreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblScreenLabel.setBounds(247, 40, 296, 40);
		contentPane.add(lblScreenLabel);
		
		//
		// Screen Image - Image that is used to signify squad. To build user familiarity.
		//
		
		ImageIcon squadIcon =  new ImageIcon(Rugby.class.getResource("/RugbySquad.PNG"));									// Create new instance of Icon using the given PNG file.
		Image squadImage = squadIcon.getImage();																			// Create image of icon variable.
		Image squadImageResize = squadImage.getScaledInstance(140,100, java.awt.Image.SCALE_SMOOTH);						// Resize image to scale desired. 
		squadIcon = new ImageIcon(squadImageResize);																		// Set instance of Icon to the resized Image.
		
		JPanel panelIcon = new JPanel();
		panelIcon.setBounds(318, 100, 140, 100);
		contentPane.add(panelIcon);
		panelIcon.setLayout(null);
		
		JLabel lblIcon = new JLabel(squadIcon);																				// Add Icon to label.
		lblIcon.setBounds(0, 0, 140, 100);
		panelIcon.add(lblIcon);
		
		//
		// Squad textField - Dynamically displays Squad of which a Player Profile can be selected. Not user editable.
		//
		
		txtSquad = new JTextField(squadInfo.getSquadName() + " Squad");														// Set textField text to method call.
		txtSquad.setBackground(Color.WHITE);
		txtSquad.setHorizontalAlignment(SwingConstants.CENTER);
		txtSquad.setEditable(false);
		txtSquad.setToolTipText("Squad - Current squad to select a player profile from.");
		txtSquad.setBounds(318, 210, 140, 25);
		contentPane.add(txtSquad);
		txtSquad.setColumns(10);
		
		JLabel lblSearchForPlayer = new JLabel("Search For Player");
		lblSearchForPlayer.setForeground(new Color(0, 153, 255));
		lblSearchForPlayer.setBounds(165, 270, 112, 14);
		contentPane.add(lblSearchForPlayer);
		
		JLabel lblSearchBy = new JLabel("By:");
		lblSearchBy.setForeground(new Color(0, 153, 255));
		lblSearchBy.setBackground(Color.WHITE);
		lblSearchBy.setBounds(165, 295, 20, 14);
		contentPane.add(lblSearchBy);
		
		//
		// Button Group - Set Up a button group with 2 radio buttons. Means when one is selected the other is unselected. Used to define the search criteria. 
		//
		
		ButtonGroup radioButtons = new ButtonGroup();

		JRadioButton rdbtnName = new JRadioButton("Full Name");																	// Create search by Full Name Radio Button
		rdbtnName.setSelected(true);
		rdbtnName.setBackground(Color.WHITE);
		rdbtnName.setForeground(new Color(0, 153, 255));
		rdbtnName.setToolTipText("Full Name - Search by full name. ");
		rdbtnName.setBounds(190, 290, 85, 23);
		contentPane.add(rdbtnName);
		
		JRadioButton rdbtnID = new JRadioButton("Member ID");																	// Create search by MemberID Radio Button
		rdbtnID.setBackground(Color.WHITE);
		rdbtnID.setForeground(new Color(0, 153, 255));
		rdbtnID.setToolTipText("Member ID - Search by member ID.");
		rdbtnID.setBounds(280, 290, 95, 23);
		contentPane.add(rdbtnID);
		
		radioButtons.add(rdbtnName);																							// Add button to Button Group
		radioButtons.add(rdbtnID);																								// Add button to Button Group
		
		//
		// Search textField
		//
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Search Bar - Enter search criteria and then click the Search button.");
		txtSearch.setBounds(165, 320, 310, 25);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		//
		// Search Button - Search for a player by type. Uses the radio buttons to define type of search, by fullName or memberID, and txtSearch text field for what user String to search for.
		//
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																						// ActionListener for Button press.
				
				if (rdbtnName.isSelected()) {																									// If Statement. Check state of radio button.			
					
					radioSelect = "Name";																										// Set variable to String.
					
				}else if (rdbtnID.isSelected()) {																								// If Else Statement. Check state of radio button.
					
					radioSelect = "ID";																											// Set variable to String.
					
				}
				
			searchFor(radioSelect);																												// Run method with parameter.
						
			}
		});
		btnSearch.setToolTipText("Search - Click this button to search for the player entered");
		btnSearch.setBounds(525, 320, 90, 25);
		contentPane.add(btnSearch);
		
		JLabel lblSquadPlayerList = new JLabel("Squad Player List");
		lblSquadPlayerList.setForeground(new Color(0, 153, 255));
		lblSquadPlayerList.setBounds(165, 360, 112, 14);
		contentPane.add(lblSquadPlayerList);
		
		//
		// ComboBox - Displays all players in current squad. ComboBox utilises toArray() to do this.
		//
		
		JComboBox comboBox = new JComboBox(squadInfo.getSquadPlayers().toArray());																// Create new comboBox with all values from selected ArrayList. Utilises toArray().
		comboBox.setMaximumRowCount(5);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setBackground(Color.WHITE);
		comboBox.setToolTipText("Squad Player List - Select a player from the drop down menu and then click the Select button.");
		comboBox.setBounds(165, 390, 310, 25);
		contentPane.add(comboBox);
		
		//
		// Select Player Button - Selects current player highlighted in comboBox and opens Player Profile Screen with their details. 
		// Utilises getSelectedIndex() from comboBox - This gets the element number of highlighted item in the comboBox relevant to position in the array it is displaying.
		//
		
		JButton btnSelectPlayer = new JButton("Select");
		btnSelectPlayer.addActionListener(new ActionListener() {																				
			
			public void actionPerformed(ActionEvent e) {																						// ActionListener for Button press.
				
				dispose();																														// Close the current instance of PlayerProfileSelect.
				playerSelection = comboBox.getSelectedIndex();																					// Set variable to element value of highlighted item in comboBox. Utilises getSelectIndex().
		
				myController.initPlayerProfileScreen(myController.getThisPlayerByNumber(squadInfo, playerSelection));							// Use connection with Controller to start method.
	
					
			}
		});
		btnSelectPlayer.setToolTipText("Select - Click this buton to select the player from the list.");
		btnSelectPlayer.setBounds(525, 390, 90, 25);
		contentPane.add(btnSelectPlayer);
		
		//
		// Back Button - returns user to Main Menu Screen
		//
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																						// ActionListener for Button press.
				
				myController.backMainMenuScreen();																								// Use connection with Controller to start method.
				dispose();																														// Close the current instance of PlayerProfileSelect.
				
			}
		});
		btnBack.setToolTipText("Back - Click this button to return to Main Menu.");
		btnBack.setBounds(350, 470, 90, 25);
		contentPane.add(btnBack);
		
	}
	
	// Methods
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Checks contents of textField of the GUI.
	 * </p>
	 * 
	 * <p>
	 * Used to check that the given input have a value within it.
	 * <br>Utilises .isEmpty().
	 * </p>
	 * 
	 * @param   search	<code>String</code> input content of GUI search textField.
	 * 
	 * @return <b>result</b>	<code>Boolean</code> output that program uses to make decisions.
	 * 
	 * @exception CustomException
	 * 
	 * @see MainMenuScreen
	 * @see Boolean
	 * @see String
	 */
	
	private boolean checkFields(String search) throws CustomException{										// Method with parameters. The content Strings of the userName and password text boxes.
		
		boolean result;																						// Variable to store result of check.
		
		result = true;																						// Set variable to true. Base setting only changed if textField contents are empty.
		
		if (search.isEmpty()) {																				// If statement. Use .isEmpty() to check content of parameter.
			
			result = false;																					// True. Set variable to false
			throw new CustomException("Enter a player to search for.");										// Create new instance of CustomException with message parameter.
			
		}
		
		return result;																						// Return Result.
	}

	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * To process user input for a search attempt.
	 * </p>
	 * 
	 * <p>
	 * Used to call methods to validate user input.
	 * <br>Valid search result in program progression.
	 * <br>Invalid returns error message.
	 * <br>Utilises checkFields method.
	 * </p>
	 * 
	 * <p>
	 * Firstly removes whitespace and checks for textFields contents.
	 * <br><code>IF</code> Content exist uses parameter to determine what type of search to do - By fullName or by memberID
	 * <br><code>IF</code> by fullName, passes input through an ignoreCase by fullName method.
	 * <br><code>IF</code> a match is found, passes the result of ignoreCase by fullName method through a second method to find <code>Player</code> instance with matching fullName.
	 * <br>When found a final method is used to create new instance of <code>PlayerProfileScreen</code> using the <code>Player</code> instance.
	 * <br><code>IF</code> by memberID, passes input through an ignoreCase memberID method.
	 * <br><code>IF</code> a match is found, passes the result of ignoreCase by memberID method through a second method to find <code>Player</code> instance with matching memberID.
	 * <br>When found a final method is used to create new instance of <code>PlayerProfileScreen</code> using the <code>Player</code> instance.
	 * </p>
	 * <p>
	 * Failed checks create a new instance of <code>CustomException</code>.
	 * </p>
	 * 
	 * @param radioSelect  <code>String</code> input to define the search criteria.
	 * 
	 * @exception CustomException
	 * 
	 * @see LoginScreen
	 * @see PlayerProfileScreen
	 * @see Player
	 */
	
	private void searchFor(String radioSelect) {																								//Method with parameter. The radio button that is selected.
		
		try {								
			
			boolean checkFields;																												// Variable to store result of method check.
			
			String search;																														// Variable to store text field content.
			
			search = txtSearch.getText().trim();																								// Set variable to text field content removing whitespace																		
			
			checkFields = checkFields(search);																									// Set variable to result of method.
		
				if (checkFields) {																												// If Statement. The text field contents exist.
					
					if (radioSelect.equals("Name")) {																							// True, content exists. If Statement checking parameter String.
					
						try {	
							
						String caseCheck = myController.checkNameCase(squadInfo,search);														// True, radio button is set for fullName search. Set variable to result of ignoreCase check. A new String that can be used.													
						
							if (caseCheck != null) {																							// If Statement. Variable is not null.																					
							
								boolean searchNameResult;																						// True, not null. Variable to store result of method.
							
								searchNameResult = myController.playerSearchByName(squadInfo,caseCheck); 										// Set variable to result of method. A search for player by the new String that was created.
					
								if (searchNameResult){																							// If Statement. A player of the fullName given after ignoreCase is found.
						
									myController.initPlayerProfileScreen(myController.getThisPlayerByName(squadInfo,caseCheck));				// True, player fullName found. Run method with parameters to create new instance of PlayerProfile Screen
									dispose();																									// Close current Screen
						
								}
							}
							
						}catch (CustomException error){																							// Exception. ignoreCase check does not match a fullName.
							
							JOptionPane.showMessageDialog(null, error, "Simply Rugby - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	// Return CustomException message.
							
						}
						
						
					}else {																														// The radio button is set to memberID
						
						try {
							
							String caseCheck = myController.checkIDCase(squadInfo,search);														// Set variable to result of ignoreCase check. A new String that can be used.										
							
							if (caseCheck != null) {																							// If Statement. Variable is not null.		
							
								boolean searchIDResult;																							// True, not null. Variable to store result of method.
						
								searchIDResult = myController.playerSearchByID(squadInfo,caseCheck); 											// Set variable to result of method. A search for player by the new String that was created.
						
								if (searchIDResult){																							// If Statement. A player of the memberID given after ignoreCase is found.
							
									myController.initPlayerProfileScreen(myController.getThisPlayerByID(squadInfo,caseCheck));					// True, player memberID found. Run method with parameters to create new instance of PlayerProfile Screen
									dispose();																									// Close current Screen
								
								}
							}
						
						}catch (CustomException error){																							// Exception. ignoreCase check does not match a memberID.
						
							JOptionPane.showMessageDialog(null, error, "Simply Rugby - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	// Return CustomException message.
						
						}
					}
				}
			
		} catch (CustomException error) {																										// Exception. Content of text field is empty.
		
			JOptionPane.showMessageDialog(null, error, "Simply Rugby - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);					// Return CustomException message.
				
		}	
	}
	
}
