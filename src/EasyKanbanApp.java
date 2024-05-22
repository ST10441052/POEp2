import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EasyKanbanApp {
    private List<Task> tasks;

    public EasyKanbanApp() {
        this.tasks = new ArrayList<>();
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            String[] options = {"Add tasks", "Show report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "EasyKanban",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                    null, options, options[0]);

            switch (choice) {
                case 0:
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
                        String taskStatus = statusOptions[statusChoice];

                        Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, i, taskStatus);
                        tasks.add(newTask);

                        // Display task details using JOptionPane
                        JOptionPane.showMessageDialog(null, newTask.printTaskDetails());

                        JOptionPane.showMessageDialog(null, "Task successfully captured");
                    }

                    // Display total hours
                    int totalHours = Task.returnTotalHours(tasks);
                    JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + totalHours);
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;

                case 2:
                    exit = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
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

