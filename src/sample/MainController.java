package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class MainController {

    public Button buttonStayAtHome;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView breadButton;

    @FXML
    private ImageView meatButton;

    @FXML
    private ImageView flourButton;

    @FXML
    private ImageView milkButton;

    @FXML
    private ImageView candyButton;

    @FXML
    private ImageView vegetableButton;

    @FXML
    private ImageView saleButton;

    @FXML
    private ImageView cannedButton;

    @FXML
    private ImageView sodaButton;

    @FXML
    private Button administrationButton;

    @FXML
    private ImageView stayHomeButton;

    @FXML
    private Button buttonBread;

    @FXML
    private Button buttonMeat;

    @FXML
    private Button buttonFlour;

    @FXML
    private Button buttonCandy;

    @FXML
    private Button buttonCanned;

    @FXML
    private Button buttonSale;

    @FXML
    private Button buttonVegetable;

    @FXML
    private Button buttonSoda;

    @FXML
    private Button buttonMilk;

    @FXML
    private Button bStayAtHome;

    @FXML
    private Button lustButButton;

    @FXML
    public void initialize() {
        lustButButton.setOnAction(actionEvent -> {
            openNewScene("/sample/MenuList.fxml");
        });
        buttonBread.setOnAction(actionEvent -> {
            openNewScene("/sample/bread.fxml");
        });
        administrationButton.setOnAction(actionEvent -> {
            openNewScene("/sample/chat.fxml");
        });
        buttonStayAtHome.setOnAction(actionEvent -> {
            openNewScene("/sample/stayAtHome.fxml");
        });
    }

    public void openNewScene(String window){
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
