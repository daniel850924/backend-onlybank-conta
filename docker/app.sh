#!/bin/bash
echo "Executando app.sh"
echo "Substituindo variaveis em application.properties"
sed -i "s/APP_AWS_ACCESSKEY/${APP_AWS_ACCESSKEY}/g" application.properties
sed -i "s/APP_AWS_SECRETKEY/${APP_AWS_SECRETKEY}/g" application.properties
echo "application.properties modificado com sucesso!"
java -jar app.jar