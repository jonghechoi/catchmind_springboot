package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class FacilityDto {
	int parking, valet, corkage, adultonly, sommelier, lettering, rentals;
	String sid, parkingdesc, valetdesc, corkagedesc, adultonlydesc, sommelierdesc, letteringdesc, rentalsdesc;
}
