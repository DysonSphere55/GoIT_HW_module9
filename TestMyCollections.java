import java.util.*;

public class TestMyCollections {

    public static void main(String[] args) {

        System.out.println("\n________________ArrayList Testing:________________");
        ArrayList<Integer> javaArrayList = new ArrayList<>();
        javaArrayList.add(1);
        javaArrayList.add(2);
        javaArrayList.add(3);
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        boolean getArrayListCheck = javaArrayList.get(1) == myArrayList.get(1);
        boolean removeArrayListCheck = javaArrayList.remove(1) == myArrayList.remove(1);
        boolean sizeArrayListCheck = javaArrayList.size() == myArrayList.size();
        System.out.println("getArrayListCheck = " + getArrayListCheck);
        System.out.println("removeArrayListCheck = " + removeArrayListCheck);
        System.out.println("sizeArrayListCheck = " + sizeArrayListCheck);

        System.out.println("\n________________LinkedList Testing:________________");
        LinkedList<Integer> javaLinkedList = new LinkedList<>();
        javaLinkedList.add(1);
        javaLinkedList.add(2);
        javaLinkedList.add(3);
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        boolean getLinkedListCheck = javaLinkedList.get(1) == myLinkedList.get(1).value;
        boolean removeLinkedListCheck = javaLinkedList.remove(1) == myLinkedList.remove(1).value;
        boolean sizeLinkedListCheck = javaLinkedList.size() == myLinkedList.size();
        System.out.println("getLinkedListCheck = " + getLinkedListCheck);
        System.out.println("removeLinkedListCheck = " + removeLinkedListCheck);
        System.out.println("sizeLinkedListCheck = " + sizeLinkedListCheck);

        System.out.println("\n________________Queue Testing:________________");
        Queue<Integer> javaQueue = new ArrayDeque<>();
        javaQueue.add(1);
        javaQueue.add(2);
        javaQueue.add(3);
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        boolean peekQueueCheck = javaQueue.peek() == myQueue.peek().value;
        boolean pollQueueCheck = javaQueue.poll() == myQueue.poll().value;
        boolean sizeQueueCheck = javaQueue.size() == myQueue.size();
        System.out.println("peekQueueCheck = " + peekQueueCheck);
        System.out.println("pollQueueCheck = " + pollQueueCheck);
        System.out.println("sizeQueueCheck = " + sizeQueueCheck);

        System.out.println("\n________________Stack Testing:________________");
        Stack<Integer> javaStack = new Stack<>();
        javaStack.push(1);
        javaStack.push(2);
        javaStack.push(3);
        javaStack.push(4);
        javaStack.push(5);
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        boolean peekStackCheck = javaStack.peek() == myStack.peek().value;
        boolean popStackCheck = javaStack.pop() == myStack.pop().value;
        boolean removeStackCheck = javaStack.remove(1) == myStack.remove(1).value;
        boolean sizeStackCheck = javaStack.size() == myStack.size();
        System.out.println("peekStackCheck = " + peekStackCheck);
        System.out.println("popStackCheck = " + popStackCheck);
        System.out.println("removeStackCheck = " + removeStackCheck);
        System.out.println("sizeStackCheck = " + sizeStackCheck);

        System.out.println("\n________________HashMap Testing:________________");
        HashMap<Integer, String> javaHashMap = new HashMap<>();
        javaHashMap.put(1, "one");
        javaHashMap.put(2, "two");
        javaHashMap.put(3, "three");
        javaHashMap.put(4, "four");
        javaHashMap.put(5, "five");
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "one");
        myHashMap.put(2, "two");
        myHashMap.put(3, "three");
        myHashMap.put(4, "four");
        myHashMap.put(5, "five");
        boolean getHashMapCheck = javaHashMap.get(2) == myHashMap.get(2).value;
        boolean removeHashMapCheck = javaHashMap.remove(2) == myHashMap.remove(2).value;
        boolean sizeHashMapCheck = javaHashMap.size() == myHashMap.size();
        System.out.println("getHashMapCheck = " + getHashMapCheck);
        System.out.println("removeHashMapCheck = " + removeHashMapCheck);
        System.out.println("sizeHashMapCheck = " + sizeHashMapCheck);

    }
}
