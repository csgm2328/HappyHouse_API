package com.ssafy.happyHouse.model;

public class HouseDto {
    int no;             // PK 번호
    String dong;        // 법정동
    String aptName;     // 아파트 이름
    String dealAmount;  // 매매가격
    String buildYear;   // 건축년도
    String dealYear;    // 거래년
    String dealMonth;   // 거래월
    String dealDay;     // 거래일
    String area;        // 면적
    String floor;       // 층
    String jibun;       // 지번
    double lat;
    double lng;
    
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "HouseDto [no=" + no + ", dong=" + dong + ", aptName=" + aptName + ", dealAmount=" + dealAmount
				+ ", buildYear=" + buildYear + ", dealYear=" + dealYear + ", dealMonth=" + dealMonth + ", dealDay="
				+ dealDay + ", area=" + area + ", floor=" + floor + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng
				+ "]";
	}
	public HouseDto() {

    }
    public HouseDto(int no, String dong, String aptName, String dealAmount, String buildYear, String dealYear, String dealMonth, String dealDay, String area, String floor, String jibun) {
        this.no = no;
        this.dong = dong;
        this.aptName = aptName;
        this.dealAmount = dealAmount;
        this.buildYear = buildYear;
        this.dealYear = dealYear;
        this.dealMonth = dealMonth;
        this.dealDay = dealDay;
        this.area = area;
        this.floor = floor;
        this.jibun = jibun;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getAptName() {
        return aptName;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public String getDealYear() {
        return dealYear;
    }

    public void setDealYear(String dealYear) {
        this.dealYear = dealYear;
    }

    public String getDealMonth() {
        return dealMonth;
    }

    public void setDealMonth(String dealMonth) {
        this.dealMonth = dealMonth;
    }

    public String getDealDay() {
        return dealDay;
    }

    public void setDealDay(String dealDay) {
        this.dealDay = dealDay;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getJibun() {
        return jibun;
    }

    public void setJibun(String jibun) {
        this.jibun = jibun;
    }
}
