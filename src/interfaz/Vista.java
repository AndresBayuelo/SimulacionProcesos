package interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Vista extends JFrame {
	
	private Border border;
	
	private JList lstProcesos;
	private JList lstEjecucion;
	private JMenuItem itmProcesar;
	private JMenuItem itmSalir;
	private JButton btnCrear;
	private JButton btnEliminar;
	
	private ControladorItmMenu controladorItmMenu;
	private ControladorBotones controladorBotones;
	private Modelo modelo;
	
	public ControladorItmMenu getControladorItmMenu() {
        if(controladorItmMenu == null)
        	controladorItmMenu = new ControladorItmMenu(this);
        return controladorItmMenu;
    }
	
	public ControladorBotones getControladorBotones() {
        if(controladorBotones == null)
        	controladorBotones = new ControladorBotones(this);
        return controladorBotones;
    }
	
	public Modelo getModelo() {
		return this.modelo;
	}
	
	public JList getLstProcesos() {
		return lstProcesos;
	}
	
	public JList getLstEjecucion() {
		return lstEjecucion;
	}
	
	public JMenuItem getItmProcesar() {
		return itmProcesar;
	}
	
	public JMenuItem getItmSalir() {
		return itmSalir;
	}
	
	public JButton getBtnCrear() {
		return btnCrear;
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	public Vista(Modelo modelo) {
		
		// titulo de la ventana
		super("Asignador de Tareas");
		
		this.modelo = modelo;
		
		configurarVentana();
		
		this.setJMenuBar(crearBarraMenu());
		
		// tipo de borde para casa JPanel
		border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		// panel de contencion
		Container contenedor = getContentPane();
		
		// seteo layout		
		contenedor.setLayout(new GridLayout(2,1));
		
		contenedor.add(crearPanelTareas());
		contenedor.add(crearPanelEjecucion());
		
		actionListeners();
		
		// visibilidad de la ventana
		setVisible(true);
		
	}
	
	public void configurarVentana(){
		
		// tamaño de la ventana
		setSize(300,380);
		
		// redimencion la ventana
		setResizable(false);
		
		// posicion de la ventana
        setLocationRelativeTo(null);
        
        // proceso al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private JMenuBar crearBarraMenu() {
		
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menuArchivo = new JMenu("Archivo");
		
		itmProcesar = new JMenuItem("Procesar");
		itmSalir = new JMenuItem("Salir");
		
		menuArchivo.add(itmProcesar);
		menuArchivo.add(itmSalir);
		
		barraMenu.add(menuArchivo);
		
		return barraMenu;
		
	}
	
	private JPanel crearPanelTareas() {
		
		JPanel p = new JPanel(new GridLayout(1,2));
		
		// titulo del borde
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Tareas");
		
		// asignación del titulo del borde al panel
		p.setBorder(titleBorder);
		
		lstProcesos = new JList();
		p.add(new JScrollPane(lstProcesos));
		
		p.add(crearPanelBotones());
		
		return p;
		
	}
	
	private JPanel crearPanelBotones() {
		
		JPanel p = new JPanel(new GridLayout(2,1));
		
		btnCrear = new JButton("Crear");
		p.add(btnCrear);
		
		btnEliminar = new JButton("Eliminar");
		p.add(btnEliminar);
		
		return p;
		
	}
	
	private JScrollPane crearPanelEjecucion() {
		
		JPanel p = new JPanel(new GridLayout(1,1));
		
		// titulo del borde
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Ejecución");
		
		// aignación del titulo del borde al panel
		p.setBorder(titleBorder);
		
		lstEjecucion = new JList();
		p.add(new JScrollPane(lstEjecucion));
		
		return new JScrollPane(p);
		
	}
	
	public void actionListeners() {
		
		itmProcesar.addActionListener(getControladorItmMenu());
		itmSalir.addActionListener(getControladorItmMenu());
		btnCrear.addActionListener(getControladorBotones());
		btnEliminar.addActionListener(getControladorBotones());
	}
	
}
