import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

class Task {
    private String name;
    private int duration; 

    public Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void execute() {
        try {
            System.out.println("Executing task: " + name + " for " + duration + " seconds.");
            Thread.sleep(duration * 1000);
            System.out.println("Task " + name + " completed.");
        } catch (InterruptedException e) {
            System.out.println("Task " + name + " was interrupted.");
        }
    }
}

class TaskScheduler {
    private ExecutorService executor;
    private List<Task> tasks;

    public TaskScheduler() {
        executor = Executors.newFixedThreadPool(3); 
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void executeTasks() {
        for (Task task : tasks) {
            executor.submit(() -> task.execute());
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}

class TaskFileManager {
    private static final String FILE_NAME = "tasks.txt";

    public static void saveTasksToFile(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.getName() + "," + task.getDuration());
                writer.newLine();
            }
            System.out.println("Tasks have been saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    public static List<Task> loadTasksFromFile() {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int duration = Integer.parseInt(parts[1]);
                tasks.add(new Task(name, duration));
            }
            System.out.println("Tasks have been loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
        return tasks;
    }
}

public class AdvancedJavaExample {
    public static
