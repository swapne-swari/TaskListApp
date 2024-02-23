package basic;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {

    private ArrayList<String> tasks;

    public TaskListApp() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index. Task not removed.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty.");
        } else {
            System.out.println("Task List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TaskListApp taskList = new TaskListApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    taskList.addTask(taskToAdd);
                    break;

                case 2:
                    if (!taskList.tasks.isEmpty()) {
                        System.out.print("Enter task index to remove: ");
                        int indexToRemove = scanner.nextInt();
                        taskList.removeTask(indexToRemove - 1);
                    } else {
                        System.out.println("Task list is empty. Nothing to remove.");
                    }
                    break;

                case 3:
                    taskList.listTasks();
                    break;

                case 4:
                    System.out.println("Exiting Task List Application. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
