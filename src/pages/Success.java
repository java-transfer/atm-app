package pages;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.Functions;

public class Success {
    JFrame successPage;
    JLabel pageHeading;

    JPanel successComponents;
    JButton exitButton;

    public void closePage() {
        successPage.setVisible(false);
    }

    public void initializeLayout() {
        successPage.setLayout(new GridLayout(2, 1));
        successPage.setPreferredSize(new Dimension(300, 200));

        successPage.pack();
        successPage.setResizable(false);
        successPage.setVisible(true);
    }

    public Success() {
        successPage = new JFrame("TSG Bank");
        successComponents = new JPanel();
        successComponents.setLayout(new FlowLayout());

        pageHeading = new JLabel("Transaction Completed!", JLabel.CENTER);

        exitButton = new JButton("Close");
        exitButton.setPreferredSize(new Dimension(100, 34));

        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                successPage.setVisible(false);
            }
        });


        // Work arround to add empty line below successComponents
        // To separate errorText from button row

        JLabel empty_line = new JLabel("");
        empty_line.setPreferredSize(new Dimension(350, 0));

        successComponents.add(exitButton);
        successComponents.add(empty_line);

        successPage.add(pageHeading);
        successPage.add(successComponents);

        initializeLayout();
    }
}



