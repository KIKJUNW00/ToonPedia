# 🖼 웹툰 추천 웹페이지 ToonPedia

![readme_mockup2](/frontend/src/Image/image.png)

<br>

## 프로젝트 소개

- 웹툰을 좋아하는 사람들이 카카오, 네이버, 페이지의 웹툰을 한 곳에서 찾고, 사람들과 커뮤니케이션하는 웹커뮤니티 입니다.
- 개인이 좋아하는 웹툰을 찜하고 웹툰 사이트로 바로 들어갈 수 있습니다.
- 커뮤니티 페이지에서 웹툰을 좋아하는 사람들과 소통할 수 있습니다.
- 유저들의 게시글에 좋아요를 누르거나 댓글을 달 수 있습니다.

<br>

## 팀원 구성

<div align="center">

| **김준우** | **류승진** |
| :------: |  :------: |
| **BE** | **FE** |
| [<img src="/frontend/src/Image/KakaoTalk_20241017_113806726.jpg" height=150 width=150> <br/> @KIKJUNW0](https://github.com/KIKJUNW00) | [<img src="/frontend/src/Image/pngtree-colorless-character-avatar-with-glasses-png-image_6317135.jpg" height=150 width=150> <br/> @lenoau](https://github.com/lenoau) |

</div>

<br>

## 1. 개발 기간
- 전체 개발 기간 : 2024-12-06 ~ 2025-01-10

<br>

## 2. 개발 환경
- Front : React.js, HTML, CSS, JavaScript, Tailwind
- Back-end : Springboot
- DataBase : MySQL
- 협업 툴 : Notion, Figma, Github

<br>

## 3. 역할 분담

### 👦김준우(BE)

- **기능**
    - 커뮤니티: 게시글 작성, 수정, 삭제, 상세, 전달
    - 로그인: OAuth2로그인, JWT생성 및 전달
    - 마이페이지: 관심웹툰 회원별 저장, 관심웹툰 삭제

<br>

### 🧑류승진(FE)
- **기능**
    - 웹툰정보: 웹툰정보 메인화면에 불러오기, 요일별 웹툰 불러오기
    - Rest API를 사용한 화면 전환 및 기능 구현
- **UI**
    - 전체적인 UI작성

<br>

## 4. 페이지별 기능

### [메인화면]
<br>
![mainPage](/frontend/src/Image/main.png)

- https://github.com/HyeokjaeLee/korea-webtoon-api?tab=readme-ov-file 에서 공유한 api를 통해서 웹툰정보들을 불러온다


### [로그인]
<br>
![login](/frontend/src/Image/login.png)

- 회원ID와 비밀번호를 JWT토큰을 통해 인증 및 인가하여 로그인
- OAuth2로그인을 사용하여 sns로그인사용


### [회원가입]
<br>
![join](/frontend/src/Image/join.png)

- 로그인과 마찬가지로 sns회원가입 사용
- 회원 비밀번호 유효성 검증
- 회원 닉네임, ID, 비밀번호 DB 저장

### [요일별 웹툰]
<br>
![dayWebtoon](/frontend/src/Image/dayWebtoon.png)

- 월~일 요일별 웹툰 불러오기

### [게시판]
<br>
![Board](/frontend/src/Image/Board.png)

- DB에 저장된 게시글 불러오기
- 게시글 작성시 **분전, **몇일전, **몇시간전 으로 시간표기

### [게시판글쓰기]
<br>
![write](/frontend/src/Image/write.png)

- 로그인된 회원별 글 저장

### [상세게시판]
<br>
![detailBoard](/frontend/src/Image/detailBoard.png)

- 게시판별 댓글 불러오기 및 댓글 작성
- 로그인된 회원별 댓글 저장

### [마이페이지]
<br>
![myPage](/frontend/src/Image/myPage.png)

- 로그인된 회원별 관심웹툰 불러오기
- 하트 누를시 저장, 및 삭제

## 5. 개발일지
<br>
https://nettle-quicksand-656.notion.site/ToonPedia-1261509e5055800e8a98dda7da880825?pvs=4



## 6. 시연영상
<br>
 - https://youtu.be/7hHjTC5dWq0


## 7. 참고

 - https://korea-webtoon-api-cc7dda2f0d77.herokuapp.com/api-docs/
