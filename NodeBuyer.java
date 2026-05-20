public class NodeBuyer {
    Buyer data;
    NodeBuyer next;
    NodeBuyer prev;

    public NodeBuyer(Buyer data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public NodeBuyer( NodeBuyer next, Buyer data, NodeBuyer prev) {
        this.next = next;
        this.data = data;
        this.prev = prev;
    }
}