package presentacion02A;

public class DiccionarioLE {
	protected NodoD primero;
	public DiccionarioLE(){
		primero = null;
	}
	protected NodoD referencia(Object x){
		for(NodoD r=primero; r!=null; r=r.sgte )
			if( x.equals(r.id) ) return r;
		return null;
	}
	public Object buscar(Object x){
		NodoD r = referencia(x);
		return r == null ? null : r.info;
	}
	public boolean agregar(Object x, Object y)throws DiccLleno{
		if( referencia(x) != null ) return false;
		primero = new NodoD(x,y,primero); //agregar al comienzo
		return true;
	}
	public boolean cambiar(Object x, Object y){
		NodoD r = referencia(x);
		if( r == null ) return false;
		r.info = y;
		return true;
	}
	public boolean borrar(Object x){
		NodoD r = referencia(x);
		if( r == null ) return false;
		if( r == primero )
			primero = primero.sgte;
		else{
			NodoD ant=primero;
			while(ant.sgte != r)
				ant = ant.sgte;
			ant.sgte = r.sgte;
		}
		return true;
	}
}
