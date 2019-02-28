package com.vasbinder.week7;

import java.util.ArrayList;
import java.util.Scanner;


public class TaskList {
    private Scanner scan = new Scanner(System.in);


    public boolean updateTask(ArrayList<Task> getList) {
        boolean check = true;
        int checkTask = 0;


        System.out.println("What task would you like to update?(By ID number)");
        int taskId = scan.nextInt();
        scan.nextLine();

        for (Task getTask : getList) {

            if (taskId == getTask.getId()) {

                getList.remove(getTask);
                check = true;
            }
            if (checkTask > getList.size()) {

                System.out.println("Input a valid task!");
                check = false;
            }
            checkTask++;
        }
        return check;
    }


    public void listTask(ArrayList<Task> getList){
        int idNum = 1;
        for (int i = 5; i>0;i--) {

            for (Task getTask : getList) {

                if (getTask.getTaskPri() == i) {

                    System.out.println(idNum+") " + getTask.getTaskName()+ "\nDescription: " + getTask.getTaskDes()
                            + "\nPriority: " + i);
                    getTask.setId(idNum);
                    idNum++;
                }
            }
        }
    }
}