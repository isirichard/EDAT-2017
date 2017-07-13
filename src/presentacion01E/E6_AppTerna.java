package presentacion01E;

public class E6_AppTerna {
	/*
	 * Probar el ejemplo de la Herencia de la Clase Terna
	 */
	public static void main(String[] args) {
		
		PTernaExte a =new PTernaExte(azar(1,100),azar(1,100),azar(1,100));
		PTernaExte b =new PTernaExte(a);
		System.out.println(a.toString());
		/**
		 * segundo y tecero son métodos heredados de Par
		 * aun que no esten en la clase Terna podemos usarlos
		 */
		System.out.println(b.segundo());
		System.out.println(b.tercero());
		System.out.println(b.toString());
	}
	/**
	 * En el caso de modificadores el public es para otras
	 * clases y es static a nivel de clase.
	 */
	public static int azar(int a, int b){
		//int randNumber = (int)(Math.random()*100+1);
		//randNumber numero azar de 1 a 1000
		return (int)(Math.random()*b+a);
	}
}
