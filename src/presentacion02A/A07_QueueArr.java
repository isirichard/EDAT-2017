package presentacion02A;
/*
 * 7. Representación de una Queue con un arreglo
 */
public class A07_QueueArr {
	public static void main(String[] args) throws InterruptedException, QueueFull, QueueEmpty {
		QueueArr cola = new QueueArr();
		//para agregar
		cola.enque("1-primero-cola:Arr");
		cola.enque("2-segundo-cola:Arr");
		cola.enque("3-tercero-cola:Arr");
		cola.enque("4-cuarto-cola:Arr");
		cola.enque("5-quinto-cola:Arr");
		//new, enque, deque, reset, empty, full
		while(!cola.empty()){
			//para atender y remover
			System.out.println("Atendiendo a: "+cola.deque());
			
			//pila.pop();
			//para demorar la atención usamos un hilo
			Thread.sleep(1000);
		}
	}
}
