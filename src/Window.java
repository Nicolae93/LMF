import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLayeredPane;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.GridBagConstraints;
import java.awt.Checkbox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTree;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.PlainDocument;
import javax.swing.Box;
import javax.swing.JComboBox;

public class Window {

	private JFrame frmLmf, frmLmf1;
	private JTextField txtId;
	private JTextField txtInsertAge;
	private BufferedImage img;
	private JTextField txtInsertName;
	private JTextField txtInsertLastname;
	private JCheckBox chckbxMale, chckbxFemale;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		
		frmLmf = new JFrame();
		frmLmf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLmf.setTitle("LMF");
		frmLmf.setResizable(true);
		frmLmf.setSize(1200, 400);
		frmLmf.setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		frmLmf.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					JDialogWindow dialog = new JDialogWindow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mnFile.add(mntmNew);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenu mnWindow = new JMenu("Window");
		menuBar.add(mnWindow);
		
		JMenu mnScans = new JMenu("Scans");
		menuBar.add(mnScans);
		
		JMenuItem mntmSelectFolder = new JMenuItem("Select Folder");
		mnScans.add(mntmSelectFolder);
		frmLmf.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmLmf.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder());
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JButton btnSearch = new JButton("Search");
		panel_1.add(btnSearch);
		
		JLabel lblId = new JLabel("ID:");
		panel_1.add(lblId);

		txtId = new JTextField();
		panel_1.add(txtId);
		txtId.setColumns(10);
		PlainDocument doc = (PlainDocument) txtId.getDocument();
		doc.setDocumentFilter(new IntFilter(5));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblName_1 = new JLabel("Name:");
		GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
		gbc_lblName_1.anchor = GridBagConstraints.EAST;
		gbc_lblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_1.gridx = 0;
		gbc_lblName_1.gridy = 0;
		panel_2.add(lblName_1, gbc_lblName_1);

		txtInsertName = new JTextField();
		((AbstractDocument) txtInsertName.getDocument()).setDocumentFilter(new MyDocumentFilter());

		GridBagConstraints gbc_txtInsertName = new GridBagConstraints();
		gbc_txtInsertName.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsertName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsertName.gridx = 1;
		gbc_txtInsertName.gridy = 0;
		panel_2.add(txtInsertName, gbc_txtInsertName);
		txtInsertName.setColumns(10);

		JLabel lblLname = new JLabel("LName:");
		GridBagConstraints gbc_lblLname = new GridBagConstraints();
		gbc_lblLname.anchor = GridBagConstraints.EAST;
		gbc_lblLname.insets = new Insets(0, 0, 5, 5);
		gbc_lblLname.gridx = 0;
		gbc_lblLname.gridy = 1;
		panel_2.add(lblLname, gbc_lblLname);

		txtInsertLastname = new JTextField();
		((AbstractDocument) txtInsertLastname.getDocument()).setDocumentFilter(new MyDocumentFilter());
		GridBagConstraints gbc_txtInsertLastname = new GridBagConstraints();
		gbc_txtInsertLastname.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsertLastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsertLastname.gridx = 1;
		gbc_txtInsertLastname.gridy = 1;
		panel_2.add(txtInsertLastname, gbc_txtInsertLastname);
		txtInsertLastname.setColumns(10);

		JLabel lblSex = new JLabel("Sex:");
		GridBagConstraints gbc_lblSex = new GridBagConstraints();
		gbc_lblSex.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex.gridx = 0;
		gbc_lblSex.gridy = 2;
		panel_2.add(lblSex, gbc_lblSex);

		chckbxMale = new JCheckBox("Male");
		chckbxMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMale.isSelected()){
					chckbxFemale.setSelected(false);
				}
			}
		});
		chckbxMale.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_chckbxMale = new GridBagConstraints();
		gbc_chckbxMale.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMale.gridx = 1;
		gbc_chckbxMale.gridy = 2;
		panel_2.add(chckbxMale, gbc_chckbxMale);

		chckbxFemale = new JCheckBox("Female");
		chckbxFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxFemale.isSelected()){
					chckbxMale.setSelected(false);
				}
			}
		});
		GridBagConstraints gbc_chckbxFemale = new GridBagConstraints();
		gbc_chckbxFemale.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxFemale.gridx = 2;
		gbc_chckbxFemale.gridy = 2;
		panel_2.add(chckbxFemale, gbc_chckbxFemale);

		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 3;
		panel_2.add(lblAge, gbc_lblAge);

		txtInsertAge = new JTextField();
		PlainDocument doc1 = (PlainDocument) txtInsertAge.getDocument();
		doc1.setDocumentFilter(new IntFilter(2));
		
		GridBagConstraints gbc_txtInsertAge = new GridBagConstraints();
		gbc_txtInsertAge.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsertAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsertAge.gridx = 1;
		gbc_txtInsertAge.gridy = 3;
		panel_2.add(txtInsertAge, gbc_txtInsertAge);
		txtInsertAge.setColumns(5);

		JLabel lblNat = new JLabel("Nat:");
		GridBagConstraints gbc_lblNat = new GridBagConstraints();
		gbc_lblNat.anchor = GridBagConstraints.EAST;
		gbc_lblNat.insets = new Insets(0, 0, 5, 5);
		gbc_lblNat.gridx = 0;
		gbc_lblNat.gridy = 4;
		panel_2.add(lblNat, gbc_lblNat);
		
		
		 Vector<String> v = new Vector<String>();
		  Locale[] locales = Locale.getAvailableLocales();
		     for (Locale locale : locales) {
		       //String iso = locale.getISO3Country();
		       //String code = locale.getCountry();
		       String name = locale.getDisplayCountry();
		   if(!v.contains(name)) v.addElement(name);
		   }
		Collections.sort(v);
		JComboBox comboBox = new JComboBox(v);
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		panel_2.add(comboBox, gbc_comboBox);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 3;
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 5;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblListOfPersons_1 = new JLabel("List of persons");
		GridBagConstraints gbc_lblListOfPersons_1 = new GridBagConstraints();
		gbc_lblListOfPersons_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblListOfPersons_1.gridwidth = 4;
		gbc_lblListOfPersons_1.gridx = 0;
		gbc_lblListOfPersons_1.gridy = 0;
		panel_4.add(lblListOfPersons_1, gbc_lblListOfPersons_1);

		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridwidth = 4;
		gbc_list_1.insets = new Insets(0, 0, 0, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 1;
		panel_4.add(list_1, gbc_list_1);

		JPanel panel_3 = new JPanel();
		frmLmf.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new CompoundBorder());
		panel_3.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnL_1 = new JButton("L4");
		panel_13.add(btnL_1);

		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnL_2 = new JButton("L3");
		panel_14.add(btnL_2);

		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnL_3 = new JButton("L2");
		panel_15.add(btnL_3);

		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.add(panel_16);
		panel_16.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnL_4 = new JButton("L1");
		panel_16.add(btnL_4);

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.add(panel_17);
		panel_17.setLayout(new GridLayout(0, 1, 0, 0));

		JButton button = new JButton("R1");
		panel_17.add(button);

		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.add(panel_18);
		panel_18.setLayout(new GridLayout(0, 1, 0, 0));

		JButton button_1 = new JButton("R2");
		panel_18.add(button_1);

		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 1, 0, 0));

		JButton button_2 = new JButton("R3");
		panel_19.add(button_2);

		JPanel panel_20 = new JPanel();
		panel_20.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.add(panel_20);
		panel_20.setLayout(new GridLayout(0, 1, 0, 0));

		JButton button_3 = new JButton("R4");
		panel_20.add(button_3);

		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 1, 0, 0));

		JButton button_4 = new JButton("R5");
		panel_21.add(button_4);

		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10, BorderLayout.SOUTH);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnPl = new JButton("Left_Palm");
		panel_11.add(btnPl);

		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12);
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnRightpalm = new JButton("Right_Palm");
		panel_12.add(btnRightpalm);
		
		String URLMU = "/Users/dexter/Documents/workspace/LMF_Project/masarykUniversity.png";
		
		

//		 panel_9.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_13.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_14.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_15.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_16.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_17.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_18.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_19.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_20.add(new LoadImageApp(URLFingerPrint,85,150));
//		 panel_21.add(new LoadImageApp(URLFingerPrint,85,150));
		 
		 String URLFingerPrint="/Users/dexter/Documents/workspace/LMF_Project/fingerPrint.jpg";
		 JButton btnL = new JButton("L5");
		
		 panel_9.add(btnL);
		 //String URLFingerPrint="/Users/dexter/Documents/workspace/LMF_Project/empty.png";
		 LoadImageApp loadImageApp = new LoadImageApp(URLFingerPrint,85,100);
		 panel_9.add(loadImageApp);
		 panel_13.add(new LoadImageApp(URLFingerPrint,85,100));
		 panel_14.add(new LoadImageApp(URLFingerPrint,85,100));
		 panel_15.add(new LoadImageApp(URLFingerPrint,85,100));
		 panel_16.add(new LoadImageApp(URLFingerPrint,85,100));
		 panel_17.add(new LoadImageApp(URLFingerPrint,85,100));
		 panel_18.add(new LoadImageApp(URLFingerPrint,85,100));
		 panel_19.add(new LoadImageApp(URLFingerPrint,85,100));
		 panel_20.add(new LoadImageApp(URLFingerPrint,85,100));
		 panel_21.add(new LoadImageApp(URLFingerPrint,85,100));
		 
		 JPanel panel_5 = new JPanel();
		 panel_3.add(panel_5, BorderLayout.NORTH);
		 panel_5.setLayout(new BorderLayout(0, 0));
		 
		 JPanel panel_24 = new JPanel();
		 panel_5.add(panel_24, BorderLayout.EAST);
		 panel_24.setLayout(new BorderLayout(0, 0));
		 //panel_24.add(new LoadImageApp(URLMU,50,50));
		 
		 JPanel panel_23 = new JPanel();
		 panel_5.add(panel_23, BorderLayout.WEST);
		 GridBagLayout gbl_panel_23 = new GridBagLayout();
		 gbl_panel_23.columnWidths = new int[]{95, 79, 76, 26, 75, 29, 91, 50, 0};
		 gbl_panel_23.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0, 0, 0};
		 gbl_panel_23.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 gbl_panel_23.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panel_23.setLayout(gbl_panel_23);
		 
		 JLabel lblInformation = new JLabel("INFORMATION:");
		 GridBagConstraints gbc_lblInformation = new GridBagConstraints();
		 gbc_lblInformation.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblInformation.insets = new Insets(0, 0, 5, 5);
		 gbc_lblInformation.gridx = 0;
		 gbc_lblInformation.gridy = 0;
		 panel_23.add(lblInformation, gbc_lblInformation);
		 
		 JLabel lblFirstName = new JLabel("FIRST NAME:");
		 GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		 gbc_lblFirstName.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		 gbc_lblFirstName.gridx = 0;
		 gbc_lblFirstName.gridy = 1;
		 panel_23.add(lblFirstName, gbc_lblFirstName);
		 
		 JLabel lblNone = new JLabel("none");
		 GridBagConstraints gbc_lblNone = new GridBagConstraints();
		 gbc_lblNone.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNone.gridx = 1;
		 gbc_lblNone.gridy = 1;
		 panel_23.add(lblNone, gbc_lblNone);
		 
		 JLabel lblLastName = new JLabel("LAST NAME:");
		 GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		 gbc_lblLastName.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		 gbc_lblLastName.gridx = 0;
		 gbc_lblLastName.gridy = 2;
		 panel_23.add(lblLastName, gbc_lblLastName);
		 
		 JLabel lblNone_1 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_1 = new GridBagConstraints();
		 gbc_lblNone_1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNone_1.gridx = 1;
		 gbc_lblNone_1.gridy = 2;
		 panel_23.add(lblNone_1, gbc_lblNone_1);
		 
		 JLabel lblSex_1 = new JLabel("SEX:");
		 GridBagConstraints gbc_lblSex_1 = new GridBagConstraints();
		 gbc_lblSex_1.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblSex_1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblSex_1.gridx = 0;
		 gbc_lblSex_1.gridy = 3;
		 panel_23.add(lblSex_1, gbc_lblSex_1);
		 
		 JLabel lblNone_2 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_2 = new GridBagConstraints();
		 gbc_lblNone_2.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNone_2.gridx = 1;
		 gbc_lblNone_2.gridy = 3;
		 panel_23.add(lblNone_2, gbc_lblNone_2);
		 
		 JLabel lblBirthdate = new JLabel("BIRTHDATE:");
		 GridBagConstraints gbc_lblBirthdate = new GridBagConstraints();
		 gbc_lblBirthdate.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblBirthdate.insets = new Insets(0, 0, 5, 5);
		 gbc_lblBirthdate.gridx = 0;
		 gbc_lblBirthdate.gridy = 4;
		 panel_23.add(lblBirthdate, gbc_lblBirthdate);
		 
		 JLabel lblNone_3 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_3 = new GridBagConstraints();
		 gbc_lblNone_3.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNone_3.gridx = 1;
		 gbc_lblNone_3.gridy = 4;
		 panel_23.add(lblNone_3, gbc_lblNone_3);
		 
		 JLabel lblAge_1 = new JLabel("AGE:");
		 GridBagConstraints gbc_lblAge_1 = new GridBagConstraints();
		 gbc_lblAge_1.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblAge_1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblAge_1.gridx = 0;
		 gbc_lblAge_1.gridy = 5;
		 panel_23.add(lblAge_1, gbc_lblAge_1);
		 
		 JLabel lblNone_4 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_4 = new GridBagConstraints();
		 gbc_lblNone_4.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNone_4.gridx = 1;
		 gbc_lblNone_4.gridy = 5;
		 panel_23.add(lblNone_4, gbc_lblNone_4);
		 
		 JLabel lblNationality = new JLabel("NATIONALITY:");
		 GridBagConstraints gbc_lblNationality = new GridBagConstraints();
		 gbc_lblNationality.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblNationality.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNationality.gridx = 0;
		 gbc_lblNationality.gridy = 6;
		 panel_23.add(lblNationality, gbc_lblNationality);
		 
		 JLabel lblNone_5 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_5 = new GridBagConstraints();
		 gbc_lblNone_5.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNone_5.gridx = 1;
		 gbc_lblNone_5.gridy = 6;
		 panel_23.add(lblNone_5, gbc_lblNone_5);
		 
		 JLabel lblEmail = new JLabel("E-MAIL:");
		 GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		 gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		 gbc_lblEmail.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblEmail.gridx = 0;
		 gbc_lblEmail.gridy = 7;
		 panel_23.add(lblEmail, gbc_lblEmail);
		 
		 JLabel lblNone_6 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_6 = new GridBagConstraints();
		 gbc_lblNone_6.insets = new Insets(0, 0, 0, 5);
		 gbc_lblNone_6.gridx = 1;
		 gbc_lblNone_6.gridy = 7;
		 panel_23.add(lblNone_6, gbc_lblNone_6);
		 
		 JPanel panel_22 = new JPanel();
		 panel_5.add(panel_22);
		 GridBagLayout gbl_panel_22 = new GridBagLayout();
		 gbl_panel_22.columnWidths = new int[]{102, 0, 0};
		 gbl_panel_22.rowHeights = new int[]{16, 16, 16, 16, 16, 0};
		 gbl_panel_22.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		 gbl_panel_22.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panel_22.setLayout(gbl_panel_22);
		 
		 JLabel lblNewLabel = new JLabel("FINGERPRINT INFO");
		 GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		 gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNewLabel.gridx = 0;
		 gbc_lblNewLabel.gridy = 0;
		 panel_22.add(lblNewLabel, gbc_lblNewLabel);
		 
		 JLabel lblTypology = new JLabel("TYPOLOGY:");
		 GridBagConstraints gbc_lblTypology = new GridBagConstraints();
		 gbc_lblTypology.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblTypology.insets = new Insets(0, 0, 5, 5);
		 gbc_lblTypology.gridx = 0;
		 gbc_lblTypology.gridy = 1;
		 panel_22.add(lblTypology, gbc_lblTypology);
		 
		 JLabel lblNone_7 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_7 = new GridBagConstraints();
		 gbc_lblNone_7.insets = new Insets(0, 0, 5, 0);
		 gbc_lblNone_7.gridx = 1;
		 gbc_lblNone_7.gridy = 1;
		 panel_22.add(lblNone_7, gbc_lblNone_7);
		 
		 JLabel lblNumberCore = new JLabel("NUMBER CORE:");
		 GridBagConstraints gbc_lblNumberCore = new GridBagConstraints();
		 gbc_lblNumberCore.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblNumberCore.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNumberCore.gridx = 0;
		 gbc_lblNumberCore.gridy = 2;
		 panel_22.add(lblNumberCore, gbc_lblNumberCore);
		 
		 JLabel lblNone_8 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_8 = new GridBagConstraints();
		 gbc_lblNone_8.insets = new Insets(0, 0, 5, 0);
		 gbc_lblNone_8.gridx = 1;
		 gbc_lblNone_8.gridy = 2;
		 panel_22.add(lblNone_8, gbc_lblNone_8);
		 
		 JLabel lblTriradiusCore = new JLabel("TRIRADIUS CORE:");
		 GridBagConstraints gbc_lblTriradiusCore = new GridBagConstraints();
		 gbc_lblTriradiusCore.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblTriradiusCore.insets = new Insets(0, 0, 5, 5);
		 gbc_lblTriradiusCore.gridx = 0;
		 gbc_lblTriradiusCore.gridy = 3;
		 panel_22.add(lblTriradiusCore, gbc_lblTriradiusCore);
		 
		 JLabel lblNone_9 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_9 = new GridBagConstraints();
		 gbc_lblNone_9.insets = new Insets(0, 0, 5, 0);
		 gbc_lblNone_9.gridx = 1;
		 gbc_lblNone_9.gridy = 3;
		 panel_22.add(lblNone_9, gbc_lblNone_9);
		 
		 JLabel lblRidgeCount = new JLabel("RIDGE COUNT:");
		 GridBagConstraints gbc_lblRidgeCount = new GridBagConstraints();
		 gbc_lblRidgeCount.insets = new Insets(0, 0, 0, 5);
		 gbc_lblRidgeCount.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblRidgeCount.gridx = 0;
		 gbc_lblRidgeCount.gridy = 4;
		 panel_22.add(lblRidgeCount, gbc_lblRidgeCount);
		 
		 JLabel lblNone_10 = new JLabel("none");
		 GridBagConstraints gbc_lblNone_10 = new GridBagConstraints();
		 gbc_lblNone_10.gridx = 1;
		 gbc_lblNone_10.gridy = 4;
		 panel_22.add(lblNone_10, gbc_lblNone_10);

		 
		
	}
	
	public void createWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.getFrmLmf().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrmLmf() {
		return frmLmf;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
