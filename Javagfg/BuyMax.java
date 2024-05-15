import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class BuyMax<BuyMax> {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        List<Pair<Integer, Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Pair<>(price[i], i + 1));
        }
        Comparator<Pair<Integer, Integer>> comparator = Comparator.comparing(Pair::getKey);
        arr.sort(comparator);
        

        int numberOfStocks = 0;
        for (Pair<Integer, Integer> pair : arr) {
            if (k - pair.getKey() * pair.getValue() < 0) {
                int num = k / pair.getKey();
                numberOfStocks += num;
                k = k - num*pair.getKey();
            } else {
                numberOfStocks += pair.getValue();
                k = k - pair.getKey() * pair.getValue();
            }
        }

        return numberOfStocks;
    }
}