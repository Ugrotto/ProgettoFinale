package it.epicode.beservice.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import it.epicode.beservice.security.StringAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ragionesociale", unique = true, nullable = false)
	private String ragioneSociale;

	@Column(name = "partitaiva", unique = true, nullable = false)
	private String partitaIva;

	@Column(name = "tipocliente")
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;

	@Email
	@Convert(converter = StringAttributeConverter.class)
	@Column(unique = true, nullable = false)
	private String email;
	@Email
	@Convert(converter = StringAttributeConverter.class)
	@Column(unique = true, nullable = false)
	private String pec;

	private String telefono;

	@Column(name = "nomecontatto")
	private String nomeContatto;

	@Column(name = "cognomecontatto")
	private String cognomeContatto;

	@Column(name = "telefonocontatto")
	private String telefonoContatto;

	@Column(name = "emailcontatto")
	@Email
	@Convert(converter = StringAttributeConverter.class)
	private String emailContatto;

	@OneToOne
	private Indirizzo indirizzosedeoperativa;

	@OneToOne
	private Indirizzo indirizzosedelegale;

	@Column(name = "datainserimento")
	private LocalDate dataInserimento;

	@Column(name = "dataultimocontatto")
	private LocalDate dataUltimoContatto;

	@Column(name = "fatturatoannuale")
	private Double fatturatoAnnuale;

	@OneToMany
	private List<Fattura> fatture;

}
