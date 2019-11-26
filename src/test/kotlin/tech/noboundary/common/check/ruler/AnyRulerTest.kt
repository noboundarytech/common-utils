package tech.noboundary.common.check.ruler

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import tech.noboundary.common.check.CheckException
import tech.noboundary.common.check.doCheck
import tech.noboundary.common.check.must
import tech.noboundary.common.check.ruler.support.AnyRuler.beNull
import tech.noboundary.common.check.ruler.support.AnyRuler.notNull

class AnyRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    @Test
    fun nullValTest() {
        var any: Any? = null
        any must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-10001, desc=any必须为Null")
        any = Any()
        doCheck(any, "any", beNull)
    }

    @Test
    fun notNullTest() {
        var any: Any? = Any()
        any must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-10000, desc=any不能为Null")
        any = null
        doCheck(any, "any", notNull)
    }

}