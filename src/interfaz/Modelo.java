package interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import modelo.*;

public class Modelo {
	
	private Cola<Proceso> procesos;
	private DefaultListModel<String> listaProcesos;
	private DefaultListModel<String> listaEjecucion;
	private int numeroProceso; 
	private Vista vista;
	private Procesador procesador;
	
	public Cola<Proceso> getProcesos() {
		return procesos;
	}
	
	public DefaultListModel<String> getListaProcesos() {
		return listaProcesos;
	}
	
	public DefaultListModel<String> getListaEjecucion() {
		return listaEjecucion;
	}
	
	public Vista getVista() {
		return vista;
	}
	
	public Modelo() {
		
		procesos = new Cola<Proceso>();
		
		numeroProceso = 1;
		
		vista = new Vista(this);
		
		listaProcesos = new DefaultListModel<String>();
		vista.getLstProcesos().setModel(listaProcesos);
		
		listaEjecucion = new DefaultListModel<String>();
		vista.getLstEjecucion().setModel(listaEjecucion);
		
	}
	
	
	public void agregarProceso() {
		
		int servicios = recibirServiciosProceso();

		if (servicios==0)
			return;
		
		procesos.encolar(new Proceso(servicios, "P" + numeroProceso));
		
		prepararListaRegistroProceso();
		listaProcesos.setElementAt("P" + numeroProceso + ", S" + servicios + "", 0);
		
		numeroProceso++;
		
	}
	
	public void agregarProceso(Proceso proceso) {
		
		procesos.encolar(proceso);
		
		prepararListaRegistroProceso();
		listaProcesos.setElementAt(proceso.getId() + ", S" + proceso.getServicios() + "", 0);
		
	}
	
	private int recibirServiciosProceso() {
		
		int t = 0;
		
		try {
			t = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de servicios del proceso."));
		} catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
		
		return t;
		
	}
	
	private void prepararListaRegistroProceso() {
		
		listaProcesos.addElement(""); // agrega un elemento vacio en la ultima posicion de la lista
		// corre los elementos una posicion abajo
		for(int i=procesos.tamanio(); i>1 && procesos.tamanio()!=1; i--) {
			listaProcesos.setElementAt(listaProcesos.get(i-2),i-1);
		}
		
	}
	
	public void eliminarProceso() {
		
		int index = vista.getLstProcesos().getSelectedIndex();
		String idProceso = "P" + listaProcesos.elementAt(index).charAt(1);
		listaProcesos.removeElementAt(index);
		
		Cola<Proceso> cola = new Cola<Proceso>();
		
		int length = procesos.tamanio();
		
		for(int i=0; i<length; i++) {
			Proceso proceso = procesos.desencolar();
			if( !(proceso.getId().equals(idProceso)) ) {
				cola.encolar(proceso);
			}
		}
		
		procesos = cola;

	}
	
	public void procesar() {

		if(procesador == null) {
			procesador = new Procesador(this, 3);
			procesador.start();
		}
		
	}
	
	public void salir() {
		
		System.exit(0);
		
	}
	
	// dar de alta, eliminar, mostrar, salir y proceso para realizar todas las tareas

}
