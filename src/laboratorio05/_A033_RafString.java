package laboratorio05;
//Problema. Buscar todas los registros de un RAF que comiencen con un String
//Ej de uso: java Buscar Perez alumnos.bin 100
import java.io.IOException;
import java.io.RandomAccessFile;

public class _A033_RafString {
	static public void main(String[]args)throws IOException{
		int l = Integer.parseInt("13");
		RandomAccessFile A=new RandomAccessFile("raf.txt","r");
		System.out.println(A.length());
		String reg;
		while((reg=buscar("hol",A,l))!=null){
			System.out.print(reg);
		}
		A.close();
	}
	static public String buscar(String x,RandomAccessFile y,int z)throws IOException{
		String reg;
		while((reg=leerRegistro(y,z))!=null){
			if( reg.indexOf(x)==0 ){
				
				return reg;
			}
		}
		return null;//no esta
	}
	static public String leerRegistro(RandomAccessFile x,int y) throws IOException{
		if(x.getFilePointer()>=x.length())
			return null;//fin archivo
		String aux="";
		for(int i=1; i<=y; ++i) 
			aux += (char)x.read();
		return aux;
	}
}
