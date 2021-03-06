//Vanessa Metayani_1872044//
package com.vanessa.entity;

public class tableinfo {

    private String nameInput;
    private int priceInput;
    private String categoryInput;

    public String getNameInput(){
        return nameInput;
    }

    public void setNameInput(String nameInput){
        this.nameInput = nameInput;
    }

    public String getCategoryInput(String trim) {
        return categoryInput;
    }

    public void setCategoryInput(String categoryInput) {
        this.categoryInput = categoryInput;
    }

    public int getPriceInput(String trim) {
        return priceInput;
    }

    public void setPriceInput(String priceInput) {
        this.priceInput = priceInput;
    }

    @Override
    public String toString() {
        return nameInput + "-" + priceInput + "-" + categoryInput;
    }
}
