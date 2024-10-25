import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Assignment2_Jform extends JFrame {
    private JLabel petLabel;
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ButtonGroup petGroup;

    // Paths for pet images
    private final String birdImage = "images/bird.jpg";
    private final String catImage = "images/cat.jpg";
    private final String dogImage = "images/dog.jpg";
    private final String rabbitImage = "images/rabbit.jpg";
    private final String pigImage = "images/pig.jpg";

    public Assignment2_Jform() {
        setTitle("Choose a pet");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the radio buttons
        petGroup = new ButtonGroup();
        petGroup.add(birdButton);
        petGroup.add(catButton);
        petGroup.add(dogButton);
        petGroup.add(rabbitButton);
        petGroup.add(pigButton);

        // Set default selected radio button
        dogButton.setSelected(true);

        // Panel to hold radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Label to display the selected pet image
        petLabel = new JLabel();
        petLabel.setHorizontalAlignment(JLabel.CENTER);
        updatePetImage(dogImage);

        // Action listeners for each radio button
        birdButton.addActionListener(new PetSelectionListener(birdImage));
        catButton.addActionListener(new PetSelectionListener(catImage));
        dogButton.addActionListener(new PetSelectionListener(dogImage));
        rabbitButton.addActionListener(new PetSelectionListener(rabbitImage));
        pigButton.addActionListener(new PetSelectionListener(pigImage));

        // Add components to the frame
        add(radioPanel, BorderLayout.WEST);
        add(petLabel, BorderLayout.CENTER);
    }

    // Method to update the image displayed in petLabel
    private void updatePetImage(String imagePath) {
        System.out.println("Loading image: " +imagePath);
     try {
        ImageIcon petIcon = new ImageIcon(getClass().getResource("/" + imagePath));
        Image scaledImage = petIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        petLabel.setIcon(new ImageIcon(scaledImage));
        petLabel.setText(null); // Clear text when image is shown
    } catch (Exception e) {
        petLabel.setText("Could not load image: " + imagePath);
        e.printStackTrace();
    }
        
        
            
    }

    // Action listener class to handle pet selection
    private class PetSelectionListener implements ActionListener {
        private String imagePath;

        public PetSelectionListener(String imagePath) {
            this.imagePath = imagePath;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            updatePetImage(imagePath);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Assignment2_Jform app = new Assignment2_Jform();
            app.setVisible(true);
        });
    }
}
