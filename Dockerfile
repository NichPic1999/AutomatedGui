FROM openjdk:8

RUN mkdir /artifact
RUN cd artifact


WORKDIR /artifact

RUN apt update
RUN apt install curl

#RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: token 717f33f2d811e00d81fff954b569864ded35696a" https://api.github.com/repos/NichPic1999/AutomatedGUI/actions/artifacts/40712006/zip --output cartella.zip
#
#RUN unzip cartella.zip

CMD ["java", "-jar", "Homework_Aereoporto-1.0-SNAPSHOT.jar"]