//SHIVRAM
//Binary Heap Tree
//Algorithm :- Heapify Algorithm:-
//Step1:- Input Array from length 
//Step 2:- Set Variable Larget to i
//Step 3:-  Calculate Left and Right Child 
			// Left Child = 2 * i +1
			// Right Child = 2 * i +2
//Step 4:- If Larget is not equal to i 
		//Replace i and largest
		// increment Swaps
		// Recursively call heapify on the Subtree rotted index largest
//Step 5:- End


//Algorithm1 :- Inserting Element into Binary Heap One at Time
//Step 1:- Take Array As an Input from Array to length n
//Step 2 :- initialize Start Time and Set Swap value at  0
//Step 3 :-	Start Loop from index1 to n - 1;
			// For Each index i
			// Step 3.1 initialize current value i;
			// Step 3.2 while Current >0 at index at Current then Swap current with its Parent
			// Step 3.3 Swap the element at index Current With its Parent
			// Step 3.4 Update the Parent Index
			// Step 3.5 Increment Swaps

// Step 4:- Print Analyisis 
	

import java.util.Random;


public class Problem1 {
	
	 // ANSI escape code for green color
    public static final String ANSI_GREEN = "\u001B[32m";
    // ANSI escape code to reset color
    public static final String ANSI_RESET = "\u001B[0m";
    

	

    // Initialize function to insert elements into binary heap one at a time
    public static void insert_intoHeap(int[] arr) 
    {
        
    	long start_time = System.nanoTime(); // Start measuring time
    	
        int p = arr.length; 
        
        int swaps = 0; // Set Swap Value = 0

        
        // Start constructing the heap from the second element
        for (int i = 1; i < p; i++) 
        {
            int current = i;
            while (current > 0 && arr[current] > arr[(current - 1) / 2]) 
            {
                // Swap current element with its parent if it violates heap property
                int temp = arr[current];
                arr[current] = arr[(current - 1) / 2];
                arr[(current - 1) / 2] = temp;
                current = (current - 1) / 2;
                swaps++;
            }
        }

        long end_time = System.nanoTime(); 
        
        long execution_time = end_time - start_time; // Calculate execution time

        // Print first 50 elements
        System.out.println(ANSI_GREEN +"\nFirst 50 elements of the binary heap (insertion method):\n"+ ANSI_RESET);
        for (int i = 0; i < Math.min(50, p); i++) 
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nNo of  swappings =  " + swaps);
        
        System.out.println("Execution time = " + execution_time + " nanoseconds");
    }
    
    

    // Initialize function to build binary heap using linear-time algorithm
  //Algorithm2 :-  Building Binary Heap Using Linear-Time Algorithm
  //Step 1 :- Take Array As an Input from Array to length n
  //Step 2:-  initialize Start Time and Set Swap value at  0
  //Step 3:- start Loop from index n/2 -1 to 0
  			// For Each Index i
  			// Step3.1 -> Call Heapify Function
  //Step 4:- Print Analyiss
    public static void build_heap(int[] arr) 
    {
        long start_time = System.nanoTime(); 
        int n = arr.length; 
        int swaps = 0; 

        // Start from the last non-leaf node and heapify down
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i, swaps); // Call heapify function
        }

        long end_time = System.nanoTime(); // Stop measuring time
        
        long execution_time = end_time - start_time; // Calculate execution time

        // Print first 50 elements
        System.out.println(ANSI_GREEN + "\nFirst 50 elements of the binary heap (linear-time algorithm):\n"+ ANSI_RESET);
       
        for (int i = 0; i < Math.min(50, n); i++) 
        {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println("\nTotal number of swappings = " + swaps);
        
        System.out.println("Execution time = " + execution_time + " nanoseconds");
    }
    
    

    // Initialize Heapify Function :- 
    
    public static void heapify(int[] arr, int n, int i, int swaps) 
    {
        int largest_no = i; // Initialize largest as root
        
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest_no]) 
        {
            largest_no = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest_no]) 
        {
            largest_no = right;
        }

        // If largest is not root
        if (largest_no != i) 
        {
            // Swap arr[i] with arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest_no];
            arr[largest_no] = temp;
            swaps++;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest_no, swaps);
        }
    }
    
    
    
    
    

    public static void main(String[] args) 
    {
        int[] random_numbers = new int[5000]; // Array to store random numbers
        Random rand = new Random(); // Random number generator
        
        for (int i = 0; i < random_numbers.length; i++) 
        {
            random_numbers[i] = rand.nextInt(50001); // Generating random numbers between 0 and 50000
        }

        // Using insertion method
        insert_intoHeap(random_numbers);

        // Using linear-time algorithm
        build_heap(random_numbers);
    }
}
