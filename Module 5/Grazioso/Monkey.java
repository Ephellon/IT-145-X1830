public class Monkey extends RescueAnimal {
   // Instance variables
   private String breed;
   public final static String[] VALID_BREEDS = {
      "Capuchin",
      "Guenon",
      "Macaque",
      "Marmoset",
      "Squirrel monkey",
      "Tamarin"
   };

   // Constructor
   public Monkey(
      String name, String breed, String gender, String age,
      String weight, String acquisitionDate, String acquisitionCountry,
      String trainingStatus, boolean reserved, String inServiceCountry
   ) {
      setName(name);
      setBreed(breed);
      setGender(gender);
      setAge(age);
      setWeight(weight);
      setAcquisitionDate(acquisitionDate);
      setAcquisitionLocation(acquisitionCountry);
      setTrainingStatus(trainingStatus);
      setReserved(reserved);
      setInServiceCountry(inServiceCountry);
   }

   // Accessor methods
   public String getBreed() {
      return breed;
   }

   // Mutator methods
   public void setBreed(String monkeyBreed) {
      breed = monkeyBreed;
   }
}
