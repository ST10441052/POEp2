
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TaskTest {
    private Task task1;
    private Task task2;
    private Task[] tasks;
    
      //this is the poep2 unit tests
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


// this is the poe p3 unit tests

@Test
public void testDeveloperEntriesForTasks() {
    
    String[] expectedDevelopers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Genda Oberhozer"};
    
   
    for (int taskId = 1; taskId <= expectedDevelopers.length; taskId++) {
        String expectedDeveloper = expectedDevelopers[taskId - 1];
        String actualDeveloper = getDeveloperNameForTask(taskId);
        assertEquals(expectedDeveloper, actualDeveloper, "The developer for task " + taskId + " should be " + expectedDeveloper);
    }
}


@Test
public void testDisplayDeveloperAndDurationForLongestTask() {
    
    
    String expected = "Genda Oberhozer , 11";
    String actual = getDeveloperAndDurationForLongestTask();

    assertEquals(expected, actual, "The developer and duration for the task with the longest duration should be 'Genda Oberhozer , 11'");
}

@Test
public void testSearchForTasks() {
   
    String taskName = "create login";
    String expected = "Mike Smith , create login";
    String actual = searchForTasks(taskName);

    assertEquals(expected, actual, "Searching for 'create login' should return 'Mike Smith , create login'");
}

