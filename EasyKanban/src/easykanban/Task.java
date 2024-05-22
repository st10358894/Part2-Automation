package easykanban;

public class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private int taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, int taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskID() {
        // Constructing Task ID based on the task name, ID, and developer details
        return taskName.substring(0, 2).toUpperCase() + ":" + taskID + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    public static boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    Object printTaskDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
