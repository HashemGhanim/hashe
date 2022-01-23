package company;

public class HeapSort {
    private static void swap(int []x,int a , int b){
        int temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
    private static void heapify(int []a , int n , int ind){
        int l = 2*ind + 1;
        int r = 2*ind + 2;
        int mx = ind;
        if(l < n && a[mx] < a[l]) mx = l;
        if(r < n && a[mx] < a[r]) mx = r;
        if(ind != mx){
            swap(a,mx,ind);
            heapify(a,n,mx);
        }
    }
    private static void buildHeap(int []a){
        for(int i = a.length / 2 - 1; i >= 0; i--)
            heapify(a,a.length , i);
    }
    public static void sort(int[]a){
        buildHeap(a);
        for(int i = a.length - 1; i >= 0; i--){
            swap(a,i,0);
            heapify(a,i,0);
        }
    }
}
