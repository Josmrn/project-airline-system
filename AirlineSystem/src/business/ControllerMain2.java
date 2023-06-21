package business;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIBrands;
import presentation.GUIMain2;
import presentation.GUIModel;

public class ControllerMain2 implements ActionListener{
	
	private GUIMain2 guiMain2; 
	private GUIBrands guiB;
	private GUIModel guiM;
	private Dimension desktopSize, FrameSize;

	public ControllerMain2() {
		guiMain2 = new GUIMain2();
		guiB = new GUIBrands();
		guiM = new GUIModel();
		
		initializerAction();
	}

	private void initializerAction() {
		guiMain2.getMiAddBrand().addActionListener(this);
		guiMain2.getMiEditModels().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == guiMain2.getMiAddBrand()) {
			desktopSize = guiMain2.getDesktopMain().getSize();
			FrameSize = guiB.getSize();
			guiB.setLocation((desktopSize.width-FrameSize.width)/2, (desktopSize.height-FrameSize.height)/2);
			guiMain2.getDesktopMain().add(guiB);
			guiB.setVisible(true);
		}
		
		if(e.getSource() == guiMain2.getMiEditModels()) {
			desktopSize = guiMain2.getDesktopMain().getSize();
			FrameSize = guiM.getSize();
			guiM.setLocation((desktopSize.width-FrameSize.width)/2, (desktopSize.height-FrameSize.height)/2);
			guiMain2.getDesktopMain().add(guiM);
			guiM.setVisible(true);
		}
		
		
	}
}
