package org.example.membership.controller;

import org.example.Container;
import org.example.membership.entity.Comment;
import org.example.membership.entity.Post;

import java.util.ArrayList;

public class PostController {
     static int postNum = 1;
     static int commentNum = 1;
    static ArrayList<Post> postList = new ArrayList<>();
    static ArrayList<Comment> commentList = new ArrayList<>();

    public void addPost() {
        System.out.println("-".repeat(30));
        System.out.println("제목을 입력하세요");
        System.out.println("10자 이내로 입력하세요");
        String title = Container.getsc().nextLine();
        System.out.println("내용을 입력하세요");
        String content = Container.getsc().nextLine();
        int id = postNum;
        postList.add(new Post(id, title, content));
        System.out.println(postNum + "번 게시판 등록이 완료되었습니다");
        postNum++;
        System.out.println("-".repeat(30));
    }

    public void viewPostList() {
        System.out.println("-".repeat(30));
        for (int i = 0; i < postList.size(); i++) {
            Post post = postList.get(i);
            System.out.println(post.getId() + "/" + post.getTitle() + "/" + post.getContent());
        }
        System.out.printf("총 등록된 게시글 수는 %d 입니다\n", postList.size());
        System.out.println("-".repeat(30));
    }

    public void viewPostDetailOffLogin() {
        System.out.println("-".repeat(30));
        System.out.println("상세보기 할 게시물 번호를 입력해주세요 : ");
        int id = Container.getsc().nextInt();
        int target = findByPostId(id);
        if (target != -1) {
            Post post = postList.get(target);
            showPost(post);
        }
    }

    public void viewPostDetailOnLogin() {
        System.out.println("-".repeat(30));
        System.out.println("상세보기 할 게시물 번호를 입력해주세요 : ");
        int id = Container.getsc().nextInt();

        int target = findByPostId(id);

        if (target != -1) {
            Post post = postList.get(target);

            showPost(post);
            while (true) {
                System.out.println("상세보기 기능을 선택해주세요(댓글 등록, 뒤로가기)");
                String cmd = Container.getsc().nextLine().trim();

                if (cmd.equals("댓글 등록")) {
                    System.out.println("댓글 내용을 입력해주세요 : ");
                    String comment = Container.getsc().nextLine();
                    commentList.add(new Comment(commentNum, id, comment));
                    showPost(post);
                    commentNum++;
                } else if (cmd.equals("뒤로가기")) {
                    System.out.println("게시물 목록으로 돌아갑니다.");
                    break;
                }
            }
        }
    }
    public void showPost(Post post) {
        System.out.println(post.getId() + "번 게시물 상세보기");
        System.out.println("게시물 번호 : " + post.getId());
        System.out.println("제목 : " + post.getTitle());
        System.out.println("내용 : " + post.getContent());
        for(int i = 0; i < commentList.size(); i++) {
            Comment comment = commentList.get(i);
            if(comment.getPostId() == post.getId()) {
                System.out.println("댓글 번호 : " +  comment.getId());
                System.out.println("댓글 : " + comment.getComment());
            }
        }
    }

    public int findByPostId(int id) {
        int targetpost = -1;
        for(int i = 0; i < postList.size(); i++) {
            if(postList.get(i).getId() == id) {
                targetpost = i;
            }
        }
        System.out.println("-".repeat(30));
        // 게시물 찾지 못했을 때.
        if(targetpost == -1) {
            System.out.println("게시물이 없습니다");
            System.out.println("-".repeat(30));
        }
        return targetpost;
    }
}