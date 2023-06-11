package Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import Classes.Account;
import Classes.User;
import Classes.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {

    CommonFunctions cf = new CommonFunctions();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String Balance = Double.toString(LoginController.acc.getBalance());
        Logo1.setText(Logo1.getText() + " " + Balance);
        UserLabel.setText(LoginController.user.getName());
    }

    @FXML
    private TextField AccNumber;

    @FXML
    private Label AccountLabel;

    @FXML
    private Label AmountLabel;

    @FXML
    private TextField AmountNumber;

    @FXML
    private Button Button1;

    @FXML
    private Button DepositButton;

    @FXML
    private Label Logo;

    @FXML
    private Label Logo1;

    @FXML
    private Button MoneyTransferButton;

    @FXML
    private Label TransactionsLabel;

    @FXML
    private Label UserLabel;

    @FXML
    private Button WithdrawButton;
    /*transactions: check empty, check enough balance(withdraw), not -ve or 0,
    check current acc no not the same as transfer acc
    message boxes for transactions, success /fail
    after message reset fields, hide acc no and transfer money*/
    @FXML
    void DepositFunc(MouseEvent event) {
        long startTime = System.nanoTime();
        String text = AmountNumber.getText();
        try {
            double balance = LoginController.acc.getBalance();
            double value = Double.parseDouble(text);

            if(value <= 0){
                cf.alertMessage("Alert","Please enter a reliable amount.", Alert.AlertType.INFORMATION);
                return;
            }

            LoginController.acc.Deposit(value);
            String Bl = Double.toString(LoginController.acc.getBalance());
            Logo1.setText("Balance: " + Bl);
            cf.alertMessage("Notification","Amount Deposited Successfully.", Alert.AlertType.INFORMATION);
            AccNumber.clear();
            AmountNumber.clear();

        } catch (NumberFormatException e) {
            cf.alertMessage("Alert","Amount field should only be numbers and Should not be empty.", Alert.AlertType.INFORMATION);
        }



        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Deposit Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void MoneyTransferFunc(MouseEvent event) {
        long startTime = System.nanoTime();

        String text = AmountNumber.getText();
        String text2 = AccNumber.getText();
        try {// e3ml el check 3la acc number
            double balance = LoginController.acc.getBalance();
            double value = Double.parseDouble(text);
            int AccNo = Integer.parseInt(text2);

            if(value > balance){
                cf.alertMessage("Alert","Not Enough Balance.", Alert.AlertType.INFORMATION);
                return;
            }

            if(value <= 0){
                cf.alertMessage("Alert","Please enter a reliable amount.", Alert.AlertType.INFORMATION);
                return;
            }

            if(AccNo == LoginController.acc.getID())
            {
                cf.alertMessage("Alert","You can't transfer Money to the same account.", Alert.AlertType.INFORMATION);
                return;
            }

            LoginController.acc.transferMoney(AccNo,value);
            String Bl = Double.toString(LoginController.acc.getBalance());
            Logo1.setText("Balance: " + Bl);
            cf.alertMessage("Notification","Amount Transferred Successfully.", Alert.AlertType.INFORMATION);
            AccNumber.clear();
            AmountNumber.clear();

        } catch (NumberFormatException e) {
            cf.alertMessage("Alert","Amount and Account fields should only be numbers", Alert.AlertType.INFORMATION);
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Money Transfer Elapsed Time: " + elapsedTimeMs + " milliseconds\n");

    }

    @FXML
    void WithdrawFunc(MouseEvent event) {
        long startTime = System.nanoTime();

        String text = AmountNumber.getText();
        try {
            double balance = LoginController.acc.getBalance();
            double value = Double.parseDouble(text);

            if(value > balance){
                cf.alertMessage("Alert","Not Enough Balance.", Alert.AlertType.INFORMATION);
                return;
            }

            if(value <= 0){
                cf.alertMessage("Alert","Please enter a reliable amount.", Alert.AlertType.INFORMATION);
                return;
            }

            LoginController.acc.withDraw(value);
            String Bl = Double.toString(LoginController.acc.getBalance());
            Logo1.setText("Balance: " + Bl);
            cf.alertMessage("Notification","Amount Withdrawn Successfully.", Alert.AlertType.INFORMATION);
            AccNumber.clear();
            AmountNumber.clear();
        } catch (NumberFormatException e) {
            cf.alertMessage("Alert","Amount field should only be numbers", Alert.AlertType.INFORMATION);
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Withdraw Elapsed Time: " + elapsedTimeMs + " milliseconds\n");

    }
    @FXML
    void goToHome(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        cf.buttonNavigation(event,"Homescreen.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Back Button Elapsed Time: " + elapsedTimeMs + " milliseconds\n");


    }

}
