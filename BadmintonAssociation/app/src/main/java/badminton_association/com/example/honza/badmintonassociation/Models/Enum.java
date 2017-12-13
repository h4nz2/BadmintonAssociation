package badminton_association.com.example.honza.badmintonassociation.Models;

/**
 * Created by Honza on 13/12/2017.
 */

public class Enum {
    public enum Gender {
        MALE,
        FEMALE;

        // Gender.values()[x] is supposedly expensive
        public static Gender fromInteger(int x) {
            switch(x) {
                case 0:
                    return MALE;
                case 1:
                    return FEMALE;
            }
            return null;
        }
    }
}
