package company;

public class QuickSort {
    private static void swap(int []x,int a , int b){
        int temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
    private static int quickSort(int []a , int i , int j){
        int l = i;
        int r = j;
        int pivot = l;
        while(true){
            while(a[pivot] <= a[r] && pivot < r){
                r--;
            }
            if(r == pivot) break;
            else {
                swap(a,pivot,r);
                pivot = r;
            }
            while(a[pivot] >= a[l] && pivot > l){
                l++;
            }
            if(l == pivot)
                break;
            else{
                swap(a,pivot,l);
                pivot = l;
            }
        }
        return pivot;
    }
    private static void quick(int []a , int l , int r){
        if(l < r){
            int p = quickSort(a,l,r);
            quick(a,l,p - 1);
            quick(a,p+1 , r);
        }
    }
    public static void sort(int []a){
        quick(a,0,a.length-1);
    }
}
