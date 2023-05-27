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

public class ProvidersGraphic extends JFrame {

    private JButton cancelButton;
    private JButton saveButton;

    private JTextField tName;
    private JTextField tEmail;
    private JTextField tPhone;

    Providers providers;

    public ProvidersGraphic(Providers providers) {
        super("Provider's Window");

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

        setLayout(new BorderLayout());

        add(BooleanButtons(cancelButton, saveButton), BorderLayout.SOUTH);
        add(createProvidersPanel(lName, lEmail, lPhoneNumber, tName, tEmail, tPhone), BorderLayout.CENTER);
        add(new JLabel("Upload the provider information"), BorderLayout.NORTH);

        cancelButton.addActionListener(new CancelListener());
        saveButton.addActionListener(new SaveListener());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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
            providers.add(tName.getText(), tEmail.getText(), tPhone.getText());

        }
    }

}