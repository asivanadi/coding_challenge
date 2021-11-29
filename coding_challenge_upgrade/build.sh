#!/usr/bin/env bash

echo "Setting environment variables"

export CREDIFY_URL="https://credapi.credify.tech"
export CREDIFY_WEB_URL="https://www.credify.tech"
export BROWSER="CHROME"

echo "Versions for Java and Maven"
java -version
mvn --version

echo "Executing the tests"
mvn clean test

echo "Generation of the reports"
mkdir target
mkdir target/allure-results

cp api/target/allure-results/* target/allure-results/
cp uitests/target/allure-results/* target/allure-results/
mvn allure:report
mvn allure:serve