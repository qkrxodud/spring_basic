package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        int resultValue = 0;
        if (member.getGrade() == Grade.VIP) {
            resultValue = price * discountPercent / 100;
        }
        return resultValue;
    }
}
