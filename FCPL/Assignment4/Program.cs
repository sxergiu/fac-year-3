
using Assignment4;

RealEstateAgency realEstateAgency = new RealEstateAgency();

Property house = new House("cucului 33",300,2000,200);
Property apartment = new Apartment("johnului nr1",150,1500,4,true);
Property rentableApartment = new RentableApartment("negrilor 4A",130,1200,1,false,200);

realEstateAgency.AddProperty(house);
realEstateAgency.AddProperty(apartment);
realEstateAgency.AddProperty(rentableApartment);

realEstateAgency.RentProperty(rentableApartment.Address);
realEstateAgency.RentProperty(apartment.Address);
realEstateAgency.RentProperty(rentableApartment.Address);
realEstateAgency.RentProperty(house.Address);

