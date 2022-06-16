# Backend Only Bank Contas

Esta aplicação possui o serviço de contas:
Base de dados: AWS DynamoDB

--build

docker buildx build --platform=linux/amd64 --build-arg JAR_FILE=backend-onlybank-conta-1.0.0-SNAPSHOT.jar -t sdm/backend-onlybank-conta .

--run

docker run -it -p 8081:8080 --name backend-onlybank-conta -e APP_AWS_ACCESSKEY=ACCESSKEY -e APP_AWS_SECRETKEY=SECRET sdm/backend-onlybank-conta
