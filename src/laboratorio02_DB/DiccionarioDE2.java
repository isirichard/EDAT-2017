package laboratorio02_DB;

public class DiccionarioDE2 {
	protected NodoDEI primero;
	public DiccionarioDE2(){ primero = null; }
	protected NodoDEI referencia(Object x){
		for(NodoDEI r=primero; r!=null; r=r.sgte )
			if( x.equals(r.id) ) return r;
		return null;
	}
	public String buscar(Object x){
		NodoDEI r = referencia(x);
		return (String) (r==null ? null : r.info);
	}
	public boolean cambiar(Object x, Object y){
		NodoDEI r = referencia(x);
		if( r == null ) return false;
		r.info = y;
		return true;
	}
	public boolean agregar(Object x,Object y)throws DiccLleno{
		if( referencia(x) != null ) return false;
		primero = new NodoDEI(x,y,primero,null);
		if(primero.sgte != null) primero.sgte.ant = primero;
		return true;
	}
	public boolean borrar(Object x){
		NodoDEI r = referencia(x);
		if( r == null ) return false;
		if( r == primero )
			//borrar el primer nodo
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
	}
}
