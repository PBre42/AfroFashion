package fr.tse.poc.poc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reponse")
public class Reponse {

	@Id
	private Long id;
	@Column(name = "is_true", nullable = false)
	private boolean isTrue;
	@Column(name = "video_reponse", nullable = false)
	private String videoReponse;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "etape_reponse_FID")
	private Etape etape;
}
