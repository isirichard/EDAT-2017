package laboratorio01;
//Clase Entero, que permite leer y
//guardar un valor en una variable entera
public class Entero {
	//Datos privados
	private int valor;
	
	//Métodos publicos
	public int leer(){
		return valor;
	}
	public void guardar(int x){
		valor=x;
	}
}