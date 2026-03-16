import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        TaskManager tasks = new TaskManager();
        //load from file on boot
        tasks.loadFromFile("tasks.txt");

        System.out.println("Initialising...");
        System.out.println("Todo App. Commands: add, list, done, delete, quit");

        while(true){
            System.out.print("Enter Command: ");
            //reading the whole input:
            String line = input.nextLine();
            //splitting the command from the argument:
            String[] parts = line.split(" ",2);
            String command = parts[0];
            //parsing command:
            switch (command) {
                case "quit":
                    //exception: checking for quit command
                    //save data to file before quitting
                    tasks.saveToFile("tasks.txt");
                    System.out.print("Bye.");
                    return;

                //else map the commands to respective functions
                case "add":
                    //check if argument is given
                    if(parts.length < 2 || parts[1].isBlank()){
                        System.out.println("please add <title>.");
                        break;
                    }
                    String title = parts[1];
                    tasks.addTask(title);
                    System.out.println("Added [] " + title+".");
                    break;
                case "done": {
                    //check if argument is give
                    if(parts.length < 2 || parts[1].isBlank()){
                        System.out.println("please add <task number>.");
                        break;
                    }
                    //check for invalid argument data type
                    try{
                        int taskNum = Integer.parseInt(parts[1]);
                        tasks.markDone(taskNum);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter valid task number.");
                    }

                    break;
                }
                case "list":
                    if (tasks.noTasks()) System.out.println("No pending tasks");
                    else {
                        System.out.println("Tasks still remaining:");
                        tasks.listTasks();
                    }
                    break;
                case "delete": {
                    //check if argument is give
                    if(parts.length < 2 || parts[1].isBlank()){
                        System.out.println("please add <task number>.");
                        break;
                    }
                    //check for invalid argument data type
                    try{
                        int taskNum = Integer.parseInt(parts[1]);
                        tasks.deleteTask(taskNum);
                        System.out.println("Deleted " + taskNum+".");
                    }catch(NumberFormatException e){
                        System.out.println("Please enter valid task number.");
                    }

                    break;
                }
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}