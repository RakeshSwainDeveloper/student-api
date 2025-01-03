package com.rks.student.studentcentraldb.entity.core;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_entity", schema = "core")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_entity_seq")
	@SequenceGenerator(name = "user_entity_seq", sequenceName = "core.user_entity_serial_no_seq", allocationSize = 1)
	@Column(name = "uset_id")
	private Integer userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_mobile_nu")
	private String mobileNumer;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "agency_id")
	private String agencyId;

	@Column(name = "role")
	private String role;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "created_time")
	private Timestamp createTime;

	@Column(name = "block_status",insertable = false)
	private String blockStatus;

	@Column(name = "block_time",insertable = false)
	private Timestamp blockTime;

}
