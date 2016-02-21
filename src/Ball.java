import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ball extends Circle
{
	private Timeline animation;
	private Circle ball;
	private double x = Math.random()*600, y = 225;
	private double dx = 1, dy = 1;
	private boolean gameOver = false;

	public Ball(Pane pane, Stage stage, Bricks bricks, Paddle paddle)
	{
		ball = new Circle(x, y, 10);
		ball.setFill(Color.BLUE);
		pane.getChildren().add(ball);

		if(!gameOver)
		{
		animation = new Timeline(new KeyFrame(Duration.millis(5),
				e -> moveBall(bricks, pane, stage, paddle)));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		}
	}

	protected void moveBall(Bricks bricks, Pane pane, Stage stage,
			Paddle paddle)
	{
		if ((x >= paddle.x && x <= paddle.x + 100)
				&& y == pane.getHeight() - 10 - paddle.getHeight()- ball.getRadius())
		{
			dy *= -1;
		} else if(y > 450)
		{
			gameOver = true;
		}

		if (x < ball.getRadius() || x > pane.getWidth() - ball.getRadius())
		{
			dx *= -1;
		}
		if (y < ball.getRadius() || y > pane.getHeight() - ball.getRadius())
		{
			dy *= -1;
		}
		if (y - ball.getRadius() <= 120 && y - ball.getRadius() >= 100)
		{
			for (int i = 0; i < bricks.yellow.size(); ++i)
			{
				if (x + ball.getRadius() > 65 && x - ball.getRadius() < 505)
				{
					if (x >= bricks.yellow.get(i).getX()
							&& x <= bricks.yellow.get(i).getX()
									+ bricks.yellow.get(i).getWidth())
					{
						if (y == bricks.yellow.get(i).getY()
								+ bricks.yellow.get(i).getHeight())
						{
							bricks.bricks.remove(bricks.yellow.get(i));
							pane.getChildren().remove(bricks.yellow.get(i));
							bricks.yellow.remove(i);
							dy *= -1;
						}
					}
				}
			}
		}

		if (y - ball.getRadius() <= 110 && y - ball.getRadius() >= 90)
		{
			for (int i = 0; i < bricks.green.size(); ++i)
			{
				if (x + ball.getRadius() > 65 && x - ball.getRadius() < 505)
				{
					if (x >= bricks.green.get(i).getX()
							&& x <= bricks.green.get(i).getX()
									+ bricks.green.get(i).getWidth())
					{
						if (y == bricks.green.get(i).getY()
								+ bricks.green.get(i).getHeight()
								|| y == bricks.green.get(i).getY())
						{
							bricks.green.get(i)
									.setHp(bricks.green.get(i).hp - 1);
								bricks.bricks.remove(bricks.green.get(i));
								pane.getChildren().remove(bricks.green.get(i));
								bricks.green.remove(i);
							dy *= -1;
						}
					}
				}
			}
		
		}
		
		if(!gameOver) {
			x += dx;
			y += dy;
		} else
		{
			pane.getChildren().remove(ball);
			
				Text text = new Text(pane.getWidth()/3,pane.getHeight()/2, "Game Over");
				text.setFont(Font.font("Times New Roman", 50));
				text.setFill(Color.WHITE);
				pane.getChildren().add(text);

				animation.stop();
			
		}
		ball.setCenterX(x);
		ball.setCenterY(y);

	}
}
