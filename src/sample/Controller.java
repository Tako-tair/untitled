package sample;

import java.awt.event.ActionEvent;
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

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button singInButton;

    @FXML
    private Button loginUpButton;

    @FXML
    void loginUpButton(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent SignIn = FXMLLoader.load(getClass().getResource("singUp.fxml"));
        Scene scene2 = new Scene(SignIn);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void singInButton(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent SignIn = FXMLLoader.load(getClass().getResource("app1.fxml"));
        Scene scene2 = new Scene(SignIn);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void initialize() {
        loginUpButton.setOnAction(actionEvent -> {
            openNewScene("singUp.fxml");
        });
        singInButton.setOnAction(actionEvent -> {
            String loginText = loginField.getText().trim();
            String loginPassText = passwordField.getText().trim();

            if(!loginText.equals("") && !loginPassText.equals("")){
                try {
                    loginUser(loginText,loginPassText);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.err.println("Login and Password is empty");
            }
        });

    }

    private void loginUser(String loginText, String loginPassText) throws SQLException {
           DataBaseHandler dbHandler = new DataBaseHandler();
           User user = new User();
           user.setLogin(loginText);
           user.setPassword(loginPassText);
           ResultSet resultSet = dbHandler.getUser(user);
            if (user.getLogin()== loginText && user.getPassword()==loginPassText) {
                openNewScene("/sample/app1.fxml");
            } else{
               Shake userLogAnime = new Shake( loginField);
               Shake userPasAnime = new Shake(passwordField);
               userLogAnime.playAnime();
               userPasAnime.playAnime();
           }
    }

    public void openNewScene(String window){
        singInButton.getScene().getWindow().hide();
        loginUpButton.getScene().getWindow().hide();
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
        stage.showAndWait();
    }
}
