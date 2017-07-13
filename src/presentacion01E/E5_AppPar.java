package presentacion01E;
/**
 *Probar el ejemplo de la Clase Par (definida por el programador)
 */
public class E5_AppPar {
	public static void main(String[] args) {
		/**
		 * sea constructor o método para copiar correctamente
		 * los atributos de un objeto o compararlos. 
		 * Sólo seran iguales en contenido mas no referencia para las 
		 * referencias se usa a=b;
		 */
		Par p=new Par(1,2); 
		Par q=new Par();
		Par r=new Par(p);
		System.out.println(p.toString());
		q.asignar(p);
		System.out.println(r==p);
		System.out.println(q==p);
		r=p;
		System.out.println(r==p);
		q=p;
		System.out.println(q==p);

	}
}
