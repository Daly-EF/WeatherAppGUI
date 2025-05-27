import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class WeatherAppGui extends JFrame {
    public WeatherAppGui() {
        // Set up our gui and add a title
        super("Weather App");

        //Configure gui to end the programs process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Set the size of our gui
        setSize(450, 650);

        //Load our gui at the center of the screen
        setLocationRelativeTo(null);

        //Make our layout manager null to manually position our components within the gui
        setLayout(null);

        //Prevent the resize of the GUI
        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents(){
        //search field
        JTextField searchTextField = new JTextField();

        //set the location and size of our component
        searchTextField.setBounds(15, 15, 351, 45);

        //change the font
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTextField);

        //Search button
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));

        //Change the cursor to a hand cursor when hovering over this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        add(searchButton);

        //Weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        //Temperature Text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));

        //Center the textS
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        //Weather Condition description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 450, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        //Humidity Image
        JLabel humidityImage = new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        //Humidity Text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        //Windspeed image
        JLabel windspeedImage = new JLabel(loadImage("src/assets/windspeed.png"));
        windspeedImage.setBounds(220, 500, 74, 66);
        add(windspeedImage);

        //Windspeed Text
        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(310, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);

    }

    //Used to create image in out GUI components
    private ImageIcon loadImage(String resourcePath){
        try{
            //read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));

            //returns and image icon so that our component can render it
            return new ImageIcon(image);

        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Could not find resource");
        return null;
    }


}