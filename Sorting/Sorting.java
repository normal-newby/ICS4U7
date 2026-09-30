package Sorting;

import java.util.*;

public class Sorting {

    static int n;
    static int[] array;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        boolean useRandom = false;
        System.out.print("Use 1000 random variables? (Y/N): ");
        String yn = input.next();
        if (yn.equalsIgnoreCase("y")) useRandom = true;

        if (useRandom){
            n = 1000;
            array = new int[n];
            for (int i = 0; i < n; i++) array[i] = (int) (Math.random() * 500);
        } else {

            System.out.print("Enter array length: ");
            n = input.nextInt();

            System.out.print("Enter array, separated by spaces: ");
            array = new int[n];
            for (int i = 0; i < n; i++) array[i] = input.nextInt();
        }

        long start, end;

        int[] bubbleArray = array.clone();
        start = System.nanoTime();
        bubbleSort(bubbleArray);
        end = System.nanoTime();
        System.out.println("Bubble sort time (microseconds): " + (end-start)/1000);
        printArray(bubbleArray);
        System.out.println();

        int[] selectionArray = array.clone();
        start = System.nanoTime();
        selectionSort(selectionArray);
        end = System.nanoTime();
        System.out.println("Selection sort time (microseconds): " + (end-start)/1000);
        printArray(selectionArray);
        System.out.println();

        int[] insertionArray = array.clone();
        start = System.nanoTime();
        insertionSort(insertionArray);
        end = System.nanoTime();
        System.out.println("Insertion sort time (microseconds): " + (end-start)/1000);
        printArray(insertionArray);
    }

    static void printArray(int[] a){
        System.out.print("Here is your sorted array: ");
        for (int i = 0; i < Math.max(n, 100); i++) System.out.print(a[i] + " ");
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
