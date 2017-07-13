package laboratorio02_PC;

public class FilaxVector extends Thread {
	int M=4, N=3; //filas y columnas
	double[][]A = {{11,12,13},{21,22,23},{31,32,33},{41,42,43}};
	double[] V={1,2,3}, R=new double[M];
	
	public void imprimir() throws InterruptedException{
		FilaxVector[] th = new FilaxVector[M];
		for(int i=0; i<M; ++i){
		th[i]=new FilaxVector(i); th[i].start();
		}
		for(int i=0; i<M; ++i){
		th[i].join(); System.out.println(R[i]);
		}
	}
	
	
	private int i;
	public FilaxVector(int x){ i=x;}
	public void run(){
		R[i] = 0;
		for(int j=0; j<N; ++j) R[i] += A[i][j]*V[j];
	}
}
