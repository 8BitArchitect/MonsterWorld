import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Iterator;

class WorldGrid extends JComponent
{

	public WorldGrid()
	{
		width = 10;
		height = 10;

		actors = new ActorGrid();
		initComponents();
	}

	public WorldGrid(int width,int height)
	{
		this.width = width;
		this.height = height;
		actors = new ActorGrid();
		
		initComponents();
		//actors.add(new Rock(0,0));

	}
	
	private boolean isEmpty(int x, int y)
	{
		Iterator<Actor> iter = actors.iterator();
		
		while(iter.hasNext())
		{
			Actor a = iter.next();
			
			if(a.getX() == x && a.getY() == y)
			{
				return false;
			}
		}
		return true;
	}

	private void removeActor(int x, int y)
	{
		Iterator<Actor> iter = actors.iterator();

		while(iter.hasNext())
		{
			Actor a = iter.next();

			if(a.getX() == x && a.getY() == y)
			{
				iter.remove();
			}
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i <= width; i++)
		{
			g2.draw(new Line2D.Double(i*48-1, 0, i*48-1, height*48));
			g2.draw(new Line2D.Double(i*48, 0, i*48, height*48));
		}
		for (int i = 0; i <= height; i++)
		{
			g2.draw(new Line2D.Double(0, i*48-1, width*48, i*48-1));
			g2.draw(new Line2D.Double(0, i*48, width*48, i*48));
		}
		for (Actor a : actors)
		{
			g2.drawImage(a.getImage(), a.getX()*48, a.getY()*48, null);
		}

		repaint();
	}

	public Dimension getPreferredSize() { return new Dimension(width * 48, height * 48); }

	private final JPopupMenu popupMenu = new JPopupMenu();
	private final JMenuItem drawRockJMenu = new JMenuItem("Draw Rock here");
	private final JMenuItem drawHumanJMenu = new JMenuItem("Draw Human here");
	private final JMenuItem drawVampireJMenu = new JMenuItem("Draw Vampire here");
	private final JMenuItem drawZombieJMenu = new JMenuItem("Draw Zombie here");
	private int x = 0, y = 0;


	private void initComponents()
	{
		popupMenu.add(drawRockJMenu);
		popupMenu.add(drawHumanJMenu);
		popupMenu.add(drawVampireJMenu);
		popupMenu.add(drawZombieJMenu);
		add(popupMenu);
		
		addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getButton() == MouseEvent.BUTTON1)
				{
					x = e.getX() / 48;
					y = e.getY() / 48;

					removeActor(x, y);

					repaint();
				}
				
				checkForTriggerEvent(e);
			}

			private void checkForTriggerEvent(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					x = e.getX();
					y = e.getY();
					popupMenu.show(e.getComponent(), x,y);
				}
			}
			
			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}
		});

		drawRockJMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isEmpty((x / 48), (y / 48)))
				{
					addActor(new Rock((x / 48), (y / 48)));
					repaint();
				}
			}
		});

		drawHumanJMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isEmpty((x / 48), (y / 48)))
				{
					addActor(new Human((x / 48), (y / 48)));
					repaint();
				}
			}
		});

		drawVampireJMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isEmpty((x / 48), (y / 48)))
				{
					addActor(new Vampire((x / 48), (y / 48)));
					repaint();
				}
			}
		});

		drawZombieJMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isEmpty((x / 48), (y / 48)))
				{
					addActor(new Zombie((x / 48), (y / 48)));
					repaint();
				}
			}
		});
	}

	public void addActor(Actor newActor){actors.add(newActor);}

	int width;
	int height;
	ActorGrid actors;
}