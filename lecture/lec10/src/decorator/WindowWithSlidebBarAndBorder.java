package decorator;

public class WindowWithSlidebBarAndBorder extends WindowWithBorder {
    @Override
    public void draw() {
        super.draw();
        System.out.println("drawing a slide bar");
    }
}
