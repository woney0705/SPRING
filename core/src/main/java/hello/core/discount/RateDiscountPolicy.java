package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.mamber.Grade;
import hello.core.mamber.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int rateDiscountAmount = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * rateDiscountAmount / 100;
        } else {
            return 0;
        }
    }
}
