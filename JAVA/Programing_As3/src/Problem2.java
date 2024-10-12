//SHIVRAM
//Problem 2
//Sorting Programs
import java.util.Arrays;
import java.util.Random;

public class Problem2 {
    
	 // ANSI escape code for green color
    public static final String ANSI_GREEN = "\u001B[32m";
    // ANSI escape code to reset color
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static void main(String[] args) 
    {
        int[] numbers = generateRandomNumbers(5000); // Generating 5000 random numbers
        int[] numbers_co = Arrays.copyOf(numbers, numbers.length); // Creating a copy of the original array for each sorting algorithm

        // Insertion Sort
        long start_time = System.nanoTime();
        insertionSort(numbers_co);
        long end_time = System.nanoTime();
       
        System.out.println(ANSI_GREEN+"Insertion Sort - "+ANSI_RESET);
        print_First100(numbers_co);
        System.out.println("Execution time = " + (end_time - start_time) + " nanoseconds");

        // Selection Sort
        numbers_co = Arrays.copyOf(numbers, numbers.length); // Resetting the array to its original state
        start_time = System.nanoTime();
        selectionSort(numbers_co);
        end_time = System.nanoTime();
        System.out.println(ANSI_GREEN+"\nSelection Sort -"+ANSI_RESET);
        print_First100(numbers_co);
        System.out.println("Execution time = " + (end_time - start_time) + " nanoseconds");

        // Bubble Sort
        numbers_co = Arrays.copyOf(numbers, numbers.length); // Resetting the array to its original state
        start_time = System.nanoTime();
        bubbleSort(numbers_co);
        end_time = System.nanoTime();
        System.out.println(ANSI_GREEN+"\nBubble Sort -"+ANSI_RESET);
        print_First100(numbers_co);
        System.out.println("Execution time = " + (end_time - start_time) + " nanoseconds");

        // Merge Sort
        numbers_co = Arrays.copyOf(numbers, numbers.length); // Resetting the array to its original state
        start_time = System.nanoTime();
        mergeSort(numbers_co, 0, numbers_co.length - 1);
        end_time = System.nanoTime();
        System.out.println(ANSI_GREEN+"\nMerge Sort -"+ANSI_RESET);
        print_First100(numbers_co);
        System.out.println("Execution time = " + (end_time - start_time) + " nanoseconds");
    }

    // Generate an array of random numbers
    public static int[] generateRandomNumbers(int size)
    {
        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++)
        {
            numbers[i] = random.nextInt(50001); // Generating random number between 0 and 50000
        }
        return numbers;
    }

    
 // 1. Insertion Sort
 //STEP 1 = Compare first two element
//STEP 2 =If the current element is smaller, shift the previous elements to the right until you find the correct position for the current element.
//STEP 3 - Insert the current element into its correct position.
//STEP 4 -Repeat until the array is sorted.
public static void insertionSort(int[] arr) 
{
        for (int i = 1; i < arr.length; i++) 
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    

//2.  Selection Sort
//STEP 1  = Find the minimum element in the unsorted array.
//STEP 2 = Swap it with the element at the beginning of the unsorted array.
//STEP 3 = Repeat this process, moving the boundary of the unsorted subarray one element to the right, until the entire array is sorted.
public static void selectionSort(int[] arr) 
{
        for (int i = 0; i < arr.length - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[j] < arr[minIndex]) 
                {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }


//3. Bubble Sort
//STEP 1:- Start from the first element and compare it with the next element.
//STEP 2:- If the current element is greater than the next element, swap them.
//STEP 3:- Continue this process for each adjacent pair of elements in the array.
//STEP 4:- After the first pass, the largest element will be at the end.
//STEP 5:- Repeat this process for all elements except the last one.
//STEP 6:- After each pass, the next largest element will be placed in its correct position.
//STEP 7:- `Repeat until the array is sorted.
public static void bubbleSort(int[] arr) 
{
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

//4.  Merge Sort
//STEP 1 :- Divide the Array into two values
//STEP 2:-  Recursively sort to each half
//STEP 3:-  Merge the sorted halves to produce a single sorted array.
//STEP 4: - The merging process involves comparing elements from the two halves and merging them into a single sorted array.




public static void mergeSort(int[] arr, int l, int r) 
{
        if (l < r) 
        {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
 }

    private static void merge(int[] arr, int l, int m, int r) 
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
        {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) 
        {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            } 
            else 
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Print the first 100 elements of an array
    public static void print_First100(int[] arr)
    {
        for (int i = 0; i < 100 && i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
