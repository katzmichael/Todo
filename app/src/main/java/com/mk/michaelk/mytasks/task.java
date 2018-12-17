package com.mk.michaelk.mytasks;

public class task {
    private String category,title,free;
    public task(String category, String title, String free) {
        this.category = category;
        this.title = title;
        this.free = free;
    }
    public task(){
        this.category = "";
        this.title = "";
        this.free = "";

    }

   // String category;
   // String title;
    //String free;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }



}
