package Singleton;

public class Client {

    public static void main(String[] args) {
        // Get the singleton instance of PrinterManager
        PrinterManager printerManager = PrinterManager.getInstance();

        // Assign some jobs
        printerManager.assignJob("Print job 1");
        printerManager.assignJob("Print job 2");
        printerManager.assignJob("Print job 3");

        // Show status of printers
        printerManager.showStatus();

        // Try assigning another job (all printers are busy now)
        printerManager.assignJob("Print job 4");

     

        // Assign new jobs after reset
        printerManager.assignJob("New print job 1");
        printerManager.assignJob("New print job 2");
        printerManager.showStatus();

    
        // Clear all jobs (clear without resetting printers)
        printerManager.clearAllJobs();
        printerManager.showStatus();

        // Check if the Singleton instance is the same
        PrinterManager printerManager2 = PrinterManager.getInstance();
        printerManager2.showStatus(); // Should show the same status as printerManager
    }
}
