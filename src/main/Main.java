package main;

import controller.CalculatorController;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        CalculatorController calculatorController = new CalculatorController();
        CalculatorView calculatorView =  new CalculatorView(calculatorController);

        calculatorController.setView(calculatorView);
        calculatorView.setVisibility(true);
    }
}
