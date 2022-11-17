package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.esprit.examen.dto.FournisseurDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFournisseur;
	private String code;
	private String libelle;
	@Enumerated(EnumType.STRING)
	private CategorieFournisseur  categorieFournisseur;
	@OneToMany(mappedBy="fournisseur")
	@JsonIgnore
	private Set<Facture> factures;
    @ManyToMany
    @JsonIgnore
    private Set<SecteurActivite> secteurActivites;
    @OneToOne(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private DetailFournisseur detailFournisseur;

	public Fournisseur(FournisseurDto fdto) {
		this.code=fdto.getCode();
		this.libelle= fdto.getLibelle();
	}

    public Fournisseur(long l, String s, String test, Object o) {
    }

    @Override
	public String toString() {
		return "Fournisseur{" +
				"idFournisseur=" + idFournisseur +
				", code='" + code + '\'' +
				", libelle='" + libelle + '\'' +
				", categorieFournisseur=" + categorieFournisseur +
				", factures=" + factures +
				", secteurActivites=" + secteurActivites +
				", detailFournisseur=" + detailFournisseur +
				'}';
	}
}
