package com.example.quizus;

public class categoryModel {
    private String categpryId, categoryName, cateogoryImage;

    public categoryModel(String categpryId, String categoryName, String cateogoryImage) {
        this.categpryId = categpryId;
        this.categoryName = categoryName;
        this.cateogoryImage = cateogoryImage;
    }

    public categoryModel(){}

    public String getCategpryId() {
        return categpryId;
    }

    public void setCategpryId(String categpryId) {
        this.categpryId = categpryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCateogoryImage() {
        return cateogoryImage;
    }

    public void setCateogoryImage(String cateogoryImage) {
        this.cateogoryImage = cateogoryImage;
    }
}
