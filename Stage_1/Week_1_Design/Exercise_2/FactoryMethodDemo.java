public class FactoryMethodDemo {

    public interface File {
        void display();
    }

    public static class TextFile implements File {
        @Override
        public void display() {
            System.out.println("Displaying a Text file.");
        }
    }

    public static class ImageFile implements File {
        @Override
        public void display() {
            System.out.println("Displaying an Image file.");
        }
    }

    public static class VideoFile implements File {
        @Override
        public void display() {
            System.out.println("Displaying a Video file.");
        }
    }

    public static abstract class FileFactory {
        public abstract File createFile();
    }

    public static class TextFileFactory extends FileFactory {
        @Override
        public File createFile() {
            return new TextFile();
        }
    }

    public static class ImageFileFactory extends FileFactory {
        @Override
        public File createFile() {
            return new ImageFile();
        }
    }

    public static class VideoFileFactory extends FileFactory {
        @Override
        public File createFile() {
            return new VideoFile();
        }
    }

    public static void main(String[] args) {
        FileFactory textFactory = new TextFileFactory();
        FileFactory imageFactory = new ImageFileFactory();
        FileFactory videoFactory = new VideoFileFactory();

        File textFile = textFactory.createFile();
        File imageFile = imageFactory.createFile();
        File videoFile = videoFactory.createFile();

        textFile.display();
        imageFile.display();
        videoFile.display();
    }
}
