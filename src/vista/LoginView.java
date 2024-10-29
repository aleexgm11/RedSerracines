package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.ModeloDominio.Usuario;

public class LoginView extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelDialog;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel userPanel;
	private JLabel userLabel;
	private JTextField userField;
	private Controller _ctrl;

    public LoginView(Frame frame, Controller ct) {
        super (frame, true);
        this._ctrl = ct;
        initDialog();
        
    }

    public void initDialog() {
    	setTitle("Inicio de Sesión");
        setIconImage(new ImageIcon("icons/login1.png").getImage());
        
    	panelDialog = new JPanel(new BorderLayout());
        panelDialog.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //Usuario
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        userPanel = new JPanel();
        
        userLabel = new JLabel("Usuario");
        userLabel.setPreferredSize(new Dimension(100, 30));
        
        userField = new JTextField();
        userField.setPreferredSize(new Dimension(150, 20));
        
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.PAGE_AXIS));
        userPanel.add(userLabel);
        userPanel.add(userField);
        
        panel1.add(userPanel);
        
        
        //Contraseña
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel passwordPanel = new JPanel();
        
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setPreferredSize(new Dimension(100, 30));
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 20));
        
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.PAGE_AXIS));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        
        panel2.add(passwordPanel);

        //Confirmacion
        JButton loginButton = new JButton("Acceder");
        loginButton.addActionListener((e)->{
        	
//        	Usuario u = _ctrl.buscarUsuario(userField.getText());
//        	
//        	if(u != null) {
//        		
//        		String contra = new String(passwordField.getPassword());
//            	if(u.getContrasenya().equalsIgnoreCase(contra)) {
//            		new MainBotones(_ctrl, contenedor);
//            	}
//            	else {
//            		JOptionPane.showMessageDialog(this, "Contraseña no valida");
//            	}
//        	}
//        	
//        	else {
//        		JOptionPane.showMessageDialog(this, "Usuario no encontrado");
//        	}
        	setVisible(false);
        	new MainBotones(_ctrl, null); //poner el usuario que se crea en la clase
        });

        panelDialog.add(panel1, BorderLayout.NORTH);
        panelDialog.add(panel2, BorderLayout.CENTER);
        panelDialog.add(loginButton, BorderLayout.SOUTH);

        setContentPane(panelDialog);
        pack();
        if(getParent() != null)
			setLocation(getParent().getLocation().x + getParent().getWidth() / 2 - getWidth() / 2, getParent().getLocation().y + getParent().getHeight() / 2 - getHeight() / 2);
        setVisible(true);

    }
}
