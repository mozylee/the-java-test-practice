package practice.javatest.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.javatest.study.domain.Study;

public interface StudyRepository extends JpaRepository<Study, Long> {

}