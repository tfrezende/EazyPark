package eazy;

import org.apache.log4j.BasicConfigurator;

import eazy.ui.MainInterface;

public class EazyPark {

	public static void main(String[] args) throws Exception {    
		
		BasicConfigurator.configure();		
	
		MainInterface mainInterface = new MainInterface();
		
		mainInterface.showMenu();
		
	}
	

}
