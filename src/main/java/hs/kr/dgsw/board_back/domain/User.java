package hs.kr.dgsw.board_back.domain;

public class User {

    private String id;
    private String password;
    private String username;
    private Integer age;
    private String gender;
    private Long profileImage;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Long profileImage) {
        this.profileImage = profileImage;
    }
}
