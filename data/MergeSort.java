package company;

public class MergeSort {
    private static void merge(int[]a  , int l , int r , int l1 , int r1){
        int curr = Math.min(l,l1);
        int last = Math.max(r , r1);
        int size = (r1 - l1 + 1) + (r - l + 1);
        int [] temp= new int [size];
        int ele = 0;
        while(l <= r && l1 <= r1){
            if(a[l] <= a[l1])
                temp[ele++] = a[l++];
            else
                temp[ele++] = a[l1++];
        }
        while(l<=r) temp[ele++] = a[l++];
        while(l1 <= r1) temp[ele++] = a[l1++];

        for(int i = 0 ; i < size; i++) a[curr++] = temp[i];
    }
    private static void Sort(int []a , int l , int r){
        if(l >= r) return;
        int mid = (l+r) /2;
        Sort(a, l , mid);
        Sort(a,mid+1 , r);
        merge(a,l,mid,mid+1,r);
    }
    public static void Sort(int []a){
        Sort(a,0,a.length -1);
    }
}
