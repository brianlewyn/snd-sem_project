package view;

import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;

import controller.Products;
import controller.Providers;

public class NonElectronicProductGraphic extends JFrame {
    JTextField tfName, tfStock, tfCode, tfPrice, tfDiscount, tfDescription, tfDate, tfProvider;
    JButton bSave, bCancel;
    Products products;
    Providers providers;

    public NonElectronicProductGraphic(Products products, Providers providers) {
        super("Product");

        this.products = products;
        this.providers = providers;

        setLayout(new BorderLayout());
        add(titlepProduct());
        add(fields(), BorderLayout.CENTER);
        add(BooleanButtons(), BorderLayout.SOUTH);

        bCancel.addActionListener(new CancelListener());
        bSave.addActionListener(new SaveListener());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Label titlepProduct() {
        return new Label("Upload Product");
    }

    private JPanel fields() {
        JPanel p = new JPanel(new BorderLayout());

        JPanel north = new JPanel(new FlowLayout());
        tfName = addField(north, "Name", 10);
        tfStock = addField(north, "Stock", 2);
        tfCode = addField(north, "Code", 10);
        tfPrice = addField(north, "Price", 10);

        JPanel center = new JPanel(new FlowLayout());
        tfDiscount = addField(center, "Discount", 10);
        tfDescription = addField(center, "Description", 50);
        tfProvider = addField(center, "Provider", 10);

        p.add(north, BorderLayout.NORTH);
        p.add(center, BorderLayout.CENTER);

        return p;
    }

    private JPanel BooleanButtons() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        bSave = new JButton("Save");
        p.add(bSave);

        bCancel = new JButton("Cancel");
        p.add(bCancel);

        return p;

    }

    private JTextField addField(JPanel div, String label, int size) {
        JTextField tField = new JTextField(size);
        div.add(new Label(label));
        div.add(tField);
        return tField;
    }

    // Listeners
    class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            tfName.setText(null);
            tfStock.setText(null);
            tfCode.setText(null);
            tfPrice.setText(null);
            tfDiscount.setText(null);
            tfProvider.setText(null);
            tfDescription.setText(null);
        }
    }

    class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            String name = tfName.getText();
            int stock = Integer.parseInt(tfStock.getText());
            long code = Long.parseLong(tfCode.getText());
            float price = Float.parseFloat(tfPrice.getText());
            float discount = Float.parseFloat(tfDiscount.getText());
            String provider = tfProvider.getText();
            String description = tfDescription.getText();

            if (providers.modify(provider) != null) {
                products.addNonElectronicProduct(name, stock, code, price, discount, description, LocalDate.now(),
                        providers.modify(provider));
                showMessage("Product upload");
            } else {
                showMessage("Provider not found");
            }
        }
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