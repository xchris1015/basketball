#! /bin/bash
cp ./basketball-worker/target/*.jar ./ops/container/
cd ./ops/container/

build image:
docker build -t basketball-worker -f Dockerfile-worker .

rm *.jar

run the docker image:
docker run --name SQS-worker -e PROFILE=dev -e AWS_ACCESSKEYID=AKIAJJKVQYGTGNZ7CXRA -e AWS_SECRETKEY=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 -e DB_URL=jdbc:postgresql://172.17.0.2:5432/basketball -e DB_USERNAME=admin -e DB_PASSWORD=password -e AWS_REGION=us-east-1 basketball-worker