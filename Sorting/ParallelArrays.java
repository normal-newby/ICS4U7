package Sorting;

import java.util.Scanner;

public class ParallelArrays {

    /*
    Anna 56
    Ava 47
    Baker 24
    Emma 87
    Nolan 63
    Zara 90
     */

    static int n;
    static String[] names;
    static int[] scores;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("How many students? ");
        n = input.nextInt();

        names = new String[n];
        scores = new int[n];

        for (int i = 0; i < n; i++){
            System.out.print("Enter " + (i+1) + "th student name and score, separated by a space: ");
            names[i] = input.next();
            scores[i] = input.nextInt();
            input.nextLine();
        }

        bubbleSortWithParallel();

        for (int i = 0; i < n; i++){
            System.out.println(names[i] + " " + scores[i]);
        }
    }

    static void bubbleSortWithParallel(){
        for (int i = 0; i < n; i++){
            boolean swap = false;
            for (int j = 0; j < n-i-1; j++){
                if (scores[j] < scores[j+1]){
                    swap = true;
                    int tempScore = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] = tempScore;

                    String tempName = names[j];
                    names[j] = names[j+1];
                    names[j+1] = tempName;
                }
            }

            if (!swap) break;
        }
    }
}
