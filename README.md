# Introduction
This simple Springboot JMS request/reply service:

* Listens for messages on a configurable topic
* Prepends `Hello` to the request message
* Replies back to the producer with the newly formed string

:bulb: The application is preconfigured for use with the Solace PubSub+ Event Broker, and this blog post.

## Usage

`mvn clean spring-boot:run`
