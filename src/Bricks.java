import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bricks extends Rectangle 
{
	public ArrayList<Bricks> bricks = new ArrayList<Bricks>();
	public ArrayList<Bricks> yellow = new ArrayList<Bricks>();
	public ArrayList<Bricks> green = new ArrayList<Bricks>();
	public ArrayList<Bricks> orange = new ArrayList<Bricks>();
	public ArrayList<Bricks> red = new ArrayList<Bricks>();
	public int hp;
	
	public Bricks(double width, double height, Color color, int hp)
	{
		super(width, height, color);
		this.hp = hp;
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
					Bricks brick = new Bricks(40, 10, Color.RED, 4);
					brick.setStroke(Color.BLACK);
					brick.setX(j*40+65);
					brick.setY(i*10+50);
					hp = 4;
					pane.getChildren().add(brick);
					bricks.add(brick);
					red.add(brick);
					continue;
				}
				if(i<4)
				{
					Bricks brick = new Bricks(40, 10, Color.ORANGE, 3);
					brick.setStroke(Color.BLACK);
					brick.setX(j*40+65);
					brick.setY(i*10+50);
					pane.getChildren().add(brick);
					bricks.add(brick);
					orange.add(brick);
					continue;
				}
				if(i<6)
				{
					Bricks brick = new Bricks(40, 10, Color.GREEN, 2);
					brick.setStroke(Color.BLACK);
					brick.setX(j*40+65);
					brick.setY(i*10+50);
					pane.getChildren().add(brick);
					bricks.add(brick);	
					green.add(brick);
					continue;
				}
				else
				{
					Bricks brick = new Bricks(40, 10, Color.YELLOW, 1);
					brick.setStroke(Color.BLACK);
					brick.setX(j*40+65);
					brick.setY(i*10+50);
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
