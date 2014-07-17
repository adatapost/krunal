/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.gen;

/**
 *
 * @author admin
 */
public class Stack<T> {
    private T []items;
    private int top = -1;
    
    public Stack(T items[]){
        this.items = items;
    }
    public void push(T item){
        top++;
        if(top>=items.length){
            System.out.println("Stack overflow");
            top--;
            return;
        }
        items[top]=item;
    }
    public T pop(){
        if(top<0){
            System.out.println("Underflow");
            return null;
        }
        return items[top--];
    }
}
