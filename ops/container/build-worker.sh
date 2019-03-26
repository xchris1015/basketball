build image:
docker build -t basketball-worker -f Dockerfile-worker .

run the docker image:
docker run --name worker -e ENV=test -e AWS_REGION=us-east-2 piggie-worker