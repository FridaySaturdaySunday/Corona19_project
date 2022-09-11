package kh.java.data.corona19.model.vo;

public class Corona19Info {

	private long deathCnt;
	private long defCnt;
	private String gubun;
	private String gubunCn;
	private String gubunEn;
	private long incDec;
	private long isolClearCnt;
	private long isolIngCnt; 
	private long localOccCnt;
	private long overFlowCnt;
	private long qurRate;
	private String stdDay;
	
	// Constructor 기본
	public Corona19Info() {
		super();
	}
	
	// Constructor field all
	public Corona19Info(long deathCnt, long defCnt, String gubun, String gubunCn, String gubunEn, long incDec,
			long isolClearCnt, long isolIngCnt, long localOccCnt, long overFlowCnt, long qurRate, String stdDay) {
		super();
		this.deathCnt = deathCnt;
		this.defCnt = defCnt;
		this.gubun = gubun;
		this.gubunCn = gubunCn;
		this.gubunEn = gubunEn;
		this.incDec = incDec;
		this.isolClearCnt = isolClearCnt;
		this.isolIngCnt = isolIngCnt;
		this.localOccCnt = localOccCnt;
		this.overFlowCnt = overFlowCnt;
		this.qurRate = qurRate;
		this.stdDay = stdDay;
	}
	
	// toString all
	@Override
	public String toString() {
		return "Corona19Info [deathCnt=" + deathCnt + ", defCnt=" + defCnt + ", gubun=" + gubun + ", gubunCn=" + gubunCn
				+ ", gubunEn=" + gubunEn + ", incDec=" + incDec + ", isolClearCnt=" + isolClearCnt + ", isolIngCnt="
				+ isolIngCnt + ", localOccCnt=" + localOccCnt + ", overFlowCnt=" + overFlowCnt + ", qurRate=" + qurRate
				+ ", stdDay=" + stdDay + "]";
	}
	
	// getter / setter
	public long getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(long deathCnt) {
		this.deathCnt = deathCnt;
	}
	public long getDefCnt() {
		return defCnt;
	}
	public void setDefCnt(long defCnt) {
		this.defCnt = defCnt;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getGubunCn() {
		return gubunCn;
	}
	public void setGubunCn(String gubunCn) {
		this.gubunCn = gubunCn;
	}
	public String getGubunEn() {
		return gubunEn;
	}
	public void setGubunEn(String gubunEn) {
		this.gubunEn = gubunEn;
	}
	public long getIncDec() {
		return incDec;
	}
	public void setIncDec(long incDec) {
		this.incDec = incDec;
	}
	public long getIsolClearCnt() {
		return isolClearCnt;
	}
	public void setIsolClearCnt(long isolClearCnt) {
		this.isolClearCnt = isolClearCnt;
	}
	public long getIsolIngCnt() {
		return isolIngCnt;
	}
	public void setIsolIngCnt(long isolIngCnt) {
		this.isolIngCnt = isolIngCnt;
	}
	public long getLocalOccCnt() {
		return localOccCnt;
	}
	public void setLocalOccCnt(long localOccCnt) {
		this.localOccCnt = localOccCnt;
	}
	public long getOverFlowCnt() {
		return overFlowCnt;
	}
	public void setOverFlowCnt(long overFlowCnt) {
		this.overFlowCnt = overFlowCnt;
	}
	public long getQurRate() {
		return qurRate;
	}
	public void setQurRate(long qurRate) {
		this.qurRate = qurRate;
	}
	public String getStdDay() {
		return stdDay;
	}
	public void setStdDay(String stdDay) {
		this.stdDay = stdDay;
	}
	
	
	
	
	
	
}
















