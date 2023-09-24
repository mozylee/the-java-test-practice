package practice.javatest.study.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import practice.javatest.member.domain.Member;
import practice.javatest.member.service.MemberService;
import practice.javatest.study.domain.Study;
import practice.javatest.study.repository.StudyRepository;
import practice.javatest.study.service.StudyService;

@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final MemberService memberService;

    private final StudyRepository repository;

    public Study createNewStudy(Long memberId, Study study) {
        memberService.findById(memberId)
                     .orElseThrow(() -> new IllegalArgumentException("Member doesn't exist for id: '" + memberId + "'"));

        study.setOwnerId(memberId);
        Study newstudy = repository.save(study);
        memberService.notify(newstudy);
        return newstudy;
    }

    public Study openStudy(Study study) {
        study.open();
        Study openedStudy = repository.save(study);
        memberService.notify(openedStudy);
        return openedStudy;
    }

    public void hi() {

    }

}
