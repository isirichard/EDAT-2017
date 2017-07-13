package laboratorio02_D;

public class DiccionarioArr {
	protected static final int N=100;
	protected int n;
	protected Object[] id, info;
	public DiccionarioArr(){
		id = new Object[N];
		info = new Object[N];
		n = 0;
	}
	protected int indice(Object x){
		for(int i=0; i<n; ++i )
			if( x.equals(id[i]) ) return i;
		return -1;
	}
	public Object buscar(Object x){
		int i = indice(x);
		return i < 0 ? null : info[i];
	}
	public boolean agregar(Object x, Object y)
			throws DiccLleno{try{
				if( indice(x) >= 0 ) return false;
				id[n]=x; info[n]=y; ++n; //agregar al final
				return true;
			}catch(ArrayIndexOutOfBoundsException e){
				throw new DiccLleno();
			}}
	public boolean borrar(Object x){
		int i = indice(x);
		if( i < 0 ) return false;
		id[i]=id[n-1]; info[i]=info[n-1]; --n;//”subir”el ultimo
		return true;
	}
	public boolean cambiar(Object x,Object y){
		int i = indice(x);
		if( i < 0 ) return false;
		info[i] = y;
		return true;
	}
}
