import java.util.StringJoiner;

public class MyHashMap<T, E> extends MyHashLinkedList {

    private static final int MAP_SIZE = 7;
    public MyHashLinkedList[] dataMap = new MyHashLinkedList[MAP_SIZE];

    public int hash(T key) {
        int result = 0;
        if (key instanceof Integer) {
            result = (int) key * 23;
        } else {
            for (char c: key.toString().toCharArray()) {
                result = result + (byte) c * 23;
            }
        }
        return result % MAP_SIZE;
    }

    public void put(T key, E value) {
        int hashIndex = hash(key);
        Node<T, E> node = new Node<>(key, value);
        if (dataMap[hashIndex] == null) {
            dataMap[hashIndex] = new MyHashLinkedList();
            dataMap[hashIndex].add(node);
            return;
        } else {
            Node temp = dataMap[hashIndex].head;
            for (int i = 0; i < dataMap[hashIndex].length; i++) {
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
        }
        dataMap[hashIndex].add(node);
    }

    public void clear() {
        for (int i = 0; i < MAP_SIZE; i++) {
            if (dataMap[i] != null) {
                dataMap[i] = null;
            }
        }
    }

    public Node remove(T key) {
        for (int i = 0; i < MAP_SIZE; i++) {
            if (dataMap[i] != null) {
                Node temp = dataMap[i].head;
                for (int j = 0; j < dataMap[i].length; j++) {
                    if (temp.key.equals(key)) {
                        dataMap[i].removeNode(j);
                        return temp;
                    }
                    temp = temp.next;
                }
            }
        }
        return null;
    }

    public Node get(T key) {
        for (int i = 0; i < MAP_SIZE; i++) {
            if (dataMap[i] != null) {
                Node temp = dataMap[i].head;
                for (int j = 0; j < dataMap[i].length; j++) {
                    if (temp.key.equals(key)) {
                        return temp;
                    }
                    temp = temp.next;
                }
            }
        }
        return null;
    }

    public int size() {
        int result = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            if (dataMap[i] != null) {
                result += dataMap[i].length;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < MAP_SIZE; i++) {
            if (dataMap[i] != null) {
                Node temp = dataMap[i].head;
                for (int j = 0; j < dataMap[i].length; j++) {
                    result.add(temp.key+"="+temp.value);
                    temp = temp.next;
                }
            }
        }
        return "{" + result + "}";
    }

    public void getKeysValues(int index) {
        Node temp = dataMap[index].head;
        System.out.println("Under index [" + index + "] is " + dataMap[index].length + " items:");
        for (int i = 0; i < dataMap[index].length; i++) {
            System.out.println("key=" + temp.key + " : " + "value=" + temp.value);
            temp = temp.next;
        }
    }
}




