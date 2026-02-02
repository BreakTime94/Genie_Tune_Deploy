## GenieTune

### 웹툰 AI 창작 교육을 통해 학생들의 문해력과 사고력을 키우는 교육 플랫폼

### 프로젝트 개요
- 프로젝트 목적: AI 활용 웹툰 제작 교육을 통해 올바른 활용 인식을 함양시키며 올바른 문장 활용 가이드 라인 제시
- 개발 기간: 2025.12.15 ~ 2026.01.16

#### 팀 구성
- Frontend:	UI/UX 설계, Next.js 기반 서비스 흐름 구현
- Backend: Spring Boot API, GraphQL, 인증/보안, 결제 
- AI: Python 기반 텍스트 순화·이미지 생성 파이프라인
- 담당역할: #### Backend

#### 🛠 기술 스택
##### Frontend

- Next.js 14 (App Router)

- TypeScript

- Apollo Client (GraphQL)

- Redux Toolkit

- Tailwind CSS 등

##### Backend

- Java 17

- Spring Boot 3.5.8

- GraphQL

- Spring Security + JWT (Access / Refresh)

- Redis (세션·토큰 관리)

- PostgreSQL

- JPA

- PortOne V2 api(외부 API)

- 국세청 사업자등록증 진위여부 API

- AWS S3 (파일 저장)

- Python 연동 등

##### AI / Model

- Python (FastAPI)

- KoBART Fine-tuning (한국어 문장 순화)

- OpenAI DALL·E 3

- Diffusers / Transformers / Torch 등

##### Infra

- Oracle Cloud (Ubuntu)

- Docker / Docker Compose

- Nginx (Reverse Proxy)

### TABLE 정의서
<img width="985" height="508" alt="image" src="https://github.com/user-attachments/assets/610ecb6e-c5ca-4066-9cef-1e65d0eb7fb9" />

### 프로젝트 구조 
<img width="953" height="459" alt="image" src="https://github.com/user-attachments/assets/d0af5d01-fd61-46c6-9429-99bf7b101129" />

### 비즈니스 로직 흐름
<img width="954" height="455" alt="image" src="https://github.com/user-attachments/assets/ff580e4c-b307-483f-bcce-a894b01b337a" />

<img width="986" height="467" alt="image" src="https://github.com/user-attachments/assets/2dfeaa01-8dc4-40bc-ba6f-0e1901366ca6" />

### 참고사항
- 현재 Python 파트는 aws server 유지 비용 이슈로 AI 담당자가 서버를 내린상태 (로컬 PC 및 github에 코드 가지고 있음)

### 릴리즈노트
- (26.02.02) 배포 프로젝트의 첨부파일 미작동 문제 확인 코드 보완 및 수정 필요
