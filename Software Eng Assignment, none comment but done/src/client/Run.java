package client;

import javax.swing.SwingUtilities;


import view.Menu;

public class Run
{

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new Menu());
	}

}
