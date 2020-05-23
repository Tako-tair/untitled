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

public class FlourApp {
    Calculator calculator = new Calculator();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button flourButton;

    @FXML
    private Button vermicelliButton;

    @FXML
    private Button muesleButton;

    @FXML
    private Button fusilliButton;

    @FXML
    private Button pastaButton;

    @FXML
    private Button noodleButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField vermicelliText;

    @FXML
    private TextField muesleText;

    @FXML
    private TextField fusilliText;

    @FXML
    private TextField pastaText;

    @FXML
    private TextField noodlesText;

    @FXML
    private TextField flourText;

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

        flourButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(500, Double.parseDouble(flourText.getText()))));
            listLabel.setText(String.valueOf(calculator.getList("Flour" + " 500 "+ "kilogram " + flourText.getText() + "\n")));
            flourText.clear();
        });
        vermicelliButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(400, Double.parseDouble(vermicelliText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Vermicelli" + " 400 " + "kilogram "+vermicelliText.getText() + "\n")));
            vermicelliText.clear();
        });
        muesleButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(700, Double.parseDouble(muesleText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Muesle" + " 700 " + "kilogram "+muesleText.getText() + "\n")));
            muesleText.clear();
        });
        fusilliButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(350, Double.parseDouble(fusilliText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Fusilli" + "350 " + "kilogram "+fusilliText.getText() + "\n")));
            fusilliText.clear();
        });
        pastaButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(550, Double.parseDouble(pastaText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Pasta" + " 550 " +  "kilogram "+pastaText.getText() + "\n")));
            pastaText.clear();
        });
        noodleButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(350, Double.parseDouble(noodlesText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Noodles" + " 350 " + "kilogram "+noodlesText.getText() + "\n")));
            noodlesText.clear();
        });
    }
}
