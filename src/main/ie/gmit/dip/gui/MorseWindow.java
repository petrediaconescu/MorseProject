package ie.gmit.dip.gui;

import ie.gmit.dip.MorseTree;
import ie.gmit.dip.exceptions.ElementNotFoundException;
import ie.gmit.dip.sound.MorseCodeSound;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/** @author Petre Diaconescu
 * @version 1.0 */
public class MorseWindow {
	private JFrame frame;
	private JPanel morsePanel = new JPanel();
	private final JTextArea notes = new JTextArea();
	private JLabel labelLetterTimer;
	private MorseTree mt = new MorseTree();
	private StringBuffer letterBuffer = new StringBuffer();
	private StringBuffer textBuffer = new StringBuffer();
	private final static long TIME_GAP = 2000L;

	MorseCodeSound morseSound = new MorseCodeSound();

	private long lastClickTime;
	private char letter;
	private File file;

	public MorseWindow() {
		// Create a window for the application
		frame = new JFrame();
		frame.setTitle("H.Dip 2015 - Morse Encoder/Decoder");
		frame.setSize(550, 500);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());

		// The morse pad and button will be added to a panel
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		topPanel.setBorder(new javax.swing.border.TitledBorder(
				"Enter Morse Code"));
		topPanel.setPreferredSize(new java.awt.Dimension(500, 100));
		topPanel.setMaximumSize(new java.awt.Dimension(500, 100));
		topPanel.setMinimumSize(new java.awt.Dimension(500, 100));

		final JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				handleClicks();
				btnStart.setVisible(false);
			}
		});
		topPanel.add(btnStart);

		morsePanel.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.SoftBevelBorder.RAISED));
		morsePanel.setBackground(Color.LIGHT_GRAY);
		morsePanel.setPreferredSize(new java.awt.Dimension(250, 50));
		morsePanel.setMaximumSize(new java.awt.Dimension(250, 50));
		morsePanel.setMinimumSize(new java.awt.Dimension(250, 50));

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				if (letterBuffer != null) {
					labelLetterTimer.setVisible(false);

					try {
						letter = mt.getValue(letterBuffer.toString());
						appendTextToBuffer(letter);
						notes.append(getTextBuffer());

					} catch (ElementNotFoundException e) {
						JOptionPane.showMessageDialog(frame, e.getMessage(),
								"Please try again...",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, e.getMessage(),
								"Please try again...",
								JOptionPane.ERROR_MESSAGE);
					}

				}
				letterBuffer = new StringBuffer();
				textBuffer = new StringBuffer();

			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				letterBuffer = new StringBuffer();
				labelLetterTimer.setVisible(false);

			}
		});

		labelLetterTimer = new JLabel();
		labelLetterTimer.setOpaque(true);
		labelLetterTimer.setBackground(Color.WHITE);

		labelLetterTimer.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.SoftBevelBorder.LOWERED));
		labelLetterTimer.setVisible(false);

		topPanel.add(morsePanel);
		topPanel.add(btnSend);
		topPanel.add(btnCancel);
		topPanel.add(labelLetterTimer);
		frame.getContentPane().add(topPanel); // Add the morse panel to the
												// window

		// The file panel will contain the file chooser
		JPanel filePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		filePanel.setBorder(new javax.swing.border.TitledBorder(
				"Select File to Encode"));
		filePanel.setPreferredSize(new java.awt.Dimension(500, 100));
		filePanel.setMaximumSize(new java.awt.Dimension(500, 100));
		filePanel.setMinimumSize(new java.awt.Dimension(500, 100));

		final JTextField txtFileName = new JTextField(20);
		txtFileName.setPreferredSize(new java.awt.Dimension(100, 30));
		txtFileName.setMaximumSize(new java.awt.Dimension(100, 30));
		txtFileName.setMargin(new java.awt.Insets(2, 2, 2, 2));
		txtFileName.setMinimumSize(new java.awt.Dimension(100, 30));

		JButton btnChooseFile = new JButton("Browse...");
		btnChooseFile.setToolTipText("Select File to Encode");
		btnChooseFile.setPreferredSize(new java.awt.Dimension(90, 30));
		btnChooseFile.setMaximumSize(new java.awt.Dimension(90, 30));
		btnChooseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnChooseFile.setMinimumSize(new java.awt.Dimension(90, 30));
		btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JFileChooser fc = new JFileChooser("./");
				int returnVal = fc.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile().getAbsoluteFile();
					String name = file.getAbsolutePath();
					txtFileName.setText(name);
				}
			}
		});

		JButton btnEncodeFile = new JButton("Encode");
		btnEncodeFile.setToolTipText("Encode Selected File");
		btnEncodeFile.setPreferredSize(new java.awt.Dimension(90, 30));
		btnEncodeFile.setMaximumSize(new java.awt.Dimension(90, 30));
		btnEncodeFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnEncodeFile.setMinimumSize(new java.awt.Dimension(90, 30));
		btnEncodeFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String fileContents = "";
				try {
					FileReader fileReader = new FileReader(file);
					int i = 0;
					while ((i = fileReader.read()) != -1) {
						char c = (char) i;

						String characterUppercase = String.valueOf(c);
						characterUppercase = characterUppercase.toUpperCase();
						String morseKey = mt.getKeyByValue(characterUppercase
								.charAt(0)) + " ";

						fileContents = fileContents + morseKey;
					}

					fileReader.close();
					notes.append("The text from " + file.getName() +   " into Morse Code>\n" + fileContents);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, e.getMessage(),
							"Please try again...",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (ElementNotFoundException e) {
					JOptionPane
							.showMessageDialog(
									frame,
									"Not a valid file. Please select a file which contains just letters and numbers.",
									"Please try again...",
									JOptionPane.INFORMATION_MESSAGE);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(frame,
							"Please select a file to encode",
							"Please try again...",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage(),
							"Please try again...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		filePanel.add(txtFileName);
		filePanel.add(btnChooseFile);
		filePanel.add(btnEncodeFile);
		frame.getContentPane().add(filePanel); // Add the panel to the window

		// A separate panel for the programme output
		JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		middlePanel.setPreferredSize(new java.awt.Dimension(500, 300));
		middlePanel.setMaximumSize(new java.awt.Dimension(500, 300));
		middlePanel.setMinimumSize(new java.awt.Dimension(500, 300));

		JScrollPane scroller = new JScrollPane();
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setPreferredSize(new Dimension(480, 200));
		scroller.setMinimumSize(new Dimension(480, 200));
		scroller.setMaximumSize(new Dimension(480, 200));

		notes.setLineWrap(true);
		notes.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.SoftBevelBorder.LOWERED));

		notes.setPreferredSize(new java.awt.Dimension(480, 200));
		notes.setMinimumSize(new java.awt.Dimension(480, 200));
		notes.setMaximumSize(new java.awt.Dimension(480, 200));

		// scroller.add(notes);
		frame.getContentPane().add(notes);

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setPreferredSize(new java.awt.Dimension(500, 50));
		bottomPanel.setMaximumSize(new java.awt.Dimension(500, 50));
		bottomPanel.setMinimumSize(new java.awt.Dimension(500, 50));

		// Create and add Clear and Quit buttons
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				notes.setText("");
				labelLetterTimer.setVisible(false);
				letterBuffer = new StringBuffer();
				textBuffer = new StringBuffer();

			}
		});

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

		bottomPanel.add(btnClear);
		bottomPanel.add(btnQuit);
		frame.getContentPane().add(bottomPanel);
		frame.setVisible(true);

	} // end of the constructor

	public void handleClicks() {

		morsePanel.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				setLabelLetterTimerText();

				if (e.isMetaDown()) { // right click
					if (System.currentTimeMillis() - lastClickTime < TIME_GAP) {
						letterBuffer.append("0");
						morseSound.playDash();
						lastClickTime = System.currentTimeMillis();
						labelLetterTimer.setText(setLabelLetterTimerText());
					} else {

						try {
							letter = mt.getValue(letterBuffer.toString());
							appendTextToBuffer(letter);
							letter = 0; // null
							labelLetterTimer.setVisible(false);
						} catch (NullPointerException ex) {
							JOptionPane.showMessageDialog(frame,
									ex.getMessage(), "Check again",
									JOptionPane.INFORMATION_MESSAGE);
						}

						letterBuffer = new StringBuffer();
						letterBuffer.append("0");
						morseSound.playDash();
						lastClickTime = System.currentTimeMillis();

					}
					lastClickTime = System.currentTimeMillis();

				} else { // normal click

					if (System.currentTimeMillis() - lastClickTime < TIME_GAP) {
						letterBuffer.append("1");
						morseSound.playDot();
						lastClickTime = System.currentTimeMillis();
						labelLetterTimer.setText(setLabelLetterTimerText());

					} else {

						try {
							letter = mt.getValue(letterBuffer.toString());
							appendTextToBuffer(letter);
							letter = 0; // null
							labelLetterTimer.setVisible(false);
						} catch (ElementNotFoundException ex) {
							JOptionPane.showMessageDialog(frame,
									ex.getMessage(), "Please try again...",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(frame,
									ex.getMessage(), "Please try again...",
									JOptionPane.ERROR_MESSAGE);
						}
						letterBuffer = new StringBuffer();
						letterBuffer.append("1");
						morseSound.playDot();
						lastClickTime = System.currentTimeMillis();

					}
				}
			}

		});

	}

	public void appendTextToBuffer(char letter) {
		if (letter != '#') {
			textBuffer.append(letter);
		}
	}
	public String getTextBuffer() {
		return textBuffer.toString();
	}

	private String setLabelLetterTimerText() {
		String message = letterBuffer.toString();
		message = message.replaceAll("1", "\\.");
		message = message.replaceAll("0", "-");
		labelLetterTimer.setVisible(true);
		return message;
	}

	public static void main(String[] args) {
		new MorseWindow();

	}
}
