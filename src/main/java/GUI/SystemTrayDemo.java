package GUI;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class SystemTrayDemo{

	public void systemTray(){
		
		if(!SystemTray.isSupported()){
			System.out.println("System tray is not supported!");
			return ;
		}	
		
		SystemTray systemTray = SystemTray.getSystemTray();
		
		Image image = Toolkit.getDefaultToolkit().getImage("/home/shriram/Final/MainProject/new1.png");
		
		PopupMenu trayPopupMenu = new PopupMenu();
		trayPopupMenu = customizeTray(trayPopupMenu);
		addActionToTray(trayPopupMenu);
		
		TrayIcon trayIcon = new TrayIcon(image, "SystemTray Demo", trayPopupMenu);
	    trayIcon.setImageAutoSize(true);
	
	    try{
	        systemTray.add(trayIcon);
	    }catch(AWTException awtException){
	        awtException.printStackTrace();
	    }
		
	}
	
	public static PopupMenu customizeTray(PopupMenu trayPopupMenu){
		return trayPopupMenu;
	}
	public static void addActionToTray(PopupMenu trayPopupMenu){
		
		MenuItem action = new MenuItem("Speak");
	    action.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	SwingUtilities.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                    new MainScreen().displayGUI(0);
	                }
	            });         
	        }
	    });     
	    
	    trayPopupMenu.add(action);
	    trayPopupMenu.addSeparator();
	    
	    MenuItem settings = new MenuItem("Settings");
	    settings.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	SwingUtilities.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                    new MainScreen().displayGUI(1);
	                }
	            });         
	        }
	    });     
	    
	    trayPopupMenu.add(settings);
	    trayPopupMenu.addSeparator();
	    
	    MenuItem info = new MenuItem("Information");
	    
	    info.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	SwingUtilities.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                    new MainScreen().displayGUI(2);
	                }
	            });              
	        }
	    });
	    
	    trayPopupMenu.add(info);
	    trayPopupMenu.addSeparator();
	    
	    MenuItem close = new MenuItem("Close");
	    
	    close.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);             
	        }
	    });
	    trayPopupMenu.add(close);
	
	}
	
	public static void main(String []args){
		
		SystemTrayDemo sysTray = new SystemTrayDemo();
		sysTray.systemTray();
	}

}