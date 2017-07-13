package laboratorio02;
/*
 * 5. Representación de un Stack con una lista enlazada
 */
public class A05_SatckLE {
	public static void main(String[] args) throws InterruptedException {
		StackLE pila = new StackLE();
		//para agregar
		pila.push("1-primero-pila:LE");
		pila.push("2-segundo-pila:LE");
		pila.push("3-tercero-pila:LE");
		pila.push("4-cuarto-pila:LE");
		pila.push("5-quinto-pila:LE");
		
		while(!pila.empty()){
			//para atender y remover
			System.out.println("Atendiendo a: "+pila.pop());
			
			//pila.pop();
			//para demorar la atención usamos un hilo
			Thread.sleep(1000);
		}
	}
}
