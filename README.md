# 기억 저장소
<img width="500" alt="스크린샷 2024-12-20 오후 11 32 35" src="https://github.com/user-attachments/assets/650250f3-72ec-43a5-b500-c1b7a37e6b27" />
---

## 프로젝트 설명
이 프로젝트는 사진을 '앨범' 형태로 분류하여 보관하고 볼수있는 웹 애플리케이션입니다.
사용자는 회원가입 후 로그인하여 앨범을 생성하고 사진을 추가,조회,수정,삭제를 할 수 있습니다.

## 주요 기능
- 사용자 인증 (로그인, 회원가입)
- 앨범 CRUD 기능 (게시글 작성, 조회, 수정, 삭제)
 

---
## 기술 스택
- **Frontend**
<br><br>
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  <img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/Tymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
<br><br>

- **Backend**
<br><br>
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/Java-000000?style=for-the-badge&logo=openjdk&logoColor=white">
<br><br>

- **Database**
<br><br>
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<br><br>

- **DevOps**
<br><br>
  <img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">
  <img src="https://img.shields.io/badge/githubactions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white">
  <img src="https://img.shields.io/badge/amazons3-569A31?style=for-the-badge&logo=amazons3&logoColor=white">
  <img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">
<br><br>
- **기타**
<br><br>
  <img src="https://img.shields.io/badge/Redis-FF4438?style=for-the-badge&logo=Redis&logoColor=white">
<br><br>


---
## 사작 가이드
### Prerequisites
    Java 17 이상
    Spring Boot Framework 3.3.2
### Installation
1. 프로젝트를 클론합니다.
   ```bash
   git clone https://github.com/s-u-n-h-o/MemoryMirror.git
   cd yourProject
 
2. Docker로 프로젝트 실행
    ```bash
   docker-compose up -d
   
3. 프로젝트 실행 확인
   ```bash
   docker ps
   
---
## 화면 구성 및 주요 기능

### 1. 로그인
<img width="500" alt="스크린샷 2024-12-20 오후 11 34 08" src="https://github.com/user-attachments/assets/e7b99f04-896f-4125-a3e4-4e6469a2dabf" />

- **아이디와 비밀번호를 입력하여 로그인을 할수 있습니다.**
- **회원가입 화면으로 넘어갈수 있습니다.**


### 2. 회원가입
<img width="500" alt="스크린샷 2024-12-20 오후 11 39 25" src="https://github.com/user-attachments/assets/2b65baa6-711e-46c8-b7f4-ecbfe47d7766" />

- **정보를 입력하여 신규 회원가입을 할수 있습니다**
- **텍스트박스 안에 있는 요구사항에 맞게 입력해야 회원가입을 할수있습니다**
  - **이름 : 특수문자 제외**
  - **핸드폰 번호 : '-'제외 11자리**


### 3. 홈화면

1. 저장된 앨범이 없는경우 (신규)

<img width="500" alt="스크린샷 2024-12-20 오후 11 44 55" src="https://github.com/user-attachments/assets/aedccdf9-fbc3-4c54-92e2-d8d3304fea1a" />

2. 저장된 앨범이 있는경우

<img width="500" alt="스크린샷 2024-12-20 오후 11 46 33" src="https://github.com/user-attachments/assets/d2e20804-0d65-4b2e-be94-8f50981c50f5" />

- **저장된 앨범 정보를 확인할수 있으며, 새로운 앨범을 추가할수있다.**
- **저장된 앨범은 4가지 앨범색상이 랜덤으로 생성되고 앨범 클릭시 저장되어 있는 상세사진들을 확인할수있고, 앨범을 선택하여 삭제할수있다.**


### 4. 저장된 앨범의 상세 사진 조회

<img width="500" alt="스크린샷 2024-12-21 오전 12 32 13" src="https://github.com/user-attachments/assets/c87aeb35-bf16-4620-b761-ba0d40cdf93f" />

- **저장한 앨범을 폴라로이드 느낌처럼 한장씩 확인할수있다. 또한 왼쪽 상단 수정버튼을 통해서 사진을 삭제,수정,추가 할수있다.**


### 5. 앨범 추가 및 삭제 팝업

<img width="500" alt="스크린샷 2024-12-20 오후 11 49 32" src="https://github.com/user-attachments/assets/2d3136b8-071b-4a51-a093-aaff3af19543" />

- **앨범추가 버튼을 클릭했을때 와 수정버튼을 클릭했을때 팝업창 형식으로 앨범과 사진을 생성할수있다.**
- **파일의 확장자는 .jpg, .jpeg, .png 만 가능하다.**
