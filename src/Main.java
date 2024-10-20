import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<Laptop>();
        laptops.add(new Laptop("Honor", 16, 128, "Windows", "Green"));
        laptops.add(new Laptop("Apple", 8, 256, "MacOS", "Silver"));
        laptops.add(new Laptop("Lenovo", 32, 1024, "Windows", "Gray"));
        laptops.add(new Laptop("Asus", 10, 2048, "Linux", "Red"));
        laptops.add(new Laptop("Huawei", 8, 512, "Windows", "Gray"));
        laptops.add(new Laptop("Acer", 16, 1024, "Windows", "Blue"));

        Map<String, Object> filters = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the criteria to filter:");
        System.out.println("1 - RAM");
        System.out.println("2 - Volume HDD");
        System.out.println("3 - OS");
        System.out.println("4 - Color");
        System.out.println("0 - Finalize selection");

        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Minimum amount of RAM?");
                    filters.put("ram", scanner.nextInt());
                    System.out.println("Accepted");
                    break;
                case 2:
                    System.out.println("Minimum hard disk space?");
                    filters.put("hdd", scanner.nextInt());
                    System.out.println("Accepted");
                    break;
                case 3:
                    System.out.println("The operating system?");
                    filters.put("os", scanner.next());
                    System.out.println("Accepted");
                    break;
                case 4:
                    System.out.println("Color?");
                    filters.put("color", scanner.next());
                    System.out.println("Accepted");
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }

        Set<Laptop> filterLaptops = laptops.stream()
                .filter(laptop -> filters.getOrDefault("ram", 0) instanceof Integer && laptop.ram >= (int) filters.getOrDefault("ram", 0))
                .filter(laptop -> filters.getOrDefault("hdd", 0) instanceof Integer && laptop.hdd >= (int) filters.getOrDefault("hdd", 0))
                .filter(laptop -> filters.getOrDefault("os", "").equals("") || laptop.os.equalsIgnoreCase((String) filters.getOrDefault("os", "")))
                .filter(laptop -> filters.getOrDefault("color", "").equals("") || laptop.color.equalsIgnoreCase((String) filters.getOrDefault("color", "")))
                .collect(Collectors.toSet());

        System.out.println("Filtered Laptops:");
        for (Laptop laptop : filterLaptops) {
            System.out.println(laptop);
        }
    }
}
