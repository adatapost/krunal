/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.second;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MultiChoice extends Question {
    private int []correctAnswer = new int[3];
    private int []userAnswer = new int[3];

    public MultiChoice(String question, String answer1, String answer2, String answer3, int []correctAnswer) {
        super(question, answer1, answer2, answer3);
        this.correctAnswer = correctAnswer;
    }

    
    @Override
    public boolean isCorrect() {
       return userAnswer[0] == correctAnswer[0]
                 && userAnswer[1] == correctAnswer[1]
                   && userAnswer[2] == correctAnswer[2];
               
    }

    @Override
    public void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuestion : "  + getQuestion());
        System.out.println("1." + getAnswer1());
        System.out.println("2." + getAnswer2());
        System.out.println("3." + getAnswer3());
        System.out.print("\nEnter three choices : ");
        userAnswer[0] = sc.nextInt();
        userAnswer[1] = sc.nextInt();
        userAnswer[2] = sc.nextInt();
    }
}
