package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.Server;

import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("My first application");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
       Abstract2 abstract2 = new Abstract2("Tair","Ospanov");
        Abstract all[] = {abstract2};
        for (int i = 0; i < all.length; i++) {
            all[i].getInfo();
            all[i].getInfo2();
        }

        CalculatorSale calculatorSale = new CalculatorSale();
        calculatorSale.info();
        calculatorSale.all();
        calculatorSale.info2();

        FThread f= new FThread();
        f.start();
        launch(args);

    }

    public static class FThread extends Thread{
        @Override
        public void run() {
            try {
                Server s = new Server();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
