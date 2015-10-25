
public interface iBeing extends iActor
{
	void move(int x, int y);
	void moveDir(Direction dir);
	void faceDir(Direction dir);
	void faceLeft();
	void faceRight();
	void faceUp();
	void faceDown();
	void tick();
}
