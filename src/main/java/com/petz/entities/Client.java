package com.petz.entities;

import com.petz.dto.AddressDto;
import com.petz.dto.DocumentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Client  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "name")
	private String name;

	@NotNull
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;

	@NotNull
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Document> documents;

	public Client(Long id) {
		this.id = id;
	}

}
