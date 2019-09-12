FROM fabric8/java-jboss-openjdk8-jdk:1.4
ADD demo-20190828.jar app.jar
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar" ]
EXPOSE 8989