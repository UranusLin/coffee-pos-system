package model;

public class PromotionAction {
    private int id;
    private int promotionId;
    private String actionType;
    private String actionValue;

    public PromotionAction(int promotionId, String actionType, String actionValue) {
        this.promotionId = promotionId;
        this.actionType = actionType;
        this.actionValue = actionValue;
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

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

    @Override
    public String toString() {
        return "PromotionAction{" +
                "id=" + id +
                ", promotionId=" + promotionId +
                ", actionType='" + actionType + '\'' +
                ", actionValue='" + actionValue + '\'' +
                '}';
    }
}
