FROM openjdk:8-jdk
COPY ./target/SpotyShoes-0.0.1-SNAPSHOT.jar SpotyShoes-0.0.1-SNAPSHOT.jar
CMD ["java" ,"-jar","SpotyShoes-0.0.1-SNAPSHOT.jar"]
RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers

#-> Create a image for springboot webservice
# -->  Dockerfile
#  - -> docker image build -t <imagetagname> .

#-> run container by using custom image
# -> docker container run  --name <ecom-web-service> -p 8080:8080 -d <ecom-webservice>


#-> verify log 
#  -> docker container log <container-name>