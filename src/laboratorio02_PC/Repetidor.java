package laboratorio02_PC;

public class Repetidor extends Thread{
	private String palabra;
	private int n;
	public Repetidor(String x,int y){
		palabra=x; n=y;
	}
	public void run(){
		for(int i=1; i<=n; ++i)
			System.out.println(i+":"+palabra);
	}
}
