FROM openjdk:11
WORKDIR /
RUN mkdir -p /jvm/heap
RUN mkdir -p /jvm/log
ENV LANG en_US.UTF-8
ADD /target/medusa-server.jar /app.jar
CMD java ${JAVA_OPTS} -jar app.jar