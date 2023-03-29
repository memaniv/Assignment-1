/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lockersapp;

import com.lockedme.businesslogic.LockersManager;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author MemaniV
 */
public class LockersApp {   
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // declare variables
        int option;
        String fileName;
        LockersManager lm = new LockersManager();
        
        //display welcome message
        displayWelcomeMessage();
        
        do {
            //display main options
            option = displayMainOptions();
            
            //determine which option has been selected
            switch (option) {
                case 1:
                    //get current files
                    String[] files = lm.getFileNames();
                    
                    //check if there are files
                    if(files.length == 0){
                        System.err.println("There are no files in the current directory.");
                    } else {
                        //display the files
                        System.out.println("Current files: " + Arrays.toString(files));
                    }
                    break;
                case 2:
                    //display the features menu
                    char choice = displayFeaturesMenu();
                    //continue running whilst the user doesn't want to navigate to the main menu
                    while(choice != 'o'){
                        //switch according to the choice of the user
                        switch(choice){
                            //add file
                            case 'a':
                                //enter file name
                                fileName = enterFileName();
                                
                                //check if file already exists
                                if(lm.isFileExisting(fileName)){
                                    //display an error message
                                    System.err.println("File already exists.");
                                } else {
                                    //add the file
                                    lm.addFile(fileName);
                                    
                                    //confirm that the file has been added
                                    System.out.println("The file has been added.\n");
                                }
                                break;
                                //delete file
                            case 'd':
                                //enter the file name
                                fileName = enterFileName();
                                
                                //check if file already exists, minding case sensitivity
                                if(lm.fileSearch(fileName) != -1){
                                    //delete the file
                                    lm.deleteFile(fileName);
                                    //confirm that the file has been deleted.
                                    System.out.println("The file has been deleted.\n");
                                } else {
                                    //confirm that the file doesn't exist
                                    System.err.println("File not found.\n");
                                }
                                break;
                                //search for a file
                            case 's':
                                //enter the file name
                                fileName = enterFileName();
                                
                                //check if file already exists
                                if(lm.fileSearch(fileName) != -1){
                                    //display a confirmation message that says the file exists
                                    System.out.println("The file exists.\n");
                                } else {
                                    //confirm that the file doesn't exist
                                    System.err.println("There's no such a file.\n");
                                }
                                break;
                            default:
                                System.err.println(choice + " is invalid. Please re-enter.");
                        }
                                    
                        //display features menu again
                        choice = displayFeaturesMenu();
                    }   break;
                case 3:
                    System.out.println("GoodBye!!!");
                    break;
                default:
                    System.err.println(option + " is an invalid option. Please re-enter.");
                    break;
            }
        } while(option != 3);
    }
    
    private static char displayFeaturesMenu(){
        //declare variables
        Scanner sc = new Scanner(System.in);
        char option;
        
        //display options
        System.out.print("\nPlease select one of the following options: " + "\n" +
                "a - add a file." + "\n" +
                "d - delete a file." + "\n" +
                "s - search for a file." + "\n" +
                "o - navigate back to the main context." + "\n\n" +
                "Your option: ");
        option = Character.toLowerCase(sc.next().charAt(0));
        
        //return the option
        return option;
    }
    
    private static String enterFileName() {
        //declare variables
        Scanner sc = new Scanner(System.in);
        String fileName;
        
        //ask user to enter the file name
        System.out.print("Please enter file name: ");
        fileName = sc.nextLine();
        
        //return the file name
        return fileName;
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to Lockers PvtLtd File Management System. This system was developed by Vuyisile Memani." + "\n" +
                "The system will allow you to do the following: " + "\n" +
                "(1) Create a new file. " + "\n" +
                "(2) Delete a file." + "\n" +
                "(3) Search for a file." + "\n" +
                "(4) Display all the files.\n");
    }

    private static int displayMainOptions() {
        //declare variables
        Scanner sc = new Scanner(System.in);
        int option;
        
        //display options
        System.out.print("\nPlease select one of the following options: " + "\n" +
                "1 - display current files." + "\n" +
                "2 - display features menu." + "\n" +
                "3 - end program." + "\n\n" +
                "Your option: ");
        option = sc.nextInt();
        
        //return the user option
        return option;
    }
    
}
