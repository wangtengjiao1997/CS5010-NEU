package decorator;
public class BasicWindow implements Window {
    public void draw() {
        System.out.println("drawing a basic window");
    }

    public static void main(String[] args) {
        // BasicWindow w = new BasicWindow();
        // decorator.WindowWithSlideBar w = new decorator.WindowWithSlideBar();
        //decorator.WindowWithBorder w = new decorator.WindowWithBorder();
        //w.draw();
        Window w = new BasicWindow();
        // window only with border
        Window w2 = new BorderDecorator(w);
        //w2.draw();
        Window w3 = new SlideBarDecorator(w2);
        w3.draw();
    }
}
