FROM openjdk:8

RUN mkdir /artifact
RUN cd artifact


WORKDIR /artifact

RUN apt update
RUN apt install curl

RUN apt-get install -y libxrender1 libxtst6 libxi6

RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: token 4ca19c000e6a24230339a548eedaddee68b676ee" https://api.github.com/repos/NichPic1999/AutomatedGui/actions/artifacts/41160996/zip --output cartella.zip

RUN jar xvf cartella.zip

CMD ["java", "-jar", "Homework_Aereoporto-1.0-SNAPSHOT.jar"]