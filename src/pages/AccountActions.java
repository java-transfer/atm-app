package pages;

import javax.swing.*;
import java.awt.*;


public class AccountActions {
    JFrame AccountActionsPage;
    JPanel AccountActionsComponents;
    JLabel pageHeading;
    JButton depositButton;
    JButton withdrawButton;


    // Set window to same size as every other window
    public void initializeLayout() {
        AccountActionsPage.setLayout(new GridLayout(2, 1));
        AccountActionsPage.setPreferredSize(new Dimension(300, 200));

        AccountActionsPage.pack();
        AccountActionsPage.setResizable(false);
        AccountActionsPage.setVisible(true);
    }
    
    public AccountActions() {
        AccountActionsPage = new JFrame("Select Preferred Action");
        pageHeading = new JLabel("Hello! what do you want to do?", JLabel.CENTER);

        depositButton = new JButton("Deposit");
        depositButton.setPreferredSize(new Dimension(100, 34));

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(100, 34));

        AccountActionsComponents = new JPanel();
        AccountActionsComponents.setLayout(new FlowLayout());
        AccountActionsComponents.add(depositButton);
        AccountActionsComponents.add(withdrawButton);

        AccountActionsPage.add(pageHeading);
        AccountActionsPage.add(AccountActionsComponents);
        initializeLayout();
    }
}