package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Clients;

public class ClientsGraphic extends JFrame {
    private JTextField fName, fEmail, fAddr, fRfc;
    private JButton bCancel, bSave;
    private Clients clients;

    public ClientsGraphic(Clients clients) {
        super("Client");

        this.clients = clients;
        setLayout(new BorderLayout());
        add(title(), BorderLayout.NORTH);
        add(fields(), BorderLayout.CENTER);
        add(buttons(), BorderLayout.SOUTH);

        bCancel.addActionListener(new ListenerCancel());
        bSave.addActionListener(new ListenerSave());

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    class ListenerSave implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            String name, email, addr, rfc;

            name = fName.getText();
            email = fEmail.getText();
            addr = fAddr.getText();
            rfc = fRfc.getText();

            clients.add(name, email, addr, rfc);

            showMessage("Clienet uploaded!!!");
        }
    }

    class ListenerCancel implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            fName.setText(null);
            fEmail.setText(null);
            fAddr.setText(null);
            fRfc.setText(null);
        }
    }

    private JLabel title() {
        return new JLabel("Upload Client");
    }

    private JPanel fields() {
        JPanel b = new JPanel(new BorderLayout());

        JPanel north = new JPanel(new FlowLayout());
        fName = addField(north, "Name", 10);
        fEmail = addField(north, "Email", 15);

        JPanel center = new JPanel(new FlowLayout());
        fAddr = addField(center, "Address", 20);
        fRfc = addField(center, "RFC", 14);

        b.add(north, BorderLayout.NORTH);
        b.add(center, BorderLayout.CENTER);

        return b;
    }

    private JPanel buttons() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        bCancel = new JButton("Cancel");
        p.add(bCancel);

        bSave = new JButton("Save");
        p.add(bSave);

        return p;
    }

    private JTextField addField(JPanel div, String label, int size) {
        JTextField tField = new JTextField(size);
        div.add(new Label(label));
        div.add(tField);
        return tField;
    }

    private void showMessage(String message) {
        JFrame temp = new JFrame();

        temp.setLayout(new FlowLayout());
        temp.add(new Label(message));

        temp.pack();

        temp.setLocationRelativeTo(null);
        temp.setVisible(true);
    }

}
