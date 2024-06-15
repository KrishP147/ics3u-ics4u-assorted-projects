import javax.swing.JOptionPane;

class AccessModifiers {
    private static final String[] OPTIONS = {
            "Visible in all classes in all packages",
            "Visible to all classes in the same package or classes in other packages that are a subclass",
            "Visible to all classes in the same package",
            "Visible only in the same class"
    };

    public void run() {
        while (true) {
            int accessLevel = programDescription("Pick an access modifier type for information");
            if (accessLevel == -1) { // User clicked cancel or closed the dialog
                goodBye();
            } else {
                showMessage(accessLevel);
            }
        }
    }

    private int programDescription(String instructions) {
        String[] options = {"Public", "Protected", "Default", "Private"};
        return JOptionPane.showOptionDialog(null, instructions, "WELCOME",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    private void showMessage(int index) {
        JOptionPane.showMessageDialog(null, OPTIONS[index]);
    }

    private void goodBye() {
        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
        System.exit(0);
    }
}