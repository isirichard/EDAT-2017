package laboratorio01;

public class BurbujaV2 {
 public static void main(String args[]){
	 //ordenar a[0],..., a[n-1] por la burbuja (borrador)
	 int a []={5,6,7,8,9,4,11,2,1,0};
	 int n= 10;
	 int k=n;
	 int t=0;
	 int i=0;
	 while(k>1){
		 //hacer una pasada sobre a[0],...,a[k-1]
		 for(int j=0;j<=k-2;++j){
			 if(a[j]>a[j+1]){
				 t=a[j];
				 a[j]=a[j+1];
				 a[j+1]=t;
				 i=j+1;
			 }
		 }
		 //disminuir
		 k=i;
	 }
	//imprimir
	System.out.println("Burbuja:");
	for(int c=0;c<a.length;c++){
		System.out.print(a[c]+" ");	
	}
 }
}
