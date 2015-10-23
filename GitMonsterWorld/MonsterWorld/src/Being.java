
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
	
	public void move(int x, int y) {
		// TODO Auto-generated method stub

	}

	
	public void faceLeft() {
		this.setImage("src/images/" + this.getType() + "-left.gif");
	}
	public void faceRight() {
		this.setImage("src/images/" + this.getType() + "-right.gif");
	}
	public void faceUp() {
		this.setImage("src/images/" + this.getType() + "-back.gif");
	}
	public void faceDown() {
		this.setImage("src/images/" + this.getType() + "-front.gif");
	}

	String type;
}
