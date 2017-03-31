package GUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.speech.EngineException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import NLP.POSTagger;
import STT.GetOutputFromLog;
import TTS.SpeechUtils;

@SuppressWarnings("serial")
class MyPanel extends JPanel 
{
    private JButton jcomp4,record,next,speak;
    private JTextField textArea;
    private String input;
    public static List<String[]> list;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JScrollPane scroll;
    private JLabel label;
    private JLabel label1;
    public int i = 0 ;
    
    public void addRecordButton(JPanel panel){
    	
    	record = new JButton("RECORD");
    	panel.add(record);
    	
    	Insets insets = panel.getInsets();
        Dimension size = record.getPreferredSize();
    	
        record.setBounds(180 + insets.left, 10 + insets.top,
                size.width + 30, size.height + 10);
        
    	record.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	GetOutputFromLog generate = new GetOutputFromLog();
            	input = generate.generateLog()[0];
            	jcomp4.setVisible(true);
            	textArea.setVisible(true);
            	textArea.setText(input);
            }
        });
    	
    }
    
    public void addSearchButton(JPanel panel){
    
    	 jcomp4 = new JButton ("SEARCH");
    	 panel.add(jcomp4);
    	 
    	 Insets insets = panel.getInsets();
         Dimension size = jcomp4.getPreferredSize();
     	
         jcomp4.setBounds(180 + insets.left, 120 + insets.top,
                 size.width + 30, size.height + 10);
         
         jcomp4.addActionListener( new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 try {
                	 
                	 POSTagger tagger = new POSTagger();
                	 list = tagger.POSTag(input);	
                	 
                	 scroll.setVisible(true);
                	 label.setVisible(true);
                	 label1.setVisible(true);
                	 next.setVisible(true);
                	 speak.setVisible(true);
                	 
                	 textArea1.setVisible(true);
                	 textArea1.setText(list.get(0)[i]);
                	 textArea2.setVisible(true);
                	 textArea2.setText(list.get(1)[i]);

                	 i++;
                	 
                	 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 
             }
         });
         
         jcomp4.setVisible(false);
    }
    
    public void addResult(JPanel panel){

        Insets insets = panel.getInsets();
        
        textArea1 = new JTextArea();
        
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setEditable(false);
        
        panel.add(textArea1);
        
    	textArea1.setBounds(20 +  insets.left, 190 + insets.top,450,50);
    	textArea1.setText("HELLO WORLD");
    	
    	textArea1.setVisible(false);
    	
    	textArea2 = new JTextArea();
    	
    	scroll = new JScrollPane (textArea2);
    	scroll.setBounds(20 + insets.left, 280 + insets.top,450,120);
    	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    	
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setEditable(false);
        
    	panel.add(scroll);
    	
        textArea2.setBounds(20 + insets.left, 280 + insets.top,450,120);
        textArea2.setText("HELLO WORLD");
    	
        scroll.setVisible(false);
    	textArea2.setVisible(false);
    	
    	
        
    }
    public void addTextArea(JPanel panel){
    	
    	textArea = new JTextField();
    	panel.add(textArea);
    	
    	Insets insets = panel.getInsets();
    	
        textArea.setBounds(140 + insets.left, insets.top + 60,
               200,50);
        
    	textArea.setText("HELLO WORLD");
    	
    	textArea.setVisible(false);
    	
    }
    
    public void addJlabel(JPanel panel){
    	label = new JLabel("TITLE");
    	Insets insets = panel.getInsets();
    	
    	label.setBounds(20 +  insets.left, 150 + insets.top,450,50);
    	panel.add(label);
    	label.setVisible(false);
    	
    	label1 = new JLabel("DESCRIPTION");
    	
    	label1.setBounds(20 +  insets.left, 230 + insets.top,450,50);
    	panel.add(label1);
    	
    	label1.setVisible(false);
    }
    
    public void addNextButton(JPanel panel,JFrame frame){
    	
    	next = new JButton ("NEXT");
   	 	panel.add(next);
   	 
   	 	Insets insets = panel.getInsets();
        Dimension size = next.getPreferredSize();
    	
        next.setBounds(240 + insets.left, 400 + insets.top,
                size.width + 20, size.height + 10);
        
        next.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	if(i!=4){
            		textArea1.setText(list.get(0)[i]);
           	 
            		textArea2.setText(list.get(1)[i]);
           	 	
            		i++;
            	}
            	else{
            		SwingUtilities.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                        	frame.dispose();
                            new MainScreen().displayGUI(0);
                        }
                    });
            	}
            }
            
        });
        
        next.setVisible(false);
    }
    
    public void addSpeakButton(JPanel panel){
    	speak = new JButton ("SPEAK");
   	 	panel.add(speak);
   	 
   	 	Insets insets = panel.getInsets();
        Dimension size = speak.getPreferredSize();
    	
        speak.setBounds(120 + insets.left, 400 + insets.top,
                size.width + 20, size.height + 10);
        
        speak.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	if(i!=4){
           	 
            		 try {
                 		SpeechUtils.speak(list.get(0)[i-1]);
 						SpeechUtils.speak(list.get(1)[i-1]);
 					} catch (EngineException e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
           	 	
            		i++;
            	}
            	else{
            		try {
                 		SpeechUtils.speak(list.get(0)[3]);
 						SpeechUtils.speak(list.get(1)[3]);
 					} catch (EngineException e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
            	}
            }
            
        });
        
        speak.setVisible(false);
    }
    public MyPanel(JPanel panels,JFrame frame) 
    {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        addRecordButton(panel);
        addTextArea(panel);
        addSearchButton(panel);
        addJlabel(panel);
        addResult(panel);
        addNextButton(panel,frame);
        addSpeakButton(panel);
        		
        panels.add(panel);
        
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}