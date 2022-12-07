package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import classes.Circle;
import classes.Rectangle;
import classes.Rhombus;
import classes.Triangle;


public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8972845754063080764L;
	JPanel panel;
	public MainWindow(){
		initUI();
	}
	private void initUI() {

		panel = new JPanel();

		//Changes the flow layout to nothing. Allows absolute positioning. 
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		//Panel for the shape selection.
		JPanel shapePanel = new JPanel();
		shapePanel.setLayout(new BoxLayout(shapePanel, BoxLayout.X_AXIS));
		final JLabel shapeLabel = new JLabel("Select a Shape: ");
		final String shapeOptions[] = {"Circle", "Rectangle", "Rhombus", "Triangle"};
		final JComboBox<String> shapeList = new JComboBox<String>(shapeOptions);
		shapePanel.add(shapeLabel);
		shapePanel.add(shapeList);
		panel.add(shapePanel);

		final JPanel areaPanel = new JPanel();
		areaPanel.setLayout(new BoxLayout(areaPanel, BoxLayout.X_AXIS));
		final JLabel areaLabel = new JLabel("Calculate Area: ");
		final JPanel areaParametersPanel = new JPanel();
		areaParametersPanel.setLayout(new BoxLayout(areaParametersPanel, BoxLayout.Y_AXIS));
		areaPanel.add(areaLabel);
		areaPanel.add(areaParametersPanel);
		panel.add(areaPanel);

		JPanel perimeterPanel = new JPanel();
		JLabel perimeterLabel = new JLabel("Calculate Perimeter: ");
		final JPanel perimeterParametersPanel = new JPanel();
		perimeterParametersPanel.setLayout(new BoxLayout(perimeterParametersPanel, BoxLayout.Y_AXIS));
		perimeterPanel.add(perimeterLabel);
		perimeterPanel.add(perimeterParametersPanel);
		panel.add(perimeterPanel);

		setupCircle(areaParametersPanel, perimeterParametersPanel);


		shapeList.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					areaParametersPanel.removeAll();
					perimeterParametersPanel.removeAll();
					String shapeName = (String) shapeList.getSelectedItem();
					if(shapeName.equals("Circle")){
						setupCircle(areaParametersPanel, perimeterParametersPanel);
					}else if(shapeName.equals("Rectangle")){
						setupRectangle(areaParametersPanel, perimeterParametersPanel);
					}else if(shapeName.equals("Rhombus")){
						setupRhombus(areaParametersPanel, perimeterParametersPanel);
					}else{
						setupTriangle(areaParametersPanel, perimeterParametersPanel);
					}
				}
			}
		});

		add(panel);
		pack();
		setTitle("Shape Calculator");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setupTriangle(JPanel areaParametersPanel, JPanel perimeterParametersPanel){
		JPanel areaBasePanel = new JPanel();
		areaBasePanel.setLayout(new BoxLayout(areaBasePanel, BoxLayout.X_AXIS));
		JLabel areaBaseLabel = new JLabel("Enter base here: ");
		final JTextField areaBaseBox = new JTextField(24);
		areaBasePanel.add(areaBaseLabel);
		areaBasePanel.add(areaBaseBox);

		JPanel areaHeightPanel = new JPanel();
		areaHeightPanel.setLayout(new BoxLayout(areaHeightPanel, BoxLayout.X_AXIS));
		JLabel areaHeightLabel = new JLabel("Enter height here: ");
		final JTextField areaHeightBox = new JTextField(24);
		areaHeightPanel.add(areaHeightLabel);
		areaHeightPanel.add(areaHeightBox);

		JPanel areaSolutionPanel = new JPanel();
		areaSolutionPanel.setLayout(new BoxLayout(areaSolutionPanel, BoxLayout.X_AXIS));
		JButton solveAreaButton = new JButton("Solve");
		final JTextField areaSolutionField = new JTextField(24);
		areaSolutionField.setBackground(Color.WHITE);
		areaSolutionField.setEditable(false);
		areaSolutionPanel.add(solveAreaButton);
		areaSolutionPanel.add(areaSolutionField);

		areaParametersPanel.add(areaBasePanel);
		areaParametersPanel.add(areaHeightPanel);
		areaParametersPanel.add(areaSolutionPanel);

		solveAreaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Triangle triangle = new Triangle(Double.parseDouble(areaBaseBox.getText()), Double.parseDouble(areaHeightBox.getText()), 0, 0, 0);
				areaSolutionField.setText(triangle.area()+"");
			}
		});

		JPanel perimeterLengthPanel = new JPanel();
		perimeterLengthPanel.setLayout(new BoxLayout(perimeterLengthPanel, BoxLayout.X_AXIS));
		JLabel perimeterLengthLabel = new JLabel("Enter length side 1 here: ");
		final JTextField perimeterLengthBox = new JTextField(24);
		perimeterLengthPanel.add(perimeterLengthLabel);
		perimeterLengthPanel.add(perimeterLengthBox);

		JPanel perimeterLength2Panel = new JPanel();
		perimeterLength2Panel.setLayout(new BoxLayout(perimeterLength2Panel, BoxLayout.X_AXIS));
		JLabel perimeterLength2Label = new JLabel("Enter length of side 2 here: ");
		final JTextField perimeterLength2Box = new JTextField(24);
		perimeterLength2Panel.add(perimeterLength2Label);
		perimeterLength2Panel.add(perimeterLength2Box);
		
		JPanel perimeterLength3Panel = new JPanel();
		perimeterLength3Panel.setLayout(new BoxLayout(perimeterLength3Panel, BoxLayout.X_AXIS));
		JLabel perimeterLength3Label = new JLabel("Enter length of side 3 here: ");
		final JTextField perimeterLength3Box = new JTextField(24);
		perimeterLength3Panel.add(perimeterLength3Label);
		perimeterLength3Panel.add(perimeterLength3Box);
		
		
		JPanel perimeterSolutionPanel = new JPanel();
		perimeterSolutionPanel.setLayout(new BoxLayout(perimeterSolutionPanel, BoxLayout.X_AXIS));
		JButton solvePerimeterButton = new JButton("Solve");
		final JTextField perimeterSolutionField = new JTextField(24);
		perimeterSolutionField.setBackground(Color.WHITE);
		perimeterSolutionField.setEditable(false);
		perimeterSolutionPanel.add(solvePerimeterButton);
		perimeterSolutionPanel.add(perimeterSolutionField);

		solvePerimeterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Triangle triangle = new Triangle(0, 0, Double.parseDouble(perimeterLengthBox.getText()), Double.parseDouble(perimeterLength2Box.getText()), Double.parseDouble(perimeterLength3Box.getText()));
				perimeterSolutionField.setText(triangle.perimeter()+"");
			}
		});

		perimeterParametersPanel.add(perimeterLengthPanel);
		perimeterParametersPanel.add(perimeterLength2Panel);
		perimeterParametersPanel.add(perimeterLength3Panel);
		perimeterParametersPanel.add(perimeterSolutionPanel);

		areaParametersPanel.revalidate();
		areaParametersPanel.repaint();
		perimeterParametersPanel.revalidate();
		perimeterParametersPanel.repaint();
		pack();
	}

	private void setupRhombus(JPanel areaParametersPanel, JPanel perimeterParametersPanel){
		JPanel areaLengthPanel = new JPanel();
		areaLengthPanel.setLayout(new BoxLayout(areaLengthPanel, BoxLayout.X_AXIS));
		JLabel areaLengthLabel = new JLabel("Enter length here: ");
		final JTextField areaLengthBox = new JTextField(24);
		areaLengthPanel.add(areaLengthLabel);
		areaLengthPanel.add(areaLengthBox);

		JPanel areaHeightPanel = new JPanel();
		areaHeightPanel.setLayout(new BoxLayout(areaHeightPanel, BoxLayout.X_AXIS));
		JLabel areaHeightLabel = new JLabel("Enter height here: ");
		final JTextField areaHeightBox = new JTextField(24);
		areaHeightPanel.add(areaHeightLabel);
		areaHeightPanel.add(areaHeightBox);

		JPanel areaSolutionPanel = new JPanel();
		areaSolutionPanel.setLayout(new BoxLayout(areaSolutionPanel, BoxLayout.X_AXIS));
		JButton solveAreaButton = new JButton("Solve");
		final JTextField areaSolutionField = new JTextField(24);
		areaSolutionField.setBackground(Color.WHITE);
		areaSolutionField.setEditable(false);
		areaSolutionPanel.add(solveAreaButton);
		areaSolutionPanel.add(areaSolutionField);

		areaParametersPanel.add(areaLengthPanel);
		areaParametersPanel.add(areaHeightPanel);
		areaParametersPanel.add(areaSolutionPanel);

		solveAreaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Rhombus rhombus = new Rhombus(Double.parseDouble(areaLengthBox.getText()), Double.parseDouble(areaHeightBox.getText()));
				areaSolutionField.setText(rhombus.area()+"");
			}
		});

		JPanel perimeterLengthPanel = new JPanel();
		perimeterLengthPanel.setLayout(new BoxLayout(perimeterLengthPanel, BoxLayout.X_AXIS));
		JLabel perimeterLengthLabel = new JLabel("Enter length here: ");
		final JTextField perimeterLengthBox = new JTextField(24);
		perimeterLengthPanel.add(perimeterLengthLabel);
		perimeterLengthPanel.add(perimeterLengthBox);

		JPanel perimeterHeightPanel = new JPanel();
		perimeterHeightPanel.setLayout(new BoxLayout(perimeterHeightPanel, BoxLayout.X_AXIS));
		JLabel perimeterHeightLabel = new JLabel("Enter height here: ");
		final JTextField perimeterHeightBox = new JTextField(24);
		perimeterHeightPanel.add(perimeterHeightLabel);
		perimeterHeightPanel.add(perimeterHeightBox);

		JPanel perimeterSolutionPanel = new JPanel();
		perimeterSolutionPanel.setLayout(new BoxLayout(perimeterSolutionPanel, BoxLayout.X_AXIS));
		JButton solvePerimeterButton = new JButton("Solve");
		final JTextField perimeterSolutionField = new JTextField(24);
		perimeterSolutionField.setBackground(Color.WHITE);
		perimeterSolutionField.setEditable(false);
		perimeterSolutionPanel.add(solvePerimeterButton);
		perimeterSolutionPanel.add(perimeterSolutionField);

		solvePerimeterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Rhombus rhombus = new Rhombus(Double.parseDouble(perimeterLengthBox.getText()), Double.parseDouble(perimeterLengthBox.getText()));
				perimeterSolutionField.setText(rhombus.perimeter()+"");
			}
		});

		perimeterParametersPanel.add(perimeterLengthPanel);
		perimeterParametersPanel.add(perimeterHeightPanel);
		perimeterParametersPanel.add(perimeterSolutionPanel);

		areaParametersPanel.revalidate();
		areaParametersPanel.repaint();
		perimeterParametersPanel.revalidate();
		perimeterParametersPanel.repaint();
		pack();
	}


	private void setupRectangle(JPanel areaParametersPanel, JPanel perimeterParametersPanel){
		JPanel areaLengthPanel = new JPanel();
		areaLengthPanel.setLayout(new BoxLayout(areaLengthPanel, BoxLayout.X_AXIS));
		JLabel areaLengthLabel = new JLabel("Enter length here: ");
		final JTextField areaLengthBox = new JTextField(24);
		areaLengthPanel.add(areaLengthLabel);
		areaLengthPanel.add(areaLengthBox);

		JPanel areaWidthPanel = new JPanel();
		areaWidthPanel.setLayout(new BoxLayout(areaWidthPanel, BoxLayout.X_AXIS));
		JLabel areaWidthLabel = new JLabel("Enter width here: ");
		final JTextField areaWidthBox = new JTextField(24);
		areaWidthPanel.add(areaWidthLabel);
		areaWidthPanel.add(areaWidthBox);

		JPanel areaSolutionPanel = new JPanel();
		areaSolutionPanel.setLayout(new BoxLayout(areaSolutionPanel, BoxLayout.X_AXIS));
		JButton solveAreaButton = new JButton("Solve");
		final JTextField areaSolutionField = new JTextField(24);
		areaSolutionField.setBackground(Color.WHITE);
		areaSolutionField.setEditable(false);
		areaSolutionPanel.add(solveAreaButton);
		areaSolutionPanel.add(areaSolutionField);

		areaParametersPanel.add(areaLengthPanel);
		areaParametersPanel.add(areaWidthPanel);
		areaParametersPanel.add(areaSolutionPanel);

		solveAreaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Rectangle rectangle = new Rectangle(Double.parseDouble(areaLengthBox.getText()), Double.parseDouble(areaWidthBox.getText()));
				areaSolutionField.setText(rectangle.area()+"");
			}
		});

		JPanel perimeterLengthPanel = new JPanel();
		perimeterLengthPanel.setLayout(new BoxLayout(perimeterLengthPanel, BoxLayout.X_AXIS));
		JLabel perimeterLengthLabel = new JLabel("Enter length here: ");
		final JTextField perimeterLengthBox = new JTextField(24);
		perimeterLengthPanel.add(perimeterLengthLabel);
		perimeterLengthPanel.add(perimeterLengthBox);

		JPanel perimeterWidthPanel = new JPanel();
		perimeterWidthPanel.setLayout(new BoxLayout(perimeterWidthPanel, BoxLayout.X_AXIS));
		JLabel perimeterWidthLabel = new JLabel("Enter width here: ");
		final JTextField perimeterWidthBox = new JTextField(24);
		perimeterWidthPanel.add(perimeterWidthLabel);
		perimeterWidthPanel.add(perimeterWidthBox);

		JPanel perimeterSolutionPanel = new JPanel();
		perimeterSolutionPanel.setLayout(new BoxLayout(perimeterSolutionPanel, BoxLayout.X_AXIS));
		JButton solvePerimeterButton = new JButton("Solve");
		final JTextField perimeterSolutionField = new JTextField(24);
		perimeterSolutionField.setBackground(Color.WHITE);
		perimeterSolutionField.setEditable(false);
		perimeterSolutionPanel.add(solvePerimeterButton);
		perimeterSolutionPanel.add(perimeterSolutionField);

		solvePerimeterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Rectangle rectangle = new Rectangle(Double.parseDouble(perimeterLengthBox.getText()), Double.parseDouble(perimeterWidthBox.getText()));
				perimeterSolutionField.setText(rectangle.perimeter()+"");
			}
		});

		perimeterParametersPanel.add(perimeterLengthPanel);
		perimeterParametersPanel.add(perimeterWidthPanel);
		perimeterParametersPanel.add(perimeterSolutionPanel);

		areaParametersPanel.revalidate();
		areaParametersPanel.repaint();
		perimeterParametersPanel.revalidate();
		perimeterParametersPanel.repaint();
		pack();
	}

	private void setupCircle(JPanel areaParametersPanel, JPanel perimeterParametersPanel){
		JPanel areaRadiusPanel = new JPanel();
		areaRadiusPanel.setLayout(new BoxLayout(areaRadiusPanel, BoxLayout.X_AXIS));
		JLabel areaRadiusLabel = new JLabel("Enter radius here: ");
		final JTextField areaRadiusBox = new JTextField(24);
		areaRadiusPanel.add(areaRadiusLabel);
		areaRadiusPanel.add(areaRadiusBox);

		JPanel areaSolutionPanel = new JPanel();
		areaSolutionPanel.setLayout(new BoxLayout(areaSolutionPanel, BoxLayout.X_AXIS));
		JButton solveAreaButton = new JButton("Solve");
		final JTextField areaSolutionField = new JTextField(24);
		areaSolutionField.setBackground(Color.WHITE);
		areaSolutionField.setEditable(false);
		areaSolutionPanel.add(solveAreaButton);
		areaSolutionPanel.add(areaSolutionField);

		areaParametersPanel.add(areaRadiusPanel);
		areaParametersPanel.add(areaSolutionPanel);

		solveAreaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Circle circle = new Circle(Double.parseDouble(areaRadiusBox.getText()));
				areaSolutionField.setText(circle.area()+"");
			}
		});

		JPanel perimeterRadiusPanel = new JPanel();
		perimeterRadiusPanel.setLayout(new BoxLayout(perimeterRadiusPanel, BoxLayout.X_AXIS));
		JLabel perimeterRadiusLabel = new JLabel("Enter radius here: ");
		final JTextField perimeterRadiusBox = new JTextField(24);
		perimeterRadiusPanel.add(perimeterRadiusLabel);
		perimeterRadiusPanel.add(perimeterRadiusBox);

		JPanel perimeterSolutionPanel = new JPanel();
		perimeterSolutionPanel.setLayout(new BoxLayout(perimeterSolutionPanel, BoxLayout.X_AXIS));
		JButton solvePerimeterButton = new JButton("Solve");
		final JTextField perimeterSolutionField = new JTextField(24);
		perimeterSolutionField.setBackground(Color.WHITE);
		perimeterSolutionField.setEditable(false);
		perimeterSolutionPanel.add(solvePerimeterButton);
		perimeterSolutionPanel.add(perimeterSolutionField);

		solvePerimeterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Circle circle = new Circle(Double.parseDouble(perimeterRadiusBox.getText()));
				perimeterSolutionField.setText(circle.perimeter()+"");
			}
		});

		perimeterParametersPanel.add(perimeterRadiusPanel);
		perimeterParametersPanel.add(perimeterSolutionPanel);

		areaParametersPanel.revalidate();
		areaParametersPanel.repaint();
		perimeterParametersPanel.revalidate();
		perimeterParametersPanel.repaint();
		pack();
	}


}
