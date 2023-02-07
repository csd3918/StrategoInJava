package MVC.Model;

import MVC.Controller.*;
import java.awt.Color;

/**This class concentrates the processes of the Board about 
 * rounds, Turns, captures of each player 
 * and the initialiazation of the game mode values 
 * 
 * @version B
 * @author George Vasileiadis
 * */
public class Board {
	
	private int Round;
	private int RCaptured,BCaptured;
	public static boolean redsturn;
	private boolean ReducedArmy = false;
	private boolean NoRetreat = false;
	
	private Piece[] BlueCaptured = new Piece[30];
	private Piece[] RedCaptured = new Piece[30];
	
	public Board(){
		
		Round = 1;
		RCaptured = 0;
		BCaptured = 0;
		
		redsturn = true;
		
		for(int i = 0; i<30; i++) {
			BlueCaptured[i] = new MovablePiece(0,Color.blue,1,"");
			RedCaptured[i] = new MovablePiece(0,Color.orange,2,"");
		}	
		
	}
	
	public void setRedsturn(boolean redsturn) {
		if(redsturn) redsturn = false;
		else redsturn = true;
	}
	
	public boolean getRedsturn() {
		return redsturn;
	}
	
	public void setReducedArmy(boolean ReducedArmy){
	        this.ReducedArmy = ReducedArmy;
	}

	public boolean getReducedArmy(){
	        return this.ReducedArmy;
	}

	public void setNoRetreat(boolean NoRetreat) {
		this.NoRetreat = NoRetreat;
	}
	
	public boolean getNoRetreat() {
		return this.NoRetreat;
	}
	
	
	public void addCaptures(Piece captured) {
		if(captured.getColor() == Controller.FireRed)
		{
			addRCaptured();
			this.RedCaptured[RCaptured].setGrade(captured.getGrade());
			this.RedCaptured[RCaptured].setColor(captured.getColor());
			this.RedCaptured[RCaptured].setSpecialID(captured.getSpecialID());
			this.RedCaptured[RCaptured].setImagename(captured.getImagename());
						
		}
		else if (captured.getColor() == Controller.IceBlue) 
		{
			addBCaptured();
			this.BlueCaptured[BCaptured].setGrade(captured.getGrade());
			this.BlueCaptured[BCaptured].setColor(captured.getColor());
			this.BlueCaptured[BCaptured].setSpecialID(captured.getSpecialID());
			this.BlueCaptured[BCaptured].setImagename(captured.getImagename());
					
		}
		
	}
	
	public void addBCaptured() { BCaptured++; }
	
	public void reduceBCaptured() { if((BCaptured-1) >= 0)BCaptured--;}
	
	public int getBCaptured() {return BCaptured;}
	
	public void addRCaptured() { RCaptured++; }
	
	public void reduceRCaptured() { if((RCaptured-1) >= 0) RCaptured--;}
	
	public int getRCaptured() {return RCaptured;}
	
	public void setRound() { Round++; }
	
	public int getRound() {	return Round; }	
	
}