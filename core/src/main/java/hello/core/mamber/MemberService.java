package hello.core.mamber;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
