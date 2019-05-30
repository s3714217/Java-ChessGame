package view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.DeselectListener;
import controller.MoveListener;
import controller.SelectListener;
import oo.Bishop;
import oo.Board;
import oo.Knight;
import oo.Piece;
import oo.Rook;
import oo.Square;

public class TilePanel extends JPanel implements BoardObserver, MoveObserver
{
	
	private int xPos;
	private int yPos;
	
	private JLabel imageLabel = null;
	private MouseListener currentListener;
	
	public TilePanel(int xPos, int yPos, CenterPanel center, Board board)
	{
		// TODO Auto-generated constructor stub
		super(new GridBagLayout());
		
		this.xPos = xPos;
		this.yPos = yPos;
		intialiseTileColour();
		
		board.addBoardObserver(this);
		board.addMoveObserver(this);
		
		currentListener = new SelectListener(xPos, yPos, board);
		this.addMouseListener(currentListener);
		
		updateBoard(board);
		
		validate();
	}
	
	public void intialiseTileColour()
	{
		Color lightTile = Color.decode("#FFEACE");
		Color darkTile = Color.decode("#CB7E75");
		
		if(yPos % 2 == 0)
		{
			if (xPos % 2 == 0)
			{
				setBackground(lightTile);
			}
			else
			{
				setBackground(darkTile);
			}
		}
		else
		{
			if (xPos % 2 == 0)
			{
				setBackground(darkTile);
			}
			else
			{
				setBackground(lightTile);
			}
		}
		
	}
	
	public void setColour(Color colour)
	{
		setBackground(colour);
		
		revalidate();
		repaint();
	}
	
	public void setImage(String string) throws IOException
	{
		BufferedImage image = ImageIO.read(new File(string));
		
		ImageIcon img = new ImageIcon(image);
//		Image resizeImg= img.getImage();
//		Image newImg = resizeImg.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
//		img = new ImageIcon(newImg);
		
		imageLabel = new JLabel(img);
		 
		imageLabel.setSize(this.getWidth(), this.getHeight());
		 
		this.add(imageLabel);
		 
	}

	@Override
	public void updateBoard(Board board)
	{
		// TODO Auto-generated method stub
		
		if (imageLabel != null)
		{
			this.remove(imageLabel);
			
			imageLabel = null;
		}
		
		Piece gotPiece = board.getSpecPiece(xPos, yPos);
		String file = "Pieces/Chess_";
		
		if (gotPiece != null)
		{
			if (gotPiece.getTeam().equals("player1"))
			{
				if (gotPiece instanceof Bishop)
				{
					file += "blt60";
				}
				else if (gotPiece instanceof Knight)
				{
					file += "nlt60";
				}
				else if (gotPiece instanceof Rook)
				{
					file += "rlt60";
				}
			}
			else if (gotPiece.getTeam().equals("player2"))
			{
				if (gotPiece instanceof Bishop)
				{
					file += "bdt60";
				}
				else if (gotPiece instanceof Knight)
				{
					file += "ndt60";
				}
				else if (gotPiece instanceof Rook)
				{
					file += "rdt60";
				}
			}
			file += ".png";
			try
			{
				setImage(file);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		deselected(board);
		
		revalidate();
		repaint();
	}

	@Override
	public void pieceSelected(Board board, int xPos, int yPos)
	{
		// TODO Auto-generated method stub
		
		Square[] possibleMoves = board.getSpecPiece(xPos, yPos).getPossibleMoves();
		
		this.removeMouseListener(currentListener);
		
		currentListener = new MoveListener(xPos, yPos, this.xPos, this.yPos, board);
		this.addMouseListener(currentListener);
		
		for (int i = 0; i < possibleMoves.length; i++)
		{
			if (possibleMoves[i] != null)
			{
				if (possibleMoves[i].getXAxis() == this.xPos && possibleMoves[i].getYAxis() == this.yPos)
				{
					
					setColour(Color.decode("#F05858"));
				}
				
			}
			
		}
		
		if (this.xPos == xPos && this.yPos == yPos)
		{
			setColour(Color.decode("#6EC2F9"));
			this.removeMouseListener(currentListener);
			
			currentListener = new DeselectListener(board);
			this.addMouseListener(currentListener);
		}
		
		revalidate();
		repaint();
	}

	@Override
	public void deselected(Board board)
	{
		// TODO Auto-generated method stub
		this.removeMouseListener(currentListener);
		
		currentListener = new SelectListener(xPos, yPos, board);
		this.addMouseListener(currentListener);
		
		intialiseTileColour();
		
		revalidate();
		repaint();
	}
	
	

}
