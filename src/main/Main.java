package app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;
import app.Welcome;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        GridPane root = new GridPane();
        StackPane btPane = new StackPane();
        Button btn = new Button("Enter");
        StackPane namePane = new StackPane();
        TextField userName = new TextField();
        TextField userPass = new TextField();
        Label loginName = new Label();
        Scene scene = new Scene(root);

        loginName.setText("Login");
        loginName.setFont(Font.font(24));

        namePane.setAlignment(Pos.TOP_LEFT);
        namePane.getChildren().add(loginName);

        userName.setAlignment(Pos.CENTER_LEFT); 
        userName.setPromptText("User name");
        userName.setOnKeyPressed(e -> {

            if (e.getCode() == KeyCode.ENTER) {
                btn.fire();
            }

        });

        userPass.setPromptText("Password");
        userPass.setOnKeyPressed(e -> {

            if (e.getCode() == KeyCode.ENTER) {
                btn.fire();
            }

        });

        btn.setText("Enter");
        btn.setOnAction(event -> {

            Scene scene2 = Welcome.display(userName);
            stage.setScene(scene2);

        });

        btPane.getChildren().add(btn);

        root.requestFocus();
        root.add(namePane, 0, 0);
        root.add(userName, 0, 5);
        root.add(userPass, 0, 6);
        root.add(btPane, 0, 8);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(12);
        root.setOnKeyPressed(e -> {

            if (e.getCode() == KeyCode.ENTER) {
                btn.fire();
            }

        });

        Rectangle2D rec = Screen.getPrimary().getVisualBounds();

        stage.setWidth(450);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.setX((rec.getWidth()-stage.getWidth())/2);
        stage.setY((rec.getHeight()-stage.getHeight())/2);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNIFIED);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);

    }
}
