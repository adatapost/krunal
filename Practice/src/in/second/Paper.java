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
public class Paper {

    private Question[] questions;

    public Paper(int noOfQuestions) {
        questions = new Question[noOfQuestions];
    }

    public void setQuestion(int index, Question q) {
        questions[index] = q;
    }

    public Question getQuestion(int index) {
        return questions[index];
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public void displayQuestions() {
        for (Question q : questions) {
            if (q != null) {
                q.display();
            }
        }
    }

    public void showResult() {
        System.out.println("\nCorrect Questions\n");
        for (Question q : questions) {
            if (q != null) {
                if (q.isCorrect()) {
                    System.out.println(q.getQuestion());
                }
            }
        }
        System.out.println("\nInCorrect Questions\n");
        for (Question q : questions) {
            if (q != null) {
                if (!q.isCorrect()) {
                    System.out.println(q.getQuestion());
                }
            }
        }
    }

}
