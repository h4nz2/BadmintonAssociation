/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation;

/**
 *
 * @author Honza
 */
public class Enum {
    public static enum Gender {
        MALE,
        FEMALE;

        // Gender.values()[x] is supposedly expensive
        public static Gender fromInteger(int x) {
            switch(x) {
                case 0:
                    return MALE;
                case 1:
                    return FEMALE;
                default:
                    return MALE;
            }
        }
    }
}
