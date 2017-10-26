/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymtg.DeckCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import mymtg.MyMTG;

/**
 * Model of cardList
 * @author Piotr Turliński
 */
public class CardListModel {
    
    ArrayList<Card> arrayList;
    
    public CardListModel(String dataFileName)
    {
        arrayList = readData(dataFileName);
    }
    
    
    public ArrayList<Card> readData(String dataFileName)
    {
        ArrayList<Card> dataList = new ArrayList<>();
        
        String line;
        String[] dataString;
        int lineCount = 0;
        
        InputStream file = MyMTG.class.getResourceAsStream("/resources/txt/" + dataFileName + ".txt");
        System.out.println(file);
        try(Scanner in = new Scanner(file);)
        {
            //Scanner in = new Scanner(file);
            while(in.hasNext())
            {
                line = in.nextLine();
                dataString = line.trim().split("\t");

                String[] attackDefence = dataString[3].split("/");
                try
                {
                    ImageIcon image = new ImageIcon(getClass().getResource("/resources/Images/" + dataString[5] + "/" + dataString[0] + ".jpg").getPath());
                    if (attackDefence[0].equals("N"))
                        attackDefence[0] = "0";
                    if (attackDefence[1].equals("A"))
                        attackDefence[1] = "0";
                    Card card = new Card(dataString[0] ,dataString[1],dataString[2],Integer.parseInt(attackDefence[0]),Integer.parseInt(attackDefence[1]),dataString[4], dataString[5], image);
                    lineCount++;
                    dataList.add(card);
                }
                catch(NullPointerException e)
                {
                    System.out.println(dataString[0]);
                }
                
            }
        }
       //catch(FileNotFoundException e)
       // {
            System.out.println("File not found: " + dataFileName);
       // }
        return dataList;
    }
    
    public String[] getRow(int rowIndex)
    {
        return new String[] {arrayList.get(rowIndex).getName(), arrayList.get(rowIndex).getManaCost(),
            arrayList.get(rowIndex).getType(), Integer.toString(arrayList.get(rowIndex).getAttack()) + "/"
                + Integer.toString(arrayList.get(rowIndex).getDefence()), arrayList.get(rowIndex).getRarity(), arrayList.get(rowIndex).getSet()};
    }
}
