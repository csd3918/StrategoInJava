package MVC.Model;

import java.awt.Color;

/**
 * 
 * Player class describes the characteristics of the Player
 * and provides modification methods
 * 
 * @version B
 * @author George Vasileiadis
 * */

public class Player {

	private String name;
	private int totalattacks;
	private double win_percentage;
	private int enemycapts;
	private int rescues;
	private Piece[] captures = new Piece[30];
	
	/**
	 * 
	 * Constructor Player(String name, Color color)
	 *  
	 * 
	 */
	public Player(String name, Color color)
	{
		this.name = name;
		totalattacks = 0;
		enemycapts = 0;
		rescues = 0;
		
		for(int i = 0; i<30; i++) captures[i] = new MovablePiece(0,Color.GRAY,0,"");
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String Name)
	{
		
		this.name = Name;
	}
	
	public void addEnemyCapts()
	{
		this.enemycapts++;
		
	}
	
	public void reduceEnemyCapts() {
		if((enemycapts-1) >= 0)	this.enemycapts--;
	}
	
	public int getEnemyCapts()
	{
		return enemycapts;		
	}
	
	public void setWin_Percentage()
	{
		win_percentage =  (this.enemycapts / this.totalattacks) * 100 ;
		
	}
	
	public double getWin_Percentage()
	{
		return win_percentage;
	}
	
	public Piece getCaptures(int index)
	{
		return this.captures[index];
	}
	public void setCaptures(Piece captures)
	{
		this.captures[enemycapts] = captures;
		this.captures[enemycapts].setImagename(captures.getImagename());
		addEnemyCapts();
	}
	
	public void setTotalAttacks()
	{
		this.totalattacks++;
	}
	
	public int getTotalAttacks()
	{
		return this.totalattacks;
	}
	
	public void setRescues(int rescues)
	{
		this.rescues++;
	}
	
	public int getRescues()
	{
		return this.rescues;
	}
	
	
	}