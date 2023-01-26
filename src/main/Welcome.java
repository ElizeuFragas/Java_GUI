package app;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Welcome {

    public static Scene display(String userName, Stage stage, Scene someScene){

        Button btn = new Button();
        btn.setText("Logout");
        btn.setOnAction(e -> choiceLogout(stage, someScene));

        StackPane btnPane = new StackPane();
        btnPane.getChildren().add(btn);

        Label label = new Label(); 
        label.setText("Welcome again " + userName);
        label.setFont(Font.font(30));

        GridPane grid = new GridPane();
        grid.add(label, 0, 0);
        grid.add(btnPane, 0, 7);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(12);

        Scene scene = new Scene(grid);

        return scene;
    }

    public static void choiceLogout(Stage st, Scene sc){

        Stage stage = new Stage();
        HBox hbox = new HBox();
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid);
        
        Button yesBt, noBt;

        stage.initModality(Modality.APPLICATION_MODAL);

        yesBt = new Button();
        yesBt.setText("Yes");
        yesBt.setOnAction(e -> {

            st.setScene(sc);
            stage.close(); 

        });

        noBt = new Button();
        noBt.setText("No");
        noBt.setOnAction(e -> stage.close()); 

        hbox.getChildren().addAll(yesBt, noBt);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        grid.add(hbox, 0, 0);
        grid.setAlignment(Pos.CENTER);

        stage.setScene(scene);
        stage.setWidth(200);
        stage.setHeight(150);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.showAndWait();

    }
}
