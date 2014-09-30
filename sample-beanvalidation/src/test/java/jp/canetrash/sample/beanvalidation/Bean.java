package jp.canetrash.sample.beanvalidation;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class Bean {

	@NotNull(message = "なんかいれろ")
	private String str;

	@Digits(fraction = 0, integer = 3, message = "数字じゃない")
	private String strInt;

	@Max(value = 10, message = "大きすぎです")
	@Min(value = 5, message = "小さすぎです")
	private Integer integer;

	private BigDecimal decimal;

	@AssertFalse(message = "Falseじゃない")
	private boolean bool1 = true;

	@AssertTrue(message = "Trueじゃない")
	private Boolean bool2 = false;

	@Future(message = "未来日ではありません")
	private Date date1;

	@Past(message = "過去日ではありません")
	private Date date2;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public BigDecimal getDecimal() {
		return decimal;
	}

	public void setDecimal(BigDecimal decimal) {
		this.decimal = decimal;
	}

	public String getStrInt() {
		return strInt;
	}

	public void setStrInt(String strInt) {
		this.strInt = strInt;
	}

	public boolean isBool1() {
		return bool1;
	}

	public void setBool1(boolean bool1) {
		this.bool1 = bool1;
	}

	public Boolean getBool2() {
		return bool2;
	}

	public void setBool2(Boolean bool2) {
		this.bool2 = bool2;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}
}
