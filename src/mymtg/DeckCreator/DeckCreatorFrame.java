/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymtg.DeckCreator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Piotr Turliński
 */
public class DeckCreatorFrame extends JFrame {
    
    public static final int DEFAULT_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int DEFAULT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static final int CARD_WIDTH = 223;
    public static final int CARD_HEIGHT = 311;
    
    
    public DeckCreatorFrame()
    {
        super.setTitle("MyMTG");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Create mainPanel(all components will be add here) with GridBagLayout
        JPanel mainPanel = new JPanel();        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();        
        mainPanel.setLayout(gridbag);
        super.add(mainPanel);
        
        super.setMinimumSize(new Dimension(DEFAULT_WIDTH / 2, DEFAULT_HEIGHT / 2));
        int mainPanelWidth = super.getWidth();
        int mainPanelHeight = super.getHeight();
        System.out.println(mainPanelWidth);
        
        //Create imagePanel
        JPanel imagePanel = new JPanel();
        GridBagLayout gridbagImage = new GridBagLayout();
        imagePanel.setLayout(gridbagImage);
        imagePanel.setPreferredSize(new Dimension(CARD_WIDTH, (int)(mainPanelHeight * 0.8)));
        
        //Create emptyPanel
        JPanel emptyPanel = new JPanel();
        
        //Create cardsList with ScrollPane.
        String[] cardsListNames = {"Name", "Mana Costs", "Card Type", "P/T", "Rarity", "Set"};
        CardListModel cardsListModel = new CardListModel("Ixalan");
        DefaultTableModel cardsTableModel = new DefaultTableModel(cardsListNames,0);
        int iter = 0;
        for(Card c : cardsListModel.arrayList)
        {
            cardsTableModel.addRow(cardsListModel.getRow(iter));
            iter++;
        }
        JTable cardsList = new JTable(cardsTableModel);
        cardsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        RowSorter<DefaultTableModel> sorter = new TableRowSorter<>(cardsTableModel);
        sorter.toggleSortOrder(0);
        cardsList.setRowSorter(sorter);
        JScrollPane scrollPaneCardsList = new JScrollPane(cardsList);

        //Create deckList
        String[] deckListNames = {"Name", "Mana Costs", "Card Type", "P/T", "Rarity", "Set"};
        CardListModel deckListModel = new CardListModel("DeckList");
        DefaultTableModel deckTableModel = new DefaultTableModel(deckListNames,0);
        iter = 0;
        for(Card c : deckListModel.arrayList)
        {
            deckTableModel.addRow(deckListModel.getRow(iter));
            iter++;
        }
        JTable deckList = new JTable(deckTableModel);
        deckList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<>(deckTableModel);
        sorter.toggleSortOrder(0);
        deckList.setRowSorter(sorter);
        JScrollPane scrollPaneDeckList = new JScrollPane(deckList);
        
        //Create sideboardList
        String[] sideboardNames = {"Name", "Mana Costs", "Card Type", "P/T", "Rarity", "Set"};
        CardListModel sideboardModel = new CardListModel("SideboardList");
        DefaultTableModel sideboardTableModel = new DefaultTableModel(sideboardNames,0);
        iter = 0;
        for(Card c : sideboardModel.arrayList)
        {
            sideboardTableModel.addRow(sideboardModel.getRow(iter));
            iter++;
        }
        JTable sideboardList = new JTable(sideboardTableModel);
        sideboardList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<>(sideboardTableModel);
        sorter.toggleSortOrder(0);
        sideboardList.setRowSorter(sorter);
        
        
        JScrollPane scrollPaneSideboardList = new JScrollPane(sideboardList);
        scrollPaneSideboardList.setMaximumSize(new Dimension((mainPanelWidth - CARD_WIDTH) / 2,(int) (mainPanelHeight * 0.47)));
        
        //Create cardImageViewer. Card picture is seen here.
        JLabel cardImageViewer = new JLabel();
        cardImageViewer.setPreferredSize(new Dimension(CARD_WIDTH,CARD_HEIGHT));
        cardImageViewer.setIcon(new ImageIcon(getClass().getResource("/resources/Images/Ixalan/Air Elemental.jpg")));
        
        //Create cardDescriptionArea
        JTextArea cardDescriptionArea = new JTextArea();
        cardDescriptionArea.setPreferredSize(new Dimension(CARD_WIDTH, mainPanelHeight / 4));
        cardDescriptionArea.setBorder(BorderFactory.createLineBorder(Color.black));
    
        //Create Buttons
        JButton addToDeck = new JButton("Add to deck");
        addToDeck.addActionListener(event ->
        {
            int iterator = 0;
            deckTableModel.addRow(cardsListModel.getRow(cardsList.getSelectedRow()));
        });
        JButton removeFromDeck = new JButton("Remove from deck");
        JButton addToSideboard = new JButton("Add to sideboard");
        addToSideboard.addActionListener(event ->
        {
            sideboardTableModel.addRow(cardsListModel.getRow(cardsList.getSelectedRow()));
        });
        JButton removeFromSideboard = new JButton("Remove from sideboard");
                               
        
        //Add ImageViewer to imagePanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.gridheight = 3;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        gridbagImage.setConstraints(cardImageViewer, constraints);
        imagePanel.add(cardImageViewer);
        
        //Add cardDescriptionArea to imagePanel
        constraints.insets = new Insets(20,0,20,0);
        gridbagImage.setConstraints(cardDescriptionArea, constraints);
        imagePanel.add(cardDescriptionArea);
        
        //Add buttons to imagePanel
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridheight = 1;
        gridbagImage.setConstraints(addToDeck, constraints);
        imagePanel.add(addToDeck);
        gridbagImage.setConstraints(removeFromDeck, constraints);
        imagePanel.add(removeFromDeck);
        gridbagImage.setConstraints(addToSideboard, constraints);
        imagePanel.add(addToSideboard);
        gridbagImage.setConstraints(removeFromSideboard, constraints);
        imagePanel.add(removeFromSideboard);      
 
        //Add emptyPanel to imagePanel
        constraints.weighty = 1.0;
        gridbagImage.setConstraints(emptyPanel, constraints);
        imagePanel.add(emptyPanel);
        
        //Add CardsList to mainPanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.gridwidth = 1;
        constraints.gridheight = 10;
        constraints.weighty = 1.0;
        constraints.weightx = 1.0;
        gridbag.setConstraints(scrollPaneCardsList, constraints);
        mainPanel.add(scrollPaneCardsList); 
        
        //Add imagePanel to mainPanel
        constraints.gridwidth = 1;
        constraints.gridwidth = 10;
        constraints.weightx = 0.0;
        gridbag.setConstraints(imagePanel, constraints);
        mainPanel.add(imagePanel);
        
        //Add deckList to mainPanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 5;
        constraints.weightx = 1.0;
        gridbag.setConstraints(scrollPaneDeckList, constraints);
        mainPanel.add(scrollPaneDeckList);
        

        
        
        //Add sideboardList to mainPanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 5;
        gridbag.setConstraints(scrollPaneSideboardList, constraints);
        mainPanel.add(scrollPaneSideboardList);
        
    } 
}

/**
 * Background panel. All components will be add here.
 * @author Piotr Turliński
 */

class backgroundPanel extends JPanel
{
    private Image background;
    
    public backgroundPanel()
    {
        super();
    }
    
    /**
     * Backgroundscalling.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent( g );
        URL aboutURL = getClass().getResource("/resources/Images/GreenBackground.jpg");
        ImageIcon icon = new ImageIcon(aboutURL);
        //ImageIcon icon = new ImageIcon("\\src\\resources\\Images\\GreenBackground.jpg");
        background = icon.getImage();
        background = background.getScaledInstance(DeckCreatorFrame.DEFAULT_WIDTH, DeckCreatorFrame.DEFAULT_HEIGHT, Image.SCALE_SMOOTH);
        icon = new ImageIcon(background);
        background = icon.getImage();
        if (background != null)
                g2.drawImage(background, 0, 0, this);  
    }
}

