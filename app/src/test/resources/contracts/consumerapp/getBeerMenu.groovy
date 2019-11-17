package contracts.consumerapp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When get beer menu, expect 200")
    request {
        method 'GET'
        url '/beer'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
    }
}