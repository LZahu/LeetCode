import java.util.Objects;

// 二叉树节点
public class Node {
    int number;
    String name;
    // 左节点
    Node left;
    // 右节点
    Node right;

    public Node(){

    }

    public Node(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public Node(int number, String name, Node left, Node right) {
        this.number = number;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return number == node.number &&
                name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
