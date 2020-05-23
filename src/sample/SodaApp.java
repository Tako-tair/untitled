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

public class SodaApp {
    Calculator calculator = new Calculator();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button lemonButton;

    @FXML
    private Button teaButton;

    @FXML
    private Button colaButton;

    @FXML
    private Button pepsiButton;

    @FXML
    private Button fantaButton;

    @FXML
    private Button coffeeButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField teaText;

    @FXML
    private TextField colaText;

    @FXML
    private TextField pepsiText;

    @FXML
    private TextField fantaText;

    @FXML
    private TextField coffeeText;

    @FXML
    private TextField lemonText;

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

        lemonButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(400, Integer.parseInt(lemonText.getText()))));
            listLabel.setText(String.valueOf(calculator.getList("Lemon drink" + " 400 "+ "count " + lemonText.getText() + "\n")));
            lemonText.clear();
        });
        teaButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(280, Integer.parseInt(teaText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Tea drink" + " 280 " + "count "+teaText.getText() + "\n")));
            teaText.clear();
        });
        colaButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(350, Integer.parseInt(colaText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Coca-cola" + " 350 " + "count "+colaText.getText() + "\n")));
            colaText.clear();
        });
        pepsiButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(320, Integer.parseInt(pepsiText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Pepsi" + "320 " + "count "+pepsiText.getText() + "\n")));
            pepsiText.clear();
        });
        fantaButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(350, Integer.parseInt(fantaText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Fanta" + " 350 " +  "count "+fantaText.getText() + "\n")));
            fantaText.clear();
        });
        coffeeButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(1500, Integer.parseInt(coffeeText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Coffee" + " 1500 " + "count "+coffeeText.getText() + "\n")));
            coffeeText.clear();
        });
    }
}
