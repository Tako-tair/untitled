package sample;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

public class SaleApp {
    CalculatorSale calculator = new CalculatorSale();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button champagneButton;

    @FXML
    private Button cakeButton;

    @FXML
    private Button medicalButton;

    @FXML
    private Button mushroomButton;

    @FXML
    private Button premiumButton;

    @FXML
    private Button chipButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField cakeText;

    @FXML
    private TextField medicalText;

    @FXML
    private TextField mushroomText;

    @FXML
    private TextField premiumText;

    @FXML
    private TextField chipText;

    @FXML
    private TextField champagneText;

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

        champagneButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSumm(3000, Integer.parseInt(champagneText.getText()))));
            listLabel.setText(String.valueOf(calculator.getList("Champagne" + " 3000 "+ "count " + champagneText.getText() + ": -10% SALE = " + Double.parseDouble(champagneText.getText()) * 3000 / 10 + "\n")));
            champagneText.clear();
        });
        cakeButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSumm(3000, Integer.parseInt(cakeText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Cake" + " 3000 " + "count "+cakeText.getText()  + ": -10% SALE = " + Double.parseDouble(cakeText.getText()) * 3000 / 10 + "\n")));
            cakeText.clear();
        });
        medicalButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSumm(500, Integer.parseInt(medicalText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Medical mask" + " 500 " + "count "+medicalText.getText()  + ": -10% SALE = " + Double.parseDouble(medicalText.getText()) * 500 / 10 + "\n")));
            medicalText.clear();
        });
        mushroomButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSumm(1200, Double.parseDouble(mushroomText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Mushrooms" + "1200 " + "kilogram "+mushroomText.getText() + ": -10% SALE = " + Double.parseDouble(mushroomText.getText()) * 1200 / 10 + "\n")));
            mushroomText.clear();
        });
        premiumButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSumm(3500, Double.parseDouble(premiumText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Premium fruit" + " 3500 " +  "kilogram "+premiumText.getText() + ": -10% SALE = " + Double.parseDouble(premiumText.getText())* 3500 / 10 + "\n")));
            premiumText.clear();
        });
        chipButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSumm(500, Integer.parseInt(chipText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Chips" + " 500 " + "count "+chipText.getText() + ": -10% SALE = " + Double.parseDouble(chipText.getText()) * 500 / 10 + "\n")));
            chipText.clear();
        });
    }
}
