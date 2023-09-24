package practice.javatest.study.service;

import practice.javatest.study.domain.Study;

public interface StudyService {

    Study createNewStudy(Long memberId, Study study);

    Study openStudy(Study study);

}
