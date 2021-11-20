import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class DynamicClient {
	
	public static void  main( String args[] )throws Exception {
	
		if(System.getSecurityManager()==null)
		System.setSecurityManager(new RMISecurityManager());

		Properties p=System.getProperties();
		String url=p.getProperty("java.rmi.server.code");

		try{
			Class client=RMIClassLoader.loadClass(url,"HelloClient");
			client.newInstance();
		}catch(Exception e){
			e.printStackTrace();        
		}   
	}
}	