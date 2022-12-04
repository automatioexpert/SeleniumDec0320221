FROM selenium/node-chrome

COPY . .

USER root
RUN apt-get update
RUN apt-get install maven -y
RUN apt-get install openjdk-8-jdk -y
RUN apt-get install dos2unix
RUN dos2unix command.sh

ENTRYPOINT ["bash", "command.sh"]