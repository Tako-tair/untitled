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

public class MeatApp {
    Calculator calculator = new Calculator();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button kebabButton;

    @FXML
    private Button fishButton;

    @FXML
    private Button chickenButton;

    @FXML
    private Button sausageButton;

    @FXML
    private Button beconButton;

    @FXML
    private Button meatButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField fiahText;

    @FXML
    private TextField chickenText;

    @FXML
    private TextField sausageText;

    @FXML
    private TextField beconText;

    @FXML
    private TextField meatText;

    @FXML
    private TextField kebabText;


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

        kebabButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(1100, Double.parseDouble(kebabText.getText()))));
            listLabel.setText(String.valueOf(calculator.getList("Kebab" + " 1100 "+ "kilogram " + kebabText.getText() + "\n")));
            kebabText.clear();
        });
        fishButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(500, Double.parseDouble(fiahText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Fish" + " 500 " + "kilogram "+fiahText.getText() + "\n")));
            fiahText.clear();
        });
        chickenButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(1200, Double.parseDouble(chickenText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Chicken" + " 1200 " + "kilogram "+chickenText.getText() + "\n")));
            chickenText.clear();
        });
        sausageButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(2200, Double.parseDouble(sausageText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Sausage" + " 2200 " + "kilogram "+sausageText.getText() + "\n")));
            sausageText.clear();
        });
        beconButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(2000, Double.parseDouble(beconText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Becon" + " 200 " +  "kilogram "+beconText.getText() + "\n")));
            beconText.clear();
        });
        meatButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(2500, Double.parseDouble(meatText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Meat" + " 2500 " + "kilogram "+meatText.getText() + "\n")));
            meatText.clear();
        });
    }
}
