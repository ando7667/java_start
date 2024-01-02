package JavaJunior.lectors.Lectors.src.main.java.org.ignatov;

import javax.persistence.*;

@Entity
@Table(name = "test1.magic")
public class Magic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmagic;
    @Column(name = "название")
    private String name;
    @Column(name = "повреждение")
    private int damage;
    @Column(name = "атака")
    private int attBonus;

    public Magic(int idmagic, String name, int damage, int attBonus) {
        this.idmagic = idmagic;
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
    }
}
