package presentacion01E;

/*
 * Probar el ejemplo de la Clase Abstracta Par y la Clase Fracción
 */
public class E8_AppAPar {
	public static void main(String[] args) {
		/**
		 * Crear a nivel de Fraccion permite usar metodos de Fraccion
		 * Definiar a nivel de APar luego inicializar en fracción es para
		 * polimorfismo
		 */
		PFraccionExte n1=new PFraccionExte(4,5);
		PFraccionExte n2=new PFraccionExte(6,5);
		
		/**
		 * heredando métodos de la superclase
		 */
		System.out.println(n1.primero());
		System.out.println(n1.segundo());
		/*
		 * Sobreescribiendo método toString de la superclase
		 */
		System.out.println(n1.suma(n2).toSgtring());
	}
	
}
