package company;

import java.util.EmptyStackException;

public class Mystack <T>{
    private T ele[] = (T[]) new Object[6];
    private Integer size = 0;
    private Integer top = -1;
    public Mystack(){

    }
    public boolean isEmpty() {
        if(top == -1) return true;
        return false;
    }

    public boolean isFull(){
        if(size == ele.length)
            return true;
        return false;
    }
    public void newCapacity(){
        Integer c = ele.length / 2;
        T arr[] = (T[]) new Object[c + ele.length];
        for(int i = 0 ; i < ele.length; i++){
            arr[i] = ele[i];
        }
        ele=arr;
    }
    public void push(T data){
        if(isFull())
            newCapacity();
        ele[++top] = data;
        size++;
    }
    public T pop(){
        if(isEmpty())
            throw new EmptyStackException();
        top--;
        size--;
        return ele[top + 1];
    }
    public T peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return ele[top];
    }

    public Integer getSize(){
        return size;
    }

    @Override
    public String toString(){
        String s = "[";
        for(int i = size - 1; i >= 0; i--)
            s+=ele[i] + ",";
        return s.substring(0,s.length() - 1) + "]";
    }
}
