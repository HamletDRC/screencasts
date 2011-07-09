import spock.lang.Specification

class WarehouseTest extends Specification {

    private final static TALISKER = 'talisker'

    def 'fill an order when you have enough in the warehouse'() {
        given:
        def order = new Order(TALISKER, 50)
        Warehouse warehouse = Mock()

        when:
        warehouse.hasInventory(_, _) >> true
        order.fill(warehouse)

        then:
        order.filled
        1 * warehouse.remove(TALISKER, 50)
    }

    def "do not fill an order when you have enough in the warehouse"() {
        given:
        def order = new Order(TALISKER, 50)
        Warehouse warehouse = Mock()

        when:
        warehouse.hasInventory(_, _) >> false
        order.fill(warehouse)

        then:
        !order.filled
        0 * warehouse.remove(_, _)
    }

    def "filling an order posts an event to the event bus"() {
        given:
        EventBus eventBus = Mock()
        def warehouse = new Warehouse(eventBus)

        when:
        warehouse.remove(TALISKER, 50)

        then:
        1 * eventBus./post(Sync|Async)/(_, {
            def root = new XmlSlurper().parseText(it)
            root.data.@name == TALISKER && root.data.@quantity == 50
        })
    }
}
