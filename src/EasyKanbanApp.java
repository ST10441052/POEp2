import javax.swing.*;
import java.awt.*;


public class EasyKanbanApp {
    private Task[] tasks;
    private int taskCount;
    private ShowReport showReport;

    public EasyKanbanApp() {
        this.tasks = new Task[100]; // Assuming a maximum of 100 tasks
        this.taskCount = 0;
        this.showReport = new ShowReport(tasks, taskCount);
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            String[] options = {"Add tasks", "Show report", "Display Done Tasks", "Task with Longest Duration", "Search by Task Name", "Search by Developer", "Delete Task", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "EasyKanban",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);

            switch (choice) {
                case 0:
                    addTasks();
                    break;
                case 1:
                    showReport.showReport();
                    break;
                case 2:
                    showReport.displayDoneTasks();
                    break;
                case 3:
                    showReport.displayLongestDurationTask();
                    break;
                case 4:
                    showReport.searchByTaskName();
                    break;
                case 5:
                    showReport.searchByDeveloper();
                    break;
                case 6:
                    showReport.deleteTask();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    private void addTasks() {
        String numTasksStr = JOptionPane.showInputDialog("How many tasks would you like to enter?");
        int numberOfTasks = Integer.parseInt(numTasksStr);

        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");

            String taskDescription;
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                if (!Task.checkTaskDescription(taskDescription)) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                }
            } while (!Task.checkTaskDescription(taskDescription));

            String developerDetails = JOptionPane.showInputDialog("Enter developer first and last name:");

            String taskDurationStr = JOptionPane.showInputDialog("Enter task duration in hours:");
            double taskDuration = Double.parseDouble(taskDurationStr);

            String[] statusOptions = {"To Do", "Doing", "Done"};
            int statusChoice = showStatusOptionDialog();
            String status = statusOptions[statusChoice];

            Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskCount + 1, status);
            tasks[taskCount] = newTask;
            taskCount++;

            // Display task details using JOptionPane
            JOptionPane.showMessageDialog(null, newTask.printTaskDetails());

            JOptionPane.showMessageDialog(null, "Task successfully captured");
        }

        // Display total hours
        int totalHours = Task.returnTotalHours(tasks, taskCount);
        JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + totalHours);
    }

    private int showStatusOptionDialog() {
        JButton toDoButton = createButton("To Do", Color.BLUE, "\u270E"); // ✎ symbol
        JButton doingButton = createButton("Doing", Color.ORANGE, "\u23F3"); // ⏳ symbol
        JButton doneButton = createButton("Done", Color.GREEN, "\u2714"); // ✔ symbol

        JButton[] options = {toDoButton, doingButton, doneButton};

        JOptionPane pane = new JOptionPane("Select task status:", JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
        JDialog dialog = pane.createDialog(null, "Task Status");
        dialog.setVisible(true);

        return (int) pane.getValue();
    }

    private JButton createButton(String text, Color color, String symbol) {
        JButton button = new JButton(symbol + " " + text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        EasyKanbanApp kanbanApp = new EasyKanbanApp();
        kanbanApp.run();
    }
}
