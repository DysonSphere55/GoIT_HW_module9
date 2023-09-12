import java.util.StringJoiner;

public class MyLinkedList<T> {

    private int length = 0;
    public Node<T> head;
    public Node<T> tail;

    public static class Node<T> {
        public T value;
        Node<T> next = null;
        Node<T> prev = null;

        private Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }


    public Node<T> get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (length == 0) {
            return null;
        }
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public Node<T> remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return popFirst();
        }
        if (index == length - 1) {
            return popLast();
        }
        Node<T> temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
        length--;
        return temp;
    }


    public Node<T> popLast() {
        if (length == 0) {
            return null;
        }
        Node<T> temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }


    public Node<T> popFirst() {
        if (length == 0) {
            return null;
        }
        Node<T> temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }


    public int size() {
        return length;
    }


    public void clear() {
        head.next = null;
        head = null;
        tail.prev = null;
        tail = null;
        length = 0;
    }


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        Node temp = head;
        for (int i = 0; i < length; i++) {
            result.add(temp.value.toString());
            temp = temp.next;
        }
        return "[" + result + "]";
    }
}

