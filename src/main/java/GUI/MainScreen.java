package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.speech.EngineException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import TTS.SpeechUtils;

public class MainScreen implements ActionListener{
	
	JFrame frame;
	private MyPanel panel1;
    private MyPanel2 panel2;
	JMenuBar menuBar;    
	JMenu file,database,help;    
	JMenuItem showDatabase,clearDatabase,exit,refresh,searchManually,info; 
	JTabbedPane tabbedPane;
	
	public void addFileItems(){
		
		exit = new JMenuItem("Exit");
		refresh = new JMenuItem("Refresh");
		searchManually = new JMenuItem("Search");
		
		exit.addActionListener(this);
		refresh.addActionListener(this);
		searchManually.addActionListener(this);
		
		file = new JMenu("File");
		
		file.add(searchManually);
		file.add(refresh);
		file.add(exit);
		
		menuBar.add(file);
	}
	
	/*public void addDatabaseItems() {
		
		showDatabase = new JMenuItem("Show Database");    
		clearDatabase = new JMenuItem("Clear Database");
		
		showDatabase.addActionListener(this);    
		clearDatabase.addActionListener(this);   
		
		database = new JMenu("Database");
		
		database.add(showDatabase);
		database.add(clearDatabase); 
		
		menuBar.add(database);
	}*/
	
	public void addHelpItems(){
		
		info = new JMenuItem("Information");
		
		info.addActionListener(this);
		
		help = new JMenu("Help");     
		
		help.add(info);
		
		menuBar.add(help);
	}
	
	public void addPanel3(JPanel panel){
		
		panel.setLayout(null);
		Insets insets = panel.getInsets();
		
		//Slider1
		
		JLabel label = new JLabel("PITCH");
		
		Dimension size = label.getPreferredSize();
		label.setBounds( 30 + insets.left,30 + insets.top,
                size.width + 20, size.height + 20);
    	panel.add(label);
    	
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 300, SpeechUtils.getChangedValues()[0].intValue()); 
		size = slider.getPreferredSize();
		
        slider.setBounds(140 + insets.left, 30 + insets.top,
                size.width + 60, size.height + 30);
        
		slider.setMinorTickSpacing(10);  
		slider.setMajorTickSpacing(50);  
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true);  
		  
		panel.add(slider);  
		
		//Slider2
		JLabel label1 = new JLabel("SPEED");
		
		size = label1.getPreferredSize();
		label1.setBounds(30 + insets.left,100 + insets.top,
                size.width + 60, size.height + 30);
    	panel.add(label1);
    	
		JSlider slider1 = new JSlider(JSlider.HORIZONTAL, 100, 200, SpeechUtils.getChangedValues()[2].intValue()); 
		size = slider1.getPreferredSize();
		
        slider1.setBounds(140 + insets.left, 100 + insets.top,
                size.width + 60, size.height + 30);
        
		slider1.setMinorTickSpacing(10);  
		slider1.setMajorTickSpacing(20);  
		slider1.setPaintTicks(true);  
		slider1.setPaintLabels(true);  
		  
		panel.add(slider1);  
		//Slider3
		
		JLabel label3 = new JLabel("VOLUME");
		
		size = label3.getPreferredSize();
		label3.setBounds(30 + insets.left,170 + insets.top,
                size.width + 60, size.height + 30);
    	panel.add(label3);
    	
		JSlider slider3 = new JSlider(JSlider.HORIZONTAL, 0, 2, SpeechUtils.getChangedValues()[1].intValue()); 
		size = slider3.getPreferredSize();
		
        slider3.setBounds(140 + insets.left, 170 + insets.top,
                size.width + 60, size.height + 30);
        
		slider3.setMinorTickSpacing(1);  
		slider3.setMajorTickSpacing(1);  
		slider3.setPaintTicks(true);  
		slider3.setPaintLabels(true);  
		  
		panel.add(slider3);  
		
		//RadioButton
		
		JLabel label4 = new JLabel("CHOOSE VOICE");
		
		size = label4.getPreferredSize();
		label4.setBounds(30 + insets.left,240 + insets.top,
                size.width + 60, size.height + 30);
    	panel.add(label4);
    	
		JRadioButton r1=new JRadioButton("KEVIN");    
		JRadioButton r2=new JRadioButton("KEVIN16"); 
		if(SpeechUtils.getChangedValues()[3].intValue() == 1){
			r1.setSelected(true);
		}
		else{
			r2.setSelected(true);
		}
		r1.setBounds(140 + insets.left, 240 + insets.top,
                size.width, size.height + 30);    
		r2.setBounds(240 + insets.left, 240 + insets.top,
                size.width + 60, size.height + 30);;    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);    
		panel.add(r1);panel.add(r2);  
		
		//JButton
		
		JButton save = new JButton ("SAVE");
   	 	panel.add(save);
   	 
        size = save.getPreferredSize();
    	
        save.setBounds(280 + insets.left, 310 + insets.top,
                size.width + 35, size.height + 10);
        
        save.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	float pitch = slider.getValue();
            	float Speed = slider1.getValue();
            	float Volume = slider3.getValue();
            	int voice = bg.getButtonCount();
            	SpeechUtils.changeValues(pitch, Volume, Speed, voice);
            }
            
        });
      //JButton
		
      		JButton cancel = new JButton ("CANCEL");
         	panel.add(cancel);
         	 
         	size = cancel.getPreferredSize();
          	
         	cancel.setBounds(140 + insets.left, 310 + insets.top,
                      size.width + 20, size.height + 10);
              
         	cancel.addActionListener( new ActionListener()
            {
         		public void actionPerformed(ActionEvent e)
                {
         			tabbedPane.setSelectedIndex(0);
                }
                  
            });
		
	}
	public void addPanel4(JPanel panel){
		panel.setLayout(null);
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		Insets insets = panel.getInsets();
		
		textArea.setBounds(20 + insets.left, insets.top + 10,
	               450,100);
		textArea.setText("This is a system implemented for users to ask any news related query they have and get real-time "
				+ "worldwide news as output.Users can listen to the news and if not satisfied, listen to "
				+ "other related news also.Users also have the provision to read the news, according to their "
				+ "needs.The system provides facilities for the user to adjust volume, pitch etc");
		
		textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
		
	}
	void displayGUI(int tabNumber)
    {
		frame = new JFrame();
		menuBar = new JMenuBar(); 
		
		addFileItems();
		//addDatabaseItems();
		addHelpItems();
		
		frame.add(menuBar);
		frame.setJMenuBar(menuBar);  
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel(); 
        JPanel panel3 = new JPanel();  
        addPanel3(panel3);
	    JPanel panel4 = new JPanel();
	    addPanel4(panel4);
	    
	    contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        panel1 = new MyPanel(contentPane,frame);
        try {
			panel2 = new MyPanel2(contentPane,frame);
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        contentPane.add(panel1, "Panel 1"); 
        contentPane.add(panel2, "Panel 2");
        
	    tabbedPane = new JTabbedPane();  
	    
	    tabbedPane.setBounds(5,5,590,590);  
	    
	    tabbedPane.add("Speak",contentPane);  
	    tabbedPane.add("Settings",panel3);  
	    tabbedPane.add("Information",panel4);
	    
	    frame.add(tabbedPane);  
	    
	    tabbedPane.setSelectedIndex(tabNumber);
	    
	    frame.setSize(500, 500);
        frame.setVisible(true);
    }
	
	public void actionPerformed(ActionEvent e) {    
		
		if(e.getSource()==info)    
		{
			tabbedPane.setSelectedIndex(2);
		}  
		if(e.getSource()==exit)    
		{
			frame.dispose();
		}
		if(e.getSource()==searchManually)    
		{
			JOptionPane.showMessageDialog(null, "Search Clicked");
		}
		if(e.getSource()==refresh)    
		{
			frame.dispose();
			SwingUtilities.invokeLater(new Runnable()
	        {
	            public void run()
	            {
	                new MainScreen().displayGUI(0);
	            }
	        });
		}
	}   

}
