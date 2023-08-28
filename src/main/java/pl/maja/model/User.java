package pl.maja.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @JoinColumn(unique = true)
    private String nickName;
    private String email;
    private int age;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MountainPeak> mountainPeakList;

    public User() {
        mountainPeakList = new ArrayList<>();
    }

    public User(String nickName, String email, int age) {
        this.nickName = nickName;
        this.email = email;
        this.age = age;
        mountainPeakList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MountainPeak> getMountainPeakList() {
        return mountainPeakList;
    }

    public void setMountainPeakList(List<MountainPeak> mountainPeakList) {
        this.mountainPeakList = mountainPeakList;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", mountainPeakList=" + mountainPeakList +
                '}';
    }
}
