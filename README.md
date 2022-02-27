# DongMyeongSelect-backend

# 동명셀렉

동명동 맛집을 랜덤 추천 해드립니다!

Category(한식, 일식/돈까스/회, 중식, 양식/아시안, 패스트푸드, 분식)을 선택하면 해당 카테고리 목록 중 랜덤으로 선택해드립니다.

**(Frontend 작업 중으로 아직 정식 배포 하지 않았음)**

## 만든이

| Backend                                       | Frontend                                 |
| --------------------------------------------- | --------------------------------------- |
| [송학현](https://github.com/alanhakhyeonsong) | [김철환](https://github.com/chulhwan99) |

## Used Stack

- Frontend: Javascript(ES6), Vue.js, Webpack
- Backend: Java 11, Spring Boot(MVC, Data JPA, Security OAuth2), H2 Database(test용), MySQL(배포용), Thymeleaf
- Infra: AWS EC2, AWS RDS, Docker

## API

| 기능           | Method | URL        | Parameter         |
| -------------- | ------ | ---------- | ----------------- |
| 전체 목록 조회 | GET    | api/all    |                   |
| 랜덤 추천      | POST   | api/random | Category (String) |

## 서버 관리자 페이지

Spring Security OAuth2를 사용하여 Google Login 인증 처리를 하였습니다.

root 경로 접속 시 관리자 페이지("/admin"), 로그인("/login") 버튼으로 접속을 제어합니다.

![](https://images.velog.io/images/songs4805/post/e43e3dcb-35df-4691-be8b-a382e06a5fef/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-02-26%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.37.54.png)

Google Login 성공 뒤, `Role.ADMIN` 권한이 부여된 사용자만 다음 관리자 페이지로 접근이 가능합니다. (default: Role.USER)

![](https://images.velog.io/images/songs4805/post/497b62ef-59f7-4a20-bd56-643cf7f3748f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-02-26%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.20.53.png)

등록 페이지

![](https://images.velog.io/images/songs4805/post/eb33bf90-bcb2-4d3d-b48d-09a0e5ee760c/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-02-26%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.21.04.png)

전체 목록 페이지(수정/삭제 가능)

![](https://images.velog.io/images/songs4805/post/542ac003-9c16-405d-b275-4369ce421447/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-02-26%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.24.45.png)

수정 페이지

![](https://images.velog.io/images/songs4805/post/7db39970-b897-46c5-9476-e990bda469c8/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-02-26%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.24.54.png)
