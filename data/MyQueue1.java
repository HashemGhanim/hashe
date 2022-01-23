package company;
import java.util.*;
public class MyQueue1 <T>{
    private Stack < T> s = new Stack<T>();
    private Integer size = 0;
    public void MyQueue1(){}
    public void enqeue(T data){
        s.push(data);
        size++;
    }
    public T dequqe(){
        if(s.size() == 1)
        {
            size--;
            return s.pop();
        }
        T f = s.pop();
        T data = dequqe();
        s.push(f);
        return data;
    }
    public Integer getSize(){
        return size;
    }
    private String getString(){
        if(s.size() == 1)
            return s.peek()+", ";
        T data = s.pop();
        String d = getString();
        s.push(data);
        return d + data + ", ";
    }

    @Override
    public String toString(){
        String s = getString();
        return "["+s.substring(0,s.length() -2)+"]";
    }
}
