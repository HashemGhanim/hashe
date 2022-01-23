package company;

public class Node {
    private Integer data;
    private Node left , right;
    public Node(Integer data){
        this.data = data;
    }
    public Integer getData(){
        return data;
    }
    public Node getLeft(){
        return left;
    }
    public Node getRight(){
        return  right;
    }
    public void setData(Integer data){
        this.data = data;
    }
    public void setLeft(Node left){
        this.left = left;
    }
    public void setRight(Node right){
        this.right = right;
    }

}
