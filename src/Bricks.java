import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bricks extends Rectangle 
{
	public ArrayList<Bricks> bricks = new ArrayList<Bricks>();
	public ArrayList<Bricks> yellow = new ArrayList<Bricks>();
	public ArrayList<Bricks> green = new ArrayList<Bricks>();
	public int hp;
	
	public Bricks(double width, double height, Color color)
	{
		super(width, height, color);
	}
	
	public Bricks(Pane pane)
	{
		//505,120
		for(int i = 0; i<8; ++i)
		{
			for(int j = 0; j<12; ++j)
			{
				
				if(i<2)
				{
					Bricks brick = new Bricks(40, 10, Color.RED);
					brick.setStroke(Color.BLACK);
					brick.setX(j*40+65);
					brick.setY(i*10+50);
					hp = 4;
					pane.getChildren().add(brick);
					bricks.add(brick);	
					continue;
				}
				if(i<4)
				{
					Bricks brick = new Bricks(40, 10, Color.ORANGE);
					brick.setStroke(Color.BLACK);
					brick.setX(j*40+65);
					brick.setY(i*10+50);
					hp = 3;
					pane.getChildren().add(brick);
					bricks.add(brick);	
					continue;
				}
				if(i<6)
				{
					Bricks brick = new Bricks(40, 10, Color.GREEN);
					brick.setStroke(Color.BLACK);
					brick.setX(j*40+65);
					brick.setY(i*10+50);
					hp = 2;
					pane.getChildren().add(brick);
					bricks.add(brick);	
					green.add(brick);
					continue;
				}
				else
				{
					Bricks brick = new Bricks(40, 10, Color.YELLOW);
					brick.setStroke(Color.BLACK);
					brick.setX(j*40+65);
					brick.setY(i*10+50);
					hp = 1;
					pane.getChildren().add(brick);
					bricks.add(brick);
					yellow.add(brick);
				}
			}
		}
		
		
	}
	
	public void setHp(int hp)
	{
		this.hp = hp;
	}
}
