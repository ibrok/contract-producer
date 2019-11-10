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
        body(file('getBeerMenuResponse.json'))
        bodyMatchers {
            jsonPath('$.beerList[*].brand', byRegex(nonEmpty()))
            jsonPath('$.beerList[*].type', byCommand('isBeerType($it)'))
            jsonPath('$.beerList[*].percentage', byRegex("[0-9]+(\\.[0-9]+)?")) //positive BigDecimal
        }
        headers {
            contentType(applicationJson())
        }
    }
}
