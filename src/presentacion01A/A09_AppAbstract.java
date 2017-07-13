package presentacion01A;

public class A09_AppAbstract {
	public static void main(String[] args) {
		/**
		 * Para usar los metodos de la calse abstract se 
		 * declara con la clase padre e inicializa con la clase deseada
		 */
		AFigura ej1= new FCirculoExte(3);
		System.out.println(ej1.area());
		AFigura ej2= new RCuadradoExte(3);
		System.out.println(ej2.area());
		AFigura ej3 = new FRectanguloExte(2, 2);
		System.out.println(ej3.area());
	}
}
