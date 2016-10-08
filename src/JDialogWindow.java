import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;

import com.mysql.fabric.xmlrpc.base.Array;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class JDialogWindow extends JDialog {
	private JTextField txtInsertName;
	private JTextField txtInsertSurname;
	private JTextField txtDdmmyyyy;
	private JTextField txtMOrF;
	private JTextField txtInsertEmail;
	private String[] arrayInfoPerson;
	/**
	 * Create the dialog.
	 */
	public JDialogWindow() {
		setBounds(100, 100, 400, 260);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 72, 319, 0 };
			gbl_panel.rowHeights = new int[] { 28, 28, 28, 28, 28, 29, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblName = new JLabel("First Name:");
				GridBagConstraints gbc_lblName = new GridBagConstraints();
				gbc_lblName.anchor = GridBagConstraints.EAST;
				gbc_lblName.insets = new Insets(0, 0, 5, 5);
				gbc_lblName.gridx = 0;
				gbc_lblName.gridy = 0;
				panel.add(lblName, gbc_lblName);
			}
			{
				txtInsertName = new JTextField();
				txtInsertName.setText("insert name");
				GridBagConstraints gbc_txtInsertName = new GridBagConstraints();
				gbc_txtInsertName.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInsertName.insets = new Insets(0, 0, 5, 0);
				gbc_txtInsertName.gridx = 1;
				gbc_txtInsertName.gridy = 0;
				panel.add(txtInsertName, gbc_txtInsertName);
				txtInsertName.setColumns(10);
			}
			{
				JLabel lblSurname = new JLabel("Second Name:");
				GridBagConstraints gbc_lblSurname = new GridBagConstraints();
				gbc_lblSurname.anchor = GridBagConstraints.EAST;
				gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
				gbc_lblSurname.gridx = 0;
				gbc_lblSurname.gridy = 1;
				panel.add(lblSurname, gbc_lblSurname);
			}
			{
				txtInsertSurname = new JTextField();
				txtInsertSurname.setText("insert surname");
				GridBagConstraints gbc_txtInsertSurname = new GridBagConstraints();
				gbc_txtInsertSurname.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInsertSurname.insets = new Insets(0, 0, 5, 0);
				gbc_txtInsertSurname.gridx = 1;
				gbc_txtInsertSurname.gridy = 1;
				panel.add(txtInsertSurname, gbc_txtInsertSurname);
				txtInsertSurname.setColumns(10);
			}
			{
				JLabel lblBirthDate = new JLabel("Birth Date:");
				GridBagConstraints gbc_lblBirthDate = new GridBagConstraints();
				gbc_lblBirthDate.anchor = GridBagConstraints.EAST;
				gbc_lblBirthDate.insets = new Insets(0, 0, 5, 5);
				gbc_lblBirthDate.gridx = 0;
				gbc_lblBirthDate.gridy = 2;
				panel.add(lblBirthDate, gbc_lblBirthDate);
			}
			{
				txtDdmmyyyy = new JTextField();
				txtDdmmyyyy.setText("DD-MM-YYYY");
				GridBagConstraints gbc_txtDdmmyyyy = new GridBagConstraints();
				gbc_txtDdmmyyyy.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDdmmyyyy.insets = new Insets(0, 0, 5, 0);
				gbc_txtDdmmyyyy.gridx = 1;
				gbc_txtDdmmyyyy.gridy = 2;
				panel.add(txtDdmmyyyy, gbc_txtDdmmyyyy);
				txtDdmmyyyy.setColumns(10);
			}
			{
				JLabel lblSex = new JLabel("Sex:");
				GridBagConstraints gbc_lblSex = new GridBagConstraints();
				gbc_lblSex.anchor = GridBagConstraints.EAST;
				gbc_lblSex.insets = new Insets(0, 0, 5, 5);
				gbc_lblSex.gridx = 0;
				gbc_lblSex.gridy = 3;
				panel.add(lblSex, gbc_lblSex);
			}
			{
				txtMOrF = new JTextField();
				txtMOrF.setText("'M' or 'F'");
				GridBagConstraints gbc_txtMOrF = new GridBagConstraints();
				gbc_txtMOrF.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMOrF.insets = new Insets(0, 0, 5, 0);
				gbc_txtMOrF.gridx = 1;
				gbc_txtMOrF.gridy = 3;
				panel.add(txtMOrF, gbc_txtMOrF);
				txtMOrF.setColumns(10);
			}
			{
				JLabel lblEmail = new JLabel("E-mail::");
				GridBagConstraints gbc_lblEmail = new GridBagConstraints();
				gbc_lblEmail.anchor = GridBagConstraints.EAST;
				gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail.gridx = 0;
				gbc_lblEmail.gridy = 4;
				panel.add(lblEmail, gbc_lblEmail);
			}
			{
				txtInsertEmail = new JTextField();
				txtInsertEmail.setText("insert e-mail");
				txtInsertEmail.setColumns(10);
				GridBagConstraints gbc_txtInsertEmail = new GridBagConstraints();
				gbc_txtInsertEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInsertEmail.insets = new Insets(0, 0, 5, 0);
				gbc_txtInsertEmail.gridx = 1;
				gbc_txtInsertEmail.gridy = 4;
				panel.add(txtInsertEmail, gbc_txtInsertEmail);
			}
			{
				JLabel lblAddImg = new JLabel("Images:");
				GridBagConstraints gbc_lblAddImg = new GridBagConstraints();
				gbc_lblAddImg.insets = new Insets(0, 0, 0, 5);
				gbc_lblAddImg.gridx = 0;
				gbc_lblAddImg.gridy = 5;
				panel.add(lblAddImg, gbc_lblAddImg);
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
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.gridx = 1;
			gbc_btnNewButton.gridy = 5;
			panel.add(btnNewButton, gbc_btnNewButton);
			{
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								
						arrayInfoPerson[0] = txtInsertName.getText().trim();	
						arrayInfoPerson[1] = txtInsertSurname.getText().trim();
						arrayInfoPerson[2] = txtDdmmyyyy.getText().trim();
						arrayInfoPerson[3] = txtMOrF.getText().trim();
						arrayInfoPerson[4] = txtInsertEmail.getText().trim();
						
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
