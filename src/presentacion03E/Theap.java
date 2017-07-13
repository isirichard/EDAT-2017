package presentacion03E;

public class Theap {
	protected static final int N=100;
	protected int n;
	protected Integer[] arr;
	Theap(){
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
	

	public void agregar(int x){
		arr[n]=x;
		n++;
		int t=0;
		for(int j=n-1; j>0 && arr[j]<arr[j/2]; j/=2){ 
			// intercambiamos con el padre
			t=arr[j];
			arr[j]=arr[j/2];
			arr[j/2]=t;
		}
	}
}
