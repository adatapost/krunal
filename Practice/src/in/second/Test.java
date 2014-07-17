/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.second;

/**
 *
 * @author admin
 */
public class Test {
    
    public static void main(String []args){
        Paper paper = new Paper(2);
        paper.setQuestion(0, new SingleChoice("What?", "Ans1", "Ans2", "Ans2", 1));
        paper.setQuestion(1, new MultiChoice("What1?", "Ans11", "Ans21", "Ans31", new int[]{1,0,1}));
        
        paper.displayQuestions();
        paper.showResult();
    }
   public static void main1(String []args){
       Question paper[] = new Question[5];
       paper[0] = new SingleChoice("What?", "Ans1", "Ans2", "Ans2", 1);
       paper[1] = new MultiChoice("What1?", "Ans11", "Ans21", "Ans31", new int[]{1,0,1});
       paper[2] = new SingleChoice("What2?", "Ans21", "Ans22", "Ans223", 2);
       paper[3] = new MultiChoice("Why?", "Ans31", "Ans31", "Ans41", new int[]{0,0,1});
       paper[4] = new SingleChoice("How?", "Ans61", "Ans62", "Ans63", 3);
       
       
       for(Question q: paper){
           if(q!=null) {
              q.display();
           }
       }
       //Result
       for(Question q: paper){
           if(q!=null) {
              System.out.println(q.getQuestion() + " " + q.isCorrect());
           }
       }
   }
}
