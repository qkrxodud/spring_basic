package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        // 앞에 변수 단축키 ctrl + alt + v
        Member newMemberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(newMemberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+ newMemberA.getName());
        System.out.println("find member = "+ findMember.getName());
    }
}
