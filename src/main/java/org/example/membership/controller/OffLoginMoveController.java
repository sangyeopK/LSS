package org.example.membership.controller;

import org.example.Container;

public class OffLoginMoveController {
    OffLogin offLogin = new OffLogin();
    public void run(){
        while(true) {
            System.out.println("게시판 / 마이 스케줄러 / 공지사항 / Q&A / 로스트아크 공식홈페이지 / 돌아가기");
            System.out.printf("이동 명령어 : ");
            String command = Container.getsc().nextLine().trim();
            if (command.equals("게시판")) {
                System.out.println("게시판으로 이동합니다");
                System.out.println("-".repeat(30));
                offLogin.post();
            } else if (command.equals("마이 스케줄러")) {
                System.out.println("마이 스케줄러로 이동합니다");
                System.out.println("-".repeat(30));
                offLogin.scheduler();
            } else if (command.equals("공지사항")) {
                System.out.println("공지사항으로 이동합니다");
                System.out.println("-".repeat(30));
                offLogin.mainPost();
            } else if (command.equals("Q&A")) {
                System.out.println("Q&A로 이동합니다");
                System.out.println("-".repeat(30));
                offLogin.Question();
            } else if (command.equals("로스트아크 공식홈페이지")) {
                System.out.println("로스트아크 공식홈페이지로 이동합니다");
                System.out.println("-".repeat(30));
                System.out.println("https://lostark.game.onstove.com/Main");
            } else if (command.equals("돌아가기")) {
                System.out.println("메인홈페이지로 이동합니다");
                System.out.println("-".repeat(30));
                break;
            }
        }
    }
}
