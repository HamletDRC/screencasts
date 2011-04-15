package examples;

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author Hamlet D'Arcy
 */
class MyBasicTest extends Specification {


    @Unroll
    def "test some math"() {
        expect:
        a * a == b

        where:
        a  | b
        2  | 4
        4  | 16
        10 | 100
    }
}