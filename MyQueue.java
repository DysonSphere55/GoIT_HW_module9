import java.util.StringJoiner;

public class MyQueue<T> {

    private int length = 0;
    public Node<T> first;
    public Node<T> last;

    public static class Node<T> {
        public T value;
        Node<T> next = null;
        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        length++;
    }


    public void clear() {
        first.next = null;
        first = null;
        last = null;
        length = 0;
    }


    public int size() {
        return length;
    }

    public Node<T> peek() {
        if (length == 0) {
            return null;
        }
        return first;
    }

    public Node<T> poll() {
        if (length == 0) {
            return null;
        }
        Node<T> temp = peek();
        if (length == 1) {
            clear();
        } else {
            first = temp.next;
            temp.next = null;
            length--;
        }
        return temp;
    }


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        Node<T> temp = first;
        for (int i = 0; i < length; i++) {
            result.add(temp.value.toString());
            temp = temp.next;
        }
        return "[" + result + "]";
    }
}
