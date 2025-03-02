package com.game.globetrotter.util;

import com.game.globetrotter.dto.ChallangeDTO;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class ImageGenerator {

    public byte[] generateChallengeImage(ChallangeDTO challenge) {
        try {
            // Create a blank image
            BufferedImage image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();

            // Set background
            g2d.setColor(new Color(25, 118, 210)); // Blue background
            g2d.fillRect(0, 0, 600, 400);

            // Add decorative elements
            g2d.setColor(new Color(41, 182, 246)); // Lighter blue
            g2d.fillOval(450, 50, 100, 100);
            g2d.fillRect(50, 300, 150, 50);

            // Set title text properties
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 30));
            g2d.drawString("GLOBETROTTER", 170, 80);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            g2d.drawString("THE ULTIMATE TRAVEL CHALLENGE", 120, 120);

            // Add challenge info
            g2d.setFont(new Font("Arial", Font.PLAIN, 18));
            g2d.drawString("You've been challenged by:", 180, 180);
            g2d.setFont(new Font("Arial", Font.BOLD, 24));
            g2d.drawString(challenge.getCreatorUsername(), 230, 220);

            // Add score info
            g2d.setFont(new Font("Arial", Font.PLAIN, 18));
            g2d.drawString("Current Score: " + challenge.getCreatorScore(), 210, 260);

            // Add call to action
            g2d.setColor(new Color(255, 235, 59)); // Yellow
            g2d.fillRoundRect(150, 300, 300, 50, 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            g2d.drawString("ACCEPT CHALLENGE!", 190, 330);

            // Dispose graphics
            g2d.dispose();

            // Convert to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();

        } catch (IOException e) {
            throw new RuntimeException("Failed to generate challenge image", e);
        }
    }
}
