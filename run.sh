#!/bin/bash

./gradlew clean build
docker compose down
docker compose build --no-cache
docker compose up -d

echo "Esperando a que los contenedores estén listos..."
sleep 10

./gradlew bootRun
