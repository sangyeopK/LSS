package org.example;

import org.example.membership.controller.ManagerController;
import org.example.membership.controller.MembershipController;
import org.example.membership.entity.Membership;

import java.util.Scanner;

public class App {

    public void run() {
        System.out.println(" == Lss회원가입 == ");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("9. 종료");
        System.out.println("0. 관리자모드");

        MembershipController membershipController = new MembershipController();

        while (true){

            System.out.printf("명령: ");
            String command = Container.getsc().nextLine().trim();

            if(command.equals("종료")){
                break;
            }else if(command.equals("회원가입")){
                membershipController.join();

            }else if(command.equals("회원확인")){
                ManagerController.list();
            }else if(command.equals("로그인")){
                membershipController.login();
            } else if(command.equals("도움말")) {
                System.out.println("1. 회원가입");
                System.out.println("2. 로그인");
                System.out.println("9. 종료");
                System.out.println("0. 관리자모드");

            } else {
                System.out.println("명령어를 제대로 입력해주세요.");
                System.out.println("만약 명령어에 대한 정보를 원하시면 \"도움말\"을 입력해주세요.");
            }

        }
    }
}