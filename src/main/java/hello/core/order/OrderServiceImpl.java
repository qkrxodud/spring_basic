package hello.core.order;

import hello.core.discout.DiscountPolicy;
import hello.core.discout.RateDiscountPolicy;
import hello.core.member.*;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member newMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(newMember, 10000);

        return new Order(memberId, itemName, 10000, discountPrice);
    }
}
