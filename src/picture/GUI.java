package picture;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JSeparator;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class GUI implements Runnable {
	
	JFrame frame;
	JSlider sliderH_Min;
	JLabel labelH_min;
	private Boolean ready = false;
	private JLabel labelS_min;
	private JSlider sliderS_min;
//	private JLabel lblMin;
	private JSlider sliderV_min;
	private JLabel labelV_min;
//	private JLabel lblMax;
	private JLabel labelH_max;
	private JSlider sliderH_max;
	private JSlider sliderS_max;
	private JLabel labelS_max;
	private JSlider sliderV_max;
	private JLabel labelV_max;
	private JLabel lblSmoothness;
	private JSlider sliderSmooth;
	private JLabel lblErode;
	private JSlider sliderErode;
	private JLabel lblDilate;
	private JSlider sliderDilate;
	private JLabel lblSize;
	private JSlider sliderSize;
	private JLabel lblSMAX;
	private JSlider sliderSMAX;
	private JButton btnInnerBlock;
	private JButton btnOuterBlock;
//	private boolean GREEN_OK = false;
//	private boolean RED_OK = false;
//	private boolean GREEN_PRESSED_BFR = false;
//	private boolean RED_PRESSED_BFR = false;
	private ArrayList<Settings> settingList = new ArrayList<Settings>();
	private boolean isSame = false;
	private int counter = 0;
	private JButton btnFront2, btnBack2;
	
	public GUI(){
		
	}
	
	public boolean getReady(){
		return ready;
	}
	public void setReady(boolean status){
		this.ready = status;
	}
	
	public int getR_min() {
		return r_min;
	}

	public void setR_min(int r_min) {
		this.r_min = r_min;
	}

	public int getG_min() {
		return g_min;
	}

	public void setG_min(int g_min) {
		this.g_min = g_min;
	}

	public int getB_min() {
		return b_min;
	}

	public void setB_min(int b_min) {
		this.b_min = b_min;
	}

	public int getR_max() {
		return r_max;
	}

	public void setR_max(int r_max) {
		this.r_max = r_max;
	}

	public int getG_max() {
		return g_max;
	}

	public void setG_max(int g_max) {
		this.g_max = g_max;
	}

	public int getB_max() {
		return b_max;
	}

	public void setB_max(int b_max) {
		this.b_max = b_max;
	}

	public int getErode() {
		return erode;
	}

	public void setErode(int erode) {
		this.erode = erode;
	}

	public int getDilate() {
		return dilate;
	}

	public void setDilate(int dilate) {
		this.dilate = dilate;
	}

	public int getSmooth() {
		return smooth;
	}

	public void setSmooth(int smooth) {
		this.smooth = smooth;
	}

	public int getSize() {
		return SMIN;
	}

	public void setSize(int size) {
		this.SMIN = size;
	}

	public int getSMAX() {
		return SMAX;
	}

	public void setSMAX(int sMAX) {
		SMAX = sMAX;
	}
	
//	public boolean getGreen_OK() {
//		return GREEN_OK;
//	}
//
//	public void setGreen_OK(boolean b) {
//		this.GREEN_PRESSED_BFR = true;
//		this.GREEN_OK = b;	
//	}
//	public boolean getGREEN_BFR(){
//		return GREEN_PRESSED_BFR;
//	}
//	
//	public boolean getRed_OK() {
//		return RED_OK;
//	}
//
//	public void setRed_OK(boolean b) {
//		this.RED_PRESSED_BFR = true;
//		this.RED_OK = b;	
//	}
//	public boolean getRED_BFR(){
//		return RED_PRESSED_BFR;
//	}
	
	public void setSettings(String color, String name) {
		for(Settings setting : settingList){
			if(name.equals(setting.getName())) {
				setting.setB_max(b_max);
				setting.setB_min(b_min);
				setting.setR_max(r_max);
				setting.setR_min(r_min);
				setting.setG_max(g_max);
				setting.setG_min(g_min);
				setting.setSmooth_lvl(smooth);
				setting.setDilate_lvl(dilate);
				setting.setErode_lvl(erode);
				setting.setS_max(SMAX);
				setting.setS_min(SMIN);
				isSame = true;
			}
				
			}
		if (isSame == false)
			settingList.add(new Settings(name, color, r_min, g_min, b_min, r_max, g_max, b_max, SMIN, SMAX, smooth, erode, dilate));
		}
	
	
	public ArrayList<Settings> getColorSettings(){
		return settingList;
	}

	private int r_min = 0, g_min = 0, b_min = 0;
	private int r_max = 255, g_max = 255, b_max = 255;
	private int smooth = 1, erode, dilate, SMIN = 100, SMAX = 0;
	private JButton btnFront1;
	private JButton btnBack1;

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		//Set the look and feel to users OS LaF.
	    try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (UnsupportedLookAndFeelException e) {
	        e.printStackTrace();
	    }
		
		int panelW = 434;
		int panelH = 419;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenW = screenSize.getWidth();
		double screenH = screenSize.getHeight();
		frame = new JFrame("Filter Tool");
		frame.setBounds((int) (screenW-panelW-150), (int) (screenH-panelH-350), 459, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 443, 617);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		sliderH_Min = new JSlider(0, 360);
		sliderH_Min.setBounds(129, 32, 287, 23);
		sliderH_Min.setValue(r_min);
		panel.add(sliderH_Min);
		sliderH_Min.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				labelH_min.setText("H_MIN : " + sliderH_Min.getValue());
				setR_min(sliderH_Min.getValue());

			}
		});

		labelH_min = new JLabel("H_MIN : " + sliderH_Min.getValue());
		labelH_min.setBounds(30, 32, 89, 14);
		panel.add(labelH_min);
		//GIT
		sliderS_min = new JSlider(0, 100);
		sliderS_min.setBounds(129, 66, 287, 23);
		sliderS_min.setValue(g_min);
		panel.add(sliderS_min);
		sliderS_min.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				labelS_min.setText("S_MIN : " + sliderS_min.getValue());
				setG_min(sliderS_min.getValue());
			}
		});

		labelS_min = new JLabel("S_MIN : " + sliderS_min.getValue());
		labelS_min.setBounds(30, 66, 89, 14);
		panel.add(labelS_min);

		//lblMin = new JLabel("MIN");
		//lblMin.setBounds(30, 11, 46, 14);
		//panel.add(lblMin);

		sliderV_min = new JSlider(0, 100);
		sliderV_min.setBounds(129, 100, 287, 23);
		sliderV_min.setValue(g_min);
		panel.add(sliderV_min);
		sliderV_min.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				labelV_min.setText("V_MIN : " + sliderV_min.getValue());
				setB_min(sliderV_min.getValue());
			}
		});

		labelV_min = new JLabel("V_MIN : " + sliderV_min.getValue());
		labelV_min.setBounds(30, 100, 89, 14);
		panel.add(labelV_min);

		//lblMax = new JLabel("MAX");
		//lblMax.setBounds(30, 137, 46, 14);
		//panel.add(lblMax);

		sliderH_max = new JSlider(0, 360);
		sliderH_max.setBounds(129, 162, 287, 23);
		sliderH_max.setValue(g_max);
		panel.add(sliderH_max);
		sliderH_max.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				labelH_max.setText("H_MAX : " + sliderH_max.getValue());
				setR_max(sliderH_max.getValue());
			}
		});

		labelH_max = new JLabel("H_MAX : " + sliderH_max.getValue());
		labelH_max.setBounds(30, 162, 89, 14);
		panel.add(labelH_max);

		sliderS_max = new JSlider(0, 100);
		sliderS_max.setValue(g_max);
		sliderS_max.setBounds(129, 196, 287, 23);
		panel.add(sliderS_max);
		sliderS_max.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				labelS_max.setText("S_MAX : " + sliderS_max.getValue());
				setG_max(sliderS_max.getValue());
			}
		});

		labelS_max = new JLabel("S_MAX : " + sliderS_max.getValue());
		labelS_max.setBounds(30, 196, 89, 14);
		panel.add(labelS_max);

		sliderV_max = new JSlider(0, 100);
		sliderV_max.setValue(b_max);
		sliderV_max.setBounds(129, 230, 287, 23);
		panel.add(sliderV_max);
		sliderV_max.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				labelV_max.setText("V_MAX : " + sliderV_max.getValue());
				setB_max(sliderV_max.getValue());
			}
		});

		labelV_max = new JLabel("V_MAX : " + sliderV_max.getValue());
		labelV_max.setBounds(30, 230, 89, 14);
		panel.add(labelV_max);
		
		sliderSmooth = new JSlider(1,29);
		sliderSmooth.setValue(1);
		sliderSmooth.setBounds(129, 365, 287, 23);
		panel.add(sliderSmooth);
		sliderSmooth.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				lblSmoothness.setText("Smooth : " + sliderSmooth.getValue());
				if(sliderSmooth.getValue() % 2 == 1)
					setSmooth(sliderSmooth.getValue());
			}
		});

		lblSmoothness = new JLabel("Smooth : " + sliderSmooth.getValue());
		lblSmoothness.setBounds(30, 365, 89, 14);
		panel.add(lblSmoothness);
		
		sliderErode = new JSlider(0,5);
		sliderErode.setValue(0);
		sliderErode.setBounds(129, 399, 287, 23);
		panel.add(sliderErode);
		sliderErode.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblErode.setText("Erode : " + sliderErode.getValue());
				setErode(sliderErode.getValue());
			}
		});

		lblErode = new JLabel("Erode : "+sliderErode.getValue());
		lblErode.setBounds(30, 399, 79, 14);
		panel.add(lblErode);
		
		sliderDilate = new JSlider(0,5);
		sliderDilate.setValue(0);
		sliderDilate.setBounds(129, 433, 287, 23);
		panel.add(sliderDilate);
		sliderDilate.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblDilate.setText("Dilate : "+sliderDilate.getValue());
				setDilate(sliderDilate.getValue());
				
			}
		});
		
		lblDilate = new JLabel("Dilate : "+sliderDilate.getValue());
		lblDilate.setBounds(30, 433, 79, 14);
		panel.add(lblDilate);
		
		sliderSize = new JSlider(0,200);
		sliderSize.setBounds(129, 291, 287, 23);
		panel.add(sliderSize);
		sliderSize.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblSize.setText("S_MIN : "+sliderSize.getValue());
				setSize(sliderSize.getValue());
				
			}
		});
		
		lblSize = new JLabel("S_MIN : "+sliderSize.getValue());
		lblSize.setBounds(30, 291, 200, 14);
		panel.add(lblSize);
		
		sliderSMAX = new JSlider(0,500);
		sliderSMAX.setValue(SMAX);
		sliderSMAX.setBounds(129, 325, 287, 23);
		panel.add(sliderSMAX);
		sliderSMAX.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblSMAX.setText("S_MAX : "+sliderSMAX.getValue());
				setSMAX(sliderSMAX.getValue());
			}
			});
		
		lblSMAX = new JLabel("S_MAX : "+sliderSMAX.getValue());
		lblSMAX.setBounds(30, 325, 200, 14);
		panel.add(lblSMAX);
		
		btnInnerBlock = new JButton("Green");
		btnInnerBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSettings("GREEN", "GREEN_SETTINGS");
				btnInnerBlock.setBackground(Color.GREEN);
				btnOuterBlock.setEnabled(true);
//				setSliders(75, 225, 0, 205, 255, 5);
				setSliders(0, 55, 49, 31, 100, 100);
				
			}
		});
		btnInnerBlock.setBounds(30, 505, 89, 23);
		panel.add(btnInnerBlock);
		
		btnOuterBlock = new JButton("Red");
		btnOuterBlock.setEnabled(false);
		btnOuterBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSettings("RED", "RED_SETTINGS");
				btnOuterBlock.setBackground(Color.GREEN);
				btnFront1.setEnabled(true);
				//Robot MAXPOWER
//				setSliders(75, 175, 143, 161, 255, 175);
				//Robot NXT
				setSliders(200, 0, 0, 270, 100, 100);
			}
		});
		btnOuterBlock.setBounds(129, 505, 89, 23);
		panel.add(btnOuterBlock);
		
		btnFront1 = new JButton("Front");
		btnFront1.setEnabled(false);
		btnFront1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSettings("FRONT1", "FRONT1_SETTINGS");
				btnFront1.setBackground(Color.GREEN);
				btnBack1.setEnabled(true);
				
				//Robot NXT
				setSliders(153,0,18,225,100,100);
			}
		});
		btnFront1.setBounds(228, 505, 89, 23);
		panel.add(btnFront1);
		
		btnBack1 = new JButton("Back");
		btnBack1.setEnabled(false);
		btnBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSettings("BACK1", "BACK1_SETTINGS");
				btnBack1.setBackground(Color.GREEN);
				btnFront2.setEnabled(true);
				setSliders(317, 0, 0, 347, 100, 100);
				
			}
		});
		btnBack1.setBounds(327, 505, 89, 23);
		panel.add(btnBack1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 492, 186, 2);
		panel.add(separator);
		
		JLabel lblPorts = new JLabel("Ports");
		lblPorts.setForeground(Color.DARK_GRAY);
		lblPorts.setBounds(111, 478, 25, 14);
		panel.add(lblPorts);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(228, 492, 186, 2);
		panel.add(separator_1);
		
		JLabel lblRobot1 = new JLabel("Robot #1");
		lblRobot1.setForeground(Color.DARK_GRAY);
		lblRobot1.setBounds(299, 478, 46, 14);
		panel.add(lblRobot1);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setReady(true);
			}
		});
		btnStart.setBackground(UIManager.getColor("Button.background"));
		btnStart.setBounds(30, 546, 188, 44);
		panel.add(btnStart);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(228, 553, 186, 2);
		panel.add(separator_2);
		
		JLabel lblRobot2 = new JLabel("Robot #2");
		lblRobot2.setForeground(Color.DARK_GRAY);
		lblRobot2.setBounds(299, 539, 46, 14);
		panel.add(lblRobot2);
		
		btnFront2 = new JButton("Front");
		btnFront2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSettings("FRONT2", "FRONT2_SETTINGS");
				btnFront2.setBackground(Color.GREEN);
				btnBack2.setEnabled(true);
				//Robot MAXPOWER
//				setSliders(200, 0, 0, 230, 55, 130);

			}
		});
		btnFront2.setEnabled(false);
		btnFront2.setBounds(228, 567, 89, 23);
		panel.add(btnFront2);
		
		btnBack2 = new JButton("Back");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSettings("BACK2", "BACK2_SETTINGS");
				btnBack2.setBackground(Color.GREEN);
			}
		});
		btnBack2.setEnabled(false);
		btnBack2.setBounds(327, 566, 89, 23);
		panel.add(btnBack2);
	}


	@Override
	public void run() {
		initialize();
		frame.setVisible(true);
		setSliders(81, 36, 6, 140, 100, 100);
	}
	public void setSliders(int r_min, int g_min, int b_min, int r_max,int g_max,int b_max){
		this.sliderH_Min.setValue(r_min);
		this.r_min = r_min;
		this.sliderS_min.setValue(g_min);
		this.g_min = g_min;
		this.sliderV_min.setValue(b_min);
		this.b_min = b_min;
		this.sliderH_max.setValue(r_max);
		this.r_max = r_max;
		this.sliderS_max.setValue(g_max);
		this.g_max = g_max;
		this.sliderV_max.setValue(b_max);
		this.b_max = b_max;
	}
}
