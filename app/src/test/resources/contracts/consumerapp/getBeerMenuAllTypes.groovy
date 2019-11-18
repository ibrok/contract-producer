package contracts.consumerapp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When get beer menu, expect 200")
    request {
        method 'GET'
        url $(anyOf('/beer/TRIPLE', '/beer/DUBBEL', '/beer/PILS', '/beer/ALC_VRIJ', '/beer/BLOND'))
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(file('getBeerMenuResponse_TYPES.json'))
        bodyMatchers {
            jsonPath('$.beerList[*].brand', byRegex(nonEmpty()))
            jsonPath('$.beerList[*].type', byCommand('isBeerType($it, "{{{ request.path.[1] }}}")'))
            jsonPath('$.beerList[*].percentage', byRegex("[0-9]+(\\.[0-9]+)?")) //positive BigDecimal
        }
        headers {
            contentType(applicationJson())
        }
    }
}
