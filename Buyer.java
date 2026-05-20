public class Buyer {
    int queueNum;
    String name;
    String mobileNumber;

    public Buyer(int queueNum, String b, String c) {
        this.queueNum = queueNum;
        this.name = b;
        this.mobileNumber = c;
    }

    void print() {
        System.out.printf("%-12d %-15s %-15s\n", queueNum, name, mobileNumber);
    }
}