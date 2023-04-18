package org.example.membership.controller;

import org.example.membership.entity.Membership;

import static org.example.membership.controller.MembershipController.memberships;

public class ManagerController {



    public static void list() {
        System.out.println("이름 / 나이 / 성별 / 생년월일 / 아이디 / 비밀번호");
        System.out.println("-".repeat(30));

        for(int i = 0; i < memberships.size(); i++){
            Membership membership = memberships.get(i);
            System.out.println(membership.getName() + " / " + membership.getAge() + " / " + membership.getGender() + " / " + membership.getBirth() + " / " + membership.getUserID() + " / " + membership.getPassword());
        }
        System.out.println("총 등록된 ID 갯수" + memberships.size());
    }
}