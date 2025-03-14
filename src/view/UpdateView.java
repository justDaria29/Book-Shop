package view;

import controller.UpdateController;

import javax.swing.*;
import java.awt.*;

public class UpdateView {
    JFrame frame = new JFrame("Update");

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JLabel labelParam1 = new JLabel("Email: ");
    JTextField textFieldParam1 = new JTextField();

    JLabel labelParam2 = new JLabel("First name: ");
    JTextField textFieldParam2 = new JTextField();

    JLabel labelParam3 = new JLabel("Last name: ");
    JTextField textFieldParam3 = new JTextField();

    JLabel labelParam4 = new JLabel("Phone number: ");
    JTextField textFieldParam4 = new JTextField();

    JLabel labelParam5 = new JLabel("Address: ");
    JTextField textFieldParam5 = new JTextField();

    JButton updateButton = new JButton("Update");
    JButton goBackButton = new JButton("Go Back");



    UpdateController updateController;

    public UpdateView(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 300);


        textFieldParam1.setPreferredSize(new Dimension(100, 20));
        textFieldParam2.setPreferredSize(new Dimension(100, 20));
        textFieldParam3.setPreferredSize(new Dimension(100, 20));
        textFieldParam4.setPreferredSize(new Dimension(100, 20));
        textFieldParam5.setPreferredSize(new Dimension(100, 20));


        panel1.add(labelParam1);
        panel1.add(textFieldParam1);

        panel1.add(labelParam2);
        panel1.add(textFieldParam2);

        panel1.add(labelParam3);
        panel1.add(textFieldParam3);

        panel1.add(labelParam4);
        panel1.add(textFieldParam4);

        panel1.add(labelParam5);
        panel1.add(textFieldParam5);

        updateButton.addActionListener(e -> updateController.update());
        goBackButton.addActionListener(e -> updateController.goBack());
        panel2.add(updateButton);
        panel2.add(goBackButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);


        frame.setContentPane(panel);

    }

    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public String getParam1() {
        return textFieldParam1.getText();
    }

    public String getParam2() {
        return textFieldParam2.getText();
    }

    public String getParam3() {
        return textFieldParam3.getText();
    }

    public String getParam4() {
        return textFieldParam4.getText();
    }

    public String getParam5() {
        return textFieldParam5.getText();
    }

    public void showMessage(String message, int option){
        if( option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if(option ==1){
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public UpdateController getPersonController() {
        return updateController;
    }

    public void setUpdateController(UpdateController updateController) {
        this.updateController = updateController;
    }
}
