import com.varabyte.kobweb.api.Apis
import com.varabyte.kobweb.api.ApisFactory
import com.varabyte.kobweb.api.InitApiContext
import com.varabyte.kobweb.api.data.MutableData
import com.varabyte.kobweb.api.log.Logger

class ApisFactoryImpl : ApisFactory {
    override fun create(logger: Logger): Apis {
        val data = MutableData()
        val apis = Apis(data, logger)
        apis.register("/hello") { ctx -> com.adwi.site.api.hello(ctx) }

        
        
        return apis
    }
}