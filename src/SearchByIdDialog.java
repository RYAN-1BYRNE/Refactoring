/*
 *
 * This is the dialog for Employee search by ID
 *
 * */

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByIdDialog extends JDialog implements ActionListener {
    private EmployeeDetails parent;
    private JButton search, cancel;
    private JTextField searchField;

    // constructor for SearchByIdDialog
    public SearchByIdDialog(EmployeeDetails parent) {
        setTitle("Search by Surname");
        setModal(true);
        this.parent = parent;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(searchPane());
        setContentPane(scrollPane);

        getRootPane().setDefaultButton(search);

        setSize(500, 190);
        setLocation(350, 250);
        setVisible(true);
    }// end SearchByIdDialog

    // initialize search container
    public Container searchPane() {
        JPanel searchPanel = new JPanel(new GridLayout(3, 1));
        JPanel textPanel = createTextPanel();
        JPanel buttonPanel = createButtonPanel();
        searchPanel.add(new JLabel("Search by ID"));
        searchPanel.add(textPanel);
        searchPanel.add(buttonPanel);

        return searchPanel;
    }// end searchPane

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(search = new JButton("Search"));
        search.addActionListener(this);
        search.requestFocus();
        buttonPanel.add(cancel = new JButton("Cancel"));
        cancel.addActionListener(this);
        return buttonPanel;
    }

    // create text panel
    public JPanel createTextPanel() {
        JLabel searchLabel;
        JPanel textPanel = new JPanel();
        textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        textPanel.add(searchLabel = new JLabel("Enter ID:"));
        searchLabel.setFont(this.parent.font1);
        textPanel.add(searchField = new JTextField(20));
        searchField.setFont(this.parent.font1);
        searchField.setDocument(new JTextFieldLimit(20));
        return textPanel;
    }

    // action listener for save and cancel button
    public void actionPerformed(ActionEvent e) {
        // if option search, search for Employee
        SearchByDialog.actionPerformed(e, search, searchField, cancel, this.parent);
    }
}// end class searchByIdDialog
