import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ball extends Circle {
	private Timeline animation;
	private Circle ball;
	private double x = Math.random() * 600, y = 225;
	private double dx = 1, dy = 1;
	private boolean gameOver = false;
	private int intScore = 0;
	private Text score = new Text(10, 15, "");
	private Bricks bricks;
	private Text text = new Text(0, 0, "");

	public Ball(Pane pane, Scene scene, Bricks bricks, Paddle paddle, Stage stage, boolean nextLevel) {
		this.bricks = bricks;
		ball = new Circle(x, y, 9);
		ball.setFill(Color.BLUE);
		pane.getChildren().addAll(ball);
		if (!nextLevel) {
			score.setText("000000");
			score.setFont(new Font("Times New Roman", 20));
			score.setFill(Color.WHITE);
			pane.getChildren().add(score);
		}

		if (!gameOver) {
			animation = new Timeline(
					new KeyFrame(Duration.millis(5), e -> moveBall(bricks, pane, scene, paddle, stage)));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		}
	}

	protected void moveBall(Bricks bricks, Pane pane, Scene scene, Paddle paddle, Stage stage) {

	/*	if ((x >= paddle.x + 250 && x <= paddle.x + 250 + 100)
				&& y == pane.getHeight() - 10 - paddle.getHeight() - ball.getRadius()) {
			dy *= -1;
		} else if (y > 450) {
			gameOver = true;
		}*/

		pane.getChildren().remove(text);
		if (x < ball.getRadius() || x > pane.getWidth() - ball.getRadius()) {
			dx *= -1;
		}
		if (y < ball.getRadius() || y > pane.getHeight() - ball.getRadius()) {
			dy *= -1;
		}
		if (y - ball.getRadius() < 120 && y - ball.getRadius() > 100) {
			for (int i = 0; i < bricks.yellow.size(); ++i) {
				if (x + ball.getRadius() > 65 && x - ball.getRadius() < 520) {
					if (x > bricks.yellow.get(i).getX()
							&& x < bricks.yellow.get(i).getX() + bricks.yellow.get(i).getWidth()) {
						if (y < bricks.yellow.get(i).getY() + bricks.yellow.get(i).getHeight()
								&& y > bricks.yellow.get(i).getY()) {
							bricks.bricks.remove(bricks.yellow.get(i));
							pane.getChildren().remove(bricks.yellow.get(i));
							intScore += 25;
							pane.getChildren().remove(score);
							score = new Text(10, 15, String.format("%06d", intScore));
							score.setFont(new Font("Times New Roman", 20));
							score.setFill(Color.WHITE);
							pane.getChildren().add(score);
							bricks.yellow.remove(i);
							dy *= -1;
						}
					}
				}
			}
		}

		if (y - ball.getRadius() < 100 && y - ball.getRadius() > 80) {
			for (int i = 0; i < bricks.green.size(); ++i) {
				if (x + ball.getRadius() > 65 && x - ball.getRadius() < 520) {
					if (x > bricks.green.get(i).getX()
							&& x < bricks.green.get(i).getX() + bricks.green.get(i).getWidth()) {
						if (y < bricks.green.get(i).getY() + bricks.green.get(i).getHeight()
								&& y > bricks.green.get(i).getY()) {
							bricks.green.get(i).setHp(bricks.green.get(i).hp - 1);
							intScore += 25;
							pane.getChildren().remove(score);
							score = new Text(10, 15, String.format("%06d", intScore));
							score.setFont(new Font("Times New Roman", 20));
							score.setFill(Color.WHITE);
							pane.getChildren().add(score);
							if (bricks.green.get(i).hp == 1) {
								bricks.green.get(i).setFill(Color.YELLOW);
							} else if (bricks.green.get(i).hp == 0) {
								bricks.bricks.remove(bricks.green.get(i));
								pane.getChildren().remove(bricks.green.get(i));
								bricks.green.remove(i);
							}
							dy *= -1;
						}
					}
				}
			}

		}

		if (y - ball.getRadius() < 80 && y - ball.getRadius() > 60) {
			for (int i = 0; i < bricks.orange.size(); ++i) {
				if (x + ball.getRadius() > 65 && x - ball.getRadius() < 520) {
					if (x > bricks.orange.get(i).getX()
							&& x < bricks.orange.get(i).getX() + bricks.orange.get(i).getWidth()) {
						if (y < bricks.orange.get(i).getY() + bricks.orange.get(i).getHeight()
								&& y > bricks.orange.get(i).getY()) {
							bricks.orange.get(i).setHp(bricks.orange.get(i).hp - 1);
							intScore += 25;
							pane.getChildren().remove(score);
							score = new Text(10, 15, String.format("%06d", intScore));
							score.setFont(new Font("Times New Roman", 20));
							score.setFill(Color.WHITE);
							pane.getChildren().add(score);
							if (bricks.orange.get(i).hp == 2) {
								bricks.orange.get(i).setFill(Color.GREEN);
							} else if (bricks.orange.get(i).hp == 1) {
								bricks.orange.get(i).setFill(Color.YELLOW);
							} else if (bricks.orange.get(i).hp == 0) {
								bricks.bricks.remove(bricks.orange.get(i));
								pane.getChildren().remove(bricks.orange.get(i));
								bricks.orange.remove(i);
							}
							dy *= -1;
						}
					}
				}
			}

		}

		if (y - ball.getRadius() < 60 && y - ball.getRadius() > 40) {
			for (int i = 0; i < bricks.red.size(); ++i) {
				if (x + ball.getRadius() > 65 && x - ball.getRadius() < 520) {
					if (x > bricks.red.get(i).getX() && x < bricks.red.get(i).getX() + bricks.red.get(i).getWidth()) {
						if (y < bricks.red.get(i).getY() + bricks.red.get(i).getHeight()
								&& y > bricks.red.get(i).getY()) {
							bricks.red.get(i).setHp(bricks.red.get(i).hp - 1);
							intScore += 25;
							pane.getChildren().remove(score);
							score = new Text(10, 15, String.format("%06d", intScore));
							score.setFont(new Font("Times New Roman", 20));
							score.setFill(Color.WHITE);
							pane.getChildren().add(score);
							if (bricks.red.get(i).hp == 3) {
								bricks.red.get(i).setFill(Color.ORANGE);
							} else if (bricks.red.get(i).hp == 2) {
								bricks.red.get(i).setFill(Color.GREEN);
							} else if (bricks.red.get(i).hp == 1) {
								bricks.red.get(i).setFill(Color.YELLOW);
							} else if (bricks.red.get(i).hp == 0) {
								bricks.bricks.remove(bricks.red.get(i));
								pane.getChildren().remove(bricks.red.get(i));
								bricks.red.remove(i);
							}
							dy *= -1;
						}
					}
				}
			}

		}

		if (!gameOver) {
			x += dx;
			y += dy;
		} else {
			pane.getChildren().remove(ball);

			text = new Text(pane.getWidth() / 3, pane.getHeight() / 2, "Game Over");
			text.setFont(Font.font("Times New Roman", 50));
			text.setFill(Color.WHITE);
			pane.getChildren().add(text);
			animation.stop();

		}

		if (this.bricks.bricks.size() == 0) {

			
			pane.getChildren().remove(ball);
			pane.getChildren().remove(score);
			this.bricks = new Bricks(pane);
			ball = new Ball(pane, scene, this.bricks, paddle, stage, true);
			pane.getChildren().add(ball);

			text = new Text(pane.getWidth() / 3, pane.getHeight() / 2, "You Win");
			text.setFont(Font.font("Times New Roman", 50));
			text.setFill(Color.WHITE);
			pane.getChildren().add(text);
		}
		ball.setCenterX(x);
		ball.setCenterY(y);

	}
}
