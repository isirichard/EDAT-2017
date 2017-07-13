package presentacion02E;
/*
 * 1. Modificar insertar de TAD Lista – implementación con Arreglos, de modo que no produzca excepción,
duplicando el espacio cada vez que se exceda su capacidad.
 */
public class E01_ListaArrDuplicando {
	protected static final int N=100;
	protected int n;
	protected Object[] valor;
	public E01_ListaArrDuplicando(){
		valor = new Object[N];
		n=0;
	}
	public boolean vacia(){
		return n==0;
	}
	public int buscar(Object x){
		for(int i=0;i<n;++i)
			if(x.equals(valor[i]))
				return i;
		return -1;
	}
	
	public Object buscar(int x){
		try {
			return valor[x];
		}catch(ArrayIndexOutOfBoundsException e){
			return null;
		}
	}
	
	public void insertar(Object x, int y)throws ListaLlena{
		try{	
			if(y<0||y>n)
				return;
			for(int i=n;i>y;--i){
				valor[i]= valor[i-1];
			}
			valor[y]=x;
			++n;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new ListaLlena("Error en insertar");
		}
	}
	
	public void eliminar(Object x){
		int i= buscar(x);
		if(i<0)
			return;
		for(int j=i; j<n-1; ++j)
			valor[j]=valor[j+1];
		--n;
	}
}
