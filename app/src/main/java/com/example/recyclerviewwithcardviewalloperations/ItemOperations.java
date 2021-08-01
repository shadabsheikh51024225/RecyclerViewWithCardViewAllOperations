package com.example.recyclerviewwithcardviewalloperations;

public class ItemOperations {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public ItemOperations(int imageResource, String text1, String text2) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }
    //creating a method to change text and calling it in main activity.
    public void changeText1(String text) {
        mText1 = text;
    }
    public int getImageResource() {
        return mImageResource;
    }
    public String getText1() {
        return mText1;
    }
    public String getText2() {
        return mText2;
    }
}
