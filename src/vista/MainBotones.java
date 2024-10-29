package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.ModeloDominio.Usuario;

public class MainBotones extends JFrame{
	private Controller _ctrl;
	private Usuario _user = null;

	protected MainBotones(Controller ctrl, Usuario user){
		_ctrl = ctrl;
		_user = user;
		initGUI();
	}

	private void initGUI() {
		
		setIconImage(new ImageIcon("icons/main.png").getImage()); 
		setTitle("RedSerracines");
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		ControlPanel controlPanel = new ControlPanel(_ctrl, _user);
		mainPanel.add(controlPanel, BorderLayout.PAGE_START);
		
		FuncionesPanel funcionesPanel = new FuncionesPanel(_ctrl, _user);
		mainPanel.add(funcionesPanel, BorderLayout.CENTER);
	
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(600, 300);
		setLocationRelativeTo(null);
		setContentPane(mainPanel);
	}
}
