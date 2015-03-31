package ro.ucv.thread.pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

public class RunMe {
	
	public static void main(String[] args) {
		
		int threadCount=12;
		String hash = "ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f";
		
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		
		Collection collection = new ArrayList<PasswordTester>( );
		
		
		for(int i=1; i<= threadCount; i++){
			
			//TODO: divide your problem into manageable intervals here
			
		   //PasswordTester task = new PasswordTester("Johnny"+i+"_");
			PasswordTester task = new PasswordTester(i*1000000, i*1000000 + 999999, hash, "Johnny"+i+"_");
		   collection.add(task);
		  }
		
		try {
			//this is called when one of the threads returns something other than null
			// all other threads are canceled
			String f=executor.invokeAny(collection);
			System.out.println("Finished  - "+f);
			JOptionPane.showMessageDialog(null, f);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		executor.shutdown();
		
	}

}
