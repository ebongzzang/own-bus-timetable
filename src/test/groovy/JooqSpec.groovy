import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import spock.lang.Specification
import static org.jooq.impl.DSL.*


class JooqSpec extends Specification {

    def "sql _query_builder_test"() {
        DSLContext create = DSL.using( SQLDialect.MYSQL_8_0)
        create.select(
                field("advertisement.id"),
                field("stats.total_impression") / (1000),
                timestampDiff(day)

        )
    }
}