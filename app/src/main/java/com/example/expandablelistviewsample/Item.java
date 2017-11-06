package com.example.expandablelistviewsample;

public class Item {
    /** 名前 */
    private String name;
    /** 説明 */
    private String info;
    /** 緯度 */
    private double latitude;
    /** 経度 */
    private double longitude;

    /**
     * 情報を指定し、アイテムを作成する。
     * @param name 名前
     * @param info 説明
     * @param latitude 緯度
     * @param longitude 経度
     */
    public Item(String name, String info, double latitude, double longitude) {
        this.name = name;
        this.info = info;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * 名前を取得する。
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 説明を取得する。
     * @return 説明
     */
    public String getInfo() {
        return info;
    }

    /**
     * 緯度を取得する。
     * @return 緯度
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * 経度を取得する。
     * @return 経度
     */
    public double getLongitude() {
        return longitude;
    }
}
