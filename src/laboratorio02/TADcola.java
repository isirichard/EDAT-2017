package laboratorio02;

import java.util.Scanner;

public class TADcola {
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		QueueArr q= new QueueArr();
		Scanner even=new Scanner(System.in);
		while(true){
			//char evento=Teclado.leerChar("evento?");
			char evento=even.next().charAt(0);
			switch(evento){
				case '0': 
					break;
				case '1': 
					if(q.full())
						System.out.println("cola llena");
					else 
						//q.enque(Teclado.leerString("cliente?"));
						q.enque(even.next());
					break;
				case '2':
					if(!q.empty())
						System.out.println("Se atiende a" + q.deque());
					break;
				default: 
					System.out.println("evento incorrecto");
					break;
			}
		}
	}
	
}
