import javax.swing.JOptionPane;

public class Test {
  public static void main(String[] argv) throws Exception {

    String[] buttons = { "Yes", "Yes to all", "No", "Cancel" };

    int rc = JOptionPane.showOptionDialog(null, "Question ?", "Confirmation",
        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[2]);

    System.out.println(rc);

  }
}