#! /bin/bash
cp ../../basketball-MVC/*.war ./
docker build -t basketball-api -f Dockerfile .
rm *.war

#start container
#docker run --name test-api basketball-api