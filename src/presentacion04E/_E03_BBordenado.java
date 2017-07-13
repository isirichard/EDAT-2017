package presentacion04E;

public class _E03_BBordenado {
	public static void main(String[] args) {
		
	}
	static public int indiceB(Comparable x,Comparable[]y,int n){
		int ip=0, iu=n-1, im, c;
		while(ip <= iu){
			if((c=y[im=(ip+iu)/2].compareTo(x))== 0) return im;
			if(c>0) iu=im-1; else ip=im+1;
		}
		return -1; //no está
	}
}
