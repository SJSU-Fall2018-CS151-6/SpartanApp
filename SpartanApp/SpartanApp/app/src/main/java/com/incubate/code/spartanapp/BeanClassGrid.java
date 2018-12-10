//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

/**
 * Created by one on 19/8/16.
 */
public class BeanClassGrid {

    private String title;
    private String subTitle;
    private String colorCode;


    public BeanClassGrid(String title, String subTitle, String colorCode) {
        this.title = title;
        this.subTitle = subTitle;
        this.colorCode = colorCode;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}
