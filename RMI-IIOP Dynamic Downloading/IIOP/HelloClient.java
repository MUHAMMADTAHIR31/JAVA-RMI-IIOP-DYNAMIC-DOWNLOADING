import javax.naming.*; //InitialContext & Context
import javax.rmi.*;

public class HelloClient {
  
    public HelloClient()throws Exception{
		Context ic = new InitialContext();         
		
		Object objref = ic.lookup("HelloService");	// STEP 1: Get the Object reference from the Name Service using JNDI call.
		System.out.println("Client: Hello server.");
        
		HelloInterface hi = (HelloInterface) PortableRemoteObject.narrow(objref, HelloInterface.class);	// STEP 2: Narrow the object reference to the concrete type and  invoke the method.
		hi.sayHello("Client:How  are you..?");
	}
	
}