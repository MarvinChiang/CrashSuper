
public class CashContextMS {

	CashSuper cs = null;

	public CashContextMS(String type) {
		switch (type) {
		case "��300��100":
			CashReturn cr31 = new CashReturn("300", "100");
			cs = cr31;
			break;
		case "��500��200":
			CashReturn cr52 = new CashReturn("500", "200");
			cs = cr52;
			break;
		case "��700��400":
			CashReturn cr74 = new CashReturn("700", "400");
			cs = cr74;
			break;
		default:
			System.out.println("1������");
		}
	}

	public double GetResult(double money) {
		return cs.acceptCash(money);
	}

}
