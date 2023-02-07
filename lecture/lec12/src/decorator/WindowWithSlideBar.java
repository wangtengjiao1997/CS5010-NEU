package decorator;

public class WindowWithSlideBar extends BasicWindow {
    @Override
    public void draw() {
        super.draw();
        System.out.println("drawing a slide bar");
    }
}
