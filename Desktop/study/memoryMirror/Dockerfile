# 1. Base 이미지 설정 (Java 17 사용)
FROM openjdk:17-jdk-slim

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 애플리케이션 JAR 파일 복사
COPY build/libs/memoryMirror-0.0.1-SNAPSHOT.jar app.jar

# 4. 필요한 리소스 복사 (Optional, static/templates가 있다면)
#COPY src/main/resources/static /app/static
#COPY src/main/resources/templates /app/template

# github action 경로 추가
COPY home/runner/work/MemoryMirror/MemoryMirror/Desktop/study/memoryMirror/src/main/resources/static /app/static
COPY home/runner/work/MemoryMirror/MemoryMirror/Desktop/study/memoryMirror/src/main/resources/templates /app/template

# 5. 포트 노출 (Spring Boot 기본 포트)
EXPOSE 8080

# 6. 애플리케이션 실행 명령어 설정
ENTRYPOINT ["java", "-jar", "app.jar"]
