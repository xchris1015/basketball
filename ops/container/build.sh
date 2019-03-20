#! /bin/bash
cp ./basketball-MVC/target/*.war ./ops/container/
cd ./ops/container/
docker build -t basketball-api -f Dockerfile .
rm *.war

#start container
#docker run --name test-api basketball-api