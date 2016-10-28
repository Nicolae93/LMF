
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
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;
import java.util.Vector;
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
	private JComboBox comboBoxNat;
	private JLabel lblAddImg;
	private JLabel label_1;
	private JLabel label;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private Path saveDir = Paths.get("/Users/dexter/Documents/LMF/scans/imag.tif");
	File[] filePathImgToMove;
	
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
			{ // Country list for combobox in Jdialog
				Vector<String> v = new Vector<String>();
				Locale[] locales = Locale.getAvailableLocales();
				for (Locale locale : locales) {
					// String iso = locale.getISO3Country();
					// String code = locale.getCountry();
					String name = locale.getDisplayCountry();
					if (!v.contains(name))
						v.addElement(name);
				}
				Collections.sort(v);
				comboBoxNat = new JComboBox(v);
				panel.add(comboBoxNat, "cell 1 5,growx");
			}
			{
				lblAddImg = new JLabel("Images:");
				panel.add(lblAddImg, "cell 0 6,alignx right,aligny center");
			}
			JButton btnNewButton = new JButton("Add FingerPrints and Palm");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// START CHOOSER
					JFileChooser chooser = new JFileChooser();
					chooser.setMultiSelectionEnabled(true);
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("Select images");
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						System.out.println(0);
						filePathImgToMove = chooser.getSelectedFiles(); // filePathImgToMove
																		// have
																		// all
																		// the
																		// paths
																		// selected
																		// from
																		// chooser
						System.out.println(1);
						System.out.println("Path selectioned in chooser: " + filePathImgToMove[0]);

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
					comboBoxNat, lblAddImg, btnNewButton, label_1, txtMm, label, txtYyyy, rdbtnMale, rdbtnFemale }));
			{
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Save");
				saveButton.setEnabled(true);

				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						System.out.println("bottone premuto");
						arrayInfoPerson = new String[6 + filePathImgToMove.length]; //creo un array di dimensioni 6(nome,...,email) + numero di oggetti selezionati nel chooser
						System.out.println("filePathImgToMove.length: " + filePathImgToMove.length);
						
						
						// condition for insertion
						if (txtInsertName.getText().trim().equals("") || txtInsertSurname.getText().trim().equals("")
								|| txtDD.getText().length() != 2 || txtMm.getText().length() != 2
								|| txtYyyy.getText().length() != 4
								|| (!rdbtnMale.isSelected() && !rdbtnFemale.isSelected())
								|| comboBoxNat.getSelectedItem().equals("") || filePathImgToMove == null
								|| (Integer.parseInt(txtDD.getText()) < 0 || Integer.parseInt(txtDD.getText()) > 31)
								|| (Integer.parseInt(txtMm.getText()) < 0 || Integer.parseInt(txtMm.getText()) > 12)
								|| (Integer.parseInt(txtYyyy.getText()) < 0 || Integer
										.parseInt(txtYyyy.getText()) > Calendar.getInstance().get(Calendar.YEAR))
								|| filePathImgToMove.length == 0){
							
							// Error message if insertion is wrong
							JOptionPane.showMessageDialog(null, "Missing something", "Incorrect Input",
									JOptionPane.WARNING_MESSAGE);
							// Crea un'altro JDialog
							JDialogWindow dialog = new JDialogWindow();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
							// chiudi JDialog
							dispose();

						} else {
							arrayInfoPerson[0] = txtInsertName.getText().trim(); // firstname
							arrayInfoPerson[1] = txtInsertSurname.getText().trim(); // lastname
							arrayInfoPerson[2] = txtYyyy.getText().trim() + "-" + txtMm.getText().trim() + "-" // bithdate
									+ txtDD.getText().trim();
							// M or F
							if (rdbtnMale.isSelected()) { // sex
								arrayInfoPerson[3] = "M";
							} else if (rdbtnFemale.isSelected()) {
								arrayInfoPerson[3] = "F";
							}

							arrayInfoPerson[4] = (String) comboBoxNat.getSelectedItem(); // nationality

							arrayInfoPerson[5] = txtInsertEmail.getText().trim(); // e-mail
							
							for (int i = 0; i < filePathImgToMove.length; i++) {
								arrayInfoPerson[6+i] = filePathImgToMove[i].toString(); // aggiungo ad arrayInfoPerson i path(conv in stringhe) delle immagini da muovere 
								System.out.println("path aggiunti alla fine dell'array arrayInfoPerson, posizione "+i+": "+filePathImgToMove[i].toString());
							}
							
							for (int i = 0; i < arrayInfoPerson.length; i++) {
								System.out.println("stampa tutti i valori dentro infoPerson: "+arrayInfoPerson[i]);
							}
							

							ConnectionDB connection = new ConnectionDB(new InsertRecordDB());
							try {
								// connection to database and execute insertion
								String[] infoPersonAdded = connection.executeStrategy(arrayInfoPerson);
								dispose();
								JOptionPane.showMessageDialog (null, "Person '" + infoPersonAdded[0] + "' added successfully", "message", JOptionPane.INFORMATION_MESSAGE);

							} catch (SQLException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}

						}
					}
				});

				saveButton.setActionCommand("OK");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	public String[] getArrayInfoPerson() {
		return arrayInfoPerson;
	}

}
