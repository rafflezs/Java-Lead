import javax.swing.*;
import graphstest.GraphTest;

public class GraphMain {
    public static void main(String[] args) {

        GraphTest gp = new GraphTest(JOptionPane.showInputDialog("Test user input"));
        JOptionPane.showMessageDialog(null, "User input: " + gp.getText());
    }
}
