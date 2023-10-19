import java.util.Scanner;

public class BusTravel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int routeChoice;
        double speed = 0, distance = 0, arrivalTime = 0;

        System.out.println("======= WELCOME TO CEBU CITY! ========");
        System.out.println("You are in South Bus Terminal(Emall)\n");
        System.out.println("Adventure awaits at every turn, and today's routes are your guide.");
        System.out.println("To explore these exciting destinations, please check a route from the options below:\n");
        System.out.println("Route 1: Minglanilla\nRoute 2: San Fernando\nRoute 3: Carcar City\n");
        System.out.println("What route do you want to take?(Enter a number)");
        System.out.println("[1]Barili\n[2]Sibonga");
        System.out.print("Enter choice: ");
        routeChoice = scan.nextInt();

        switch (routeChoice) {
            case 1:
                // Barili route
                System.out.println("Route 4.1: Barili");
                System.out.println("Route 4.1.1: Dumanjug");
                System.out.println("Route 4.1.2: Alcantara");
                System.out.println("-MoalBoal\n");
                System.out.print("Enter your speed in kilometers per hour (km/hr): ");
                speed = scan.nextDouble();
                distance = 84.9;
                arrivalTime = distance / speed;
                int temp = (int) (arrivalTime * 100);
                int hour = temp / 100;
                int min = temp % 100;

                // Check if minutes need adjustment
                if (min >= 60) {
                    hour++;
                    min -= 60;
                }

                // Display results
                System.out.println("Speed: " + speed + " km/hr");
                System.out.println("Distance travelled: " + distance + " km");
                System.out.printf("ETA: %d hour and %d minutes", hour, min + 1);
                break;
            case 2:
                // Sibonga route
                int choice;
                System.out.println("Route 4.2: SIBONGA");
                System.out.println("What route do you want to take? (Enter route number)");
                System.out.println("[1]Dumanjug\n[2]Argao");
                System.out.print("Enter choice: ");
                choice = scan.nextInt();

                if (choice == 1) {
                    // Dumanjug route
                    System.out.println("Route 4.2: Sibonga");
                    System.out.println("Route 4.2.1: Dumanjug");
                    System.out.println("Route 4.2.2: Alcantara");
                    System.out.println("-MoalBoal");
                    System.out.print("Enter your speed in kilometers per hour (km/hr):  ");
                    speed = scan.nextDouble();
                    distance = 96.2;
                } else if (choice == 2) {
                    // Argao route
                    System.out.println("Route 4.2: Sibonga");
                    System.out.println("Route 5: Argao ");
                    System.out.println("Route 5.1: Ronda");
                    System.out.println("Route 5.2: Alcantara");
                    System.out.println("-MoalBoal");
                    System.out.print("Enter your speed in kilometers per hour (km/hr): ");
                    speed = scan.nextDouble();
                    distance = 126.7;
                }
                arrivalTime = distance / speed;
                int temp2 = (int) (arrivalTime * 100);
                int hour2 = temp2 / 100;
                int min2 = temp2 % 100;

                // Check if minutes need adjustment
                if (min2 >= 60) {
                    hour2++;
                    min2 -= 60;
                }
                // Display results
                System.out.println("Speed: " + speed + " km/hr");
                System.out.println("Distance travelled: " + distance + " km");
                System.out.printf("ETA: %d hours and %d minutes", hour2, min2 + 1);
                break;
        }
    }
}