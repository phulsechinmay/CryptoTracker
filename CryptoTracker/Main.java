package CryptoTracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("CryptoTracker");
        Scene mainScene = new Scene(root, 600, 500);
        primaryStage.setScene(mainScene);
        Label bitcoinValue = (Label)loader.getNamespace().get("bitcoinValue");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
