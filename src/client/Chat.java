package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Chat {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    public TextArea messageTextArea;

    @FXML
    private TextField inputTextfield;

    @FXML
    private Button sendButton;

    @FXML
    private TextField nameField;

    @FXML
    private Label count;


    // адрес сервера
    private static final String SERVER_HOST = "localhost";
    // порт
    private static final int SERVER_PORT = 3443;
    // клиентский сокет
    private Socket clientSocket;
    // входящее сообщение
    private Scanner inMessage;
    // исходящее сообщение
    private PrintWriter outMessage;
    // имя клиента
    private String clientName = "";
    // получаем имя клиента
    public String getClientName() {
        return this.clientName;
    }

    @FXML
    void initialize() {
        try {
            // подключаемся к серверу
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendButton.setOnAction(actionEvent -> {
            if (!inputTextfield.getText().trim().isEmpty() && !nameField.getText().trim().isEmpty()) {
                clientName = nameField.getText();
                sendMsg();
                // фокус на текстовое поле с сообщением
                inputTextfield.requestFocus();
            }
            inputTextfield.clear();
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // бесконечный цикл
                    while (true) {
                                // если есть входящее сообщение
                                if (inMessage.hasNext()) {
                                    // считываем его
                                    String inMes = inMessage.nextLine();
                                    String clientsInChat = "Клиентов в чате = ";
                                    if (inMes.indexOf(clientsInChat) == 0) {
                                        count.setText(inMes);
                                    } else {
                                        // выводим сообщение
                                        messageTextArea.setText(inMes);
                                        // добавляем строку перехода
                                        messageTextArea.setText("\n");
                                    }
                                }
                            }
                } catch (Exception e) {
                }
            }
        }).start();
    }

    public void sendMsg() {
        // формируем сообщение для отправки на сервер
        String messageStr = nameField.getText() + ": " + inputTextfield.getText();
        // отправляем сообщение
        outMessage.println(messageStr);
        outMessage.flush();
        inputTextfield.setText("");
    }

    @FXML
    void buttomBack(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent SignIn = FXMLLoader.load(getClass().getResource("/sample/app1.fxml"));
        Scene scene2 = new Scene(SignIn);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
}
