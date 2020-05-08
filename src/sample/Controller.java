package sample;

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
    void initialize() {
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


        loginUpButton.setOnAction(actionEvent -> {
           openNewScene("/sample/singUp.fxml");
        });

    }

    private void loginUser(String loginText, String loginPassText) throws SQLException {
           DataBaseHandler dbHandler = new DataBaseHandler();
           User user = new User();
           user.setLogin(loginText);
           user.setPassword(loginPassText);
           ResultSet resultSet = dbHandler.getUser(user);

           int count = 0;
           try {
            while (resultSet.next()) {
                count++;
            }
        }catch(SQLException e){
               e.printStackTrace();
           }
            if (count >= 1) {
                openNewScene("/sample/app1.fxml");

            } else{
               Shake userLogAnime = new Shake( loginField);
               Shake userPasAnime = new Shake(passwordField);
               userLogAnime.playAnime();
               userPasAnime.playAnime();
           }
    }
    public void openNewScene(String window){
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
