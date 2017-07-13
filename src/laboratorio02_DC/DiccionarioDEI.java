package laboratorio02_DC;

public class DiccionarioDEI {
	protected Nodo primero;
	public DiccionarioDEI(){
		primero = null;
	}
	protected Nodo referencia(String x){
		for(Nodo r=primero; r!=null; r=r.sgte ){
			int c = x.compareTo((String) r.id);
			if( c==0 ) return r;
			if( c<0 ) break;
		}
		return null; //no está
	}
	//...
	public boolean agregar(Comparable x,Object y)
			throws DiccLleno{
		//crear nuevo nodo
		Nodo r = new Nodo(x,y,null,null);
		//agregar como primer nodo
		if(primero==null){primero=r; return true;}
		if(primero.id.equals(x)) return false; //ya existe
		if(primero.id.compareTo(x)>0){
			r.sgte=primero; primero=primero.ant=r; return true;
		}
		//buscar referencias a nodos anterior y siguiente
		Nodo ant=primero, sgte=primero.sgte;
		while(sgte!=null){
			int c=sgte.id.compareTo(x);
			if(c==0) return false; //ya existe
			if(c>0) break;
			ant=sgte; sgte=sgte.sgte;
		}
		//insertar entre nodos anterior y siguiente
		r.sgte=sgte; r.ant=ant;
		ant.sgte=r;
		if(sgte!=null) sgte.ant=r;
		return true;
	}
}
