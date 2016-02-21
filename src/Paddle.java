import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Paddle extends Rectangle {
	
	double x = 0, y = 0;
	
	public Paddle(Scene scene, AnchorPane pane, Stage primaryStage) {
		AnchorPane ancPane = pane;
		final Rectangle rect = new Rectangle();
		rect.setY(190);
	    rect.yProperty().bind(ancPane.heightProperty().subtract(10));
	    rect.setHeight(10);
	    rect.setWidth(100);
	    rect.setFill(Color.WHITE);
	    ancPane.getChildren().add(rect);
	    primaryStage.setScene(scene);
	    primaryStage.setResizable(false);
	    primaryStage.show();
		final double rectangleSpeed = 600; // pixels per second
		final double minX = 0;
		final double maxX = 600 - 90;
		final DoubleProperty rectangleVelocity = new SimpleDoubleProperty();
		final LongProperty lastUpdateTime = new SimpleLongProperty();
		final AnimationTimer rectangleAnimation = new AnimationTimer() {
			@Override
			public void handle(long timestamp) {
				if (lastUpdateTime.get() > 0) {
					final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1000000000.0;
					final double deltaX = elapsedSeconds * rectangleVelocity.get();
					final double oldX = rect.getTranslateX();
					final double newX = Math.max(minX, Math.min(maxX, oldX + deltaX));
					x = newX;
					rect.setTranslateX(newX);
				}
				lastUpdateTime.set(timestamp);
			}
		};
		rectangleAnimation.start();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.D) {
					rectangleVelocity.set(rectangleSpeed);
				} else if (event.getCode() == KeyCode.A) {
					rectangleVelocity.set(-rectangleSpeed);
				}
			}
		});

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.A) {
					rectangleVelocity.set(0);
				}
			}
		});
	}
}
