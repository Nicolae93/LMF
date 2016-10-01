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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.BoxLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
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

public class Window {

	private JFrame frmLmf;
	private JTextField txtId;
	private JTextField txtInsertAge;
	private JTextField txtInsertNationality;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmLmf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmLmf.setResizable(false);
		frmLmf.setSize(700, 500);
		
		frmLmf.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmLmf.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnWindow = new JMenu("Window");
		menuBar.add(mnWindow);
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
		
		txtId = new JTextField();
		txtId.setText("ID:");
		txtId.setToolTipText("");
		panel_1.add(txtId);
		txtId.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblSex = new JLabel("Sex:");
		GridBagConstraints gbc_lblSex = new GridBagConstraints();
		gbc_lblSex.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex.gridx = 0;
		gbc_lblSex.gridy = 0;
		panel_2.add(lblSex, gbc_lblSex);
		
		JCheckBox chckbxMale = new JCheckBox("Male");
		chckbxMale.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_chckbxMale = new GridBagConstraints();
		gbc_chckbxMale.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMale.gridx = 1;
		gbc_chckbxMale.gridy = 0;
		panel_2.add(chckbxMale, gbc_chckbxMale);
		
		JCheckBox chckbxFemale = new JCheckBox("Female");
		GridBagConstraints gbc_chckbxFemale = new GridBagConstraints();
		gbc_chckbxFemale.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxFemale.gridx = 2;
		gbc_chckbxFemale.gridy = 0;
		panel_2.add(chckbxFemale, gbc_chckbxFemale);
		
		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 1;
		panel_2.add(lblAge, gbc_lblAge);
		
		txtInsertAge = new JTextField();
		txtInsertAge.setText("Insert age");
		GridBagConstraints gbc_txtInsertAge = new GridBagConstraints();
		gbc_txtInsertAge.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsertAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsertAge.gridx = 1;
		gbc_txtInsertAge.gridy = 1;
		panel_2.add(txtInsertAge, gbc_txtInsertAge);
		txtInsertAge.setColumns(5);
		
		JLabel lblNat = new JLabel("Nat:");
		GridBagConstraints gbc_lblNat = new GridBagConstraints();
		gbc_lblNat.anchor = GridBagConstraints.EAST;
		gbc_lblNat.insets = new Insets(0, 0, 5, 5);
		gbc_lblNat.gridx = 0;
		gbc_lblNat.gridy = 2;
		panel_2.add(lblNat, gbc_lblNat);
		
		txtInsertNationality = new JTextField();
		txtInsertNationality.setText("Insert nationality");
		GridBagConstraints gbc_txtInsertNationality = new GridBagConstraints();
		gbc_txtInsertNationality.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsertNationality.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsertNationality.gridx = 1;
		gbc_txtInsertNationality.gridy = 2;
		panel_2.add(txtInsertNationality, gbc_txtInsertNationality);
		txtInsertNationality.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 3;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_plblInformations.setHorizontalAlignment(SwingConstants.LEFT);
		anel_6.rowHeights = new int[]{0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, 1.0};
		panel_6.setLayout(gbl_panel_6);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_6.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//myLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel lblL = new JLabel("L5");
		panel_11.add(lblL);
		
		JPanel panel_12 = new JPanel();
		panel_9.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblL_1 = new JLabel("L4");
		panel_12.add(lblL_1);
		
		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13);
		panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblL_2 = new JLabel("L3");
		panel_13.add(lblL_2);
		
		JPanel panel_14 = new JPanel();
		panel_9.add(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblL_3 = new JLabel("L2");
		panel_14.add(lblL_3);
		
		JPanel panel_15 = new JPanel();
		panel_9.add(panel_15);
		panel_15.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblL_4 = new JLabel("L1");
		panel_15.add(lblL_4);
		
		JPanel panel_16 = new JPanel();
		panel_9.add(panel_16);
		panel_16.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblR = new JLabel("R1");
		panel_16.add(lblR);
		
		JPanel panel_17 = new JPanel();
		panel_9.add(panel_17);
		panel_17.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblR_1 = new JLabel("R2");
		panel_17.add(lblR_1);
		
		JPanel panel_18 = new JPanel();
		panel_9.add(panel_18);
		panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblR_2 = new JLabel("R3");
		panel_18.add(lblR_2);
		
		JPanel panel_19 = new JPanel();
		panel_9.add(panel_19);
		panel_19.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblR_3 = new JLabel("R4");
		panel_19.add(lblR_3);
		
		JPanel panel_20 = new JPanel();
		panel_9.add(panel_20);
		panel_20.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblR_4 = new JLabel("R5");
		panel_20.add(lblR_4);
		
		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel_6.add(panel_8, gbc_panel_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.add(panel_5, BorderLayout.NORTH);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblInformation = new JLabel("INFORMATIONS");
		GridBagConstraints gbc_lblInformation = new GridBagConstraints();
		gbc_lblInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformation.gridx = 0;
		gbc_lblInformation.gridy = 0;
		panel_5.add(lblInformation, gbc_lblInformation);
		
		JLabel lblName = new JLabel("NAME:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panel_5.add(lblName, gbc_lblName);
		
		JLabel lblSurname_1 = new JLabel("SURNAME:");
		GridBagConstraints gbc_lblSurname_1 = new GridBagConstraints();
		gbc_lblSurname_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname_1.gridx = 0;
		gbc_lblSurname_1.gridy = 2;
		panel_5.add(lblSurname_1, gbc_lblSurname_1);
		
		JLabel lblSurname = new JLabel("NATIONALITY:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 3;
		panel_5.add(lblSurname, gbc_lblSurname);
		
		JLabel lblSex_1 = new JLabel("SEX:");
		GridBagConstraints gbc_lblSex_1 = new GridBagConstraints();
		gbc_lblSex_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex_1.gridx = 0;
		gbc_lblSex_1.gridy = 4;
		panel_5.add(lblSex_1, gbc_lblSex_1);
		
		JLabel lblAge_1 = new JLabel("AGE:");
		GridBagConstraints gbc_lblAge_1 = new GridBagConstraints();
		gbc_lblAge_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblAge_1.gridx = 0;
		gbc_lblAge_1.gridy = 5;
		panel_5.add(lblAge_1, gbc_lblAge_1);
		
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
