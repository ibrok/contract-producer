package contracts.consumerapp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When get beer menu, expect 200")
    request {
        method 'POST'
        url '/beer'
        body (file('postOrderRequest.json'))
        bodyMatchers {
            jsonPath('$.orderItems[*].beer.brand', byRegex(nonBlank()))
            jsonPath('$.orderItems[*].beer.type', byRegex("/^TRIPLE\$|^DUBBEL\$|^PILS\$|^BLOND\$|^ALC_VRIJ\$/]"))
            jsonPath('$.orderItems[*].beer.percentage', byRegex("[0-9]+(\\.[0-9]+)?"))
            jsonPath('$.orderItems[*].quantity', byRegex("[0-9]+"))
        }
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(anyNonBlankString())
        headers {
            contentType(applicationJson())
        }
    }
}
