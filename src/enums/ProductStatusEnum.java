package enums;

public enum ProductStatusEnum {
    SALE("sale"),
    NotSale("not-sale"),
    OutOfStock("out-of-stock");

    private final String showName;

    ProductStatusEnum(String showName) {
        this.showName = showName;
    }

    public String getShowName() {
        return showName;
    }

    public static ProductStatusEnum getEnum(String showName) {
        for (ProductStatusEnum productStatusEnum: ProductStatusEnum.values()) {
            if (productStatusEnum.showName.equals(showName)) {
                return productStatusEnum;
            }
        }
        return null;
    }
}