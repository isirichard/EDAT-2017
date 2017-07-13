package laboratorio02_DB;

public class DiccionarioLE {
	protected Nodo primero;
	public DiccionarioLE(){
		primero = null;
	}
	protected Nodo referencia(Object x){
		for(Nodo r=primero; r!=null; r=r.sgte )
			if( x.equals(r.id) ) return r;
		return null;
	}
	public Object buscar(Object x){
		Nodo r = referencia(x);
		return r == null ? null : r.info;
	}
	public boolean agregar(Object x, Object y)throws DiccLleno{
		if( referencia(x) != null ) return false;
		primero = new Nodo(x,y,primero); //agregar al comienzo
		return true;
	}
	public boolean cambiar(Object x, Object y){
		Nodo r = referencia(x);
		if( r == null ) return false;
		r.info = y;
		return true;
	}
	public boolean borrar(Object x){
		Nodo r = referencia(x);
		if( r == null ) return false;
		if( r == primero )
			primero = primero.sgte;
		else{
			Nodo ant=primero;
			while(ant.sgte != r)
				ant = ant.sgte;
			ant.sgte = r.sgte;
		}
		return true;
	}
}
