package MVC.Model;

import javax.swing.*;
import java.awt.Color;
	/**
	 * Abstract class Piece
	 * @version B
	 * @author George Vasileiadis
	 *
	 **/

	/*needs javadoc and maybe some more methods*/

@SuppressWarnings("serial")
public abstract class Piece extends JButton {
	
	private int grade;
	private Color color;
	private int specialID;
	private String imagename;
	private boolean pieceonBoard;
	private boolean rescue;
	private Icon pic;
	private boolean available_square;
	
	public Piece(int grade,Color color, int specialID, String image)
	{
		setGrade(grade);
		setColor(color);
		setSpecialID(specialID);
		
		this.imagename = image;
		this.pieceonBoard = true;
		pic = new ImageIcon(imagename);
		this.available_square = false;
	}
		
	

	public void setGrade(int grade) {
		
		this.grade = grade;
	}
	
	public int getGrade() {
		
		return this.grade;
	}
	
	public void setColor(Color color) {
		
		this.color = color;
	}
	
	public Color getColor() {
		
		return this.color;
	}

	public void setSpecialID(int specialID) {
		
		this.specialID = specialID;
	}
	
	public int getSpecialID() {
		
		return this.specialID;
	}
	
	/**
	 * Pic is about giving the graphical part to each Piece
	 * 
	 *@param pic
	 **/
	public void setImage(Icon pic) {
		
		this.pic = pic;		
	}
	
	public Icon getImage() {
	
		return pic;
	}
	/**
	 * Imagename is about giving the path to the Piece
	 * 
	 * @param imagepath
	 * 
	 **/
	public void setImagename(String image)
	{	
		
		imagename = image;
	}
	public String getImagename() {
				
		return this.imagename;
	}
	/**
	 * By this method, we check if the piece is on board or captured
	 * @param pieceonBoard
	 * */
	public boolean setisPieceonBoard(boolean pieceonBoard) {
		if(pieceonBoard) return true;
		else return false;		
	}
	
	public boolean isPieceonBoard() {
		return pieceonBoard;
	}



	public void setAvailable_square(boolean available_square) {
		this.available_square = available_square;
	}
	
	public boolean getAvailable_square() {
		return this.available_square; 
	}

	/**
	 * This method exists for the Movable Pieces which recover another Piece from the Captures
	 * and makes them unable to do it again
	 * 
	 * @param rescue
	 * */

	public void setHasRescued(boolean rescue) {
		
		this.rescue = rescue;
	}
	
	public boolean getHasRescued()
	{
		return this.rescue;
	}

	
}