package blood.bank.infra.persistence.models;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "insignia")
public class BadgeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "insignia_id_seq")
    @SequenceGenerator(name = "insignia_id_seq", sequenceName = "insignia_id_seq", allocationSize = 1)
    @Column(name = "id_insigna")
    private Long id;

    @Column(name = "nome_insigna")
    private String badgeName;

    @Column(name = "imagem")
    private String image;

    @Column(name = "pontos_necessarios")
    private Integer necessaryPoints;

    @Column(name = "data_conquista")
    private LocalDate dateOfAchievement;

    public BadgeEntity() {
    }

    public BadgeEntity(String badgeName, String image, Integer necessaryPoints, LocalDate dateOfAchievement) {
        this.badgeName = badgeName;
        this.image = image;
        this.necessaryPoints = necessaryPoints;
        this.dateOfAchievement = dateOfAchievement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNecessaryPoints() {
        return necessaryPoints;
    }

    public void setNecessaryPoints(Integer necessaryPoints) {
        this.necessaryPoints = necessaryPoints;
    }

    public LocalDate getDateOfAchievement() {
        return dateOfAchievement;
    }

    public void setDateOfAchievement(LocalDate dateOfAchievement) {
        this.dateOfAchievement = dateOfAchievement;
    }
}
