# 🌍 GlobeTrotter Challenge

**The Ultimate Travel Guessing Game!**

GlobeTrotter is an engaging web application that tests your knowledge of world destinations through a fun guessing game. Travel the world virtually, learn interesting facts about different places, and challenge your friends to see who knows more about our planet's amazing locations!

## 🚀 Features

### 🎮 Core Gameplay
- **Destination Guessing**: Be presented with clues about mystery destinations and guess the correct location
- **Rich Clue System**: Each destination comes with unique clues to help guide your guesses
- **Learning Experience**: Discover fascinating fun facts and trivia for each destination
- **Score Tracking**: Keep track of your correct and incorrect answers

### 🏆 Challenge System
- **User Profiles**: Create a unique username to track your progress
- **Friend Challenges**: Send challenge links to friends through WhatsApp
- **Social Competition**: Compare scores with friends to see who's the ultimate GlobeTrotter
- **Shareable Content**: Dynamic images generate with your challenge invitations

## 💻 Technology Stack

- **Backend**: Spring Boot, Java 17
- **Database**: MySQL
- **ORM**: Spring Data JPA
- **Security**: Spring Security
- **Frontend**: [Your frontend tech here - e.g., React, Angular, Thymeleaf]

## 🛠️ Installation & Setup

### Prerequisites
- Java 17 or higher
- Maven
- MySQL

### Database Setup
1. Create a MySQL database named `globetrotter`
2. Run the database scripts in the `db/` directory to create the necessary tables
3. (Optional) Load the sample data using the provided SQL scripts

### Application Setup
1. Clone the repository:
   ```
   git clone https://github.com/yourusername/globetrotter.git
   cd globetrotter
   ```

2. Configure the application properties in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/globetrotter
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. Build the application:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

5. Access the application at `http://localhost:8080`

## 📊 Dataset

The application includes a rich dataset of 100+ global destinations, each featuring:
- City and country information
- Multiple clues to help players guess the location
- Fun facts to learn after guessing
- Trivia about the destination's culture, history, and more

The dataset is securely stored in the backend database to prevent client-side peeking.

## 🎮 How to Play

1. Visit the GlobeTrotter website
2. Create a username to start tracking your progress
3. Read the clues about a mystery destination
4. Select your guess from the multiple choice options
5. Receive immediate feedback and learn fun facts
6. Continue playing to improve your score
7. Challenge friends to beat your score!

## 🔗 Challenge a Friend

1. Click the "Challenge a Friend" button
2. Share the generated link via WhatsApp
3. Your friend will see your score and can try to beat it
4. Compare results and see who's the ultimate GlobeTrotter!

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📞 Contact

Your Name - thakurpg9@gmail.com
