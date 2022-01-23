import company.BainryTree;
import company.HeapSort;
import company.MergeSort;

import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int [] a = new int[5];
        a[0] = 6;
        a[1] = 4;
        a[2] = 5;
        a[3] = 10;
        a[4] = 9;
        HeapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
