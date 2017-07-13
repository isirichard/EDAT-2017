package laboratorio04;

public class _E02_Concurrencia {
	static public int indiceC(Object x,Object[]y,int n) throws InterruptedException{
		int im=(n-1)/2;
		T t=new T(x,y,im,n-1);
		t.start();
		int i=indiceR(x,y,0,im);
		t.join();
		return i>=0 ? i : t.resultado();
	}
	static public int indiceR(Object x,Object[]y,int ip,int iu){
		if(ip>iu) return -1;
		return y[ip].equals(x)? ip : indiceR(x,y,ip+1,iu);
	}
	
}
