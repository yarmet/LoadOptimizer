package main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class InputParams {
    private int total;
    private List<Integer> values;
    private boolean needShortSequence;
}
