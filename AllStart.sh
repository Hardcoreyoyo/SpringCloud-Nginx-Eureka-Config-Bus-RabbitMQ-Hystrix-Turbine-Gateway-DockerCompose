#!/bin/sh

mvn -f ./ServiceEureka package 

mv -f ./ServiceEureka/target/ServiceEureka-SE1.0.0.jar ./SpringCloudNetflixDocker/ServiceEureka/

mvn -f ./ServiceEurekaPeer2 package 

mv -f ./ServiceEurekaPeer2/target/ServiceEurekaPeer2-SE1.0.0.jar ./SpringCloudNetflixDocker/ServiceEurekaPeer2/

mvn -f ./ServiceEurekaPeer3 package 

mv -f ./ServiceEurekaPeer3/target/ServiceEurekaPeer3-SE1.0.0.jar ./SpringCloudNetflixDocker/ServiceEurekaPeer3/

docker-compose up -d
