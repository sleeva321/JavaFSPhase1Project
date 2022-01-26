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
	case "1":displayFiles();
	break;
	case "2":createFiles();
	break;
	case "3":deleteFile();
	break;
	case "4":searchFile();
	break;
	case "5":System.exit(0);;	
	break;
	default:System.out.println("Invalid Option Entered");
		break;
	
	}
	
	if(toContinue) {
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
	

	
	public static void dispalyMenu()
	{
	System.out.println("******** Welcome to LockedMe.com *********");
	System.out.println("==========Developed by SivaREddy=============");
	System.out.println("###########################################");
	System.out.println("\t1.Display All Files\t\n\t2.Add a new filet\t\n\t3.Delete a file\t\n\t4.search a filet\t\n\t5.Exit");
	}
	
	/**
	 * This method will display all the files present in the directory
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
		
	}
	
	/**
	 * This method will search for the files present in the directory
	 */
	public static void searchFile()
	{
		
	}
	/**
	 * This method will delete the files
	 */
	public static void deleteFile()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
		
		System.out.println("Enter the file name to be deleted");
		
		 String str2=scanner.nextLine();
		File file=new File(filePath + "\\" +str2);
		
		if(file.exists())
		{
			file.delete();
			System.out.println("File Deleted Successfully: "+str2);
		}
			
		else
		{
			System.out.println("File Not Found");
		}
		}
		catch (Exception e) {
			System.out.println(errorMsg);
		}
		finally {
			sc.close();
		}
	}

}
