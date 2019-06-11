
public class CashContextDZ {
	CashSuper cs = null;

	public CashContextDZ(String type) {
		switch (type) {
		case "����":
			CashRebate cr9 = new CashRebate("0.9");
			cs = cr9;
			break;
		case "����":
			CashRebate cr8 = new CashRebate("0.8");
			cs = cr8;
			break;
		case "����":
			CashRebate cr7 = new CashRebate("0.7");
			cs = cr7;
			break;
		case "����":
			CashRebate cr6 = new CashRebate("0.6");
			cs = cr6;
			break;
		case "����":
			CashRebate cr5 = new CashRebate("0.5");
			cs = cr5;
			break;
		case "����":
			CashRebate cr4 = new CashRebate("0.4");
			cs = cr4;
			break;
		case "����":
			CashRebate cr3 = new CashRebate("0.3");
			cs = cr3;
			break;

		default:
			System.out.println("������");
		}

	}

	public double GetResult(double money) {
		return cs.acceptCash(money);
	}

}
