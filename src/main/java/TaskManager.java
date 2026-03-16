import java.io.*;
import java.util.*;

public class TaskManager {
    //attributes:
    private ArrayList<Task> taskList = new ArrayList<>();

    //methods:
    //read and write methods-
    public void saveToFile(String fileName){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for(Task temp:taskList){
                //write all tasks to the file one by one
                String stat = temp.isDone()? "true":"false";
                writer.write(temp.getID()+","+temp.getTitle()+","+stat);
                writer.newLine();
            }
            writer.close();
        }catch(IOException e){
            System.out.println("File error: "+e.getMessage());
        }
    }
    public void loadFromFile(String fileName){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            //end of file should return NULL and break while
            while((line = reader.readLine()) != null){
                String[] taskInfo = line.split(",",3);
                //insert task
                Task temp = new Task();
                temp.setID(Integer.parseInt(taskInfo[0]));
                temp.setTitle(taskInfo[1]);
                temp.setDone(Boolean.parseBoolean(taskInfo[2]));
                taskList.add(temp);
            }
            reader.close();
        }catch(FileNotFoundException e1){
            //do nothing : empty file is fine
        }catch(IOException e2){
            System.out.println("File Error: "+e2.getMessage());
        }
    }
    //task methods-
    public void addTask(String title){
        Task newTask = new Task();
        newTask.setID(taskList.size()+1);
        newTask.setTitle(title);
        taskList.add(newTask);
    }
    public void listTasks(){
        int n = taskList.size();
        for (Task temp : taskList) {
            String stat_display = temp.isDone()? "[X]":"[ ]";
            System.out.print(temp.getID() + ". " +stat_display +" "+ temp.getTitle() + "\n");
        }
    }
    public void markDone(int TaskNum){
        int idx = TaskNum-1;
        //edge case:
        if(idx >= taskList.size()){
            System.out.println("No such Task exists");
            return;
        }

        taskList.get(idx).setDone(true);
        System.out.println("Marked (" + taskList.get(idx).getTitle() + ") as done");
    }
    public void deleteTask(int TaskNum){
        int idx = TaskNum-1;
        //edge case:
        if(idx >= taskList.size()){
            System.out.println("No such Task exists");
            return;
        }
        taskList.remove(idx);
    }
    public boolean noTasks(){
        return taskList.isEmpty();
    }
}