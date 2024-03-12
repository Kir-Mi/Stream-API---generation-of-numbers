import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Charger", 100.0),
                new Order("Charger", 200.0),
                new Order("Smartphone", 900.0)
        );

        Map<String, Double> topProducts = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct,Collectors.summingDouble(Order::getCost)))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(topProducts);
    }
}