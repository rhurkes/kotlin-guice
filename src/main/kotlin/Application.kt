// https://stackoverflow.com/questions/30802384/guice-inject-an-arraylist-of-strings
// https://www.javaer101.com/en/article/16082126.html

import com.google.inject.*
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.getInstance

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val injector = Guice.createInjector(listOf(MainModule()))
            injector.getInstance<Handler>().run()
        }
    }

    class MainModule : KotlinModule() {
        override fun configure() {
            @Provides
            fun getHandler(): Handler {
                return HandlerA("A")
            }
        }
    }
}

interface Handler {
    fun run()
}

class HandlerA @Inject constructor(private val name: String) : Handler {
    override fun run() {
        println("I'm ${name}!")
    }
}
