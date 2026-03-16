public class Task {
    //attributes:
    private int taskId = 0;
    private String title = "";
    private boolean status = false;

    //methods:
    //getters
    public int getID(){
        return taskId;
    }
    public String getTitle(){
        return title;
    }
    public boolean isDone(){
        return status;
    }

    //setters
    public void setID(int ID){
        taskId = ID;
    }
    public void setTitle(String text){
        title = text;
    }
    public void setDone(Boolean value){
        status = value;
    }
}