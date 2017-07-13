package laboratorio02_DB;

public class DiccionarioArr{
	protected static final int N=100;
	protected int n;
	protected Comparable[] id;
	protected Object[] info;
	public DiccionarioArr(){
		id=new Comparable[N]; info=new Object[N]; n=0;
	}
	protected int indice(Comparable x){//busqueda binaria
		int ip=0, iu=n-1, im, c;
		while(ip <= iu){
			if((c=id[im=(ip+iu)/2].compareTo(x))==0) return im;
			if( c > 0 ) iu=im-1; else ip=im+1;
		}
		return -1;
	}
	public String buscar(Comparable x){
		int i = indice(x);
		return (String) (i < 0 ? null : info[i]);
	}
	public boolean agregar(Comparable x,Object y)throws DiccLleno{
		if( indice(x) >= 0 ) return false;
		if( n >= N ) throw new DiccLleno();
		int i=n-1;
		while(i >=0 && x.compareTo(id[i]) < 0){
			id[i+1]=id[i]; info[i+1]=info[i]; --i;
		}
		id[i+1]=x; info[i+1]=y; ++n;
		return true;
	}
	public boolean borrar(Comparable x){
		int i = indice(x);
		if( i < 0 ) return false;
		for(int j=i; j<n-1; ++j){
			id[j]=id[j+1]; info[j]=info[j+1];
		}
		--n;
		return true;
	}
	public boolean cambiar(Comparable x,Object y){
		int i = indice(x);
		if( i < 0 ) return false;
		info[i] = y;
		return true;
	}


}