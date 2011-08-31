package fr.soat.hibernate.sample;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "APPLICATION")
@IdClass(Application.class)
public class Application implements Serializable {

    public Application(){}

    long applicationId;
    String name;

    @Id
    @Column(name = "APPLICATION_ID")
    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long id) {
        this.applicationId = id;
    }

    public void setName(String name){
        this.name = name;
    }

    @Column(name = "APPLICATION_NAME", nullable = false)
    public String getName(){
        return this.name;
    }
}
