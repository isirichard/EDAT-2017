package laboratorio02_PC;

public class Cajeros {
	static public void main(String[]args)throws InterruptedException{
		Cuenta c = new Cuenta(1,100);
		Cajero a=new Cajero("a",c), b=new Cajero("b",c);
		a.start(); b.start();
	}
}