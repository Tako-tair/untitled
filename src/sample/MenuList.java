package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuList {
  Calculator calculator =new Calculator();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label totalMoneylabel;

    @FXML
    public TextArea listText;

    @FXML
    private Button removeButton;

    @FXML
    private Button listButton;

    @FXML
    private TextField removeText;

    @FXML
    private TextField cardText;

    @FXML
    private TextField cvsText;

    @FXML
    private Label messageLabel;

    @FXML
    private Button endButton;

    @FXML
    private Button backButton;

    public static ArrayList<Order> s;
    public void ddd(ArrayList<Order> a){
        System.out.println( a);
        this.s=a;
    }

    @FXML
    void initialize() {

        listButton.setOnAction(actionEvent -> {
                PackageData pd = new PackageData("LIST");
                Main.connect(pd);
            });


            totalMoneylabel.setText(String.valueOf(s));


        endButton.setOnAction(actionEvent -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            messageLabel.setText("Thank you for your purchase, all products will be delivered to you in 1 hour)");
        });

        backButton.setOnAction(actionEvent -> {
            openNewScene("/sample/app1.fxml");
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
        stage.getScene().getWindow().hide();
        stage.hide();
    }
}

