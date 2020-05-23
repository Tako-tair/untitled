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
import sample.Animation.Shake;

import static java.lang.String.*;

public class BreadApp {
 Calculator calculator = new Calculator();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button bread1BuyButton;

    @FXML
    private Button bread2BuyButton;

    @FXML
    private Button bread3BuyButton;

    @FXML
    private Button bread4BuyButton;

    @FXML
    private Button bread5BuyButton;

    @FXML
    private Button bread6BuyButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField bread1Text;

    @FXML
    private TextField bread2Text;

    @FXML
    private TextField bread3Text;

    @FXML
    private TextField bread4Text;

    @FXML
    private TextField bread5Text;

    @FXML
    private TextField bread6Text;

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

        bread1BuyButton.setOnAction(actionEvent -> {
                moneyLable.setText(valueOf(calculator.getSum(220, Integer.parseInt(bread1Text.getText()))));
                listLabel.setText(String.valueOf(calculator.getList("Bread for sandwiches" + " 220 "+ "count " + bread1Text.getText() + "\n")));
                bread1Text.clear();
        });
        bread2BuyButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(180, Integer. parseInt(bread2Text.getText()))));
            listLabel.setText(valueOf(calculator.getList("Medeu bread" + " 180 " + "count "+bread2Text.getText() + "\n")));
            bread2Text.clear();
        });
        bread3BuyButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(180, Integer. parseInt(bread3Text.getText()))));
            listLabel.setText(valueOf(calculator.getList("bread Aksay black" + " 180 " + "count "+bread3Text.getText() + "\n")));
            bread3Text.clear();
        });
        bread4BuyButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(210, Integer. parseInt(bread4Text.getText()))));
            listLabel.setText(valueOf(calculator.getList("bread Wallis" + " 210 " + "count "+bread4Text.getText() + "\n")));
            bread4Text.clear();
        });
        bread5BuyButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(145, Integer. parseInt(bread5Text.getText()))));
            listLabel.setText(valueOf(calculator.getList("baguette" + " 145 " +  "count "+bread5Text.getText() + "\n")));
            bread5Text.clear();
        });
        bread6BuyButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(130, Integer. parseInt(bread6Text.getText()))));
            listLabel.setText(valueOf(calculator.getList("bread Aksay classic" + " 130 " + "count "+bread6Text.getText() + "\n")));
            bread6Text.clear();
        });
    }
}
