package TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User[] userArray = new User[5];
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to TaskManager");
            System.out.println("Enter your name ");
            boolean isExistingUser = false;
            int userPosition = 0;
            String userName = scan.nextLine();


            for (int count = 0; count < userArray.length; count++) {

                if (userArray[count] == null) {
                    continue;
                }
                if (userArray[count].equals(userName)) {
                      isExistingUser = true;
                      userPosition = count;
                      break;

                }
            }
            User currentUser;
            if (isExistingUser == false) {
                currentUser = new User(userName);
                for (int count = 0; count < userArray.length; count++) {
                    if (userArray[count] != null) {
                        continue;
                    }
                    userArray[count] = currentUser;
                    break;
                }
            }

            else {
                currentUser = userArray[userPosition];
            }

                Integer choice = 0;
                while (choice != 5) {
                    System.out.print("Welcome ");
                    System.out.println(currentUser.getUserName());

                    System.out.println("1.Add Task");
                    System.out.println("2.List all my tasks");
                    System.out.println("3.Update");
                    System.out.println("4.Delete");
                    System.out.println("5.Exit");
                    choice = new Integer(scan.nextLine());

                    if (choice == 1) {
                        System.out.println("Enter your Task ");
                        String taskDescription = scan.nextLine();
                        Task userTask = new Task(taskDescription);


                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] == null) {
                                currentUser.getTaskArray()[count] = userTask;
                                break;
                            }
                        }
                        currentUser.getTaskArray()[0] = userTask;
                        System.out.println("Task added sucessfully ");


                    } else if (choice == 5) {
                        System.out.println("Thanks for using our app");
                    } else if (choice == 2) {
                        boolean taskChecker = false;
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] != null) {
                                System.out.print(count + 1);
                                System.out.print(". ");
                                System.out.println(currentUser.getTaskArray()[count].getTaskDescription());
                                taskChecker = true;
                            }
                        }
                    }
                    else if (choice == 3) {
                        boolean taskChecker = false;
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] != null) {
                                System.out.print(count + 1);
                                System.out.print(". ");
                                System.out.println(currentUser.getTaskArray()[count].getTaskDescription());

                                System.out.println("Enter your choice from the list to update");
                                Integer updateChoice = new Integer(scan.nextLine());
                                System.out.println("Enter new task to update");
                                Task newTask = new Task(scan.nextLine());

                                currentUser.getTaskArray()[updateChoice - 1] = newTask;
                                System.out.println("New task updated sucessfully ");

                                taskChecker = true;
                            }

                            if (taskChecker == false) {
                                System.out.println("There is no task still now add new tasks to update");

                            }

                        }

                    }
                    else if (choice == 4) {
                        boolean taskChecker = false;
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] != null) {
                                System.out.print(count + 1);
                                System.out.print(". ");
                                System.out.println(currentUser.getTaskArray()[count].getTaskDescription());

                                System.out.println("Enter your choice from the list to delete");
                                Integer deleteChoice = new Integer(scan.nextLine());


                                currentUser.getTaskArray()[deleteChoice - 1] = null;
                                System.out.println("Task deleted sucessfully");

                                taskChecker = true;
                            }

                            if (taskChecker == false) {
                                System.out.println("There is no task to delete");
                            }

                        }
                    }

                    
                }
        }
    }
}
