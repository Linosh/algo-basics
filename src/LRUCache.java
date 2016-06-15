import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dmitriiiermiichuk on 6/14/16.
 */
public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }

    }

    public void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null)
            head.pre = n;

        head = n;

        if (end == null)
            end = head;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);

            } else {
                setHead(created);
            }

            map.put(key, created);
        }
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}



class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity+1, 1.0f, true);  // for access order
        this.capacity = capacity;
    }

    public int get(int key) {
        if(super.get(key) == null)
            return -1;
        else
            return ((int) super.get(key));
    }

    public void set(int key, int value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry entry) {
        return (size() > this.capacity);
    }
}

class LRUCacheTest {
    public static void main(String[] args) {

        LRUCache2 cache = new LRUCache2(5);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        cache.set(5, 5);

        cache.get(3);
        cache.get(4);
        cache.get(1);
        cache.get(2);

        cache.set(6, 6);

        System.out.println(cache.get(5));

    }
}
