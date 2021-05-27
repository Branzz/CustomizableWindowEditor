/*************************************************
  File: AlohaClient.java
  Author: Brock D. Boyer
  Date: 12/09/97
  Class: CS555 - Dr. Pinkowski
  Description:  These classes attach to the 
		Aloha simulation server and display the
		results of the simulation.
**************************************************/

import java.net.*;
import java.io.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class AlohaClient extends Applet implements ActionListener {
	private Frame ClientFrame;
	private TextArea ResultsList;
	private Button StartClientButton;
	static final int SERVER_PORT=5555;
	InputStream input = null;
	PrintWriter output = null;
	InputStreamReader inStream;
	OutputStreamWriter outStream;

// ---
	protected Label RateTransLabel;
	protected Label NumTransLabel;
	protected Label RateServiceLable;
	protected Choice NumToTransChoice;
	protected Choice ServRateChoice;
	protected Choice TransRateChoice;
	private Button RunSimButton;
	private Button StopSimButton;
	private Button ExitButton;

	// ---------------------------
	// Construct GUI.
	// ---------------------------
	private void makeGUI(Frame curFrame)
	{
		
		

		// Make container panel.
		Panel containerPanel = new Panel();

		// Set layout manager.
	  containerPanel.setLayout( null );

		// Add components.
		RateTransLabel = new Label( "Rate of transmissions:  ", Label.RIGHT );
		RateTransLabel.setBounds( new Rectangle( new Dimension( 243, 46 ) ) ); 
		RateTransLabel.setLocation( 11, 73 );
		containerPanel.add( RateTransLabel );
		RateTransLabel.setBackground( new Color( 64, 64, 64 ) );
		RateTransLabel.setForeground( new Color( 255, 255, 255 ) );
		RateTransLabel.setEnabled( true );
		RateTransLabel.setVisible( true );
		NumTransLabel = new Label( "Number of transmissions to attempt:  ", Label.RIGHT );
		NumTransLabel.setBounds( new Rectangle( new Dimension( 243, 46 ) ) ); 
		NumTransLabel.setLocation( 11, 9 );
		containerPanel.add( NumTransLabel );
		NumTransLabel.setBackground( new Color( 64, 64, 64 ) );
		NumTransLabel.setForeground( new Color( 255, 255, 255 ) );
		NumTransLabel.setEnabled( true );
		NumTransLabel.setVisible( true );
		RateServiceLable = new Label( "Rate of service:  ", Label.RIGHT );
		RateServiceLable.setBounds( new Rectangle( new Dimension( 243, 46 ) ) ); 
		RateServiceLable.setLocation( 11, 137 );
		containerPanel.add( RateServiceLable );
		RateServiceLable.setBackground( new Color( 64, 64, 64 ) );
		RateServiceLable.setForeground( new Color( 255, 255, 255 ) );
		RateServiceLable.setEnabled( true );
		RateServiceLable.setVisible( true );
		NumToTransChoice = new Choice();
		NumToTransChoice.setBounds( new Rectangle( new Dimension( 84, 46 ) ) ); 
		NumToTransChoice.setLocation( 276, 9 );
		containerPanel.add( NumToTransChoice );
		NumToTransChoice.setBackground( new Color( 255, 255, 255 ) );
		NumToTransChoice.setForeground( new Color( 0, 0, 0 ) );
		NumToTransChoice.setEnabled( true );
		NumToTransChoice.setVisible( true );
		NumToTransChoice.addItem( "10" );
		NumToTransChoice.addItem( "500" );
		NumToTransChoice.addItem( "1000" );
		NumToTransChoice.addItem( "15000" );
		NumToTransChoice.addItem( "200000" );
		ServRateChoice = new Choice();
		ServRateChoice.setBounds( new Rectangle( new Dimension( 84, 46 ) ) ); 
		ServRateChoice.setLocation( 276, 137 );
		containerPanel.add( ServRateChoice );
		ServRateChoice.setBackground( new Color( 255, 255, 255 ) );
		ServRateChoice.setForeground( new Color( 0, 0, 0 ) );
		ServRateChoice.setEnabled( true );
		ServRateChoice.setVisible( true );
		ServRateChoice.addItem( "1" );
		ServRateChoice.addItem( "3" );
		ServRateChoice.addItem( "5" );
		ServRateChoice.addItem( "8" );
		ServRateChoice.addItem( "12" );
		ServRateChoice.addItem( "15" );
		ServRateChoice.addItem( "18" );
		ServRateChoice.addItem( "20" );
		TransRateChoice = new Choice();
		TransRateChoice.setBounds( new Rectangle( new Dimension( 84, 46 ) ) ); 
		TransRateChoice.setLocation( 276, 73 );
		containerPanel.add( TransRateChoice );
		TransRateChoice.setBackground( new Color( 255, 255, 255 ) );
		TransRateChoice.setForeground( new Color( 0, 0, 0 ) );
		TransRateChoice.setEnabled( true );
		TransRateChoice.setVisible( true );
		TransRateChoice.addItem( "1" );
		TransRateChoice.addItem( "3" );
		TransRateChoice.addItem( "5" );
		TransRateChoice.addItem( "8" );
		TransRateChoice.addItem( "12" );
		TransRateChoice.addItem( "15" );
		TransRateChoice.addItem( "18" );
		TransRateChoice.addItem( "20" );
		Button RunSimButton = new Button( "Run Simulation" );
		RunSimButton.setBounds( new Rectangle( new Dimension( 137, 46 ) ) ); 
		RunSimButton.setLocation( 11, 233 );
		containerPanel.add( RunSimButton );
		RunSimButton.setBackground( new Color( 192, 192, 192 ) );
		RunSimButton.setForeground( new Color( 0, 0, 0 ) );
		RunSimButton.setEnabled( true );
		RunSimButton.setVisible( true );
		StopSimButton = new Button( "Stop Simulation" );
		StopSimButton.setBounds( new Rectangle( new Dimension( 137, 46 ) ) ); 
		StopSimButton.setLocation( 170, 233 );
		containerPanel.add( StopSimButton );
		StopSimButton.setBackground( new Color( 192, 192, 192 ) );
		StopSimButton.setForeground( new Color( 0, 0, 0 ) );
		StopSimButton.setEnabled( true );
		StopSimButton.setVisible( true );
		ExitButton = new Button( "Exit" );
		ExitButton.setBounds( new Rectangle( new Dimension( 137, 46 ) ) ); 
		ExitButton.setLocation( 329, 233 );
		containerPanel.add( ExitButton );
		ExitButton.setBackground( new Color( 192, 192, 192 ) );
		ExitButton.setForeground( new Color( 0, 0, 0 ) );
		ExitButton.setEnabled( true );
		ExitButton.setVisible( true );

RunSimButton.addActionListener( this );
StopSimButton.addActionListener( this );
ExitButton.addActionListener( this );


		// Add container panel
		curFrame.add( containerPanel );

		// End MakeGUI

	curFrame.setVisible( true );
	// --

	}
	
	public void init() {
		//StartClientButton = new Button ( "Start Client" );
		//add( StartClientButton );
		//StartClientButton.addActionListener( this );
		ClientFrame = new Frame( "Simple Aloha Simulation Results" );
		ClientFrame.addWindowListener( new CloseWindow() );
    ClientFrame.setSize(400, 400);
    ResultsList = new TextArea("", 10, 40);
		ClientFrame.add( ResultsList );
	  ResultsList.setEditable( false );
	}
	
	public void actionPerformed( ActionEvent e ){
			// ** use the following to debug event name
			//  System.out.println(e.getActionCommand());
	  if (e.getActionCommand() == "Stop Simulation"){
			ResultsList.append("Halted...");
		   }
 	  if (e.getActionCommand() == "Exit"){
		  	System.exit( 0 );
		   }

		if (e.getActionCommand() == "Run Simulation"){
				ResultsList.setText( "" ); 
				ClientFrame.setVisible( true );
				byte bytes[] = new byte[4096];
				Socket server = null;
				int c;
	  			
     try {
				server = new Socket("127.0.0.1", SERVER_PORT);
				input = server.getInputStream();
			
				ResultsList.append("Server found on IP " + server.getInetAddress() +" port "+ server.getPort() + ".\n");
				output = new PrintWriter(server.getOutputStream());
					
				int nbytes;
				char cbuff[] = new char[1024];
				inStream = new InputStreamReader(input);
			 
			  while((nbytes = inStream.read(cbuff,0,1024))!= -1){
					String str = new String(cbuff,0,nbytes);
					ResultsList.append(str);
				}                        
			  ResultsList.append("Successful run...");
		   }
    catch(Exception exception) {
            System.err.println("Error: " + exception);
            try {
            	server.close();
            }
            catch(Exception myException){
                    System.err.println("Error: " + myException);
            }
       }
    }
	}
	
	public static void main( String args[] ){		
		
    AlohaClient AC = new AlohaClient();
		Frame app = new Frame( "Aloha Client" );
		app.setSize(425, 375);
		app.addWindowListener(new CloseWindowAndExit());
		app.addWindowListener(new CloseWindow());

		AC.init();
		AC.start();
		app.add(AC, BorderLayout.CENTER);
		
		// Set up component.
		app.setBackground( new Color( 192, 192, 192 ) );
		app.setResizable( true );
    AC.makeGUI( app );		

	}
}

class CloseWindowAndExit extends WindowAdapter {
	public void windowClosing(WindowEvent e){
    System.exit( 0 );
 		} 
	}
	
class CloseWindow extends WindowAdapter {
	public void windowClosing(WindowEvent e){
		e.getWindow().setVisible( false );
	}
}