# Getting Started

### Project setup

* Project.http : This contains a set of http requests for the project
* application.yml : spring boot setup for the project

### Current experiments

 - Multi threading
 - Kafka

### kafka setup 

 - [Download kafka here](https://kafka.apache.org/downloads)
 - Extract in a folder
 - Start zookeeper using command `bin/zookeeper-server-start.sh config/zookeeper.properties`
 - Start kafka listern using command `bin/kafka-server-start.sh config/server.properties`
 - Start project using command `mvn spring-boot:run`
 - Hit the apis present