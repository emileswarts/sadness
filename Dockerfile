FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/sadness.jar /sadness/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/sadness/app.jar"]
