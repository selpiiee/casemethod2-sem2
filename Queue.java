public class Queue {
    NodeBuyer head = null;
    NodeBuyer tail = null;
    int queueCounter = 1;

    NodeOrder headOrder = null;
    NodeOrder tailOrder = null;

    boolean isEmpty() {
        return head == null;
    }

    void addQueue(Buyer newBuyer) {
        NodeBuyer newNode = new NodeBuyer(null, newBuyer, null);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void printQueue() {
        if (!isEmpty()) {
            System.out.println("======================================================");
            System.out.println("                  BUYER WAITING LIST                  ");
            System.out.println("======================================================");
            NodeBuyer temp = head;
            while(temp != null) {
                temp.data.print();
                temp = temp.next;
            }
            System.out.println("");
        } else {
            System.out.println("The list is currently empty!!");
        }
    }

    NodeBuyer removeQueue() {
        if (isEmpty()) {
            System.out.println("The list is currently empty!!");
            return null;
        }
        NodeBuyer temp = head;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return temp;
    }

    void addOrder(Order newOrder) {
        NodeOrder neworder = new NodeOrder(null, newOrder, null);
        if (headOrder == null) {
            headOrder = tailOrder = neworder;
        } else {
            tailOrder.next = neworder;
            neworder.prev = tailOrder;
            tailOrder = neworder;
        }
    }

    void sortOrdersByName() {
        if (headOrder == null) {
            return;
        }

        NodeOrder current = headOrder;
        NodeOrder index = null;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data.OrderName.compareTo(index.data.OrderName) > 0) {
                    Order temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    void printReport() {
        sortOrdersByName();

        if (headOrder != null) {
            System.out.println("===============================================================");
            System.out.println("             INCOME REPORT (HIGHEST REVENUE FIRST)             ");
            System.out.println("===============================================================");
            System.out.printf("%-16s %-20s %-10s\n", "Order Code", "Order Name", "Price");

            NodeOrder current = headOrder;
            int reportNum = 1;
            while (current != null) {
                System.out.printf("%-16d %-20s %-10d\n", current.data.OrderCode, current.data.OrderName, current.data.price);

                current = current.next;
                reportNum++;
            }
            System.out.println("===============================================================");
        } else {
            System.out.println("===============================================================");
            System.out.println("No order records found.");
            System.out.println("===============================================================");
        }
    }
}