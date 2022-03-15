package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        int defaultValue = 0;
        if (member.getGrade() == Grade.VIP) {
            defaultValue = discountFixAmount;
        }
        return defaultValue;
    }
}
