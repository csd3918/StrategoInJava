package Utilities;

import MVC.Model.*;
import java.lang.Math;

public class RandomizePieces {

	
public static Piece[] RandomizePieceArray(Piece[] pieces, boolean ReducedArmy) {
	boolean	reduce = ReducedArmy; 
	
	return getmakeRandom(pieces, reduce);
	
}
	// Better random
	//(rand() % (upp_index_limit - low_index_limit + 1)) + low_index_limit;
		
	
	public static  Piece[] getmakeRandom(Piece[] pieces, boolean provlima) {
				
		Piece tmppiece;
		int i = 0, max = 15;
		int range = max - i + 1;
		
		
		for( i = 0; i < 16; i++) {
			range = max - i + 1;
			int rand = (int) (Math.random() * range);
			
			tmppiece = pieces[i];
			pieces[i] = pieces[rand];
			pieces[rand] = tmppiece;
		}
		
		if(!provlima) {
			max = 29;
			for( i = 16; i < 30; i++) 
			{
				range = max - i + 1;
				int rand = (int) (Math.random() * range) + i;
				
				tmppiece = pieces[i];
				pieces[i] = pieces[rand];
				pieces[rand] = tmppiece;				
			}
		}
				
			
		max  = 45;
		
		for(i = 30; i < 46; i++)
		{			
			range = max - i + 1;
			int rand = (int) (Math.random() * range);
			
			tmppiece = pieces[i];
			pieces[i] = pieces[rand];
			pieces[rand] = tmppiece;
		}
		
		if(!provlima) {
			max = 59;
			
			for(i = 46; i < 60; i++) 
			{
				range = max - i + 1;
				
				int rand = (int) (Math.random() * range);
				
				tmppiece = pieces[i];
				pieces[i] = pieces[rand];
				pieces[rand] = tmppiece;
			}
		}
		
		return pieces;	

}
	}
