package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

import java.io.IOException;

public class CommonFunctions {
    private Stage stage;
    private Scene scene;
    void buttonNavigation(ActionEvent event, String fxmlScreenName) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/"+fxmlScreenName));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    boolean alertMessage(String title, String message, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();

        ButtonType result = alert.getResult();
        if(result == ButtonType.CANCEL)
            return false;
        return true;



    }
}
