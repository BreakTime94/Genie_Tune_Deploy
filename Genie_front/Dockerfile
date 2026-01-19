# 1. 가볍고 최신인 Node.js 20 환경을 베이스로 시작
FROM node:20-alpine

# 2. 컨테이너 내부의 작업 디렉토리를 /app으로 설정
WORKDIR /app

# 3. 라이브러리 목록만 먼저 복사
# (파일 수정 시 매번 설치하지 않게 캐시를 활용하려는 목적)
COPY package.json package-lock.json ./

# 4. 라이브러리 설치 (npm install보다 엄격하고 빠른 ci 사용)
RUN npm ci

# 5. 내 서버의 모든 소스 코드를 컨테이너 안으로 복사
COPY . .

# 6. Next.js의 빌드 과정 실행 (.next 폴더 생성)
RUN npm run build

# 7. 컨테이너 3000번 포트 사용 명시
EXPOSE 3000

# 8. 컨테이너가 켜지면 실제로 실행할 명령어 (서버 시작)
CMD ["npm", "run", "start"]