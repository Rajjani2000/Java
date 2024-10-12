//SHIVRAM
//Problem 3
//Non Traditional Sorting 
//Step 1: Generate Random Array

	//Set size to 5000, min to 0, and max to 500.
	//Create an empty array array of size size.
	//Create a Random object.
	//Repeat size times:
	//Generate a random number between min and max.
	//Assign the generated number to the current index of array.
	//Return the generated array.

//Step 2: Non-Traditional Counting Sort

	//Create an integer array count of size 501, initialized with all elements as 0.
	//Iterate over each element num in the input array array:
	//Increment the value at index num in the count array.
	//Initialize an index index to 0.
	//Iterate over each element i in the count array:
	//While the value at index i in the count array is greater than 0:
	//Set the current index index in the sorted array to the value of i.
	//Decrement the value at index i in the count array.
	//Increment the index.
	//Return the sorted array

import java.util.Arrays;
import java.util.Random;

public class Problem3 
{
	 // ANSI escape code for green color
    public static final String ANSI_GREEN = "\u001B[32m";
    // ANSI escape code to reset color
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) 
    {
        // Generate 5000 random numbers between 0 and 500
        int[] random_numbers = generate_RandomArray(5000, 0, 500);
        
        // Start time measurement
        long start_time = System.nanoTime();
        
        // Sort the array using non-traditional counting sort
        int[] sorted_numbers = nonTraditional_countingsort(random_numbers);
        
        // End time measurement
        long end_time = System.nanoTime();
        
        // Print every 100th element (50 elements) in the sorted array
        for (int i = 99; i < 5000; i += 100) 
        {
            System.out.print(sorted_numbers[i] + " ");
        }
        System.out.println();
        
        // Print execution time
        System.out.println( ANSI_GREEN+"\nExecution Time = " + (end_time - start_time) + " nanoseconds"+ ANSI_RESET);
    }

    // Function to generate an array of random numbers
    private static int[] generate_RandomArray(int size, int min, int max) 
    {
        Random rand_no = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) 
        {
            array[i] = rand_no.nextInt((max - min) + 1) + min;
        }
        return array;
    }

    // Function to perform non-traditional counting sort
    private static int[] nonTraditional_countingsort(int[] array) 
    {
        int[] count = new int[501]; // Count array with indices from 0 to 500
        
     // Count occurrences of each number
        for (int num : array) 
        {
            count[num]++;
        }
        
        // Reconstruct the sorted array using count array
        int[] sortedarray = new int[array.length];
        int ind = 0;
        for (int i = 0; i < count.length; i++) 
        {
            while (count[i] > 0) 
            {
                sortedarray[ind++] = i;
                count[i]--;
            }
        }
        return sortedarray;
    }
}
