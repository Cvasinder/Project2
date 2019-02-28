package com.vasbinder.week7;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Task> taskList = new ArrayList<>();
    static TaskList list = new TaskList();

    static boolean whatTask(){

        String whichTask;
        boolean exit = false;

        System.out.println("Please choose an option:\n" +
                "(1) Add a task.\n" +
                "(2) Remove a task.\n" +
                "(3) Update a task.\n" +
                "(4) List all tasks.\n" +
                "(0) Exit.");
        whichTask = scan.nextLine();

        switch (whichTask){


            case "1": addTask();
                break;

            case "2":

                list.listTask(taskList);
                removeTask();
                break;

            case "3":

                list.listTask(taskList);
                if(list.updateTask(taskList)){addTask();}
                break;

            case "4":

                list.listTask(taskList);
                break;

            case "0":

                exit = true;
                break;

            default:

                System.out.println("Not a valid input!");
                break;
        }
        return exit;
    }

    static void addTask() {

        int taskPri = 0;
        boolean validInput = false;

        System.out.println("What is the name of your new task?");
        String askTask = scan.nextLine();

        System.out.println("What is the description of the task " + askTask + ":");
        String taskDes = scan.nextLine();

        while(!validInput){

            try{
                System.out.println("What is the priority of this task?(1-5)");
                taskPri = scan.nextInt();
                scan.nextLine();
                if(0<taskPri & taskPri<6){

                    validInput = true;
                }
                else{
                    System.out.println("input a valid priority number(1-5)");
                }

            }catch (Exception e){
                scan.nextLine();
                System.out.println("invalid input try again!");
            }
        }

        Task newTask = new Task(askTask, taskDes, taskPri);
        taskList.add(newTask);
    }

    static void removeTask() {

        int checkTask = 0;
        int taskId = 0;
        boolean validInput = false;

        while (!validInput) {

            try {
                System.out.println("What task would you like to remove?(By ID number)");
                taskId = scan.nextInt();
                scan.nextLine();
                validInput = true;

            } catch (Exception e) {
                scan.nextLine();
                System.out.println("invalid input try again!");
            }
        }

        for (Task getTask : taskList) {

            if (taskId == getTask.getId()) {
                taskList.remove(getTask);
            }
            else if (checkTask > taskList.size()) {

                System.out.println("Input a valid task!");
                removeTask();
            }
            checkTask++;
        }
    }

    public static void main(String[] args) {

        boolean exit;
        do{

            exit = whatTask();
        }while(!exit);
    }
}
