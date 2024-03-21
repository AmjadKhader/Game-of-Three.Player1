FROM openjdk:17-oracle

MAINTAINER Amjad Khader <amjad@amjadkhader.com>

COPY /target/player1-1.0.0.jar justeattakeawayplayer1challenge.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "justeattakeawayplayer1challenge.jar"]