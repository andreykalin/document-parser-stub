FROM openjdk:17-alpine

ENV TZ="Europe/Moscow"

RUN addgroup -S springrunner && adduser -S springrunner -G springrunner -u 1010
USER springrunner:springrunner

ARG DEPENDENCY=/build/libs/dependencies
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} ${VM_OPTS} -Dspring.profiles.active=json-log -cp app:app/lib/* ru.lanit.demo.documentparserstub.DocumentParserStubApplication ${0} ${@}"]
