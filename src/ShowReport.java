import javax.swing.*;

public class ShowReport {

    private Task[] tasks;
    private int taskCount;

    public ShowReport(Task[] tasks, int taskCount) {
        this.tasks = tasks;
        this.taskCount = taskCount;
    }

    public void displayDoneTasks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            if ("Done".equalsIgnoreCase(tasks[i].getTaskStatus())) {
                sb.append("Developer: ").append(tasks[i].getDeveloperDetails())
                  .append(", Task Name: ").append(tasks[i].getTaskName())
                  .append(", Duration: ").append(tasks[i].getTaskDuration()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No tasks with status 'Done'");
    }

    public void displayLongestDurationTask() {
        if (taskCount == 0) {
            JOptionPane.showMessageDialog(null, "No tasks available");
            return;
        }
        Task longestTask = tasks[0];
        for (int i = 1; i < taskCount; i++) {
            if (tasks[i].getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = tasks[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Developer: " + longestTask.getDeveloperDetails() 
                                          + ", Duration: " + longestTask.getTaskDuration());
    }

    public void searchByTaskName() {
        String taskName = JOptionPane.showInputDialog("Enter the task name to search:");
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskName().equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + tasks[i].getTaskName() 
                                                  + ", Developer: " + tasks[i].getDeveloperDetails() 
                                                  + ", Status: " + tasks[i].getTaskStatus());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found");
    }

    public void searchByDeveloper() {
        String developerName = JOptionPane.showInputDialog("Enter the developer name to search:");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getDeveloperDetails().equalsIgnoreCase(developerName)) {
                sb.append("Task Name: ").append(tasks[i].getTaskName())
                  .append(", Status: ").append(tasks[i].getTaskStatus()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No tasks found for the developer");
    }

    public void deleteTask() {
        String taskName = JOptionPane.showInputDialog("Enter the task name to delete:");
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskName().equalsIgnoreCase(taskName)) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the task: " 
                                                              + taskName + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    tasks[i] = tasks[taskCount - 1]; // Replace the deleted task with the last task
                    taskCount--;
                    JOptionPane.showMessageDialog(null, "Task deleted successfully");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found");
    }

    public void showReport() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            sb.append(tasks[i].printTaskDetails()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No tasks available");
    }
}
