import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class JDialogWindow extends JDialog {
	private JTextField txtInsertName;
	private JTextField txtInsertSurname;
	private JTextField txtDD;
	private JTextField txtInsertEmail;
	private String[] arrayInfoPerson;
	private JTextField txtYyyy;
	private JTextField txtMm;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblBirthDate;
	private JLabel lblSex;
	private JLabel lblEmail;
	private JLabel lblNationality;
	private JComboBox comboBox;
	private JLabel lblAddImg;
	private JLabel label_1;
	private JLabel label;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;

	/**
	 * Create the dialog.
	 */
	public JDialogWindow() {
		setBounds(100, 100, 400, 300);

		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new MigLayout("", "[83px][319px,grow]", "[28px][28px][28px][28px][28px][][29px]"));
			{
				lblName = new JLabel("First Name:");
				panel.add(lblName, "cell 0 0,alignx right,aligny center");
			}
			{
				txtInsertName = new JTextField();
				((AbstractDocument) txtInsertName.getDocument()).setDocumentFilter(new MyDocumentFilter());
				panel.add(txtInsertName, "cell 1 0,growx,aligny center");
				txtInsertName.setColumns(10);

			}
			{
				lblSurname = new JLabel("Second Name:");
				panel.add(lblSurname, "cell 0 1,alignx right,aligny center");
			}
			{
				txtInsertSurname = new JTextField();
				((AbstractDocument) txtInsertSurname.getDocument()).setDocumentFilter(new MyDocumentFilter());
				panel.add(txtInsertSurname, "cell 1 1,growx,aligny center");
				txtInsertSurname.setColumns(10);
			}
			{
				lblBirthDate = new JLabel("Birth Date:");
				panel.add(lblBirthDate, "cell 0 2,alignx right,aligny center");
			}
			{

				NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
				DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
				decimalFormat.setGroupingUsed(false);
				txtDD = new JTextField();
				txtDD.setColumns(15); // whatever size you wish to set
				panel.add(txtDD, "flowx,cell 1 2,alignx leading,aligny top");
				txtDD.setColumns(2);

				PlainDocument doc = (PlainDocument) txtDD.getDocument();
				doc.setDocumentFilter(new IntFilter(2));

			}
			{
				lblSex = new JLabel("Sex:");
				panel.add(lblSex, "cell 0 3,alignx right,aligny center");
			}

			{
				lblEmail = new JLabel("E-mail:");
				panel.add(lblEmail, "cell 0 4,alignx right,aligny center");
			}
			{
				txtInsertEmail = new JTextField();
				txtInsertEmail.setColumns(10);
				panel.add(txtInsertEmail, "cell 1 4,growx,aligny center");
			}
			{
				lblNationality = new JLabel("Nationality:");
				panel.add(lblNationality, "cell 0 5,alignx trailing");
			}
			{
				comboBox = new JComboBox(Locale.getISOCountries());
				panel.add(comboBox, "cell 1 5,growx");
			}
			{
				lblAddImg = new JLabel("Images:");
				panel.add(lblAddImg, "cell 0 6,alignx right,aligny center");
			}
			JButton btnNewButton = new JButton("Add FingerPrints and Palm");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// TODO add information into database by filling the
					// DialogWindow

					// START CHOOSER
					JFileChooser chooser = new JFileChooser();
					chooser.setMultiSelectionEnabled(true);
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("choosertitle");
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File[] pathBigImagesArray;
						Path newdir = Paths.get("/Users/dexter/Documents/workspace/LMF_Project/imagine.png");
						pathBigImagesArray = chooser.getSelectedFiles();
						System.out.println(pathBigImagesArray[0]);

						try {
							Files.copy(pathBigImagesArray[0].toPath(), newdir, StandardCopyOption.REPLACE_EXISTING);
						} catch (FileAlreadyExistsException e1) {
							// destination file already exists
						} catch (IOException e1) {
							// something else went wrong
							e1.printStackTrace();
						}

						// source is in pathBigImagesArray[i]
						// for (int i = 0; i < pathBigImagesArray.length;
						// i++) {
						// System.out.println("getSelectedFile() : " +
						// pathBigImagesArray[i]);
						// Files.move(pathBigImagesArray[i],
						// newdir.resolve(pathBigImagesArray[i].getFileName()));
						// }
					} else {
						System.out.println("No Selection ");
					}
					// END CHOOSER
				}
			});
			panel.add(btnNewButton, "cell 1 6,alignx center,aligny center");
			{
				label_1 = new JLabel("/");
				panel.add(label_1, "cell 1 2");
			}
			{
				txtMm = new JTextField();
				panel.add(txtMm, "cell 1 2");
				txtMm.setColumns(2);
				PlainDocument doc1 = (PlainDocument) txtMm.getDocument();
				doc1.setDocumentFilter(new IntFilter(2));
			}
			{
				label = new JLabel("/");
				panel.add(label, "cell 1 2");
			}
			{
				txtYyyy = new JTextField();
				panel.add(txtYyyy, "cell 1 2,alignx leading");
				txtYyyy.setColumns(4);
				PlainDocument doc2 = (PlainDocument) txtYyyy.getDocument();
				doc2.setDocumentFilter(new IntFilter(4));
			}
			{
				rdbtnMale = new JRadioButton("Male");
				rdbtnMale.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (rdbtnMale.isSelected()) {
							rdbtnFemale.setSelected(false);
						}
					}
				});

				panel.add(rdbtnMale, "flowx,cell 1 3");
			}
			{
				rdbtnFemale = new JRadioButton("Female");
				rdbtnFemale.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (rdbtnFemale.isSelected()) {
							rdbtnMale.setSelected(false);
						}
					}
				});
				if (rdbtnFemale.isSelected()) {
					rdbtnMale.setSelected(false);
				}
				panel.add(rdbtnFemale, "cell 1 3");
			}
			panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblName, txtInsertName,
					lblSurname, txtInsertSurname, lblBirthDate, txtDD, lblSex, lblEmail, txtInsertEmail, lblNationality,
					comboBox, lblAddImg, btnNewButton, label_1, txtMm, label, txtYyyy, rdbtnMale, rdbtnFemale }));
			{
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.setEnabled(false);
				
				
				
//				boolean flag = false;
//				arrayInfoPerson = new String[7];
//				do {
//					if (txtInsertName.getText().equals("") || txtInsertSurname.getText().equals("")
//							|| txtDD.getText().length() != 2 || txtMm.getText().length() != 2
//							|| txtYyyy.getText().length() != 4
//							|| (!rdbtnMale.isSelected() && !rdbtnFemale.isSelected())) {
//						flag = true;
//					} else {
//						okButton.setEnabled(true);
//						flag = false;
//					}
//				} while (flag);
				
				

				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						System.out.println("bottone premuto");
//						arrayInfoPerson = new String[7];
//						boolean flag = false;
//						
//						do {
//							if (txtInsertName.getText().equals("") || txtInsertSurname.getText().equals("")
//									|| txtDD.getText().length() != 2 || txtMm.getText().length() != 2
//									|| txtYyyy.getText().length() != 4
//									|| (!rdbtnMale.isSelected() && !rdbtnFemale.isSelected())) {
//								flag = true;
//							} else {
//								arrayInfoPerson[0] = txtInsertName.getText().trim();
//								arrayInfoPerson[1] = txtInsertSurname.getText().trim();
//								arrayInfoPerson[2] = txtYyyy.getText().trim() + "-" + txtMm.getText().trim() + "-"
//										+ txtDD.getText().trim();
//								// M or F
//								if (rdbtnMale.isSelected()) {
//									arrayInfoPerson[3] = "M";
//									flag = false;
//								} else if (rdbtnFemale.isSelected()) {
//									arrayInfoPerson[3] = "F";
//									flag = false;
//								} 
//								arrayInfoPerson[4] = txtInsertEmail.getText().trim();
//								System.out.println(comboBox.getSelectedItem());
//								System.out.println((String)comboBox.getSelectedItem());
//								arrayInfoPerson[5] = (String) comboBox.getSelectedItem();
//							}
//						} while (flag);
//
//						try {
//							System.out.println(2);
//							ConnectionDB connection = new ConnectionDB(new InsertRecordDB());
//							connection.executeStrategy(arrayInfoPerson);
//
//							System.out.println(3);
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
					}
				});

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public String[] getArrayInfoPerson() {
		return arrayInfoPerson;
	}

}
