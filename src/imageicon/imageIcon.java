package imageicon;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class imageIcon
{
    public static ImageIcon getImageIcon(String filePath, int width, int height) 
    {
        try 
        {
            return new ImageIcon(
                    ImageIO.read(new File(filePath)).getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
}

