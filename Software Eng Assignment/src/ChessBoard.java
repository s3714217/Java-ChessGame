import java.awt.EventQueue;

import javax.swing.JFrame;

public class ChessBoard {

	private JFrame frame;

	public ChessBoard(Board board) {
		initialize(board);
	}


	private void initialize(Board board) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	
	public JFrame getPanel()
	{
		return frame;
	}

}
