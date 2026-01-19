# 가벼운 nginx 이미지 사용
FROM nginx:1.25-alpine

# 기본 nginx 설정 제거
RUN rm /etc/nginx/conf.d/default.conf

# 프로젝트 전용 nginx 설정 복사
COPY nginx.conf /etc/nginx/nginx.conf

# 외부에서 접근할 포트
EXPOSE 80

# nginx 포그라운드 실행 (Docker 필수 옵션)
CMD ["nginx", "-g", "daemon off;"]
