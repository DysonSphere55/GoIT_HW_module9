import java.util.StringJoiner;

public class MyStack<T> {

    private int height = 0;
    public Node<T> top;
    public Node<T> bottom;

    public static class Node<T> {
        public T value;
        Node<T> next = null;
        public Node(T value) {
            this.value = value;
        }
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        if (height == 0) {
            top = node;
            bottom = node;
        } else {
            top.next = node;
            top = node;
        }
        height++;
    }

    public void clear() {
        top.next = null;
        top = null;
        bottom = null;
        height = 0;
    }

    public int size() {
        return height;
    }

    public Node<T> peek() {
        if (height == 0) {
            return null;
        }
        return top;
    }

    public Node<T> pop() {
        if (height == 0) {
            return null;
        }
        Node<T> node = top;
        if (height == 1) {
            clear();
        } else {
            top = top.next;
            node.next = null;
            height--;
        }
        return node;
    }

    public Node<T> remove(int index) {
        if (index < 0 || index >= height) {
            throw new IndexOutOfBoundsException();
        }
        if (height == 0) {
            return null;
        }
        if (height == 1 || index == height - 1) {
            return pop();
        }
        Node<T> temp = bottom;
        Node<T> beforeTemp = bottom;
        for (int i = 0; i < index; i++) {
            beforeTemp = temp;
            temp = temp.next;
        }
        beforeTemp.next = temp.next;
        temp.next = null;
        height--;
        return temp;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        Node<T> temp = bottom;
        for (int i = 0; i < height; i++) {
            result.add(temp.value.toString());
            temp = temp.next;
        }
        return "[" + result + "]";
    }
}
