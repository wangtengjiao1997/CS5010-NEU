package decorator;

public class BorderDecorator implements Window {
    private Window innerWindow;

    public BorderDecorator(Window w) {
        innerWindow = w;
    }

    @Override
    public void draw() {
        innerWindow.draw();
        System.out.println("drawing a border");
    }
}
