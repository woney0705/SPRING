package hello.core.discount;

import hello.core.mamber.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
