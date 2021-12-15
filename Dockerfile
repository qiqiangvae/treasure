FROM openjdk:8
MAINTAINER qiqiang.online
ADD treasure-console/target/treasure-console.jar /home/treasure/treasure-console.jar
ADD fs.sh /home/treasure/fs.sh
WORKDIR /home/treasure
CMD sh fs.sh start
EXPOSE 6677