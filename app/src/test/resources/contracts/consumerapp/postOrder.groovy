package contracts.consumerapp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When get beer menu, expect 200")
    request {
        method 'POST'
        url '/beer'
        body ([
                orderItems: [
                        [
                            beer: [
                                    brand: value(consumer(anyNonBlankString()), producer("Leffe")),
                                    type: value(consumer(anyOf("TRIPLE", "DUBBEL", "PILS", "BLOND", "ALC_VRIJ")), producer("TRIPLE")),
                                    percentage: value(consumer(regex("[0-9]+(\\.[0-9]+)?")), producer( 8.5))
                            ],
                            quantity: value(consumer(regex("[0-9]+")), producer(3))
                        ],
                        [
                            beer: [
                                    brand: value(consumer(anyNonBlankString()), producer("Karmeliet")),
                                    type: value(consumer(anyOf("TRIPLE", "DUBBEL", "PILS", "BLOND", "ALC_VRIJ")), producer("TRIPLE")),
                                    percentage: value(consumer(regex("[0-9]+(\\.[0-9]+)?")), producer( 8.4))
                            ],
                            quantity: value(consumer(regex("[0-9]+")), producer(3))
                        ]

                ]

        ])
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
