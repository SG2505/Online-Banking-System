package Controllers;
import Classes.DummyDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PayBills implements Initializable {

    CommonFunctions cf = new CommonFunctions();
    ToggleGroup toggleGroup = new ToggleGroup();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String Balance = Double.toString(LoginController.acc.getBalance());
        BalanceLabel.setText("Balance: " + Balance);
        UserLabel.setText(LoginController.user.getName());

        ElectRadio.setToggleGroup(toggleGroup);
        WaterRadio.setToggleGroup(toggleGroup);
        PhoneRadio.setToggleGroup(toggleGroup);
        INternetRadio.setToggleGroup(toggleGroup);
        GasRadio.setToggleGroup(toggleGroup);
    }
    @FXML
    private Button BackButton;

    @FXML
    private RadioButton ElectRadio;

    @FXML
    private RadioButton GasRadio;

    @FXML
    private RadioButton INternetRadio;

    @FXML
    private Button PayBillButton;

    @FXML
    private RadioButton PhoneRadio;

    @FXML
    private Label UserLabel;
    @FXML
    private Label BalanceLabel;


    @FXML
    private RadioButton WaterRadio;

    @FXML
    private TextField invoiceNumberField;

    @FXML
    void GoHome(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        cf.buttonNavigation(event,"HomeScreen.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Back Button Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void PayBill(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        String text = invoiceNumberField.getText();
        try {
            int value = Integer.parseInt(text);
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                String selectedOption = selectedRadioButton.getText();
                if (DummyDB.getBill(selectedOption).getID() == value){
                    LoginController.acc.payBill(selectedOption);
                }
                else{
                    cf.alertMessage("Alert","Invoice number doesn't exist", Alert.AlertType.INFORMATION);
                    return;
                }

            }
            else{
                cf.alertMessage("Alert","Please select a bill to pay", Alert.AlertType.INFORMATION);
                return;
            }

        } catch (NumberFormatException e) {
            cf.alertMessage("Alert","Invoice field should only be numbers", Alert.AlertType.INFORMATION); //show error message here
        }
        String Bl = Double.toString(LoginController.acc.getBalance());
        BalanceLabel.setText("Balance: " + Bl);


        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Pay Bill Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
        cf.alertMessage("Alert","paid successfully", Alert.AlertType.INFORMATION);

    }

}
