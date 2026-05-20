public class NodeOrder {
    Order data;
    NodeOrder prev;
    NodeOrder next;

    public NodeOrder(Order data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public NodeOrder(NodeOrder prev, Order data, NodeOrder next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}