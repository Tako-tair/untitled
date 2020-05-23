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

public class MilkApp {
     Calculator calculator = new Calculator();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button milkButton;

    @FXML
    private Button curdButton;

    @FXML
    private Button sourButton;

    @FXML
    private Button yogurtButton;

    @FXML
    private Button cheeseButton;

    @FXML
    private Button iceButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField curdText;

    @FXML
    private TextField sourText;

    @FXML
    private TextField uogurtText;

    @FXML
    private TextField cheeseText;

    @FXML
    private TextField iceText;

    @FXML
    private TextField milkText;

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

        milkButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(200, Integer.parseInt(milkText.getText()))));
            listLabel.setText(String.valueOf(calculator.getList("Milk" + " 200 "+ "litres " + milkText.getText() + "\n")));
            milkText.clear();
        });
        curdButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(700, Double.parseDouble(curdText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Curd" + " 700 " + "kilogram "+curdText.getText() + "\n")));
            curdText.clear();
        });
        sourButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(250, Integer.parseInt(sourText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Sour cream" + " 250 " + "count "+sourText.getText() + "\n")));
            sourText.clear();
        });
        yogurtButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(100, Integer.parseInt(uogurtText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Yogurt" + " 100 " + "count "+uogurtText.getText() + "\n")));
            uogurtText.clear();
        });
        cheeseButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(1500, Double.parseDouble(cheeseText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Cheese" + " 1500 " +  "kilogram "+cheeseText.getText() + "\n")));
            cheeseText.clear();
        });
        iceButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(250, Integer.parseInt(iceText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Ice cream" + " 250 " + "count "+iceText.getText() + "\n")));
            iceText.clear();
        });
    }
}