package com.example.bootjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Alien{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  /* NotBlank= 空白、nullを弾くバリデーション Size=文字数,Collection要素の数を制限*/
  @NotBlank(message="名前を入力してください")
  @Size(min=4,max=20, message="適切な名前を入力してください")
  private String name;
  
  @NotBlank(message="名前を入力してください")
  @Size(min=10, max=30,message="適切な名前を入力してください")
  private String email;

  public Integer getId(){
    return id;
  }
  public void setId(Integer id){
    this.id = id;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name= name;
  }
  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email= email;
  }

}



