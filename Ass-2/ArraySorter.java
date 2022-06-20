// Student Name: Jigishaben Pragnesh Padhiyar
// Date: 25-10-21
// Program Name: Array Sorter file
// Purpose: to implement the various sorting algorithms for arrays in Java


import java.util.Arrays;
import java.util.stream.IntStream;
//ArraySorter Class

public class ArraySorter
{
    public long swapsMade;
    public ArraySorter()
    {
        this.swapsMade = 0;
    }
    // Bubble sort implementation
    public int[] bubbleSort(int[] arr, int length)
    {
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length-i-1; j++){
 
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    this.swapsMade += 1;
                }
            }
        }
        return arr;
    }
    // Enhanced Bubble sort implementation
    public int[] enhancedBubbleSort(int[] arr, int length)
    {
       
        this.swapsMade = 0;
        int loopswaps;
        do{
            loopswaps = 0;
            for(int i = 0; i < length-1; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    loopswaps += 1;
                }
            }
            length--;
            this.swapsMade += loopswaps;
        }while(loopswaps != 0);
        return arr;

    }
    // Selection sort implementation
    public int[] selectionSort(int[] arr, int length)
    {
        this.swapsMade = 0;
        for (int i = 0; i < length-1; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            if(i != minIndex){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                this.swapsMade += 1;
            }
        }
        return arr;
    }

    
    // Merge sort implementation
   public int[] mergeSort(int[] arr, int length)
    {
        if (length > 1){
            int mid = length/2;
            int[] firstSlice = IntStream  
            .range(0, mid)  
            .map(i -> arr[i])  
            .toArray();
            int[] secondSlice = IntStream.range(mid,length).map(i -> arr[i]).toArray();
            firstSlice = this.mergeSort(firstSlice, mid);
            secondSlice = this.mergeSort(secondSlice, length - mid);  
            int i = 0, j = 0;   
            int k = 0;
            while (i < mid && j < length - mid) {
                if (firstSlice[i] <= secondSlice[j]) {
                    arr[k] = firstSlice[i];
                    i++;
                }
                else {
                    arr[k] = secondSlice[j];
                    j++;
                    this.swapsMade ++;
                }
                k++;
                
            }
    
            while (i < mid) {
                arr[k] = firstSlice[i];
                i++;
                k++;
            }
    
            while (j < length - mid) {
                arr[k] = secondSlice[j];
                j++;
                k++;
            }
        }
        return arr;
    }
    // Quick sort implementation
    public int[] quickSort(int[] arr, int low, int length)
    {
        int high = length - 1;
        if (low < high) 
        {            
            int pivot = arr[high]; 
            int i = low-1; 
        
            for(int j = low; j <= high-1; j++)
            {
                
                if (arr[j] < pivot) 
                {
                    
                    i++; 
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    this.swapsMade += 1;
                }
            }
            int temp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = temp;
            this.swapsMade += 1;
            this.quickSort(arr, low, i);
            this.quickSort(arr, i+2, length);
        }
        return arr;
    }
}