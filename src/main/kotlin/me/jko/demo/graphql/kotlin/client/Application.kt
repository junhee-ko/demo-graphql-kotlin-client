package me.jko.demo.graphql.kotlin.client

import com.expediagroup.graphql.client.spring.GraphQLWebClient
import kotlinx.coroutines.runBlocking
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main() {
    val client = GraphQLWebClient(url = "http://localhost:8080/graphql")

    runBlocking {
        val helloWorldQuery = HelloWorldQuery(
            HelloWorldQuery.Variables(
                nameStartWith = "J"
            )
        )

        val result = client.execute(helloWorldQuery)
        println("hello world query result: $result")
    }
}
