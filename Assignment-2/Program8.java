import javax.swing.*;
import java.awt.event.*;

public class Program8 extends JFrame implements ActionListener {

    JLabel lblPrincipal, lblRate, lblTime, lblAmount;
    JTextField txtPrincipal, txtRate, txtTime, txtAmount;
    JButton btnCalculate, btnClear;

    Program8() {
        // Frame title
        setTitle("Investment Calculator");

        // Layout
        setLayout(null);

        // Labels
        lblPrincipal = new JLabel("Principal Amount");
        lblRate = new JLabel("Rate (%)");
        lblTime = new JLabel("Time (Years)");
        lblAmount = new JLabel("Final Amount");

        // Text fields
        txtPrincipal = new JTextField();
        txtRate = new JTextField();
        txtTime = new JTextField();
        txtAmount = new JTextField();

        // Buttons
        btnCalculate = new JButton("Calculate");
        btnClear = new JButton("Clear");

        // Set positions
        lblPrincipal.setBounds(50, 50, 120, 30);
        txtPrincipal.setBounds(180, 50, 150, 30);

        lblRate.setBounds(50, 100, 120, 30);
        txtRate.setBounds(180, 100, 150, 30);

        lblTime.setBounds(50, 150, 120, 30);
        txtTime.setBounds(180, 150, 150, 30);

        lblAmount.setBounds(50, 200, 120, 30);
        txtAmount.setBounds(180, 200, 150, 30);
        txtAmount.setEditable(false);

        btnCalculate.setBounds(70, 270, 100, 30);
        btnClear.setBounds(200, 270, 100, 30);

        // Add components
        add(lblPrincipal);
        add(txtPrincipal);

        add(lblRate);
        add(txtRate);

        add(lblTime);
        add(txtTime);

        add(lblAmount);
        add(txtAmount);

        add(btnCalculate);
        add(btnClear);

        // Add action listeners
        btnCalculate.addActionListener(this);
        btnClear.addActionListener(this);

        // Frame settings
        setSize(420, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCalculate) {
            try {
                double principal = Double.parseDouble(txtPrincipal.getText());
                double rate = Double.parseDouble(txtRate.getText());
                double time = Double.parseDouble(txtTime.getText());

                // Simple Interest Formula
                double amount = principal + (principal * rate * time / 100);

                txtAmount.setText(String.valueOf(amount));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid numeric values.");
            }
        }

        if (e.getSource() == btnClear) {
            txtPrincipal.setText("");
            txtRate.setText("");
            txtTime.setText("");
            txtAmount.setText("");
        }
    }

    public static void main(String[] args) {
        new Program8();
    }
}