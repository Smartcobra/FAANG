//package org.asiczen;
//
//public class EagerInitialization {
//    private static final EagerInitialization  instance = new EagerInitialization();
//
//
//
//    public static EagerInitialization getInstance() {
//        return instance;
//    }
//}
//
//CAP-
//
///// reALTIME PAYMENT -
//----//LEAD ARchitect
//        //bank process 50 milion transaction per day accross different chahel retail corporate and inter bank
//        // and the payment across 40 countireis and multiple currencies
//        // different country have differen regulations
//        //  monolith - 500 transaction per second , lower scale - such vast of processing
//
////  Expection  new businees demands 10,000 transaction per second
//    // with subsecond acknowledgement , t+0 settlement and 24/7 availability
//    // 1. microservices architecture - decouple the monolith into microservices and deploy
//        // accept payments  mobile , website thirdparty sources
//        //  frud detection before the settelment
//       // duplicate transaction detection - should not be more than one strict req--------
//       // audit trail - //immutable
//       //  avalability -99.999% uptime
//       //  distributed with multi region presence
//
////---
////
//--//DB --Pstgressql -  relational database - strong consistency and complex queries
////  - NoSQL - MongoDB - flexible schema and high scalability for unstructured data
////  - In-memory database - Redis - for caching and real-time data access
//
//// Service layers--
////  - API Gateway -  single entry point for all client requests, routing to appropriate microservices
////  - Payment Service -  handle payment processing, validation, and communication with external payment gateways
//    - Frud detection --- for frud detection - machine learning model to analyze transaction patterns and flag suspicious activities
//    - adit trail - immutable log of all transactions and activities for compliance and auditing purposes
//    - Notification Service - send real-time notifications to users about transaction status and updates
//    - Settlement Service - handle the settlement process with banks and financial institutions
//    -- service registry and discovery -  for dynamic service discovery and load balancing // if not in K*S , if there we can use K*S service discovery
//
////high yeild bond ---  heigh yeild --- bond
//
//
//
//
//
