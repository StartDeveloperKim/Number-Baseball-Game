package org.example.computer;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<String> numbers = new ArrayList<>();

    public Computer() {
        System.out.println("상대방 숫자가 생성되었습니다.");
        numbers.clear();
        generateNumbers();
    }

    public String getNumberByIndex(int idx) {
        return numbers.get(idx);
    }

    public boolean isContainNumber(String number) {
        return numbers.contains(number);
    }

    private void generateNumbers() {
        while (numbers.size()!=3) {
            String number = String.valueOf((int) (Math.random() * 9 + 1) );
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }
}
