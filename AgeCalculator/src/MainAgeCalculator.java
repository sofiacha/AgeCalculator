	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import java.awt.FlowLayout;
	import javax.swing.JTextField;
import javax.swing.BorderFactory;
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
import java.awt.Color;
import java.awt.Font;


	public class MainAgeCalculator extends JFrame {
		private JTextField textField;
		private JTextField textField_1;

		/**
		 * Launch the application.
		 */
		int age;
		private JTextField textField_2;
		
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
			getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
			setTitle("Utility frame");
			setBounds(100, 100, 470, 150);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//final String date;
			String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13","14","15", "16", "17", "18", "19", "20", "21", "22", "23", "24","25","26","27", "28", "29", "30", "31"};
			String[] year = {"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991","1992","1993","1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003","2004","2005","2006", "2007", "2008", "2009", "2010", "2011","2012","2013","2014","2015", "2016", "2017"};
			String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12","13","14","15", "16", "17", "18", "19", "20", "21", "22", "23"};
			String[] minutes = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
			
			
			getContentPane().setLayout(null);
			
			final JComboBox daycombox = new JComboBox(day);
			daycombox.setBounds(10, 11, 37, 20);
			daycombox.setMaximumRowCount(10);
			getContentPane().add(daycombox);
		
			
			final JComboBox monthComboBox = new JComboBox(month);
			monthComboBox.setBounds(57, 11, 77, 20);
			monthComboBox.setMaximumRowCount(10);
			getContentPane().add(monthComboBox);
			
			final JComboBox yearComboBox = new JComboBox(year);
			yearComboBox.setBounds(144, 11, 59, 20);
			yearComboBox.setMaximumRowCount(10);
			getContentPane().add(yearComboBox);
			
			JComboBox hoursComboBox = new JComboBox(hours);
			hoursComboBox.setBounds(213, 11, 49, 20);
			hoursComboBox.setMaximumRowCount(10);
			getContentPane().add(hoursComboBox);
			
			JComboBox minutesComboBox = new JComboBox(minutes);
			minutesComboBox.setBounds(272, 11, 49, 20);
			yearComboBox.setMaximumRowCount(10);
			getContentPane().add(minutesComboBox);
			//System.out.println(age);
			
			JButton btnNewButton = new JButton("Calculate Age");
			btnNewButton.setBounds(325, 10, 119, 23);
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
						 	
						 	textField = new JTextField("  Your age is: " + Integer.toString(age));
							textField.setBackground(UIManager.getColor("Button.background"));
							textField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,UIManager.getColor("Button.background")));
							textField.setBounds(20, 50, 170, 50);
							getContentPane().add(textField);
							textField.setFont(new Font("Tahoma", Font.BOLD, 20));
							textField.setForeground(Color.PINK);
							textField.setColumns(10);
						 	//System.out.println(i);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			});
			getContentPane().add(btnNewButton);
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			textField_2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,UIManager.getColor("Button.background")));
			textField_2.setText(" :");
			textField_2.setForeground(Color.BLACK);
			textField_2.setBackground(UIManager.getColor("Button.background"));
			textField_2.setBounds(259, 11, 16, 20);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			
	
			
			
			

		}
	}

