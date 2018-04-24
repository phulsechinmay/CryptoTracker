package CryptoTracker;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertSceneController extends ConvertController{
    @FXML
    public ImageView leftImg;

    @FXML
    public ImageView rightImg;

    @FXML
    public Label leftLabel;

    @FXML
    public Label rightLabel;

    @FXML
    public TextField leftText;

    @FXML
    public TextField rightText;

    @Override
    public void setRightImage(Image img) {
        rightImg.setImage(img);
    }

    @Override
    public void setLeftImage(Image img) {
        leftImg.setImage(img);
    }

    @Override
    public void setLeftLabel(String str) {
        leftLabel.setText(str);
    }

    @Override
    public void setRightLabel(String str) {
        rightLabel.setText(str);
    }

    @Override
    public void convertValues() {
        try {
            String leftStr = leftText.getText();
            Double leftValue = Double.parseDouble(leftStr);

            Double convertedValue = leftValue * leftCost / rightCost;
            String output = String.format("%.3f", convertedValue);
            rightText.setText(output);
        }
        catch(NumberFormatException e){
            System.out.println("Format exception, enter correct string");
        }

    }

    @Override
    public void switchCurrencies() {
        Image leftTempImg = leftImg.getImage(); // Switch images
        leftImg.setImage(rightImg.getImage());
        rightImg.setImage(leftTempImg);

        String leftTempStr = leftLabel.getText(); // Switch Labels
        leftLabel.setText(rightLabel.getText());
        rightLabel.setText(leftTempStr);

        Double leftTempCost = leftCost; // Switch costs
        leftCost = rightCost;
        rightCost = leftTempCost;
    }
}
