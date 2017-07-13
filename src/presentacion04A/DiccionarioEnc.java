package presentacion04A;
//representación: hashing con encadenamiento
public class DiccionarioEnc {
	static protected final int m=100;
	protected Nodo[] tabla;
	//operaciones publicas
	public DiccionarioEnc(){
		tabla = new Nodo[m];
	}
	public Object buscar(Object x){
		int i = h(x);
		Nodo r=referencia(x,tabla[i]);
		return r==null ? null : r.info;
	}
	public boolean cambiar(Object x, Object y){
		Nodo r = referencia(x,tabla[h(x)]);
		if( r==null ) return false;
		r.info=y;
		return true;
	}
	public boolean agregar(Object x,Object y)throws DiccLleno{
		int i = h(x);
		if( referencia(x,tabla[i]) != null ) return false;
		tabla[i] = new Nodo(x,y,tabla[i]);
		return true;
	}
	public boolean borrar(Object x){
		int i = h(x);
		if(tabla[i]==null) return false;
		if(tabla[i].id.equals(x)){
			tabla[i]=tabla[i].sgte; return true;
		}
		for(Nodo r=tabla[i]; r.sgte!=null; r=r.sgte)
			if(r.sgte.id.equals(x)){
				r.sgte=r.sgte.sgte; return true;
			}
		return false;
	}
	//operaciones internas
	protected Nodo referencia(Object x, Nodo r){
		if( r== null || r.id.equals(x) ) return r;
		return referencia(x, r.sgte);
	}
	protected int h(Object x){return Math.abs(x.hashCode()%m);}
	
	class Nodo{
		public Object id, info;
		public Nodo sgte;
		public Nodo(Object x,Object y,Nodo z){id=x;info=y;sgte=z;}
	}
}

