import spock.lang.Specification

class BasicTest extends Specification {

    def "test basic math"() {
        when:
        def a = 2
        then:
        a**a == 4
    }

    def "test list API"() {
        given:
        def a = []
        when:
        a << 'hello'
        then:
        a.contains 'hello'
    }

    def "test more math"() {
        expect:
        a+a == b

        where:
        a = 2
        b = 4
    }

    def "test a lot more math"() {
        expect:
        a == b

        where:
        a      | b
        1 + 1  | 2
        2 + 2  | 4
        5 + 10 | 15
    }

}
