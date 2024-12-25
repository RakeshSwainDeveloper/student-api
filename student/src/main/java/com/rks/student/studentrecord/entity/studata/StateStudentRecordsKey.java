//package com.rks.student.studentrecord.entity.studata;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Embeddable
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class StateStudentRecordsKey implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	@Column(name = "state_application_id")
//	private String stateApplicationId;
//	@Column(name = "nsp_scheme_code")
//	private Integer nspSchemeCode;
//	@Column(name = "state_lgd_code")
//	private Integer stateLgdCode;
//	@Column(name = "academic_year")
//	private String academicYear;
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//		StateStudentRecordsKey that = (StateStudentRecordsKey) o;
//		return Objects.equals(stateApplicationId, that.stateApplicationId)
//				&& Objects.equals(nspSchemeCode, that.nspSchemeCode) && Objects.equals(stateLgdCode, that.stateLgdCode)
//				&& Objects.equals(academicYear, that.academicYear);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(stateApplicationId, nspSchemeCode, stateLgdCode, academicYear);
//	}
//
//}
