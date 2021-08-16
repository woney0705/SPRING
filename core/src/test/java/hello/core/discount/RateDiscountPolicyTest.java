package hello.core.discount;

import hello.core.mamber.Grade;
import hello.core.mamber.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIO는 10%할인이 적용")
    void vip_o() {
        //given
        Member member =  new Member(1L, "memberVIP", Grade.VIP);
        //when

        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아니면 할일인 되지않아야한다")
    void vip_X() {
        //given
        Member member =  new Member(2L, "memberBASIC", Grade.BASIC);
        //when

        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}