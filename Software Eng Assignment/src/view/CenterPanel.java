package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import oo.Board;

public class CenterPanel extends JPanel
{
	
	private List<TilePanel> tilePanels;
	public CenterPanel(Board board)
	{
		// TODO Auto-generated constructor stub
		super(new GridLayout(6,6));
		
		this.tilePanels = new ArrayList<>();
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
		
		System.out.println(this.getWidth());
	}

}
