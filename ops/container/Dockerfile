FROM tomcat:9.0.10-jre8

EXPOSE 8080

ENV PROFILE=dev
ENV AWS_REGION=us-east-1
ENV DB_URL=172.17.0.4:5432/basketball_xx
ENV DB_PASSWORD=password
ENV DB_USERNAME=admin

# set environment

RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY ./*.war /usr/local/tomcat/webapps/ROOT.war
COPY ./setenv.sh /usr/local/tomcat/bin/setenv.sh