package client;

import javax.swing.SwingUtilities;

import oo.Board;
import view.ChessGUI;

public class run
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> new ChessGUI(new Board()));
	}

}
