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
public class IntStack {
    private int []items;
    private int top = -1;
    
    public IntStack(int items[]){
        this.items = items;
    }
    public void push(int item){
        top++;
        if(top>=items.length){
            System.out.println("Stack overflow");
            top--;
            return;
        }
        items[top]=item;
    }
    public int pop(){
        if(top<0){
            System.out.println("Underflow");
            return -1;
        }
        return items[top--];
    }
}
