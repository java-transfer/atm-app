package pages;
import javax.swing.*;
import utils.Functions;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectTransaction {
    JFrame SelectTransactionPage;
    JPanel SelectTransactionComponents;
    JLabel pageHeading;
    JButton depositButton;
    JButton withdrawButton;


    // Set window to same size as every other window
    public void initializeLayout() {
        SelectTransactionPage.setLayout(new GridLayout(2, 1));
        SelectTransactionPage.setPreferredSize(new Dimension(300, 200));

        SelectTransactionPage.pack();
        SelectTransactionPage.setResizable(false);
        SelectTransactionPage.setVisible(true);
    }
    
    // Close page
    public void closePage() {
        SelectTransactionPage.setVisible(false);
    }

        
    public SelectTransaction() {
        SelectTransactionPage = new JFrame("TSG Bank");

        SelectTransactionComponents = new JPanel();
        SelectTransactionComponents.setLayout(new FlowLayout());

        pageHeading = new JLabel("Select Transaction", JLabel.CENTER);

        depositButton = new JButton("Deposit");
        depositButton.setPreferredSize(new Dimension(100, 34));
        depositButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                closePage();           
                Deposit perfomDeposit = new Deposit();
            }
        });

        withdrawButton = new JButton("Withdrawal");
        withdrawButton.setPreferredSize(new Dimension(100, 34));
        withdrawButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                closePage();           
                Withdraw performWithdrawal = new Withdraw();
            }
        });

        SelectTransactionComponents.add(depositButton);
        SelectTransactionComponents.add(withdrawButton);

        SelectTransactionPage.add(pageHeading);
        SelectTransactionPage.add(SelectTransactionComponents);
        initializeLayout();
    }
}