package presentacion01E;
/*
 * Implementar una interfaz para componentes genéricas, 
 * donde se puede ordenar enteros entregados
como argumentos.
 */
//Ejemplo:Ordenación por inserción
//que ordena objectos de cualquer tipo
public class E4_Interfaz {
	/**
	 * para enviar parametros con referencia y usar el polimorfismo
	 * es decir usar metodos de interface. Los parametros son recibidos
	 * como declaración de superclase y son trabajados como la clase heredada
	 * dentro del bloque del codigo.
	 * Para nuestro Compare es un método polimorfista.
	 */
	public static void insercion(Comparable[]a){
			for(int k=0;k<a.length;++k){
				int j;
				Comparable t=a[k];
				/*
				 * método de inserción comparando el actual con el anterior
				 * si es menor se desplaza hasta que no lo sea.
				 * En terminos de resta si la diferencia es negativa se desplaza
				 * hasta que no lo sea.
				 */
				for(j=k;j>0&& t.Compare(a[j-1])<0;--j)
					a[j]=a[j-1];
				a[j]=t;
			}
	}
	public static void main(String[]args){
		 {
		        CEnteroImpl[] a = new CEnteroImpl[args.length];

		        for( int i=0; i<args.length; ++i )
		            a[i] = new CEnteroImpl( Integer.parseInt(args[i]) );

		        insercion( a );

		        for( int i=0; i<a.length; ++i )
		            System.out.print( a[i]+" ");
		      }
	}
	
}

