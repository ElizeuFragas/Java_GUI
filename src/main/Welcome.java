package app;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Welcome {

    static Stage window;
    public static void display(TextField userName){

        GridPane grid = new GridPane();
        Scene scene2 = new Scene(grid);
        Button btn = new Button();
        Label label = new Label(); 
        StackPane btnPane = new StackPane();

        window = (Stage) userName.getScene().getWindow();
        //if (window == null) {
        //    window=(Stage) userName.getScene().getWindow();
        //}
        Scene sc = userName.getScene();

        System.out.println(userName.getText());

        btn.setText("Logout");
        btn.setOnAction(e -> choiceLogout(window, sc));

        btnPane.getChildren().add(btn);

        label.setText("Welcome again " + userName.getText());
        label.setFont(Font.font(30));

        grid.add(label, 0, 0);
        grid.add(btnPane, 0, 7);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(12);

        if (window.isFocused()) {
            window.setScene(scene2);
        }
    }

    public static void choiceLogout(Stage st, Scene sc){

        Stage stage = new Stage();
        HBox hbox = new HBox();
        Label label = new Label();
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        Button yesBt, noBt;

        System.out.println(st.getTitle());
        stage.initModality(Modality.APPLICATION_MODAL);

        label.setText("Are you sure about that ?");
        label.setFont(Font.font(15));

        yesBt = new Button();
        yesBt.setFont(Font.font(12));
        yesBt.setText("Yes");
        yesBt.setMaxHeight(15);
        yesBt.setOnAction(e -> {
            st.setScene(sc);
            stage.close();

        });

        noBt = new Button();
        noBt.setText("No");
        noBt.setMaxHeight(15);
        noBt.setFont(Font.font(12));
        noBt.setOnAction(e -> stage.close()); 

        hbox.getChildren().addAll(yesBt, noBt);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(label, hbox);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 0, 10, 0));


        Rectangle2D rec = Screen.getPrimary().getVisualBounds();

        stage.setScene(scene);
        stage.setWidth(200);
        stage.setHeight(100);
        stage.setResizable(false);
        stage.setX((rec.getWidth()-stage.getWidth())/2);
        stage.setY((rec.getHeight()-stage.getHeight())/2);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();

    }
}
