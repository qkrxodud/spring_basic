package hello.core.order;

import hello.core.discout.DiscountPolicy;
import hello.core.member.*;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member newMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(newMember, 10000);

        return new Order(memberId, itemName, 10000, discountPrice);
    }
}
