FROM tomcat:9.0-alpine

LABEL MAINTAINER=nathalia_amaral

EXPOSE 3004

ADD /target/gestaoprocind.war /usr/local/tomcat/webapps/