package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Andrei.Apostol on 7/12/2017.
 */

//city (String), stateProvince (String);
//        -	generate getters and setters for fields above(ALT+INSERT -> Getter and Setter -> select all fields -> OK;
//        -	override methods equals() and toString() (ALT+INSRT-> select equals()/toString()
//        -> select all fields -> OK
//        -	annotate columns defined and the entity with the correct annotation
@Table
public class Location {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Id(name="location_id")
    private Long id;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="city")
    private String city;

    @Column(name="state_province")
    private String stateProvince;


    @Column(name="street_address")
    private String streetAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (!id.equals(location.id)) return false;
        if (postalCode != null ? !postalCode.equals(location.postalCode) : location.postalCode != null) return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        if (stateProvince != null ? !stateProvince.equals(location.stateProvince) : location.stateProvince != null)
            return false;
        return streetAddress != null ? streetAddress.equals(location.streetAddress) : location.streetAddress == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                '}';
    }
}
