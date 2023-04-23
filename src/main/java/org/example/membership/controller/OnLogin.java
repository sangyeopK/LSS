package org.example.membership.controller;

import org.example.Container;

public class OnLogin {
    public void post() {
        while (true) {
            System.out.println("게시판 보기 / 상세보기 / 글쓰기 / 돌아가기");
            System.out.printf("게시판 명령어: ");
            String command = Container.getsc().nextLine().trim();
            if (command.equals("게시판 보기")) {
                new PostController().viewPostList();
            } else if (command.equals("상세보기")) {
                new PostController().viewPostDetailOnLogin();
            } else if (command.equals("글쓰기")) {
                new PostController().addPost();
            } else if (command.equals("돌아가기")) {
                break;
            }
        }
    }

    public void scheduler() {
    }

    public void mainPost() {
    }

    public void Question() {
    }
}
