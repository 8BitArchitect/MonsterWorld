
public class Vampire extends Monster
{
	//Creates vampire object with the position
	//	of the vampire being instantiated with
	//	(x,y) coordinates passed to it
	public Vampire(int x, int y)
	{
		super(x, y, IMG_LOC);
		this.setType("Vampire");
		
	}

	//Creates a vampire at the default location (0,0)
	public Vampire()
	{
		super(0, 0, IMG_LOC);
		this.setType("Vampire");
	}

	//String containing path to vampire-front.gif
	private static final String IMG_LOC = "src/images/vampire-front.gif";

}
