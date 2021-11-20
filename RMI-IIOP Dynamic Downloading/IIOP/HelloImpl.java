import javax.rmi.PortableRemoteObject;

public class HelloImpl extends PortableRemoteObject implements HelloInterface {
	public HelloImpl() throws java.rmi.RemoteException {
       super();     // invoke rmi linking and remote object initialization
	   //System.out.println("Hello");
	}

   public void sayHello(String from ) throws java.rmi.RemoteException {
       System.out.println( "Hello from " + from + "!!" );
   }
}