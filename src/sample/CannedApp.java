package sample;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static java.lang.String.valueOf;

public class CannedApp {
    Calculator calculator = new Calculator();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button beefButton;

    @FXML
    private Button tomatoButton;

    @FXML
    private Button mackerelButton;

    @FXML
    private Button tunaButton;

    @FXML
    private Button sardinesButton;

    @FXML
    private Button spratButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField tomatoText;

    @FXML
    private TextField mackerelText;

    @FXML
    private TextField tunaText;

    @FXML
    private TextField sardinesText;

    @FXML
    private TextField spratText;

    @FXML
    private TextField beefText;

    @FXML
    void backButton(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent SignIn = FXMLLoader.load(getClass().getResource("/sample/app1.fxml"));
        Scene scene2 = new Scene(SignIn);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void initialize() {
        moneyLable.setText(String.valueOf(calculator.getMoney()));
        listLabel.setText(String.valueOf(calculator.getInfo()));

        beefButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(500, Integer.parseInt(beefText.getText()))));
            listLabel.setText(String.valueOf(calculator.getList("Beef conservation" + " 500 "+ "count " + beefText.getText() + "\n")));
            beefText.clear();
        });
        tomatoButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(600, Integer.parseInt(tomatoText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Tomato conservation" + " 600 " + "count "+tomatoText.getText() + "\n")));
            tomatoText.clear();
        });
        mackerelButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(450, Integer.parseInt(mackerelText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Mackerel conservation" + " 450 " + "count "+mackerelText.getText() + "\n")));
            mackerelText.clear();
        });
        tunaButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(850, Integer.parseInt(tunaText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Tuna conservation" + " 850 " + "count "+tunaText.getText() + "\n")));
            tunaText.clear();
        });
        sardinesButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(650, Integer.parseInt(sardinesText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Sardines conservation" + " 650 " +  "count "+sardinesText.getText() + "\n")));
            sardinesText.clear();
        });
        spratButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(450, Integer.parseInt(spratText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Sprat conservation" + " 450 " + "count "+spratText.getText() + "\n")));
            spratText.clear();
        });
    }
}