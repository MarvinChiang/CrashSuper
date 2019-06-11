import javax.swing.JCheckBox;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import javax.swing.JButton;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744383142579599285L;
	static double temporary, total = 0;
	int index;

	public static double YuanJia;

	public static final double getYuanJia() {
		return YuanJia;
	}

	public static final void setYuanJia(double yuanJia) {
		YuanJia = yuanJia;
	};

	JLabel lName = new JLabel("原价：");
	JFrame xitong = new JFrame("打折系统");
	JButton button = new JButton("计算");
	JLabel l = new JLabel("先满送再打折");
	JTextField ShuRuKuang = new JTextField("1000");
	JTextArea jieguo1 = new JTextArea();
	JTextArea jieguo2 = new JTextArea();
	static JCheckBox DaZhe = new JCheckBox("打折");
	static JCheckBox ManSong = new JCheckBox("满送");
	JLabel xiaoji = new JLabel("小计：");
	JLabel leiji = new JLabel("累计：");
	static String[] discount = new String[] { "九折", "八折", "七折", "六折", "五折", "四折", "三折" };
	static String[] fullSent = new String[] { "满300送100", "满500送200", "满700送400" };
	static JComboBox<String> Discount = new JComboBox<String>(discount);
	JComboBox<String> FullSent = new JComboBox<String>(fullSent);

	public static void main(String[] args) {
		GUI t = new GUI();

		t.button.addActionListener(t.new MyActionListener());

	}

	public GUI() {

		this.setTitle("窗口");
		this.setSize(800, 300);
		this.setLocation(200, 200);
		this.setLayout(new FlowLayout());
		ShuRuKuang.setPreferredSize(new Dimension(100, 30));
		this.add(lName);
		this.add(ShuRuKuang);
		l.setForeground(Color.red);
		l.setBounds(300, 50, 270, 30);
		this.add(l);
		DaZhe.setBounds(50, 50, 130, 30);
		ManSong.setBounds(50, 100, 130, 30);
		DaZhe.setSelected(false);
		ManSong.setSelected(false);
		this.add(ManSong);
		this.add(DaZhe);
		FullSent.setBounds(200, 100, 80, 80);
		Discount.setBounds(300, 100, 80, 80);
		this.add(FullSent);
		this.add(Discount);

		jieguo1.setPreferredSize(new Dimension(300, 50));
		jieguo1.setLineWrap(true);
		jieguo2.setPreferredSize(new Dimension(300, 50));
		jieguo2.setLineWrap(true);
		this.add(xiaoji);
		this.add(jieguo1);
		this.add(leiji);
		this.add(jieguo2);
		button.setBounds(50, 50, 280, 30);
		this.add(button, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			index++;

			System.out.println("按钮被活动" + index + "次");

			setYuanJia(Double.valueOf(ShuRuKuang.getText()));

			temporary = getYuanJia();
			jieguo1.setText("原价"+String.valueOf(temporary));
			if (getManSong()) {
				new CashContextMS(String.valueOf(FullSent.getSelectedItem()));
				CashContextMS csuper = new CashContextMS(String.valueOf(FullSent.getSelectedItem()));
				double prices = csuper.GetResult(temporary);
				jieguo1.setText(String.valueOf(FullSent.getSelectedItem()) + "-->" + String.valueOf(prices) + "\t");
				temporary = prices;

			}

			if (getDaZhe())

			{
				System.out.println(temporary);

				new CashContextDZ(String.valueOf(Discount.getSelectedItem()));
				CashContextDZ csuper = new CashContextDZ(String.valueOf(Discount.getSelectedItem()));
				double prices = csuper.GetResult(temporary);

				jieguo1.append(String.valueOf(Discount.getSelectedItem()) + "-->" + String.valueOf(prices) + "\t");

			}

			total = total + temporary;
			jieguo2.setText("第"+index+"件物品累计"+String.valueOf(total)+"元");
		}

	}

	public boolean getManSong() {
		return ManSong.isSelected();
	}

	public boolean getDaZhe() {
		return DaZhe.isSelected();
	}
}
