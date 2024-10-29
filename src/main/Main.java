package main;

import javax.swing.SwingUtilities;

import vista.MainGui;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new MainGui();
			}
		});
		
	}

}
