
import java.util.List;

import org.junit.Test;

public class TaskTest {
    private Task task1;
    private Task task2;
    private List<Task> tasks;

    

    @Test
    public void testTaskDescription() {
        assertTrue(Task.checkTaskDescription(task1.getTaskDescription()));
        assertTrue(Task.checkTaskDescription(task2.getTaskDescription()));
    }

    @Test
    public void testCreateTaskID() {
        assertEquals("LO:0:SON", task1.getTaskID());
        assertEquals("AD:1:SON", task2.getTaskID());
    }

    @Test
    public void testPrintTaskDetails() {
        String task1Details = "Task Status: To Do\n" +
                              "Developer Details: Robyn Harrison\n" +
                              "Task Number: 0\n" +
                              "Task Name: Login Feature\n" +
                              "Task Description: Create login to authenticate users\n" +
                              "Task ID: LO:0:SON\n" +
                              "Duration: 8.0 hours";
        
        String task2Details = "Task Status: Doing\n" +
                              "Developer Details: Robyn Harrison\n" +
                              "Task Number: 1\n" +
                              "Task Name: Add Task Feature\n" +
                              "Task Description: Create task feature to add users\n" +
                              "Task ID: AD:1:SON\n" +
                              "Duration: 10.0 hours";
        
        assertEquals(task1Details, task1.printTaskDetails());
        assertEquals(task2Details, task2.printTaskDetails());
    }

    @Test
    public void testReturnTotalHours() {
        assertEquals(18, Task.returnTotalHours(tasks));
    }
}
