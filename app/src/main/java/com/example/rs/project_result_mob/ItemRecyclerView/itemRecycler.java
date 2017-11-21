package com.example.rs.project_result_mob.ItemRecyclerView;

/**
 * Created by rs on 11/13/2017.
 */

public class itemRecycler {

    String name;
    String etc;
    int imageIdAvatar;

    public itemRecycler(String name, String etc, int imageIdAvatar) {
        this.name = name;
        this.etc = etc;
        this.imageIdAvatar = imageIdAvatar;
    }

    public itemRecycler() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public int getImageIdAvatar() {
        return imageIdAvatar;
    }

    public void setImageIdAvatar(int imageIdAvatar) {
        this.imageIdAvatar = imageIdAvatar;
    }
}
