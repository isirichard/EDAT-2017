package laboratorio05;
/**
 * Propuesto. Búsqueda por Hashing
Problema. ordenar archivo de acceso directo usando quicksort
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class _A035_archivoQuick {
	protected static int L;
	public static void main(String[]args)throws IOException{
		RandomAccessFile A=new RandomAccessFile("raf2.txt","rw" );
		L = Integer.parseInt("2");//largo registro(en bytes)
		int n = (int)A.length()/L; //numero registros
		quicksort(A,0,n-1);
	}
	public static void quicksort(RandomAccessFile x,int ip,int iu) throws IOException{
		if( ip >= iu ) return;
		int i = particionar(x,ip,iu);
		quicksort(x,ip,i-1);
		quicksort(x,i+1,iu);
	}
	public static int particionar(RandomAccessFile x,int ip,int iu) throws IOException{
		String pivote = leerRegistro(x,ip);
		int i=ip;
		for(int j=ip+1; j<=iu; ++j){
			String reg = leerRegistro(x,j);
			if(reg.compareTo(pivote)<0) 
				intercambiar(x,++i,j);
		}
		intercambiar(x,ip,i);
		return i;
	}
	public static void intercambiar(RandomAccessFile x,int i,int j) throws IOException{
		String aux1=leerRegistro(x,i), aux2=leerRegistro(x,j);
		escribirRegistro(x,aux1,j); escribirRegistro(x,aux2,i);
	}
	static public String leerRegistro(RandomAccessFile x,int y) throws IOException{
		x.seek(y*L);
		String aux = "";
		for(int i=1; i<=L; ++i){
			aux += (char)x.read();
		}
		return aux;
	}
	static public void escribirRegistro( RandomAccessFile x,String y,int z)throws IOException{
		x.seek(z*L);
		for(int i=0; i<y.length(); ++i){
			x.write((char)y.charAt(i));
		}
	}
}
