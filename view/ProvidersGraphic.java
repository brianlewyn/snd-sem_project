package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Providers;

public class ProvidersGraphic {

    JButton cancelButton;
    JButton saveButton;

    JTextField tName;
    JTextField tEmail;
    JTextField tPhone;

    Providers providers;

    public ProvidersGraphic(Providers providers) {

        this.providers = providers;

        // Name, email, phonenumber
        JLabel lName = new JLabel("Name");
        JLabel lEmail = new JLabel("Email");
        JLabel lPhoneNumber = new JLabel("Phonenumber");

        cancelButton = new JButton("Cancel");
        saveButton = new JButton("Save");

        tName = new JTextField("", 20);
        tEmail = new JTextField("", 20);
        tPhone = new JTextField("", 20);

        JFrame frame = new JFrame("Provider's Window");
        frame.setLayout(new BorderLayout());

        frame.add(BooleanButtons(cancelButton, saveButton), BorderLayout.SOUTH);
        frame.add(createProvidersPanel(lName, lEmail, lPhoneNumber, tName, tEmail, tPhone), BorderLayout.CENTER);
        frame.add(new JLabel("Upload the provider information"), BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createProvidersPanel(JLabel lName, JLabel lEmail, JLabel lPhoneNumber,
            JTextField tName, JTextField tEmail, JTextField tPhone) {

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p.add(lName);
        p.add(tName);

        p.add(lEmail);
        p.add(tEmail);

        p.add(lPhoneNumber);
        p.add(tPhone);

        return p;

    }

    private JPanel BooleanButtons(JButton cancelButton, JButton saveButton) {

        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        p.add(cancelButton);
        p.add(saveButton);

        return p;

    }

    class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tName.setText(null);
            tEmail.setText(null);
            tPhone.setText(null);
        }
    }

    class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String name = tName.getText();
            String email = tEmail.getText();
            String phone = tPhone.getText();

            providers.add(name, email, phone);

            tName.setText(null);
            tEmail.setText(null);
            tPhone.setText(null);

        }
    }

}