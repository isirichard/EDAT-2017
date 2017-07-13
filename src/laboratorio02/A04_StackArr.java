package laboratorio02;
/*
 * 4. Representación de un Stack con un arreglo
 */
public class A04_StackArr {
	public static void main(String[] args) throws InterruptedException {
		StackArr pila = new StackArr();
		//para agregar
		pila.push("1-primero-pila");
		pila.push("2-segundo-pila");
		pila.push("3-tercero-pila");
		pila.push("4-cuarto-pila");
		pila.push("5-quinto-pila");
		
		while(!pila.empty()){
			//para atender y remover
			System.out.println("Atendiendo a: "+pila.pop());
			
			//pila.pop();
			//para demorar la atención usamos un hilo
			Thread.sleep(1000);
		}
	
	}
}
