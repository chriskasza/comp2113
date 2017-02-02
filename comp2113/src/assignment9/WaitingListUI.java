package assignment9;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import assignment9.EmergWaitingList.Patient;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 09
 * Version:      1.0
 * File:         WaitingListUI.java
 *
 * A UI for an emergency waiting room triage. 
 * 
 */

public class WaitingListUI {
	public static int served;
	public static EmergWaitingList list;
	public static Scanner in = new Scanner(System.in);	

	public static void main(String[] args) {
		boolean quitflag = false;
		int menuChoice;
		served = 0;
		list = new EmergWaitingList();
		
		while(true) {
			printMenu();
			menuChoice = getMenuChoice();
			switch(menuChoice) {
				case(1):
					addPatient();
					break;
				case(2):  
					getNextPatient();
					break;
				case(3):
					getNumWaiting();
					break;
				case(4):
					getNumServed();
					break;
				case(5):
					printList();
					break;
				case(6):					
					quitflag = true;
					break;
				default:
					break;
			}
			if(quitflag) {
				break;
			}			
		}
		System.out.println("\nGoodbye.");
		in.close();
	}
	
	public static void printMenu() {
		System.out.println("\nTriage Menu");
		System.out.println("-----------\n");
		System.out.println("1. Add patient");
		System.out.println("2. Get next patient");
		System.out.println("3. Get the number of waiting patients");
		System.out.println("4. Get the number patients served");
		System.out.println("5. Display list of waiting patients");
		System.out.println("6. Exit Application\n");
	}
	
	public static int getMenuChoice() {
		System.out.print("Choose an option [1-6]: ");
		if(in.hasNextInt()) {
			try {
				int i = Integer.parseInt(in.nextLine());
				return i;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}			
		}
		else {
			in.nextLine();
		}
		return -1; 
	}

	public static void addPatient() {
		float f;
		String name;
		System.out.println("\nAdd a new patient: ");
		System.out.print("Name: ");
		name = in.nextLine().trim();
		System.out.print("Priority level: ");
		try {
			f = Float.parseFloat(in.nextLine());
			list.addPatient(name, f);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("\n\n");
	}
	
	public static void getNextPatient() {
		String p = list.getNextPatient();
		if(p == null) {
			System.out.println("\nThere are no patients waiting!\n\n");
		}
		else {
			served++;
			System.out.println("\nNext patient is: " + p + "\n\n");
		}
	}
	
	public static void getNumWaiting() {
		System.out.println("\nThere are " + list.getNumWaiting() + " patients to be served.\n\n");
	}
	
	public static void getNumServed() {
		System.out.println("\nThere have been " + served + " patients served.\n\n");
	}
	
	public static void printList() {
		ArrayList<Patient> waitinglistarray = list.getList();
		System.out.println("\nPatients waiting to be served (incl. priority level): ");
		for(Patient temp : waitinglistarray) {
			System.out.println(temp.name + " (" + temp.priority + ")");
		}
		System.out.println("\n\n");
	}
}
