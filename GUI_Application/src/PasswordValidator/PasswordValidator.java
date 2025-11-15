package PasswordValidator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class PasswordValidator extends JFrame{
    private JPanel mainPanel;
    private JLabel statusLabel;
    private JPasswordField passwordTextField;


    public PasswordValidator() {
//        mainPanel = new JPanel();
//        passwordTextField = new JPasswordField();
//        statusLabel = new JLabel();

        mainPanel.setName("mainPanel");
        setContentPane(mainPanel);
        setTitle("Password Validator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        passwordTextField.setName("passwordTextField");
        statusLabel.setName("statusLabel");
        passwordTextField.setEchoChar('*');
        passwordTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validatePassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validatePassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    private void validatePassword() {
        char[] pass = passwordTextField.getPassword();

        if(pass.length < 8) {
            statusLabel.setText("Password must be 8 characters long");
            statusLabel.setForeground(Color.RED);
        } else if(!checkDigit(pass)) {
            statusLabel.setText("Password must contain at least one digit");
            statusLabel.setForeground(Color.RED);
        } else if(!checkSpecial(pass)) {
            statusLabel.setText("Password must contain at least one special character");
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setText("Password is valid");
            statusLabel.setForeground(Color.GREEN);
        }

    }

    private boolean checkSpecial(char[] pass) {
        for(char c : pass) {
            if(!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDigit(char[] pass) {
        for(char c : pass) {
            if(Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new PasswordValidator();
    }
}
