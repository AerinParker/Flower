public class Flower implements FlowerInterface {
    private String flowerName;
    private String flowerColor;

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

    public String getFlowerName() {
        return flowerName;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }
    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    @Override
    public void setFlowerName() {

    }

    @Override
    public void setFlowerColor() {

    }

}
