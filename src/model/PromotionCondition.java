package model;

public class PromotionCondition {
    private int id;
    private int promotionId;
    private String conditionType;
    private String conditionValue;

    public PromotionCondition(int promotionId, String conditionType, String conditionValue) {
        this.promotionId = promotionId;
        this.conditionType = conditionType;
        this.conditionValue = conditionValue;
    }

    public int getId() {
        return id;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    @Override
    public String toString() {
        return "PromotionCondition{" +
                "id=" + id +
                ", promotionId=" + promotionId +
                ", conditionType='" + conditionType + '\'' +
                ", conditionValue='" + conditionValue + '\'' +
                '}';
    }
}
