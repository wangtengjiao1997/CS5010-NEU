package singleton;

public class OuterPage {
    private Page p;
    private Counter c;

    public OuterPage(Page p) {
        this.p = p;
        //c = new Counter();
        c = Counter.getGlobalCounter();
    }

    public OuterPage() {
        this.p = new Page();
        c = Counter.getGlobalCounter();
    }
}
