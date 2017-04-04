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
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
	import java.util.Locale;
	import java.util.concurrent.TimeUnit;

	import javax.swing.JComboBox;
	import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;


	public class MainAgeCalculator extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5955805502901982528L;

		private JTextField textField, textField_3;

		/**
		 * Launch the application.
		 */
		int age, months, days, daysbef, min, h, secs;
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
			setBounds(100, 100, 480, 200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//String lists to use in the visible lists for month day year hours and minutes
			String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13","14","15", "16", "17", "18", "19", "20", "21", "22", "23", "24","25","26","27", "28", "29", "30", "31"};
			String[] year = {"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991","1992","1993","1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003","2004","2005","2006", "2007", "2008", "2009", "2010", "2011","2012","2013","2014","2015", "2016", "2017"};
			String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12","13","14","15", "16", "17", "18", "19", "20", "21", "22", "23"};
			String[] minutes = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
			
			
			getContentPane().setLayout(null);
			//declaration and initialisation of five combo boxes
			final JComboBox daycombox = new JComboBox(day);
			daycombox.setBounds(10, 11, 49, 20);
			daycombox.setMaximumRowCount(10);
			getContentPane().add(daycombox);
		
			
			final JComboBox monthComboBox = new JComboBox(month);
			monthComboBox.setBounds(69, 11, 77, 20);
			monthComboBox.setMaximumRowCount(10);
			getContentPane().add(monthComboBox);
			
			final JComboBox yearComboBox = new JComboBox(year);
			yearComboBox.setBounds(156, 11, 59, 20);
			yearComboBox.setMaximumRowCount(10);
			getContentPane().add(yearComboBox);
			
			JComboBox hoursComboBox = new JComboBox(hours);
			hoursComboBox.setBounds(225, 11, 49, 20);
			hoursComboBox.setMaximumRowCount(10);
			getContentPane().add(hoursComboBox);
			
			JComboBox minutesComboBox = new JComboBox(minutes);
			minutesComboBox.setBounds(282, 11, 49, 20);
			yearComboBox.setMaximumRowCount(10);
			getContentPane().add(minutesComboBox);
			
			//button to calculate age, once triggered the selected date from combo boxes are being saved in strings 
			JButton btnNewButton = new JButton("Calculate Age");
			btnNewButton.setBounds(335, 10, 119, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String selecteday = (String) daycombox.getSelectedItem();
					String selectedmonth = (String) monthComboBox.getSelectedItem();
					String selectedyear = (String) yearComboBox.getSelectedItem();
					String selectedhours = (String) hoursComboBox.getSelectedItem();
					String selectedminutes = (String) minutesComboBox.getSelectedItem();
					//we create a string in the format of "MMMM d, yyyy HH:mm" from the selected date
					String date = selectedmonth + " " +selecteday + ", " + selectedyear +" "+selectedhours+":"+selectedminutes;
					
					
					DateFormat format = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
					Date currentdate = new Date();
				
					try {
							//transform string to date
							Date birthdaydate = format.parse(date);
							//transform date to localdate so it can be used with period.between
							LocalDate dc = currentdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
							LocalDate db = birthdaydate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
							Period period = Period.between(db, dc);
							//calculate the difference between current date and birthday date and save it in long variable
						 	long diffInMillies = currentdate.getTime() - birthdaydate.getTime();
						 	//calculate seconds, minutes and hours from the long variable (difference from current to birthday)
						 	secs = (int) (TimeUnit.SECONDS.convert(diffInMillies,TimeUnit.MILLISECONDS) % 60);
						 	min =  (int) (TimeUnit.SECONDS.convert(diffInMillies,TimeUnit.MILLISECONDS) / 60) % 60;
						 	h = (int) ((TimeUnit.SECONDS.convert(diffInMillies,TimeUnit.MILLISECONDS) / 60) / 60)%24 +1;
						 	//calculate age, days, months using period
						 	days = period.getDays();
						 	months = period.getMonths();
						 	age = period.getYears(); 
							//set both textfields with the age	in years, months, days, hours, minutes, seconds		 						 	
						 	textField = new JTextField("  Your are alive: " + Integer.toString(age) + " years " + Integer.toString(months) + " months "+ Integer.toString(days) +" days ");
							textField.setBackground(UIManager.getColor("Button.background"));
							textField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,UIManager.getColor("Button.background")));
							textField.setBounds(20, 50, 450, 50);
							getContentPane().add(textField);
							textField.setFont(new Font("Tahoma", Font.BOLD, 15));
							textField.setForeground(Color.PINK);
							textField.setColumns(10);
							textField_3 = new JTextField("  "+Integer.toString(h) + " hours "+ Integer.toString(min)+" minutes and "+Integer.toString(secs)+" seconds!");
							textField_3.setBackground(UIManager.getColor("Button.background"));
							textField_3.setBorder(BorderFactory.createMatteBorder(2,2,2,2,UIManager.getColor("Button.background")));
							textField_3.setBounds(20, 95, 450, 50);
							getContentPane().add(textField_3);
							textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
							textField_3.setForeground(Color.PINK);
							textField_3.setColumns(10);
						
					} catch (ParseException e) {
						//Auto-generated catch block
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
			textField_2.setBounds(270, 10, 16, 20);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			
	
			
			
			

		}
	}

