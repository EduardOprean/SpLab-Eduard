package models;

public class RealImage extends Image {
    public RealImage(String imageName) {
        super(imageName);
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk");
    }
}
