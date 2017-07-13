package laboratorio02_PC;

public class Cuenta extends Thread{
	private int id, saldo;
	public Cuenta(int x,int y){id=x; saldo=y;}
	public int obtenerSaldo(){return saldo;}
	public synchronized void depositar(int x){saldo+=x;}
	public synchronized boolean girar(int x){
		if( x > saldo ) return false;
		saldo-=x;
		return true;
	}
}