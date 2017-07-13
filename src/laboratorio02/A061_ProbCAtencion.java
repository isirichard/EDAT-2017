package laboratorio02;
/*
 * Problema. Simular una cola de atención de clientes de acuerdo al siguiente diálogo:
 */
import java.util.Scanner;

public class A061_ProbCAtencion {
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		QueueArr q = new QueueArr();
		boolean ciclo=true;
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
