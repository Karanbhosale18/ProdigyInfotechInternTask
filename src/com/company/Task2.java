package com.company;

import java.util.Random;
import java.util.Scanner;

class GuessTheNo{

}

public class Task2{
    public static void main(String[] args){
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int chance=0;
        int loopend=0;

        int computernum;
        System.out.println("Welcome to 'Guess The Number' Game :");
        System.out.println("Note : You Have To Guess The Next Number ");

        while(loopend!=1) {
            computernum=rand.nextInt(1,10);
            System.out.println("Predict The Next Number : ");
            int N = input.nextInt();
            chance++;

            if (N == computernum) {
                loopend++;
                System.out.println("You Have Successfully Guess The Number In Your "+chance+" Attempt");
                break;
            }else{
                System.out.println("Wrong Prediction, Correct Number is "+computernum);
                System.out.println("Try Again");
            }
        }
    }
}
