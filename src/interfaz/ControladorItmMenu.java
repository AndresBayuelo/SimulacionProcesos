package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ControladorItmMenu implements ActionListener{
	
	private Vista vista;
	
	public ControladorItmMenu(Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JMenuItem itmMenu = (JMenuItem) e.getSource();
		
		if(itmMenu == vista.getItmProcesar()) {
			vista.getModelo().procesar();
		}
		
		if(itmMenu == vista.getItmSalir()) {
			vista.getModelo().salir();
		}
		
	}
	
	

}
