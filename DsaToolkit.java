import java.util.*;
public class DsaToolkit {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\n=== DSA TOOLKIT ===");
                System.out.println("1. Stack Operations");
                System.out.println("2. Queue Operations");
                System.out.println("3. Linked List Operations");
                System.out.println("4. Searching");
                System.out.println("5. Sorting");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> stackOperations(sc);
                    case 2 -> queueOperations(sc);
                    case 3 -> linkedListOperations(sc);
                    case 4 -> searchOperations(sc);
                    case 5 -> sortOperations(sc);
                    case 0 -> System.out.println("Exiting... Thank you!");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 0);
            sc.close();
        }

        // Stack Operations
        public static void stackOperations(Scanner sc) {
            Stack<Integer> stack = new Stack<>();
            int choice;
            do {
                System.out.println("\n-- Stack Operations --");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Display");
                System.out.println("0. Back");
                System.out.print("Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter element to push: ");
                        stack.push(sc.nextInt());
                    }
                    case 2 -> System.out.println("Popped: " + (stack.isEmpty() ? "Stack is empty" : stack.pop()));
                    case 3 -> System.out.println("Top: " + (stack.isEmpty() ? "Stack is empty" : stack.peek()));
                    case 4 -> System.out.println("Stack: " + stack);
                }
            } while (choice != 0);
        }

        // Queue Operations
        public static void queueOperations(Scanner sc) {
            Queue<Integer> queue = new LinkedList<>();
            int choice;
            do {
                System.out.println("\n-- Queue Operations --");
                System.out.println("1. Enqueue");
                System.out.println("2. Dequeue");
                System.out.println("3. Peek");
                System.out.println("4. Display");
                System.out.println("0. Back");
                System.out.print("Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter element to enqueue: ");
                        queue.offer(sc.nextInt());
                    }
                    case 2 -> System.out.println("Dequeued: " + (queue.isEmpty() ? "Queue is empty" : queue.poll()));
                    case 3 -> System.out.println("Front: " + (queue.isEmpty() ? "Queue is empty" : queue.peek()));
                    case 4 -> System.out.println("Queue: " + queue);
                }
            } while (choice != 0);
        }

        // Linked List Operations
        public static void linkedListOperations(Scanner sc) {
            LinkedList<Integer> list = new LinkedList<>();
            int choice;
            do {
                System.out.println("\n-- Linked List Operations --");
                System.out.println("1. Add at End");
                System.out.println("2. Add at Start");
                System.out.println("3. Remove by Index");
                System.out.println("4. Display");
                System.out.println("0. Back");
                System.out.print("Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter value: ");
                        list.addLast(sc.nextInt());
                    }
                    case 2 -> {
                        System.out.print("Enter value: ");
                        list.addFirst(sc.nextInt());
                    }
                    case 3 -> {
                        System.out.print("Enter index to remove: ");
                        int idx = sc.nextInt();
                        if (idx >= 0 && idx < list.size())
                            list.remove(idx);
                        else
                            System.out.println("Invalid index!");
                    }
                    case 4 -> System.out.println("List: " + list);
                }
            } while (choice != 0);
        }

        // Searching
        public static void searchOperations(Scanner sc) {
            System.out.println("\n-- Searching --");
            System.out.print("Enter array size: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.print("Enter array elements: ");
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.print("Enter key to search: ");
            int key = sc.nextInt();

            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search (sorted array)");
            int choice = sc.nextInt();

            int index = -1;
            if (choice == 1) {
                for (int i = 0; i < n; i++)
                    if (arr[i] == key) {
                        index = i;
                        break;
                    }
            } else if (choice == 2) {
                Arrays.sort(arr); // Ensure array is sorted
                int l = 0, r = n - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (arr[mid] == key) {
                        index = mid;
                        break;
                    } else if (arr[mid] < key)
                        l = mid + 1;
                    else
                        r = mid - 1;
                }
            }

            System.out.println(index == -1 ? "Key not found" : "Key found at index " + index);
        }

        // Sorting
        public static void sortOperations(Scanner sc) {
            System.out.println("\n-- Sorting --");
            System.out.print("Enter array size: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.print("Enter array elements: ");
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> bubbleSort(arr);
                case 2 -> selectionSort(arr);
                case 3 -> insertionSort(arr);
            }

            System.out.print("Sorted array: ");
            for (int num : arr) System.out.print(num + " ");
            System.out.println();
        }

        public static void bubbleSort(int[] a) {
            int n = a.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (a[j] > a[j + 1]) {
                        int tmp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = tmp;
                    }
        }

        public static void selectionSort(int[] a) {
            int n = a.length;
            for (int i = 0; i < n - 1; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++)
                    if (a[j] < a[min]) min = j;
                int tmp = a[min];
                a[min] = a[i];
                a[i] = tmp;
            }
        }

    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key)
                a[j + 1] = a[j--];
            a[j + 1] = key;
            }
        }
   }