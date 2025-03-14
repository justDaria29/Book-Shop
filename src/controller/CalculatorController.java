package controller;

import view.CalculatorView;

public class CalculatorController {

    private CalculatorView view;

    public CalculatorView getView() {
        return view;
    }

    public void setView(CalculatorView view) {
        this.view = view;
    }

    public void logInButtonClicked() {
        view.setVisibility(false);
        PersonController personController = new PersonController();
    }
    public void signUpButtonClicked() {
        view.setVisibility(false);
        SignUpController signUpController = new SignUpController();
    }

}
