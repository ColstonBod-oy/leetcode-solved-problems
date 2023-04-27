import java.util.HashMap;

class LRUCache146 {
  class LRUCache {
    private final Node head;
    private final Node tail;
    private final int capacity;
    private final HashMap<Integer, Node> cache;
    
    public LRUCache(int capacity) {
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
      this.capacity = capacity;
      cache = new HashMap<>(capacity + 1);
    }

    private void insert(Node n) {
      Node tailPrev = tail.prev;
      tailPrev.next = tail.prev = n;
      n.next = tail;
      n.prev = tailPrev; 
    }

    private void remove(Node n) {
      n.prev.next = n.next;
      n.next.prev = n.prev;
    }
    
    public int get(int key) {
      if (cache.containsKey(key)) {
        remove(cache.get(key));
        insert(cache.get(key));
        return cache.get(key).val;
      }

      return -1;
    }
    
    public void put(int key, int value) {
      if (cache.containsKey(key)) {
        remove(cache.get(key));
      }
      
      cache.put(key, new Node(key, value));
      insert(cache.get(key));

      if (cache.size() > capacity) { 
        cache.remove(head.next.key);
        remove(head.next);
      }
    }

    private class Node {
      private final int key;
      private final int val;
      private Node next;
      private Node prev;

      public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
      }
    }
  }

  /**
   * Your LRUCache object will be instantiated and called as such:
   * LRUCache obj = new LRUCache(capacity);
   * int param_1 = obj.get(key);
   * obj.put(key,value);
   */
  
}