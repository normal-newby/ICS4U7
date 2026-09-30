package Sorting;

import java.util.*;

public class Sorting {

    static int n;
    static int[] array;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter array length: ");
        n = input.nextInt();

        System.out.print("Enter array, separated by spaces: ");
        array = new int[n];
        for (int i = 0; i < n; i++) array[i] = input.nextInt();

        int[] bubbleArray = array.clone();
        bubbleSort(bubbleArray);
        printArray(bubbleArray);

        int[] selectionArray = array.clone();
        selectionSort(selectionArray);
        printArray(selectionArray);

        int[] insertionArray = array.clone();
        insertionSort(insertionArray);
        printArray(insertionArray);
    }

    static void printArray(int[] a){
        System.out.print("Here is your sorted array: ");
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }

    static void bubbleSort(int[] a){
        for (int i = 0; i < n; i++){
            boolean swap = false;
            for (int j = 0; j < n-i-1; j++){
                if (a[j] > a[j+1]){
                    swap = true;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if (!swap) break;
        }
    }

    static void selectionSort(int[] a){
        for (int i = 0; i < n; i++){
            int minIdx = i;
            for (int j = i; j < n; j++){
                if (a[j] < a[minIdx]) minIdx = j;
            }
            int temp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = temp;
        }
    }

    static void insertionSort(int[] a){
        for (int i = 1; i < n; i++){
            int key = a[i];
            int j = i-1;

            while (j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = key;
        }
    }
}
