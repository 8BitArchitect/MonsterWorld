import java.awt.*;

import javax.swing.*;

class Actor implements iActor
{
	public Actor()
	{
		xGrid = yGrid = xScreen = yScreen = 0;
		displayImage = new ImageIcon("src/images/default.gif").getImage();
	}

	public Actor(int x, int y, String filename)
	{
		xGrid = x;
		yGrid = y;
		xScreen = x * 48;
		yScreen = y * 48;
		displayImage = new ImageIcon(filename).getImage();
	}

	public void setPos(int x, int y)
	{
		//this.xGrid = x;
		//this.yGrid = y;
		xScreen = x;
		yScreen = y;
		xGrid = x / 48;
		yGrid = y / 48;
	}

	public void setImage(String filename)
	{
		displayImage = new ImageIcon(filename).getImage();
	}

	public Image getImage()
	{
		return displayImage;
	}
	

	public int getGridX() {return xGrid;}

	public int getGridY() {return yGrid;}
	
	public int getScreenY() {return yScreen;}
	
	public int getScreenX() {return xScreen;}

	int xGrid;
	int yGrid;
	int xScreen;
	int yScreen;
	Image displayImage;
	
}