package presentacion04E;

public class _E02_Concurrencia {
	public static void main(String[] args) {
		
	}
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
class T extends Thread{
	private Object x,y[]; 
	private int ip, iu, i;
	public T(Object x,Object[]y,int ip,int iu){
		this.x=x; 
		this.y=y; 
		this.ip=ip; 
		this.iu=iu;
	}

	public void run(){ 
		//i=indice(a,ip,iu); 
		//i=indice
	}
	public int resultado(){ 
		return i; 
	}
}