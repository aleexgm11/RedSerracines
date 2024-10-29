package vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import controller.Controller;
import model.ModeloDominio.Administrador;
import model.ModeloDominio.Cliente;
import model.ModeloDominio.GenerateRandom;
import model.ModeloDominio.Usuario;
import model.ModeloDominio.Veterinario;

public class RegisterView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private MainGui mainGui;
	
	private JPanel panelPrincipal = new JPanel();
	private JPanel datos;
	private JPanel usuario;
	private JPanel tipo;
	private JPanel buttonsPanel;
	private JPanel seleccion;
	
	private String[] tipos = {"Cliente", "Administrador", "Veterinario"};
	private String[] headers = {"Informacion extra", "Datos del usuario"};
	private String[] veterinarias;
	
	private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtDni;
    private JPasswordField txtContrasena;
    
    private DefaultTableModel tabla;
    
    private JComboBox<String> tipoBox;
    private JComboBox<String> veterinariasBox;
	private JButton okButton;
	private JButton cancelButton;
	
    @SuppressWarnings("exports")
	public RegisterView(Frame frame, Controller ct) {
    	super(frame);
    	this._ctrl=ct;
    	this.datos= createPanel();
    	this.usuario= createPanel();
    	this.tipo= createPanel();
    	this.buttonsPanel= createPanel();
    	this.seleccion= createPanel();
    	this.okButton = new JButton("Registrar");
    	this.cancelButton = new JButton("Cancelar");
		initDialog();
		
    }
    
    private JPanel createPanel() {
    	return new JPanel(new FlowLayout(FlowLayout.CENTER));
    }
    
    @SuppressWarnings("serial")
	private void initDialog() {
        setTitle("Registro de Usuario");
        setIconImage(new ImageIcon("icons/login1.png").getImage());
        
        //Nombre
        JPanel nombrePanel = new JPanel();
		nombrePanel.setLayout(new BoxLayout(nombrePanel, BoxLayout.PAGE_AXIS));
		nombrePanel.add(Box.createRigidArea(new Dimension(150, 20)));
		nombrePanel.add(new JLabel("Nombre:"));
		txtNombre = new JTextField(20);
		PlainDocument documentName = new PlainDocument(); // esto genera un documento para setear el maximo de caracteres de un textField
		documentName.setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException{
				String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
				
				if(string.length() <= 20) {
					  super.replace(fb, offset, length, text, attrs);
				}
			}
		});
		txtNombre.setDocument(documentName);
		txtNombre.setMinimumSize(new Dimension(150, 20));
		txtNombre.setPreferredSize(new Dimension(150, 20));
		nombrePanel.add(txtNombre);
				
		//Contrasena
		JPanel contrasenaPanel = new JPanel();
		contrasenaPanel.setLayout(new BoxLayout(contrasenaPanel, BoxLayout.PAGE_AXIS));
		contrasenaPanel.add(Box.createRigidArea(new Dimension(150, 20)));
		contrasenaPanel.add(new JLabel("Contrasena: "));
		txtContrasena = new JPasswordField(15);
		PlainDocument documentPassword = new PlainDocument(); // esto genera un documento para setear el maximo de caracteres de un textField
		documentPassword.setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException{
				String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
				
				if(string.length() <= 15) {
					  super.replace(fb, offset, length, text, attrs);
				}
			}
		});
		txtContrasena.setDocument(documentPassword);
		txtContrasena.setMinimumSize(new Dimension(150, 20));
		txtContrasena.setPreferredSize(new Dimension(150, 20));
		contrasenaPanel.add(txtContrasena);
		        
        //Telefono
        JPanel telefonoPanel = new JPanel();
		telefonoPanel.setLayout(new BoxLayout(telefonoPanel, BoxLayout.PAGE_AXIS));
		telefonoPanel.add(Box.createRigidArea(new Dimension(150, 20)));
		telefonoPanel.add(new JLabel("Telefono:"));
		txtTelefono = new JTextField(9);
		PlainDocument documentTelefono = new PlainDocument(); // esto genera un documento para setear el maximo de caracteres de un textField
		documentTelefono.setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException{
				String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
				
				if(string.length() <= 9) {
					  super.replace(fb, offset, length, text, attrs);
				}
			}
		});
		txtTelefono.setDocument(documentTelefono);
		txtTelefono.setMinimumSize(new Dimension(150, 20));
		txtTelefono.setPreferredSize(new Dimension(150, 20));
		telefonoPanel.add(txtTelefono);
		
		//DNI
		JPanel dniPanel = new JPanel();
		dniPanel.setLayout(new BoxLayout(dniPanel, BoxLayout.PAGE_AXIS));
		dniPanel.add(Box.createRigidArea(new Dimension(150, 20)));
		dniPanel.add(new JLabel("DNI: "));
		txtDni = new JTextField(10);
		PlainDocument documentDni = new PlainDocument(); // esto genera un documento para setear el maximo de caracteres de un textField
		documentDni.setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException{
				String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
				
				if(string.length() <= 10) {
					  super.replace(fb, offset, length, text, attrs);
				}
			}
		});
		txtDni.setDocument(documentDni);
		txtDni.setMinimumSize(new Dimension(150, 20));
		txtDni.setPreferredSize(new Dimension(150, 20));
		dniPanel.add(txtDni);
		
		//Tipo de usuario
		JPanel tipoUsuarioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tipoUsuarioPanel.add(new JLabel("Tipo de Usuario: "));
		tipoBox = new JComboBox<String>(tipos);
		tipoUsuarioPanel.add(tipoBox);
		
		//Seleccion de veterinaria
		veterinarias = _ctrl.getVeterinariasInfo();
		JPanel seleccionVetPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		seleccionVetPanel.add(new JLabel("Veterinarias: "));
		veterinariasBox = new JComboBox<String>(veterinarias);
		seleccionVetPanel.add(veterinariasBox);
				
		//Tabla de datos segun el tipo de usuario
		tabla = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
			
				//  hacer editable solo la columna 1
				return column == 1;
			}
		};
		tabla.setColumnIdentifiers(headers);
		JTable extraInfo = new JTable(tabla);
		extraInfo.setSize(new Dimension(150, 20));
		JScrollPane scroll = new JScrollPane(extraInfo);
		scroll.setPreferredSize(new Dimension(400, 100));
		
		tipoBox.addActionListener((e) -> tipoBoxListener(tipoBox));
		
		usuario.add(dniPanel);
		usuario.add(contrasenaPanel);
		datos.add(nombrePanel);
		datos.add(telefonoPanel);
		seleccion.add(tipoUsuarioPanel);
		seleccion.add(seleccionVetPanel);
		tipo.add(scroll);

		//Botones
		cancelButton.addActionListener((e) -> cancelListener());
		buttonsPanel.add(cancelButton);
		okButton.addActionListener((e) -> okListener());
		buttonsPanel.add(okButton);
		
		
        panelPrincipal.add(usuario);
        panelPrincipal.add(datos);
        panelPrincipal.add(seleccion);
        panelPrincipal.add(tipo);
        panelPrincipal.add(buttonsPanel);

        setPreferredSize(new Dimension(500, 400));
        setContentPane(panelPrincipal);
        pack();
        if(getParent() != null)
			setLocation(getParent().getLocation().x + getParent().getWidth() / 2 - getWidth() / 2, getParent().getLocation().y + getParent().getHeight() / 2 - getHeight() / 2);
        setVisible(true);
    }
    
    private void okListener() {    	
    	String tipo = tipoBox.getSelectedItem().toString();
    	Usuario user = null;
    	String vet = veterinariasBox.getSelectedItem().toString();
    	long selectedVet = _ctrl.buscarVeterinaria(vet);
    	
    	// atributos
    	String nombre = txtNombre.getText();
    	String contra = new String(txtContrasena.getPassword());
    	int telefono = Integer.parseInt(txtTelefono.getText());
    	String dni = txtDni.getText();
    	
    	switch(tipo){
    	case "Cliente":
    		user = new Cliente(GenerateRandom.getRandom(), selectedVet, nombre, 
    				contra, telefono, dni);
    		break;
    		
    	case "Administrador":
    		
    		int numUsuario = Integer.parseInt(tabla.getValueAt(2, 1).toString().trim());
    		
    		user = new Administrador(GenerateRandom.getRandom(), selectedVet, nombre, contra,
    				telefono, dni, numUsuario);
    		break;
    		
    	case "Veterinario":
    		
    		long licencia = Long.parseLong(tabla.getValueAt(0, 1).toString().trim());
    		int consulta = Integer.parseInt(tabla.getValueAt(1, 1).toString().trim());
    		String especialidad = tabla.getValueAt(2, 1).toString().trim();
    		
    		user = new Veterinario(GenerateRandom.getRandom(), selectedVet, nombre, contra,
    				telefono, dni, licencia, consulta, especialidad);
    		break;
    	}
    	
    	if(_ctrl.buscarUsuario(user.getDni()) == null && _ctrl.altaUsuario(user)) {
    		//mainGui.changeWindow(new StartView(_ctrl));
    	}
    	
    	else
    		JOptionPane.showMessageDialog(this, "Usuario invalido");
    	
	}

	private void cancelListener() {
		setVisible(false);
	}

	private void tipoBoxListener(JComboBox<String> tipoBox) {
		int selectedTipoIndex = tipoBox.getSelectedIndex();
		
		tabla.setRowCount(0);
		switch (selectedTipoIndex) {
		case 0: //Cliente
			break;
		case 1: //Administrador
			tabla.addRow(new Object[] {"Numero de usuario", " "});
			break;
		case 2: //Veterinario
			tabla.addRow(new Object[] {"Licencia", " "});
			tabla.addRow(new Object[] {"Consulta", " "});
			tabla.addRow(new Object[] {"Especialidad", " "});
			break;
		}
		
		
	}

	


}
