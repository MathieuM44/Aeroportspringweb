package AeroportSpring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "Reser_seq_id", initialValue = 1000, allocationSize = 1)

public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name = "id_reservation")
	private Long id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "date_reservation", length = 400, nullable = false)
	private Date date;
	@Column(name = "numero_reservation", length = 400, nullable = false)
	private Integer numero;

	@Version
	@Column(name = "version_reservation")
	private int version;

	// Association

	@ManyToOne
	@JoinColumn(name = "id_passager")
	private Passager passager;

	@ManyToOne
	@JoinColumn(name = "reservation_vol")
	private Vol vol;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;




	public Reservation(Date date, Integer numero) {
		super();

		this.date = date;
		this.numero = numero;

	}
	
	

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Reservation() {

	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Client getClient() {
		return client;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
}
