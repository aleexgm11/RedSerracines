package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class Acceder extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel acceder;
	private Image icon;
	private ImageIcon icon2;
	private JPanel panelTitle;
	private JLabel mainTitle;
	private JPanel panelImage;
	private JLabel imageLogin;
	private JButton loginButton;
	private JButton registerButton;
	private Controller _ctlr;

	public Acceder(Controller c) {
		this._ctlr = c;
		initAcceder();
	}
	
	private void initAcceder() {
		
		acceder = new JPanel();
		acceder.setLayout(new BoxLayout(acceder, BoxLayout.PAGE_AXIS));
		
		icon = new ImageIcon("icons/main.png").getImage();
		icon2 = new ImageIcon("icons/login.jpg");
		setIconImage(icon);
		setTitle("Acceso");
		panelImage = new JPanel();
		imageLogin = new JLabel();
		imageLogin.setIcon(icon2);
		panelImage.add(imageLogin);
		panelImage.setPreferredSize(new Dimension(300,300));
		
		acceder.add(panelImage);
		
		panelTitle = new JPanel();
		mainTitle = new JLabel("Inicie sesión o registrese");
		mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
		panelTitle.add(mainTitle);
		panelTitle.setMaximumSize(new Dimension(400, 100));
		
		acceder.add(panelTitle);
		
		JPanel buttonPanel = new JPanel();
		loginButton = new JButton("Inicio de Sesión");
		registerButton = new JButton("Registro de Usuario");
		loginButton.addActionListener((e)->{
			setVisible(false);
			new LoginView(this,_ctlr);
		});
		registerButton.addActionListener((e)->{
			setVisible(false);
			new RegisterView(this,_ctlr);
		});
		buttonPanel.add(loginButton);
		buttonPanel.add(registerButton);
		
		acceder.add(buttonPanel);
		
		add(acceder);
		pack();
		setVisible(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setContentPane(acceder);
	}
}
