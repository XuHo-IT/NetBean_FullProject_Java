/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author HELLO
 */
public class Article {

  private int id;
  private String title;
  private String imgLink;
  private String content;
  private String fullContent;

  public Article() {
    // This constructor is empty, but could be used to initialize default values
  }

  public Article(int id, String title, String imgLink, String content, String fullContent) {
    this.id = id;
    this.title = title;
    this.imgLink = imgLink;
    this.content = content;
    this.fullContent = fullContent;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImgLink() {
    return imgLink;
  }

  public void setImgLink(String imgLink) {
    this.imgLink = imgLink;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getFullContent() {
    return fullContent;
  }

  public void setFullContent(String fullContent) {
    this.fullContent = fullContent;
  }
}
