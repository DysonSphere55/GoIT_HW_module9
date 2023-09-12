import java.util.Arrays;
import java.util.StringJoiner;

public class MyArrayList<T> {

    private static final int SIZE_INIT = 8;
    private Object[] data;
    private int index;

    public MyArrayList() {
        data = new Object[SIZE_INIT];
    }

    public void add(T value) {
        checkSize();
        data[index] = value;
        index++;
    }

    private void checkSize() {
        if (index == data.length) {
            int new_size = data.length * 2;
            data = Arrays.copyOf(data, new_size);
        }
    }

    public void clear() {
        data = new Object[SIZE_INIT];
        index = 0;
    }

    public T remove(int i) {
        if (i < 0 || i >= index) {
            throw new IndexOutOfBoundsException();
        }
        T temp = (T) data[i];
        if (index == 0) {
            clear();
        } else {
            for (int j = i; j < index; j++) {
                data[j] = data[j+1];
            }
            index--;
            data = Arrays.copyOf(data, data.length - 1);
        }
        return temp;
    }

    public T get(int i) {
        if (i < 0 || i >= index) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[i];
    }

    public int size() {
        return index;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < index; i++) {
            result.add(data[i].toString());
        }
        return "[" + result + "]";
    }
}
