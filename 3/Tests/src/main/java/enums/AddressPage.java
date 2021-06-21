package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressPage implements BaseHtmlId {

    POSTCODE("postcode"),
    COUNTRY_IN("countryIn"),
    REGION_IN("regionIn"),
    DISTRICT_IN("districtIn"),
    CITY_IN("cityIn"),
    STREET_IN("streetIn"),
    HOUSE_IN("houseIn"),
    BUILDING_IN("buildingIn"),
    APARTMENT_IN("apartmentIn"),
    PHONE("phone");

    private final String htmlId;
}
