package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import oo.Board;

// holds all the tiles
public class CenterPanel extends JPanel
{
	//gui tiles
	private List<TilePanel> tilePanels;
	
	public CenterPanel(Board board)
	{
		// TODO Auto-generated constructor stub
		//grid layout of a 6 by 6
		super(new GridLayout(6,6));
		
		this.tilePanels = new ArrayList<>();
		
		// adding all the tiles to the centerpanel
		for(int i = 5; i >= 0; i--)
		{
			for(int j = 0; j < 6; j++)
			{
				TilePanel tilePanel = new TilePanel(j, i, this, board);
				
				this.tilePanels.add(tilePanel);
				
				add(tilePanel);
			}
		}
		
		validate();
		
	}

}
