import java.util.*;

public class TaskManager {
    //attributes:
    private ArrayList<Task> taskList = new ArrayList<>();

    //methods:
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

        taskList.get(idx).setDone();
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