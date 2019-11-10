package contracts.consumerapp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When get beer menu, expect 200")
    request {
        method 'GET'
        url '/beer/TRIPLE'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(file('getBeerMenuResponse_TRIPLE.json'))
        bodyMatchers {
            jsonPath('$.beerList[*].brand', byRegex(nonEmpty()))
            jsonPath('$.beerList[*].type', byCommand('isBeerType($it, "TRIPLE")'))
            jsonPath('$.beerList[*].percentage', byRegex("[0-9]+(\\.[0-9]+)?")) //positive BigDecimal
        }
        headers {
            contentType(applicationJson())
        }
    }
}
