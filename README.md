🌍 GlobeTrotter Challenge
The Ultimate Travel Guessing Game!
GlobeTrotter is an engaging web application that tests your knowledge of world destinations through a fun guessing game. Travel the world virtually, learn interesting facts about different places, and challenge your friends to see who knows more about our planet's amazing locations!
🚀 Features
🎮 Core Gameplay

Destination Guessing: Be presented with clues about mystery destinations and guess the correct location
Rich Clue System: Each destination comes with unique clues to help guide your guesses
Learning Experience: Discover fascinating fun facts and trivia for each destination
Score Tracking: Keep track of your correct and incorrect answers

🏆 Challenge System

User Profiles: Create a unique username to track your progress
Friend Challenges: Send challenge links to friends through WhatsApp
Social Competition: Compare scores with friends to see who's the ultimate GlobeTrotter
Shareable Content: Dynamic images generate with your challenge invitations

💻 Technology Stack

Backend: Spring Boot, Java 17
Database: MySQL
ORM: Spring Data JPA
Security: Spring Security

🛠️ Installation & Setup
Prerequisites

Java 17 or higher
Maven
MySQL

Database Setup

Create a MySQL database named globetrotter
Run the database scripts in the db/ directory to create the necessary tables
(Optional) Load the sample data using the provided SQL scripts

Application Setup

Clone the repository:
Copygit clone https://github.com/yourusername/globetrotter.git
cd globetrotter

Configure the application properties in src/main/resources/application.properties:
propertiesCopyspring.datasource.url=jdbc:mysql://localhost:3306/globetrotter
spring.datasource.username=your_username
spring.datasource.password=your_password

Build the application:
Copymvn clean install

Run the application:
Copymvn spring-boot:run

Access the application at http://localhost:8080

📊 Dataset
The application includes a rich dataset of 100+ global destinations, each featuring:

City and country information
Multiple clues to help players guess the location
Fun facts to learn after guessing
Trivia about the destination's culture, history, and more

The dataset is securely stored in the backend database to prevent client-side peeking.
🎮 How to Play

Visit the GlobeTrotter website
Create a username to start tracking your progress
Read the clues about a mystery destination
Select your guess from the multiple choice options
Receive immediate feedback and learn fun facts
Continue playing to improve your score
Challenge friends to beat your score!

🔗 Challenge a Friend

Click the "Challenge a Friend" button
Share the generated link via WhatsApp
Your friend will see your score and can try to beat it
Compare results and see who's the ultimate GlobeTrotter!

🤝 Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

Fork the project
Create your feature branch (git checkout -b feature/AmazingFeature)
Commit your changes (git commit -m 'Add some AmazingFeature')
Push to the branch (git push origin feature/AmazingFeature)
Open a Pull Request
