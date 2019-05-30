package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControladorBotones implements ActionListener{
	
	private Vista vista;
	
	public ControladorBotones(Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton boton = (JButton) e.getSource();
		
		if(boton == vista.getBtnCrear()) {
			vista.getModelo().agregarProceso();
		}
		
		if(boton == vista.getBtnEliminar()) {
			vista.getModelo().eliminarProceso();
		}
		
	}

}
