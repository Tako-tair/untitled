package sample;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.scene.traversal.TopMostTraversalEngine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import sample.Animation.Shake;

public class singUpController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button singInButton;

    @FXML
    private TextField singUpLocationHome;

    @FXML
    private TextField singUpSurname;

    @FXML
    private TextField singUpBankcard;

    @FXML
    private TextField singUpName;

    @FXML
    private TextField singUpPhoneNumber;

    @FXML
    private Button buttonBack;



    @FXML
    void initialize() {
        singInButton.setOnAction(actionEvent -> {
            singUpNewUser();
        });

        buttonBack.setOnAction(actionEvent -> {
            openNewScene("/sample/sample.fxml");
        });
    }

    private void singUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        String name = singUpName.getText();
        String surname = singUpSurname.getText();
        String login = loginField.getText();
        String password = passwordField.getText();
        String location = singUpLocationHome.getText();
        String bankCard = singUpBankcard.getText();
        String phoneNumber = singUpPhoneNumber.getText();

        User user = new User(name,surname,login,password,location,bankCard,phoneNumber);

        dbHandler.singUpUser(user);


    }

    public void openNewScene(String window){
        buttonBack.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
