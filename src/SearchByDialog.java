import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SearchByDialog {
    public static void actionPerformed(ActionEvent e, JButton search, JTextField searchField, JButton cancel, EmployeeDetails searchByIdDialog) {
        // if option search, search for Employee
        if (e.getSource() == search) {
            // try get correct valus from text field
            try {
                Double.parseDouble(searchField.getText());
                searchByIdDialog.searchByIdField.setText(searchField.getText());
                // search Employee by ID
                searchByIdDialog.searchEmployeeById();
                searchByIdDialog.dispose();// dispose dialog
            }// end try
            catch (NumberFormatException num) {
                // display message and set colour to text field if entry is wrong
                searchField.setBackground(new Color(255, 150, 150));
                JOptionPane.showMessageDialog(null, "Wrong ID format!");
            }// end catch
        }// end if
        // else dispose dialog
        else if (e.getSource() == cancel)
            searchByIdDialog.dispose();
    }// end actionPerformed
}
