package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
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



import java.awt.*;
import java.io.IOException;

import Classes.*;
import static java.awt.Color.*;

public class LoginController {
    CommonFunctions cf = new CommonFunctions();
    private Stage stage;
    private Scene scene;

    public static Account acc;
    public static User user;

    DummyDB DB = new DummyDB();

    CommonFunctions CF = new CommonFunctions();

    @FXML
    private Label PasswordLabel;

    @FXML
    private TextField PasswordText;

    @FXML
    private Label UserLabel;

    @FXML
    private TextField UserText;

    @FXML
    private Button button_Login;
    @FXML
    private ImageView logoImageView;

    @FXML
    private Label login_create_account;
    User U1  = new User("mohamed", "123", "01115003772", "h@gmail.com",77);
    Account Acc1  = new Account("Checking", 134134);
    Account Acc2  = new Account("Savings", 600);

    public LoginController(){

        logoImageView = new ImageView();
        Image img  = new Image("./Images/logo1.png");
        logoImageView.setImage(img);


    }
    @FXML
    void Login(ActionEvent event) throws IOException {
        long startTime = System.nanoTime();
        // check 3la en el text field not empty w
        U1.addAccount(Acc1);
        U1.addAccount(Acc2);

        if (UserText.getText().isEmpty()){
            cf.alertMessage("Email field is empty","Please enter your email",Alert.AlertType.INFORMATION);
            return;
        } else if (PasswordText.getText().isEmpty()) {
            cf.alertMessage("Password field is empty","Please enter your password",Alert.AlertType.INFORMATION);
            return;
        }

        String email= UserText.getText();
        user=DummyDB.getSingleUser(email);
        if (user == null){
            cf.alertMessage("Alert","User is not found", Alert.AlertType.INFORMATION);
            System.out.println("error");
        } else if ((user.getPassword().compareTo(PasswordText.getText()))!=0) {
            cf.alertMessage("Email and Password don't match","Email and Password don't match please try again",Alert.AlertType.ERROR);
            return;
        } else{
            acc=user.getAccountindex(0);
            CF.buttonNavigation(event,"Homescreen.fxml"); //main screen
        }

        Acc1.Deposit(25);
        Acc2.Deposit(25);
        System.out.println(Acc1.getTransactions());
        System.out.println(Acc2.Deposit(25));

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Login Elapsed Time: " + elapsedTimeMs + " milliseconds\n");
    }

    @FXML
    void ChangeLabelCss(MouseEvent event) {

        String hoverColor = "rgb(0, 123, 255)";// RGB values for light blue
        login_create_account.setStyle("-fx-text-fill: " + hoverColor + "; -fx-underline: true; -fx-cursor: hand;");

    }

    @FXML
    void ReturnCss(MouseEvent event) {
        String hoverColor = "rgb(53, 103, 156)"; // RGB values for light blue
        login_create_account.setStyle("-fx-text-fill: " + hoverColor + "; -fx-underline: false; -fx-cursor: default;");
    }
    @FXML
    void navigateToCreateNewAccount(MouseEvent event) throws IOException {
        long startTime = System.nanoTime();

        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/CreateNewAccount.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeMs = elapsedTime / 1_000_000.0;
        System.out.println("Navigate to Create Account Elapsed Time: " + elapsedTimeMs + " milliseconds\n");

    }
}
