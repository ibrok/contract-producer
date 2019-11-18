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
                                    brand: "Leffe",
                                    type: "TRIPLE",
                                    percentage: 8.5
                            ],
                            quantity: 3
                        ],
                        [
                            beer: [
                                    brand: "Karmeliet",
                                    type: "TRIPLE",
                                    percentage: 8.4
                            ],
                            quantity: 2
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
