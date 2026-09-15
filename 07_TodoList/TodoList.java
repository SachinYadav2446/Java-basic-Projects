import java.util.ArrayList;
import java.util.Scanner;
public class TodoList {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   To-Do List Application            ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        boolean continueProgram = true;
        while(continueProgram) {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.\n");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            switch(choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewAllTasks();
                    break;
                case 3:
                    markTaskComplete();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    viewStatistics();
                    break;
                case 6:
                    continueProgram = false;
                    System.out.println("\nThank you for using To-Do List!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.\n");
            }
        }
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add a new task");
        System.out.println("2. View all tasks");
        System.out.println("3. Mark task as complete");
        System.out.println("4. Delete a task");
        System.out.println("5. View statistics");
        System.out.println("6. Exit");
    }
    static void addTask() {
        System.out.print("\nEnter task description: ");
        String description = scanner.nextLine().trim();
        if (description.isEmpty()) {
            System.out.println("Task cannot be empty!");
            return;
        }
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine().trim();
        Task newTask = new Task(description, priority);
        tasks.add(newTask);
        System.out.println("✓ Task added successfully!");
    }
    static void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\n📭 No tasks found!");
            return;
        }
        System.out.println("\n--- All Tasks ---");
        System.out.println("┌─────┬─────────────────────────────┬──────────┬──────────┐");
        System.out.println("│ ID  │ Task                        │ Priority │ Status   │");
        System.out.println("├─────┼─────────────────────────────┼──────────┼──────────┤");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "✓ Done" : "○ Pending";
            System.out.printf("│ %-3d │ %-27s │ %-8s │ %-8s │\n", 
                            (i + 1), task.getDescription(), task.getPriority(), status);
        }
        System.out.println("└─────┴─────────────────────────────┴──────────┴──────────┘");
    }
    static void markTaskComplete() {
        if (tasks.isEmpty()) {
            System.out.println("\n📭 No tasks to mark!");
            return;
        }
        viewAllTasks();
        System.out.print("Enter task ID to mark complete: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input!");
            scanner.nextLine();
            return;
        }
        int taskId = scanner.nextInt() - 1;
        if (taskId < 0 || taskId >= tasks.size()) {
            System.out.println("Invalid task ID!");
            return;
        }
        Task task = tasks.get(taskId);
        if (task.isCompleted()) {
            System.out.println("Task is already completed!");
        } else {
            task.setCompleted(true);
            System.out.println("✓ Task marked as complete!");
        }
    }
    static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("\n📭 No tasks to delete!");
            return;
        }
        viewAllTasks();
        System.out.print("Enter task ID to delete: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input!");
            scanner.nextLine();
            return;
        }
        int taskId = scanner.nextInt() - 1;
        if (taskId < 0 || taskId >= tasks.size()) {
            System.out.println("Invalid task ID!");
            return;
        }
        Task removedTask = tasks.remove(taskId);
        System.out.println("✓ Task deleted: " + removedTask.getDescription());
    }
    static void viewStatistics() {
        int total = tasks.size();
        int completed = 0;
        int pending = 0;
        int highPriority = 0;
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completed++;
            } else {
                pending++;
            }
            if (task.getPriority().equalsIgnoreCase("High")) {
                highPriority++;
            }
        }
        System.out.println("\n--- Statistics ---");
        System.out.println("Total tasks: " + total);
        System.out.println("Completed: " + completed);
        System.out.println("Pending: " + pending);
        System.out.println("High priority tasks: " + highPriority);
        if (total > 0) {
            double completionRate = (completed * 100.0) / total;
            System.out.println("Completion rate: " + String.format("%.1f", completionRate) + "%");
        }
    }
}
class Task {
    private String description;
    private String priority;
    private boolean completed;
    public Task(String description, String priority) {
        this.description = description;
        this.priority = priority.isEmpty() ? "Medium" : priority;
        this.completed = false;
    }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
