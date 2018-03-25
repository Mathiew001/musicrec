package com.imooc.demo.entity;

import java.util.Date;

public class MusicRec {
    private Integer id;
    private String musicName;
    private String musicAuthor;
    private String musicSrc;
    private String posterSrc;
    private String musicComment;
    private Integer likeNumber;
    private Date sharedTime;
    private String userId;

    public MusicRec() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public String getMusicSrc() {
        return musicSrc;
    }

    public void setMusicSrc(String musicSrc) {
        this.musicSrc = musicSrc;
    }

    public String getPosterSrc() {
        return posterSrc;
    }

    public void setPosterSrc(String posterSrc) {
        this.posterSrc = posterSrc;
    }

    public String getMusicComment() {
        return musicComment;
    }

    public void setMusicComment(String musicComment) {
        this.musicComment = musicComment;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Date getSharedTime() {
        return sharedTime;
    }

    public void setSharedTime(Date sharedTime) {
        this.sharedTime = sharedTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
