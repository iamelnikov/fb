package com.ee.fb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * A PersonalData.
 */
@Document(collection = "PERSONALDATA")
public class PersonalData implements Serializable {

    @Id
    private String id;

    @Field("last_name")
    private String lastName;

    @Field("first_name")
    private String firstName;

    @Field("middle_name")
    private String middleName;

    @Field("birth_date")
    private Date birthDate;

    @Field("birth_place")
    private String birthPlace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonalData personalData = (PersonalData) o;

        if ( ! Objects.equals(id, personalData.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "id=" + id +
                ", lastName='" + lastName + "'" +
                ", firstName='" + firstName + "'" +
                ", middleName='" + middleName + "'" +
                ", birthDate='" + birthDate + "'" +
                ", birthPlace='" + birthPlace + "'" +
                '}';
    }
}
