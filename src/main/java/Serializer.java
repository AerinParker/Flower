import java.io.*;
import java.nio.charset.*;

public class Serializer implements FlowerInterface {
    @Override
    public void setFlowerName() {

    }

    @Override
    public void setFlowerColor() {

    }

    public static void serializeToCSV(Flower myFlower, String filename) {
        String flowerDetails = Flower.getFlowerDetails(myFlower).toString();
        File file = new File(filename);
        try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8 ))) {
            out.write(flowerDetails);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
