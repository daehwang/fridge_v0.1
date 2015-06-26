package org.dedeplz.fridge.model.member;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
//MemberVO [id=java, password=1234, nick=abcd, name=한지민,
//email=java@gmail.com, gender=0, answer=파스타, level=5, registerDate=null, love=0]
public class MemberVO {
	@Size(min=4,max=10)
   private String id;
	@Size(min=4,max=10)
   private String password;
	@NotEmpty
   private String nick;
	@NotEmpty
   private String name;
	@Email
	@NotEmpty
   private String email;
	@Min(1)
   private int gender;
   @NotEmpty
   private String answer;
   private int level;
   private String registerDate;
   private int love;
   public MemberVO() {
      super();
      // TODO Auto-generated constructor stub
   }
   public MemberVO(String id, String password, String nick, String name,
         String email, int gender, String answer, int level,
         String registerDate, int love) {
      super();
      this.id = id;
      this.password = password;
      this.nick = nick;
      this.name = name;
      this.email = email;
      this.gender = gender;
      this.answer = answer;
      this.level = level;
      this.registerDate = registerDate;
      this.love = love;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getNick() {
      return nick;
   }
   public void setNick(String nick) {
      this.nick = nick;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public int getGender() {
      return gender;
   }
   public void setGender(int gender) {
      this.gender = gender;
   }
   public String getAnswer() {
      return answer;
   }
   public void setAnswer(String answer) {
      this.answer = answer;
   }
   public int getLevel() {
      return level;
   }
   public void setLevel(int level) {
      this.level = level;
   }
   public String getRegisterDate() {
      return registerDate;
   }
   public void setRegisterDate(String registerDate) {
      this.registerDate = registerDate;
   }
   public int getLove() {
      return love;
   }
   public void setLove(int love) {
      this.love = love;
   }
   @Override
   public String toString() {
      return "MemberVO [id=" + id + ", password=" + password + ", nick="
            + nick + ", name=" + name + ", email=" + email + ", gender="
            + gender + ", answer=" + answer + ", level=" + level
            + ", registerDate=" + registerDate + ", love=" + love + "]";
   }
}