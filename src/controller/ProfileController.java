package controller;

import model.BookModel;
import repository.ProfileRepository;
import view.CalculatorView;
import view.ProfileView;

import java.util.List;

public class ProfileController{
int customerId=0;
    ProfileView profileView =  new ProfileView();
BookModel bookModel=new BookModel();
    ProfileRepository profileRepository;
    public ProfileController(int customerid){
        this.customerId=customerid;
        this.profileRepository =  new ProfileRepository();
        this.profileView.setVisibility(true);
        this.profileView.setProfileController(this);
    }


    public void delete(){

        try {
            boolean successfullyDeleted=this.profileRepository.delete(customerId);
            if(successfullyDeleted){
                this.profileView.showMessage("Successfully deleted",1);
                profileView.setVisibility(false);

                CalculatorController calculatorController = new CalculatorController();
                CalculatorView calculatorView =  new CalculatorView(calculatorController);


                calculatorController.setView(calculatorView);
                calculatorView.setVisibility(true);
                profileRepository.getCostumers();
            }else  this.profileView.showMessage("Not successful",0);
        }
        catch (Exception e){
            this.profileView.showMessage("Input error!",0);
        }

    }
    public void update() {
        profileView.setVisibility(false);
        UpdateController updateController = new UpdateController(customerId);
    }

    public void categorySelected(String category){

        try {
            List<BookModel> books= profileRepository.getData(category);
            profileView.displayData(books);
        }
        catch (Exception e){

            this.profileView.showMessage("Input error!",0);

        }
    }

    public void searchButtonClicked(){
        try {
            List<BookModel> books= profileRepository.getData(profileView.getCategory());
            profileView.displayData(books, profileView.getSearchText());
        }
        catch (Exception e){

            this.profileView.showMessage("Input error!",0);

        }
    }

    public void logOut() {
        profileView.setVisibility(false);
        CalculatorController calculatorController = new CalculatorController();
        CalculatorView calculatorView =  new CalculatorView(calculatorController);

        calculatorController.setView(calculatorView);
        calculatorView.setVisibility(true);
    }

    public int getStockAmount(String title){
        int amount=0;
        try {
            amount=profileRepository.getStockAmount(title);

        }
        catch (Exception e){

            this.profileView.showMessage("Input error!",0);

        }
        return amount;
    }
}
