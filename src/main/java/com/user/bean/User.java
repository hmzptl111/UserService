package com.user.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "contact" }) })
public class User {
	@Id
	private String email;
	private String name;
	private long contact;
}