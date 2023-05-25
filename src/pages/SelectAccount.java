package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.Functions;

public class SelectAccount {
    JFrame selectAccountPage;
    JPanel selectAccountComponents;
    JLabel pageHeading;
    JButton savingsButton;
    JButton currentButton;

    // Functions
    Functions functions = new Functions();

    // Set window to same size as every other window
    public void initializeLayout() {
        selectAccountPage.setLayout(new GridLayout(2, 1));
        selectAccountPage.setPreferredSize(new Dimension(300, 200));

        selectAccountPage.pack();
        selectAccountPage.setResizable(false);
        selectAccountPage.setVisible(true);
    }

    // Close page
    public void closePage() {
        selectAccountPage.setVisible(false);
    }

    public SelectAccount() {
        selectAccountPage = new JFrame("TSG Bank");
        selectAccountComponents = new JPanel();
        selectAccountComponents.setLayout(new FlowLayout());

        pageHeading = new JLabel("Enter Account Type", JLabel.CENTER);

        savingsButton = new JButton("Savings");
        savingsButton.setPreferredSize(new Dimension(100, 34));
        savingsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                closePage();
                functions.setAccountType("Savings");                
                SelectTransaction selectTransaction = new SelectTransaction();
            }
        });

        currentButton = new JButton("Current");
        currentButton.setPreferredSize(new Dimension(100, 34));
        currentButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                closePage();
                functions.setAccountType("Current");                
                SelectTransaction selectTransaction = new SelectTransaction();
            }
        });



        selectAccountComponents.add(savingsButton);
        selectAccountComponents.add(currentButton);

        selectAccountPage.add(pageHeading);
        selectAccountPage.add(selectAccountComponents);
        initializeLayout();
    }
}
