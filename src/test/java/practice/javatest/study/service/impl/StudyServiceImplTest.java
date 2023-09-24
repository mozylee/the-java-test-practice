package practice.javatest.study.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import practice.javatest.member.domain.Member;
import practice.javatest.member.service.MemberService;
import practice.javatest.study.domain.Study;
import practice.javatest.study.domain.enums.StudyStatus;
import practice.javatest.study.repository.StudyRepository;
import practice.javatest.study.service.StudyService;

@ExtendWith(MockitoExtension.class)
class StudyServiceImplTest {

    StudyService studyService;

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @BeforeEach
    void setUp() {
        studyService = new StudyServiceImpl(memberService, studyRepository);
    }

    @Test
    @DisplayName("정상적으로 빈이 주입되어 객체가 생성되는지 확인")
    void createStudyService() throws Exception {
        // given

        // when

        // then
        assertThat(studyService).isNotNull();
    }

    @Test
    @DisplayName("createNewStudy: 정상 케이스")
    void createNewStudy() throws Exception {
        // given
        Long id = 1L;

        Member member = new Member(id, "whyalwaysmeyy@gmail.com");
        Study study = new Study(10, "java");

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // when
        Study newStudy = studyService.createNewStudy(id, study);

        // then
        then(memberService).should(times(1)).notify(study);
        assertThat(newStudy.getOwnerId()).isEqualTo(id);
    }

    @Test
    @DisplayName("openStudy: 정상 케이스")
    void openStudy() throws Exception {
        // given
        Study study = new Study(10, "java");

        given(studyRepository.save(study)).willReturn(study);

        // when
        Study openedStudy = studyService.openStudy(study);

        // then
        then(memberService).should(times(1)).notify(study);

        assertThat(openedStudy).isEqualTo(study);
        assertThat(openedStudy.getStatus()).isEqualTo(StudyStatus.OPENED);
        assertThat(openedStudy.getOpenedDateTime()).isNotNull();
    }

}