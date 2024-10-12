//SHIVRAM
//Problem 4
//Algorithm: Non-Traditional Radix Sort
//Step 1: Generate Random Numbers
		
			//Generate an array of random integers.
			//Specify the length of the array, minimum value, and maximum value.
			//Fill the array with random integers within the specified range.


//Step 2: Find Maximum Number of Digits

			//Find the maximum number of digits among all the elements in the array.
			//Convert the maximum number into a string.
			//Count the number of characters in the string to determine the maximum number of digits.


//Step 3: Non-Traditional Radix Sort

			//Initialize variables:
			//n as the length of the array.
			//maxDigits as the maximum number of digits found.	
			//digitPos to iterate over each digit position from the least significant to the most significant.
			//output array to store sorted elements temporarily.
			//count array to keep track of digit frequencies.
			//Iterate through each digit position from the least significant to the most significant.
			//Within each iteration:
			//Create a new count array to store digit frequencies for the current digit position.
			//Iterate over each element in the array:
			//Extract the digit at the current position.
			//Increment the count of that digit.
			//Perform cumulative sum on the count array to determine the final position of each digit.
			//Iterate over the array in reverse order:
			//Extract the digit at the current position.
			//Place the element in the output array at the position determined by the count array.
			//Decrement the count of that digit.
			//Copy the sorted output array back to the original array.


			//Repeat step 3 for each digit position until all digits have been processed.
//Step 4: Main Function

			//Generate an array of random numbers.
			//Perform non-traditional Radix sort on the array.
			//Measure the execution time of the sorting process.
			//Print the execution time.
			//Print the first 100 and last 100 elements of the sorted array.

import java.util.Arrays;
import java.util.Random;

public class Problem4 
{
	
	 // ANSI escape code for green color
    public static final String ANSI_GREEN = "\u001B[32m";
    // ANSI escape code to reset color
    public static final String ANSI_RESET = "\u001B[0m";

    // Function to generate random numbers between minimum and maximum
    public static int[] generateRandomNumbers(int length, int minimum, int maximum) 
    {
    	
        Random random = new Random();
        int[] numes = new int[length];
        for (int i = 0; i < length; i++)
        {
            numes[i] = random.nextInt(maximum - minimum + 1) + minimum; 
        }
        return numes;
    }
    
    

    // Function to find the maximum number of digits in the array
    public static int findmax_digits(int[] array)
    {
        int max_number = Arrays.stream(array).max().orElse(0); 
        return String.valueOf(max_number).length(); 
    }

    // Function to perform non-traditional Radix sort
    public static void nonTraditionalRadixSort(int[] array)
    {
        int length = array.length;
        int max_digits = findmax_digits(array);

        for (int digit_pos = 0; digit_pos < max_digits; digit_pos++) 
        { 
        	
        	
        	// Iterate through each digit position
            int[] output = new int[length];
            int[] count = new int[10]; // Counting sort for each digit position

            for (int num : array) 
            {
                int digit = (num / (int) Math.pow(10, digit_pos)) % 10; // Extract the digit at the current position
                count[digit]++;
            }

            for (int i = 1; i < 10; i++) 
            {
                count[i] += count[i - 1]; // Cumulative sum to determine positions
            }

            for (int i = length - 1; i >= 0; i--)
            {
                int digit = (array[i] / (int) Math.pow(10, digit_pos)) % 10; // Extract the digit at the current position
                output[count[digit] - 1] = array[i];
                count[digit]--;
            }

            System.arraycopy(output, 0, array, 0, length); // Copy sorted output to original array
        }
    }

    public static void main(String[] args)
    {
        // Generate random numbers
        int arrayLength = 5000;
        int[] numbers = generateRandomNumbers(arrayLength, 0, 50000);

        // Perform non-traditional Radix sort and measure execution time
        long startTime = System.nanoTime();
        nonTraditionalRadixSort(numbers);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000; // Convert to milliseconds

        // Print execution time
        System.out.println("\nExecution Time = " + executionTime + " milliseconds");

        // Print first 100 and last 100 elements in ascending order
        System.out.println(ANSI_GREEN+"\nFirst 100 elements (in ascending order) =\n"+ANSI_RESET);
        for (int i = 0; i < 100; i++)
        {
            System.out.print(numbers[i] + " ");
        }
        System.out.println(ANSI_GREEN+"\nLast 100 elements (in ascending order) =\n"+ANSI_RESET);
        for (int i = arrayLength - 100; i < arrayLength; i++) 
        {
            System.out.print(numbers[i] + " ");
        }
    }
}
