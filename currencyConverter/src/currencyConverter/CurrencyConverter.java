package currencyConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField jtxtAmount;
	private JTextField jtxtAmountConverted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter frame = new CurrencyConverter();
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
	public CurrencyConverter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 700);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(95, 158, 160), 14));
		panel.setBounds(29, 24, 866, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel.setBounds(113, 11, 871, 65);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(95, 158, 160), 14));
		panel_1.setBounds(29, 129, 866, 275);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_1.setBounds(45, 49, 318, 53);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("From Currency");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_1_1.setBounds(45, 113, 318, 53);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("To Currency");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_1_2.setBounds(45, 172, 318, 53);
		panel_1.add(lblNewLabel_1_2);
		
		jtxtAmount = new JTextField();
		jtxtAmount.setFont(new Font("Tahoma", Font.BOLD, 45));
		jtxtAmount.setBounds(373, 42, 459, 60);
		panel_1.add(jtxtAmount);
		jtxtAmount.setColumns(10);
		
		JComboBox jcmbFromCurrency = new JComboBox();
		jcmbFromCurrency.setModel(new DefaultComboBoxModel(new String[] {"GBP - Britain", "CAD - Canadian", "USD - United States Dollars", "NGN -Nigerian Naria", "MXN - Mexcan Peso", "EUR - Euro", "CHF - Swiss Franc", "AUD - Australian", "CNY -Indian Rupee"}));
		jcmbFromCurrency.setBounds(373, 105, 459, 61);
		panel_1.add(jcmbFromCurrency);
		
		JComboBox jcmbToCurrency = new JComboBox();
		jcmbToCurrency.setModel(new DefaultComboBoxModel(new String[] {"GBP - Britain", "CAD - Canadian", "USD - United States Dollars", "NGN -Nigerian Naria", "MXN - Mexcan Peso", "EUR - Euro", "CHF - Swiss Franc", "AUD - Australian", "CNY -Indian Rupee"}));
		jcmbToCurrency.setBounds(373, 172, 459, 61);
		panel_1.add(jcmbToCurrency);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(95, 158, 160), 14));
		panel_2.setBounds(29, 408, 866, 100);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Amount Converted");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1_3.setBounds(39, 25, 334, 53);
		panel_2.add(lblNewLabel_1_3);
		
		jtxtAmountConverted = new JTextField();
		jtxtAmountConverted.setFont(new Font("Tahoma", Font.BOLD, 35));
		jtxtAmountConverted.setColumns(10);
		jtxtAmountConverted.setBounds(372, 21, 459, 60);
		panel_2.add(jtxtAmountConverted);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(95, 158, 160), 14));
		panel_3.setBounds(29, 514, 866, 100);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount,convertAmount;
				String toCurrency, fromCurrency;
				try {
					amount=Double.parseDouble(jtxtAmount.getText());
				}
				catch(NumberFormatException ex) {
					JOptionPane.showConfirmDialog(null, "Please enter a valid number!","Exclamation",JOptionPane.ERROR_MESSAGE);
					jtxtAmount.setText("");
					jtxtAmount.requestFocus();
					return;
				}
				fromCurrency= jcmbFromCurrency.getSelectedItem().toString().substring(0,3);
				toCurrency= jcmbToCurrency.getSelectedItem().toString().substring(0,3);
				convertAmount=converterCurrency(amount,fromCurrency,toCurrency);
				jtxtAmountConverted.setText(String.format("%.2f %s = %.2f %s", amount,fromCurrency, convertAmount, toCurrency));
		}});
		btnConverter.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnConverter.setBounds(34, 30, 252, 34);
		panel_3.add(btnConverter);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			private JFrame frame;
			public void actionPerformed(ActionEvent e) {
				frame= new JFrame ("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit?","Currency Converter" , JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnExit.setBounds(582, 30, 252, 34);
		panel_3.add(btnExit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtAmount.setText("");
				jtxtAmountConverted.setText("");
				jcmbToCurrency.setSelectedIndex(-1);
				jcmbFromCurrency.setSelectedIndex(-1);
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnReset.setBounds(306, 30, 252, 34);
		panel_3.add(btnReset);
	}
	public double converterCurrency(double amount, String fromCurrency, String toCurrency) {
		Map<String, Double> conversionRate = new HashMap<>();
		conversionRate.put("GBP",1.0);
		conversionRate.put("CAD",1.87);
		conversionRate.put("USD",1.89);
		conversionRate.put("NGN",1674.76);
		conversionRate.put("MXN",30.54);
		conversionRate.put("EUR",1.45);
		conversionRate.put("CHF",1.37);
		conversionRate.put("AUD",1.97);
		conversionRate.put("CNY",9.93);
		conversionRate.put("INR",108.86);
		if(!conversionRate.containsKey(fromCurrency)|| !conversionRate.containsKey(toCurrency)) {
			throw new IllegalArgumentException("Invalid currency code!");
		}
		return amount* conversionRate.get(toCurrency)/conversionRate.get(fromCurrency);
		}
}
