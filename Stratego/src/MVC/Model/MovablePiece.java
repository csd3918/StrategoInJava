package MVC.Model;

import java.awt.Color;

/**
 * initialize the grade and the specialID to the Movable Piece
 * @param grade
 * @param SpecialID
 * 
 * @version B
 * @author George Vasileiadis
 * */

@SuppressWarnings("serial")

public class MovablePiece extends Piece
{
	public MovablePiece(int grade, Color color, int SpecialID, String image)
	{
		super(grade,color,SpecialID,image);
	}
	
}
