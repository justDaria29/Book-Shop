package controller;

import repository.UpdateRepository;
import view.CalculatorView;
import repository.Customer;
import view.UpdateView;

public class UpdateController {
int customerId=0;
    UpdateView updateView =  new UpdateView();

    UpdateRepository updateRepository;
    public UpdateController(int customerid){
        this.customerId=customerid;
        this.updateRepository =  new UpdateRepository();
        this.updateView.setVisibility(true);
        this.updateView.setUpdateController(this);
    }


    public void update(){

        try {
            System.out.println("\nBEFORE UPDATE:\n");
            Customer customer=this.updateRepository.getCostumer(customerId);

            String email=this.updateView.getParam1();
            if(email.isBlank())email=customer.getEmail();

            String firstName=this.updateView.getParam2();
            if(firstName.isBlank())firstName=customer.getFirstName();

            String lastName=this.updateView.getParam3();
            if(lastName.isBlank())lastName=customer.getLastName();

            String phoneNo=this.updateView.getParam4();
            if(phoneNo.isBlank())phoneNo=customer.getPhoneNo();

            String address=this.updateView.getParam5();
            if(address.isBlank())address=customer.getAddress();

            this.updateRepository.update(email, firstName, lastName, phoneNo, address, customerId);
            System.out.println("\nAFTER UPDATE:\n");
            this.updateRepository.getCostumer(customerId);
        }
        catch (Exception e){
            this.updateView.showMessage("Input error!",0);
        }

    }
    public void goBack() {
        updateView.setVisibility(false);

        ProfileController profileController = new ProfileController(customerId);
    }

}
