package CryptoTracker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Controller implements CryptoAPICaller{

    public String[] cryptoPrices = new String[]{"8939.27", "1397.20", "645.51", "151.70", "0.8727", "11.58"};

    public static final String urlstr ="https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,BCH,ETH,LTC,XRP,EOS&tsyms=USD";

    @FXML
    private Image bitcoinImg;

    @FXML
    private Image bitcoinCashImg;

    @FXML
    private Image rippleImg;

    @FXML
    private Image eosImg;

    @FXML
    private Image litecoinImg;

    @FXML
    private Image ethereumImg;

    @FXML
    private Label bitcoinValue;

    @FXML
    private Label bitcoinCashValue;

    @FXML
    private Label rippleValue;

    @FXML
    private Label eosValue;

    @FXML
    private Label litecoinValue;

    @FXML
    private Label ethereumValue;

    @FXML
    private Button bitcoinBtn;

    @FXML
    private Button bitcoinCashBtn;

    @FXML
    private Button rippleBtn;

    @FXML
    private Button eosBtn;

    @FXML
    private Button litecoinBtn;

    @FXML
    private Button ethereumBtn;

    public void initialize(){
        refreshValues();
    }

    @FXML
    public void refreshValues(){
        JSONObject values = callCryptoAPI();
        String[] prices = new String[6];
        if(values != null){ // Gets the costs from the JSONObject that the API responds with
            String[] currencies = new String[]{"BTC", "BCH", "ETH", "LTC", "XRP", "EOS"};
            for(int i=0; i<6; i++){
                JSONObject cur = (JSONObject) values.get(currencies[i]);
                String cost = cur.get("USD").toString();
                prices[i] = cost;
            }
        }
        else
            prices = cryptoPrices;

        bitcoinValue.setText("$ " + prices[0]);
        bitcoinCashValue.setText("$ " + prices[1]);
        ethereumValue.setText("$ " + prices[2]);
        litecoinValue.setText("$ " + prices[3]);
        rippleValue.setText("$ " + prices[4]);
        eosValue.setText("$ " + prices[5]);

        cryptoPrices = prices;
    }

    @Override
    public JSONObject callCryptoAPI() {
        try {
            URL url = new URL(urlstr);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("Code: " + responseCode);

            if(responseCode != 200){
                System.out.println("Invalid Response.");
                return null;
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            JSONParser jParser = new JSONParser();
            JSONObject responseObj = (JSONObject) jParser.parse(response.toString());
            return responseObj;
        }
        catch(MalformedURLException e) {
            System.out.println("Malformed API url.");
            return null;
        }
        catch(IOException io){
            System.out.println("IO Exception");
            return null;
        }
        catch(ParseException pe){
            System.out.println("Parse Exception");
            return null;
        }
    }

    @FXML
    public void bitcoinExchange() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConvertScene.fxml"));
            Parent root = loader.load();

            ConvertController convertC = loader.getController();
            convertC.setLeftImage(bitcoinImg);
            convertC.setLeftLabel("Bitcoin");
            convertC.setRightLabel("Dollars");
            convertC.leftCost = Double.parseDouble(cryptoPrices[0]);
            convertC.rightCost = 1.0;


            Scene convScene = new Scene(root, 400, 250);

            convertC.display("Bitcoin", convScene);
        }
        catch(IOException ioe){
            System.out.println("Caught an IO exception on loader.load()");
        }

    }

    @FXML
    public void bitcoinCashExchange() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConvertScene.fxml"));

            Parent root = loader.load();

            ConvertController convertC = loader.getController();
            convertC.setLeftImage(bitcoinCashImg);
            convertC.setLeftLabel("Bitcoin Cash");
            convertC.setRightLabel("Dollars");
            convertC.leftCost = Double.parseDouble(cryptoPrices[1]);
            convertC.rightCost = 1.0;


            Scene convScene = new Scene(root, 400, 250);

            convertC.display("Bitcoin Cash", convScene);
        }
        catch(IOException ioe){
            System.out.println("Caught an IO exception on loader.load()");
        }
    }

    @FXML
    public void ethereumExchange() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConvertScene.fxml"));
            Parent root = loader.load();

            ConvertController convertC = loader.getController();
            convertC.setLeftImage(ethereumImg);
            convertC.setLeftLabel("Ethereum");
            convertC.setRightLabel("Dollars");
            convertC.leftCost = Double.parseDouble(cryptoPrices[2]);
            convertC.rightCost = 1.0;


            Scene convScene = new Scene(root, 400, 250);

            convertC.display("Ethereum", convScene);
        }
        catch(IOException ioe){
            System.out.println("Caught an IO exception on loader.load()");
        }
    }

    @FXML
    public void litecoinExchange() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConvertScene.fxml"));
            Parent root = loader.load();

            ConvertController convertC = loader.getController();
            convertC.setLeftImage(litecoinImg);
            convertC.setLeftLabel("Litecoin");
            convertC.setRightLabel("Dollars");
            convertC.leftCost = Double.parseDouble(cryptoPrices[3]);
            convertC.rightCost = 1.0;

            Scene convScene = new Scene(root, 400, 250);

            convertC.display("Litecoin", convScene);
        }
        catch(IOException ioe){
            System.out.println("Caught an IO exception on loader.load()");
        }
    }

    @FXML
    public void rippleExchange() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConvertScene.fxml"));
            Parent root = loader.load();

            ConvertController convertC = loader.getController();
            convertC.setLeftImage(rippleImg);
            convertC.setLeftLabel("Ripple");
            convertC.setRightLabel("Dollars");
            convertC.leftCost = Double.parseDouble(cryptoPrices[4]);
            convertC.rightCost = 1.0;

            Scene convScene = new Scene(root, 400, 250);

            convertC.display("Ripple", convScene);
        }
        catch(IOException ioe){
            System.out.println("Caught an IO exception on loader.load()");
        }
    }

    @FXML
    public void eosExchange() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConvertScene.fxml"));

            Parent root = loader.load();

            ConvertController convertC = loader.getController();
            convertC.setLeftImage(eosImg);
            convertC.setLeftLabel("EOS");
            convertC.setRightLabel("Dollars");
            convertC.leftCost = Double.parseDouble(cryptoPrices[5]);
            convertC.rightCost = 1.0;

            Scene convScene = new Scene(root, 400, 250);

            convertC.display("EOS", convScene);
        }
        catch(IOException ioe){
            System.out.println("Caught an IO exception on loader.load()");
        }
    }
}
