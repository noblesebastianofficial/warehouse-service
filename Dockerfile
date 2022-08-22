FROM openjdk:17-oracle

LABEL maintainer="noblesebastiank@gmail.com"


WORKDIR /usr/local/bin/

COPY target/warehouse-1.0.1.0-SNAPSHOT.jar webapp.jar

CMD ["java","-jar","webapp.jar"]
