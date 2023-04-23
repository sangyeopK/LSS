package org.example.membership.controller;

import org.example.Container;
import org.example.membership.entity.Membership;

import java.util.ArrayList;


public class MembershipController {

    private int count = 1;

    static ArrayList<Membership> memberships = new ArrayList<>();

    public void join() {
        System.out.println("이름을 입력해주세요.");
        System.out.println("Ex) 홍길동 ");
        System.out.printf("=> ");
        String name = Container.getsc().nextLine().trim();
        System.out.println("나이를 입력해주세요");
        System.out.println("Ex) 10 ");
        System.out.printf("=> ");
        int age = Container.getsc().nextInt();
        Container.getsc().nextLine();
        System.out.println("생년월일을 입력해주세요.");
        System.out.println("Ex) 990909 ");
        System.out.printf("=> ");
        int birth = Container.getsc().nextInt();
        Container.getsc().nextLine();
        System.out.println("성별을 입력해주세요.");
        System.out.println("Ex) 남 or 여 ");
        System.out.printf("=> ");
        String gender = Container.getsc().nextLine().trim();
        System.out.println("사용할 ID를 입력해주세요.");
        System.out.println(" 특수문자 사용불가 ");
        System.out.printf("=> ");
        String userID = Container.getsc().nextLine().trim();
        System.out.println("사용할 비밀번호를 입력해주세요.");
        System.out.println("Ex) 6자 이상 입력하세요 ");
        System.out.printf("=> ");
        String password = Container.getsc().nextLine().trim();
        System.out.println("정보를 저장하시겠습니까?, 저장하시려면 저장하기를 입력해주세요.");
        System.out.printf("=> ");
        String result = Container.getsc().nextLine().trim();
        System.out.println("정보가 저장되었습니다. 회원가입을 종료합니다.");
        System.out.println("-".repeat(20));
        int id = count;

        memberships.add(new Membership(id, name, age, birth, gender, userID, password));

        count++;
    }


    public void login() {
        System.out.println("ID를 입력해주세요.");
        String userID = Container.getsc().nextLine().trim();
        System.out.println("비밀번호를 입력해주세요.");
        String password = Container.getsc().nextLine().trim();
        String membershipUserID = findByID(userID);
        String membershipPassword = findByPS(password);


        if (!(userID.equals(membershipUserID)) || !(password.equals(membershipPassword))) {
            System.out.println("일치하는 회원정보가 존재하지않습니다.");
            System.out.println("아이디 또는 비밀번호를 확인해주세요.");
            System.out.println("-".repeat(20));
        } else if (userID.equals(membershipUserID) && password.equals(membershipPassword)) {
            System.out.println("로그인 되었습니다.");
            System.out.println("-".repeat(20));
            new OnLoginMoveController().run();
        }
    }

    private String findByID(String userID) {
        for (Membership membership : memberships) {
            if (membership.getUserID().equals(userID)) {
                return membership.getUserID();
            }
        }
        return null;
    }


    private String findByPS(String password) {
        for (Membership membership : memberships) {
            if (membership.getPassword().equals(password)) {
                return membership.getPassword();
            }
        }
        return null;
    }
}