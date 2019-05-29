package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import oo.Board;

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
//		header.setFont(new Font("Sans-serif", Font.BOLD, 15));
		
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
		
		submit.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						// TODO Auto-generated method stub
						if (inputNumMoves.getText().length() > 0)
						{
							try 
							{
								
								if (Integer.parseInt(inputNumMoves.getText()) > 0)
								{
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
