
class Order {

    private final String name;
    private final int quantity;
    private boolean isFilled;

    Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    void fill(Warehouse warehouse) {

        if (warehouse.hasInventory(name, quantity)) {
            warehouse.remove(name, quantity);
            isFilled = true;
        }
    }

    public boolean isFilled() {
        return isFilled;
    }
}
