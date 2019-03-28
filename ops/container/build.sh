#! /bin/bash
cp ./basketball-MVC/target/*.war ./ops/container/
cd ./ops/container/
docker build -t basketball-api -f Dockerfile .
rm *.war

#start container
docker run --name test-api -e PROFILE=dev -e DB_URL=jdbc:postgresql://172.17.0.2:5432/basketball -e DB_USERNAME=admin -e DB_PASSWORD=password -e AWS_REGION=us-east-1 basketball-api