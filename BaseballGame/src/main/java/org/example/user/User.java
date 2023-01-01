package org.example.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class User {

    private final List<String> numbers = new ArrayList<>();

    public User() {}

    public void inputNumbers() {
        numbers.clear();
        String[] numbers;
        while (true) {
            numbers = inputNumbersAtConsole();
            if (validationLength(numbers) && validationValue(numbers) && validationDuplicate(numbers)) {
                break;
            }
        }
        parseNumber(numbers);
    }

    public String getNumberByIndex(int idx) {
        return numbers.get(idx);
    }

    private void parseNumber(String[] inputNumbers) {
        this.numbers.addAll(Arrays.asList(inputNumbers));
    }

    private boolean validationDuplicate(String[] inputNumbers) {
        if (inputNumbers.length != Arrays.stream(inputNumbers).distinct().count()) {
            System.out.println("중복된 숫자는 입력할 수 없습니다.");
            return false;
        }
        return true;
    }

    private boolean validationValue(String[] inputNumbers) {
        if (Arrays.stream(inputNumbers).anyMatch(Predicate.isEqual("0"))) {
            System.out.println("0은 입력할 수 없습니다.");
            return false;
        } else if (validationNumber(inputNumbers)) {
            System.out.println("1~9까지의 숫자만 입력할 수 있습니다.");
            return false;
        }
        return true;
    }

    private boolean validationNumber(String[] inputNumbers) {
        for (String inputNumber : inputNumbers) {
            if (!inputNumber.matches("^[1-9]$")) {
                return true;
            }
        }
        return false;
    }

    private boolean validationLength(String[] inputNumbers) {
        if (inputNumbers.length != 3) {
            System.out.println("세 개의 숫자를 공백으로 구분하여 입력해주세요.");
            return false;
        }
        return true;
    }

    private String[] inputNumbersAtConsole() {
        System.out.print("세 개의 숫자를 입력해주세요.(예시:1 2 3) : ");

        Scanner sc = new Scanner(System.in);
        return sc.nextLine().split(" ");
    }
}
