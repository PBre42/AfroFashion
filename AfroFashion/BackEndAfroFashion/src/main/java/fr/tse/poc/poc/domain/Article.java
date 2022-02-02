package fr.tse.poc.poc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Article")
public class Article {
	@Id
	private Long id;
	@Column(name = "libelle", nullable = false)
	private String libelle;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "image", nullable = false)
	private String image;
	@Column(name = "prix", nullable = false)
	private Double prix;
}
