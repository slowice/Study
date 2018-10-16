package xb.mall.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Menu {
    private String name;
    private String link;
    @Id
    private String id;

    private String pid;
}
