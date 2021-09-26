public class Dog extends Pet {
   private int dogSpaceNumber;
   private int dogWeight;
   private boolean grooming;

   public Dog() {
      this.dogSpaceNumber = -1;
      this.dogWeight = -1;
      this.grooming = false;
   }

   // Grooming
   public boolean getGrooming() {
      return this.grooming;
   }

   public void setGrooming(boolean groom) {
      this.grooming = groom;
   }

   // Weight
   public int getDogWeight() {
      return this.dogWeight;
   }

   public void setDogWeight(int weight) {
      this.dogWeight = weight;
   }

   // Space ID
   public int getDogSpaceNumber() {
      return this.dogSpaceNumber;
   }

   public void setDogSpaceNumber(int spaceID) {
      this.dogSpaceNumber = spaceID;
   }

   // Main
   public static void main(String[] args) {
      return;
   }
}
