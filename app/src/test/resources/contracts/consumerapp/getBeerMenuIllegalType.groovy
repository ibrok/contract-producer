package contracts.consumerapp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When get beer menu with illegal type, expect 400")
    request {
        method 'GET'
        url '/beer/UNSUPPORTED'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 400
    }
}
