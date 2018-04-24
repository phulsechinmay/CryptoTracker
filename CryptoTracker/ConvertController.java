package CryptoTracker;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

abstract public class ConvertController {

    public Scene convertScene;
    public Double rightCost;
    public Double leftCost;

    abstract public void setRightImage(Image img);
    abstract public void setLeftImage(Image img);
    abstract public void setRightLabel(String str);
    abstract public void setLeftLabel(String str);
    abstract public void convertValues();
    abstract public void switchCurrencies();

    public void display(String title, Scene scene){
        Stage window = new Stage();
        convertScene = scene;
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setScene(scene);
        window.showAndWait();
    }
}
