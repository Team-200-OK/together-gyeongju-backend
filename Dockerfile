FROM openjdk:17-jdk-slim

WORKDIR /app

ARG JAR_FILE=./build/libs/together-gyeongju-0.0.1-SNAPSHOT.jar
ARG PROFILES
ARG ENV

# JAR 파일 메인 디렉토리에 복사
COPY ${JAR_FILE} together-gyeongju-spring-boot-app.jar

# 정적 파일을 저장하기 위한 공간
RUN mkdir -p /app/mm
RUN mkdir -p /app/mm/images

# 시스템 진입점 정의
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-Dspring.profiles.active=${PROFILES}", "-jar", "together-gyeongju-spring-boot-app.jar"]