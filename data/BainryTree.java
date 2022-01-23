package company;
import java.util.*;
public class BainryTree {
    Node  root ;
    int size = 0 , high =  -1 ;
    static int ind = 0;
    public BainryTree(int data){
        root = new Node (data);
        size++;
    }
    public int getSize(){
        return size;
    }
    public BainryTree(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void add(Integer data){
        Node  temp = new Node (data);
        if(isEmpty())
        {
            root = temp;
            size++;
            return;
        }
        Node curr = root;
        add(curr , temp);
        size++;
    }
    public Node getRoot(){
        return root;
    }
    private void add(Node curr , Node temp){
        if(temp.getData() > curr.getData() && curr.getRight() == null){
            curr.setRight(temp);
            return;
        }
        if(temp.getData() < curr.getData() && curr.getLeft() == null){
            curr.setLeft(temp);
            return;
        }
        if(temp.getData() > curr.getData())
        {
            curr = curr.getRight();
            add(curr,temp);
        }
        if(temp.getData() < curr.getData())
        {
            curr = curr.getLeft();
            add(curr,temp);
        }
    }
    public void printIn(){
        Node  curr = root;
        printIn(curr);
    }
    private void printIn(Node curr){
        if(curr == null)
            return;
        printIn(curr.getLeft());
        System.out.print(curr.getData() + " ");
        printIn(curr.getRight());
    }

    public void printPre(){
        Node curr = root;
        printPre(curr);
    }
    private void printPre(Node curr){
        if(curr == null)
            return;
        System.out.print(curr.getData() + " ");
        printPre(curr.getLeft());
        printPre(curr.getRight());
    }

    public void printPost(){
        Node  curr = root;
        printPost(curr);
    }
    private void printPost(Node curr){
        if(curr == null)
            return;
        printPost(curr.getLeft());
        printPost(curr.getRight());
        System.out.print(curr.getData() + " ");
    }

    public int treeHigh(){
        Node  curr = root;
        high(curr,0);
        return high;
    }
    private void high(Node curr ,  Integer count){
        if(curr == null)
        {
            high = Math.max(high,count);
            return;
        }
        high(curr.getRight() , count+1);
        high(curr.getLeft() , count+1);
    }

    public boolean isLeaf(Integer data){
        Node  curr = root;
        return isLeaf(root,data);
    }
    private boolean isLeaf(Node curr , Integer data){
        if(curr.getRight() == null && curr.getLeft() == null && curr.getData().equals(data))
            return true;
        if(curr.getRight() == null && curr.getLeft() == null && !curr.getData().equals(data))
            return false;
        if(curr.getRight() != null && curr.getLeft() != null)
            return isLeaf(curr.getRight() , data) || isLeaf(curr.getLeft() , data);
        else if(curr.getRight() != null)
            return isLeaf(curr.getRight() , data);
        else
            return isLeaf(curr.getLeft() , data);
    }

    public int maxValue(){
        Node  curr = root;
        return maxValue(curr);
    }
    private int maxValue(Node curr){
        if(curr.getLeft() == null && curr.getRight() == null)
            return (int)curr.getData();
        int x1 = Integer.MIN_VALUE , x2 = Integer.MIN_VALUE;
        if(curr.getRight() != null)
            x1 = maxValue(curr.getRight());
        if(curr.getLeft() != null)
            x2 = maxValue(curr.getLeft());
        int temp = Math.max(x1,x2);
        int re = (Math.max((int)curr.getData() , temp));
        return re;
    }

    public int minValue(){
        Node curr = root;
        return minValue(curr);
    }
    private int minValue(Node curr){
        if(curr.getLeft() == null && curr.getRight() == null)
            return (int)curr.getData();
        int x1 = Integer.MAX_VALUE , x2 = Integer.MAX_VALUE;
        if(curr.getRight() != null)
            x1 = minValue(curr.getRight());
        if(curr.getLeft() != null)
            x2 = minValue(curr.getLeft());
        int temp = Math.min(x1,x2);
        int re = (Math.min((int)curr.getData() , temp));
        return re;
    }

    public String pathOfValue(Integer data){
        Node  curr  = root , m = root;
        if(isHere(m , data))
            return pathOfValue(curr,data);
        else
            return "There is NO path\n";
    }
    private boolean isHere(Node curr ,int data){
        if(curr.getData().equals(data))
            return true;
        if(curr.getRight() == null && curr.getLeft() == null)
            return false;
        if(curr.getLeft() != null && curr.getRight() != null)
            return isHere(curr.getRight() , data) || isHere(curr.getLeft() , data);
        else if(curr.getRight() != null)
            return isHere(curr.getRight() , data);
        else
            return isHere(curr.getLeft() , data);
    }
    private String pathOfValue(Node curr , int data){
        if(curr.getData().equals(data))
            return data+"";
        if(curr.getRight() == null && curr.getLeft() == null)
            return "";
        if(curr.getData() < data)
            return curr.getData() +"->"+ pathOfValue(curr.getRight() , data);
        else
            return curr.getData() + "->" + pathOfValue(curr.getLeft() , data);
    }

    public static void Sort(ArrayList <Integer> a){
        BainryTree o = new BainryTree();
        for(int i = 0 ; i < a.size(); i++){
            o.add(a.get(i));
        }
        ind = 0;
        fillArray(o.root, a);
    }
    private static void fillArray(Node root , ArrayList<Integer> a){
        if(root == null)
            return;
        fillArray(root.getLeft() , a);
        a.set(ind++,root.getData());
        fillArray(root.getRight() , a);
    }

    private int getAllLeft(Node root){
        if(root == null)
            return 0;
        return 1 + getAllLeft(root.getLeft());
    }
    private int getAllRight(Node root){
        if(root == null)
            return 0;
        return 1 + getAllRight(root.getRight());
    }

    public int[][] getInTheSame(Node root){
        int n = getAllLeft(root);
        int m = getAllRight(root);
        int[][] a =new int[n+m+1][size + 1];
        int [] c = new int[n+m+1];
        for(int i = 0 ; i < n+m+1; i++) c[i] = 0;
        count(a,c,n,root);
        return a;
    }
    private void count(int [][] a , int []c , int ind , Node root){
        if(root == null) return;
        a[ind][c[ind]] = root.getData();
        c[ind]++;
        count(a,c,ind - 1 , root.getLeft());
        count(a,c,ind + 1, root.getRight());
    }
}
