package skillTracking;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
 * Player Profile Screen
 * </p>
 * 
 * <p>
 * Has a direct link with the <code>Controller</code> that enables communication and completion of tasks.
 * <br>Reading and interpreting user actions through the <code>View</code>.
 * <br>Sending them to <code>Controller</code> to be processed.
 * </p>
 * 
 * <p>
 * Screen used for showing Player Profiles and updating them.
 * <br>Is used to display information to the user and receive input from a user.
 * <br>Has buttons for user navigation.
 * <br>Text fields for comment input.
 * <br>Sliders to set skill rating.
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

public class PlayerProfileScreen extends JFrame {

	// Variables
	
	private Controller myController;																														// Controller variable for storing instance of the Controller being used during program runtime.
	private Player playerDetails;																															// Variable to store current player details for profile. The instance of Player.
	
	private JPanel contentPane;																																// JPanel variable for storing the panel that all GUI elements are added to.
	private JTextField txtDateOfUpdate;																														// JTextField variable for contents of textField.
	
	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>PlayerProfileScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * </p>
	 * 
	 * <p>
	 * First parameter is to set up a connection with the <code>Controller</code>.
	 * <br>Second is which instance of <code>Player</code> to use for content generation.
	 * </p>
	 * 
	 * @param controller		<code>Controller</code> input to set controller variable to.
	 * @param playerInfo		<code>Player</code> input to set playerInfo variable to.
	 * 
	 * @see Controller
	 * @see PlayerProfile
	 * @see Player
	 */
	
	public PlayerProfileScreen(Controller controller, Player playerInfo) {
		
		myController = controller;																											// Set Variable to parameter.	
		playerDetails = playerInfo;																											// Set Variable to parameter.	
		
		// GUI element creation
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Rugby.class.getResource("/RugbyBall.PNG")));										// Set Tool bar Icon.
		setTitle("Simply Rugby - Player Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 895);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblScreenLabel = new JLabel("Player Profile");
		lblScreenLabel.setForeground(new Color(0, 153, 255));
		lblScreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblScreenLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblScreenLabel.setBounds(555, 40, 200, 40);
		contentPane.add(lblScreenLabel);
		
		JLabel lblChartLabel = new JLabel("Overall Ratings");
		lblChartLabel.setToolTipText("Overall Ratings - Bar chart displaying the average score for the player in each skill category");
		lblChartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblChartLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblChartLabel.setForeground(new Color(0, 153, 255));
		lblChartLabel.setBounds(95, 130, 160, 25);
		contentPane.add(lblChartLabel);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();																						// Create a new instance of JFreeChart library Class. Data that will be displayed by the chart
		dataset.addValue(averageRating(playerDetails,"Passing"), "Passing", "Skill Category");																// Add data value to dataset. 
		dataset.addValue(averageRating(playerDetails,"Tackling"), "Tackling", "Skill Category");															// Add data value to dataset.
		dataset.addValue(averageRating(playerDetails,"Kicking"), "Kicking", "Skill Category");																// Add data value to dataset.
	
		JFreeChart barChart = ChartFactory.createBarChart(null,null,null,dataset,PlotOrientation.VERTICAL,true, true, false);								// Create instance of a bar chart.
		
		ChartPanel chartPanel = new ChartPanel(barChart);																									// Create a panel for the chart to be added to.
		chartPanel.setBounds(25, 170, 300, 300);
		contentPane.add(chartPanel);
		chartPanel.setPreferredSize(new java.awt.Dimension(300,300) );																						// Defining dimensions of bar chart.
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setForeground(new Color(0, 153, 255));
		lblPlayer.setBounds(55, 505, 70, 14);
		contentPane.add(lblPlayer);
		
		//
		// Player Text Field
		//
		
		JTextField txtPlayerName = new JTextField(playerDetails.getFullName());																				// Set text field to player fullName
		txtPlayerName.setBackground(Color.WHITE);
		txtPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerName.setEditable(false);
		txtPlayerName.setToolTipText("Player - Name of player this profile being displayed belongs to.");
		txtPlayerName.setBounds(130, 500, 160, 25);
		contentPane.add(txtPlayerName);
		txtPlayerName.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition.setForeground(new Color(0, 153, 255));
		lblPosition.setBounds(55, 545, 70, 14);
		contentPane.add(lblPosition);
		
		//
		// Position Text Field
		//
		
		JTextField txtPosition = new JTextField(playerDetails.getStringPosition());																			// Set text field to players current playing position
		txtPosition.setBackground(Color.WHITE);
		txtPosition.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosition.setEditable(false);
		txtPosition.setToolTipText("Position - Position the player currently plays.");
		txtPosition.setBounds(130, 540, 160, 25);
		contentPane.add(txtPosition);
		txtPosition.setColumns(10);
		
		JLabel lblDateOfLast = new JLabel("Updated");
		lblDateOfLast.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfLast.setForeground(new Color(0, 153, 255));
		lblDateOfLast.setBounds(55, 585, 70, 14);
		contentPane.add(lblDateOfLast);
		
		//
		// Update Text Field
		//
		
		txtDateOfUpdate = new JTextField(playerDetails.getProfileDate());																					// Set text field to players last update date
		txtDateOfUpdate.setBackground(Color.WHITE);
		txtDateOfUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateOfUpdate.setEditable(false);
		txtDateOfUpdate.setToolTipText("Last Update - Date that the profile was last edited (For demo purposes has been set to time of update)");
		txtDateOfUpdate.setBounds(130, 580, 160, 25);
		contentPane.add(txtDateOfUpdate);
		txtDateOfUpdate.setColumns(10);
		
		//
		// Score Card A Creation
		//
		
		JPanel panelA = new JPanel();
		panelA.setBackground(Color.WHITE);
		panelA.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		panelA.setBounds(355, 110, 932, 190);
		contentPane.add(panelA);
		panelA.setLayout(null);
		
		//
		// Creating image
		//
		
		ImageIcon passingIcon =  new ImageIcon(Rugby.class.getResource("/RugbyPass.PNG"));
		Image passingImage = passingIcon.getImage();
		Image passingImageResize = passingImage.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
		passingIcon = new ImageIcon(passingImageResize);
			
		JPanel panelAIcon = new JPanel();
		panelAIcon.setBounds(40, 20, 100, 100);
		panelA.add(panelAIcon);
		panelAIcon.setLayout(null);
			
		JLabel lblIconA = new JLabel(passingIcon);
		lblIconA.setToolTipText("Passing Score Card");
		lblIconA.setBounds(0, 0, 100, 100);
		panelAIcon.add(lblIconA);
			
		JTextField txtCategoryA = new JTextField(playerDetails.getSkillCategories("Passing").getCategoryName());
		txtCategoryA.setToolTipText("Passing Score Card");
		txtCategoryA.setBackground(Color.WHITE);
		txtCategoryA.setHorizontalAlignment(SwingConstants.CENTER);
		txtCategoryA.setBounds(40, 140, 100, 25);
		panelA.add(txtCategoryA);
		txtCategoryA.setEditable(false);
		txtCategoryA.setColumns(10);
			
		JTextField txtSkillA1 = new JTextField(playerDetails.getSkillCategories("Passing").getSkill("Standard").getSkill());
		txtSkillA1.setToolTipText("Passing Skill");
		txtSkillA1.setBackground(Color.WHITE);
		txtSkillA1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillA1.setBounds(195, 20, 100, 25);
		panelA.add(txtSkillA1);
		txtSkillA1.setEditable(false);
		txtSkillA1.setColumns(10);
			
		JLabel lblCurrentRatingA1 = new JLabel("Rating");
		lblCurrentRatingA1.setForeground(new Color(0, 153, 255));
		lblCurrentRatingA1.setBounds(340, 25, 50, 14);
		panelA.add(lblCurrentRatingA1);
			
		JTextField txtRatingA1 = new JTextField(playerDetails.getSkillCategories("Passing").getSkill("Standard").getStringRating());
		txtRatingA1.setToolTipText("Current Rating");
		txtRatingA1.setBackground(Color.WHITE);
		txtRatingA1.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingA1.setBounds(390, 20, 25, 25);
		panelA.add(txtRatingA1);
		txtRatingA1.setEditable(false);
		txtRatingA1.setColumns(10);
			
		JSlider sliderA1 = new JSlider();
		sliderA1.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderA1.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes by clicking the Update button");
		sliderA1.setBackground(Color.WHITE);
		sliderA1.setBounds(460, 10, 200, 43);
		panelA.add(sliderA1);
		sliderA1.setValue(playerDetails.getSkillCategories("Passing").getSkill("Standard").getRating());
		sliderA1.setMinorTickSpacing(1);
		sliderA1.setMajorTickSpacing(1);
		sliderA1.setPaintLabels(true);
		sliderA1.setPaintTicks(true);
		sliderA1.setSnapToTicks(true);
		sliderA1.setMaximum(5);
			
		JTextField txtSkillA2 = new JTextField(playerDetails.getSkillCategories("Passing").getSkill("Pop").getSkill());
		txtSkillA2.setToolTipText("Passing Skill");
		txtSkillA2.setBackground(Color.WHITE);
		txtSkillA2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillA2.setEditable(false);
		txtSkillA2.setBounds(195, 80, 100, 25);
		panelA.add(txtSkillA2);
		txtSkillA2.setColumns(10);
			
		JLabel lblCurrentRatingA2 = new JLabel("Rating");
		lblCurrentRatingA2.setForeground(new Color(0, 153, 255));
		lblCurrentRatingA2.setBounds(340, 85, 50, 14);
		panelA.add(lblCurrentRatingA2);
			
		JTextField txtRatingA2 = new JTextField(playerDetails.getSkillCategories("Passing").getSkill("Pop").getStringRating());
		txtRatingA2.setToolTipText("Current Rating");
		txtRatingA2.setBackground(Color.WHITE);
		txtRatingA2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingA2.setEditable(false);
		txtRatingA2.setBounds(390, 80, 25, 25);
		panelA.add(txtRatingA2);
		txtRatingA2.setColumns(10);
			
		JSlider sliderA2 = new JSlider();
		sliderA2.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderA2.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderA2.setBackground(Color.WHITE);	
		sliderA2.setMinorTickSpacing(1);
		sliderA2.setMajorTickSpacing(1);
		sliderA2.setMaximum(5);
		sliderA2.setPaintLabels(true);
		sliderA2.setPaintTicks(true);
		sliderA2.setSnapToTicks(true);
		sliderA2.setBounds(460, 70, 200, 48);
		panelA.add(sliderA2);
		sliderA2.setValue(playerDetails.getSkillCategories("Passing").getSkill("Pop").getRating());
			
		JTextField txtSkillA3 = new JTextField(playerDetails.getSkillCategories("Passing").getSkill("Spin").getSkill());
		txtSkillA3.setToolTipText("Passing Skill");
		txtSkillA3.setBackground(Color.WHITE);
		txtSkillA3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillA3.setEditable(false);
		txtSkillA3.setBounds(195, 140, 100, 25);
		panelA.add(txtSkillA3);
		txtSkillA3.setColumns(10);
			
		JLabel lblCurrentRatingA3 = new JLabel("Rating");
		lblCurrentRatingA3.setForeground(new Color(0, 153, 255));
		lblCurrentRatingA3.setBounds(340, 145, 50, 14);
		panelA.add(lblCurrentRatingA3);
			
		JTextField txtRatingA3 = new JTextField(playerDetails.getSkillCategories("Passing").getSkill("Spin").getStringRating());
		txtRatingA3.setToolTipText("Current Rating");
		txtRatingA3.setBackground(Color.WHITE);
		txtRatingA3.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingA3.setEditable(false);
		txtRatingA3.setBounds(390, 140, 25, 25);
		panelA.add(txtRatingA3);
		txtRatingA3.setColumns(10);
			
		JSlider sliderA3 = new JSlider();
		sliderA3.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderA3.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderA3.setBackground(Color.WHITE);
		sliderA3.setBounds(460, 130, 200, 48);
		sliderA3.setValue(playerDetails.getSkillCategories("Passing").getSkill("Spin").getRating());
		panelA.add(sliderA3);
		sliderA3.setSnapToTicks(true);
		sliderA3.setPaintTicks(true);
		sliderA3.setPaintLabels(true);
		sliderA3.setMinorTickSpacing(1);
		sliderA3.setMaximum(5);
		sliderA3.setMajorTickSpacing(1);
		
		//
		// Comment text field with scroll bar
		//
		
		JTextArea textAreaA = new JTextArea(playerDetails.getSkillCategories("Passing").getComment());
		textAreaA.setToolTipText("Passing Score Card Comments - Any changes to the comments can be applied by clicking the Update button.");
		textAreaA.setLineWrap(true);
		textAreaA.setWrapStyleWord(true);
		textAreaA.setBounds(693, 18, 215, 160);
			
		JScrollPane scrollA = new JScrollPane(textAreaA,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollA.setBounds(693, 18, 215, 160);
		panelA.add(scrollA);
			
		//
		// Score Card B Creation
		//
		
		JPanel panelB = new JPanel();
		panelB.setBackground(Color.WHITE);
		panelB.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		panelB.setBounds(355, 310, 932, 250);
		contentPane.add(panelB);
		panelB.setLayout(null);
		
		//
		// Creating image
		//
		
		ImageIcon tacklingIcon =  new ImageIcon(Rugby.class.getResource("/RugbyTackling.PNG"));
		Image tacklingImage = tacklingIcon.getImage();
		Image tacklingImageResize = tacklingImage.getScaledInstance(120,80, java.awt.Image.SCALE_SMOOTH);
		tacklingIcon = new ImageIcon(tacklingImageResize);
				
		JPanel panelBIcon = new JPanel();
		panelBIcon.setBounds(30, 60, 120, 80);
		panelB.add(panelBIcon);
		panelBIcon.setLayout(null);
			
		JLabel lblIconB = new JLabel(tacklingIcon);
		lblIconB.setToolTipText("Tackling Score Card");
		lblIconB.setBounds(0, 0, 120, 80);
		panelBIcon.add(lblIconB);
			
		JTextField txtCategoryB = new JTextField(playerDetails.getSkillCategories("Tackling").getCategoryName());
		txtCategoryB.setToolTipText("Tackling Score Card");
		txtCategoryB.setBackground(Color.WHITE);
		txtCategoryB.setHorizontalAlignment(SwingConstants.CENTER);
		txtCategoryB.setEditable(false);
		txtCategoryB.setBounds(40, 170, 100, 25);
		panelB.add(txtCategoryB);
		txtCategoryB.setColumns(10);
			
		JTextField txtSkillB1 = new JTextField(playerDetails.getSkillCategories("Tackling").getSkill("Front").getSkill());
		txtSkillB1.setToolTipText("Tackling Skill");
		txtSkillB1.setBackground(Color.WHITE);
		txtSkillB1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillB1.setEditable(false);
		txtSkillB1.setBounds(195, 20, 100, 25);
		panelB.add(txtSkillB1);
		txtSkillB1.setColumns(10);
			
		JLabel lblCurrentRatingB1 = new JLabel("Rating");
		lblCurrentRatingB1.setForeground(new Color(0, 153, 255));
		lblCurrentRatingB1.setBounds(340, 25, 50, 14);
		panelB.add(lblCurrentRatingB1);
			
		JTextField txtRatingB1 = new JTextField(playerDetails.getSkillCategories("Tackling").getSkill("Front").getStringRating());
		txtRatingB1.setToolTipText("Current Rating");
		txtRatingB1.setBackground(Color.WHITE);
		txtRatingB1.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingB1.setEditable(false);
		txtRatingB1.setColumns(10);
		txtRatingB1.setBounds(390, 20, 25, 25);
		panelB.add(txtRatingB1);
			
		JSlider sliderB1 = new JSlider();
		sliderB1.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderB1.setForeground(new Color(0, 0, 0));
		sliderB1.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderB1.setBackground(Color.WHITE);
		sliderB1.setSnapToTicks(true);
		sliderB1.setPaintTicks(true);
		sliderB1.setPaintLabels(true);
		sliderB1.setMinorTickSpacing(1);
		sliderB1.setMaximum(5);
		sliderB1.setMajorTickSpacing(1);
		sliderB1.setBounds(460, 10, 200, 48);
		sliderB1.setValue(playerDetails.getSkillCategories("Tackling").getSkill("Front").getRating());
		panelB.add(sliderB1);
			
		JTextField txtSkillB2 = new JTextField(playerDetails.getSkillCategories("Tackling").getSkill("Rear").getSkill());
		txtSkillB2.setToolTipText("Tackling Skill");
		txtSkillB2.setBackground(Color.WHITE);
		txtSkillB2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillB2.setEditable(false);
		txtSkillB2.setBounds(195, 80, 100, 25);
		panelB.add(txtSkillB2);
		txtSkillB2.setColumns(10);
			
		JLabel lblCurrentRatingB2 = new JLabel("Rating");
		lblCurrentRatingB2.setForeground(new Color(0, 153, 255));
		lblCurrentRatingB2.setBounds(340, 85, 50, 14);
		panelB.add(lblCurrentRatingB2);
			
		JTextField txtRatingB2 = new JTextField(playerDetails.getSkillCategories("Tackling").getSkill("Rear").getStringRating());
		txtRatingB2.setToolTipText("Current Rating");
		txtRatingB2.setBackground(Color.WHITE);
		txtRatingB2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingB2.setEditable(false);
		txtRatingB2.setColumns(10);
		txtRatingB2.setBounds(390, 80, 25, 25);
		panelB.add(txtRatingB2);
			
		JSlider sliderB2 = new JSlider();
		sliderB2.setForeground(new Color(0, 0, 0));
		sliderB2.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderB2.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderB2.setBackground(Color.WHITE);
		sliderB2.setSnapToTicks(true);
		sliderB2.setPaintTicks(true);
		sliderB2.setPaintLabels(true);
		sliderB2.setMinorTickSpacing(1);
		sliderB2.setMaximum(5);
		sliderB2.setMajorTickSpacing(1);
		sliderB2.setBounds(460, 70, 200, 48);
		sliderB2.setValue(playerDetails.getSkillCategories("Tackling").getSkill("Rear").getRating());
		panelB.add(sliderB2);
			
		JTextField txtSkillB3 = new JTextField(playerDetails.getSkillCategories("Tackling").getSkill("Side").getSkill());
		txtSkillB3.setToolTipText("Tackling Skill");
		txtSkillB3.setBackground(Color.WHITE);
		txtSkillB3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillB3.setEditable(false);
		txtSkillB3.setBounds(195, 140, 100, 25);
		panelB.add(txtSkillB3);
		txtSkillB3.setColumns(10);
			
		JLabel lblCurrentRatingB3 = new JLabel("Rating");
		lblCurrentRatingB3.setForeground(new Color(0, 153, 255));
		lblCurrentRatingB3.setBounds(340, 145, 50, 14);
		panelB.add(lblCurrentRatingB3);
			
		JTextField txtRatingB3 = new JTextField(playerDetails.getSkillCategories("Tackling").getSkill("Side").getStringRating());
		txtRatingB3.setToolTipText("Current Rating");
		txtRatingB3.setBackground(Color.WHITE);
		txtRatingB3.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingB3.setEditable(false);
		txtRatingB3.setColumns(10);
		txtRatingB3.setBounds(390, 140, 25, 25);
		panelB.add(txtRatingB3);
			
		JSlider sliderB3 = new JSlider();
		sliderB3.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderB3.setForeground(new Color(0, 0, 0));
		sliderB3.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderB3.setBackground(Color.WHITE);
		sliderB3.setSnapToTicks(true);
		sliderB3.setPaintTicks(true);
		sliderB3.setPaintLabels(true);
		sliderB3.setMinorTickSpacing(1);
		sliderB3.setMaximum(5);
		sliderB3.setMajorTickSpacing(1);
		sliderB3.setBounds(460, 130, 200, 48);
		sliderB3.setValue(playerDetails.getSkillCategories("Tackling").getSkill("Side").getRating());
		panelB.add(sliderB3);
			
		JTextField txtSkillB4 = new JTextField(playerDetails.getSkillCategories("Tackling").getSkill("Scrabble").getSkill());
		txtSkillB4.setToolTipText("Tackling Skill");
		txtSkillB4.setBackground(Color.WHITE);
		txtSkillB4.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillB4.setEditable(false);
		txtSkillB4.setBounds(195, 200, 100, 25);
		panelB.add(txtSkillB4);
		txtSkillB4.setColumns(10);
			
		JLabel lblCurrentRatingB4 = new JLabel("Rating");
		lblCurrentRatingB4.setForeground(new Color(51, 153, 255));
		lblCurrentRatingB4.setBounds(340, 205, 50, 14);
		panelB.add(lblCurrentRatingB4);
			
		JTextField txtRatingB4 = new JTextField(playerDetails.getSkillCategories("Tackling").getSkill("Scrabble").getStringRating());
		txtRatingB4.setToolTipText("Current Rating");
		txtRatingB4.setBackground(Color.WHITE);
		txtRatingB4.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingB4.setEditable(false);
		txtRatingB4.setColumns(10);
		txtRatingB4.setBounds(390, 200, 25, 25);
		panelB.add(txtRatingB4);
			
		JSlider sliderB4 = new JSlider();
		sliderB4.setForeground(new Color(0, 0, 0));
		sliderB4.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderB4.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderB4.setBackground(Color.WHITE);
		sliderB4.setSnapToTicks(true);
		sliderB4.setPaintTicks(true);
		sliderB4.setPaintLabels(true);
		sliderB4.setMinorTickSpacing(1);
		sliderB4.setMaximum(5);
		sliderB4.setMajorTickSpacing(1);
		sliderB4.setBounds(460, 190, 200, 48);
		sliderB4.setValue(playerDetails.getSkillCategories("Tackling").getSkill("Scrabble").getRating());
		panelB.add(sliderB4);
		
		//
		// Comment text field with scroll bar
		//
			
		JTextArea textAreaB = new JTextArea(playerDetails.getSkillCategories("Tackling").getComment());
		textAreaB.setToolTipText("Tackling Score Card Comments - Any changes to the comments can be applied by clicking the Update button.");
		textAreaB.setLineWrap(true);
		textAreaB.setWrapStyleWord(true);
		textAreaB.setBounds(693, 18, 215, 160);
				
		JScrollPane scrollB = new JScrollPane(textAreaB,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollB.setSize(215, 210);
		scrollB.setLocation(693, 18);
		scrollA.setBounds(693, 18, 215, 160);
		panelB.add(scrollB);
			
		//
		// Score Card C Creation
		//
			
		JPanel panelC = new JPanel();	
		panelC.setBackground(Color.WHITE);
		panelC.setBorder(new LineBorder(new Color(127, 255, 0), 2, true));
		panelC.setLayout(null);
		panelC.setBounds(355, 570, 932, 250);
		contentPane.add(panelC);
		
		//
		// Creating image
		//
		
		ImageIcon kickingIcon =  new ImageIcon(Rugby.class.getResource("/RugbyKicking.PNG"));
		Image kickingImage = kickingIcon.getImage();
		Image kickingImageResize = kickingImage.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
		kickingIcon = new ImageIcon(kickingImageResize);
			
		JPanel panelCIcon = new JPanel();
		panelCIcon.setBounds(40, 50, 100, 100);
		panelC.add(panelCIcon);
		panelCIcon.setLayout(null);
			
		JLabel lblIconC = new JLabel(kickingIcon);
		lblIconC.setToolTipText("Kicking Score Card");
		lblIconC.setBounds(0, 0, 100, 100);
		panelCIcon.add(lblIconC);
			
		JTextField txtCategoryC = new JTextField(playerDetails.getSkillCategories("Kicking").getCategoryName());
		txtCategoryC.setToolTipText("Kicking Score Card");
		txtCategoryC.setBackground(Color.WHITE);
		txtCategoryC.setHorizontalAlignment(SwingConstants.CENTER);
		txtCategoryC.setEditable(false);
		txtCategoryC.setColumns(10);
		txtCategoryC.setBounds(40, 170, 100, 25);
		panelC.add(txtCategoryC);
			
		JTextField txtSkillC1 = new JTextField(playerDetails.getSkillCategories("Kicking").getSkill("Drop").getSkill());
		txtSkillC1.setToolTipText("Kicking Skill");
		txtSkillC1.setBackground(Color.WHITE);
		txtSkillC1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillC1.setEditable(false);
		txtSkillC1.setColumns(10);
		txtSkillC1.setBounds(195, 20, 100, 25);
		panelC.add(txtSkillC1);
			
		JLabel lblCurrentRatingC1 = new JLabel("Rating");
		lblCurrentRatingC1.setForeground(new Color(0, 153, 255));
		lblCurrentRatingC1.setBounds(340, 25, 50, 14);
		panelC.add(lblCurrentRatingC1);
			
		JTextField txtRatingC1 = new JTextField(playerDetails.getSkillCategories("Kicking").getSkill("Drop").getStringRating());
		txtRatingC1.setToolTipText("Current Rating");
		txtRatingC1.setBackground(Color.WHITE);
		txtRatingC1.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingC1.setEditable(false);
		txtRatingC1.setColumns(10);
		txtRatingC1.setBounds(390, 20, 25, 25);
		panelC.add(txtRatingC1);
			
		JSlider sliderC1 = new JSlider();
		sliderC1.setForeground(new Color(0, 0, 0));
		sliderC1.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderC1.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderC1.setBackground(Color.WHITE);
		sliderC1.setSnapToTicks(true);
		sliderC1.setPaintTicks(true);
		sliderC1.setPaintLabels(true);
		sliderC1.setMinorTickSpacing(1);
		sliderC1.setMaximum(5);
		sliderC1.setMajorTickSpacing(1);
		sliderC1.setBounds(460, 10, 200, 48);
		sliderC1.setValue(playerDetails.getSkillCategories("Kicking").getSkill("Drop").getRating());
		panelC.add(sliderC1);
			
		JTextField txtSkillC2 = new JTextField(playerDetails.getSkillCategories("Kicking").getSkill("Punt").getSkill());
		txtSkillC2.setToolTipText("Kicking Skill");
		txtSkillC2.setBackground(Color.WHITE);
		txtSkillC2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillC2.setEditable(false);
		txtSkillC2.setColumns(10);
		txtSkillC2.setBounds(195, 80, 100, 25);
		panelC.add(txtSkillC2);
			
		JLabel lblCurrentRatingC2 = new JLabel("Rating");
		lblCurrentRatingC2.setForeground(new Color(0, 153, 255));
		lblCurrentRatingC2.setBounds(340, 85, 50, 14);
		panelC.add(lblCurrentRatingC2);
			
		JTextField txtRatingC2 = new JTextField(playerDetails.getSkillCategories("Kicking").getSkill("Punt").getStringRating());
		txtRatingC2.setToolTipText("Current Rating");
		txtRatingC2.setBackground(Color.WHITE);
		txtRatingC2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingC2.setEditable(false);
		txtRatingC2.setColumns(10);
		txtRatingC2.setBounds(390, 80, 25, 25);
		panelC.add(txtRatingC2);
			
		JSlider sliderC2 = new JSlider();
		sliderC2.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderC2.setForeground(new Color(0, 0, 0));
		sliderC2.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderC2.setBackground(Color.WHITE);
		sliderC2.setSnapToTicks(true);
		sliderC2.setPaintTicks(true);
		sliderC2.setPaintLabels(true);
		sliderC2.setMinorTickSpacing(1);
		sliderC2.setMaximum(5);
		sliderC2.setMajorTickSpacing(1);
		sliderC2.setBounds(460, 70, 200, 48);
		sliderC2.setValue(playerDetails.getSkillCategories("Kicking").getSkill("Punt").getRating());
		panelC.add(sliderC2);
			
		JTextField txtSkillC3 = new JTextField(playerDetails.getSkillCategories("Kicking").getSkill("Grubber").getSkill());
		txtSkillC3.setToolTipText("Kicking Skill");
		txtSkillC3.setBackground(Color.WHITE);
		txtSkillC3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillC3.setEditable(false);
		txtSkillC3.setColumns(10);
		txtSkillC3.setBounds(195, 140, 100, 25);
		panelC.add(txtSkillC3);
			
		JLabel lblCurrentRatingC3 = new JLabel("Rating");
		lblCurrentRatingC3.setForeground(new Color(0, 153, 255));
		lblCurrentRatingC3.setBounds(340, 145, 50, 14);
		panelC.add(lblCurrentRatingC3);
			
		JTextField txtRatingC3 = new JTextField(playerDetails.getSkillCategories("Kicking").getSkill("Grubber").getStringRating());
		txtRatingC3.setToolTipText("Current Rating");
		txtRatingC3.setBackground(Color.WHITE);
		txtRatingC3.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingC3.setEditable(false);
		txtRatingC3.setColumns(10);
		txtRatingC3.setBounds(390, 140, 25, 25);
		panelC.add(txtRatingC3);
			
		JSlider sliderC3 = new JSlider();
		sliderC3.setForeground(new Color(0, 0, 0));
		sliderC3.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderC3.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderC3.setBackground(Color.WHITE);
		sliderC3.setSnapToTicks(true);
		sliderC3.setPaintTicks(true);
		sliderC3.setPaintLabels(true);
		sliderC3.setMinorTickSpacing(1);
		sliderC3.setMaximum(5);
		sliderC3.setMajorTickSpacing(1);
		sliderC3.setBounds(460, 130, 200, 48);
		sliderC3.setValue(playerDetails.getSkillCategories("Kicking").getSkill("Grubber").getRating());
		panelC.add(sliderC3);
			
		JTextField txtSkillC4 = new JTextField(playerDetails.getSkillCategories("Kicking").getSkill("Goal").getSkill());
		txtSkillC4.setToolTipText("Kicking Skill");
		txtSkillC4.setBackground(Color.WHITE);
		txtSkillC4.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkillC4.setEditable(false);
		txtSkillC4.setColumns(10);
		txtSkillC4.setBounds(195, 200, 100, 25);
		panelC.add(txtSkillC4);
			
		JLabel lblCurrentRatingC4 = new JLabel("Rating");
		lblCurrentRatingC4.setForeground(new Color(0, 153, 255));
		lblCurrentRatingC4.setBounds(340, 205, 50, 14);
		panelC.add(lblCurrentRatingC4);
			
		JTextField txtRatingC4 = new JTextField(playerDetails.getSkillCategories("Kicking").getSkill("Goal").getStringRating());
		txtRatingC4.setToolTipText("Current Rating");
		txtRatingC4.setBackground(Color.WHITE);
		txtRatingC4.setHorizontalAlignment(SwingConstants.CENTER);
		txtRatingC4.setEditable(false);
		txtRatingC4.setColumns(10);
		txtRatingC4.setBounds(390, 200, 25, 25);
		panelC.add(txtRatingC4);
			
		JSlider sliderC4 = new JSlider();
		sliderC4.setFont(new Font("Tahoma", Font.BOLD, 11));
		sliderC4.setForeground(new Color(0, 0, 0));
		sliderC4.setToolTipText("Rating Slider - Adjust slider to reflect new rating and apply changes using Update button");
		sliderC4.setBackground(Color.WHITE);
		sliderC4.setSnapToTicks(true);
		sliderC4.setPaintTicks(true);
		sliderC4.setPaintLabels(true);
		sliderC4.setMinorTickSpacing(1);
		sliderC4.setMaximum(5);
		sliderC4.setMajorTickSpacing(1);
		sliderC4.setBounds(460, 190, 200, 48);
		sliderC4.setValue(playerDetails.getSkillCategories("Kicking").getSkill("Goal").getRating());
		panelC.add(sliderC4);
		
		//
		// Comment text field with scroll bar
		//
		
		JTextArea textAreaC = new JTextArea(playerDetails.getSkillCategories("Kicking").getComment());
		textAreaC.setToolTipText("Kicking Score Card Comments - Any changes to the comments can be applied by clicking the Update button.");
		textAreaC.setLineWrap(true);
		textAreaC.setWrapStyleWord(true);
		textAreaC.setBounds(693, 18, 215, 160);
			
		JScrollPane scrollC = new JScrollPane(textAreaC,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollC.setSize(215, 210);
		scrollC.setLocation(693, 18);
		scrollC.setBounds(693, 18, 215, 210);
		panelC.add(scrollC);
			
		//
		// Update Button
		//
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																									// ActionListener for Button press.
	
				int select;																																	// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Update current player profile?", "Simply Rugby - Update", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {																										// If Statement. Variable value is YES.
						
					boolean checkComment;																													// variable to store result of method.
					int choice = JOptionPane.NO_OPTION;																										// Variable for storing user response to message box.
						
					try {
						
						checkComment = checkComment(textAreaA.getText(),textAreaB.getText(),textAreaC.getText());											// Set variable to result of method. Checks contents of the text fields exists.
						
						if (!checkComment) {																												// If Statement. Variable value is False.																								
							
							choice = JOptionPane.YES_OPTION;																								// Set variable to YES								
							
						}
						
					} catch (CustomException error) {																										// Exception. The text fields do not all contain contents.
							
						choice = JOptionPane.showOptionDialog(null, error, "Simply Rugby - Update", 
								 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);												// Set variable to response to message box.
				
					}
						
					if (choice == JOptionPane.YES_OPTION) {																									// If Statement. The user accepts that the text fields do not all contain content or the already do.
						
						myController.updateRating(playerDetails,txtCategoryA.getText(),txtSkillA1.getText(),sliderA1.getValue());							// True. Run updateRating method with element of GUI value to change details of current Player instances Player Profile being view/altered
						myController.updateRating(playerDetails,txtCategoryA.getText(),txtSkillA2.getText(),sliderA2.getValue());
						myController.updateRating(playerDetails,txtCategoryA.getText(),txtSkillA3.getText(),sliderA3.getValue());
						myController.updateComment(playerDetails,txtCategoryA.getText(),textAreaA.getText());												// Run updateComment method with element of GUI String to change details of current Player instances Player Profile being view/altered
						
						myController.updateRating(playerDetails,txtCategoryB.getText(),txtSkillB1.getText(),sliderB1.getValue());
						myController.updateRating(playerDetails,txtCategoryB.getText(),txtSkillB2.getText(),sliderB2.getValue());
						myController.updateRating(playerDetails,txtCategoryB.getText(),txtSkillB3.getText(),sliderB3.getValue());
						myController.updateRating(playerDetails,txtCategoryB.getText(),txtSkillB4.getText(),sliderB4.getValue());
						myController.updateComment(playerDetails,txtCategoryB.getText(),textAreaB.getText());
						
						myController.updateRating(playerDetails,txtCategoryC.getText(),txtSkillC1.getText(),sliderC1.getValue());
						myController.updateRating(playerDetails,txtCategoryC.getText(),txtSkillC2.getText(),sliderC2.getValue());
						myController.updateRating(playerDetails,txtCategoryC.getText(),txtSkillC3.getText(),sliderC3.getValue());
						myController.updateRating(playerDetails,txtCategoryC.getText(),txtSkillC4.getText(),sliderC4.getValue());
						myController.updateComment(playerDetails,txtCategoryC.getText(),textAreaC.getText());
						
						myController.updateDate(playerDetails);																								// Run updateDate method with element of GUI value to change date of last update of current Player instances Player Profile being view/altered
						
						myController.initPlayerProfileScreen(playerDetails);																				// Create new instance of screen to reflect changes.
						dispose();																															// Close current screen.
						
						}
				}		
			}
		});
		btnUpdate.setToolTipText("Update - Click this button to apply new ratings and/or ammend comments.");
		btnUpdate.setBounds(130, 640, 90, 25);
		contentPane.add(btnUpdate);
			
		//
		// Back Button
		//
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {																													// ActionListener for Button press.
				
				int select;																																					// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Return to player profile select? Any changes not updated will be lost.", "Simply Rugby - Return", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);													// Sets variable to the value returned from YES_NO_Option message pop up.								
					
				if (select == JOptionPane.YES_OPTION) {																														// If Statement. Variable value is YES.
						
				myController.backPlayerProfileSelect();																														// Use connection with Controller to start method.
				dispose();																																					// Close the current instance of PlayerProfile.
				
				}
			}
		});			
		btnBack.setToolTipText("Back - Click this button to return to Player Profile Select.");
		btnBack.setBounds(130, 690, 90, 25);
		contentPane.add(btnBack);
				
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
	 * <br>Utilises .trim().
	 * <br>Utilises .isEmpty().
	 * </p>
	 * 
	 * @param   textAreaA	<code>String</code> input content of GUI userName textField.
	 * @param   textAreaB	<code>String</code> input content of GUI userName textField.
	 * @param   textAreaC	<code>String</code> input content of GUI userName textField.
	 * 
	 * @return <b>result</b>	<code>Boolean</code> output that program uses to make decisions.
	 * 
	 * @exception CustomException
	 * 
	 * @see PlayerProfileScreen
	 * @see Boolean
	 * @see String
	 */
	
	private boolean checkComment(String textAreaA, String textAreaB, String textAreaC) throws CustomException {										// Method with parameter
		
		boolean result;																																// Variable to store result of check.
		
		result = false;																																// Set variable to false. Base setting only changed if textField contents are empty.
		
		if(textAreaA.trim().isEmpty() || textAreaB.trim().isEmpty() || textAreaC.trim().isEmpty()) {												// If statement. Use .isEmpty() and .trim() to check content of parameter.
			
			result = true;																															// True. Set variable to true
			throw new CustomException("A comment box is empty continue?");																			// Create new instance of CustomException with message parameter.
			
		}
		
		return result;																																// Return result.
	}
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p> 
	 * Calculates the average rating of a skill category.
	 * </p>
	 * 
	 * <p>
	 * Used to calculate the average rating of a skill category for given player.
	 * <br>Loops through all skills in a given category, adding the values then dividing by the number of values looped through.
	 * </p>
	 * 
	 * @param   playerDetails	<code>Player</code> input of <code>Player</code> instance rating is wanted for.
	 * @param   skillCategory	<code>String</code> input of which <code>SkillCategory</code> to get skill ratings from.

	 * 
	 * @return <b>result</b>	<code>Double</code> output of the average skill rating of given <code>SkillCategory</code> for given <code>Player</code> instance.
	 * 
	 * 
	 * @see PlayerProfileScreen
	 * @see Player
	 * @see Double
	 * @see String
	 */
	
	// Method to calculate average of a skill category ArraYyList. Can handle any category or size of list as these differ. Ideal for program future and the dynamic nature of screen creation.
	
	private double averageRating(Player playerDetails,String skillCategory) {																				// Method with parameters. The Player instance we want ratings from and String of the category name
		
		double result;																																		// Variable to store result of check.
		int categorySize;																																	// Variable to store size of ArrayList.
		
		result = 0;																																			// Set variable to 0 so amounts can be added per loop.
		categorySize = (playerDetails.getSkillCategories(skillCategory).getAllSkills().size());																// Set variable to size of ArrayList being used.
		
		for (int i = 0; i < categorySize; i++){																												// For Loop. Loop through all values of given ArrayList
			
			result = result + playerDetails.getSkillCategories(skillCategory).getAllSkills().get(i).getRating();											// Set variable to itself plus new value found during the loop
			
			}
		
		result = result / categorySize ;																													// Set variable to itself divided by the ArrayList size.
		
		return result;																																		// Return the result.
	}
	
}
