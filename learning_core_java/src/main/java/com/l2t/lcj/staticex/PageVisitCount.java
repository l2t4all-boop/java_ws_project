package com.l2t.lcj.staticex;

class WebPage{

    private String title;
    private String content;
    private static int count = 0;

    public WebPage(String title, String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("Creating webpage: ").append(title);
        System.out.println(sb.toString());
        this.title = title;
        this.content = content;
        count++;
    }
    public void showDetails(){
        System.out.println("Title :"+title);
        System.out.println("Content :"+content);
    }
    public static void showCount(){
        System.out.println("Count :"+count);
    }

}
public class PageVisitCount {

    public static void main(String[] args) {
        WebPage.showCount();
        WebPage page1 = new WebPage("Home","Home Content");
        WebPage page2 = new WebPage("About","About Us Content");
        WebPage page3 = new WebPage("Services","Our Services Content");
        WebPage page4 = new WebPage("Contact","Contact Information Content");
        WebPage page5 = new WebPage("Blog","Latest Blog Posts Content");
        WebPage.showCount();
        WebPage page6 = new WebPage("Home","Home Content");
        WebPage page7 = new WebPage("Home","Home Content");
        WebPage page8 = new WebPage("Contact","Contact Information Content");
        WebPage.showCount();

    }

}
