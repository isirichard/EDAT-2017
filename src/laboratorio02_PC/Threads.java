package laboratorio02_PC;

public class Threads {
	static public void main(String[]args)
			throws InterruptedException{
		Repetidor a = new Repetidor("hola",1000);
		Repetidor b = new Repetidor("chao",1000);
		a.start();
		b.start();
		b.join(); //espera fin de b
		System.out.println("fin chaos");
		a.join();
		System.out.println("fin holas");
	}
}
