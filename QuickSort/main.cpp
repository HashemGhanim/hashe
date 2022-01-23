#include<iostream>
using namespace std;
void swap(int &a , int &b){
    int temp = a;
    a = b;
    b = temp;
}
int partition(int a[] , int l  , int r){
    int i = l;
    int j = r;
    int pivot = (l+r) /2 ;
    while(!(pivot == i && i == j)){
        while(j > pivot && a[j] >= a[pivot]) j--;
        
        if(a[j] < a[pivot] && pivot < j)
        {
            swap(a[pivot] , a[j]);
            pivot = j;
        }
        
        while(i < pivot && a[i] <= a[pivot]) i++;
        if(a[i] > a[pivot] && pivot > i)
        {
            swap(a[pivot] , a[i]);
            pivot = i;
        }
    }
    return pivot;
}
void quickSort(int *a ,int l , int r){
    if(l < r){
        int pivot =partition(a,l,r);
        quickSort(a, l, pivot - 1);
        quickSort(a, pivot + 1, r);
    }
}
int main(){
    int a[] = {6,4,5,10,9};
    int n = sizeof(a)/sizeof(a[0]);
    quickSort(a, 0, n-1);
    for(int i = 0 ; i < n; i++) cout << a[i] << " ";
    cout <<endl;
    return 0;
}
