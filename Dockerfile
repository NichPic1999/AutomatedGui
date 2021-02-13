FROM openjdk:8

RUN mkdir /artifact
RUN cd artifact

#0e9593bd3a0e44da3c07901ec4e586ff7359b856
WORKDIR /artifact

RUN apt update
RUN apt install curl

RUN apt-get install -y libxrender1 libxtst6 libxi6

RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: token " https://api.github.com/repos/NichPic1999/AutomatedGui/actions/artifacts/40910883/zip --output cartella.zip

RUN jar xvf cartella.zip

CMD ["java", "-jar", "Homework_Aereoporto-1.0-SNAPSHOT.jar"]