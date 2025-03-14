package controller;

import repository.SignUpRepository;
import view.CalculatorView;
import view.SignUpView;

public class SignUpController {

    SignUpView signUpView =  new SignUpView();

    SignUpRepository signUpRepository;
    public SignUpController(){
        this.signUpRepository =  new SignUpRepository();
        this.signUpView.setVisibility(true);
        this.signUpView.setSignUpController(this);
    }


    public void signUp(){

        try {
            String email=this.signUpView.getParam1();
            String firstName=this.signUpView.getParam2();
            String lastName=this.signUpView.getParam3();
            String phoneNo=this.signUpView.getParam4();
            String address=this.signUpView.getParam5();
            int customerId=this.signUpRepository.getNextIndex();
            this.signUpRepository.signUp(email, firstName, lastName, phoneNo, address, customerId);
            this.signUpRepository.getCostumers();
        }
        catch (Exception e){
            this.signUpView.showMessage("Input error!",0);
        }

    }
    public void goBack() {
        signUpView.setVisibility(false);

        CalculatorController calculatorController = new CalculatorController();
        CalculatorView calculatorView =  new CalculatorView(calculatorController);


        calculatorController.setView(calculatorView);
        calculatorView.setVisibility(true);
    }

}
