package com.nuriddin.myCinemaRoom.projection;

// TODO: 30.03.2022  
public interface AnnouncementView {

    Long getAnnouncementId();

    String getName();

    String getTitle();

    String getPosterImgId();

    String getDescription();
    String getDuration();
    String getGenre();
    String getAgeRate();
    String getYear();
    String getTrailerLink();
    String getCreatedAt();
    String getStatus();

}
