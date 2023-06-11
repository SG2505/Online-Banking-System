package Controllers;

import Classes.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateAnotherAcc implements Initializable {
    CommonFunctions cf = new CommonFunctions();
    @FXML
    private ComboBox<String> AccTypeBox;

    ObservableList<String> items = FXCollections.observableArrayList(
            "Checking",
            "Saving"
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AccTypeBox.setItems(items);
        UserNameLabel.setText(LoginController.user.getName());


    }

    @FXML
    private Label ChooseAccLabel;

    @FXML
    private Button CreateAccButton;

    @FXML
    private TextField OpeningBalanceEntry;

    @FXML
    private Label OpeningBalanceLabel;

    @FXML
    private Label ScreenLabel;

    @FXML
    private Label UserNameLabel;

    @FXML
    void Create_Acc(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        int ID;
        if(OpeningBalanceEntry.getText().isEmpty())
        {
            cf.alertMessage("Alert","Please Enter Your Opening Balance", Alert.AlertType.INFORMATION);
        }
        try {
            ID = Integer.parseInt(OpeningBalanceEntry.getText());
            Account acc1 = new Account(AccTypeBox.getValue(), Double.parseDouble(OpeningBalanceEntry.getText()));
            LoginController.user.addAccount(acc1);
        }catch (NumberFormatException e){
            cf.alertMessage("Alert","Balance should only be numbers", Alert.AlertType.INFORMATION);
        }
        cf.buttonNavigation(event,"Homescreen.fxml");

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Create Account Elapsed Time: " + elapsedTimeMs + " milliseconds");
    }
    @FXML
    void GoHomescreen(ActionEvent event) throws IOException {
        cf.buttonNavigation(event,"Homescreen.fxml");
    }

}