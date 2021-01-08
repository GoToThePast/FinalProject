package model;

public class Goods {
    int goodsID;
    String goodsName="";
    String goodsType="";
    int goodsPrice;
    int goodsStock;
    int goodsSellID;
    String goodsIntroduce="";
    String goodsPicUrl="";
    public Goods() {
    }

    public Goods( int goodsID,String goodsName, String goodsType,int goodsPrice, int goodsStock,int goodsSellID,String goodsIntroduce,String goodsPicUrl) {
        this.goodsID=goodsID;
        this.goodsName=goodsName;
        this.goodsType=goodsType;
        this.goodsPrice=goodsPrice;
        this.goodsStock=goodsStock;
        this.goodsSellID=goodsSellID;
        this.goodsIntroduce=goodsIntroduce;
        this.goodsPicUrl=goodsPicUrl;

    }



    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {

        this.goodsType = goodsType;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsStock() {

        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }
    public int getGoodsSellID() {

        return goodsSellID;
    }

    public void setGoodsSellID(int goodsSellID) {
        this.goodsSellID = goodsSellID;
    }
    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsPicUrl() {

        return goodsPicUrl;
    }

    public void setGoodsPicUrl(String goodsPicUrl) {
        this.goodsPicUrl = goodsPicUrl;
    }
}
