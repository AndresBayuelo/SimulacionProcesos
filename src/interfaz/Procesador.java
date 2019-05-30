package interfaz;

import modelo.Proceso;

public class Procesador extends Thread {
	
	private Modelo modelo;
	private int serviciosXProceso;
	private boolean estado;
	
	public Procesador(Modelo modelo, int serviciosXProceso) {
		this.modelo = modelo;
		this.serviciosXProceso = serviciosXProceso;
	}
	
	public boolean getEstado() {
		return estado;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true) {

			if(modelo.getProcesos().tamanio()>0) {

				modelo.getListaProcesos().removeElementAt(modelo.getProcesos().tamanio() - 1);
				Proceso proceso = modelo.getProcesos().desencolar();
				int serviciosAtendidos = 0;

				if (proceso.getServicios() >= serviciosXProceso) {
					serviciosAtendidos = serviciosXProceso;
				} else if (proceso.getServicios() < serviciosXProceso) {
					serviciosAtendidos = proceso.getServicios();
				}

				proceso.setServicios(proceso.getServicios() - serviciosAtendidos);

				modelo.getListaEjecucion().addElement("" + proceso.getId() + ", S.Atendidos " + serviciosAtendidos);

				if (proceso.getServicios() > 0)
					modelo.agregarProceso(proceso);

			}else{

				System.out.println("Sin procesos en cola.");

			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
}
