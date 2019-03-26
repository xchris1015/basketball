FROM java:openjdk-8

ENV PROFILE=dev
ENV AWS_REGION=us-east-1


#config jar file and run it
#RUN yum install/ apt-get install

COPY ./*.jar /tmp/worker.jar

CMD ["java", "-jar","/tmp/worker.jar","-Dspring.profiles.active=${PROFILE}","-Daws.region=${AWS_REGION}"]