package decorator;

public class WindowWithBorder extends BasicWindow {
    @Override
    public void draw() {
        super.draw();
        System.out.println("drawing border");
    }
}
