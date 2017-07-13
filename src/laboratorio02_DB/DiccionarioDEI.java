package laboratorio02_DB;

public class DiccionarioDEI extends DiccionarioDE2{
	public boolean agregar(Comparable x,Object y)throws DiccLleno{
		if( referencia(x) != null ) return false;
		NodoDEI r = new NodoDEI(x,y,null,null);
		if( primero==null || ((Comparable) primero.id).compareTo(x)>0 ){
			r.sgte = primero; primero = r;
		}else{
			NodoDEI ant=primero, sig=primero.sgte;
			while( sig!=null && sig.id.compareTo(x)<0 ){
				ant = sig; sig = sig.sgte;
			}
			ant.sgte = r; r.sgte = sig;
		}
		return true;
	}
}
