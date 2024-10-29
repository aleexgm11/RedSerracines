package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class MainGui extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Controller _ctrl; 
	public MainGui() {
		super("Red Serracines");
		this._ctrl = new Controller();
		initGui();
	}
	
	private void initGui() {
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		Image icon = new ImageIcon("icons/main.png").getImage();
		ImageIcon icon2 = new ImageIcon("icons/mainGrande.png");
		setIconImage(icon);
		
		JPanel panelTitle = new JPanel();
		JLabel mainTitle = new JLabel("RedSerracines");
		mainTitle.setFont(new Font("Arial", Font.BOLD, 45));
		panelTitle.add(mainTitle);
		panelTitle.setMaximumSize(new Dimension(400, 100));
		mainPanel.add(panelTitle);
		
		JPanel panelImage = new JPanel();
		JLabel imageMain = new JLabel();
		imageMain.setIcon(icon2);
		panelImage.add(imageMain);
		panelImage.setPreferredSize(new Dimension(300,300));
		mainPanel.add(panelImage);
		
		JPanel buttonPanel = new JPanel();
		JButton initButton = new JButton("Acceder");
		JButton exitButton = new JButton("Salir");
		initButton.addActionListener((e)-> {
			setVisible(false);
			new Acceder(_ctrl);
		});
		exitButton.addActionListener((e)->{dispose();});
		buttonPanel.add(initButton);
		buttonPanel.add(exitButton);
		//buttonPanel.setMaximumSize(new Dimension(500, 200));
		mainPanel.add(buttonPanel);
		//this.addWindowListener(null);
		
		add(mainPanel);
		pack();
		setVisible(true);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setContentPane(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void changeWindow(JPanel p) {
		getContentPane().removeAll();

        getContentPane().add(p);

        validate();
        repaint();
	}
	

}
