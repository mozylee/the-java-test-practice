package practice.javatest.member.service;


import java.util.Optional;
import practice.javatest.member.domain.Member;
import practice.javatest.study.domain.Study;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);

}