//package com.rks.student.studentrecord.entity.studata;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.sql.Timestamp;
//
//import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "state_student_records", schema = "studata")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class StateStudentRecord implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	@EmbeddedId
//	private StateStudentRecordsKey id;
//	@Column(name = "otr_id")
//	private String otrId;
//	@Column(name = "aadhaar_number")
//	private String aadhaarNumber;
//	@Column(name = "academic_allowance_payable")
//	private BigDecimal academicAllowancePayable;
//	@Column(name = "applicant_name")
//	private String applicantName;
//	@Column(name = "attendance_percentage")
//	private Integer lastYearAttendancePercentage;
//	@Column(name = "c_course_master_id")
//	private Integer ccourseMasterId;
//	@Column(name = "central_academic_allowance_payable")
//	private BigDecimal centralAcademicAllowancePayable;
//	@Column(name = "central_disability_allowance_payable")
//	private BigDecimal centralDisabilityAllowancePayable;
//	@Column(name = "central_non_refundable_fee_payable")
//	private BigDecimal centralNonRefundableFeePayable;
//	@Temporal(TemporalType.DATE)
//	@Column(name = "course_commencement_date")
//	private Date courseCommencementDate;
//	@Column(name = "course_group")
//	private Integer courseGroup;
//	@Column(name = "course_level")
//	private Integer courseLevel;
//	@Column(name = "course_name")
//	private String courseName;
//	@Temporal(TemporalType.DATE)
//	@Column(name = "date_of_birth")
//	private Date dateOfBirth;
//	@Column(name = "disability_allowance_payable")
//	private BigDecimal disabilityAllowancePayable;
//	@Column(name = "district_lgd_code")
//	private Integer districtLgdCode;
//	@Column(name = "district_name")
//	private String districtName;
//	@Column(name = "father_name")
//	private String fatherName;
//	@Column(name = "fresh_renewal")
//	private String freshRenewal;
//	@Column(name = "gender")
//	private String gender;
//	@Column(name = "guardian_name")
//	private String guardianName;
//	@Column(name = "hosteller_or_dayscholar")
//	private String hostellerOrDayscholar;
//	@Column(name = "institution_code")
//	private String institutionCode;
//	@Column(name = "institution_district_lgd_code")
//	private Integer institutionDistrictLgdCode;
//	@Column(name = "institution_district_name")
//	private String institutionDistrictName;
//	@Column(name = "institution_name")
//	private String institutionName;
//	@Column(name = "institution_state_lgd_code")
//	private Integer institutionStateLgdCode;
//	@Column(name = "institution_state_name")
//	private String institutionStateName;
//	@Column(name = "is_pwd")
//	private String isPwd;
//	@Column(name = "is_state_share_paid")
//	private String isStateSharePaid;
//	@Column(name = "mobile_number")
//	private String mobileNumber;
//	@Column(name = "mother_name")
//	private String motherName;
//	@Column(name = "non_refundable_fee_payable")
//	private BigDecimal nonRefundableFeePayable;
//	@Column(name = "nsp_application_id")
//	private String nspApplicationId;
//	@Column(name = "state_academic_allowance_paid")
//	private BigDecimal stateAcademicAllowancePaid;
//	@Column(name = "state_disability_allowance_paid")
//	private BigDecimal stateDisabilityAllowancePaid;
//	@Column(name = "state_name")
//	private String stateName;
//	@Column(name = "state_non_refundable_fee_paid")
//	private BigDecimal stateNonRefundableFeePaid;
//	@Column(name = "state_scheme_code")
//	private String stateSchemeCode;
//	@Column(name = "studying_class_year")
//	private Integer studyingClassYear;
//	@Column(name = "top_up_amount")
//	private BigDecimal topUpAmount;
//	@Column(name = "type_of_course")
//	private Integer typeOfCourse;
//	@Column(name = "type_of_institution_code")
//	private String typeOfInstitutionCode;
//	@Column(name = "guardian_income")
//	private BigDecimal guardianIncome;
//	@Column(name = "guardian_occupation")
//	private String guardianOccupation;
//	@Column(name = "created_time", insertable = false, updatable = false)
//	private Timestamp createdTime;
//	@Column(name = "aadhaar_vault_ref_token")
//	private String aadhaarVaultRefToken;
//	@Column(name = "aadhaar_token_ref")
//	private String aadhaarTokenRef;
//	@Column(name = "aadhaar_authentication_method")
//	private Integer aadhaarAuthenticationMethod;
//	@Column(name = "aadhaar_registration_mode")
//	private String aadhaarRegistrationMode;
//	@Column(name = "transaction_id")
//	private String transactionId;
//	@Column(name = "demo_auth")
//	private String demoAuth;
//	@Column(name = "aadhaar_seeding_status")
//	private String aadhaarSeedingStatus;
//	@Column(name = "caste")
//	private String caste;
//	@Column(name = "applicant_address")
//	private String applicantAddress;
//	@Column(name = "applicant_city_name")
//	private String applicantCityName;
//	@Column(name = "applicant_address_pincode")
//	private Integer applicantAddressPincode;
//	@Column(name = "applicant_email_id")
//	private String applicantEmailId;
//	@Column(name = "is_orphan")
//	private String isOrphan;
//	@Column(name = "hoi_name")
//	private String hoiName;
//	@Column(name = "hoi_designation")
//	private String hoiDesignation;
//	@Column(name = "hoi_mobile_number")
//	private String hoiMobileNumber;
//	@Column(name = "hoi_email_id")
//	private String hoiEmailId;
//	@Column(name = "institute_nodal_officer_name")
//	private String instituteNodalOfficerName;
//	@Column(name = "institute_nodal_officer_designation")
//	private String instituteNodalOfficerDesignation;
//	@Column(name = "institute_nodal_officer_mobile_number")
//	private String instituteNodalOfficerMobileNumber;
//	@Column(name = "institute_nodal_officer_email_id")
//	private String instituteNodalOfficerEmailId;
//	@Column(name = "institution_type")
//	private String institutionType;
//	@Column(name = "address_of_institute")
//	private String addressOfInstitute;
//	@Column(name = "block_lgd_code_of_institute")
//	private Integer blockLgdCodeOfInstitute;
//	@Column(name = "pin_code_of_institute")
//	private Integer pinCodeOfInstitute;
//	@Column(name = "course_total_duration")
//	private Integer courseTotalDurationInYears;
//	@Column(name = "attendance_method")
//	private String attendanceMethod;
//	@Column(name = "previous_course_completed")
//	private String previousCourseCompleted;
//	@Column(name = "previous_course_passing_percentage")
//	private Integer previousCoursePassingPercentage;
//	@Column(name = "last_year_result")
//	private String lastYearResult;
//	@Column(name = "geo_tagging_of_institute")
//	private String geoTaggingOfInstitute;
//	@Column(name = "aadhar_based_ekyc_of_ino")
//	private String aadharBasedEkycOfIno;
//	@Column(name = "aadhar_based_ekyc_of_hoi")
//	private String aadharBasedEkycOfHoi;
//	@Column(name = "aadhar_based_ekyc_of_dno_or_sno")
//	private String aadharBasedEkycOfDnoOrSno;
//	@Column(name = "aadhar_based_ekyc")
//	private String aadharBasedEkyc;
//	@Column(name = "parents_legal_guardian_aadhar_number")
//	private String parentsLegalGuardianAadharNumber;
//	@Column(name = "aadhar_belongs_to")
//	private String aadharBelongsTo;
//	@Column(name = "relationship_of_parents_guardians_validate")
//	private String relationshipOfParentsGuardiansValidate;
//	@Column(name = "management_quota")
//	private String managementQuota;
//	@Column(name = "previous_course_passing_year")
//	private String previousCoursePassingYear;
//	@Column(name = "dedup_check_status")
//	private String deDupCheckStatus;
//	@Column(name = "dedup_request_id")
//	private String deDupRequestId;
//
//}
