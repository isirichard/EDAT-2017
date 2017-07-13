package laboratorio05;
import laboratorio02.*;
/**
 * • No compara elementos (no está limitado por O(nlogn))
	 • Ordena en tiempo lineal: O(n)
	 • Separa elementos originales en N colas de acuerdo a valor de su último carácter
	 • Vacía las colas una a una almacenando elementos en arreglo original
	 • Repite proceso pero de acuerdo a valor de su penúltimo carácter
	 • Sucesivamente hasta que finalmente repite proceso con primer carácter
	 • Si los elementos tienen k caracteres, el tiempo total será O(kn) (k pasadas de tiempo
	 proporcional a n)
 *
 */
public class _A05_Buckersort {
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		Comparable[]a={"23","31","52","64","70","82","11","06"};
		bucketsort(a, a.length);
		imprimir(a);
	}
	static public void bucketsort(Comparable[]x,int n) throws QueueFull, QueueEmpty{
		//crear colas vacías
		//final char primero='a', ultimo='z'; //1ºy ult de alfabeto
		final char primero='0', ultimo='9'; //1ºy ult de numeros
		final int N=ultimo-primero+1; //tamaño del alfabeto
		QueueArr[]q=new QueueArr[N];
		for(int iq=0;iq<N;++iq)
			q[iq]=new QueueArr();
		//////////////////////////////////////////////////////////////
		//realizar k pasadas
		final int k=((String) x[0]).length(); //largo de strings
		////////////////////////////////////////////////////////////////
		for(int j=k-1; j>=0; --j){
			//separar de acuerdo a valor de caracter
			for(int i=0; i<n; ++i)
				q[((String) x[i]).charAt(j)-primero].enque(x[i]);
			//vaciar ordenadamente N colas almacenando en arreglo
			int i=0;
			//un nuevo orden deacuerdo a la u d c...
			for(int iq=0; iq<N; ++iq)
				while(!q[iq].empty())
					x[i++]=(String)q[iq].deque();
		}
	}
	////////////////////////////////////////////////////////////
	static void imprimir(Comparable[]arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
