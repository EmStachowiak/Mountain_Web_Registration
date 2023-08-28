package pl.maja.model;

import jakarta.persistence.*;

@Entity
public class MountainPeak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int height;
    private int verticalGain;
    private float distance;

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    private User user;

    public MountainPeak() {
    }

    public MountainPeak(String mountainPeak, int height, int verticalGain, float distance) {
        this.name = mountainPeak;
        this.height = height;
        this.verticalGain = verticalGain;
        this.distance = distance;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVerticalGain() {
        return verticalGain;
    }

    public void setVerticalGain(int verticalGain) {
        this.verticalGain = verticalGain;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MountainPeak{" +
                "id=" + id +
                ", mountainPeak='" + name + '\'' +
                ", height=" + height +
                ", verticalGain=" + verticalGain +
                ", distance=" + distance +
                '}';
    }
}
