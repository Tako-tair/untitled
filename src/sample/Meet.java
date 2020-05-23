package sample;


import java.io.*;
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
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class Meet {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Label moneyLable;

    @FXML
    private Label listLabel;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea areaField;

    @FXML
    private TextField poka;

    Calculator calculator = new Calculator();

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
        moneyLable.setText("Total money: " + calculator.getMoney());
        listLabel.setText(calculator.getInfo());

        sendButton.setOnAction(actionEvent -> {
            ArrayList<nameSurname> list = new ArrayList<>();
            nameSurname nameSurname = new nameSurname(poka.getText());
            list.add(nameSurname);
           saveMess(list);
           ArrayList<sample.nameSurname> mess = getMess();
           areaField.setText("Dear client: " + " " +mess + "\n" +  " Thanks too for your shopping");
           poka.clear();

            moneyLable.setText(("Total money: "+calculator.getMoney()));
            listLabel.setText(calculator.getInfo());
        });
    }

    public static void saveMess(ArrayList<nameSurname> st) {
        try{
            BufferedWriter output = new BufferedWriter(new FileWriter("memory.txt"));
            StringBuilder s = new StringBuilder();
            for (nameSurname value : st) {
                s.append(value).append("\n");
            }
            output.write(s.toString());
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<nameSurname> getMess() {
        ArrayList<nameSurname> users = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader("memory.txt"));
            String s = "";
            while ((s = input.readLine()) != null) {
                String[] words = s.split(" ");
                nameSurname nameSurname = new nameSurname(words[0]) ;
                users.add(nameSurname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
