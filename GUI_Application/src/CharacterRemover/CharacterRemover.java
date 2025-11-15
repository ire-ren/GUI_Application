package CharacterRemover;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterRemover extends JFrame{
    private JCheckBox vowelsCheckBox;
    private JCheckBox consonantsCheckBox;
    private JCheckBox numbersCheckBox;
    private JButton restoreButton;
    private JButton removeButton;
    private JPanel MainPanel;
    private JLabel textLabel;

    String original = textLabel.getText();

    public CharacterRemover() {
        setContentPane(MainPanel);
        setTitle("Character Remover");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = textLabel.getText();

                if(vowelsCheckBox.isSelected()) {
                    result = result.replaceAll("[AEIOUaeiou]", "");
                }

                if(consonantsCheckBox.isSelected()) {
                    result = result.replaceAll("[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]", "");
                }

                if(numbersCheckBox.isSelected()) {
                    result = result.replaceAll("[0987654321]", "");
                }

                textLabel.setText(result);
            }
        });

        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText(original);
                vowelsCheckBox.setSelected(false);
                consonantsCheckBox.setSelected(false);
                numbersCheckBox.setSelected(false);
            }
        });
    }

    public static void main(String[] args) {
        new CharacterRemover();
    }
}
