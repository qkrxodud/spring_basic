package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    AppConfig appConfig;
    MemberService memberService;
    // 문제 점 다른 저장소로 변경할 때 OCP 개방폐쇄의 원칙을 잘 준수한가?
    // DIP를 잘 지키고 있는가?
    // 의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있음

    @BeforeEach
    public void beforeEach () {
        appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member newMember = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(newMember);
        Member findMemeber = memberService.findMember(1L);

        //then
        Assertions.assertThat(newMember).isEqualTo(findMemeber);
    }
}
