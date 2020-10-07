package com.petz.entities;

import com.petz.constant.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "document")
@NoArgsConstructor
@AllArgsConstructor
public class Document {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "number")
	private String number;
	
	@Enumerated(EnumType.STRING)
	private DocumentType type;

	public Document(Long id) {
		this.id = id;
	}
}
