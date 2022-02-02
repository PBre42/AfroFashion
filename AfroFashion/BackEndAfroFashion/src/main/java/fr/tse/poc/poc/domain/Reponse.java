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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Boolean isTrue;
	@Column(name = "video_reponse", nullable = false)
	private String videoReponse;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "etape_reponse_FID")
	@JsonIgnore
	private Etape etape;
}
