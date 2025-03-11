FROM tomcat:11-jdk17

WORKDIR /usr/local/tomcat

RUN rm -rf /webapps/*

COPY build/libs/JavaShop-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
