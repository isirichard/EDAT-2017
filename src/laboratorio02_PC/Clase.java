package laboratorio02_PC;

public class Clase {
	static public void main(String[]args){
		Repetidor a = new Repetidor("hola",1000);
		Repetidor b = new Repetidor("chao",1000);
		a.start(); //crea thread e invoca a método run
		b.start();
		}
		}
