package Controllers;

import Classes.Account;
import Classes.User;
import Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;


public class CreateNewAccount {
    CommonFunctions cf = new CommonFunctions();
    public static User user;
    public static Account Acc;
    @FXML
    private Button CA_CreateAccountButton;

    @FXML
    private TextField CA_EmailField;

    @FXML
    private TextField CA_NameField;

    @FXML
    private TextField CA_NationalIDField;

    @FXML
    private PasswordField CA_PasswordCheckField;

    @FXML
    private PasswordField CA_PasswordField;

    @FXML
    private TextField CA_PhoneField;
    @FXML
    private Button CA_backButton;

    ObservableList<String> items = FXCollections.observableArrayList(
            "Checking",
            "Saving"
    );
    @FXML
    private ComboBox<String> AccType = new ComboBox<>();




    @FXML
    void createNewAccount(ActionEvent event) {
        long startTime = System.nanoTime();

        int ID;
        if(CA_NameField.getText().isEmpty()){
            cf.alertMessage("Alert","Please Enter Your Name", Alert.AlertType.INFORMATION);
        }// not numbers

        else if (CA_EmailField.getText().isEmpty()){
            cf.alertMessage("Alert","Please Enter Your Email", Alert.AlertType.INFORMATION);
        }
        else if(CA_EmailField.getText().contains("@")){
            cf.alertMessage("Alert","Email format is incorrect", Alert.AlertType.INFORMATION);
        }
        else if (CA_NationalIDField.getText().isEmpty()){
            cf.alertMessage("Alert","Please Enter Your National ID", Alert.AlertType.INFORMATION);
        }
        else if (CA_PhoneField.getText().isEmpty()){
            cf.alertMessage("Alert","Please Enter Your Phone Number", Alert.AlertType.INFORMATION);
        }// not chars
        else if (CA_PasswordField.getText().isEmpty()){
            cf.alertMessage("Alert","Please Enter a Password", Alert.AlertType.INFORMATION);
        }
        else if ((CA_PasswordCheckField.getText().compareTo(CA_PasswordField.getText())) !=0){
            cf.alertMessage("Alert","Passwords don't match try again!", Alert.AlertType.INFORMATION);
        }
        else if (!isAlpha(CA_NameField.getText())) {
            cf.alertMessage("Alert","Name should only contains Alphabets!", Alert.AlertType.INFORMATION);
        }
        else if (isAlpha(CA_PhoneField.getText())) {
            cf.alertMessage("Alert","Phone number should not contain Alphabets!", Alert.AlertType.INFORMATION);
        }
        else{
            try {
                ID = Integer.parseInt(CA_NationalIDField.getText());
                user = new User(CA_NameField.getText(),CA_PasswordField.getText(),CA_PhoneField.getText(),CA_EmailField.getText(),ID);
                Acc = new Account(AccType.getValue(),0);//check how to make combo box for account type and add account
                user.addAccount(Acc);
                LoginController.user=user;
                LoginController.acc=Acc;
                cf.alertMessage("Success","Account Created Successfully", Alert.AlertType.CONFIRMATION);
                cf.buttonNavigation(event,"login.fxml");
                System.out.println(user);
                //CF.buttonNavigation(event,".fxml"); //main screen
            }
            catch (NumberFormatException e){
                cf.alertMessage("Alert","National ID should only be numbers", Alert.AlertType.INFORMATION);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Create New Account Elapsed Time: " + elapsedTimeMs + " milliseconds\n");

    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }


    @FXML
    void FillComboBox(MouseEvent event) {
        long startTime = System.nanoTime();

        AccType.setItems(items);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Fill Combo Box Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }
    @FXML
    void CA_back(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        cf.buttonNavigation(event,"login.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Back Button Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }
}