import java.util.List;

public class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private double taskDuration;
    private int taskNumber;
    private String taskStatus;
    private String taskID;

    public Task(String taskName, String taskDescription, String developerDetails, double taskDuration, int taskNumber, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskNumber = taskNumber;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    public static boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    private String createTaskID() {
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;
        String developerNamePart = developerDetails.split(" ").length > 1 ?
                developerDetails.split(" ")[developerDetails.split(" ").length - 1].substring(0, 3) : developerDetails;
        return (taskNamePart + ":" + taskNumber + ":" + developerNamePart).toUpperCase();
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours\n";
    }

    public static int returnTotalHours(List<Task> tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }

    
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public String getTaskID() {
        return taskID;
    }
}
