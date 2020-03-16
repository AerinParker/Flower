import com.thoughtworks.xstream.XStream;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Flower implements FlowerInterface, Serializable {
    private String flowerName;
    private String flowerColor;

    public Flower() {
    }

    public Flower(String flowerName, String flowerColor) {
        this.flowerName = flowerName;
        this.flowerColor = flowerColor;
    }

    public static StringBuilder getFlowerDetails(Flower myFlower) {
        StringBuilder flowerDetails = new StringBuilder();
        flowerDetails.append(myFlower.getFlowerName());
        flowerDetails.append(",");
        flowerDetails.append(myFlower.getFlowerColor());
        return flowerDetails;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public static Flower deserializeFromCSV(String filename) throws IOException {

        Path path = Paths.get(filename);

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        String [] contents = line.split(",");
        Flower flower1 = new Flower(contents[0], contents[1]);
        return flower1;
    }

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

    public static void binarySerialization(Flower myFlower, String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream objectOut = new ObjectOutputStream (fileOut);
        objectOut.writeObject (myFlower);
        fileOut.close();
        objectOut.close();
    }

    public static Flower binaryDeserialization(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Flower flower1 = (Flower) objectIn.readObject();
        fileIn.close();
        objectIn.close();
        return flower1;
    }

    public static void serializeToXML (Flower myFlower, String filename) throws IOException {
        FileOutputStream objectOut = new FileOutputStream(filename);
        XMLEncoder encoder = new XMLEncoder(objectOut);
        encoder.writeObject(myFlower);
        encoder.close();
        objectOut.close();
    }

    public static Flower deserializeFromXML (String filename) throws IOException {
        FileInputStream objectIn = new FileInputStream(filename);
        XMLDecoder decoder = new XMLDecoder(objectIn);
        Flower flower1 = (Flower) decoder.readObject();
        decoder.close();
        objectIn.close();
        return flower1;
    }

    public static Flower xStreamSerialization (Flower myFlower) throws IOException {
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        Class [] classes = new Class [] { Flower.class };
        xStream.allowTypes(classes);
        String xml = xStream.toXML(myFlower);
        Flower flower1 = (Flower) xStream.fromXML(xml);
        return flower1;
    }

    @Override
    public boolean equals(Object o) {
        Boolean retVal = null;
        retVal = (this == o);
            if (o == null || ! (o instanceof Flower)) retVal = false;
        Flower flower = (Flower) o;
        retVal = Objects.equals(flowerName, flower.flowerName) &&
                Objects.equals(flowerColor, flower.flowerColor);
        return retVal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowerName, flowerColor);
    }

}