package pages;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.Functions;

public class Deposit {
    JFrame depositPage;
    JLabel pageHeading;

    JPanel depositComponents;
    JTextField amount;
    JButton depositButton;
    JLabel errorText;

    public void closePage() {
        depositPage.setVisible(false);
    }

    public void initializeLayout() {
        depositPage.setLayout(new GridLayout(2, 1));
        depositPage.setPreferredSize(new Dimension(300, 200));

        depositPage.pack();
        depositPage.setResizable(false);
        depositPage.setVisible(true);
    }

    public Deposit() {
        depositPage = new JFrame("TSG Bank");
        depositComponents = new JPanel();
        depositComponents.setLayout(new FlowLayout());

        pageHeading = new JLabel("Enter Amount to Deposit", JLabel.CENTER);

        amount = new JTextField(5);
        amount.setPreferredSize(new Dimension(42, 34));

        errorText = new JLabel("Invalid Amount");
        errorText.setForeground(Color.RED);


        depositButton = new JButton("Deposit");
        depositButton.setPreferredSize(new Dimension(100, 34));

        depositButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                errorText.setVisible(false);

                try {
                    float amountToCredit = Integer.parseInt(amount.getText());

                    if (amountToCredit < 0) {
                        errorText.setVisible(true);
                        System.out.println("Can't Deposit Negatives");
                        errorText.setText("Can't Deposit Negatives");

                    } else {
                        Functions functions = new Functions();
                        functions.creditAccount(amountToCredit);
                        closePage();
                        Success success = new Success();
                    }

                } catch (Exception amountError) {
                    System.out.println("Invalid Value Entered");
                    errorText.setVisible(true);
                }
            }

        });


        // Work arround to add empty line below depositComponents
        // To separate errorText from button row

        JLabel empty_line = new JLabel("");
        empty_line.setPreferredSize(new Dimension(350, 0));

        depositComponents.add(amount);
        depositComponents.add(depositButton);
        depositComponents.add(empty_line);
        depositComponents.add(errorText);
        errorText.setVisible(false);

        depositPage.add(pageHeading);
        depositPage.add(depositComponents);

        initializeLayout();
    }
}

