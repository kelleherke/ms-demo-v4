#!/bin/sh

echo "********************************************************"
echo "Waiting for the eureka server to start on port $EUREKASERVER_PORT"
echo "********************************************************"
while ! `nc -z eurekaserver  $EUREKASERVER_PORT`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Waiting for the ZIPKIN server to start  on port $ZIPKIN_PORT"
echo "********************************************************"
while ! `nc -z zipkin $ZIPKIN_PORT`; do sleep 10; done
echo "******* ZIPKIN has started"

echo "********************************************************"
echo "Starting Zuul Service with Configuration Service via Eureka :  $EUREKASERVER_URI" ON PORT: $SERVER_PORT;
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT   \
     -Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI   \
     -Dspring.profiles.active=$PROFILE                          \
     -Dspring.zipkin.baseUrl=$ZIPKIN_URL                       \
     -jar /usr/local/zuulservice/zuulsvr-0.0.1-SNAPSHOT.jar