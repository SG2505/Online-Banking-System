package Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Classes.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.util.Date;

public class TransactionsHistoryController implements Initializable{

    Account acc ;
    CommonFunctions cf = new CommonFunctions();
    @FXML
    private Button backButton;

    @FXML
    private GridPane GridPane;

    @FXML
    private HBox HorizontalBox;

    @FXML
    private TableView<Transaction> TableView = new TableView<Transaction>();
    @FXML
    private TableColumn<Transaction,Integer> TransactionID = new TableColumn<>("ID");
    @FXML
    private TableColumn<Transaction,String> type = new TableColumn<>("type");
    @FXML
    private TableColumn<Transaction,Double> amount = new TableColumn<>("amount");
    @FXML
    private TableColumn<Transaction,Date> date = new TableColumn<>("date");


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        TransactionID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        //load dummy data
        TableView.setItems(getTransactions());

        //Update the table to allow for the first and last name fields
        //to be editable
    }

    private ObservableList<Transaction> getTransactions() {
        ObservableList<Transaction> transactions = FXCollections.observableArrayList(LoginController.acc.getTransactions());


        return transactions;
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
    @FXML
    private VBox VBox;

}
