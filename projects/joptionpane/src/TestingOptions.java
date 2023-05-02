import javax.swing.JOptionPane;

public class TestingOptions {
  public static void main(String[] argv) throws Exception {

    String[] buttons = {"l"};

    int rc = JOptionPane.showOptionDialog(null, "Question ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);

    System.out.println(rc);

  }
}