package com.lockedme;

import java.io.File;
import java.util.Scanner;

public class LockedMe 
{
	public static String filePath="C:\\Users\\SIVA REDDY\\Desktop\\Myfiles";
	public static String errorMsg="Something went wrong,Please contact lockedme@lkf.com";
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		String userChoice;
		boolean toContinue=true;
	do
	{
		dispalyMenu();
	System.out.println("Please enter your choice");
	
	userChoice=scanner.nextLine();
	switch (userChoice)
	{
	// This case will call displayFiles method to get files from the folder
	case "1":displayFiles();
	break;
	// This case will call createFiles method to create files in the folder
	case "2":createFiles();
	break;
	// This case will call deleteFile method to delete files from the folder
	case "3":deleteFile();
	break;
	// This case will call searchFile method to search files from the folder
	case "4":searchFile();
	break;
	case "5":System.out.println("Thank You! Please visit again");
		System.exit(0);
	
	break;
	default:System.out.println("Invalid Option Entered");
		break;
	
	}
	
	if(toContinue) 
	{
		System.out.println("Do you want to continue? yes to continue/any other key to stop");
		String wantToContinue = scanner.nextLine().toLowerCase();
		if(wantToContinue.contains("yes"))
			toContinue=true;
		else
		{
			toContinue=false;
			System.out.println("Thank you for Visiting.Have a Nice Day");
		}
	}
	}
	while(toContinue);
	}
	/**
	 * This method will display menu options to the user.
	 */
	public static void dispalyMenu()
	{
	System.out.println("******** Welcome to LockedMe.com *********");
	System.out.println("========= Developed by SivaReddy ==========");
	System.out.println("###########################################");
	System.out.println("@@@@@@@@ File Management Sysytem @@@@@@@@@@");
	System.out.println("\t1.Display All Files\t\n\t2.Add a new file\t\n\t3.Delete a file\t\n\t4.search a file\t\n\t5.Exit");
	}
	/**
	 * This method will display all the files present in the folder
	 */
	public static void displayFiles()
	{
		try 
		{
			File file=new File(filePath);
			File[] listoffiles=file.listFiles();
			if(listoffiles.length==0)
				System.out.println("No Files Found in directory");
			else
			{
				for(var l:listoffiles)
					System.out.println(l.getName());
			}
			
		
		} 
		catch (Exception e) 
		{
			System.out.println(errorMsg);
		}
	}
	/**
	 * This method will create the files
	 */
	public static void createFiles()
	{
		try {
			System.out.println("Enter the filename to be created");
			String userFile=scanner.nextLine();
			File myFile = new File(filePath + "\\" + userFile);
			if (myFile.createNewFile()) {
		        System.out.println("File created: " + myFile.getName());
		      } else {
		        System.out.println("File already exists.");
		} 
		}
			catch (Exception e) {
			System.out.println(errorMsg);
		}
	}
	
	/**
	 * This method will search for the files present in the directory
	 */
	public static void searchFile()
	{
		try
		{
		File file=new File(filePath);
		File[] listoffiles=file.listFiles();
		System.out.println("Enter the file name to be search");
		String filename=scanner.nextLine();
		boolean found=false;
	for(File f:listoffiles)
		{
			if(f.getName().contains(filename))
			  found = true;
			
		}
	System.out.println(found? "Entered file "+filename+ " exists":"File Not Found");
		}
		catch (Exception e) {
			System.out.println(errorMsg);
		}
		 
	}
	/**
	 * This method will delete the files
	 */
	public static void deleteFile()
	{
		try
		{
			
		
		File file=new File(filePath);
		File[] listoffiles=file.listFiles();
		System.out.println("Enter the name to be deleted");
		String fileDelete=scanner.nextLine();
		boolean isDeleted = false;
		for(File f:listoffiles)
		{
			if(f.getName().contains(fileDelete))
			{
				f.delete();
				isDeleted=true;
		
			}
				}
		System.out.println(isDeleted?"File "+fileDelete+" Successfully":"File Not found");
		}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(errorMsg);
		}


	}
}
