package Controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileScreen implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AccNumberLabel2.setText(String.valueOf(LoginController.acc.getID()));
        UserLabel2.setText((LoginController.user.getName()));
        EmailLabel2.setText(LoginController.user.getEmailAddress());
        NationalIdLabel2.setText(String.valueOf(LoginController.user.getNationalID()));
        PhoneLabel2.setText(LoginController.user.getPhoneNumber());
        AccTypeLabel2.setText(LoginController.acc.getType());
        BalanceLabel2.setText(String.valueOf(LoginController.acc.getBalance()));
    }
    CommonFunctions cf = new CommonFunctions();

    @FXML
    private Label AccNumberLabel;

    @FXML
    private Label AccNumberLabel2;

    @FXML
    private Label AccTypeLabel;

    @FXML
    private Label AccTypeLabel2;

    @FXML
    private Button BackButton;

    @FXML
    private Label BalanceLabel;

    @FXML
    private Label BalanceLabel2;

    @FXML
    private Button DeleteAccount;

    @FXML
    private Label EmailLabel;

    @FXML
    private Label EmailLabel2;

    @FXML
    private Label NationalIdLabel;

    @FXML
    private Label NationalIdLabel2;

    @FXML
    private Label PhoneLabel;

    @FXML
    private Label PhoneLabel2;

    @FXML
    private ImageView ProfileImage;

    @FXML
    private Label UserLabel;

    @FXML
    private Label UserLabel2;

    @FXML
    void Delete_UserAcc(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        LoginController.acc=null;
        if(!cf.alertMessage("Question","Are you sure you want to delete the account?", Alert.AlertType.CONFIRMATION))
            return;
        cf.alertMessage("Success", "Account Deleted Successfully", Alert.AlertType.CONFIRMATION);
        cf.buttonNavigation(event,"login.fxml");

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Delete User Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void GoHome(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();

        cf.buttonNavigation(event,"HomeScreen.fxml");

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Back Button Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

}

