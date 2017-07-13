package laboratorio01;

public class AppOrdenacion {
	static int a []={5,6,7,8,9,4,11,2,1,0};
	static int n=10;
	static int k=0;
	static int t=0;
	static int j=0;
	public static void main(String args[]){
		
		insercion();
		seleccion();
		burbuja();
	}
	static void insercion(){
		while(k<n){
			t=a[k];
			for(j =k;j>0&&a[j-1]>t;--j){
				a[j]=a[j-1];
			}
			a[j]=t;
			++k;
		}
		System.out.println("Ordenación por Inserción:");	
		for(int c=0;c<a.length;c++){
		System.out.print(a[c]+" ");	
		}
		System.out.println();
	}
	static void seleccion(){
		int i=0;
		while (k>=2){
			i=0;
			for(int j=1;j<=k-1;++j){
				if(a[j]>a[i])
					i=j;
			}
			t=a[i];
			a[i]=a[k-1];
			a[k-1]=t;
			--k;
		}
		System.out.println("Ordenación por Selección:");
		for(int c=0;c<a.length;c++){
			
			System.out.print(a[c]+" ");	
		}
		System.out.println();
	}
	static void burbuja(){
		while(k>1){
			 for(int j=0;j<=k-2;++j){
				 if(a[j]>a[j+1]){
					 t=a[j];
					 a[j]=a[j+1];
					 a[j+1]=t;
				 }
			 }
			 --k;
		 }
		System.out.println("Ordenación po Burbuja:");
		for(int c=0;c<a.length;c++){
			System.out.print(a[c]+" ");	
		}
	}
}
