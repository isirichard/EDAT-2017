package laboratorio02;
/*
 * 8. Representación de una Queue con una lista enlazada
 */
public class A08_QueueLE {
	public static void main(String[] args) throws InterruptedException, QueueFull, QueueEmpty {
		QueueLE cola = new QueueLE();
		//para agregar
		cola.enque("1-primero-cola:LE");
		cola.enque("2-segundo-cola:LE");
		cola.enque("3-tercero-cola:LE");
		cola.enque("4-cuarto-cola:LE");
		cola.enque("5-quinto-cola:LE");
		
		while(!cola.empty()){
			//para atender y remover
			System.out.println("Atendiendo a: "+cola.deque());
			
			//pila.pop();
			//para demorar la atención usamos un hilo
			Thread.sleep(1000);
		}
	}
}