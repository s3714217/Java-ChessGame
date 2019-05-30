package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import oo.Board;

// for entering the amount of moves wanted
public class MoveAmount extends JFrame
{
	
	private int numMoves = 0;	
	private JLabel header;
	private JTextField inputNumMoves;
	private JLabel labelNumMoves;
	private JButton submit;
	
	public MoveAmount(JFrame mainFrame, Board board) throws HeadlessException
	{
		// TODO Auto-generated constructor stub	
		super("Amount of moves");
		
		mainFrame.setVisible(false);
		
		setSize(350, 220);
		setResizable(false);
		setPreferredSize(new Dimension(350, 220));
		setLocationRelativeTo(mainFrame);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		Container content = this.getContentPane();
		content.setLayout(null);
		header = new JLabel("Enter the amount of moves wanted");
		header.setBounds(75, 3, 250, 40);

		
		labelNumMoves = new JLabel("Amount:");
		labelNumMoves.setBounds(20, 30, 250, 30);
		
		inputNumMoves = new JTextField();
		inputNumMoves.setBounds(75, 30, 225, 30);

		submit = new JButton("Submit");
		submit.setBounds(50, 150, 250, 30);
		
		add(header);
		add(labelNumMoves);
		add(inputNumMoves);
		add(submit);
		
		// submit action
		submit.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						// TODO Auto-generated method stub
						// checks the length of the string entered
						if (inputNumMoves.getText().length() > 0)
						{
							// trys to get turn string into int
							try 
							{
								
								// check the number entered is bigger than 0
								if (Integer.parseInt(inputNumMoves.getText()) > 0)
								{
									// create the chessGUI
									numMoves = Integer.parseInt(inputNumMoves.getText());
									setVisible(false);
									
									JOptionPane.showMessageDialog(null, "Welcome to LATTITUDE CHESS GAME");
									
									board.setNumMoves(numMoves);
									
									ChessGUI chess_board = new ChessGUI(board);
									 
									mainFrame.dispose();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Enter a number larger than 0");
								}
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Enter only digits");
							}
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "Enter a numbers");
						}
					}
					
				});
	}

}
