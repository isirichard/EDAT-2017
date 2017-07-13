package presentacion03A;

import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

public class _A03_AExpresion {
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		Nodo raiz = new Nodo("-", //valor
				new Nodo("*",new Nodo("3",null,null),new Nodo("4",null,null)),
				new Nodo("/",new Nodo("6",null,null),new Nodo("2",null,null))
				);
		AE prueba=new AE();
		System.out.println("resultado: "+prueba.evaluar(raiz));
		System.out.print("inOrden: ");prueba.inOrden(raiz);
		System.out.print("postOrden: ");prueba.postOrden(raiz);
		System.out.print("preOrden: ");prueba.preOrden(raiz);
		
		
		System.out.println("///////////EXPRESION///////////////////////");
		String exp="2+4*5+6/2-3";
		Nodo raiz2=prueba.expresion(exp);
		System.out.print("inOrden: ");prueba.inOrden(raiz2);
		System.out.println("resultado: "+prueba.evaluar(raiz2));
		//prueba.postOrden(raiz2);
		//prueba.preOrden(raiz2);
		
		
	}

}
