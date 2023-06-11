package Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeScreenController implements Initializable {



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String Balance = Double.toString(LoginController.acc.getBalance());
        B.setText(B.getText() + " " + Balance);
        UsernameLabel.setText(LoginController.user.getName());
        Switch_Acc.setItems(FXCollections.observableArrayList(getArrayAsStrings()));

    }



    @FXML
    private Button AnotherAccButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Label ProfileLabel;

    @FXML
    private ImageView ProfileImageView;

    @FXML
    private Label B;

    @FXML
    private HBox BalanceLabel;

    @FXML
    private Button BillsButton;

    @FXML
    private Button ItemsButton;

    @FXML
    private ComboBox<String> Switch_Acc =  new ComboBox<>();

    @FXML
    private Button TranButton;

    @FXML
    private Button TranHistButton;

    @FXML
    private ImageView TransactionImageView;

    @FXML
    private Label UsernameLabel;

    @FXML
    private Label WelcomeLabel;

    @FXML
    private ImageView billsImageView;

    @FXML
    private ImageView buyItemsImageView;
    @FXML
    private Button LogoutButton;




    CommonFunctions CF = new CommonFunctions();


    @FXML
    void Buy_Items(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        CF.buttonNavigation(event,"BuyItem.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Buy Items Button Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void Create_Another_Acc(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        CF.buttonNavigation(event,"CreateAnotherAcc.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Create Another Account Button Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }


    private String[] getArrayAsStrings() {
        int intArray [] = LoginController.user.getAccountsIDs();
        String[] stringArray = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            stringArray[i] = String.valueOf(intArray[i]);
        }
        return stringArray;
    }

    @FXML
    void Pay_Bills(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        CF.buttonNavigation(event,"PayBill.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Pay Bills Button Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void Show_History(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        CF.buttonNavigation(event,"TableView.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Show History Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void Transactions(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        CF.buttonNavigation(event,"TransactionScene.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Transactions Button Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void switchAccOn(ActionEvent event) {
        long startTime = System.nanoTime();

        String selectedValue = Switch_Acc.getSelectionModel().getSelectedItem();
        // Call your function with the selected value

        int AccID = Integer.parseInt(selectedValue);
        LoginController.acc = LoginController.user.getAccount(AccID);
        String Bl = Double.toString(LoginController.acc.getBalance());
        B.setText("Balance: $" + Bl);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Switch Account Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void GoProfile(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        CF.buttonNavigation(event,"ProfileScreen.fxml");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Profile Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }
    @FXML
    void GoLogin(ActionEvent event) throws IOException {
        if(CF.alertMessage("Question","Are you sure you want to logout?", Alert.AlertType.CONFIRMATION))
            CF.buttonNavigation(event,"login.fxml");
    }
}


