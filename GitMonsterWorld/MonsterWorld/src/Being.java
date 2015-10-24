
public abstract class Being extends Actor
{

	public Being()
	{
		super();
	}
	
	public Being(int x, int y, String fileName)
	{
		super(x, y, fileName);
	}

	public String getType()
	{ return type; }
	
	public void setType(String actorType)
	{ type = actorType; }
	
	//Most basic of basic movements
	//NOTE: x and y should only be the values
	//	0, 1, or -1.
	public void move(int x, int y) {
		
		int OrigX = getGridX();
		int OrigY = getGridY();
		int xTarget = OrigX + x;
		int yTarget = OrigY + y;
		int xDelta;
		int yDelta;
		
		//move right
		if(xTarget > OrigX)
			faceRight();
		//move left
		if(xTarget < OrigX)
			faceLeft();
		//move down
		if(yTarget > OrigY)
			faceDown();
		//move up
		if(yTarget < OrigY)
			faceUp();

		//Move image on screen until theoretical grid
		//	coordinates sync
		while(getGridX() != xTarget || getGridY() != yTarget)
		{
			xDelta = getScreenX() + x;
			yDelta = getScreenY() + y;
			setPos(xDelta, yDelta);
		}
	}

	public void faceLeft() {
		setImage("src/images/" + this.getType() + "-left.gif");
	}
	public void faceRight() {
		setImage("src/images/" + this.getType() + "-right.gif");
	}
	public void faceUp() {
		setImage("src/images/" + this.getType() + "-back.gif");
	}
	public void faceDown() {
		setImage("src/images/" + this.getType() + "-front.gif");
	}

	private String type;
}
