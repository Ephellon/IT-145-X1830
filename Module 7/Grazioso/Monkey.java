public class Monkey extends RescueAnimal {
   // Instance variables
   private String species;
   private String height;
   private String tailLength;
   private String bodyLength;

   public final static String[] VALID_SPECIES = {
      "Capuchin",
      "Guenon",
      "Macaque",
      "Marmoset",
      "Squirrel monkey",
      "Tamarin"
   };

   // Constructor
   public Monkey(
      String name, String species, String gender, String age,
      String weight, String height, String bodyLength, String tailLength,
      String acquisitionDate, String acquisitionCountry,
      String trainingStatus, boolean reserved, String inServiceCountry
   ) {
      setName(name);
      setSpecies(species);
      setGender(gender);
      setAge(age);
      setWeight(weight);
      setHeight(height);
      setBodyLength(bodyLength);
      setTailLength(tailLength);
      setAcquisitionDate(acquisitionDate);
      setAcquisitionLocation(acquisitionCountry);
      setTrainingStatus(trainingStatus);
      setReserved(reserved);
      setInServiceCountry(inServiceCountry);
   }

   // Accessor methods
   public String getSpecies() {
      return species;
   }

   public String getHeight() {
      return height;
   }

   public String getTailLength() {
      return tailLength;
   }

   public String getBodyLength() {
      return bodyLength;
   }

   // Mutator methods
   public void setSpecies(String monkeySpecies) {
      species = monkeySpecies;
   }

   public void setHeight(String monkeyHeight) {
      height = monkeyHeight;
   }

   public void setTailLength(String monkeyTailLength) {
      tailLength = monkeyTailLength;
   }

   public void setBodyLength(String monkeyBodyLength) {
      bodyLength = monkeyBodyLength;
   }
}
