import java.io.*;
import java.nio.charset.*;

public class Serializer implements FlowerInterface {

    public static void serializeToCSV(Flower myFlower, String filename) {
        String flowerDetails = Flower.getFlowerDetails(myFlower).toString();
        File file = new File(filename);
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8 ))) {
            writer.write(flowerDetails);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFlowerName() {

    }

    @Override
    public void setFlowerColor() {

    }
}
