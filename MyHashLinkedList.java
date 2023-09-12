class MyHashLinkedList {
    protected static class Node<T, E> {
        public T key;
        public E value;
        public Node<T, E> next = null;

        public Node(T key, E value) {
            this.key = key;
            this.value = value;
        }
    }

    protected int length = 0;
    public Node head;
    public Node tail;

    protected void add(Node node) {
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    protected void clear() {
        head.next = null;
        head = null;
        tail = null;
        length = 0;
    }

    protected Node removeNode(int index) {
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
        Node prev = get(index - 1);
        Node temp = get(index);
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }


    private Node popLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail.next = null;
        }
        length--;
        return temp;
    }


    private Node popFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    private Node get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (length == 0) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

}

