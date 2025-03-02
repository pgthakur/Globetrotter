-- Destinations Table
CREATE TABLE destinations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Clues Table
CREATE TABLE clues (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    destination_id BIGINT NOT NULL,
    text VARCHAR(500) NOT NULL,
    FOREIGN KEY (destination_id) REFERENCES destinations(id)
);

-- Fun Facts Table
CREATE TABLE fun_facts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    destination_id BIGINT NOT NULL,
    text VARCHAR(500) NOT NULL,
    type VARCHAR(20) NOT NULL, -- 'FUN_FACT' or 'TRIVIA'
    FOREIGN KEY (destination_id) REFERENCES destinations(id)
);

-- Users Table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    correct_answers INT DEFAULT 0,
    wrong_answers INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Challenges Table
CREATE TABLE challenges (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    challenge_id VARCHAR(36) UNIQUE NOT NULL,
    creator_id BIGINT NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (creator_id) REFERENCES users(id)
);