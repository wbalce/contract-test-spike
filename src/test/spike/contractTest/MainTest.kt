package spike.contractTest

import org.apache.http.client.fluent.Request
import org.apache.http.entity.ContentType

import au.com.dius.pact.consumer.MockServer
import au.com.dius.pact.consumer.dsl.PactDslJsonBody
import org.assertj.core.api.KotlinAssertions.assertThat
import au.com.dius.pact.consumer.dsl.PactDslWithProvider
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt
import au.com.dius.pact.consumer.junit5.PactTestFor
import au.com.dius.pact.core.model.RequestResponsePact
import au.com.dius.pact.core.model.annotations.Pact
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(PactConsumerTestExt::class)
class MainTest {
    @Pact(consumer = "FrontendApplication", provider = "ProductService")
    fun getAllProducts(builder: PactDslWithProvider): RequestResponsePact {
        return builder.given("products exists")
            .uponReceiving("get all products")
            .method("GET")
            .path("/products")
            .willRespondWith()
            .status(200)
            .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "getAllProducts")
    fun getAllProducts_whenProductsExist(mockServer: MockServer) {
        val test = mockServer.getUrl() 
        val respBody = Request.Get(test + "/products")
                // .bodyString("{}", ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();
        assertTrue(true)
    }
}
