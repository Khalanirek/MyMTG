/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymtg.DeckCreator;

import javax.swing.ImageIcon;

/**
 * A model of the card object in MVC pattern
 * @author Piotr Turliński
 */
public class Card {
    
    private String name;
    private String manaCost;
    private String type;
    private int attack;
    private int defence;
    private String rarity;
    private String set;
    private ImageIcon picture;
    
    
    
    public Card(String name,String manaCost, String type, int attack, int defence, String rarity, String set, ImageIcon picture)
    {
        this.name = name;
        this.manaCost = manaCost;
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.rarity = rarity;
        this.set = set;
        this.picture = picture;
    }
    
    /**
     * Method sets card name.
     * @param name card name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Method returns card's name.
     * @return card name
     */
    public String getName()
    {
        return name;
        
    }
    
     /**
     * Sets manaCost.
     * @param manaCost 
     */
       public void setManaCost(String manaCost)
    {
        this.manaCost = manaCost;
    }
    
    /**
     * Returns manaCost.
     * @return 
     */
    public String getManaCost()
    {
        return manaCost;
    }
    
     /**
     * Sets cards type.
     * @param type 
     */
       public void setType(String type)
    {
        this.type = type;
    }
    
    /**
     * Returns cards type.
     * @return 
     */
    public String getType()
    {
        return type;
    }
    /**
     * Method sets the attack field.
     * @param attack 
     */
    public void setAttack(int attack)
    {
        this.attack = attack;
    }
    
    /**
     * Method returns value of the attack field.
     * @return attack
     */
    public int getAttack()
    {
        return attack;
    }
    
    /**
     * Method sets the defence field.
     * @param defence 
     */
    public void setDefence(int defence)
    {
        this.defence = defence;
    }
    
    /**
     * Method returns value of the defence field.
     * @return 
     */
    public int getDefence()
    {
        return defence;
    }
   
     /**
     * Sets rarity.
     * @param rarity 
     */
    public void setRarity(String rarity)
    {
        this.rarity = rarity;
    }
    
    /**
     * Returns rarity.
     * @return 
     */
    public String getRarity()
    {
        return rarity;
    }
    
     /**
     * Sets set
     * @param set 
     */
    public void setSet(String set)
    {
        this.set = set;
    }
    
    /**
     * Returns set.
     * @return 
     */
    public String getSet()
    {
        return set;
    }
    /**
     * Method sets card's picture.
     * @param picture 
     */
    public void setPicture(ImageIcon picture)
    {
        this.picture = picture;
    }
    
    /**
     * Method returns card's picture.
     * @return 
     */
    public ImageIcon getPicture()
    {
        return picture;
    }
    
}
