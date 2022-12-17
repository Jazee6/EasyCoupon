FROM openjdk:17

MAINTAINER Jazee

ADD EasyCoupon-0.0.1.jar app.jar

RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]