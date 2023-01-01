package org.example.game;

import org.example.computer.Computer;
import org.example.user.User;

import java.util.Scanner;

public class BaseballGame{

    private User user;
    private Computer computer;
    private int strike;
    private int ball;

    public void run() {
        while (true) {
            System.out.println("게임시작:1 // 게임종료:2");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();

            if (input.equals("1")) {
                this.computer = new Computer();
                this.user = new User();
                play();
            } else if (input.equals("2")) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }

    }

    private void play() {
        while (true) {
            user.inputNumbers();
            if (checkResult()) {
                System.out.println("컴퓨터 OUT!!");
                break;
            }
        }
    }

    private boolean checkResult() {
        strike = 0;
        ball = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (isStrike(idx)) {
                strike++;
                continue;
            }
            if (isBall(idx)) {
                ball++;
            }
        }
        if (strike == 3) {
            return true;
        } else {
            printHint();
            return false;
        }
    }

    private void printHint() {
        System.out.println(strike + "스트라이크 // " + ball + "볼 // " + (3 - (strike + ball)) + "Nothing");
    }

    private boolean isBall(int idx) {
        return computer.isContainNumber(user.getNumberByIndex(idx));
    }

    private boolean isStrike(int idx) {
        return user.getNumberByIndex(idx).equals(computer.getNumberByIndex(idx));
    }
}
