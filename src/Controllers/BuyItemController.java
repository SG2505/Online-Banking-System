package Controllers;
import Classes.DummyDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyItemController implements Initializable {



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String Balance = Double.toString(LoginController.acc.getBalance());
        BalanceLabel.setText(BalanceLabel.getText() + " " + Balance);
        UsernameLabel.setText(LoginController.user.getName());
    }

    CommonFunctions cf = new CommonFunctions();
    @FXML
    private Label BalanceAmountLabel;

    @FXML
    private Button BackButton;

    @FXML
    private Label BalanceLabel;

    @FXML
    private Label BuyItemLabel;

    @FXML
    private TextField OrderNumberEntry;

    @FXML
    private Label OrderNumberLabel;

    @FXML
    private Label UsernameLabel;

    @FXML
    void GoHome(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();

        cf.buttonNavigation(event,"HomeScreen.fxml");

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Back Button Elapsed Time: " + elapsedTimeMs + " milliseconds");
    }

    @FXML
    void Buy_Button(ActionEvent event) {
        long startTime = System.nanoTime();
        int ID;
        if(OrderNumberEntry.getText().isEmpty())
        {
            cf.alertMessage("Alert","Please Enter Your Order Number", Alert.AlertType.INFORMATION);
        }


        try {
            int value = Integer.parseInt(OrderNumberEntry.getText());

            if (DummyDB.getItem(value) == null){
                cf.alertMessage("Order doesn't exist","Order doesnt exist please enter a correct order number", Alert.AlertType.ERROR);
                return;
            }

            //check if balance is sufficient to purchase item
            if (LoginController.acc.getBalance() < DummyDB.getItem(value).getPrice()){
                cf.alertMessage("Not enough balance","No enough balance in account", Alert.AlertType.ERROR);
                return;
            }

            LoginController.acc.buyItem(value);
            String Bl = Double.toString(LoginController.acc.getBalance());
            BalanceLabel.setText("Balance: " + Bl);
        } catch (NumberFormatException e) {
            cf.alertMessage("Alert","Enter a valid Order Number", Alert.AlertType.INFORMATION);
        }



        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Buy Elapsed Time: " + elapsedTimeMs + " milliseconds");
        cf.alertMessage("Alert","paid successfully", Alert.AlertType.INFORMATION);
    }

}