// student name :Jigishaben Pragnesh Padhiyar
// Date : 25-10-21
// ArraySorterTest class
// Performs tests on the ArraySorter class methods

import java.util.Random;
import java.util.Arrays;

public class ArraySorterTest
{
    public static int[] arrayGenerator(int size, int highest)
    {
        // Create the Random number generator instance
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = rand.nextInt(highest+1);
        }
        return arr;
    }
    public static void main(String[] args)
    {
        // Instantiate the ArraySorter class
        ArraySorter sorter = new ArraySorter();
        
        // Create three integer variables 

        int numberOfArrays = 1000;
        int lengthOfArrays = 50;
        int highestNumber =500;
        System.out.println(String.format("Array size: %d.", lengthOfArrays));
        System.out.println(String.format("Generates numbers from 0 to: %d.", highestNumber));
        System.out.println(String.format("Number of arrays sorted: %d.", numberOfArrays));

        // Bubble sort test

        System.out.println("Bubble sort.");
        sorter.swapsMade = 0;
        long startTime = System.nanoTime();
        for(int i = 0; i < numberOfArrays; i++){
            int[] arr = arrayGenerator(lengthOfArrays, highestNumber);            
            arr = sorter.bubbleSort(arr, lengthOfArrays);            
        }
        long stopTime = System.nanoTime();
        long timeDiff = stopTime - startTime;
        System.out.println(String.format("time: %d nanoseconds.", timeDiff));
        System.out.println(String.format("swaps: %d.", sorter.swapsMade));
        System.out.println("Enhanced Bubble sort.");
        sorter.swapsMade = 0;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfArrays; i++){
           
            // Test Enhamced Bubble Sort

            int[] arr = arrayGenerator(lengthOfArrays, highestNumber);            
            arr = sorter.enhancedBubbleSort(arr, lengthOfArrays);            
        }
        stopTime = System.nanoTime();
        timeDiff = stopTime - startTime;
        System.out.println(String.format("time: %d nanoseconds.", timeDiff));
        System.out.println(String.format("swaps: %d.", sorter.swapsMade));
       System.out.println("Selection sort.");
        sorter.swapsMade = 0;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfArrays; i++){
            
            // Test selection Sort    

            int[] arr = arrayGenerator(lengthOfArrays, highestNumber);            
            arr = sorter.selectionSort(arr, lengthOfArrays);            
        }
        stopTime = System.nanoTime();
      
        timeDiff = stopTime - startTime;
        System.out.println(String.format("time: %d nanoseconds.", timeDiff));
        System.out.println(String.format("swaps: %d.", sorter.swapsMade));

        // Test merge sort

        System.out.println("Merge sort.");
        sorter.swapsMade = 0;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfArrays; i++){
                
            int[] arr = arrayGenerator(lengthOfArrays, highestNumber);            
            arr = sorter.mergeSort(arr, lengthOfArrays);            
        }
        stopTime = System.nanoTime();
      
        timeDiff = stopTime - startTime;
        System.out.println(String.format("time: %d nanoseconds.", timeDiff));
        System.out.println(String.format("swaps: %d.", sorter.swapsMade));

        // Test quick sort
        
        System.out.println("Quick sort.");
        sorter.swapsMade = 0;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfArrays; i++){
                   
            int[] arr = arrayGenerator(lengthOfArrays, highestNumber);            
            arr = sorter.quickSort(arr, 0, lengthOfArrays);
                      
        }
        stopTime = System.nanoTime();
    
        timeDiff = stopTime - startTime;
        System.out.println(String.format("time: %d nanoseconds.", timeDiff));
        System.out.println(String.format("swaps: %d.", sorter.swapsMade));
    }
}