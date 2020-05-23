package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Animation.Shake;

import javax.xml.crypto.Data;

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
    void backButton(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent SignIn = FXMLLoader.load(getClass().getResource("/sample/app1.fxml"));
        Scene scene2 = new Scene(SignIn);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    void initialize() {
        totalMoneylabel.setText(String.valueOf("Total money: "+calculator.getMoney()));

        endButton.setOnAction(actionEvent -> {
            if(!cardText.getText().equals("") && !cvsText.getText().equals("") && cardText.getText().length()==16 && cvsText.getText().length()==3) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                messageLabel.setText(" Your order is processed and will be delivered within 1 HOUR, total money - " + String.valueOf(calculator.getMoney()) + " Thank you for shopping)");
                cardText.clear();
                cvsText.clear();
            }else{
                Shake shake = new Shake(cardText);
                Shake shake1 = new Shake(cvsText);
                shake.playAnime();
                shake1.playAnime();
                cardText.setText("Write 16 number");
                cvsText.setText("Write 3 number");
                messageLabel.setText("Please fill in the ABOVE mentioned objects");
            }
        });

        listButton.setOnAction(actionEvent -> {
            listText.setText(calculator.getInfo());
        });

        removeButton.setOnAction(actionEvent -> {
           listText.setText(calculator.getRemove(removeText.getText()));
           totalMoneylabel.setText(calculator.geRemove(removeText.getText()));
           removeText.clear();
        });
    }
}

