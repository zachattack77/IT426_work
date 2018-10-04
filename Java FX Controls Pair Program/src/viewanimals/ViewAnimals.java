package viewanimals;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Radio button to show a picture of the animal
 * @author Pavel Vashchuk and Zach Kunitsa
 * @version 1.0
 */
public class ViewAnimals extends Application {

    public static final int WIDTH_SIZE = 330;
    public static final int HEIGHT_SIZE = 350;
    public static final int IMG_SIZE = 300;
    public static final int SPACING = 10;
    public static final int PADDING = 15;
    public static final int RADIO_BUTN_SPACING = 20;

    @Override
    public void start(Stage stage) {
        stage.setScene(assembleScene());
        stage.setTitle("Select an image!");
        stage.show();
    }

    private Scene assembleScene(){
        VBox mainPanel = new VBox();

        mainPanel.getChildren().addAll(getImages());

        return new Scene(mainPanel, WIDTH_SIZE, HEIGHT_SIZE);
    }

    private VBox getImages(){
        VBox panel = new VBox();
        panel.setSpacing(SPACING);
        panel.setPadding(new Insets(PADDING));

        //HBox for the radioButtons
        HBox radioButtonPanel = new HBox();

        radioButtonPanel.setSpacing(RADIO_BUTN_SPACING);
        ToggleGroup group = new ToggleGroup();

        RadioButton[] buttons = new RadioButton[4];
        String[] pets = {"bear","cat", "owl", "parrot"};

        for(int i = 0; i < buttons.length; i++){

            buttons[i] = new RadioButton(pets[i]);
        }
        radioButtonPanel.getChildren().addAll(buttons);
        group.getToggles().addAll(buttons);

        //add the radioBox panel to the main VBox
        panel.getChildren().add(radioButtonPanel);

        //add image to the bottom
        ImageView imageView = new ImageView();

        for(RadioButton button : buttons){
            button.selectedProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    Image image = new Image(new File("images/"+ button.getText() +".jpg").toURI().toURL().toString(), true);
                    imageView.setFitHeight(IMG_SIZE);
                    imageView.setFitWidth(IMG_SIZE);
                    imageView.setImage(image);
                }
                catch(MalformedURLException e) {
                    System.out.println(e);
                }

            });
        }


        panel.getChildren().add(imageView);

        return panel;
    }


}
