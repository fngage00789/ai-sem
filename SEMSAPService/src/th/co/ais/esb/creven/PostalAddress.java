package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PostalAddress {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlElement(name = "CountryCode")
    private String countryCode;

    @XmlElement(name = "RegionCode")
    private String regionCode;

    @XmlElement(name = "CityName")
    private String cityName;

    @XmlElement(name = "AdditionalCityName")
    private String additionalCityName;

    @XmlElement(name = "DistrictName")
    private String districtName;

    @XmlElement(name = "StreetPostalCode")
    private String streetPostalCode;

    @XmlElement(name = "POBoxPostalCode", nillable = true)
    private String poBoxPostalCode;

    @XmlElement(name = "StreetPrefixName")
    private String streetPrefixName;

    @XmlElement(name = "TimeZoneCode")
    private String timeZoneCode;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAdditionalCityName() {
		return additionalCityName;
	}

	public void setAdditionalCityName(String additionalCityName) {
		this.additionalCityName = additionalCityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getStreetPostalCode() {
		return streetPostalCode;
	}

	public void setStreetPostalCode(String streetPostalCode) {
		this.streetPostalCode = streetPostalCode;
	}

	public String getPoBoxPostalCode() {
		return poBoxPostalCode;
	}

	public void setPoBoxPostalCode(String poBoxPostalCode) {
		this.poBoxPostalCode = poBoxPostalCode;
	}

	public String getStreetPrefixName() {
		return streetPrefixName;
	}

	public void setStreetPrefixName(String streetPrefixName) {
		this.streetPrefixName = streetPrefixName;
	}

	public String getTimeZoneCode() {
		return timeZoneCode;
	}

	public void setTimeZoneCode(String timeZoneCode) {
		this.timeZoneCode = timeZoneCode;
	}
}
