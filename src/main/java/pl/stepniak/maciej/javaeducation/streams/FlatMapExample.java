package pl.stepniak.maciej.javaeducation.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(final String[] args) {
        final List<String> strings1 = new ArrayList<>() {{
            add("U0");
            add("U1");
            add("U2");
            add("U3");
        }};
        final List<String> strings2 = new ArrayList<>() {{
            add("U0");
            add("U4");
            add("U5");
            add("U6");
        }};
        final List<String> strings3 = new ArrayList<>() {{
            add("U0");
            add("U7");
            add("U8");
            add("U9");
        }};
        final List<List<String>> total = new ArrayList<>() {{
            add(strings1);
            add(strings2);
            add(strings3);
        }};
        final Set<String> flatted = total.stream().flatMap(Collection::stream).collect(Collectors.toSet());
        System.out.println("Flatted size: " + flatted.size());
        flatted.forEach(System.out::println);
    }
}
