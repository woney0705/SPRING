package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("이준원", 36);

        //when
        Member saveMember = memberRepository.save(member);

        //Then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(saveMember).isEqualTo(findMember);
    }


    @Test
    void findAll() {
        //given
        Member member1 = new Member("이준원1", 36);
        Member member2 = new Member("이준원2", 36);
        Member member3 = new Member("이준원3", 36);
        Member member4 = new Member("이준원4", 36);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        //when
        List<Member> memberList = memberRepository.findAll();

        //Then
        assertThat(memberList.size()).isEqualTo(4);
        assertThat(memberList).contains(member1,member2,member3,member4);
    }


}