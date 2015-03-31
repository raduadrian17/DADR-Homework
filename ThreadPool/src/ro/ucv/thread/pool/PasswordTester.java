package ro.ucv.thread.pool;

import java.security.MessageDigest;
import java.util.concurrent.Callable;

import javax.swing.JOptionPane;


public class PasswordTester implements Callable<String> {

	String myName="";
	int intervalStart;
	int intervalStop;
	String hash;
	//TODO: check off all the todos
	
	/**
	 * TODO: this constructor should receive an interval where to generate passwords 
	 * and the password hash 
	 * TODO: all three parameters must be saved locally just like name
	 * 
	 * @param intervalStart int
	 * @param intervalEnd int
	 * @param hash String
	 * @param name name of the PasswordTester instance
	 */
	
	public PasswordTester(int _intervalStart, int _intervalStop, String _hash,String _name) 
	{
		intervalStart = _intervalStart;
		intervalStop = _intervalStop;
		hash = _hash;
		myName = _name;
	}
	
	
	
	
	@Override
	public String call() throws Exception {
		
		System.out.println(myName+Thread.currentThread().getId()+": i'm starting");
		
		//TODO: all passwords from intervalStart to intervalEnd must be hashed using sha256 
		//TODO: and checked if their sha256 hash is equal to  the locally saved hash from the constructor
		
		for(int i=intervalStart;i<intervalStop;i++)
		{
			//System.out.println(myName+Thread.currentThread().getId()+": i="+i);
			if(sha256(i).equals(hash))
			{
				System.out.println(i);
				
				System.out.println(myName+": i finished ! " + i);
//				JOptionPane.showMessageDialog(null, myName+": i finished ! " + i);
				return myName+": i finished ! " + i;
				
//				System.exit(0);
			}	
			
		}
		
		return "No password found"; 
		//return null;
	}
	
	
	String sha256(int possiblePassword) {
		 try{
		        MessageDigest digest = MessageDigest.getInstance("SHA-256");
		        byte[] hash = digest.digest((""+possiblePassword).getBytes("UTF-8"));
		        StringBuffer hexString = new StringBuffer();

		        for (int i = 0; i < hash.length; i++) {
		            String hex = Integer.toHexString(0xff & hash[i]);
		            if(hex.length() == 1) hexString.append('0');
		            hexString.append(hex);
		        }

		        return hexString.toString();
		    } catch(Exception ex){
		       throw new RuntimeException(ex);
		    }
	}

}
