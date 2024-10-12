package Singleton;


//Task 2 :- Create a New Class called PrinterManager

public class PrinterManager {
	
	
//Task 3 :- defining private static "Single Instance"	
    private static PrinterManager instance; 
    
    
//Define an array of Printer called printers    
    private Printer[] printers; 

    
    
// Task 4 :- Create Private constructor to prevent external instantiation
    private PrinterManager() 
    {
       
        printers = new Printer[3];
        
        for (int i = 0; i < printers.length; i++)
        {
            printers[i] = new Printer(false, ""); // All printers start free and without a job
        }
    }

    
    //Task 5 Create a  Public static method to get the Singleton instance
    public static PrinterManager getInstance() {
        if (instance == null) {
            instance = new PrinterManager();
        }
        return instance;
    }

    //Task 6:- Create  Method to assign a job to an available printer
    public void assignJob(String job) 
    {
        boolean jobAssigned = false;
        for (Printer printer : printers) {
            if (!printer.isBusy()) { // If the printer is not busy, assign the job
                printer.setBusy(true);
                printer.setPrintJob(job);
                System.out.println("Job assigned to printer.");
                jobAssigned = true;
                break;
            }
        }
        if (!jobAssigned) {
            System.out.println("All printers are busy. Please wait.");
        }
    }

    
//Task 7:- Create  Method to display the status of all printers
    public void showStatus() 
    {
        for (int i = 0; i < printers.length; i++) {
            Printer printer = printers[i];
            System.out.println("Printer " + (i + 1) + " - Busy: " + printer.isBusy() + ", Job: " + printer.getPrintJob());
        }
    }

    
    //Task 9:- : Clear all jobs (reset all printers without printing anything)
    public void clearAllJobs() {
        for (Printer printer : printers) {
            printer.resetPrinter(); // Clear each job
        }
        System.out.println("All jobs have been cleared.");
    }
    
    
}
