import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WorldFrame extends JFrame
{
	//!!!!!!!!!!!!IMPLEMENT "PAUSE"!!!!!!!!!!!!!!!!!!!!!!
	//HAVE TO BE ABLE TO SEE STAGE
	//SET-UP BEFORE ANY MOVEMENT TAKES PLACE!!!!!!!!!
	public WorldFrame()
	{
		super("Monster Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cPane = getContentPane();
		cPane.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		cPane.add(worldGrid, BorderLayout.CENTER);
		cPane.add(panel, BorderLayout.SOUTH);
		panel.add(startButton);

		//10 x 10 and 500 x 600 works well for my laptop
		//	feel free to change if you need to.
		setSize(500, 600);

		//When start button is pressed, call gameLoop()
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				worldGrid.pressedStart();
				if(worldGrid.isRunning())
				{
					startButton.setText("Stop");
				}
				else
				{
					startButton.setText("Start");
				}
			}
		});
	}
	
	private WorldGrid worldGrid = new WorldGrid();

	private JButton startButton = new JButton("Start");
	
	//Eclipse yelled at me for not having this
	private static final long serialVersionUID = 1L;
}