package bran.test.random; /*************************************************
**  File: SimpleAlohaServer.java
**  Author: Brock D. Boyer
**  Date: 11/21/97
**  For: CS555 - Dr. Pinkowski
**  Description:  These classes create and manage
**									a Simple Aloha network server.
**************************************************/
import java.net.*;
import java.io.*;
import java.util.Vector;

/*-------------------------------------------------
-  Class:    SimpleAlohaServer
-  Author: Brock D. Boyer
-  Modified: 12/09/97
-  Description:  The Main class which attaches to 
-  								a port and starts the listener.
--------------------------------------------------*/
class SimpleAlohaServer {
		private static final int SERVER_PORT=5554;
		private NetWatcher nw = null;
		
		// --- Constructor called on new
		public SimpleAlohaServer(int myPort) {
				// --- Initialize and start the network monitor
				nw = new NetWatcher(myPort);
			  nw.start();
 			  System.out.println("Listening on port " + myPort + ".");
 			  }
		
		public static void main(String args[]){
	    int myServer_Port;
	
	    // --- Check for port as argument, use default if not
	    try
	    {
	    	myServer_Port = Integer.parseInt(args[0],10);
	    }
	    catch(Exception MiscException)
	    {
	    	System.out.println("Setting port to default: " + SERVER_PORT);
	    	myServer_Port = SERVER_PORT;
	    }
	    
	    // --- Now use the constructor
	    new SimpleAlohaServer(myServer_Port);
	    }
}  // endclass



/*-------------------------------------------------
-  Class:		NetWatcher
-  Author: 	Brock D. Boyer
-  Modified:	12/09/97
-  Description:	Listen on a given port. If a client
									connects pass processing to 
									ServeClient.
--------------------------------------------------*/
class NetWatcher extends Thread {
	
	private static int ClientPort;

	// --- Use vector structure to manage the threads
	private static Vector ClientThreadVector = new Vector(5,2);
	private ServerSocket ListenSocket = null;

	// --- Constructor
	public NetWatcher(int myPort){
	ClientPort = myPort;
	}

	public void run(){
	  ListenForRequest();
	  }
	
	private void ListenForRequest()	{
	
		// --- First connect the listener socket
		try {
			ListenSocket = new ServerSocket(ClientPort);
			}
	  catch(Exception MiscException) {
	  	System.err.println("Error: " + MiscException);
	  	System.exit(1);
	  	}
	
	  ServeClient ServeThisClient = null;
	
	  // Continuously check for clients
	  while (true){
	  	try{
		  		Socket CurrentSocket = ListenSocket.accept();
		  		ServeThisClient = new ServeClient(CurrentSocket);
		  		ServeThisClient.start();
		  		ClientThreadVector.addElement(ServeThisClient);
		
		     //clean up the if client closes connection
		     for(int i=0;i<NetWatcher.ClientThreadVector.size();i++)
		     if(!((ServeClient)(ClientThreadVector.elementAt(i))).isAlive())
		         ClientThreadVector.removeElementAt(i);   
	      }
	    catch(Exception MiscException){
	    	System.err.println("Error: " + MiscException);
	    	}
	   }
	 }
}



/*-------------------------------------------------
-  Class:		ServeClient
-  Author: 	Brock D. Boyer
-  Modified:	12/09/97
-  Description:	Handle an individual client by
-									running the simulation and the
-									results to it.									
--------------------------------------------------*/
class ServeClient extends Thread
{
	private Socket ServeClientSocket;
  private PrintWriter MyOutputWriter;
  private InputStream MyInputWriter;
  OutputStreamWriter MyOutStream;

  public ServeClient(Socket CurrentSocket)
  {
  	ServeClientSocket = CurrentSocket;
  }

  
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
  Function:	RunSimulation
  Purpose:		Run the simulation and send results to client
  Date:			11/21/97
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
private void RunSimulation()
  {
  	
  	
  	System.out.println("Starting simulation for " + ServeClientSocket.getInetAddress() +":"+ ServeClientSocket.getPort());

	try {
	  
	  
	  MyOutputWriter.println("Welcome to the ALOHA network simulation");
		
		double r, sum = 0.0;
		int i, j, cnt = 1000;
		double packet_size, sum_r;
		
		for (i=1; i <= cnt; i++){
			sum_r = 0.0;
			for (j=1; j<=1200; j++) {
					r = Math.random();
					MyOutputWriter.print ("Random number "+i+","+j+": " + r + "\n");
					sum_r += r;
					}
			packet_size = 2 * (sum_r - 6) + 50;
			MyOutputWriter.print("Packet size " + i + ": " + packet_size + "\n");
			sum += packet_size;
		}
		MyOutputWriter.println("Average observed packet size: "+sum/cnt);
       }
  catch(Exception MiscException){
	  System.err.println( "Error: " + MiscException );
	  }

	  System.out.println("Completed simulation for " + ServeClientSocket.getInetAddress() +":"+ ServeClientSocket.getPort());

 }

  public void run()
  {
   System.out.println("Attached client " + ServeClientSocket.getInetAddress() +":"+ ServeClientSocket.getPort());
   
   try {
   	MyOutputWriter = new PrintWriter(ServeClientSocket.getOutputStream(), true);
   	MyInputWriter = ServeClientSocket.getInputStream();
   	
   	RunSimulation();
   	ServeClientSocket.close();
   	
   	}
	catch( SocketException socket_error ) {
         socket_error.printStackTrace();
         System.exit( 1 );
      }
    catch ( Exception MiscException ) {
   		System.err.println( "Error: " + MiscException );
   		}
   		
   		System.out.println("Detached client " + ServeClientSocket.getInetAddress() +":"+ ServeClientSocket.getPort());
   		stop();
  }
}

// ********************************************************
//  Function to compute statistical random numbers
// ********************************************************
//double exprand(x) double x; {return (x * (-log(1-Math.random())));