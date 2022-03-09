package ir.maktab.houseservicesspringboot.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Entity
public class Client extends User {
    private Double credit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Comment> comments = new ArrayList<>();
}
