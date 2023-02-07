package decorator;

public class SlideBarDecorator implements Window {
    private Window innerWindow;

    public SlideBarDecorator(Window w) {
        innerWindow = w;
    }

    @Override
    public void draw() {
        innerWindow.draw();
        System.out.println("drawing a slide bar");
    }
}
