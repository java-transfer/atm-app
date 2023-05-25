package pages;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    JFrame loginPage;
    JLabel pageHeading;

    JPanel loginComponents;
    JTextField loginPin;
    JButton loginButton;
    JLabel errorText;

    public void closePage() {
        loginPage.setVisible(false);
    }

    public void initializeLayout() {
        loginPage.setLayout(new GridLayout(2, 1));
        loginPage.setPreferredSize(new Dimension(300, 200));

        loginPage.pack();
        loginPage.setResizable(false);
        loginPage.setVisible(true);
    }

    public Login() {
        loginPage = new JFrame("TSG Bank");
        loginComponents = new JPanel();
        loginComponents.setLayout(new FlowLayout());

        pageHeading = new JLabel("Enter Your PIN", JLabel.CENTER);

        loginPin = new JTextField(5);
        loginPin.setPreferredSize(new Dimension(42, 34));

        loginButton = new JButton("Proceed");
        loginButton.setPreferredSize(new Dimension(100, 34));

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                errorText.setVisible(false);

                try {
                    int inputedPIN = Integer.parseInt(loginPin.getText());

                    if (inputedPIN != 5555) {
                        errorText.setVisible(true);
                        System.out.println("Incorrect PIN Entered");
                        errorText.setText("Wrong PIN Entered ");

                    } else {
                        closePage();
                        SelectAccount selectAccount = new SelectAccount();
                    }

                } catch (Exception pinError) {
                    System.out.println("Invalid PIN Entered");
                    errorText.setVisible(true);
                }
            }

        });

        errorText = new JLabel("Invalid PIN");
        errorText.setForeground(Color.RED);

        // Work arround to add empty line below loginComponents
        // To separate errorText from button row

        JLabel empty_line = new JLabel("");
        empty_line.setPreferredSize(new Dimension(350, 0));

        loginComponents.add(loginPin);
        loginComponents.add(loginButton);
        loginComponents.add(empty_line);
        loginComponents.add(errorText);
        errorText.setVisible(false);

        loginPage.add(pageHeading);
        loginPage.add(loginComponents);

        initializeLayout();
    }
}