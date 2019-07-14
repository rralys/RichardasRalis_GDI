package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class MetalsAndColorsData {

    private final List<Integer> summary;
    private final List<String> elements;
    private final String color;
    private final String metals;
    private final List<String> vegetables;

    public String summary() {

        int sum = getSummary().stream()
                .mapToInt(Integer::intValue)
                .sum();

        return Integer.toString(sum);
    }

    public String elements() {
        return String.join(", ", getElements());
    }

    public String vegetables() {
        return String.join(", ", getVegetables());
    }
}
