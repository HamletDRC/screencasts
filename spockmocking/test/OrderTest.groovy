import spock.lang.Specification

public class OrderTest extends Specification {

    def "fill an order when there is enough inventory"() {
        given:
        def order = new Order('talisker', 50)
        Warehouse warehouse = Mock()

        when:
        warehouse.hasInventory('talisker', 50) >> true
        order.fill(warehouse)

        then:
        order.filled
        1 * warehouse.remove('talisker', 50)
    }

    def "do not fill an order when missing inventory"() {
        given:
        def order = new Order('talisker', 50)
        Warehouse warehouse = Mock()

        when:
        warehouse.hasInventory(_, _) >> false
        order.filled

        then:
        !order.filled
        0 * warehouse.remove(_, _)
    }

    def "test event messages are posted"() {
        given:
        EventBus eventBus = Mock()
        Warehouse warehouse = new Warehouse(eventBus)

        when:
        warehouse.remove('talisker', 50)

        then:
        1 * eventBus./post(Sync|Async)/(_, {
            def root = new XmlSlurper().parseText(it)
            root.data.@name == 'talisker' && root.data.@quantity == 50
        })
    }
}
