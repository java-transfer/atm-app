package pages;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.AccountData;
import utils.Functions;

public class Withdraw {
    JFrame withdrawPage;
    JLabel pageHeading;

    JPanel withdrawComponents;
    JTextField amount;
    JButton withdrawButton;
    JLabel errorText;

    public void closePage() {
        withdrawPage.setVisible(false);
    }

    public void initializeLayout() {
        withdrawPage.setLayout(new GridLayout(2, 1));
        withdrawPage.setPreferredSize(new Dimension(300, 200));

        withdrawPage.pack();
        withdrawPage.setResizable(false);
        withdrawPage.setVisible(true);
    }

    public Withdraw() {
        withdrawPage = new JFrame("TSG Bank");
        withdrawComponents = new JPanel();
        withdrawComponents.setLayout(new FlowLayout());

        pageHeading = new JLabel("Enter Amount to Withdraw", JLabel.CENTER);

        amount = new JTextField(5);
        amount.setPreferredSize(new Dimension(42, 34));

        errorText = new JLabel("Invalid Amount");
        errorText.setForeground(Color.RED);


        withdrawButton = new JButton("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(100, 34));

        withdrawButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                errorText.setVisible(false);

                try {
                    float amountToDebit = Integer.parseInt(amount.getText());

                    if (amountToDebit >= 20000 && AccountData.accountType == "Savings") {
                        errorText.setVisible(true);
                        System.out.println("Amount must be under 20,000");
                        errorText.setText("Amount must be under 20,000");

                    } else if(amountToDebit > AccountData.accountBalance) {
                        System.out.println("Insufficient Funds");
                        errorText.setText("Insufficient Funds");
                        errorText.setVisible(true);

                    } else {
                        
                        Functions functions = new Functions();
                        functions.debitAccount(amountToDebit);
                        closePage();
                        Success success = new Success();

                    }

                } catch (Exception amountError) {
                    System.out.println("Invalid Value Entered");
                    errorText.setVisible(true);
                }
            }

        });


        // Work arround to add empty line below withdrawComponents
        // To separate errorText from button row

        JLabel empty_line = new JLabel("");
        empty_line.setPreferredSize(new Dimension(350, 0));

        withdrawComponents.add(amount);
        withdrawComponents.add(withdrawButton);
        withdrawComponents.add(empty_line);
        withdrawComponents.add(errorText);
        errorText.setVisible(false);

        withdrawPage.add(pageHeading);
        withdrawPage.add(withdrawComponents);

        initializeLayout();
    }
}

