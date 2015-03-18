package ro.ucv.main.interactive;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class GenerarePuncte {
	
	int randomLongitudine;
    int randomLatitudine;
    static ArrayList<Puncte> pcts =null;
    Puncte myPcp = null;
	
	public GenerarePuncte() 
	{
		pcts = new ArrayList<Puncte>();
		//myPcp = new Puncte();
	
	 //GenerarePuncte generator = new GenerarePuncte();
	 Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 100; ++idx)
	    {
	      int randomLongitudine = randomGenerator.nextInt(200);
	      int randomLatitudine = randomGenerator.nextInt(200);
	     // System.out.println("Lat: " + randomLatitudine);
	     // System.out.println("Log: " + randomLongitudine);
	      
	      myPcp = new Puncte();
	      myPcp.setLatitudine(randomLatitudine);
	      myPcp.setLongitudine(randomLongitudine);
	      
	      pcts.add(myPcp);
	      
	      
	    }
	   
	}
	    
	    public static ArrayList<Puncte> getPcts() {
		return pcts;
	}

	public void setPcts(ArrayList<Puncte> pcts) {
		this.pcts = pcts;
	}

//		public static void main (String[] args)
//	    {
//	    	new GenerarePuncte();
//	    	//System.out.println(getPcts);
//	    	ArrayList<Puncte> temp = new ArrayList<Puncte>();
//	    	temp = getPcts();
//	   // System.out.println(temp);
//	    	
//	    for(Puncte p: temp)
//	    {
//	    	System.out.println(p.getLatitudine() + " " + p.getLongitudine());
//	    }
//	    	
//	    }
	   
	
	    
}
