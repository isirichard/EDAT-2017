package presentacion03E;
/// C) ///////////////////////////////////////
public class T {
	protected static final int N=100;
	protected int n;
	protected Integer[] arr;
	T(){
		arr = new Integer[N];
		n=0;
	}

	public int extraerMenor(){
		int menor=arr[0];
		int i,idmenor=0;
		for(i=0; i<arr.length; ++i){
			if(arr[i]==null)
				break;
			if(arr[i]<menor){
				menor=arr[i];
				idmenor=i;
			}	
		}
		i=idmenor;
		//System.out.println(i);
		for(int j=i; j<n-1; ++j){
			if(arr[i]==null)
				break;
			arr[j]=arr[j+1];
		}
		
		--n;
		return menor;	
		
	}

	void agregar(int x) throws ListaLlena{
		try{	
			arr[n]=x;
			n++;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new ListaLlena("Error en insertar");
		}
	}
	//


	void ordenar(Comparable[]x){

	}

	
}
