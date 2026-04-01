import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        TreeMap<Integer, String> tmap = new TreeMap<>();

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. ArrayList CRUD");
            System.out.println("2. HashMap CRUD");
            System.out.println("3. TreeMap CRUD");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    String item = sc.next();
                    list.add(item);

                    System.out.println("List: " + list);

                    if (!list.isEmpty()) {
                        System.out.print("Enter index to update: ");
                        int idx = sc.nextInt();

                        if (idx >= 0 && idx < list.size()) {
                            System.out.print("Enter new value: ");
                            String val = sc.next();
                            list.set(idx, val);
                        } else {
                            System.out.println("Invalid index");
                        }
                    }

                    System.out.println("After Update: " + list);

                    System.out.print("Enter element to delete: ");
                    String del = sc.next();
                    list.remove(del);

                    System.out.println("After Delete: " + list);
                    break;

                case 2:
                    System.out.print("Enter key and value: ");
                    int key = sc.nextInt();
                    String value = sc.next();
                    map.put(key, value);

                    System.out.println("Map: " + map);

                    System.out.print("Enter key to update: ");
                    key = sc.nextInt();
                    System.out.print("Enter new value: ");
                    value = sc.next();
                    map.put(key, value);

                    System.out.println("After Update: " + map);

                    System.out.print("Enter key to delete: ");
                    key = sc.nextInt();
                    map.remove(key);

                    System.out.println("After Delete: " + map);
                    break;

                case 3:
                    System.out.print("Enter key and value: ");
                    key = sc.nextInt();
                    value = sc.next();
                    tmap.put(key, value);

                    System.out.println("TreeMap: " + tmap);

                    System.out.print("Enter key to update: ");
                    key = sc.nextInt();
                    System.out.print("Enter new value: ");
                    value = sc.next();
                    tmap.put(key, value);

                    System.out.println("After Update: " + tmap);

                    System.out.print("Enter key to delete: ");
                    key = sc.nextInt();
                    tmap.remove(key);

                    System.out.println("After Delete: " + tmap);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }
}