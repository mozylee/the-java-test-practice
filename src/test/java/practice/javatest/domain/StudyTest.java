package practice.javatest.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import practice.javatest.study.domain.Study;

class StudyTest {

    @DisplayName("Study 객체 생성 테스트")
    @Tag("ci")
    @RepeatedTest(10)
        // or @Test
    void create() throws Exception {
        Study study = new Study();

        assertThat(study).isNotNull();
        System.out.println("StudyTest.create");
    }

    // 참고 : https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests
    @DisplayName("파라미터 테스트")
    @NullSource
    @EmptySource
    @ValueSource(strings = {"이이잉1", "이이잉2", "이이잉3", "이이잉4"})
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    void parameterizedTest(String message) throws Exception {
        assertThat(message).isNotEmpty();
    }

    @Test
    @Disabled
    @DisplayName("Study 객체 생성 테스트2")
    void create2() throws Exception {
        Study study = new Study();

        assertThat(study).isNotNull();
        System.out.println("StudyTest.create2 <- 이거 테스트 안됨");
    }

    // 무조건 static
    // return type은 무조건 void
    @BeforeAll
    static void beforeAll() {
        System.out.println("StudyTest.beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("StudyTest.afterAll");
    }

    // 테스트가 실행될 때마다 호출
    @BeforeEach
    void beforeEach() {
        System.out.println("StudyTest.beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("StudyTest.afterEach");
    }

}