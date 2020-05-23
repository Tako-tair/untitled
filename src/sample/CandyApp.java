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

public class CandyApp {
    Calculator calculator = new Calculator();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button cookiesButton;

    @FXML
    private Button chocolateButton;

    @FXML
    private Button potatesButton;

    @FXML
    private Button doughnutsButton;

    @FXML
    private Button chupButton;

    @FXML
    private Button candyButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField chocolateText;

    @FXML
    private TextField potatesText;

    @FXML
    private TextField doughnutsText;

    @FXML
    private TextField chupText;

    @FXML
    private TextField candyText;

    @FXML
    private TextField cookiesText;


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

        cookiesButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(500, Double.parseDouble(cookiesText.getText()))));
            listLabel.setText(String.valueOf(calculator.getList("Cookies" + " 500 "+ "kilogram " + cookiesText.getText() + "\n")));
            cookiesText.clear();
        });
        chocolateButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(400, Integer.parseInt(chocolateText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Chocolate" + " 400 " + "count "+chocolateText.getText() + "\n")));
            chocolateText.clear();
        });
        potatesButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(700, Integer.parseInt(potatesText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Chocolate potato" + " 700 " + "count "+potatesText.getText() + "\n")));
            potatesText.clear();
        });
        doughnutsButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(350, Integer.parseInt(doughnutsText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Doughnuts" + " 350 " + "count "+doughnutsText.getText() + "\n")));
            doughnutsText.clear();
        });
        chupButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(550, Integer.parseInt(chupText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Chupa chups" + " 5500 " +  "count "+chupText.getText() + "\n")));
            chupText.clear();
        });
        candyButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(350, Double.parseDouble(candyText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Candy" + " 350 " + "kilogram "+candyText.getText() + "\n")));
            candyText.clear();
        });
    }
}