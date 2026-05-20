
import java.util.Scanner;


public class Demo {
    public static void main(String[] args) {
        Queue qResto = new Queue();
        Scanner sc = new Scanner(System.in);
        int menu;

        do { 
            System.out.println("\n===============================================================");
            System.out.println("                   ROYAL DELISH QUEUE SYSTEM                   ");
            System.out.println("===============================================================");
            System.out.println("1. Add Queue");
            System.out.println("2. Print Queue");
            System.out.println("3. Remove Queue and Messages");
            System.out.println("4. Order Report");
            System.out.println("0. Exit");
            System.out.print("Select menu : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Buyer Name\t: ");
                    String name = sc.nextLine();
                    System.out.print("Phone Number\t: ");
                    String ph = sc.nextLine();

                    Buyer newBuyer = new Buyer(qResto.queueCounter, name, ph);
                    qResto.addQueue(newBuyer);

                    System.out.println("Successfully added to queue with ticket number: " + qResto.queueCounter);
                    System.out.println("===============================================================");

                    qResto.queueCounter++;
                    break;
                case 2:
                    qResto.printQueue();
                    break;
                case 3:
                    NodeBuyer callNodeBuyer = qResto.removeQueue();

                    if (callNodeBuyer != null) {
                        System.out.println("===============================================================");
                        System.out.println("Calling Queue Number\t: " + callNodeBuyer.data.queueNum);
                        System.out.println("Customer Name\t\t: " + callNodeBuyer.data.name);
                        System.out.println("===============================================================");

                        System.out.print("Enter Order Code\t: ");
                        int code = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Food Order\t: ");
                        String food = sc.nextLine();
                        System.out.print("Enter Total Price\t: ");
                        int price = sc.nextInt();
                        sc.nextLine();

                        Order newOrder = new Order(code, food, price);
                        qResto.addOrder(newOrder);

                        System.out.println("Order for " + callNodeBuyer.data.name + " has been successfully recorded!");
                    }
                    break;
                case 4:
                    qResto.printReport();
                    break;
                case 0:
                    System.out.println("Thank you for using Royal Delish System!");
                    break;
                default:
                    System.out.println("Invalid option! Please select a menu between 0 and 4.");
            }
        } while (menu != 0);
        sc.close();
    }
}