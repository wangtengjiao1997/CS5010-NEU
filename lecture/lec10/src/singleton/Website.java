package singleton;

public class Website {
    public static void main(String[] args) {
        Page[] pages = new Page[4];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = new Page();
        }
        OuterPage[] outerPages = new OuterPage[3];
        for (int i = 0; i < outerPages.length; i++) {
            if (i == 0 || i == 1) {
                outerPages[i] = new OuterPage(pages[2]);
            } else {
                outerPages[i] = new OuterPage();
            }
        }

        pages[0].click();
        pages[3].click();
        pages[0].click();
        pages[1].click();


//        int total = 0;
//        for (int i = 0; i < pages.length; i++) {
//            total += pages[i].getCounter().getVal();
//        }
//        System.out.println(total);


        System.out.println(Counter.getGlobalCounter().getVal());
    }
}
