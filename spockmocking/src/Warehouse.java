

public class Warehouse {

    private final EventBus eventBus;

    public Warehouse(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public Warehouse() {
        this(new EventBus());
    }

    public boolean hasInventory(String name, int quantity) {
        return true;
    }

    public void remove(String name, int quantity) {
        eventBus.postAsync("removeItem", "<event><data name=\"" + name + "\" quantity=\"" + quantity + "\" /></event>");
    }
}
