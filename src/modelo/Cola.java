package modelo;

public class Cola<T> {
	
	private Nodo<T> primero = null;
	private Nodo<T> ultimo = null;
	
	public void encolar(T v) {
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(v);
		nuevo.setRef(null);
		
		if ( primero == null ) {
			primero = nuevo;
		}else {
			ultimo.setRef(nuevo);
		}
		
		ultimo = nuevo;
	}
	
	public T desencolar() {
		Nodo<T> ret = primero;
		if( primero!=ultimo ) {
			primero = primero.getRef();
		}else {
			primero = null;
			ultimo = null;
		}
		return ret.getInfo();
	}
	
	public boolean vacia() {
		if( primero!=null) {
			return false;
		}
		return true;
	}
	
	public void borrar() {
		primero = null;
		ultimo = null;
	}
	
	public int tamanio() {
		int n = 0;
		Nodo<T> aux = primero;
		while( aux!=null ) {
			n++;
			aux = aux.getRef();
		}
		return n;
	}
	
	public String toString() {
		String x="";
		Nodo<T> aux = primero;
		while( aux!=null ) {
			x += "" + aux.getInfo().toString() + (aux.getRef()!=null?",":"");
			aux = aux.getRef();
		}
		return x;
	}

}
