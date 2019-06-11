
public class CashContextDZ {
	CashSuper cs = null;

	public CashContextDZ(String type) {
		switch (type) {
		case "¾ÅÕÛ":
			CashRebate cr9 = new CashRebate("0.9");
			cs = cr9;
			break;
		case "°ËÕÛ":
			CashRebate cr8 = new CashRebate("0.8");
			cs = cr8;
			break;
		case "ÆßÕÛ":
			CashRebate cr7 = new CashRebate("0.7");
			cs = cr7;
			break;
		case "ÁùÕÛ":
			CashRebate cr6 = new CashRebate("0.6");
			cs = cr6;
			break;
		case "ÎåÕÛ":
			CashRebate cr5 = new CashRebate("0.5");
			cs = cr5;
			break;
		case "ËÄÕÛ":
			CashRebate cr4 = new CashRebate("0.4");
			cs = cr4;
			break;
		case "ÈıÕÛ":
			CashRebate cr3 = new CashRebate("0.3");
			cs = cr3;
			break;

		default:
			System.out.println("²»´òÕÛ");
		}

	}

	public double GetResult(double money) {
		return cs.acceptCash(money);
	}

}
