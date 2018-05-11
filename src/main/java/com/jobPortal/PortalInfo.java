package com.jobPortal;

import com.google.gson.annotations.SerializedName;

public class PortalInfo {
    @SerializedName("title")
    String title;

    @SerializedName("location")
    String location;

    public PortalInfo(String jobtitle, String joblocation ) {
        this.title = jobtitle;
        this.location = joblocation;
    }
}
