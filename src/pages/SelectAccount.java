package pages;

import javax.swing.*;
import java.awt.*;

public class SelectAccount {
    JFrame selectAccountPage;
    JPanel selectAccountComponents;
    JLabel pageHeading;
    JButton savingsButton;
    JButton currentButton;

    // Set window to same size as every other window
    public void initializeLayout() {
        selectAccountPage.setLayout(new GridLayout(2, 1));
        selectAccountPage.setPreferredSize(new Dimension(300, 200));

        selectAccountPage.pack();
        selectAccountPage.setResizable(false);
        selectAccountPage.setVisible(true);
    }

    public SelectAccount() {
        selectAccountPage = new JFrame("Select account type");
        pageHeading = new JLabel("Enter Account Type", JLabel.CENTER);

        savingsButton = new JButton("Saving");
        savingsButton.setPreferredSize(new Dimension(100, 34));

        currentButton = new JButton("Current");
        currentButton.setPreferredSize(new Dimension(100, 34));

        selectAccountComponents = new JPanel();
        selectAccountComponents.setLayout(new FlowLayout());
        selectAccountComponents.add(savingsButton);
        selectAccountComponents.add(currentButton);

        selectAccountPage.add(pageHeading);
        selectAccountPage.add(selectAccountComponents);
        initializeLayout();
    }
}
