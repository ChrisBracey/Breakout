import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.Button;
import java.lang.Exception;

public class Main extends Application {
    @Override
	public void start(Stage primaryStage) throws Exception {
	    AnchorPane ancPane = new AnchorPane();      
	    Scene scene = new Scene(ancPane, 600, 450, Color.BLACK); 
	    final Paddle paddle = new Paddle(scene, ancPane, primaryStage);
	    Bricks bricks = new Bricks(ancPane);
	    final Ball ball = new Ball(ancPane, scene, bricks, paddle, primaryStage,false, false);
		
	    primaryStage.setScene(scene);
	    primaryStage.setResizable(false);
	    primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

    public void restart(Stage stage) {
        stage.close();
        try
        {
             start(new Stage());
        } catch(Exception e) {

        }
    }
}
