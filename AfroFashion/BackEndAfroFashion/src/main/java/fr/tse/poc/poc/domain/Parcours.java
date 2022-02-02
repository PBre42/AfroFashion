package fr.tse.poc.poc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Parcours")
public class Parcours {
	@Id
	private Long id;

	@Column(name = "nombre_de_vie", nullable = false)
	private Integer nombreDeVie;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "etapeDepart_FID")
	private Etape etapeDepart;

	
}
