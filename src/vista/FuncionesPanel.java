package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controller.Controller;
import model.ModeloDominio.Usuario;

public class FuncionesPanel extends JPanel{

	private Controller _ctrl;
	private JToolBar _toolBar;
	private JButton _citaButton, _veterinariasButton, _mascotasButton, _informesButton;
	private Usuario _user;

	public FuncionesPanel(Controller ctrl, Usuario user) {
		_ctrl = ctrl;
		_user = user;
		//_tipo = user.getTipo();
		initGUI();
		
	}

	private void initGUI() {
		setLayout(new BorderLayout());
		_toolBar = new JToolBar();
		add(_toolBar);
		
		// Citas Button
		createCitasButton(_toolBar);
		_toolBar.addSeparator();
		_toolBar.addSeparator();

		
		// Mascotas Button
		createMascotasButton(_toolBar);
		_toolBar.addSeparator();		
		_toolBar.addSeparator();

		
		// Veterinarias Button
		createVeterinariasButton(_toolBar);
		_toolBar.addSeparator();
		_toolBar.addSeparator();

		
		// Informes Button
		createInformesButton(_toolBar);
		_toolBar.addSeparator();
		_toolBar.addSeparator();

		
		//enableButtons();
		
	}

	private void createInformesButton(JToolBar _toolBar2) {
		_informesButton= createButton("Informes", "informe.png");
		_informesButton.addActionListener((e) -> {
			//Clase para consultar informes que tienes sobre tus mascotas
		});
		_toolBar2.add(_informesButton);			
	}

	private void createMascotasButton(JToolBar _toolBar2) {
		_mascotasButton= createButton("Mascotas", "mascotas.png");
		_mascotasButton.addActionListener((e) -> {
			//Clase para pedir consultar añadir o modificar datos sobre mascotas que tienes
		});
		_toolBar2.add(_mascotasButton);		
	}

	private JButton createButton(String toolTip, String icon) {
		JButton button = new JButton();
		
		button.setText(toolTip);
		button.setIcon(new ImageIcon("icons/" + icon ));
		button.setSize(new Dimension(70, 30));
		
		return button;
	}

	private void createCitasButton(JToolBar _toolBar2) {
		_citaButton = createButton("Citas", "cita.png");
		_citaButton.addActionListener((e) ->{
			//Clase para pedir consultar modificar o eliminar una cita
			//Se puedeen añadir informes en la cita del medico 
		});
		_toolBar2.add(_citaButton);	
		
	}

	private void createVeterinariasButton(JToolBar _toolBar2) {
		_veterinariasButton = createButton("Veterinarias", "veterinaria.png");
		_veterinariasButton.addActionListener((e) -> {
			//clase para ver consultar pedir añadir o eliminar veteriarias
		});
		_toolBar2.add(_veterinariasButton);	
		
	}
	
	private void enableButtons() {
		switch (_user.getTipo()){
		case "VETERINARIO":
			_citaButton.setEnabled(true);
			_mascotasButton.setEnabled(false);
			_veterinariasButton.setEnabled(false);
			_informesButton.setEnabled(true);
			break;
		case "CLIENTE":
			_citaButton.setEnabled(true);
			_mascotasButton.setEnabled(false);
			_veterinariasButton.setEnabled(false);
			_informesButton.setEnabled(true);
			break;
		
		case "ADMINISTRADOR":
			_citaButton.setEnabled(false);
			_mascotasButton.setEnabled(false);
			_veterinariasButton.setEnabled(true);
			_informesButton.setEnabled(false);
			break;
		}
		
			
	}

}
