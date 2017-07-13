package presentacion04A;

public class DiccionarioLin {
	//representacion: hashing con rehashing lineal
	static protected final int m=100;
	protected Elemento[] tabla;
	//operaciones publicas
	public DiccionarioLin(){
		tabla = new Elemento[m];
	}
	public Object buscar(Object x){
		int i = indice(x);
		return i<0 ? null : tabla[i].info;
	}
	public boolean cambiar(Object x, Object y){
		int i = indice(x);
		if( i<0 ) return false;
		tabla[i].info = y;
		return true;
	}
	public boolean agregar(Object x, Object y)throws DiccLleno {
		int i;
		for(i=h(x); tabla[i]!=null; i=(i+1)%m)
			if( tabla[i].id.equals(x) && !tabla[i].borrado )
				return false;
		tabla[i] = new Elemento(x,y);
		return true;
	}
	public boolean borrar(Object x){
		int i = indice(x);
		if( i<0 ) return false;
		tabla[i].borrado = true;
		return true;
	}
	//operaciones internas
	protected int indice(Object x){
		for(int i=h(x); tabla[i]!=null; i=(i+1)%m)
			if(tabla[i].id.equals(x) && !tabla[i].borrado) return i;
		return -1;
	}
	private int h(Object x) {
		return Math.abs(x.hashCode()%m);
	} 
}
class Elemento{
	public Object id, info;
	boolean borrado;
	public Elemento(Object x,Object y){
		id=x; info=y;borrado=false;
	}
}
