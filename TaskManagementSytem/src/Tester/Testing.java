package Tester;

import static taskValidationRules.Taskvalidation.validateAll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import core.Status;
import core.Task;

public class Testing {

	public static void main(String[] args) {
		Map<Integer, Task>tasks=new HashMap<>();
	    try(Scanner sc=new Scanner(System.in)){
	    	boolean exit=false;
	    	Task t1;
	    	while(!exit) {
	    		System.out.println("1.Add new Task");
	    		System.out.println("2.Delete the Task");
	    		System.out.println("3.Update task status");
	    		System.out.println("4.Display all pending Task");
	    		System.out.println("5.Display all pending tasks for today");
	    		System.out.println("6.Display all tasks sorted by TaskDate");
	    		System.out.println("Enter your choice");
	    		int choice=sc.nextInt();	    	
	    		switch(choice) {
	    		case 1:
	    			System.out.println("enter task details:taskName, description, taskDate");
	    			t1=validateAll(sc.next(),sc.next(),sc.next());
	    			tasks.put(t1.getTaskId(),t1);
	    			System.out.println("Task added successfully!!!");
	    			break;
	    		case 2:
	    			System.out.println("enter id to delete");
	    			t1=tasks.get(sc.nextInt());
	    			if(t1==null) {
	    				System.out.println("Task doesn't exist..");
	    			}
	    			else {
	    				t1.setActive(false);
	    			System.out.println("task deleted successfully!!!");
	    			}
	    			break;
	    		case 3:
	    			System.out.println("enter id to update task status");
	    			t1=tasks.get(sc.nextInt());
	    			if(t1==null) {
	    				System.out.println("Task doesn't exist..");
	    			}
	    			else {
	    				System.out.println("enter status to update: ");
	    				t1.setStatus(Status.valueOf(sc.next().toUpperCase()));
	    			System.out.println("status updated successfully!!!");
	    			}
	    			
	    			break;
	    		case 4:
	    			ArrayList<Task>taskValues=new ArrayList<Task>(tasks.values());
	    			for(Task t:taskValues) {
	    				if(t.getStatus().equals(Status.valueOf("PENDING"))) {
	    					System.out.println(t);
	    				}
	    			}
	    			break;
	    		case 5:
	    			taskValues=new ArrayList<Task>(tasks.values());
	    			for(Task t:taskValues) {
	    				if(t.getStatus().equals(Status.valueOf("PENDING"))) {
	    					if(t.getTaskDate().isBefore(LocalDate.now().plusDays(1))) {
	    						System.out.println(t);
	    					}
	    					
	    				}
	    			}
	    			break;
	    		case 6:
	    			taskValues=new ArrayList<Task>(tasks.values());
	    			Comparator <Task>comp=(t11,t2)->(t11.getTaskDate().compareTo(t2.getTaskDate()));
	    			Collections.sort(taskValues,comp);
	    			for(Task t: taskValues) {
	    				System.out.println(t);
	    			}
	    			break;
	    		}
	    	
	    	}
	    }
	    catch(Exception c){
            c.printStackTrace();    	
	    }
	}

	

}
