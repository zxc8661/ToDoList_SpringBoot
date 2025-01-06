# ✅ 기능 확장 아이디어 (실습 추천)

### 1. Todo 수정 및 삭제 기능 추가
- **PUT 요청**을 사용하여 할 일 수정
- **DELETE 요청**을 사용하여 할 일 삭제

### 2. 상태 필터링 및 정렬 기능 추가
- **완료 여부**에 따라 필터링 (`GET /app/todos?complete=true`)
- **생성일 순, 제목 순** 정렬

### 3. 유효성 검사 (Validation) 추가
- `@Valid`와 `@NotBlank`를 사용하여 입력 데이터 검사
- **예:** 제목이 비어있을 경우 예외 처리

### 4. 예외 처리 (Global Exception Handling)
- `@ControllerAdvice`와 `@ExceptionHandler`를 활용하여 예외 처리
- **JSON 형태**로 에러 메시지 응답

### 5. 데이터베이스 변경 (H2 → MySQL)
- **H2** 대신 **MySQL**, **PostgreSQL** 등 실제 데이터베이스로 전환

---

# ✅ 학습할 스프링 부트 핵심 기능 (중요 개념)

### 1. 스프링 부트 핵심 개념
- `@RestController`, `@Service`, `@Repository`의 차이
- **Bean과 Dependency Injection** (의존성 주입) 이해

### 2. 스프링 데이터 JPA
- `JpaRepository`와 `CrudRepository`의 차이
- **JPQL 및 Criteria API** 활용

### 3. 스프링 시큐리티 (Spring Security)
- **로그인/회원가입 기능 구현**
- **JWT (JSON Web Token)** 기반 인증 방식

### 4. 테스트 코드 작성 (JUnit + Mockito)
- `@SpringBootTest`와 `@MockBean` 활용
- **서비스 및 리포지토리 단위 테스트 작성**

### 5. API 문서화 (Swagger)
- **springdoc-openapi**를 사용하여 API 문서화
- **API 엔드포인트, 파라미터, 응답 예시** 시각화

### 6. 클라우드 및 배포
- **AWS EC2에 배포하기**
- **Docker**를 사용한 스프링 부트 + MySQL 환경 구성
