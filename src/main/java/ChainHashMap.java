import java.util.HashMap;
import java.util.LinkedList;

public class ChainHashMap<T, T1> {
    private int capacity;
    private int size;

    private LinkedList<Node> [] st;

    private class Node {
        T key;
        T1 value;

        public Node(T key, T1 value) {
            this.key = key;
            this.value = value;
        }
    }

    public ChainHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(T key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public boolean contains(T key) {
        return get(key) != null;
    }

    public void checkKeyNotNull(T key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void put(T key, T1 value) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].add(new Node(key, value));
        size++;
    }



    public T1 get(T key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public T1 remove(T key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (int j = 0; j < st[i].size(); j++) {
            if (key.equals(st[i].get(j).key)) {
                T1 temp = st[i].get(j).value;
                st[i].remove(j);
                size--;
                return temp;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append("#busket ").append(i).append(":  ");
            for (Node node : st[i]) {
                sb.append(node.key).append(" = ").append(node.value).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

