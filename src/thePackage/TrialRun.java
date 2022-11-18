package thePackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// based on "Creating a Form in JavaFX" tutorial by Chappell and Hildebrandt, Oracle

public class TrialRun extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25,25,25,25));
            
            Text scenetitle = new Text("Welcome");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
            grid.add(scenetitle, 0, 0, 2, 1);
            
            Label userName = new Label("User Name:");
            grid.add(userName, 0, 1);
            
            TextField userTextField = new TextField();
            grid.add(userTextField, 1, 1);

            Label pw = new Label("Password:");
            grid.add(pw, 0, 2);
            
            PasswordField pwBox = new PasswordField();
            grid.add(pwBox,  1, 2);            
            
            Scene scene = new Scene(grid, 400, 500);
            primaryStage.setScene(scene);

            // it's show time!
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    } // start

    public static void main(String[] args) {
        launch(args);
    } // main

} // class TrialRun