package laboratorio02_PC;

public class Cajero extends Thread {
	private String id;
	private Cuenta cta;
	public Cajero(String x,Cuenta y){ id=x; cta=y;}
	public void run(){
		if(cta.girar(80)==false)
			System.out.println("Cajero "+id+":sobregiro");
		System.out.println("Cajero "+id+":saldo="+cta.obtenerSaldo());
	}
}
