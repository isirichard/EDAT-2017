package presentacion03E;

import java.io.Externalizable;

/**
 * 5. el TDA T tiene definidas las siguientes operaciones:
operación Significado
T t=new T() 		Crea un objeto de clase T sin información
t.extraerMenor() 	Entrega (y elimina) el menor valor del objeto
t.agregar(x) 		Agregar el valor x al objeto
a) use el TDA en un método que ordene un arreglo: void ordenar(Comparable[]x)
b) implemente el TDA con un heap (AB que contiene el menor valor en su raíz)
c) implemente el TDA con un arreglo
 */
public class _E05_TDA_T {
	
	public static void main(String[] args) throws ListaLlena {
		
		////// a) ///////////////////////////////////
		Theap t=new Theap();
		t.agregar(1);
		t.agregar(2);
		t.agregar(3);
		t.agregar(4);
		t.agregar(5);
		t.agregar(6);
		t.agregar(7);
	
		System.out.println(t.extraerMenor());
		System.out.println(t.extraerMenor());
		
		//System.out.println(t.extraerMenor());
		//System.out.println(t.extraerMenor());
		
		for(int i=0;i<t.arr.length;i++){
			if(t.arr[i]==null)
				break;
			System.out.print(t.arr[i]+" ");
			
		}
		System.out.println();
		//// b) ///////////////////////////////////////
		Integer[] arr={4,5,1,2,6};
		ordenar(arr);
	
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null)
				break;
			System.out.print(arr[i]+" ");
			
		}
	}
	static void ordenar(Comparable[]x) throws ListaLlena{
		T t=new T();
		for(int i=0;i<x.length;i++){
			t.agregar((int)x[i]);
		}
		for(int i=0;i<x.length;i++){
			int menor=t.extraerMenor();
			x[i]=menor;
		}
		
	}
	
	
	
}
