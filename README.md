# Java Collections — 33 Problems to Master the Framework

Organized by topic, in the order you should tackle them. Each has the concept it drills, the problem, and a working solution.

---

## Part 1: ArrayList (dynamic arrays)

### 1. Remove duplicates from an ArrayList while preserving order
**Concept:** ArrayList traversal, `contains()`, manual dedup logic.
```java
import java.util.*;

public class P1 {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int n : list) {
            if (seen.add(n)) {       // add() returns false if already present
                result.add(n);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(Arrays.asList(1, 2, 2, 3, 1, 4)));
        // [1, 2, 3, 4]
    }
}
```

### 2. Rotate an ArrayList by k positions
**Concept:** `Collections.rotate()`, sublist manipulation.
```java
import java.util.*;

public class P2 {
    public static void rotate(List<Integer> list, int k) {
        Collections.rotate(list, k);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        rotate(list, 2);
        System.out.println(list); // [4, 5, 1, 2, 3]
    }
}
```

### 3. Find the second largest element using an ArrayList
**Concept:** Sorting vs single-pass scan, avoiding O(n log n) when O(n) works.
```java
import java.util.*;

public class P3 {
    public static int secondLargest(List<Integer> list) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : list) {
            if (n > first) {
                second = first;
                first = n;
            } else if (n > second && n != first) {
                second = n;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondLargest(Arrays.asList(10, 5, 20, 20, 8)));
        // 10
    }
}
```

### 4. Merge two sorted ArrayLists into one sorted ArrayList
**Concept:** Two-pointer merge, `ArrayList` capacity growth cost.
```java
import java.util.*;

public class P4 {
    public static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>(a.size() + b.size());
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) result.add(a.get(i++));
            else result.add(b.get(j++));
        }
        while (i < a.size()) result.add(a.get(i++));
        while (j < b.size()) result.add(b.get(j++));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(merge(Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 6)));
        // [1, 2, 3, 4, 5, 6]
    }
}
```

---

## Part 2: LinkedList (doubly linked list + Deque)

### 5. Implement a simple undo feature using LinkedList as a stack
**Concept:** `LinkedList` implements `Deque`, so it can act as a stack via `push`/`pop`.
```java
import java.util.*;

public class P5 {
    public static void main(String[] args) {
        LinkedList<String> undoStack = new LinkedList<>();
        undoStack.push("type A");
        undoStack.push("type B");
        undoStack.push("delete B");
        System.out.println(undoStack.pop()); // "delete B" — undo last action
        System.out.println(undoStack);        // [type B, type A]
    }
}
```

### 6. Reverse a LinkedList in place
**Concept:** `ListIterator`, understanding node-based structure gives O(1) insert/remove at ends.
```java
import java.util.*;

public class P6 {
    public static <T> void reverse(LinkedList<T> list) {
        LinkedList<T> reversed = new LinkedList<>();
        Iterator<T> it = list.descendingIterator();
        while (it.hasNext()) reversed.add(it.next());
        list.clear();
        list.addAll(reversed);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        reverse(list);
        System.out.println(list); // [4, 3, 2, 1]
    }
}
```

### 7. Compare ArrayList vs LinkedList insertion cost (benchmark)
**Concept:** Understand *why* you pick one over the other — array shifting vs pointer relinking.
```java
import java.util.*;

public class P7 {
    public static void main(String[] args) {
        int n = 100_000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long t1 = System.nanoTime();
        for (int i = 0; i < n; i++) arrayList.add(0, i); // insert at front
        long t2 = System.nanoTime();
        for (int i = 0; i < n; i++) linkedList.add(0, i);
        long t3 = System.nanoTime();

        System.out.println("ArrayList front-insert: " + (t2 - t1) / 1_000_000 + " ms");
        System.out.println("LinkedList front-insert: " + (t3 - t2) / 1_000_000 + " ms");
        // ArrayList should be much slower — every insert shifts all elements
    }
}
```

---

## Part 3: HashSet (unordered, unique elements)

### 8. Find common elements between two arrays (intersection)
**Concept:** O(1) average lookup with `HashSet`, `retainAll()`.
```java
import java.util.*;

public class P8 {
    public static Set<Integer> intersection(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int n : a) setA.add(n);
        Set<Integer> setB = new HashSet<>();
        for (int n : b) setB.add(n);
        setA.retainAll(setB);
        return setA;
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1,2,3,4}, new int[]{3,4,5,6}));
        // [3, 4]
    }
}
```

### 9. Check if an array contains any duplicates
**Concept:** `HashSet.add()` return value as a dedup check, O(n) solution.
```java
import java.util.*;

public class P9 {
    public static boolean hasDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int n : arr) {
            if (!seen.add(n)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicates(new int[]{1, 2, 3, 2})); // true
        System.out.println(hasDuplicates(new int[]{1, 2, 3, 4})); // false
    }
}
```

### 10. Implement a custom class in a HashSet correctly (hashCode/equals)
**Concept:** Why `hashCode()` and `equals()` must be overridden together for correct HashSet behavior.
```java
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() { return "(" + x + "," + y + ")"; }
}

public class P10 {
    public static void main(String[] args) {
        Set<Point> points = new HashSet<>();
        points.add(new Point(1, 2));
        points.add(new Point(1, 2)); // duplicate — won't be added
        points.add(new Point(3, 4));
        System.out.println(points.size()); // 2
        System.out.println(points);
    }
}
```

---

## Part 4: LinkedHashSet (insertion-ordered unique elements)

### 11. Get the first non-repeating character in a string
**Concept:** `LinkedHashSet` preserves insertion order while enforcing uniqueness.
```java
import java.util.*;

public class P11 {
    public static Character firstNonRepeating(String s) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            counts.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> e : counts.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("swiss")); // 'w'
    }
}
```

### 12. Deduplicate a stream of events while keeping the order they arrived
**Concept:** `LinkedHashSet` vs `HashSet` — when order matters as much as uniqueness.
```java
import java.util.*;

public class P12 {
    public static void main(String[] args) {
        List<String> events = Arrays.asList("login", "click", "login", "scroll", "click", "logout");
        Set<String> uniqueOrdered = new LinkedHashSet<>(events);
        System.out.println(uniqueOrdered);
        // [login, click, scroll, logout]  <- HashSet would scramble this order
    }
}
```

---

## Part 5: TreeSet (sorted unique elements, Red-Black tree)

### 13. Find the k closest numbers to a target using TreeSet navigation
**Concept:** `ceiling()`, `floor()`, `higher()`, `lower()` navigation methods.
```java
import java.util.*;

public class P13 {
    public static List<Integer> kClosest(TreeSet<Integer> set, int target, int k) {
        List<Integer> result = new ArrayList<>();
        Integer lower = set.floor(target);
        Integer higher = set.ceiling(target);
        if (set.contains(target)) { result.add(target); lower = set.lower(target); higher = set.higher(target); }

        while (result.size() < k && (lower != null || higher != null)) {
            if (lower == null) { result.add(higher); higher = set.higher(higher); }
            else if (higher == null) { result.add(lower); lower = set.lower(lower); }
            else if (Math.abs(target - lower) <= Math.abs(higher - target)) {
                result.add(lower); lower = set.lower(lower);
            } else {
                result.add(higher); higher = set.higher(higher);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9, 11));
        System.out.println(kClosest(set, 6, 3)); // [5, 7, 9]
    }
}
```

### 14. Range queries — count elements between two values
**Concept:** `subSet()`, `headSet()`, `tailSet()` for range views without scanning.
```java
import java.util.*;

public class P14 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(5, 12, 18, 20, 33, 41));
        SortedSet<Integer> range = set.subSet(12, true, 33, true); // [12, 33] inclusive
        System.out.println(range);            // [12, 18, 20, 33]
        System.out.println(range.size());     // 4
    }
}
```

### 15. Sort a custom class in a TreeSet using Comparable
**Concept:** Natural ordering — implementing `Comparable<T>` so TreeSet knows how to sort.
```java
import java.util.*;

class Employee implements Comparable<Employee> {
    String name; double salary;
    Employee(String name, double salary) { this.name = name; this.salary = salary; }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    @Override
    public String toString() { return name + ":" + salary; }
}

public class P15 {
    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(new Employee("Alice", 75000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Employee("Cara", 90000));
        System.out.println(employees); // sorted by salary ascending
    }
}
```

---

## Part 6: HashMap (key-value, unordered)

### 16. Count word frequency in a sentence
**Concept:** `merge()` / `getOrDefault()` idioms — the bread and butter of HashMap usage.
```java
import java.util.*;

public class P16 {
    public static Map<String, Integer> wordFrequency(String sentence) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : sentence.toLowerCase().split("\\s+")) {
            freq.merge(word, 1, Integer::sum);
        }
        return freq;
    }

    public static void main(String[] args) {
        System.out.println(wordFrequency("the cat sat on the mat the cat ran"));
        // {the=3, cat=2, sat=1, on=1, mat=1, ran=1}
    }
}
```

### 17. Two Sum — find indices of two numbers that add to a target
**Concept:** Classic HashMap lookup trick — trade space for O(n) time instead of O(n²).
```java
import java.util.*;

public class P17 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        // [0, 1]
    }
}
```

### 18. Group anagrams together
**Concept:** Using a computed key (sorted chars) to bucket items in a HashMap.
```java
import java.util.*;

public class P18 {
    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String w : words) {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(w);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // [[eat, tea, ate], [tan, nat], [bat]]
    }
}
```

### 19. Find the first repeated character with its index using HashMap
**Concept:** Combining HashMap with early-exit logic; entrySet iteration.
```java
import java.util.*;

public class P19 {
    public static int firstRepeatedIndex(String s) {
        Map<Character, Integer> firstIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIndex.containsKey(c)) return i;
            firstIndex.put(c, i);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstRepeatedIndex("abcbad")); // 3 ('b' repeats at index 3)
    }
}
```

---

## Part 7: LinkedHashMap (insertion/access-ordered map)

### 20. Implement an LRU (Least Recently Used) cache
**Concept:** The textbook use case for LinkedHashMap — access-order mode + `removeEldestEntry()`.
```java
import java.util.*;

public class P20 {
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        LRUCache(int capacity) {
            super(capacity, 0.75f, true); // true = access-order
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "a"); cache.put(2, "b"); cache.put(3, "c");
        cache.get(1);          // access 1, moves it to "most recent"
        cache.put(4, "d");     // evicts 2, the least recently used
        System.out.println(cache.keySet()); // [3, 1, 4]
    }
}
```

### 21. Track visit order of URLs while deduplicating
**Concept:** LinkedHashMap keeps insertion order by default — useful whenever you need a map that also remembers "what came first".
```java
import java.util.*;

public class P21 {
    public static void main(String[] args) {
        Map<String, Integer> visitOrder = new LinkedHashMap<>();
        String[] urls = {"/home", "/about", "/home", "/contact", "/about"};
        for (int i = 0; i < urls.length; i++) {
            visitOrder.putIfAbsent(urls[i], i); // keep only first-seen index
        }
        System.out.println(visitOrder); // {/home=0, /about=1, /contact=3}
    }
}
```

---

## Part 8: TreeMap (sorted map, Red-Black tree)

### 22. Build a phone book sorted by name, with range lookup
**Concept:** `firstKey()`, `lastKey()`, `subMap()` on TreeMap.
```java
import java.util.*;

public class P22 {
    public static void main(String[] args) {
        TreeMap<String, String> phoneBook = new TreeMap<>();
        phoneBook.put("Charlie", "555-0003");
        phoneBook.put("Alice", "555-0001");
        phoneBook.put("Bob", "555-0002");
        phoneBook.put("Dave", "555-0004");

        System.out.println(phoneBook.firstKey()); // Alice
        System.out.println(phoneBook.lastKey());  // Dave
        System.out.println(phoneBook.subMap("Alice", "Dave")); // {Alice=..., Bob=..., Charlie=...}
    }
}
```

### 23. Find the floor and ceiling entries for a given key
**Concept:** `floorEntry()`, `ceilingEntry()` — useful for range-bucketed lookups (e.g., pricing tiers).
```java
import java.util.*;

public class P23 {
    public static void main(String[] args) {
        TreeMap<Integer, String> pricingTiers = new TreeMap<>();
        pricingTiers.put(0, "Free");
        pricingTiers.put(100, "Basic");
        pricingTiers.put(500, "Pro");
        pricingTiers.put(1000, "Enterprise");

        int usage = 350;
        Map.Entry<Integer, String> tier = pricingTiers.floorEntry(usage);
        System.out.println("Tier for usage " + usage + ": " + tier.getValue()); // Basic
    }
}
```

### 24. Sort a map by value instead of key
**Concept:** TreeMap can't sort by value directly — use a stream + LinkedHashMap collector as the practical solution.
```java
import java.util.*;
import java.util.stream.*;

public class P24 {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 92); scores.put("Bob", 78); scores.put("Cara", 88);

        Map<String, Integer> sortedByValue = scores.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                      (a, b) -> a, LinkedHashMap::new));

        System.out.println(sortedByValue); // {Alice=92, Cara=88, Bob=78}
    }
}
```

---

## Part 9: PriorityQueue (heap)

### 25. Find the k largest elements in an array
**Concept:** Min-heap of size k — a classic PriorityQueue pattern.
```java
import java.util.*;

public class P25 {
    public static List<Integer> kLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) minHeap.poll();
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        System.out.println(kLargest(new int[]{3, 1, 5, 12, 2, 11}, 3));
        // [5, 12, 11] (order not guaranteed, but these are the 3 largest)
    }
}
```

### 26. Merge k sorted lists using a PriorityQueue
**Concept:** Heap with a custom Comparator holding (value, listIndex) pairs.
```java
import java.util.*;

public class P26 {
    public static List<Integer> mergeKLists(List<List<Integer>> lists) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // int[] = {value, listIndex, elementIndex}
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                heap.offer(new int[]{lists.get(i).get(0), i, 0});
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            result.add(top[0]);
            int nextIdx = top[2] + 1;
            if (nextIdx < lists.get(top[1]).size()) {
                heap.offer(new int[]{lists.get(top[1]).get(nextIdx), top[1], nextIdx});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
            Arrays.asList(1, 4, 7),
            Arrays.asList(2, 5, 8),
            Arrays.asList(3, 6, 9)
        );
        System.out.println(mergeKLists(lists)); // [1..9]
    }
}
```

### 27. Task scheduler — process highest priority task first (custom Comparator)
**Concept:** Priority ordering with a custom object and `Comparator.comparing()`.
```java
import java.util.*;

class Task {
    String name; int priority;
    Task(String name, int priority) { this.name = name; this.priority = priority; }
    public String toString() { return name + "(p" + priority + ")"; }
}

public class P27 {
    public static void main(String[] args) {
        PriorityQueue<Task> pq = new PriorityQueue<>(
            Comparator.comparingInt((Task t) -> t.priority).reversed() // higher priority first
        );
        pq.offer(new Task("Backup", 1));
        pq.offer(new Task("Fix outage", 5));
        pq.offer(new Task("Send report", 2));

        while (!pq.isEmpty()) System.out.println(pq.poll());
        // Fix outage(p5), Send report(p2), Backup(p1)
    }
}
```

---

## Part 10: Deque / Stack / Queue

### 28. Check for balanced parentheses using a Deque as a stack
**Concept:** `ArrayDeque` is the preferred stack implementation over legacy `Stack`.
```java
import java.util.*;

public class P28 {
    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}")); // true
        System.out.println(isBalanced("{[(])}")); // false
    }
}
```

### 29. Sliding window maximum using a Deque
**Concept:** Monotonic deque — an interview-favorite pattern that's O(n) instead of O(n·k).
```java
import java.util.*;

public class P29 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices, values decreasing
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        // [3, 3, 5, 5, 6, 7]
    }
}
```

### 30. Implement a circular buffer / round-robin scheduler using ArrayDeque
**Concept:** Using Deque as a double-ended queue for rotating access.
```java
import java.util.*;

public class P30 {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>(Arrays.asList("P1", "P2", "P3"));
        int cycles = 5;
        for (int i = 0; i < cycles; i++) {
            String current = queue.pollFirst();
            System.out.println("Running: " + current);
            queue.offerLast(current); // send to back of the line
        }
        // Running: P1, P2, P3, P1, P2 -- round robin
    }
}
```

---

## Part 11: Iterator, Comparator/Comparable, and Collections utilities

### 31. Safely remove elements while iterating (avoid ConcurrentModificationException)
**Concept:** Why `for-each` + `list.remove()` throws, and how `Iterator.remove()` fixes it.
```java
import java.util.*;

public class P31 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove(); // safe removal during iteration
            }
        }
        System.out.println(nums); // [1, 3, 5]
    }
}
```

### 32. Sort a list of custom objects by multiple fields
**Concept:** Chaining `Comparator.comparing().thenComparing()`.
```java
import java.util.*;

class Person {
    String name; int age;
    Person(String name, int age) { this.name = name; this.age = age; }
    public String toString() { return name + "(" + age + ")"; }
}

public class P32 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
            new Person("Bob", 30), new Person("Alice", 30), new Person("Alice", 25)
        ));

        people.sort(Comparator.comparingInt((Person p) -> p.age)
                              .thenComparing(p -> p.name));

        System.out.println(people); // [Alice(25), Alice(30), Bob(30)]
    }
}
```

### 33. Make a mutable collection unmodifiable / thread-safe
**Concept:** `Collections.unmodifiableList()`, `Collections.synchronizedList()`, and why they behave differently.
```java
import java.util.*;

public class P33 {
    public static void main(String[] args) {
        List<Integer> mutable = new ArrayList<>(List.of(1, 2, 3));

        List<Integer> readOnlyView = Collections.unmodifiableList(mutable);
        try {
            readOnlyView.add(4); // throws
        } catch (UnsupportedOperationException e) {
            System.out.println("Can't modify: " + e);
        }

        // Note: the underlying list can still change and the view reflects it
        mutable.add(4);
        System.out.println(readOnlyView); // [1, 2, 3, 4]

        List<Integer> threadSafe = Collections.synchronizedList(new ArrayList<>());
        // Must manually synchronize when iterating:
        synchronized (threadSafe) {
            for (int n : threadSafe) { /* safe here */ }
        }
    }
}
```

---

## Suggested order to attack these

1. **Days 1-2:** Problems 1-7 (List family — ArrayList vs LinkedList)
2. **Days 3-4:** Problems 8-15 (Set family — HashSet, LinkedHashSet, TreeSet)
3. **Days 5-7:** Problems 16-24 (Map family — HashMap, LinkedHashMap, TreeMap) — spend the most time here, it's the most-used part of the framework
4. **Days 8-9:** Problems 25-27 (PriorityQueue / heaps)
5. **Day 10:** Problems 28-30 (Deque/Stack/Queue)
6. **Day 11:** Problems 31-33 (Iterator safety, Comparator chaining, immutability)

Each problem is self-contained and runnable as-is — just paste into a `.java` file matching the class name and run it.
