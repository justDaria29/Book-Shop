package view;

import controller.PersonController;

import javax.swing.*;
import java.awt.*;

public class PersonView {
    JFrame frame = new JFrame("Add person demo");

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JLabel labelParam1 = new JLabel("Email: ");
    JTextField textFieldParam1 = new JTextField();


    JButton logInButton = new JButton("Log In");

    JButton showCustomersButton = new JButton("All Emails");

    PersonController personController;

    public PersonView(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);


        textFieldParam1.setPreferredSize(new Dimension(100, 20));


        panel1.add(labelParam1);
        panel1.add(textFieldParam1);

        logInButton.addActionListener(e -> personController.logIn());
        showCustomersButton.addActionListener(e -> personController.getCustomers());

        panel2.add(logInButton);
        panel2.add(showCustomersButton);

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


    public void showMessage(String message, int option){
        if( option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if(option ==1){
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public PersonController getPersonController() {
        return personController;
    }

    public void setPersonController(PersonController personController) {
        this.personController = personController;
    }
}
