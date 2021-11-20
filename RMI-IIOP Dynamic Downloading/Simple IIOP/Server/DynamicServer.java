import javax.naming.InitialContext;
import javax.naming.Context;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

public class DynamicServer {
   
	public static void main(String[] args)throws Exception {
       
		if(System.getSecurityManager()==null)
		System.setSecurityManager(new RMISecurityManager());

		Properties p=System.getProperties();
		String url=p.getProperty("java.rmi.server.codebase"); 
		
		Class server=RMIClassLoader.loadClass(url,"HelloImpl"); // Step 1: Instantiate the Hello servant

		Object obj=server.newInstance();	
		Remote remote=(Remote)obj;
		
		Context initialNamingContext = new InitialContext(); 	// Step 2: Publish the reference in the Naming Service  // using JNDI API
        initialNamingContext.rebind("HelloService", remote );
       

        System.out.println("Hello Server: Ready...");
    }
}