package ui;

import java.util.ArrayList;
import java.util.List;
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * calculator user interface class
 * @author zach Kunitsa
 * @version 1.0
 */
public class CalculatorUI extends Application {

    public static final int WIDTH = 435;
    public static final int HEIGHT = 265;
    public static final double VGAP = 5.0;
    public static final double HGAP = 5.0;
    public static final double BUTTON_HEIGHT = 37.0;
    public static final double BUTTON_WIDTH = 132.0;

    List<Node> buttons= new ArrayList<>();
    EventHandler<ActionEvent> calculatorController;

    TextField textField = new TextField();
    GridPane buttonsPanel = new GridPane();


    @Override
    public void start(Stage primaryStage) {

        // Create the instance of the calculator engine -
        // the controller - to handle GUI events


        try {
            BorderPane root = new BorderPane();

            buttonsPanel.setVgap(VGAP);
            buttonsPanel.setHgap(HGAP);
            buttonsPanel.setAlignment(Pos.CENTER);
            buttonsPanel.setPadding(new Insets(10,10,10,10));
            root.setCenter(buttonsPanel);

            // Create buttons
            createButton("7", 0,0,1,1);
            createButton("8", 1,0,1,1);
            createButton("9", 2,0,1,1);
            createButton("+", 3,0,1,1);

            createButton("4",  0,1,1,1);
            createButton("5", 1,1,1,1);
            createButton("6", 2,1,1,1);
            createButton("-", 3,1,1,1);

            createButton("1",  0,2,1,1);
            createButton("2", 1,2,1,1);
            createButton("3", 2,2,1,1);
            createButton("*", 3,2,1,1);

            createButton("0",  0,3,1,1);
            createButton("Enter", 1,3,2,1);
            //createButton("", 2,3,1,1);
            createButton("/", 3,3,1,1);

            textBox();


            buttonsPanel.getChildren().addAll(buttons);

            Scene scene = new Scene(root, WIDTH, HEIGHT);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    private void textBox(){
        textField = new TextField();
        textField.setAlignment(Pos.CENTER_RIGHT);
        buttonsPanel.add(textField,0,4,4,1);

    }

    private void createButton(String button, int x, int y, int colSpan, int rowSpan) {
        Button createButton = new Button(button);

        GridPane.setConstraints(createButton, x, y, colSpan, rowSpan);
        createButton.setPrefHeight(BUTTON_HEIGHT);
        createButton.setPrefWidth(BUTTON_WIDTH);
        createButton.setMaxWidth(Double.MAX_VALUE);
        createButton.setMaxHeight(Double.MAX_VALUE);
        createButton.setOpaqueInsets(new Insets(5,5,5,5));

        createButton.setOnAction(calculatorController);
        buttons.add(createButton);

    }
}

