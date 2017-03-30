	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import java.awt.FlowLayout;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import javax.swing.JList;
	import javax.swing.JScrollPane;
	import javax.swing.ListSelectionModel;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Locale;
	import java.util.concurrent.TimeUnit;

	import javax.swing.JComboBox;
	import javax.swing.UIManager;


	public class MainAgeCalculator extends JFrame {
		private JTextField textField;
		private JTextField textField_1;

		/**
		 * Launch the application.
		 */
		int age;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MainAgeCalculator frame = new MainAgeCalculator();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public MainAgeCalculator() {
			setTitle("Utility frame");
			setBounds(100, 100, 450, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//final String date;
			String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13","14","15", "16", "17", "18", "19", "20", "21", "22", "23", "24","25","26","27", "28", "29", "30", "31"};
			String[] year = {"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991","1992","1993","1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003","2004","2005","2006", "2007", "2008", "2009", "2010", "2011","2012","2013","2014","2015", "2016", "2017"};
			getContentPane().setLayout(null);
			
			final JComboBox daycombox = new JComboBox(day);
			daycombox.setBounds(78, 6, 37, 20);
			daycombox.setMaximumRowCount(10);
			getContentPane().add(daycombox);
		
			
			final JComboBox monthComboBox = new JComboBox(month);
			monthComboBox.setBounds(120, 6, 77, 20);
			monthComboBox.setMaximumRowCount(10);
			getContentPane().add(monthComboBox);
			
			final JComboBox yearComboBox = new JComboBox(year);
			yearComboBox.setBounds(202, 6, 49, 20);
			yearComboBox.setMaximumRowCount(10);
			getContentPane().add(yearComboBox);
			
			JButton btnNewButton = new JButton("Calculate Age");
			btnNewButton.setBounds(256, 5, 139, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String selecteday = (String) daycombox.getSelectedItem();
					String selectedmonth = (String) monthComboBox.getSelectedItem();
					String selectedyear = (String) yearComboBox.getSelectedItem();
					String date = selectedmonth + " " +selecteday + ", " + selectedyear;
					//System.out.println(date);
					
					DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
					DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
					Date currentdate = new Date();
					System.out.println(dateFormat.format(currentdate));
					try {
						Date realdate = format.parse(date);
						System.out.println(dateFormat.format(realdate));
						 	long diffInMillies = currentdate.getTime() - realdate.getTime();
						 	System.out.println(TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS));
						 	age = (int) (TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS) / 365);
						 	
						 	textField = new JTextField("Your age is: " + Integer.toString(age));
							textField.setBackground(UIManager.getColor("Button.background"));
							textField.setBounds(78, 45, 277, 190);
							getContentPane().add(textField);
							textField.setColumns(10);
						 	//System.out.println(i);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			});
			getContentPane().add(btnNewButton);
			//System.out.println(age);
			
			
			

		}
	}

