package laboratorio05;
//Problema. búsqueda binaria en RAF ordenado
import java.io.IOException;
import java.io.RandomAccessFile;

public class _A034_RAFord {
	protected static int L;
	public static void main(String[]args)throws IOException{
		RandomAccessFile A=new RandomAccessFile("raf2.txt","r" );
		L = Integer.parseInt("12");//largo registro(en bytes)
		int n = (int)A.length()/L; //numero registros
		int i=indice("hol",A,0,n-1);
		System.out.println(i<0? "no existe": leerRegistro(A,i));
	}
	static public int indice(String x,RandomAccessFile y, int ip,int iu)throws IOException{
		
		if( ip > iu ) 
			return -1; //no esta
		int im = (ip + iu)/2; //indice del medio
		
		String reg=leerRegistro(y,im);
		int l = Math.min(x.length(),reg.length());
		int c = x.compareTo(reg.substring(0,l));
		if( c == 0 ) 
			return im;
		return c<0? indice(x,y,ip,im-1): indice(x,y,im+1,iu);
	}
	static public String leerRegistro(RandomAccessFile x,int y) throws IOException{
		x.seek(y*L);
		String aux = "";
		for(int i=1; i<=L; ++i) 
			aux += (char)x.read();
		return aux;
	}
}
