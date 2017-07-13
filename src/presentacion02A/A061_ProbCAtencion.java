package presentacion02A;
/*
 * Problema. Simular una cola de atención de clientes de acuerdo al siguiente diálogo:
 */
import java.util.Scanner;

public class A061_ProbCAtencion {
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		//utilizando un cola
		QueueArr q = new QueueArr();
		boolean ciclo=true;
		/*
		 * con las letras ingresadas en consola 0,1,2
		 * 0 acaba el programa
		 * 1 se agrega a la cola un cliente.
		 * 2 se atiende al cliente.
		 */
		//new, enque, deque, reset,empty, full
		Scanner sc=new Scanner(System.in);
		while(ciclo){
			System.out.print("Evento? ");
			String evento = sc.next();
			switch(evento){
				case "0":
						ciclo=false;
					break;
				case "1":
					if( q.full() )
						System.out.print("cola llena ");
					else{
						System.out.print("cliente? ");
						q.enque(sc.next());
					}
					break;
				case "2":
					if(!q.empty())
						System.out.println("se atiende a " + q.deque());
					break;
				default: System.out.println("evento incorrecto ");
			}
		}
	}
}
