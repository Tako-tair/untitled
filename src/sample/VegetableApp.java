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

public class VegetableApp {
    Calculator calculator = new Calculator();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyLable;

    @FXML
    private Button cabbageButton;

    @FXML
    private Button cucumberButton;

    @FXML
    private Button tomatoButton;

    @FXML
    private Button bananaButton;

    @FXML
    private Button gradeButton;

    @FXML
    private Button appleButton;

    @FXML
    private Label listLabel;

    @FXML
    private TextField cucumberText;

    @FXML
    private TextField tomatoText;

    @FXML
    private TextField bananaText;

    @FXML
    private TextField gradeText;

    @FXML
    private TextField appleText;

    @FXML
    private TextField cabbageText;

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

        cabbageButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(300, Double.parseDouble(cabbageText.getText()))));
            listLabel.setText(String.valueOf(calculator.getList("Cabbages" + " 300 "+ "kilogram " + cabbageText.getText() + "\n")));
            cabbageText.clear();
        });
        cucumberButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(300, Double.parseDouble(cucumberText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Cucumbers" + " 300 " + "kilogram "+cucumberText.getText() + "\n")));
            cucumberText.clear();
        });
        tomatoButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(350, Double.parseDouble(tomatoText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Tomatoes" + " 350 " + "kilogram "+tomatoText.getText() + "\n")));
            tomatoText.clear();
        });
        bananaButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(120, Integer.parseInt(bananaText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Bananas" + "120 " + "count "+bananaText.getText() + "\n")));
            bananaText.clear();
        });
        gradeButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(1500, Double.parseDouble(gradeText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Grades" + " 1500 " +  "kilogram "+gradeText.getText() + "\n")));
            gradeText.clear();
        });
        appleButton.setOnAction(actionEvent -> {
            moneyLable.setText(valueOf(calculator.getSum(700, Double.parseDouble(appleText.getText()))));
            listLabel.setText(valueOf(calculator.getList("Apples" + " 700 " + "kilogram "+appleText.getText() + "\n")));
            appleText.clear();
        });
    }
}
