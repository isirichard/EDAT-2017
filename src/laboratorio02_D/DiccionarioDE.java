package laboratorio02_D;

public class DiccionarioDE {
	protected NodoDE primero;
	public DiccionarioDE(){ primero = null; }
	protected NodoDE referencia(Object x){
		for(NodoDE r=primero; r!=null; r=r.sgte )
			if( x.equals(r.id) ) return r;
		return null;
	}
	public String buscar(Object x){
		NodoDE r = referencia(x);
		return (String)(r==null ? null : r.info);
	}
	public boolean cambiar(Object x, Object y){
		NodoDE r = referencia(x);
		if( r == null ) return false;
		r.info = y;
		return true;
	}
	public boolean agregar(Object x,Object y)throws DiccLleno{
		if( referencia(x) != null ) return false;
		primero = new NodoDE(x,y,primero,null);
		if(primero.sgte != null) primero.sgte.ant = primero;
		return true;
	}
	public boolean borrar(Object x){
		NodoDE r = referencia(x);
		if( r == null ) return false;
		if( r == primero ) //borrar el primer nodo
			if( primero.sgte == null )
				primero = null;
			else{
				primero.sgte.ant=null; primero=primero.sgte;
			}
		else{//borrar un nodo intermedio
			r.ant.sgte = r.sgte;
			if( r.sgte != null ) r.sgte.ant = r.ant;
		}
		return true;
	}}
