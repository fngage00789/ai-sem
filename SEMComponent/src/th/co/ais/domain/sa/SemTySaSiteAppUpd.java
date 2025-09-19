package th.co.ais.domain.sa;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

import th.co.ais.domain.AbstractDomain;

public class SemTySaSiteAppUpd extends AbstractDomain  {
	
	private String	p_site_app_id	;
	private String	p_contract_id	;
	private BigDecimal	p_contract_time	;
	private BigDecimal	p_contract_time_seq	;
	private String	p_contract_no	;
	private String	p_req_type	;
	private String	p_req_doc_type	;
	private String	p_title	;
	private String	p_req_officer	;
	private String	p_req_officer_manual	;
	private String	p_company	;
	private String	p_region	;
	private String	p_doc_no	;
	private Date	p_doc_dt	;
	private String	p_doc_status	;
	private String	p_need_legal_approve	;
	private String	p_need_avp_approve	;
	private String	p_location_id	;
	private String	p_location_zone	;
	private String	p_is_co_locate	;
	private String	p_co_contract_no	;
	private String	p_terminate_reason	;
	private String	p_terminate_remove_flag	;
	private Date	p_terminate_remove_dt	;
	private String	p_terminate_cancel_relate_data	;
	private String	p_terminate_note	;
	private String	p_location_type	;
	private String	p_location_address_no	;
	private String	p_location_building	;
	private String	p_location_floor	;
	private String	p_location_room_no	;
	private String	p_location_street	;
	private String	p_location_tambon	;
	private String	p_location_amphur_id	;
	private String	p_location_province_id	;
	private String	p_location_postcode	;
	private BigDecimal	p_land_area	;
	private String	p_land_area_type	;
	private BigDecimal	p_deck_area	;
	private String	p_deck_area_type	;
	private BigDecimal	p_building_area	;
	private BigDecimal	p_room_area	;
	private String	p_area_remark	;
	private Date	p_effective_dt	;
	private Date	p_expire_dt	;
	private BigDecimal	p_age_year	;
	private BigDecimal	p_age_month	;
	private BigDecimal	p_age_day	;
	private String	p_contract_wanted	;
	private BigDecimal	p_promise_renew_time	;
	private BigDecimal	p_promise_renew_period	;
	private String	p_promise_renew_period_type	;
	private String	p_lessor_name	;
	private String	p_lessor_house_no	;
	private String	p_lessor_building	;
	private String	p_lessor_floor	;
	private String	p_lessor_room_no	;
	private String	p_lessor_street	;
	private String	p_lessor_tambon	;
	private String	p_lessor_amphur_id	;
	private String	p_lessor_province_id	;
	private String	p_lessor_postcode	;
	private String	p_lessor_tax_id	;
	private String	p_contact_name	;
	private String	p_contact_tel	;
	private String	p_contact_mobile	;
	private String	p_contact_fax	;
	private String	p_contact_email	;
	private BigDecimal	p_rent_amt	;
	private String	p_rent_period_type	;
	private String	p_rent_detail	;
	private String	p_rent_wht_type	;
	private BigDecimal	p_rent_wht_rate	;
	private String	p_rent_wht_rate_mod	;
	private BigDecimal	p_rent_service_amt	;
	private String	p_rent_service_period_type	;
	private String	p_rent_service_detail	;
	private String	p_rent_service_vat_type	;
	private String	p_rent_service_wht_type	;
	private BigDecimal	p_rent_service_wht_rate	;
	private String	p_rent_service_wht_rate_mod	;
	private String	p_rent_area_amt_memo	;
	private String	p_rent_service_amt_memo	;
	private String	p_rent_setup_amt_memo	;
	private String	p_rent_other_amt_memo	;
	private String	p_rent_special_amt_memo	;
	private BigDecimal	p_total_rent_service	;
	private String	p_rent_payment_period	;
	private String	p_rent_payment_period_oth	;
	private String	p_rent_deposit_flag	;
	private BigDecimal	p_rent_deposit_bg_amt	;
	private String	p_rent_deposit_bg_vat	;
	private BigDecimal	p_rent_deposit_cash_amt	;
	private String	p_rent_deposit_cash_vat	;
	private String	p_rent_remark	;
	private String	p_el_use_multi_resourse	;
	private String	p_el_use_new_meter	;
	private String	p_el_use_old_meter	;
	private String	p_el_use_owner	;
	private String	p_el_owner_type	;
	private String	p_el_pay_on_package	;
	private String	p_el_package_period_type	;
	private BigDecimal	p_el_pay_on_package_amt	;
	private String	p_el_pay_on_used	;
	private BigDecimal	p_el_unit_price	;
	private String	p_el_vat_type	;
	private String	p_el_remark	;
	private String	p_el_deposit_flag	;
	private BigDecimal	p_el_bg_deposit	;
	private String	p_el_bg_deposit_vat_type	;
	private BigDecimal	p_el_cash_deposit	;
	private String	p_el_cash_deposit_vat_type	;
	private String	p_el_deposit_remark	;
	private String	p_remark_special	;
	private String	p_remark_documents	;
	private String	p_remark_contract	;
	private String	p_remark_aqm	;
	private String	p_remark_risk	;
	private String	p_remark_legal	;
	private String	p_remark_other	;
	private String	p_pt_tax_pay_type	;
	private String	p_pt_remark	;
	private String	p_ins_flag	;
	private BigDecimal	p_ins_sum_insured	;
	private Date	p_ins_effective_dt	;
	private Date	p_ins_expire_dt	;
	private String	p_ins_beneficiary	;
	private Date	p_assign_dt	;
	private String	p_assign_by	;
	private String	p_assign_to_team	;
	private String	p_assign_to_user	;
	private Date	p_leader_approve_dt	;
	private String	p_leader_approve_by	;
	private String	p_leader_approve_status	;
	private String	p_leader_approve_remark	;
	private Date	p_manager_approve_dt	;
	private String	p_manager_approve_by	;
	private String	p_manager_approve_status	;
	private String	p_manager_approve_remark	;
	private Date	p_legal_approve_dt	;
	private String	p_legal_approve_by	;
	private String	p_legal_approve_status	;
	private String	p_legal_approve_remark	;
	private Date	p_avp_approve_dt	;
	private String	p_avp_approve_by	;
	private String	p_avp_approve_status	;
	private String	p_avp_approve_remark	;
	private String	p_flow_status	;
	private String	p_record_status	;
	private String	p_batch_no	;
	private Date	p_batch_dt	;
	private String	p_location_edit_flag	;
	private String	p_contract_edit_flag	;
	private String	p_rent_edit_flag	;
	private String	p_rent_deposit_edit_flag	;
	private String	p_el_edit_flag	;
	private String	p_el_deposit_edit_flag	;
	private String	p_property_tax_edit_flag	;
	private String	p_insurance_edit_flag	;
	private String	p_mail_edit_flag	;
	private Date	p_create_dt	;
	private String	p_create_by	;
	private Date	p_update_dt	;
	private String	p_update_by	;
	private BigDecimal	p_version	;
	private String	p_place_type	;
	private String	p_parties_type	;
	private String	p_phase	;
	private Date	p_terminate_cancel_contract_dt	;
	private Date	p_terminate_remove_end_dt	;
	private String	p_co_locate_company	;
	private String	p_location_code	;
	private String	p_location_name	;
	private String	p_construction_unneed	;
	private String	p_contract_never_expire	;
	private String	p_contract_wanted_remark	;
	private String	p_tower_type	;
	private String	p_tower_location	;
	private BigDecimal	p_tower_height	;
	private String	p_rent_vat_type	;
	private BigDecimal	p_rent_vat_rate	;
	private BigDecimal	p_rent_service_vat_rate	;
	private String	p_remark_after_approve	;
	private BigDecimal	p_rent_amt_old	;
	private String	p_rent_period_type_old	;
	private BigDecimal	p_rent_amt_add	;
	private BigDecimal	p_rent_amt_add_perc	;
	private BigDecimal	p_rent_serv_amt_old	;
	private String	p_rent_serv_period_type_old	;
	private BigDecimal	p_rent_serv_amt_add	;
	private BigDecimal	p_rent_serv_amt_add_perc	;
	private BigDecimal	p_rent_deposit_bg_amt_old	;
	private BigDecimal	p_rent_deposit_cash_amt_old	;
	private BigDecimal	p_rent_deposit_bg_amt_add	;
	private BigDecimal	p_rent_deposit_cash_amt_add	;
	private BigDecimal	p_revenue	;
	private String	p_rent_area_memo_vat_type	;
	private String	p_rent_area_memo_wht_type	;
	private BigDecimal	p_rent_area_memo_wht_rate	;
	private String	p_rent_serv_memo_vat_type	;
	private String	p_rent_serv_memo_wht_type	;
	private BigDecimal	p_rent_serv_memo_wht_rate	;
	private String	p_rent_setup_memo_vat_type	;
	private String	p_rent_setup_memo_wht_type	;
	private BigDecimal	p_rent_setup_memo_wht_rate	;
	private String	p_rent_other_memo_vat_type	;
	private String	p_rent_other_memo_wht_type	;
	private BigDecimal	p_rent_other_memo_wht_rate	;
	private String	p_is_macro_type	;
	private String	p_is_micro_type	;
	private String	p_is_pico_type	;
	private String	p_is_repeater_type	;
	private String	p_is_tower_type	;
	private String	p_is_wifi_type	;
	private String	p_is_other_type	;
	private String	p_is_other_type_detail	;
	private String	p_contract_no_old	;
	private String	p_is_smallcell_type	;
	private String	p_co_company	;
	private String	p_co_company_contract_no	;
	private String	p_el_use_oth_site	;
	private String	p_el_use_oth_site_contract_no	;
	private String	p_re_locate_contract_no	;
	private String	p_is_fbb_type	;
	private String	p_is_ofc_type	;
	private String	p_is_fttx_type	;
	private Date	p_change_effective_dt	;
	private String	p_service_payment_period	;
	private String	p_service_payment_period_oth	;
	private BigDecimal	p_el_deposit_bg_amt_old	;
	private BigDecimal	p_el_deposit_cash_amt_old	;
	private BigDecimal	p_el_deposit_bg_amt_add	;
	private BigDecimal	p_el_deposit_cash_amt_add	;
	private String	p_el_no_expenses	;
	private String	p_no_rental	;
	private String	p_save_flag	;
	private String	p_legal_vat_type	;
	private String	p_co_operator	;
	private String	p_leasehold_rights	;
	private String	p_license	;
	private String	p_ll_rental_agreement	;
	private String	p_sa_site_type	;
	private String	p_deck_area_unit_type	;
	private String	p_deck_area_width	;
	private String	p_deck_area_long	;
	private String	p_deck_area_other	;
	private String	p_building_area_type	;
	private String	p_building_area_unit_type	;
	private String	p_building_area_width	;
	private String	p_building_area_long	;
	private String	p_building_area_other	;
	private String	p_room_area_type	;
	private String	p_room_area_unit_type	;
	private String	p_room_area_width	;
	private String	p_room_area_long	;
	private String	p_room_area_other	;
	private String	p_land_area_unit_type	;
	private String	p_land_area_width	;
	private String	p_land_area_long	;
	private String	p_land_area_other	;
	private String	p_place_type_other	;
	private String	p_doc_type_other	;
	private String	p_doc_location_address_no	;
	private String	p_doc_location_building	;
	private String	p_doc_location_floor	;
	private String	p_doc_location_street	;
	private String	p_doc_location_tambon	;
	private String	p_doc_location_amphur_id	;
	private String	p_doc_location_province_id	;
	private String	p_doc_location_postcode	;
	private Date	p_ch_effect_dt_contract	;
	private String	p_lessor_title_name	;
	private Date	p_lessor_birthday	;
	private String	p_contract_title_name	;
	private String	p_contract_id_card	;
	private Date	p_contract_birthday	;
	private String	p_contract_address_no	;
	private String	p_contract_building	;
	private String	p_contract_floor	;
	private String	p_contract_room_no	;
	private String	p_contract_street	;
	private String	p_contract_tambon	;
	private String	p_contract_amphur_id	;
	private String	p_contract_province_id	;
	private String	p_contract_postcode	;
	private String	p_owner_title_name	;
	private String	p_doc_type	;
	private String	p_el_use_other	;
	private String	p_lessor_tel	;
	private String	p_lessor_mobile	;
	private String	p_lessor_fax	;
	private String	p_lessor_email	;
	private String	p_no_deposit_rent	;
	private String	p_no_deposit_elec	;
	private String	p_owner_name	;
	private String	p_owner_category	;
	private String	p_station_type	;
	private String	p_owner_sub_category	;
	private String	p_emer_contact_name	;
	private String	p_emer_contact_phone	;
	private String	p_renew_rent_flag	;
	private String	p_renew_rent_percent	;
	private String	p_promise_renew_remark	;
	
	
	private String jsonData;

	
//	private Integer id;
//	private String name;
//	private java.sql.Date create_date;
//	private BigDecimal salary;
 //private String typeName1 = "SEM_TY_TEST";
	
	
	public SemTySaSiteAppUpd() {
	
	}


	public String getP_site_app_id() {
		return p_site_app_id;
	}



	public void setP_site_app_id(String p_site_app_id) {
		this.p_site_app_id = p_site_app_id;
	}



	public String getP_contract_id() {
		return p_contract_id;
	}



	public void setP_contract_id(String p_contract_id) {
		this.p_contract_id = p_contract_id;
	}



	public BigDecimal getP_contract_time() {
		return p_contract_time;
	}



	public void setP_contract_time(BigDecimal p_contract_time) {
		this.p_contract_time = p_contract_time;
	}



	public BigDecimal getP_contract_time_seq() {
		return p_contract_time_seq;
	}



	public void setP_contract_time_seq(BigDecimal p_contract_time_seq) {
		this.p_contract_time_seq = p_contract_time_seq;
	}



	public String getP_contract_no() {
		return p_contract_no;
	}



	public void setP_contract_no(String p_contract_no) {
		this.p_contract_no = p_contract_no;
	}



	public String getP_req_type() {
		return p_req_type;
	}



	public void setP_req_type(String p_req_type) {
		this.p_req_type = p_req_type;
	}



	public String getP_req_doc_type() {
		return p_req_doc_type;
	}



	public void setP_req_doc_type(String p_req_doc_type) {
		this.p_req_doc_type = p_req_doc_type;
	}



	public String getP_title() {
		return p_title;
	}



	public void setP_title(String p_title) {
		this.p_title = p_title;
	}



	public String getP_req_officer() {
		return p_req_officer;
	}



	public void setP_req_officer(String p_req_officer) {
		this.p_req_officer = p_req_officer;
	}



	public String getP_req_officer_manual() {
		return p_req_officer_manual;
	}



	public void setP_req_officer_manual(String p_req_officer_manual) {
		this.p_req_officer_manual = p_req_officer_manual;
	}



	public String getP_company() {
		return p_company;
	}



	public void setP_company(String p_company) {
		this.p_company = p_company;
	}



	public String getP_region() {
		return p_region;
	}



	public void setP_region(String p_region) {
		this.p_region = p_region;
	}



	public String getP_doc_no() {
		return p_doc_no;
	}



	public void setP_doc_no(String p_doc_no) {
		this.p_doc_no = p_doc_no;
	}



	public Date getP_doc_dt() {
		return p_doc_dt;
	}



	public void setP_doc_dt(Date p_doc_dt) {
		this.p_doc_dt = p_doc_dt;
	}



	public String getP_doc_status() {
		return p_doc_status;
	}



	public void setP_doc_status(String p_doc_status) {
		this.p_doc_status = p_doc_status;
	}



	public String getP_need_legal_approve() {
		return p_need_legal_approve;
	}



	public void setP_need_legal_approve(String p_need_legal_approve) {
		this.p_need_legal_approve = p_need_legal_approve;
	}



	public String getP_need_avp_approve() {
		return p_need_avp_approve;
	}



	public void setP_need_avp_approve(String p_need_avp_approve) {
		this.p_need_avp_approve = p_need_avp_approve;
	}



	public String getP_location_id() {
		return p_location_id;
	}



	public void setP_location_id(String p_location_id) {
		this.p_location_id = p_location_id;
	}



	public String getP_location_zone() {
		return p_location_zone;
	}



	public void setP_location_zone(String p_location_zone) {
		this.p_location_zone = p_location_zone;
	}



	public String getP_is_co_locate() {
		return p_is_co_locate;
	}



	public void setP_is_co_locate(String p_is_co_locate) {
		this.p_is_co_locate = p_is_co_locate;
	}



	public String getP_co_contract_no() {
		return p_co_contract_no;
	}



	public void setP_co_contract_no(String p_co_contract_no) {
		this.p_co_contract_no = p_co_contract_no;
	}



	public String getP_terminate_reason() {
		return p_terminate_reason;
	}



	public void setP_terminate_reason(String p_terminate_reason) {
		this.p_terminate_reason = p_terminate_reason;
	}



	public String getP_terminate_remove_flag() {
		return p_terminate_remove_flag;
	}



	public void setP_terminate_remove_flag(String p_terminate_remove_flag) {
		this.p_terminate_remove_flag = p_terminate_remove_flag;
	}



	public Date getP_terminate_remove_dt() {
		return p_terminate_remove_dt;
	}



	public void setP_terminate_remove_dt(Date p_terminate_remove_dt) {
		this.p_terminate_remove_dt = p_terminate_remove_dt;
	}



	public String getP_terminate_cancel_relate_data() {
		return p_terminate_cancel_relate_data;
	}



	public void setP_terminate_cancel_relate_data(String p_terminate_cancel_relate_data) {
		this.p_terminate_cancel_relate_data = p_terminate_cancel_relate_data;
	}



	public String getP_terminate_note() {
		return p_terminate_note;
	}



	public void setP_terminate_note(String p_terminate_note) {
		this.p_terminate_note = p_terminate_note;
	}



	public String getP_location_type() {
		return p_location_type;
	}



	public void setP_location_type(String p_location_type) {
		this.p_location_type = p_location_type;
	}



	public String getP_location_address_no() {
		return p_location_address_no;
	}



	public void setP_location_address_no(String p_location_address_no) {
		this.p_location_address_no = p_location_address_no;
	}



	public String getP_location_building() {
		return p_location_building;
	}



	public void setP_location_building(String p_location_building) {
		this.p_location_building = p_location_building;
	}



	public String getP_location_floor() {
		return p_location_floor;
	}



	public void setP_location_floor(String p_location_floor) {
		this.p_location_floor = p_location_floor;
	}



	public String getP_location_room_no() {
		return p_location_room_no;
	}



	public void setP_location_room_no(String p_location_room_no) {
		this.p_location_room_no = p_location_room_no;
	}



	public String getP_location_street() {
		return p_location_street;
	}



	public void setP_location_street(String p_location_street) {
		this.p_location_street = p_location_street;
	}



	public String getP_location_tambon() {
		return p_location_tambon;
	}



	public void setP_location_tambon(String p_location_tambon) {
		this.p_location_tambon = p_location_tambon;
	}



	public String getP_location_amphur_id() {
		return p_location_amphur_id;
	}



	public void setP_location_amphur_id(String p_location_amphur_id) {
		this.p_location_amphur_id = p_location_amphur_id;
	}



	public String getP_location_province_id() {
		return p_location_province_id;
	}



	public void setP_location_province_id(String p_location_province_id) {
		this.p_location_province_id = p_location_province_id;
	}



	public String getP_location_postcode() {
		return p_location_postcode;
	}



	public void setP_location_postcode(String p_location_postcode) {
		this.p_location_postcode = p_location_postcode;
	}



	public BigDecimal getP_land_area() {
		return p_land_area;
	}



	public void setP_land_area(BigDecimal p_land_area) {
		this.p_land_area = p_land_area;
	}



	public String getP_land_area_type() {
		return p_land_area_type;
	}



	public void setP_land_area_type(String p_land_area_type) {
		this.p_land_area_type = p_land_area_type;
	}



	public BigDecimal getP_deck_area() {
		return p_deck_area;
	}



	public void setP_deck_area(BigDecimal p_deck_area) {
		this.p_deck_area = p_deck_area;
	}



	public String getP_deck_area_type() {
		return p_deck_area_type;
	}



	public void setP_deck_area_type(String p_deck_area_type) {
		this.p_deck_area_type = p_deck_area_type;
	}



	public BigDecimal getP_building_area() {
		return p_building_area;
	}



	public void setP_building_area(BigDecimal p_building_area) {
		this.p_building_area = p_building_area;
	}



	public BigDecimal getP_room_area() {
		return p_room_area;
	}



	public void setP_room_area(BigDecimal p_room_area) {
		this.p_room_area = p_room_area;
	}



	public String getP_area_remark() {
		return p_area_remark;
	}



	public void setP_area_remark(String p_area_remark) {
		this.p_area_remark = p_area_remark;
	}



	public Date getP_effective_dt() {
		return p_effective_dt;
	}



	public void setP_effective_dt(Date p_effective_dt) {
		this.p_effective_dt = p_effective_dt;
	}



	public Date getP_expire_dt() {
		return p_expire_dt;
	}



	public void setP_expire_dt(Date p_expire_dt) {
		this.p_expire_dt = p_expire_dt;
	}



	public BigDecimal getP_age_year() {
		return p_age_year;
	}



	public void setP_age_year(BigDecimal p_age_year) {
		this.p_age_year = p_age_year;
	}



	public BigDecimal getP_age_month() {
		return p_age_month;
	}



	public void setP_age_month(BigDecimal p_age_month) {
		this.p_age_month = p_age_month;
	}



	public BigDecimal getP_age_day() {
		return p_age_day;
	}



	public void setP_age_day(BigDecimal p_age_day) {
		this.p_age_day = p_age_day;
	}



	public String getP_contract_wanted() {
		return p_contract_wanted;
	}



	public void setP_contract_wanted(String p_contract_wanted) {
		this.p_contract_wanted = p_contract_wanted;
	}



	public BigDecimal getP_promise_renew_time() {
		return p_promise_renew_time;
	}



	public void setP_promise_renew_time(BigDecimal p_promise_renew_time) {
		this.p_promise_renew_time = p_promise_renew_time;
	}



	public BigDecimal getP_promise_renew_period() {
		return p_promise_renew_period;
	}



	public void setP_promise_renew_period(BigDecimal p_promise_renew_period) {
		this.p_promise_renew_period = p_promise_renew_period;
	}



	public String getP_promise_renew_period_type() {
		return p_promise_renew_period_type;
	}



	public void setP_promise_renew_period_type(String p_promise_renew_period_type) {
		this.p_promise_renew_period_type = p_promise_renew_period_type;
	}



	public String getP_lessor_name() {
		return p_lessor_name;
	}



	public void setP_lessor_name(String p_lessor_name) {
		this.p_lessor_name = p_lessor_name;
	}



	public String getP_lessor_house_no() {
		return p_lessor_house_no;
	}



	public void setP_lessor_house_no(String p_lessor_house_no) {
		this.p_lessor_house_no = p_lessor_house_no;
	}



	public String getP_lessor_building() {
		return p_lessor_building;
	}



	public void setP_lessor_building(String p_lessor_building) {
		this.p_lessor_building = p_lessor_building;
	}



	public String getP_lessor_floor() {
		return p_lessor_floor;
	}



	public void setP_lessor_floor(String p_lessor_floor) {
		this.p_lessor_floor = p_lessor_floor;
	}



	public String getP_lessor_room_no() {
		return p_lessor_room_no;
	}



	public void setP_lessor_room_no(String p_lessor_room_no) {
		this.p_lessor_room_no = p_lessor_room_no;
	}



	public String getP_lessor_street() {
		return p_lessor_street;
	}



	public void setP_lessor_street(String p_lessor_street) {
		this.p_lessor_street = p_lessor_street;
	}



	public String getP_lessor_tambon() {
		return p_lessor_tambon;
	}



	public void setP_lessor_tambon(String p_lessor_tambon) {
		this.p_lessor_tambon = p_lessor_tambon;
	}



	public String getP_lessor_amphur_id() {
		return p_lessor_amphur_id;
	}



	public void setP_lessor_amphur_id(String p_lessor_amphur_id) {
		this.p_lessor_amphur_id = p_lessor_amphur_id;
	}



	public String getP_lessor_province_id() {
		return p_lessor_province_id;
	}



	public void setP_lessor_province_id(String p_lessor_province_id) {
		this.p_lessor_province_id = p_lessor_province_id;
	}



	public String getP_lessor_postcode() {
		return p_lessor_postcode;
	}



	public void setP_lessor_postcode(String p_lessor_postcode) {
		this.p_lessor_postcode = p_lessor_postcode;
	}



	public String getP_lessor_tax_id() {
		return p_lessor_tax_id;
	}



	public void setP_lessor_tax_id(String p_lessor_tax_id) {
		this.p_lessor_tax_id = p_lessor_tax_id;
	}



	public String getP_contact_name() {
		return p_contact_name;
	}



	public void setP_contact_name(String p_contact_name) {
		this.p_contact_name = p_contact_name;
	}



	public String getP_contact_tel() {
		return p_contact_tel;
	}



	public void setP_contact_tel(String p_contact_tel) {
		this.p_contact_tel = p_contact_tel;
	}



	public String getP_contact_mobile() {
		return p_contact_mobile;
	}



	public void setP_contact_mobile(String p_contact_mobile) {
		this.p_contact_mobile = p_contact_mobile;
	}



	public String getP_contact_fax() {
		return p_contact_fax;
	}



	public void setP_contact_fax(String p_contact_fax) {
		this.p_contact_fax = p_contact_fax;
	}



	public String getP_contact_email() {
		return p_contact_email;
	}



	public void setP_contact_email(String p_contact_email) {
		this.p_contact_email = p_contact_email;
	}



	public BigDecimal getP_rent_amt() {
		return p_rent_amt;
	}



	public void setP_rent_amt(BigDecimal p_rent_amt) {
		this.p_rent_amt = p_rent_amt;
	}



	public String getP_rent_period_type() {
		return p_rent_period_type;
	}



	public void setP_rent_period_type(String p_rent_period_type) {
		this.p_rent_period_type = p_rent_period_type;
	}



	public String getP_rent_detail() {
		return p_rent_detail;
	}



	public void setP_rent_detail(String p_rent_detail) {
		this.p_rent_detail = p_rent_detail;
	}



	public String getP_rent_wht_type() {
		return p_rent_wht_type;
	}



	public void setP_rent_wht_type(String p_rent_wht_type) {
		this.p_rent_wht_type = p_rent_wht_type;
	}



	public BigDecimal getP_rent_wht_rate() {
		return p_rent_wht_rate;
	}



	public void setP_rent_wht_rate(BigDecimal p_rent_wht_rate) {
		this.p_rent_wht_rate = p_rent_wht_rate;
	}



	public String getP_rent_wht_rate_mod() {
		return p_rent_wht_rate_mod;
	}



	public void setP_rent_wht_rate_mod(String p_rent_wht_rate_mod) {
		this.p_rent_wht_rate_mod = p_rent_wht_rate_mod;
	}



	public BigDecimal getP_rent_service_amt() {
		return p_rent_service_amt;
	}



	public void setP_rent_service_amt(BigDecimal p_rent_service_amt) {
		this.p_rent_service_amt = p_rent_service_amt;
	}



	public String getP_rent_service_period_type() {
		return p_rent_service_period_type;
	}



	public void setP_rent_service_period_type(String p_rent_service_period_type) {
		this.p_rent_service_period_type = p_rent_service_period_type;
	}



	public String getP_rent_service_detail() {
		return p_rent_service_detail;
	}



	public void setP_rent_service_detail(String p_rent_service_detail) {
		this.p_rent_service_detail = p_rent_service_detail;
	}



	public String getP_rent_service_vat_type() {
		return p_rent_service_vat_type;
	}



	public void setP_rent_service_vat_type(String p_rent_service_vat_type) {
		this.p_rent_service_vat_type = p_rent_service_vat_type;
	}



	public String getP_rent_service_wht_type() {
		return p_rent_service_wht_type;
	}



	public void setP_rent_service_wht_type(String p_rent_service_wht_type) {
		this.p_rent_service_wht_type = p_rent_service_wht_type;
	}



	public BigDecimal getP_rent_service_wht_rate() {
		return p_rent_service_wht_rate;
	}



	public void setP_rent_service_wht_rate(BigDecimal p_rent_service_wht_rate) {
		this.p_rent_service_wht_rate = p_rent_service_wht_rate;
	}



	public String getP_rent_service_wht_rate_mod() {
		return p_rent_service_wht_rate_mod;
	}



	public void setP_rent_service_wht_rate_mod(String p_rent_service_wht_rate_mod) {
		this.p_rent_service_wht_rate_mod = p_rent_service_wht_rate_mod;
	}



	public String getP_rent_area_amt_memo() {
		return p_rent_area_amt_memo;
	}



	public void setP_rent_area_amt_memo(String p_rent_area_amt_memo) {
		this.p_rent_area_amt_memo = p_rent_area_amt_memo;
	}



	public String getP_rent_service_amt_memo() {
		return p_rent_service_amt_memo;
	}



	public void setP_rent_service_amt_memo(String p_rent_service_amt_memo) {
		this.p_rent_service_amt_memo = p_rent_service_amt_memo;
	}



	public String getP_rent_setup_amt_memo() {
		return p_rent_setup_amt_memo;
	}



	public void setP_rent_setup_amt_memo(String p_rent_setup_amt_memo) {
		this.p_rent_setup_amt_memo = p_rent_setup_amt_memo;
	}



	public String getP_rent_other_amt_memo() {
		return p_rent_other_amt_memo;
	}



	public void setP_rent_other_amt_memo(String p_rent_other_amt_memo) {
		this.p_rent_other_amt_memo = p_rent_other_amt_memo;
	}



	public String getP_rent_special_amt_memo() {
		return p_rent_special_amt_memo;
	}



	public void setP_rent_special_amt_memo(String p_rent_special_amt_memo) {
		this.p_rent_special_amt_memo = p_rent_special_amt_memo;
	}



	public BigDecimal getP_total_rent_service() {
		return p_total_rent_service;
	}



	public void setP_total_rent_service(BigDecimal p_total_rent_service) {
		this.p_total_rent_service = p_total_rent_service;
	}



	public String getP_rent_payment_period() {
		return p_rent_payment_period;
	}



	public void setP_rent_payment_period(String p_rent_payment_period) {
		this.p_rent_payment_period = p_rent_payment_period;
	}



	public String getP_rent_payment_period_oth() {
		return p_rent_payment_period_oth;
	}



	public void setP_rent_payment_period_oth(String p_rent_payment_period_oth) {
		this.p_rent_payment_period_oth = p_rent_payment_period_oth;
	}



	public String getP_rent_deposit_flag() {
		return p_rent_deposit_flag;
	}



	public void setP_rent_deposit_flag(String p_rent_deposit_flag) {
		this.p_rent_deposit_flag = p_rent_deposit_flag;
	}



	public BigDecimal getP_rent_deposit_bg_amt() {
		return p_rent_deposit_bg_amt;
	}



	public void setP_rent_deposit_bg_amt(BigDecimal p_rent_deposit_bg_amt) {
		this.p_rent_deposit_bg_amt = p_rent_deposit_bg_amt;
	}



	public String getP_rent_deposit_bg_vat() {
		return p_rent_deposit_bg_vat;
	}



	public void setP_rent_deposit_bg_vat(String p_rent_deposit_bg_vat) {
		this.p_rent_deposit_bg_vat = p_rent_deposit_bg_vat;
	}



	public BigDecimal getP_rent_deposit_cash_amt() {
		return p_rent_deposit_cash_amt;
	}



	public void setP_rent_deposit_cash_amt(BigDecimal p_rent_deposit_cash_amt) {
		this.p_rent_deposit_cash_amt = p_rent_deposit_cash_amt;
	}



	public String getP_rent_deposit_cash_vat() {
		return p_rent_deposit_cash_vat;
	}



	public void setP_rent_deposit_cash_vat(String p_rent_deposit_cash_vat) {
		this.p_rent_deposit_cash_vat = p_rent_deposit_cash_vat;
	}



	public String getP_rent_remark() {
		return p_rent_remark;
	}



	public void setP_rent_remark(String p_rent_remark) {
		this.p_rent_remark = p_rent_remark;
	}



	public String getP_el_use_multi_resourse() {
		return p_el_use_multi_resourse;
	}



	public void setP_el_use_multi_resourse(String p_el_use_multi_resourse) {
		this.p_el_use_multi_resourse = p_el_use_multi_resourse;
	}



	public String getP_el_use_new_meter() {
		return p_el_use_new_meter;
	}



	public void setP_el_use_new_meter(String p_el_use_new_meter) {
		this.p_el_use_new_meter = p_el_use_new_meter;
	}



	public String getP_el_use_old_meter() {
		return p_el_use_old_meter;
	}



	public void setP_el_use_old_meter(String p_el_use_old_meter) {
		this.p_el_use_old_meter = p_el_use_old_meter;
	}



	public String getP_el_use_owner() {
		return p_el_use_owner;
	}



	public void setP_el_use_owner(String p_el_use_owner) {
		this.p_el_use_owner = p_el_use_owner;
	}



	public String getP_el_owner_type() {
		return p_el_owner_type;
	}



	public void setP_el_owner_type(String p_el_owner_type) {
		this.p_el_owner_type = p_el_owner_type;
	}



	public String getP_el_pay_on_package() {
		return p_el_pay_on_package;
	}



	public void setP_el_pay_on_package(String p_el_pay_on_package) {
		this.p_el_pay_on_package = p_el_pay_on_package;
	}



	public String getP_el_package_period_type() {
		return p_el_package_period_type;
	}



	public void setP_el_package_period_type(String p_el_package_period_type) {
		this.p_el_package_period_type = p_el_package_period_type;
	}



	public BigDecimal getP_el_pay_on_package_amt() {
		return p_el_pay_on_package_amt;
	}



	public void setP_el_pay_on_package_amt(BigDecimal p_el_pay_on_package_amt) {
		this.p_el_pay_on_package_amt = p_el_pay_on_package_amt;
	}



	public String getP_el_pay_on_used() {
		return p_el_pay_on_used;
	}



	public void setP_el_pay_on_used(String p_el_pay_on_used) {
		this.p_el_pay_on_used = p_el_pay_on_used;
	}



	public BigDecimal getP_el_unit_price() {
		return p_el_unit_price;
	}



	public void setP_el_unit_price(BigDecimal p_el_unit_price) {
		this.p_el_unit_price = p_el_unit_price;
	}



	public String getP_el_vat_type() {
		return p_el_vat_type;
	}



	public void setP_el_vat_type(String p_el_vat_type) {
		this.p_el_vat_type = p_el_vat_type;
	}



	public String getP_el_remark() {
		return p_el_remark;
	}



	public void setP_el_remark(String p_el_remark) {
		this.p_el_remark = p_el_remark;
	}



	public String getP_el_deposit_flag() {
		return p_el_deposit_flag;
	}



	public void setP_el_deposit_flag(String p_el_deposit_flag) {
		this.p_el_deposit_flag = p_el_deposit_flag;
	}



	public BigDecimal getP_el_bg_deposit() {
		return p_el_bg_deposit;
	}



	public void setP_el_bg_deposit(BigDecimal p_el_bg_deposit) {
		this.p_el_bg_deposit = p_el_bg_deposit;
	}



	public String getP_el_bg_deposit_vat_type() {
		return p_el_bg_deposit_vat_type;
	}



	public void setP_el_bg_deposit_vat_type(String p_el_bg_deposit_vat_type) {
		this.p_el_bg_deposit_vat_type = p_el_bg_deposit_vat_type;
	}



	public BigDecimal getP_el_cash_deposit() {
		return p_el_cash_deposit;
	}



	public void setP_el_cash_deposit(BigDecimal p_el_cash_deposit) {
		this.p_el_cash_deposit = p_el_cash_deposit;
	}



	public String getP_el_cash_deposit_vat_type() {
		return p_el_cash_deposit_vat_type;
	}



	public void setP_el_cash_deposit_vat_type(String p_el_cash_deposit_vat_type) {
		this.p_el_cash_deposit_vat_type = p_el_cash_deposit_vat_type;
	}



	public String getP_el_deposit_remark() {
		return p_el_deposit_remark;
	}



	public void setP_el_deposit_remark(String p_el_deposit_remark) {
		this.p_el_deposit_remark = p_el_deposit_remark;
	}



	public String getP_remark_special() {
		return p_remark_special;
	}



	public void setP_remark_special(String p_remark_special) {
		this.p_remark_special = p_remark_special;
	}



	public String getP_remark_documents() {
		return p_remark_documents;
	}



	public void setP_remark_documents(String p_remark_documents) {
		this.p_remark_documents = p_remark_documents;
	}



	public String getP_remark_contract() {
		return p_remark_contract;
	}



	public void setP_remark_contract(String p_remark_contract) {
		this.p_remark_contract = p_remark_contract;
	}



	public String getP_remark_aqm() {
		return p_remark_aqm;
	}



	public void setP_remark_aqm(String p_remark_aqm) {
		this.p_remark_aqm = p_remark_aqm;
	}



	public String getP_remark_risk() {
		return p_remark_risk;
	}



	public void setP_remark_risk(String p_remark_risk) {
		this.p_remark_risk = p_remark_risk;
	}



	public String getP_remark_legal() {
		return p_remark_legal;
	}



	public void setP_remark_legal(String p_remark_legal) {
		this.p_remark_legal = p_remark_legal;
	}



	public String getP_remark_other() {
		return p_remark_other;
	}



	public void setP_remark_other(String p_remark_other) {
		this.p_remark_other = p_remark_other;
	}



	public String getP_pt_tax_pay_type() {
		return p_pt_tax_pay_type;
	}



	public void setP_pt_tax_pay_type(String p_pt_tax_pay_type) {
		this.p_pt_tax_pay_type = p_pt_tax_pay_type;
	}



	public String getP_pt_remark() {
		return p_pt_remark;
	}



	public void setP_pt_remark(String p_pt_remark) {
		this.p_pt_remark = p_pt_remark;
	}



	public String getP_ins_flag() {
		return p_ins_flag;
	}



	public void setP_ins_flag(String p_ins_flag) {
		this.p_ins_flag = p_ins_flag;
	}



	public BigDecimal getP_ins_sum_insured() {
		return p_ins_sum_insured;
	}



	public void setP_ins_sum_insured(BigDecimal p_ins_sum_insured) {
		this.p_ins_sum_insured = p_ins_sum_insured;
	}



	public Date getP_ins_effective_dt() {
		return p_ins_effective_dt;
	}



	public void setP_ins_effective_dt(Date p_ins_effective_dt) {
		this.p_ins_effective_dt = p_ins_effective_dt;
	}



	public Date getP_ins_expire_dt() {
		return p_ins_expire_dt;
	}



	public void setP_ins_expire_dt(Date p_ins_expire_dt) {
		this.p_ins_expire_dt = p_ins_expire_dt;
	}



	public String getP_ins_beneficiary() {
		return p_ins_beneficiary;
	}



	public void setP_ins_beneficiary(String p_ins_beneficiary) {
		this.p_ins_beneficiary = p_ins_beneficiary;
	}



	public Date getP_assign_dt() {
		return p_assign_dt;
	}



	public void setP_assign_dt(Date p_assign_dt) {
		this.p_assign_dt = p_assign_dt;
	}



	public String getP_assign_by() {
		return p_assign_by;
	}



	public void setP_assign_by(String p_assign_by) {
		this.p_assign_by = p_assign_by;
	}



	public String getP_assign_to_team() {
		return p_assign_to_team;
	}



	public void setP_assign_to_team(String p_assign_to_team) {
		this.p_assign_to_team = p_assign_to_team;
	}



	public String getP_assign_to_user() {
		return p_assign_to_user;
	}



	public void setP_assign_to_user(String p_assign_to_user) {
		this.p_assign_to_user = p_assign_to_user;
	}



	public Date getP_leader_approve_dt() {
		return p_leader_approve_dt;
	}



	public void setP_leader_approve_dt(Date p_leader_approve_dt) {
		this.p_leader_approve_dt = p_leader_approve_dt;
	}



	public String getP_leader_approve_by() {
		return p_leader_approve_by;
	}



	public void setP_leader_approve_by(String p_leader_approve_by) {
		this.p_leader_approve_by = p_leader_approve_by;
	}



	public String getP_leader_approve_status() {
		return p_leader_approve_status;
	}



	public void setP_leader_approve_status(String p_leader_approve_status) {
		this.p_leader_approve_status = p_leader_approve_status;
	}



	public String getP_leader_approve_remark() {
		return p_leader_approve_remark;
	}



	public void setP_leader_approve_remark(String p_leader_approve_remark) {
		this.p_leader_approve_remark = p_leader_approve_remark;
	}



	public Date getP_manager_approve_dt() {
		return p_manager_approve_dt;
	}



	public void setP_manager_approve_dt(Date p_manager_approve_dt) {
		this.p_manager_approve_dt = p_manager_approve_dt;
	}



	public String getP_manager_approve_by() {
		return p_manager_approve_by;
	}



	public void setP_manager_approve_by(String p_manager_approve_by) {
		this.p_manager_approve_by = p_manager_approve_by;
	}



	public String getP_manager_approve_status() {
		return p_manager_approve_status;
	}



	public void setP_manager_approve_status(String p_manager_approve_status) {
		this.p_manager_approve_status = p_manager_approve_status;
	}



	public String getP_manager_approve_remark() {
		return p_manager_approve_remark;
	}



	public void setP_manager_approve_remark(String p_manager_approve_remark) {
		this.p_manager_approve_remark = p_manager_approve_remark;
	}



	public Date getP_legal_approve_dt() {
		return p_legal_approve_dt;
	}



	public void setP_legal_approve_dt(Date p_legal_approve_dt) {
		this.p_legal_approve_dt = p_legal_approve_dt;
	}



	public String getP_legal_approve_by() {
		return p_legal_approve_by;
	}



	public void setP_legal_approve_by(String p_legal_approve_by) {
		this.p_legal_approve_by = p_legal_approve_by;
	}



	public String getP_legal_approve_status() {
		return p_legal_approve_status;
	}



	public void setP_legal_approve_status(String p_legal_approve_status) {
		this.p_legal_approve_status = p_legal_approve_status;
	}



	public String getP_legal_approve_remark() {
		return p_legal_approve_remark;
	}



	public void setP_legal_approve_remark(String p_legal_approve_remark) {
		this.p_legal_approve_remark = p_legal_approve_remark;
	}



	public Date getP_avp_approve_dt() {
		return p_avp_approve_dt;
	}



	public void setP_avp_approve_dt(Date p_avp_approve_dt) {
		this.p_avp_approve_dt = p_avp_approve_dt;
	}



	public String getP_avp_approve_by() {
		return p_avp_approve_by;
	}



	public void setP_avp_approve_by(String p_avp_approve_by) {
		this.p_avp_approve_by = p_avp_approve_by;
	}



	public String getP_avp_approve_status() {
		return p_avp_approve_status;
	}



	public void setP_avp_approve_status(String p_avp_approve_status) {
		this.p_avp_approve_status = p_avp_approve_status;
	}



	public String getP_avp_approve_remark() {
		return p_avp_approve_remark;
	}



	public void setP_avp_approve_remark(String p_avp_approve_remark) {
		this.p_avp_approve_remark = p_avp_approve_remark;
	}



	public String getP_flow_status() {
		return p_flow_status;
	}



	public void setP_flow_status(String p_flow_status) {
		this.p_flow_status = p_flow_status;
	}



	public String getP_record_status() {
		return p_record_status;
	}



	public void setP_record_status(String p_record_status) {
		this.p_record_status = p_record_status;
	}



	public String getP_batch_no() {
		return p_batch_no;
	}



	public void setP_batch_no(String p_batch_no) {
		this.p_batch_no = p_batch_no;
	}



	public Date getP_batch_dt() {
		return p_batch_dt;
	}



	public void setP_batch_dt(Date p_batch_dt) {
		this.p_batch_dt = p_batch_dt;
	}



	public String getP_location_edit_flag() {
		return p_location_edit_flag;
	}



	public void setP_location_edit_flag(String p_location_edit_flag) {
		this.p_location_edit_flag = p_location_edit_flag;
	}



	public String getP_contract_edit_flag() {
		return p_contract_edit_flag;
	}



	public void setP_contract_edit_flag(String p_contract_edit_flag) {
		this.p_contract_edit_flag = p_contract_edit_flag;
	}



	public String getP_rent_edit_flag() {
		return p_rent_edit_flag;
	}



	public void setP_rent_edit_flag(String p_rent_edit_flag) {
		this.p_rent_edit_flag = p_rent_edit_flag;
	}



	public String getP_rent_deposit_edit_flag() {
		return p_rent_deposit_edit_flag;
	}



	public void setP_rent_deposit_edit_flag(String p_rent_deposit_edit_flag) {
		this.p_rent_deposit_edit_flag = p_rent_deposit_edit_flag;
	}



	public String getP_el_edit_flag() {
		return p_el_edit_flag;
	}



	public void setP_el_edit_flag(String p_el_edit_flag) {
		this.p_el_edit_flag = p_el_edit_flag;
	}



	public String getP_el_deposit_edit_flag() {
		return p_el_deposit_edit_flag;
	}



	public void setP_el_deposit_edit_flag(String p_el_deposit_edit_flag) {
		this.p_el_deposit_edit_flag = p_el_deposit_edit_flag;
	}



	public String getP_property_tax_edit_flag() {
		return p_property_tax_edit_flag;
	}



	public void setP_property_tax_edit_flag(String p_property_tax_edit_flag) {
		this.p_property_tax_edit_flag = p_property_tax_edit_flag;
	}



	public String getP_insurance_edit_flag() {
		return p_insurance_edit_flag;
	}



	public void setP_insurance_edit_flag(String p_insurance_edit_flag) {
		this.p_insurance_edit_flag = p_insurance_edit_flag;
	}



	public String getP_mail_edit_flag() {
		return p_mail_edit_flag;
	}



	public void setP_mail_edit_flag(String p_mail_edit_flag) {
		this.p_mail_edit_flag = p_mail_edit_flag;
	}



	public Date getP_create_dt() {
		return p_create_dt;
	}



	public void setP_create_dt(Date p_create_dt) {
		this.p_create_dt = p_create_dt;
	}



	public String getP_create_by() {
		return p_create_by;
	}



	public void setP_create_by(String p_create_by) {
		this.p_create_by = p_create_by;
	}



	public Date getP_update_dt() {
		return p_update_dt;
	}



	public void setP_update_dt(Date p_update_dt) {
		this.p_update_dt = p_update_dt;
	}



	public String getP_update_by() {
		return p_update_by;
	}



	public void setP_update_by(String p_update_by) {
		this.p_update_by = p_update_by;
	}



	public BigDecimal getP_version() {
		return p_version;
	}



	public void setP_version(BigDecimal p_version) {
		this.p_version = p_version;
	}



	public String getP_place_type() {
		return p_place_type;
	}



	public void setP_place_type(String p_place_type) {
		this.p_place_type = p_place_type;
	}



	public String getP_parties_type() {
		return p_parties_type;
	}



	public void setP_parties_type(String p_parties_type) {
		this.p_parties_type = p_parties_type;
	}



	public String getP_phase() {
		return p_phase;
	}



	public void setP_phase(String p_phase) {
		this.p_phase = p_phase;
	}



	public Date getP_terminate_cancel_contract_dt() {
		return p_terminate_cancel_contract_dt;
	}



	public void setP_terminate_cancel_contract_dt(Date p_terminate_cancel_contract_dt) {
		this.p_terminate_cancel_contract_dt = p_terminate_cancel_contract_dt;
	}



	public Date getP_terminate_remove_end_dt() {
		return p_terminate_remove_end_dt;
	}



	public void setP_terminate_remove_end_dt(Date p_terminate_remove_end_dt) {
		this.p_terminate_remove_end_dt = p_terminate_remove_end_dt;
	}



	public String getP_co_locate_company() {
		return p_co_locate_company;
	}



	public void setP_co_locate_company(String p_co_locate_company) {
		this.p_co_locate_company = p_co_locate_company;
	}



	public String getP_location_code() {
		return p_location_code;
	}



	public void setP_location_code(String p_location_code) {
		this.p_location_code = p_location_code;
	}



	public String getP_location_name() {
		return p_location_name;
	}



	public void setP_location_name(String p_location_name) {
		this.p_location_name = p_location_name;
	}



	public String getP_construction_unneed() {
		return p_construction_unneed;
	}



	public void setP_construction_unneed(String p_construction_unneed) {
		this.p_construction_unneed = p_construction_unneed;
	}



	public String getP_contract_never_expire() {
		return p_contract_never_expire;
	}



	public void setP_contract_never_expire(String p_contract_never_expire) {
		this.p_contract_never_expire = p_contract_never_expire;
	}



	public String getP_contract_wanted_remark() {
		return p_contract_wanted_remark;
	}



	public void setP_contract_wanted_remark(String p_contract_wanted_remark) {
		this.p_contract_wanted_remark = p_contract_wanted_remark;
	}



	public String getP_tower_type() {
		return p_tower_type;
	}



	public void setP_tower_type(String p_tower_type) {
		this.p_tower_type = p_tower_type;
	}



	public String getP_tower_location() {
		return p_tower_location;
	}



	public void setP_tower_location(String p_tower_location) {
		this.p_tower_location = p_tower_location;
	}



	public BigDecimal getP_tower_height() {
		return p_tower_height;
	}



	public void setP_tower_height(BigDecimal p_tower_height) {
		this.p_tower_height = p_tower_height;
	}



	public String getP_rent_vat_type() {
		return p_rent_vat_type;
	}



	public void setP_rent_vat_type(String p_rent_vat_type) {
		this.p_rent_vat_type = p_rent_vat_type;
	}



	public BigDecimal getP_rent_vat_rate() {
		return p_rent_vat_rate;
	}



	public void setP_rent_vat_rate(BigDecimal p_rent_vat_rate) {
		this.p_rent_vat_rate = p_rent_vat_rate;
	}



	public BigDecimal getP_rent_service_vat_rate() {
		return p_rent_service_vat_rate;
	}



	public void setP_rent_service_vat_rate(BigDecimal p_rent_service_vat_rate) {
		this.p_rent_service_vat_rate = p_rent_service_vat_rate;
	}



	public String getP_remark_after_approve() {
		return p_remark_after_approve;
	}



	public void setP_remark_after_approve(String p_remark_after_approve) {
		this.p_remark_after_approve = p_remark_after_approve;
	}



	public BigDecimal getP_rent_amt_old() {
		return p_rent_amt_old;
	}



	public void setP_rent_amt_old(BigDecimal p_rent_amt_old) {
		this.p_rent_amt_old = p_rent_amt_old;
	}



	public String getP_rent_period_type_old() {
		return p_rent_period_type_old;
	}



	public void setP_rent_period_type_old(String p_rent_period_type_old) {
		this.p_rent_period_type_old = p_rent_period_type_old;
	}



	public BigDecimal getP_rent_amt_add() {
		return p_rent_amt_add;
	}



	public void setP_rent_amt_add(BigDecimal p_rent_amt_add) {
		this.p_rent_amt_add = p_rent_amt_add;
	}



	public BigDecimal getP_rent_amt_add_perc() {
		return p_rent_amt_add_perc;
	}



	public void setP_rent_amt_add_perc(BigDecimal p_rent_amt_add_perc) {
		this.p_rent_amt_add_perc = p_rent_amt_add_perc;
	}



	public BigDecimal getP_rent_serv_amt_old() {
		return p_rent_serv_amt_old;
	}



	public void setP_rent_serv_amt_old(BigDecimal p_rent_serv_amt_old) {
		this.p_rent_serv_amt_old = p_rent_serv_amt_old;
	}



	public String getP_rent_serv_period_type_old() {
		return p_rent_serv_period_type_old;
	}



	public void setP_rent_serv_period_type_old(String p_rent_serv_period_type_old) {
		this.p_rent_serv_period_type_old = p_rent_serv_period_type_old;
	}



	public BigDecimal getP_rent_serv_amt_add() {
		return p_rent_serv_amt_add;
	}



	public void setP_rent_serv_amt_add(BigDecimal p_rent_serv_amt_add) {
		this.p_rent_serv_amt_add = p_rent_serv_amt_add;
	}



	public BigDecimal getP_rent_serv_amt_add_perc() {
		return p_rent_serv_amt_add_perc;
	}



	public void setP_rent_serv_amt_add_perc(BigDecimal p_rent_serv_amt_add_perc) {
		this.p_rent_serv_amt_add_perc = p_rent_serv_amt_add_perc;
	}



	public BigDecimal getP_rent_deposit_bg_amt_old() {
		return p_rent_deposit_bg_amt_old;
	}



	public void setP_rent_deposit_bg_amt_old(BigDecimal p_rent_deposit_bg_amt_old) {
		this.p_rent_deposit_bg_amt_old = p_rent_deposit_bg_amt_old;
	}



	public BigDecimal getP_rent_deposit_cash_amt_old() {
		return p_rent_deposit_cash_amt_old;
	}



	public void setP_rent_deposit_cash_amt_old(BigDecimal p_rent_deposit_cash_amt_old) {
		this.p_rent_deposit_cash_amt_old = p_rent_deposit_cash_amt_old;
	}



	public BigDecimal getP_rent_deposit_bg_amt_add() {
		return p_rent_deposit_bg_amt_add;
	}



	public void setP_rent_deposit_bg_amt_add(BigDecimal p_rent_deposit_bg_amt_add) {
		this.p_rent_deposit_bg_amt_add = p_rent_deposit_bg_amt_add;
	}



	public BigDecimal getP_rent_deposit_cash_amt_add() {
		return p_rent_deposit_cash_amt_add;
	}



	public void setP_rent_deposit_cash_amt_add(BigDecimal p_rent_deposit_cash_amt_add) {
		this.p_rent_deposit_cash_amt_add = p_rent_deposit_cash_amt_add;
	}



	public BigDecimal getP_revenue() {
		return p_revenue;
	}



	public void setP_revenue(BigDecimal p_revenue) {
		this.p_revenue = p_revenue;
	}



	public String getP_rent_area_memo_vat_type() {
		return p_rent_area_memo_vat_type;
	}



	public void setP_rent_area_memo_vat_type(String p_rent_area_memo_vat_type) {
		this.p_rent_area_memo_vat_type = p_rent_area_memo_vat_type;
	}



	public String getP_rent_area_memo_wht_type() {
		return p_rent_area_memo_wht_type;
	}



	public void setP_rent_area_memo_wht_type(String p_rent_area_memo_wht_type) {
		this.p_rent_area_memo_wht_type = p_rent_area_memo_wht_type;
	}



	public BigDecimal getP_rent_area_memo_wht_rate() {
		return p_rent_area_memo_wht_rate;
	}



	public void setP_rent_area_memo_wht_rate(BigDecimal p_rent_area_memo_wht_rate) {
		this.p_rent_area_memo_wht_rate = p_rent_area_memo_wht_rate;
	}



	public String getP_rent_serv_memo_vat_type() {
		return p_rent_serv_memo_vat_type;
	}



	public void setP_rent_serv_memo_vat_type(String p_rent_serv_memo_vat_type) {
		this.p_rent_serv_memo_vat_type = p_rent_serv_memo_vat_type;
	}



	public String getP_rent_serv_memo_wht_type() {
		return p_rent_serv_memo_wht_type;
	}



	public void setP_rent_serv_memo_wht_type(String p_rent_serv_memo_wht_type) {
		this.p_rent_serv_memo_wht_type = p_rent_serv_memo_wht_type;
	}



	public BigDecimal getP_rent_serv_memo_wht_rate() {
		return p_rent_serv_memo_wht_rate;
	}



	public void setP_rent_serv_memo_wht_rate(BigDecimal p_rent_serv_memo_wht_rate) {
		this.p_rent_serv_memo_wht_rate = p_rent_serv_memo_wht_rate;
	}



	public String getP_rent_setup_memo_vat_type() {
		return p_rent_setup_memo_vat_type;
	}



	public void setP_rent_setup_memo_vat_type(String p_rent_setup_memo_vat_type) {
		this.p_rent_setup_memo_vat_type = p_rent_setup_memo_vat_type;
	}



	public String getP_rent_setup_memo_wht_type() {
		return p_rent_setup_memo_wht_type;
	}



	public void setP_rent_setup_memo_wht_type(String p_rent_setup_memo_wht_type) {
		this.p_rent_setup_memo_wht_type = p_rent_setup_memo_wht_type;
	}



	public BigDecimal getP_rent_setup_memo_wht_rate() {
		return p_rent_setup_memo_wht_rate;
	}



	public void setP_rent_setup_memo_wht_rate(BigDecimal p_rent_setup_memo_wht_rate) {
		this.p_rent_setup_memo_wht_rate = p_rent_setup_memo_wht_rate;
	}



	public String getP_rent_other_memo_vat_type() {
		return p_rent_other_memo_vat_type;
	}



	public void setP_rent_other_memo_vat_type(String p_rent_other_memo_vat_type) {
		this.p_rent_other_memo_vat_type = p_rent_other_memo_vat_type;
	}



	public String getP_rent_other_memo_wht_type() {
		return p_rent_other_memo_wht_type;
	}



	public void setP_rent_other_memo_wht_type(String p_rent_other_memo_wht_type) {
		this.p_rent_other_memo_wht_type = p_rent_other_memo_wht_type;
	}



	public BigDecimal getP_rent_other_memo_wht_rate() {
		return p_rent_other_memo_wht_rate;
	}



	public void setP_rent_other_memo_wht_rate(BigDecimal p_rent_other_memo_wht_rate) {
		this.p_rent_other_memo_wht_rate = p_rent_other_memo_wht_rate;
	}



	public String getP_is_macro_type() {
		return p_is_macro_type;
	}



	public void setP_is_macro_type(String p_is_macro_type) {
		this.p_is_macro_type = p_is_macro_type;
	}



	public String getP_is_micro_type() {
		return p_is_micro_type;
	}



	public void setP_is_micro_type(String p_is_micro_type) {
		this.p_is_micro_type = p_is_micro_type;
	}



	public String getP_is_pico_type() {
		return p_is_pico_type;
	}



	public void setP_is_pico_type(String p_is_pico_type) {
		this.p_is_pico_type = p_is_pico_type;
	}



	public String getP_is_repeater_type() {
		return p_is_repeater_type;
	}



	public void setP_is_repeater_type(String p_is_repeater_type) {
		this.p_is_repeater_type = p_is_repeater_type;
	}



	public String getP_is_tower_type() {
		return p_is_tower_type;
	}



	public void setP_is_tower_type(String p_is_tower_type) {
		this.p_is_tower_type = p_is_tower_type;
	}



	public String getP_is_wifi_type() {
		return p_is_wifi_type;
	}



	public void setP_is_wifi_type(String p_is_wifi_type) {
		this.p_is_wifi_type = p_is_wifi_type;
	}



	public String getP_is_other_type() {
		return p_is_other_type;
	}



	public void setP_is_other_type(String p_is_other_type) {
		this.p_is_other_type = p_is_other_type;
	}



	public String getP_is_other_type_detail() {
		return p_is_other_type_detail;
	}



	public void setP_is_other_type_detail(String p_is_other_type_detail) {
		this.p_is_other_type_detail = p_is_other_type_detail;
	}



	public String getP_contract_no_old() {
		return p_contract_no_old;
	}



	public void setP_contract_no_old(String p_contract_no_old) {
		this.p_contract_no_old = p_contract_no_old;
	}



	public String getP_is_smallcell_type() {
		return p_is_smallcell_type;
	}



	public void setP_is_smallcell_type(String p_is_smallcell_type) {
		this.p_is_smallcell_type = p_is_smallcell_type;
	}



	public String getP_co_company() {
		return p_co_company;
	}



	public void setP_co_company(String p_co_company) {
		this.p_co_company = p_co_company;
	}



	public String getP_co_company_contract_no() {
		return p_co_company_contract_no;
	}



	public void setP_co_company_contract_no(String p_co_company_contract_no) {
		this.p_co_company_contract_no = p_co_company_contract_no;
	}



	public String getP_el_use_oth_site() {
		return p_el_use_oth_site;
	}



	public void setP_el_use_oth_site(String p_el_use_oth_site) {
		this.p_el_use_oth_site = p_el_use_oth_site;
	}



	public String getP_el_use_oth_site_contract_no() {
		return p_el_use_oth_site_contract_no;
	}



	public void setP_el_use_oth_site_contract_no(String p_el_use_oth_site_contract_no) {
		this.p_el_use_oth_site_contract_no = p_el_use_oth_site_contract_no;
	}



	public String getP_re_locate_contract_no() {
		return p_re_locate_contract_no;
	}



	public void setP_re_locate_contract_no(String p_re_locate_contract_no) {
		this.p_re_locate_contract_no = p_re_locate_contract_no;
	}



	public String getP_is_fbb_type() {
		return p_is_fbb_type;
	}



	public void setP_is_fbb_type(String p_is_fbb_type) {
		this.p_is_fbb_type = p_is_fbb_type;
	}



	public String getP_is_ofc_type() {
		return p_is_ofc_type;
	}



	public void setP_is_ofc_type(String p_is_ofc_type) {
		this.p_is_ofc_type = p_is_ofc_type;
	}



	public String getP_is_fttx_type() {
		return p_is_fttx_type;
	}



	public void setP_is_fttx_type(String p_is_fttx_type) {
		this.p_is_fttx_type = p_is_fttx_type;
	}



	public Date getP_change_effective_dt() {
		return p_change_effective_dt;
	}



	public void setP_change_effective_dt(Date p_change_effective_dt) {
		this.p_change_effective_dt = p_change_effective_dt;
	}



	public String getP_service_payment_period() {
		return p_service_payment_period;
	}



	public void setP_service_payment_period(String p_service_payment_period) {
		this.p_service_payment_period = p_service_payment_period;
	}



	public String getP_service_payment_period_oth() {
		return p_service_payment_period_oth;
	}



	public void setP_service_payment_period_oth(String p_service_payment_period_oth) {
		this.p_service_payment_period_oth = p_service_payment_period_oth;
	}



	public BigDecimal getP_el_deposit_bg_amt_old() {
		return p_el_deposit_bg_amt_old;
	}



	public void setP_el_deposit_bg_amt_old(BigDecimal p_el_deposit_bg_amt_old) {
		this.p_el_deposit_bg_amt_old = p_el_deposit_bg_amt_old;
	}



	public BigDecimal getP_el_deposit_cash_amt_old() {
		return p_el_deposit_cash_amt_old;
	}



	public void setP_el_deposit_cash_amt_old(BigDecimal p_el_deposit_cash_amt_old) {
		this.p_el_deposit_cash_amt_old = p_el_deposit_cash_amt_old;
	}



	public BigDecimal getP_el_deposit_bg_amt_add() {
		return p_el_deposit_bg_amt_add;
	}



	public void setP_el_deposit_bg_amt_add(BigDecimal p_el_deposit_bg_amt_add) {
		this.p_el_deposit_bg_amt_add = p_el_deposit_bg_amt_add;
	}



	public BigDecimal getP_el_deposit_cash_amt_add() {
		return p_el_deposit_cash_amt_add;
	}



	public void setP_el_deposit_cash_amt_add(BigDecimal p_el_deposit_cash_amt_add) {
		this.p_el_deposit_cash_amt_add = p_el_deposit_cash_amt_add;
	}



	public String getP_el_no_expenses() {
		return p_el_no_expenses;
	}



	public void setP_el_no_expenses(String p_el_no_expenses) {
		this.p_el_no_expenses = p_el_no_expenses;
	}



	public String getP_no_rental() {
		return p_no_rental;
	}



	public void setP_no_rental(String p_no_rental) {
		this.p_no_rental = p_no_rental;
	}



	public String getP_save_flag() {
		return p_save_flag;
	}



	public void setP_save_flag(String p_save_flag) {
		this.p_save_flag = p_save_flag;
	}



	public String getP_legal_vat_type() {
		return p_legal_vat_type;
	}



	public void setP_legal_vat_type(String p_legal_vat_type) {
		this.p_legal_vat_type = p_legal_vat_type;
	}



	public String getP_co_operator() {
		return p_co_operator;
	}



	public void setP_co_operator(String p_co_operator) {
		this.p_co_operator = p_co_operator;
	}



	public String getP_leasehold_rights() {
		return p_leasehold_rights;
	}



	public void setP_leasehold_rights(String p_leasehold_rights) {
		this.p_leasehold_rights = p_leasehold_rights;
	}



	public String getP_license() {
		return p_license;
	}



	public void setP_license(String p_license) {
		this.p_license = p_license;
	}



	public String getP_ll_rental_agreement() {
		return p_ll_rental_agreement;
	}



	public void setP_ll_rental_agreement(String p_ll_rental_agreement) {
		this.p_ll_rental_agreement = p_ll_rental_agreement;
	}



	public String getP_sa_site_type() {
		return p_sa_site_type;
	}



	public void setP_sa_site_type(String p_sa_site_type) {
		this.p_sa_site_type = p_sa_site_type;
	}



	public String getP_deck_area_unit_type() {
		return p_deck_area_unit_type;
	}



	public void setP_deck_area_unit_type(String p_deck_area_unit_type) {
		this.p_deck_area_unit_type = p_deck_area_unit_type;
	}



	public String getP_deck_area_width() {
		return p_deck_area_width;
	}



	public void setP_deck_area_width(String p_deck_area_width) {
		this.p_deck_area_width = p_deck_area_width;
	}



	public String getP_deck_area_long() {
		return p_deck_area_long;
	}



	public void setP_deck_area_long(String p_deck_area_long) {
		this.p_deck_area_long = p_deck_area_long;
	}



	public String getP_deck_area_other() {
		return p_deck_area_other;
	}



	public void setP_deck_area_other(String p_deck_area_other) {
		this.p_deck_area_other = p_deck_area_other;
	}



	public String getP_building_area_type() {
		return p_building_area_type;
	}



	public void setP_building_area_type(String p_building_area_type) {
		this.p_building_area_type = p_building_area_type;
	}



	public String getP_building_area_unit_type() {
		return p_building_area_unit_type;
	}



	public void setP_building_area_unit_type(String p_building_area_unit_type) {
		this.p_building_area_unit_type = p_building_area_unit_type;
	}



	public String getP_building_area_width() {
		return p_building_area_width;
	}



	public void setP_building_area_width(String p_building_area_width) {
		this.p_building_area_width = p_building_area_width;
	}



	public String getP_building_area_long() {
		return p_building_area_long;
	}



	public void setP_building_area_long(String p_building_area_long) {
		this.p_building_area_long = p_building_area_long;
	}



	public String getP_building_area_other() {
		return p_building_area_other;
	}



	public void setP_building_area_other(String p_building_area_other) {
		this.p_building_area_other = p_building_area_other;
	}



	public String getP_room_area_type() {
		return p_room_area_type;
	}



	public void setP_room_area_type(String p_room_area_type) {
		this.p_room_area_type = p_room_area_type;
	}



	public String getP_room_area_unit_type() {
		return p_room_area_unit_type;
	}



	public void setP_room_area_unit_type(String p_room_area_unit_type) {
		this.p_room_area_unit_type = p_room_area_unit_type;
	}



	public String getP_room_area_width() {
		return p_room_area_width;
	}



	public void setP_room_area_width(String p_room_area_width) {
		this.p_room_area_width = p_room_area_width;
	}



	public String getP_room_area_long() {
		return p_room_area_long;
	}



	public void setP_room_area_long(String p_room_area_long) {
		this.p_room_area_long = p_room_area_long;
	}



	public String getP_room_area_other() {
		return p_room_area_other;
	}



	public void setP_room_area_other(String p_room_area_other) {
		this.p_room_area_other = p_room_area_other;
	}



	public String getP_land_area_unit_type() {
		return p_land_area_unit_type;
	}



	public void setP_land_area_unit_type(String p_land_area_unit_type) {
		this.p_land_area_unit_type = p_land_area_unit_type;
	}



	public String getP_land_area_width() {
		return p_land_area_width;
	}



	public void setP_land_area_width(String p_land_area_width) {
		this.p_land_area_width = p_land_area_width;
	}



	public String getP_land_area_long() {
		return p_land_area_long;
	}



	public void setP_land_area_long(String p_land_area_long) {
		this.p_land_area_long = p_land_area_long;
	}



	public String getP_land_area_other() {
		return p_land_area_other;
	}



	public void setP_land_area_other(String p_land_area_other) {
		this.p_land_area_other = p_land_area_other;
	}



	public String getP_place_type_other() {
		return p_place_type_other;
	}



	public void setP_place_type_other(String p_place_type_other) {
		this.p_place_type_other = p_place_type_other;
	}



	public String getP_doc_type_other() {
		return p_doc_type_other;
	}



	public void setP_doc_type_other(String p_doc_type_other) {
		this.p_doc_type_other = p_doc_type_other;
	}



	public String getP_doc_location_address_no() {
		return p_doc_location_address_no;
	}



	public void setP_doc_location_address_no(String p_doc_location_address_no) {
		this.p_doc_location_address_no = p_doc_location_address_no;
	}



	public String getP_doc_location_building() {
		return p_doc_location_building;
	}



	public void setP_doc_location_building(String p_doc_location_building) {
		this.p_doc_location_building = p_doc_location_building;
	}



	public String getP_doc_location_floor() {
		return p_doc_location_floor;
	}



	public void setP_doc_location_floor(String p_doc_location_floor) {
		this.p_doc_location_floor = p_doc_location_floor;
	}



	public String getP_doc_location_street() {
		return p_doc_location_street;
	}



	public void setP_doc_location_street(String p_doc_location_street) {
		this.p_doc_location_street = p_doc_location_street;
	}



	public String getP_doc_location_tambon() {
		return p_doc_location_tambon;
	}



	public void setP_doc_location_tambon(String p_doc_location_tambon) {
		this.p_doc_location_tambon = p_doc_location_tambon;
	}



	public String getP_doc_location_amphur_id() {
		return p_doc_location_amphur_id;
	}



	public void setP_doc_location_amphur_id(String p_doc_location_amphur_id) {
		this.p_doc_location_amphur_id = p_doc_location_amphur_id;
	}



	public String getP_doc_location_province_id() {
		return p_doc_location_province_id;
	}



	public void setP_doc_location_province_id(String p_doc_location_province_id) {
		this.p_doc_location_province_id = p_doc_location_province_id;
	}



	public String getP_doc_location_postcode() {
		return p_doc_location_postcode;
	}



	public void setP_doc_location_postcode(String p_doc_location_postcode) {
		this.p_doc_location_postcode = p_doc_location_postcode;
	}



	public Date getP_ch_effect_dt_contract() {
		return p_ch_effect_dt_contract;
	}



	public void setP_ch_effect_dt_contract(Date p_ch_effect_dt_contract) {
		this.p_ch_effect_dt_contract = p_ch_effect_dt_contract;
	}



	public String getP_lessor_title_name() {
		return p_lessor_title_name;
	}



	public void setP_lessor_title_name(String p_lessor_title_name) {
		this.p_lessor_title_name = p_lessor_title_name;
	}



	public Date getP_lessor_birthday() {
		return p_lessor_birthday;
	}



	public void setP_lessor_birthday(Date p_lessor_birthday) {
		this.p_lessor_birthday = p_lessor_birthday;
	}



	public String getP_contract_title_name() {
		return p_contract_title_name;
	}



	public void setP_contract_title_name(String p_contract_title_name) {
		this.p_contract_title_name = p_contract_title_name;
	}



	public String getP_contract_id_card() {
		return p_contract_id_card;
	}



	public void setP_contract_id_card(String p_contract_id_card) {
		this.p_contract_id_card = p_contract_id_card;
	}



	public Date getP_contract_birthday() {
		return p_contract_birthday;
	}



	public void setP_contract_birthday(Date p_contract_birthday) {
		this.p_contract_birthday = p_contract_birthday;
	}



	public String getP_contract_address_no() {
		return p_contract_address_no;
	}



	public void setP_contract_address_no(String p_contract_address_no) {
		this.p_contract_address_no = p_contract_address_no;
	}



	public String getP_contract_building() {
		return p_contract_building;
	}



	public void setP_contract_building(String p_contract_building) {
		this.p_contract_building = p_contract_building;
	}



	public String getP_contract_floor() {
		return p_contract_floor;
	}



	public void setP_contract_floor(String p_contract_floor) {
		this.p_contract_floor = p_contract_floor;
	}



	public String getP_contract_room_no() {
		return p_contract_room_no;
	}



	public void setP_contract_room_no(String p_contract_room_no) {
		this.p_contract_room_no = p_contract_room_no;
	}



	public String getP_contract_street() {
		return p_contract_street;
	}



	public void setP_contract_street(String p_contract_street) {
		this.p_contract_street = p_contract_street;
	}



	public String getP_contract_tambon() {
		return p_contract_tambon;
	}



	public void setP_contract_tambon(String p_contract_tambon) {
		this.p_contract_tambon = p_contract_tambon;
	}



	public String getP_contract_amphur_id() {
		return p_contract_amphur_id;
	}



	public void setP_contract_amphur_id(String p_contract_amphur_id) {
		this.p_contract_amphur_id = p_contract_amphur_id;
	}



	public String getP_contract_province_id() {
		return p_contract_province_id;
	}



	public void setP_contract_province_id(String p_contract_province_id) {
		this.p_contract_province_id = p_contract_province_id;
	}



	public String getP_contract_postcode() {
		return p_contract_postcode;
	}



	public void setP_contract_postcode(String p_contract_postcode) {
		this.p_contract_postcode = p_contract_postcode;
	}



	public String getP_owner_title_name() {
		return p_owner_title_name;
	}



	public void setP_owner_title_name(String p_owner_title_name) {
		this.p_owner_title_name = p_owner_title_name;
	}



	public String getP_doc_type() {
		return p_doc_type;
	}



	public void setP_doc_type(String p_doc_type) {
		this.p_doc_type = p_doc_type;
	}



	public String getP_el_use_other() {
		return p_el_use_other;
	}



	public void setP_el_use_other(String p_el_use_other) {
		this.p_el_use_other = p_el_use_other;
	}



	public String getP_lessor_tel() {
		return p_lessor_tel;
	}



	public void setP_lessor_tel(String p_lessor_tel) {
		this.p_lessor_tel = p_lessor_tel;
	}



	public String getP_lessor_mobile() {
		return p_lessor_mobile;
	}



	public void setP_lessor_mobile(String p_lessor_mobile) {
		this.p_lessor_mobile = p_lessor_mobile;
	}



	public String getP_lessor_fax() {
		return p_lessor_fax;
	}



	public void setP_lessor_fax(String p_lessor_fax) {
		this.p_lessor_fax = p_lessor_fax;
	}



	public String getP_lessor_email() {
		return p_lessor_email;
	}



	public void setP_lessor_email(String p_lessor_email) {
		this.p_lessor_email = p_lessor_email;
	}



	public String getP_no_deposit_rent() {
		return p_no_deposit_rent;
	}



	public void setP_no_deposit_rent(String p_no_deposit_rent) {
		this.p_no_deposit_rent = p_no_deposit_rent;
	}



	public String getP_no_deposit_elec() {
		return p_no_deposit_elec;
	}



	public void setP_no_deposit_elec(String p_no_deposit_elec) {
		this.p_no_deposit_elec = p_no_deposit_elec;
	}



	public String getP_owner_name() {
		return p_owner_name;
	}



	public void setP_owner_name(String p_owner_name) {
		this.p_owner_name = p_owner_name;
	}



	public String getP_owner_category() {
		return p_owner_category;
	}



	public void setP_owner_category(String p_owner_category) {
		this.p_owner_category = p_owner_category;
	}



	public String getP_station_type() {
		return p_station_type;
	}



	public void setP_station_type(String p_station_type) {
		this.p_station_type = p_station_type;
	}



	public String getP_owner_sub_category() {
		return p_owner_sub_category;
	}



	public void setP_owner_sub_category(String p_owner_sub_category) {
		this.p_owner_sub_category = p_owner_sub_category;
	}



	public String getP_emer_contact_name() {
		return p_emer_contact_name;
	}



	public void setP_emer_contact_name(String p_emer_contact_name) {
		this.p_emer_contact_name = p_emer_contact_name;
	}



	public String getP_emer_contact_phone() {
		return p_emer_contact_phone;
	}



	public void setP_emer_contact_phone(String p_emer_contact_phone) {
		this.p_emer_contact_phone = p_emer_contact_phone;
	}



	public String getP_renew_rent_flag() {
		return p_renew_rent_flag;
	}



	public void setP_renew_rent_flag(String p_renew_rent_flag) {
		this.p_renew_rent_flag = p_renew_rent_flag;
	}



	public String getP_renew_rent_percent() {
		return p_renew_rent_percent;
	}



	public void setP_renew_rent_percent(String p_renew_rent_percent) {
		this.p_renew_rent_percent = p_renew_rent_percent;
	}



	public String getP_promise_renew_remark() {
		return p_promise_renew_remark;
	}



	public void setP_promise_renew_remark(String p_promise_renew_remark) {
		this.p_promise_renew_remark = p_promise_renew_remark;
	}


	@Override
	public String toString() {
		return "SemTySaSiteAppUpd [p_site_app_id=" + p_site_app_id + ", p_contract_id=" + p_contract_id
				+ ", p_contract_time=" + p_contract_time + ", p_contract_time_seq=" + p_contract_time_seq
				+ ", p_contract_no=" + p_contract_no + ", p_req_type=" + p_req_type + ", p_req_doc_type="
				+ p_req_doc_type + ", p_title=" + p_title + ", p_req_officer=" + p_req_officer
				+ ", p_req_officer_manual=" + p_req_officer_manual + ", p_company=" + p_company + ", p_region="
				+ p_region + ", p_doc_no=" + p_doc_no + ", p_doc_dt=" + p_doc_dt + ", p_doc_status=" + p_doc_status
				+ ", p_need_legal_approve=" + p_need_legal_approve + ", p_need_avp_approve=" + p_need_avp_approve
				+ ", p_location_id=" + p_location_id + ", p_location_zone=" + p_location_zone + ", p_is_co_locate="
				+ p_is_co_locate + ", p_co_contract_no=" + p_co_contract_no + ", p_terminate_reason="
				+ p_terminate_reason + ", p_terminate_remove_flag=" + p_terminate_remove_flag
				+ ", p_terminate_remove_dt=" + p_terminate_remove_dt + ", p_terminate_cancel_relate_data="
				+ p_terminate_cancel_relate_data + ", p_terminate_note=" + p_terminate_note + ", p_location_type="
				+ p_location_type + ", p_location_address_no=" + p_location_address_no + ", p_location_building="
				+ p_location_building + ", p_location_floor=" + p_location_floor + ", p_location_room_no="
				+ p_location_room_no + ", p_location_street=" + p_location_street + ", p_location_tambon="
				+ p_location_tambon + ", p_location_amphur_id=" + p_location_amphur_id + ", p_location_province_id="
				+ p_location_province_id + ", p_location_postcode=" + p_location_postcode + ", p_land_area="
				+ p_land_area + ", p_land_area_type=" + p_land_area_type + ", p_deck_area=" + p_deck_area
				+ ", p_deck_area_type=" + p_deck_area_type + ", p_building_area=" + p_building_area + ", p_room_area="
				+ p_room_area + ", p_area_remark=" + p_area_remark + ", p_effective_dt=" + p_effective_dt
				+ ", p_expire_dt=" + p_expire_dt + ", p_age_year=" + p_age_year + ", p_age_month=" + p_age_month
				+ ", p_age_day=" + p_age_day + ", p_contract_wanted=" + p_contract_wanted + ", p_promise_renew_time="
				+ p_promise_renew_time + ", p_promise_renew_period=" + p_promise_renew_period
				+ ", p_promise_renew_period_type=" + p_promise_renew_period_type + ", p_lessor_name=" + p_lessor_name
				+ ", p_lessor_house_no=" + p_lessor_house_no + ", p_lessor_building=" + p_lessor_building
				+ ", p_lessor_floor=" + p_lessor_floor + ", p_lessor_room_no=" + p_lessor_room_no + ", p_lessor_street="
				+ p_lessor_street + ", p_lessor_tambon=" + p_lessor_tambon + ", p_lessor_amphur_id="
				+ p_lessor_amphur_id + ", p_lessor_province_id=" + p_lessor_province_id + ", p_lessor_postcode="
				+ p_lessor_postcode + ", p_lessor_tax_id=" + p_lessor_tax_id + ", p_contact_name=" + p_contact_name
				+ ", p_contact_tel=" + p_contact_tel + ", p_contact_mobile=" + p_contact_mobile + ", p_contact_fax="
				+ p_contact_fax + ", p_contact_email=" + p_contact_email + ", p_rent_amt=" + p_rent_amt
				+ ", p_rent_period_type=" + p_rent_period_type + ", p_rent_detail=" + p_rent_detail
				+ ", p_rent_wht_type=" + p_rent_wht_type + ", p_rent_wht_rate=" + p_rent_wht_rate
				+ ", p_rent_wht_rate_mod=" + p_rent_wht_rate_mod + ", p_rent_service_amt=" + p_rent_service_amt
				+ ", p_rent_service_period_type=" + p_rent_service_period_type + ", p_rent_service_detail="
				+ p_rent_service_detail + ", p_rent_service_vat_type=" + p_rent_service_vat_type
				+ ", p_rent_service_wht_type=" + p_rent_service_wht_type + ", p_rent_service_wht_rate="
				+ p_rent_service_wht_rate + ", p_rent_service_wht_rate_mod=" + p_rent_service_wht_rate_mod
				+ ", p_rent_area_amt_memo=" + p_rent_area_amt_memo + ", p_rent_service_amt_memo="
				+ p_rent_service_amt_memo + ", p_rent_setup_amt_memo=" + p_rent_setup_amt_memo
				+ ", p_rent_other_amt_memo=" + p_rent_other_amt_memo + ", p_rent_special_amt_memo="
				+ p_rent_special_amt_memo + ", p_total_rent_service=" + p_total_rent_service
				+ ", p_rent_payment_period=" + p_rent_payment_period + ", p_rent_payment_period_oth="
				+ p_rent_payment_period_oth + ", p_rent_deposit_flag=" + p_rent_deposit_flag
				+ ", p_rent_deposit_bg_amt=" + p_rent_deposit_bg_amt + ", p_rent_deposit_bg_vat="
				+ p_rent_deposit_bg_vat + ", p_rent_deposit_cash_amt=" + p_rent_deposit_cash_amt
				+ ", p_rent_deposit_cash_vat=" + p_rent_deposit_cash_vat + ", p_rent_remark=" + p_rent_remark
				+ ", p_el_use_multi_resourse=" + p_el_use_multi_resourse + ", p_el_use_new_meter=" + p_el_use_new_meter
				+ ", p_el_use_old_meter=" + p_el_use_old_meter + ", p_el_use_owner=" + p_el_use_owner
				+ ", p_el_owner_type=" + p_el_owner_type + ", p_el_pay_on_package=" + p_el_pay_on_package
				+ ", p_el_package_period_type=" + p_el_package_period_type + ", p_el_pay_on_package_amt="
				+ p_el_pay_on_package_amt + ", p_el_pay_on_used=" + p_el_pay_on_used + ", p_el_unit_price="
				+ p_el_unit_price + ", p_el_vat_type=" + p_el_vat_type + ", p_el_remark=" + p_el_remark
				+ ", p_el_deposit_flag=" + p_el_deposit_flag + ", p_el_bg_deposit=" + p_el_bg_deposit
				+ ", p_el_bg_deposit_vat_type=" + p_el_bg_deposit_vat_type + ", p_el_cash_deposit=" + p_el_cash_deposit
				+ ", p_el_cash_deposit_vat_type=" + p_el_cash_deposit_vat_type + ", p_el_deposit_remark="
				+ p_el_deposit_remark + ", p_remark_special=" + p_remark_special + ", p_remark_documents="
				+ p_remark_documents + ", p_remark_contract=" + p_remark_contract + ", p_remark_aqm=" + p_remark_aqm
				+ ", p_remark_risk=" + p_remark_risk + ", p_remark_legal=" + p_remark_legal + ", p_remark_other="
				+ p_remark_other + ", p_pt_tax_pay_type=" + p_pt_tax_pay_type + ", p_pt_remark=" + p_pt_remark
				+ ", p_ins_flag=" + p_ins_flag + ", p_ins_sum_insured=" + p_ins_sum_insured + ", p_ins_effective_dt="
				+ p_ins_effective_dt + ", p_ins_expire_dt=" + p_ins_expire_dt + ", p_ins_beneficiary="
				+ p_ins_beneficiary + ", p_assign_dt=" + p_assign_dt + ", p_assign_by=" + p_assign_by
				+ ", p_assign_to_team=" + p_assign_to_team + ", p_assign_to_user=" + p_assign_to_user
				+ ", p_leader_approve_dt=" + p_leader_approve_dt + ", p_leader_approve_by=" + p_leader_approve_by
				+ ", p_leader_approve_status=" + p_leader_approve_status + ", p_leader_approve_remark="
				+ p_leader_approve_remark + ", p_manager_approve_dt=" + p_manager_approve_dt + ", p_manager_approve_by="
				+ p_manager_approve_by + ", p_manager_approve_status=" + p_manager_approve_status
				+ ", p_manager_approve_remark=" + p_manager_approve_remark + ", p_legal_approve_dt="
				+ p_legal_approve_dt + ", p_legal_approve_by=" + p_legal_approve_by + ", p_legal_approve_status="
				+ p_legal_approve_status + ", p_legal_approve_remark=" + p_legal_approve_remark + ", p_avp_approve_dt="
				+ p_avp_approve_dt + ", p_avp_approve_by=" + p_avp_approve_by + ", p_avp_approve_status="
				+ p_avp_approve_status + ", p_avp_approve_remark=" + p_avp_approve_remark + ", p_flow_status="
				+ p_flow_status + ", p_record_status=" + p_record_status + ", p_batch_no=" + p_batch_no
				+ ", p_batch_dt=" + p_batch_dt + ", p_location_edit_flag=" + p_location_edit_flag
				+ ", p_contract_edit_flag=" + p_contract_edit_flag + ", p_rent_edit_flag=" + p_rent_edit_flag
				+ ", p_rent_deposit_edit_flag=" + p_rent_deposit_edit_flag + ", p_el_edit_flag=" + p_el_edit_flag
				+ ", p_el_deposit_edit_flag=" + p_el_deposit_edit_flag + ", p_property_tax_edit_flag="
				+ p_property_tax_edit_flag + ", p_insurance_edit_flag=" + p_insurance_edit_flag + ", p_mail_edit_flag="
				+ p_mail_edit_flag + ", p_create_dt=" + p_create_dt + ", p_create_by=" + p_create_by + ", p_update_dt="
				+ p_update_dt + ", p_update_by=" + p_update_by + ", p_version=" + p_version + ", p_place_type="
				+ p_place_type + ", p_parties_type=" + p_parties_type + ", p_phase=" + p_phase
				+ ", p_terminate_cancel_contract_dt=" + p_terminate_cancel_contract_dt + ", p_terminate_remove_end_dt="
				+ p_terminate_remove_end_dt + ", p_co_locate_company=" + p_co_locate_company + ", p_location_code="
				+ p_location_code + ", p_location_name=" + p_location_name + ", p_construction_unneed="
				+ p_construction_unneed + ", p_contract_never_expire=" + p_contract_never_expire
				+ ", p_contract_wanted_remark=" + p_contract_wanted_remark + ", p_tower_type=" + p_tower_type
				+ ", p_tower_location=" + p_tower_location + ", p_tower_height=" + p_tower_height + ", p_rent_vat_type="
				+ p_rent_vat_type + ", p_rent_vat_rate=" + p_rent_vat_rate + ", p_rent_service_vat_rate="
				+ p_rent_service_vat_rate + ", p_remark_after_approve=" + p_remark_after_approve + ", p_rent_amt_old="
				+ p_rent_amt_old + ", p_rent_period_type_old=" + p_rent_period_type_old + ", p_rent_amt_add="
				+ p_rent_amt_add + ", p_rent_amt_add_perc=" + p_rent_amt_add_perc + ", p_rent_serv_amt_old="
				+ p_rent_serv_amt_old + ", p_rent_serv_period_type_old=" + p_rent_serv_period_type_old
				+ ", p_rent_serv_amt_add=" + p_rent_serv_amt_add + ", p_rent_serv_amt_add_perc="
				+ p_rent_serv_amt_add_perc + ", p_rent_deposit_bg_amt_old=" + p_rent_deposit_bg_amt_old
				+ ", p_rent_deposit_cash_amt_old=" + p_rent_deposit_cash_amt_old + ", p_rent_deposit_bg_amt_add="
				+ p_rent_deposit_bg_amt_add + ", p_rent_deposit_cash_amt_add=" + p_rent_deposit_cash_amt_add
				+ ", p_revenue=" + p_revenue + ", p_rent_area_memo_vat_type=" + p_rent_area_memo_vat_type
				+ ", p_rent_area_memo_wht_type=" + p_rent_area_memo_wht_type + ", p_rent_area_memo_wht_rate="
				+ p_rent_area_memo_wht_rate + ", p_rent_serv_memo_vat_type=" + p_rent_serv_memo_vat_type
				+ ", p_rent_serv_memo_wht_type=" + p_rent_serv_memo_wht_type + ", p_rent_serv_memo_wht_rate="
				+ p_rent_serv_memo_wht_rate + ", p_rent_setup_memo_vat_type=" + p_rent_setup_memo_vat_type
				+ ", p_rent_setup_memo_wht_type=" + p_rent_setup_memo_wht_type + ", p_rent_setup_memo_wht_rate="
				+ p_rent_setup_memo_wht_rate + ", p_rent_other_memo_vat_type=" + p_rent_other_memo_vat_type
				+ ", p_rent_other_memo_wht_type=" + p_rent_other_memo_wht_type + ", p_rent_other_memo_wht_rate="
				+ p_rent_other_memo_wht_rate + ", p_is_macro_type=" + p_is_macro_type + ", p_is_micro_type="
				+ p_is_micro_type + ", p_is_pico_type=" + p_is_pico_type + ", p_is_repeater_type=" + p_is_repeater_type
				+ ", p_is_tower_type=" + p_is_tower_type + ", p_is_wifi_type=" + p_is_wifi_type + ", p_is_other_type="
				+ p_is_other_type + ", p_is_other_type_detail=" + p_is_other_type_detail + ", p_contract_no_old="
				+ p_contract_no_old + ", p_is_smallcell_type=" + p_is_smallcell_type + ", p_co_company=" + p_co_company
				+ ", p_co_company_contract_no=" + p_co_company_contract_no + ", p_el_use_oth_site=" + p_el_use_oth_site
				+ ", p_el_use_oth_site_contract_no=" + p_el_use_oth_site_contract_no + ", p_re_locate_contract_no="
				+ p_re_locate_contract_no + ", p_is_fbb_type=" + p_is_fbb_type + ", p_is_ofc_type=" + p_is_ofc_type
				+ ", p_is_fttx_type=" + p_is_fttx_type + ", p_change_effective_dt=" + p_change_effective_dt
				+ ", p_service_payment_period=" + p_service_payment_period + ", p_service_payment_period_oth="
				+ p_service_payment_period_oth + ", p_el_deposit_bg_amt_old=" + p_el_deposit_bg_amt_old
				+ ", p_el_deposit_cash_amt_old=" + p_el_deposit_cash_amt_old + ", p_el_deposit_bg_amt_add="
				+ p_el_deposit_bg_amt_add + ", p_el_deposit_cash_amt_add=" + p_el_deposit_cash_amt_add
				+ ", p_el_no_expenses=" + p_el_no_expenses + ", p_no_rental=" + p_no_rental + ", p_save_flag="
				+ p_save_flag + ", p_legal_vat_type=" + p_legal_vat_type + ", p_co_operator=" + p_co_operator
				+ ", p_leasehold_rights=" + p_leasehold_rights + ", p_license=" + p_license + ", p_ll_rental_agreement="
				+ p_ll_rental_agreement + ", p_sa_site_type=" + p_sa_site_type + ", p_deck_area_unit_type="
				+ p_deck_area_unit_type + ", p_deck_area_width=" + p_deck_area_width + ", p_deck_area_long="
				+ p_deck_area_long + ", p_deck_area_other=" + p_deck_area_other + ", p_building_area_type="
				+ p_building_area_type + ", p_building_area_unit_type=" + p_building_area_unit_type
				+ ", p_building_area_width=" + p_building_area_width + ", p_building_area_long=" + p_building_area_long
				+ ", p_building_area_other=" + p_building_area_other + ", p_room_area_type=" + p_room_area_type
				+ ", p_room_area_unit_type=" + p_room_area_unit_type + ", p_room_area_width=" + p_room_area_width
				+ ", p_room_area_long=" + p_room_area_long + ", p_room_area_other=" + p_room_area_other
				+ ", p_land_area_unit_type=" + p_land_area_unit_type + ", p_land_area_width=" + p_land_area_width
				+ ", p_land_area_long=" + p_land_area_long + ", p_land_area_other=" + p_land_area_other
				+ ", p_place_type_other=" + p_place_type_other + ", p_doc_type_other=" + p_doc_type_other
				+ ", p_doc_location_address_no=" + p_doc_location_address_no + ", p_doc_location_building="
				+ p_doc_location_building + ", p_doc_location_floor=" + p_doc_location_floor
				+ ", p_doc_location_street=" + p_doc_location_street + ", p_doc_location_tambon="
				+ p_doc_location_tambon + ", p_doc_location_amphur_id=" + p_doc_location_amphur_id
				+ ", p_doc_location_province_id=" + p_doc_location_province_id + ", p_doc_location_postcode="
				+ p_doc_location_postcode + ", p_ch_effect_dt_contract=" + p_ch_effect_dt_contract
				+ ", p_lessor_title_name=" + p_lessor_title_name + ", p_lessor_birthday=" + p_lessor_birthday
				+ ", p_contract_title_name=" + p_contract_title_name + ", p_contract_id_card=" + p_contract_id_card
				+ ", p_contract_birthday=" + p_contract_birthday + ", p_contract_address_no=" + p_contract_address_no
				+ ", p_contract_building=" + p_contract_building + ", p_contract_floor=" + p_contract_floor
				+ ", p_contract_room_no=" + p_contract_room_no + ", p_contract_street=" + p_contract_street
				+ ", p_contract_tambon=" + p_contract_tambon + ", p_contract_amphur_id=" + p_contract_amphur_id
				+ ", p_contract_province_id=" + p_contract_province_id + ", p_contract_postcode=" + p_contract_postcode
				+ ", p_owner_title_name=" + p_owner_title_name + ", p_doc_type=" + p_doc_type + ", p_el_use_other="
				+ p_el_use_other + ", p_lessor_tel=" + p_lessor_tel + ", p_lessor_mobile=" + p_lessor_mobile
				+ ", p_lessor_fax=" + p_lessor_fax + ", p_lessor_email=" + p_lessor_email + ", p_no_deposit_rent="
				+ p_no_deposit_rent + ", p_no_deposit_elec=" + p_no_deposit_elec + ", p_owner_name=" + p_owner_name
				+ ", p_owner_category=" + p_owner_category + ", p_station_type=" + p_station_type
				+ ", p_owner_sub_category=" + p_owner_sub_category + ", p_emer_contact_name=" + p_emer_contact_name
				+ ", p_emer_contact_phone=" + p_emer_contact_phone + ", p_renew_rent_flag=" + p_renew_rent_flag
				+ ", p_renew_rent_percent=" + p_renew_rent_percent + ", p_promise_renew_remark="
				+ p_promise_renew_remark + "]";
	}


	public String getJsonData() {
		return jsonData;
	}


	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}


	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public java.util.Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setCreateDt(java.util.Date createDt) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public java.util.Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setUpdateDt(java.util.Date updateDt) {
		// TODO Auto-generated method stub
		
	}

	

	/*
	 * @Override public String toString() { return "SemTySaSiteAppUpd [id=" + id +
	 * ", name=" + name + ", create_date=" + create_date + ", salary=" + salary +
	 * "]"; }
	 */
/*
	
	public String getSQLTypeName() throws SQLException {
		// TODO Auto-generated method stub
		return typeName1;
	}
	
	
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		    typeName1 = typeName;
		    id = stream.readInt();
	        name = stream.readString();
	        create_date = stream.readDate();
	        salary = stream.readBigDecimal();
		
	}

	public void writeSQL(SQLOutput stream) throws SQLException {
		    stream.writeInt(id);
	        stream.writeString(name);
	        stream.writeDate(create_date);
	        stream.writeBigDecimal(salary);
		
	}
*/

}
