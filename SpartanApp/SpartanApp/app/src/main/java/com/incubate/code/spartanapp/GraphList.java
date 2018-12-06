//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

/**
 * Created by one on 20/8/16.
 */
public class GraphList {

    private String title;
    private String value;
    private String colorCode;

    public GraphList(String title, String value, String colorCode) {
        this.title = title;
        this.value = value;
        this.colorCode = colorCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
