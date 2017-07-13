package presentacion01E;
/*
 * Probar el ejemplo del Polimorfismo de las Clases Par o Terna
 */
public class E7_Polimorfismo {
	public static void main(String[] args) {
		int a=azar(1,100);
		int b=azar(1,100); 
		/*
		 * sentencia condicional lineal
		 * primero a condicion a evaluar separado de ?
		 * en caso de si es verdad caso contrario separado de :
		 * en caso de ser falso
		 */
		Par p= azar(1,2)==1? new Par(a,b):new PTernaExte(a,b,azar(1,100));
		System.out.println(p.toString());
	}
	public static int azar(int a, int b){
		//int randNumber = (int)(Math.random()*100+1);
		//randNumber numero azar de 1 a 1000
		//System.out.println((int)(Math.random()*b+a));
		return (int)(Math.random()*b+a);
	}
}
