# Game of Three - Player 1

This project implements a two-player game using Spring Boot applications communicating with Kafka.

### Gameplay:

Two independent players (separate applications) take turns modifying a number.
Each player can add, subtract 1, or keep the current number then divide it by 3.
The goal is to reach the number 1 first.

![img.png](img.png)

#### Communication:

Players communicate their moves by sending messages to Kafka topics.
Each player listens for moves sent by the other player on a dedicated topic.

#### Project Structure:

* **[Shared Domain Model](https://github.com/AmjadKhader/Game-of-three.Game)**: A separate project contains the Game class, defining the game logic.

* **Player Applications**: Two Spring Boot applications represent each player ([Player1Application](https://github.com/AmjadKhader/Game-of-Three.Player1) and [Player2Application](https://github.com/AmjadKhader/Game-of-Three.Player2)). They use Kafka to send and receive moves from their designated topics.



### Running the Application:

Ensure you have docker compose up using the command `docker compose up -d`.

**Ensure to run both services**


#### Additional Notes:

This is a basic implementation focusing on game logic and Kafka communication.
You can manually choose the starting value of the game by calling `POST /game/start` 

**Technologies Used:**
* Spring Boot 
* Apache Kafka