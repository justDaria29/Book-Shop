package view;

import controller.CalculatorController;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JPanel {

    JPanel panel1 = new JPanel();



    JButton buttonLogIn = new JButton("Log In");
    JButton buttonSignUp = new JButton("Sign Up");



    JFrame frame = new JFrame("Simple Calculator Demo");

    public CalculatorView(CalculatorController controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);


        buttonLogIn.addActionListener(e -> controller.logInButtonClicked());
        buttonSignUp.addActionListener(e -> controller.signUpButtonClicked());

        panel1.add(buttonLogIn);
        panel1.add(buttonSignUp);



        JPanel panel =  new JPanel();



        panel.add(panel1);


        frame.setContentPane(panel);


    }





    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
}
