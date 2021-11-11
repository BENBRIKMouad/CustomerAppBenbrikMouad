#!/bin/sh
mvn clean package && docker build -t ma.benbrik/CustomerAppBenbrikMouad .
docker rm -f CustomerAppBenbrikMouad || true && docker run -d -p 9080:9080 -p 9443:9443 --name CustomerAppBenbrikMouad ma.benbrik/CustomerAppBenbrikMouad