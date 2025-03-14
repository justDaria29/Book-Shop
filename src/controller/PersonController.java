package controller;

import repository.PersonRepository;
import view.PersonView;
import controller.ProfileController;

public class PersonController {

    PersonView personView =  new PersonView();

    PersonRepository personRepository;
    public PersonController(){
        this.personRepository =  new PersonRepository();
        this.personView.setVisibility(true);
        this.personView.setPersonController(this);
    }

    public void getCustomers(){

        try {

            this.personRepository.getCostumers();
        }
        catch (Exception e){
            this.personView.showMessage("Input error!",0);
        }
    }
    public void logIn(){

        try {
            String email=this.personView.getParam1();
            //System.out.println(email);
            int customerId=this.personRepository.logIn(email);

            if(customerId!=0) {
                personView.setVisibility(false);
                ProfileController profileController = new ProfileController(customerId);
                profileController.categorySelected("All");
            }
        }
        catch (Exception e){
            this.personView.showMessage("Input error!",0);
        }
    }

}
