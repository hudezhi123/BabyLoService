package com.hdz.babyloservice.bean;

import java.util.List;

public class Animal {

    public Animal() {}

    public Animal(final String name, final String desc, final String enName, final List<String> imgList) {
        this.name = name;
        this.desc = desc;
        this.enName = enName;
        this.imgList = imgList;
    }

    private String name;
    private String desc;
    private String enName;
    List<String> imgList;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }

    public String getEnName() {
        return this.enName;
    }

    public void setEnName(final String enName) {
        this.enName = enName;
    }

    public List<String> getImgList() {
        return this.imgList;
    }

    public void setImgList(final List<String> imgList) {
        this.imgList = imgList;
    }
}
