package org.example.membership.controller;

import org.example.Container;

import java.util.ArrayList;

public class OffLogin {
    public void post() {
        while (true) {
            System.out.println("게시판 보기 / 상세보기 / 돌아가기");
            System.out.printf("게시판 명령어: ");
            String command = Container.getsc().nextLine().trim();
            if (command.equals("게시판 보기")) {
                new PostController().viewPostList();
            } else if (command.equals("상세보기")) {
                new PostController().viewPostDetailOffLogin();
            } else if (command.equals("돌아가기")) {
                break;
            }
        }
    }


    public void scheduler() {
        System.out.println("현재 저장된 컨텐츠 데이터가 없습니다");
    }

    public void mainPost() {
        System.out.println("공지사항임");
    }

    public void Question() {
        System.out.println("웰컴투큐엔에이");
    }
}
