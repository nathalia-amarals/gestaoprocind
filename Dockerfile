FROM tomcat:9.0-alpine

LABEL MAINTAINER=nathalia_amaral

EXPOSE 3004

RUN sed -i 's/port="8080"/port="3004"/' ${CATALINA_HOME}/conf/server.xml

ADD /target/gestaoprocind.war /usr/local/tomcat/webapps/