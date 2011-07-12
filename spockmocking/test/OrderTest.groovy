import spock.lang.Specification

public class OrderTest extends Specification {

    private static TALISKER = 'talisker'

    def "fill an order when you have enough in the warehouse"() {
        given:
        def order = new Order(TALISKER, 50)
        Warehouse warehouse = Mock()

        when:
        warehouse.hasInventory(TALISKER, 50) >> true
        order.fill(warehouse)

        then:
        order.filled
        1* warehouse.remove(TALISKER, 51)
    }

    def "do no fill an order when you have no inventory"() {
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

    def "fill an order posts an event to the event bus"() {
        given:
        EventBus bus = Mock()
        def warehouse = new Warehouse(bus)

        when:
        warehouse.remove(TALISKER, 50)

        then:
        1 * bus./post(Sync|Async)/(_, {
            def root = new XmlSlurper().parseText(it)
            root.data.@name == TALISKER && root.data.@quantity == 50
        })
    }
}
