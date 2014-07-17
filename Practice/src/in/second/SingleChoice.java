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
public class SingleChoice extends Question {

    private int correctAnswer;
    private int userAnswer;

    public SingleChoice(String question, String answer1, String answer2, String answer3,int correctAnswer) {
        super(question, answer1, answer2, answer3);
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public boolean isCorrect() {
        return userAnswer == correctAnswer;
    }

    @Override
    public void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuestion : "  + getQuestion());
        System.out.println("1." + getAnswer1());
        System.out.println("2." + getAnswer2());
        System.out.println("3." + getAnswer3());
        System.out.print("\nEnter your choice : ");
        userAnswer = sc.nextInt();
    }

}
