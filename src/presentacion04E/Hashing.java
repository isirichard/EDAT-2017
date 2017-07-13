package presentacion04E;


/**
 *1. Implemente Hashing con todas sus operaciones (constructor, agregar, eliminar, buscar, recorrer,
visualizar arreglo) en un arreglo y usando el método que consideres más óptimo para manejar información.
 */
public class Hashing {
	static protected final int m=100;
	protected Nodo[] tabla;
	//operaciones publicas
	public Hashing(){
		tabla = new Nodo[m];
	}
	public boolean agregar(Object x,Object y)throws DiccLleno{
		int i = h(x);
		if( referencia(x,tabla[i]) != null ) return false;
		
		tabla[i] = new Nodo(x,y,tabla[i]);
		return true;
	}
	public boolean eliminar(Object x){
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
	public Object buscar(Object x){
		int i = h(x);
		Nodo r=referencia(x,tabla[i]);
		return r==null ? null : r.info;
	}

	//operaciones internas
	protected Nodo referencia(Object x, Nodo r){
		if( r== null || r.id.equals(x) ){
			//System.out.println(r.info);
			return r;
		} 
			
		return referencia(x, r.sgte);
	}
	public boolean cambiar(Object x, Object y){
		Nodo r = referencia(x,tabla[h(x)]);
		if( r==null ) return false;
		r.info=y;
		return true;
	}
	
	@Override
	public String toString() {
		String mostrar="";
		
		for (int i = 0; i < tabla.length; i++) {
			Nodo aux=tabla[i];
			if(tabla[i]==null){
				System.out.println("null");
				continue;
			}
			System.out.print(i+": ");
			while(tabla[i]!=null){
				System.out.print(tabla[i].info+" ");
				tabla[i]=tabla[i].sgte;
			}
			tabla[i]=aux;
			System.out.println();
				
			//System.out.println(tabla[i].info);
			
		}
		return mostrar;
	}
	protected int h(Object x){
		return Math.abs(x.hashCode()%m);
		}

	class Nodo{
		public Object id, info;
		public Nodo sgte;
		public Nodo(Object x,Object y,Nodo z){
			id=x;
			info=y;
			sgte=z;}
	}
}
