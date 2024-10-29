package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controller.Controller;
import model.ModeloDominio.Usuario;

public class ControlPanel extends JPanel{

	private Controller _ctrl;
	private JToolBar _toolBar;
	private JButton _quitButton, _accederButton, _modificarButton;
	private Usuario _user;

	public ControlPanel(Controller ctrl, Usuario user) {
		_ctrl = ctrl;
		_user = user;
		initGUI();
		
	}

	private void initGUI() {
		setLayout(new BorderLayout());
		_toolBar = new JToolBar();
		_toolBar.setBackground(new Color(120, 200, 255));
		add(_toolBar, BorderLayout.PAGE_START);
		
		JPanel panelImage = new JPanel();
		JLabel image = new JLabel();
		image.setIcon(new ImageIcon("icons/main.png"));
		panelImage.add(image);
		panelImage.add(new JLabel("RedSerracines"));
		panelImage.setPreferredSize(new Dimension(90,90));
		_toolBar.add(panelImage);
		_toolBar.addSeparator();	
		
		// Modificar Button
		createModificarButton(_toolBar);
		_toolBar.addSeparator();
		
		// Acceder Button
		createAccederButton(_toolBar);
		_toolBar.addSeparator();
		
		
		// Quit Button
		_toolBar.add(Box.createGlue()); // this aligns the button to the right
		createQuitButton(_toolBar);
		_toolBar.addSeparator();
		
	}

	private void createQuitButton(JToolBar _toolBar2) {
		_quitButton = createButton("Cerrar el programa", "salir.png");
		_quitButton.addActionListener((e) -> Utils.quit(this));
		_toolBar2.add(_quitButton);		
	}

	private JButton createButton(String toolTip, String icon) {
		JButton button = new JButton();
		
		button.setToolTipText(toolTip);
		button.setIcon(new ImageIcon("icons/" + icon ));
		button.setPreferredSize(new Dimension(60, 60));
		
		return button;
	}

	private void createModificarButton(JToolBar _toolBar2) {
		_modificarButton = createButton("Modificar tu usuario", "modificar.png");
		_modificarButton.addActionListener((e) ->{
			//Clase parecida al registerView pero con 3 botones y campos rellenados ya con el usuario que ha iniciado sesion
			new UsuarioView(_ctrl, _user);
		});
		_toolBar2.add(_modificarButton);	
		
	}

	private void createAccederButton(JToolBar _toolBar2) {
		_accederButton = createButton("Volver al inicio de sesion", "home.png");
		_accederButton.addActionListener((e) -> {
			setVisible(false);
			new Acceder(_ctrl);
		});
		_toolBar2.add(_accederButton);	
		
	}

}
