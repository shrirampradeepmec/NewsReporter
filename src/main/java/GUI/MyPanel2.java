package GUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.speech.EngineException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
class MyPanel2 extends JPanel 
{

    private JButton jcomp1;

    String[] title = new String[4];
	String[] des = new String[4];
	public static List<String[]> list = new ArrayList<String[]>();
	
	public static void setList(List<String[]> lists){
		list = lists;
	}
	
    public MyPanel2(JPanel panels,JFrame frame) throws EngineException 
    {   
        JPanel panel = new JPanel();
        panel.setLayout(null);

        panels.add(panel);
        
        jcomp1 = new JButton ("Back");
        panel.add(jcomp1);
        
        Insets insets = panel.getInsets();
        Dimension size = jcomp1.getPreferredSize();
        
        jcomp1.setBounds(180 + insets.left, 50 + insets.top + 80,
                size.width + 30, size.height + 10);
        
        jcomp1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                    	frame.dispose();
                        new MainScreen().displayGUI(0);
                    }
                });
            }
        });
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}

