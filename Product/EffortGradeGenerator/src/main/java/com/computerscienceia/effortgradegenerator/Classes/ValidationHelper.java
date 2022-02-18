/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

/**
 *
 * @author adithyanarayanan
 */
public class ValidationHelper {
    public static boolean isAlpha(String s) {
        return s != null && s.chars().allMatch(Character::isLetter);
    }
}
