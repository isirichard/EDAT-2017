package laboratorio01;
//Ejemplo:Ordenación por inserción
//que ordena objectos de cualquer tipo
public class AppInterfaz {
	public static void insercion(IComparable[]a){
		for(int k=0;k<a.length;++k){
			int j;
			IComparable t=a[k];
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
		            System.out.println( a[i] );
		      }
	}
	
}
