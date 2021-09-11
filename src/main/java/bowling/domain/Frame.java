package bowling.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Frame {

    protected final List<Pitch> pitches;

    public Frame() {
        this.pitches = new ArrayList<>();
    }

    public abstract boolean add(final Pitch pitch);

    public abstract boolean isFull();

    public List<Integer> pitchValues() {
        return pitches.stream()
                .map(Pitch::value)
                .collect(Collectors.toList());
    }

    protected int pitchesSum() {
        return pitches.stream()
                .map(Pitch::value)
                .reduce(0, Integer::sum);
    }

    protected int pitchesSum(final Pitch pitch) {
        return Stream.of(Collections.singletonList(pitch), pitches)
                .flatMap(Collection::stream)
                .map(Pitch::value)
                .reduce(0, Integer::sum);
    }

}